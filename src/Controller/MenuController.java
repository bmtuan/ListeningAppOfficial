package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 import java.awt.Cursor;
 import java.awt.Color;
import javax.swing.JButton;

import src.Model.HistoryModel;
import src.View.*;

public class MenuController implements ActionListener, MouseListener {
    private MenuController() {
    }

    private MenuPanel mp;
    private static MenuPanel view = new MenuPanel();
    private static MenuController instance = new MenuController(view);

    private MenuController(MenuPanel v) {
        this.mp = v;
        v.getStartButton().addMouseListener(this);
        v.getStartButton().addActionListener(this);
        v.getHistoryButton().addMouseListener(this);
        v.getHistoryButton().addActionListener(this);
        v.getHelpButton().addMouseListener(this);
        v.getHelpButton().addActionListener(this);
        v.getExitButton().addMouseListener(this);
        v.getExitButton().addActionListener(this);
    }

    public static MenuController getInstance() {
        return instance;
    }

    public MenuPanel getView() {
        return this.mp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int action = Integer.parseInt(e.getActionCommand());
        switch (action) {
            case 0:
                LevelController lc = new LevelController(new LevelPanel());
                mp.getStartButton().setForeground(Color.black);
                MainFrame.refresh(lc.getLevelPanel());
                break;
            case 1:
                HistoryController hc = new HistoryController(new HistoryModel(), new HistoryPanel());
                mp.getHistoryButton().setForeground(Color.black);
                MainFrame.refresh(hc.getHistoryPanel());
                break;
            case 2:
                MainFrame.refresh(new HelpPanel());
                mp.getHelpButton().setForeground(Color.black);
                break;
            case 3:
                System.exit(0);
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
        // x.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }
}