package src.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import src.Model.HistoryModel;
import src.View.*;

public class MenuController implements MouseListener {
    public MenuController() {}
    private MenuPanel mp;
    
    public MenuController(MenuPanel v) {
        this.mp = v;
        v.getStartLabel2().addMouseListener(this);
        v.getHelpLabel2().addMouseListener(this);
        v.getHistoryLabel2().addMouseListener(this);
        v.getExitLabel2().addMouseListener(this);
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
        x.setForeground(Color.black);
        mp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
<<<<<<< HEAD
            int input = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn thoát?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (input == 0)
                System.exit(0);
=======
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chứ?", "Xác nhận",JOptionPane.YES_NO_OPTION , JOptionPane.DEFAULT_OPTION, (new javax.swing.ImageIcon("Image\\why.png")));
            if (confirm == 0 ){
                System.exit(0);
            }
>>>>>>> e5b351c3552bab8d7c548df0fc0c68d20236e6ce
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

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