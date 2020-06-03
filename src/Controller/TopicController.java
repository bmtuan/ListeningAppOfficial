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

import javax.swing.JButton;
import javax.swing.JLabel;

import src.View.*;
import src.Model.*;
import src.DAO.ExerciseDAO;

public class TopicController implements  MouseListener {
    private LevelModel levelModel;
    private TopicPanel topicPanel;

    public LevelModel getLevelModel() {
        return levelModel;
    }

    public TopicPanel getTopicPanel() {
        return topicPanel;
    }

    public TopicController(LevelModel levelModel, TopicPanel topicPanel) {
        for (int i = 0; i < topicPanel.getTitle().length; i++) {
            topicPanel.getTitle()[i].addMouseListener(this);
        }
        topicPanel.getBackLabel().addMouseListener(this);
        this.levelModel = levelModel;
        this.topicPanel = topicPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        topicPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        String title = x.getText();
        int level = levelModel.getLevel();
        Exercise ex;
        if (x.getText()=="Trở về"){
<<<<<<< HEAD
            //topicPanel.setVisible(false);
=======
            topicPanel.setVisible(false);
>>>>>>> e5b351c3552bab8d7c548df0fc0c68d20236e6ce
            LevelController lc = new LevelController(new LevelPanel());
            MainFrame.refresh(lc.getLevelPanel());
        } else 
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
        // JButton y = (JButton) e.getSource();
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