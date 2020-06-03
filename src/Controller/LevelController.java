package src.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;
import src.View.*;
import src.Model.LevelModel;

public class LevelController implements MouseListener {
    private LevelPanel levelPanel;
    public LevelPanel getLevelPanel() {
        return levelPanel;
    }

    public void setLevelPanel(LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
    }

    public LevelController(LevelPanel lp) {
        lp.getLevel_1Label().addMouseListener(this);
        lp.getLevel_2Label().addMouseListener(this);
        lp.getLevel_3Label().addMouseListener(this);
        lp.getBackLabel().addMouseListener(this);
        this.levelPanel = lp;
    }
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        String command = x.getText();
        if (command == "Mức 1"){
            TopicController tc1 = new TopicController(new LevelModel(1), new TopicPanel(1));
            MainFrame.refresh(tc1.getTopicPanel());
        }
        else if (command == "Mức 2"){
            TopicController tc1 = new TopicController(new LevelModel(2), new TopicPanel(2));
            MainFrame.refresh(tc1.getTopicPanel());
        } else if (command == "Mức 3"){
            TopicController tc1 = new TopicController(new LevelModel(3), new TopicPanel(3));
            MainFrame.refresh(tc1.getTopicPanel());
        } else if (command == "Trở về"){
            MenuController menuController = new MenuController(new MenuPanel());
            MainFrame.refresh(menuController.getView());
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
        x.setForeground(Color.BLUE);
        levelPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        levelPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}