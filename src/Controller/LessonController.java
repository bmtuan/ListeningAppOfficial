package src.Controller;

import src.View.LessonPanel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import src.Model.*;

import javax.swing.text.StyledDocument;
import org.jfree.data.xy.XYDataset;
import src.Controller.TopicController;
import src.DAO.HistoryDAO;
import src.DAO.JDBCConnection;
import src.View.*;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.MutableComboBoxModel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LessonController extends DocumentFilter
        implements ActionListener, LineListener, KeyListener, DocumentListener {
    private TopicController topicController;
    private ExerciseModel exerciseModel;
    private LessonPanel lessonPanel;

    public LessonController(ExerciseModel exerciseModel, LessonPanel lessonPanel, TopicController topicController)
            throws IOException {
        this.exerciseModel = exerciseModel;
        this.lessonPanel = lessonPanel;
        this.topicController = topicController;
        lessonPanel.getText().addKeyListener(this);
        exerciseModel.setTimer(new Timer(1000, this));
        exerciseModel.getTimer().setInitialDelay(0);
        exerciseModel.getClip().addLineListener(this);
        lessonPanel.getbPlay().addActionListener(this);
        lessonPanel.getbPlay().requestFocus();
        lessonPanel.getbNext().addActionListener(this);
        lessonPanel.getbListen().addActionListener(this);
        lessonPanel.getbBack().addActionListener(this);
        initTrackBox();
        lessonPanel.getTrackBox().addActionListener(this);

        exerciseModel.getTrackDatasets().add(lessonPanel.getDataset());
        exerciseModel.setTextDocument((AbstractDocument) this.lessonPanel.getText().getDocument());
        exerciseModel.getTextDocument().setDocumentFilter(this);
        lessonPanel.getAns().getStyledDocument().addDocumentListener(this);
        ExerciseModel.loadDict();
    }

    private void initTrackBox() {
        int numOfTracks = exerciseModel.getCurrentExercise().getListTrack().size();
        String[] trackList = new String[numOfTracks];
        for (int i = 0; i < numOfTracks; ++i)
            trackList[i] = "Track " + Integer.toString(i + 1);
        lessonPanel.setTrackBox(new JComboBox(trackList));

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        lessonPanel.getTrackBox().setRenderer(renderer);
        lessonPanel.getBoxContainer().add(Box.createHorizontalStrut(250));
        lessonPanel.getBoxContainer().add(lessonPanel.getTrackBox());
        lessonPanel.getBoxContainer().add(Box.createHorizontalStrut(350));
        lessonPanel.getTrackBox().setVisible(false);

    }

    public void fillProgressBar() {
        int currentProgress = exerciseModel.getCurrentProgress();
        exerciseModel.setCurrentProgress(currentProgress + exerciseModel.getPercentPerSec());
        lessonPanel.getProgressBar().setValue(exerciseModel.getCurrentProgress());
    }

    private void addTrackDataset(int currentAttempt, int[] points) {
        XYSeriesCollection dataset = lessonPanel.createDataset(currentAttempt, points);
        exerciseModel.getTrackDatasets().add(dataset);
    }

    private void generateChart(int currentTrack, int currentAttempt, int[] points) {
        exerciseModel.getTrackDatasets().get(currentTrack).removeSeries(0);
        XYSeries series = new XYSeries("Current Attempt");
        for (int i = 0; i < currentAttempt; ++i) {
            series.add(i + 1, points[i]);
        }
        exerciseModel.getTrackDatasets().get(currentTrack).addSeries(series);
        lessonPanel.getChart().getXYPlot().setDataset(exerciseModel.getTrackDatasets().get(currentTrack));
    }

    private void showTrackChart(int currentTrack) {
        lessonPanel.getChart().getXYPlot().setDataset(exerciseModel.getTrackDatasets().get(currentTrack));
        lessonPanel.getChart().setTitle("Track " + Integer.toString(currentTrack + 1));
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
        int currentWordPos = exerciseModel.getCurrentWordPos();
        int currentCharPos = exerciseModel.getCurrentCharPos();
        String[] words = exerciseModel.getWords();
        String[] standardizeWords = exerciseModel.getStandardizedWords();
        StyledDocument ansDocument = lessonPanel.getAns().getStyledDocument();
        // check if current char typed in match current char in transcript
        if ((fb.getDocument().getText(0, fb.getDocument().getLength()) + str)
                .equalsIgnoreCase(standardizeWords[currentWordPos].substring(0, currentCharPos + 1))) {
            super.insertString(fb, offs, str, a);
            lessonPanel.getHint().setText("");
            exerciseModel.setCurrentCharPos(++currentCharPos);
            if (exerciseModel.getCurrentExercise().getLevel() == 1) {
                if (!exerciseModel.getDict().contains(standardizeWords[currentWordPos].toLowerCase())) {
                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord, Color.gray.brighter());
                    if (!exerciseModel.getIsInserted()[currentWordPos]) {
                        exerciseModel.getIsInserted()[currentWordPos] = true;
                        ansDocument.insertString(ansDocument.getLength(), words[currentWordPos] + " ", keyWord);
                    }
                }
            }
            // hit the end of a word
            if (currentCharPos == standardizeWords[currentWordPos].length()) {
                // check if that is the last word in the transcript
                if (currentWordPos != standardizeWords.length) {
                    remove(fb, 0, fb.getDocument().getLength());
                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord, Color.green.brighter());
                    ansDocument.setCharacterAttributes(0, lessonPanel.getAns().getDocument().getLength(), keyWord,
                            true);
                    if (exerciseModel.getCurrentExercise().getLevel() == 1) {
                        if (exerciseModel.getDict().contains(standardizeWords[currentWordPos].toLowerCase()))
                            ansDocument.insertString(ansDocument.getLength(), words[currentWordPos] + " ", keyWord);
                    } else
                        ansDocument.insertString(ansDocument.getLength(), words[currentWordPos] + " ", keyWord);
                    exerciseModel.setCurrentWordPos(++currentWordPos);
                    exerciseModel.setCurrentCharPos(0);

                }
            }
        } else {
            if (!str.equals(" ")) {
                lessonPanel.getHint().setText("Incorrect!");
                lessonPanel.getHint().setForeground(Color.red.brighter());
            }

        }
    }

    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
        int currentWordPos = exerciseModel.getCurrentWordPos();
        int currentCharPos = exerciseModel.getCurrentCharPos();
        String[] words = exerciseModel.getWords();
        String[] standardizeWords = exerciseModel.getStandardizedWords();
        StyledDocument ansDocument = lessonPanel.getAns().getStyledDocument();
        if ((fb.getDocument().getText(0, fb.getDocument().getLength()) + str)
                .equalsIgnoreCase(standardizeWords[currentWordPos].substring(0, currentCharPos + 1))) {
            super.replace(fb, offs, length, str, a);
            lessonPanel.getHint().setText("");
            exerciseModel.setCurrentCharPos(++currentCharPos);
            if (exerciseModel.getCurrentExercise().getLevel() == 1) {
                if (!exerciseModel.getDict().contains(standardizeWords[currentWordPos].toLowerCase())) {
                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord, Color.gray.brighter());
                    if (!exerciseModel.getIsInserted()[currentWordPos]) {
                        exerciseModel.getIsInserted()[currentWordPos] = true;
                        ansDocument.insertString(ansDocument.getLength(), words[currentWordPos] + " ", keyWord);
                    }
                }
            }
            // hit the end of a word

            if (currentCharPos == standardizeWords[currentWordPos].length()) {
                // check if that is the last word in the transcript
                if (currentWordPos != standardizeWords.length) {
                    remove(fb, 0, fb.getDocument().getLength());
                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord, Color.green.brighter());
                    ansDocument.setCharacterAttributes(0, lessonPanel.getAns().getDocument().getLength(), keyWord,
                            true);
                    if (exerciseModel.getCurrentExercise().getLevel() == 1) {
                        if (exerciseModel.getDict().contains(standardizeWords[currentWordPos].toLowerCase()))
                            ansDocument.insertString(ansDocument.getLength(), words[currentWordPos] + " ", keyWord);
                    } else
                        ansDocument.insertString(ansDocument.getLength(), words[currentWordPos] + " ", keyWord);
                    exerciseModel.setCurrentWordPos(++currentWordPos);
                    exerciseModel.setCurrentCharPos(0);

                }
            }
        } else {
            if (!str.equals(" ")) {
                lessonPanel.getHint().setText("Incorrect!");
                lessonPanel.getHint().setForeground(Color.red.brighter());
            }
        }

    }

    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        exerciseModel.setCurrentCharPos(exerciseModel.getCurrentCharPos() - 1);
        super.remove(fb, offset, length);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exerciseModel.getTimer()) {
            int currentSec = exerciseModel.getCurrentSec();
            fillProgressBar();
            if (currentSec > 9)
                lessonPanel.getCurrentTime().setText("00:" + Integer.toString(currentSec));
            else
                lessonPanel.getCurrentTime().setText("00:0" + Integer.toString(currentSec));
            exerciseModel.setCurrentSec(currentSec + 1);
        } else if (e.getSource() == lessonPanel.getbPlay()) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lessonPanel.getText().requestFocus(true);
                    if (!exerciseModel.checkIsPlaying()) {
                        if (exerciseModel.getCurrentAttempt() < ExerciseModel.getMaxNumOfAttempts()) {
                            lessonPanel.getbPlay().setIcon(new ImageIcon("Image/pause" + ".png", "pause button"));
                            exerciseModel.loadAudio();
                            if (exerciseModel.getCurrentWordPos() != exerciseModel.getWords().length) {
                                exerciseModel.setCurrentAttempt(exerciseModel.getCurrentAttempt() + 1);

                            }
                        } else {
                            lessonPanel.getText().setEditable(false);
                            lessonPanel.getText().requestFocus(false);
                            exerciseModel.setCurrentPoint(0);
                            String restOfTranscript = "";
                            for (int i = exerciseModel.getCurrentWordPos(); i < exerciseModel.getWords().length; ++i)
                                restOfTranscript += exerciseModel.getWords()[i] + " ";
                            if (exerciseModel.getCurrentWordPos() != exerciseModel.getWords().length) {
                                try {
                                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                                    StyleConstants.setForeground(keyWord, Color.red.brighter());
                                    StyledDocument ansStyledDocument = lessonPanel.getAns().getStyledDocument();
                                    ansStyledDocument.insertString(ansStyledDocument.getLength(), restOfTranscript,
                                            keyWord);
                                } catch (BadLocationException ex) {
                                    Logger.getLogger(LessonController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                exerciseModel.setCurrentWordPos(exerciseModel.getWords().length);
                            }
                            if (exerciseModel.getCurrentTrack() == exerciseModel.getCurrentExercise().getListTrack()
                                    .size() - 1) {
                                String message = "Score: "
                                        + Integer.toString(
                                                exerciseModel.getTotalPoint() / (exerciseModel.getCurrentTrack() + 1))
                                        + "/100" + "\n" + "Title: " + exerciseModel.getCurrentExercise().getTitle()
                                        + "\n" + "Level: " + exerciseModel.getCurrentExercise().getLevel();
                                JOptionPane.showMessageDialog(lessonPanel, message, "Result", 1, null);
                                lessonPanel.getbPlay().setEnabled(false);
                            }

                        }
                        exerciseModel.getPoints()[exerciseModel.getCurrentAttempt() - 1] = exerciseModel
                                .getCurrentPoint();
                        generateChart(exerciseModel.getCurrentTrack(), exerciseModel.getCurrentAttempt(),
                                exerciseModel.getPoints());

                    } else {
                        lessonPanel.getbPlay().setIcon(new ImageIcon("Image/play1" + ".png", "play button"));
                        exerciseModel.stopAudio();

                    }
                }
            });
        } else if (e.getSource() == lessonPanel.getbNext()) {
            try {
                if (exerciseModel.checkIsPlaying())
                    exerciseModel.stopAudio();
                exerciseModel.loadFile();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                ex.printStackTrace();
            }
            exerciseModel.getClip().addLineListener(this);
            exerciseModel.setCurrentAttempt(0);
            exerciseModel.setCurrentWordPos(0);
            exerciseModel.setCurrentCharPos(0);
            exerciseModel.getPoints()[exerciseModel.getCurrentAttempt()] = 0;
            exerciseModel.setCurrentPoint(0);
            addTrackDataset(exerciseModel.getCurrentAttempt(), exerciseModel.getPoints());
            generateChart(exerciseModel.getCurrentTrack(), exerciseModel.getCurrentAttempt(),
                    exerciseModel.getPoints());
            lessonPanel.getChart().setTitle("Track " + Integer.toString(exerciseModel.getCurrentTrack() + 1));
            lessonPanel.getText().setEditable(true);
            lessonPanel.getAns().setText("");
            lessonPanel.getbPlay().setEnabled(true);
            lessonPanel.getNextPanel().setVisible(false);
            if (exerciseModel.getTime() > 9)
                lessonPanel.getTrackLen().setText("00:" + Integer.toString(exerciseModel.getTime()));
            else
                lessonPanel.getTrackLen().setText("00:0" + Integer.toString(exerciseModel.getTime()));
        } else if (e.getSource() == lessonPanel.getbListen()) {
            if (exerciseModel.checkIsPlaying())
                return;
            exerciseModel.loadAudio();
        } else if (e.getSource() == lessonPanel.getbBack()) {
            exerciseModel.stopAudio();
            if (exerciseModel.getCurrentTrack() != exerciseModel.getCurrentExercise().getListTrack().size() - 1
                    || exerciseModel.getCurrentWordPos() != exerciseModel.getWords().length) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to leave? All your current work will be deleted", "Select an Option",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (input == 0)
                    MainFrame.refresh(topicController.getTopicPanel());

            } else
                MainFrame.refresh(topicController.getTopicPanel());

        } else {

            lessonPanel.getTrackBox().setVisible(true);
            JComboBox cb = (JComboBox) e.getSource();
            String trackName = (String) cb.getSelectedItem();
            int currentTrack = Integer.parseInt(trackName.substring(trackName.length() - 1, trackName.length()));
            System.out.println(Integer.toString(currentTrack));
            showTrackChart(currentTrack - 1);
            try {

                lessonPanel.getAns().getStyledDocument().remove(0,
                        lessonPanel.getAns().getStyledDocument().getLength());
                lessonPanel.getAns().getStyledDocument().insertString(0,
                        exerciseModel.getCurrentExercise().getListTrack().get(currentTrack - 1).getTranscript(),
                        new SimpleAttributeSet());
            } catch (BadLocationException ex) {
                Logger.getLogger(LessonController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            lessonPanel.getbPlay().setIcon(new ImageIcon("Image/play1" + ".png", "play button"));
            exerciseModel.setPlaying(false);
            lessonPanel.getProgressBar().setValue(0);
            exerciseModel.setCurrentProgress(0);
            exerciseModel.setCurrentSec(0);
            lessonPanel.getCurrentTime().setText("00:00");
            exerciseModel.getTimer().stop();

        } else if (event.getType() == LineEvent.Type.START) {

            exerciseModel.getTimer().start();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (lessonPanel.getbPlay().isEnabled()) {
                if (exerciseModel.getCurrentWordPos() != exerciseModel.getWords().length) {
                    if (exerciseModel.checkIsPlaying()) {
                        exerciseModel.stopAudio();
                        lessonPanel.getbPlay().setIcon(new ImageIcon("Image/play1" + ".png", "play button"));

                    } else {
                        if (exerciseModel.getCurrentAttempt() < ExerciseModel.getMaxNumOfAttempts()) {
                            lessonPanel.getbPlay().setIcon(new ImageIcon("Image/pause" + ".png", "pause button"));
                            exerciseModel.loadAudio();
                            exerciseModel.setCurrentAttempt(exerciseModel.getCurrentAttempt() + 1);

                        } else {
                            lessonPanel.getText().setEditable(false);
                            lessonPanel.getText().requestFocus(false);
                            exerciseModel.setCurrentPoint(0);
                            StyledDocument ansStyledDocument = lessonPanel.getAns().getStyledDocument();
                            String restOfTranscript = "";
                            for (int i = exerciseModel.getCurrentWordPos(); i < exerciseModel.getWords().length; ++i)
                                restOfTranscript += exerciseModel.getWords()[i] + " ";
                            if (exerciseModel.getCurrentWordPos() != exerciseModel.getWords().length) {
                                try {
                                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                                    StyleConstants.setForeground(keyWord, Color.red.brighter());
                                    ansStyledDocument.insertString(ansStyledDocument.getLength(), restOfTranscript,
                                            keyWord);
                                } catch (BadLocationException ex) {
                                    Logger.getLogger(LessonController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                exerciseModel.setCurrentWordPos(exerciseModel.getWords().length);
                            }
                            if (exerciseModel.getCurrentTrack() == exerciseModel.getCurrentExercise().getListTrack()
                                    .size() - 1) {
                                String message = "Score: "
                                        + Integer.toString(
                                                exerciseModel.getTotalPoint() / (exerciseModel.getCurrentTrack() + 1))
                                        + "/100" + "\n" + "Title: " + exerciseModel.getCurrentExercise().getTitle()
                                        + "\n" + "Level: " + exerciseModel.getCurrentExercise().getLevel();
                                JOptionPane.showMessageDialog(lessonPanel, message, "Result", 1, null);
                                lessonPanel.getbPlay().setEnabled(false);
                            }

                        }
                    }
                    exerciseModel.getPoints()[exerciseModel.getCurrentAttempt() - 1] = exerciseModel.getCurrentPoint();
                    generateChart(exerciseModel.getCurrentTrack(), exerciseModel.getCurrentAttempt(),
                            exerciseModel.getPoints());

                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (exerciseModel.getCurrentAttempt() != ExerciseModel.getMaxNumOfAttempts()) {
            exerciseModel.setCurrentPoint(exerciseModel.getCurrentPoint() + exerciseModel.getPointPerWord());
            exerciseModel.getPoints()[exerciseModel.getCurrentAttempt() - 1] = exerciseModel.getCurrentPoint();
            for (int i = 0; i < exerciseModel.getPoints().length; ++i)
                System.out.println(exerciseModel.getPoints()[i]);
            generateChart(exerciseModel.getCurrentTrack(), exerciseModel.getCurrentAttempt(),
                    exerciseModel.getPoints());
            if (exerciseModel.getCurrentWordPos() == exerciseModel.getStandardizedWords().length - 1) {
                // set point for last attempt to be 100
                exerciseModel.getPoints()[exerciseModel.getCurrentAttempt() - 1] = 100;
                generateChart(exerciseModel.getCurrentTrack(), exerciseModel.getCurrentAttempt(),
                        exerciseModel.getPoints());
                // add current track point to total point
                exerciseModel.setTotalPoint(
                        exerciseModel.getTotalPoint() + Integer.max(5 * (21 - exerciseModel.getCurrentAttempt()), 0));
                exerciseModel.stopAudio();
                lessonPanel.getText().setEditable(false);
                lessonPanel.getText().requestFocus(false);
                lessonPanel.getbPlay().setEnabled(false);
                // check for last track
                if (exerciseModel.getCurrentTrack() != exerciseModel.getCurrentExercise().getListTrack().size() - 1)
                    lessonPanel.getNextPanel().setVisible(true);
                else {
                    // hit the last track
                    // code for creating History
                    System.out.println("reached here");
                    createHistory();
                    // create result dialog
                    String message = "Score: "
                            + Integer.toString(exerciseModel.getTotalPoint() / (exerciseModel.getCurrentTrack() + 1))
                            + "/100" + "\n" + "Title: " + exerciseModel.getCurrentExercise().getTitle() + "\n"
                            + "Level: " + exerciseModel.getCurrentExercise().getLevel();
                    JOptionPane.showMessageDialog(lessonPanel, message, "Result", 1, null);
                    lessonPanel.getTrackBox().setVisible(true);
                    lessonPanel.getbPlay().setEnabled(false);

                }

            }
        } else if (exerciseModel.getCurrentTrack() != exerciseModel.getCurrentExercise().getListTrack().size() - 1)
            lessonPanel.getNextPanel().setVisible(true);
        else {
            lessonPanel.getTrackBox().setVisible(true);
            createHistory();

        }

    }

    private void createHistory() {
        History history = new History();
        history.setDate(exerciseModel.getStartTime());
        System.out.println(exerciseModel.getStartTime());
        history.setLevel(exerciseModel.getCurrentExercise().getLevel());
        history.setTopic(exerciseModel.getCurrentExercise().getTitle());
        history.setScore(exerciseModel.getTotalPoint());
        String sql = "SELECT exercise.HighScore FROM test.exercise WHERE exercise.Title = " + "\"" + history.getTopic()
                + "\"";
        String sql1 = "UPDATE exercise SET exercise.HighScore =" + history.getScore() +" WHERE exercise.Title = " + "\"" + history.getTopic()
        + "\"";
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement prepareStatement;
        Statement statement;
        try {
            prepareStatement = connection.prepareStatement(sql);
            statement = connection.createStatement();
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()){
                if (history.getScore() > rs.getInt("HighScore")){
                    statement.executeUpdate(sql1);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // System.out.println("Fuck'in wow shit");
        // System.out.println(history.getDate());
        HistoryDAO.addHistory(history);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {      
    }
    
    
    
}
