package src.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Color;
import src.Controller.*;
import src.View.*;

public class HelpController implements MouseListener {
    private HelpPanel helpPanel;

    public HelpPanel getHelpPanel() {
        return helpPanel;
    }

    public void setHelpPanel(HelpPanel helpPanel) {
        this.helpPanel = helpPanel;
    }

    public HelpController(HelpPanel helpPanel) {
        helpPanel.getBackLabel().addMouseListener(this);
        this.helpPanel = helpPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        helpPanel.setVisible(false);
        MenuController menuController = new MenuController(new MenuPanel());
        MainFrame.getInstance().add(menuController.getView());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.BLUE);
        helpPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        helpPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}