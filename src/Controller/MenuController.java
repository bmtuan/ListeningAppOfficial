package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 import java.awt.Cursor;
 import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

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
        v.getStartLabel2().addMouseListener(this);
        v.getHelpLabel2().addMouseListener(this);
        v.getHistoryLabel2().addMouseListener(this);
        v.getExitLabel2().addMouseListener(this);
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
                MainFrame.refresh(lc.getLevelPanel());
                break;
            case 1:
                HistoryController hc = new HistoryController(new HistoryModel(), new HistoryPanel());
                MainFrame.refresh(hc.getHistoryPanel());
                break;
            case 2:
                MainFrame.refresh(new HelpPanel());
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel X = (JLabel) e.getSource();
        if (x v.getStartLabel2){

        }
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
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}