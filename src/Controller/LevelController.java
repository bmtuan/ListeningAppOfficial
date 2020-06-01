package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.*;
import src.View.*;
import src.Model.LevelModel;

public class LevelController implements ActionListener, MouseListener {
    private LevelPanel levelPanel;

    public LevelPanel getLevelPanel() {
        return levelPanel;
    }

    public void setLevelPanel(LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
    }

    public LevelController(LevelPanel lp) {
        this.levelPanel = lp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int action = Integer.parseInt(e.getActionCommand());
        switch (action) {
            case 1:
                TopicController tc1 = new TopicController(new LevelModel(action), new TopicPanel(action));
                MainFrame.refresh(tc1.getTopicPanel());
                break;
            case 2:
                TopicController tc2 = new TopicController(new LevelModel(action), new TopicPanel(action));
                MainFrame.refresh(tc2.getTopicPanel());
                break;
            case 3:
                TopicController tc3 = new TopicController(new LevelModel(action), new TopicPanel(action));
                MainFrame.refresh(tc3.getTopicPanel());
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        JButton x = (JButton) e.getSource();
        x.setForeground(Color.red.brighter());
        x.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JButton x = (JButton) e.getSource();
        x.setForeground(Color.black);
    }
}