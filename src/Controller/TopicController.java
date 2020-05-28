package src.Controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.*;
import java.sql.SQLException;
import java.awt.*;
import java.time.*;
import javax.swing.JLabel;

import src.View.*;
import src.Model.*;
import src.DAO.ExerciseDAO;

public class TopicController implements ActionListener, MouseListener {
    private LevelModel levelModel;
    private TopicPanel topicPanel;

    public LevelModel getLevelModel() {
        return levelModel;
    }

    public TopicPanel getTopicPanel() {
        return topicPanel;
    }

    public TopicController(LevelModel levelModel, TopicPanel topicPanel) {
        topicPanel.getBackButton().addActionListener(this);
        topicPanel.getHomeButton().addActionListener(this);
        this.levelModel = levelModel;
        this.topicPanel = topicPanel;
        for (int i = 0; i < topicPanel.getLessonLabel().length; i++) {
            topicPanel.getLessonLabel()[i].addMouseListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() =="Back"){
        topicPanel.setVisible(false);
        LevelController lc = new LevelController(new LevelPanel());
        MainFrame.refresh(lc.getLevelPanel());
        }
        else{
            topicPanel.setVisible(false);
            MainFrame.getInstance().add(MenuController.getInstance().getView());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        String title = x.getText();
        int level = levelModel.getLevel();
        Exercise ex;
        try {
            ex = ExerciseDAO.getExerciseByTitle(title, level);
            // ex = ExerciseDAO.getExerciseByTitle("Go to bed early is better for us", 1);
            ExerciseModel em = new ExerciseModel(ex);
            em.setStartTime(LocalDateTime.now());
            LessonPanel lp = new LessonPanel();
            int trackLen = em.getCurrentExercise().getListTrack().get(em.getCurrentTrack()).getTime();
            if (trackLen > 9)
                lp.getTrackLen().setText("00:" + Integer.toString(trackLen));
            else 
                lp.getTrackLen().setText("00:0" + Integer.toString(trackLen));
            try {
                LessonController lc = new LessonController(em, lp, this);
                MainFrame.refresh(lp);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }      
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.green.brighter());
        topicPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        topicPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }  
    // public static void main(String[] args) {
    //     LevelModel lm = new LevelModel(1);
    //     for (Track x : lm.getAllExerciseByLevel(1).get(1).getTrackList()){
    //         System.out.println(x.toString());
    //     }
    //     System.out.println("True");
    //}
}