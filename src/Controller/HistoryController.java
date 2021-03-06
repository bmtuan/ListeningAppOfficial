package src.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JLabel;

import src.Model.HistoryModel;
import src.View.*;

public class HistoryController implements MouseListener {
    HistoryModel historyModel;
    HistoryPanel historyPanel;

    public HistoryController(HistoryModel historyModel, HistoryPanel historyPanel) {
        historyPanel.getBackLabel().addMouseListener(this);
        this.historyModel = historyModel;
        this.historyPanel = historyPanel;
    }

    public HistoryPanel getHistoryPanel() {
        return historyPanel;
    }

    public HistoryModel getHistoryModel() {
        return historyModel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        historyPanel.setVisible(false);
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
        historyPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        historyPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}