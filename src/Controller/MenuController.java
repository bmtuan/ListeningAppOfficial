package src.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 import java.awt.Cursor;
 import java.awt.Color;
import javax.swing.JLabel;

import src.Model.HistoryModel;
import src.View.*;

public class MenuController implements MouseListener {
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
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        String command = x.getText();
        if (command == ("Bắt đầu")){
            LevelController lc = new LevelController(new LevelPanel());
            MainFrame.refresh(lc.getLevelPanel());
        }
        else if (command == ("Lịch sử")){
            HistoryController hc = new HistoryController(new HistoryModel(), new HistoryPanel());
            MainFrame.refresh(hc.getHistoryPanel());
        }
        else if (command == "Hướng dẫn"){
            MainFrame.refresh(new HelpPanel());
        }
        else {
            LoginController lc = new LoginController(new LoginPanel());
            MainFrame.refresh(lc.getLp());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.BLUE);
        mp.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        mp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}