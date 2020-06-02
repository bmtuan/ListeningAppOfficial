package src.Controller;

import src.DAO.UserDAO;
import src.Model.User;
import src.View.ForgetPasswordPanel;
import src.View.MainFrame;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

public class ForgetPasswordController implements ActionListener{
    private ForgetPasswordPanel fp;
    private static ForgetPasswordPanel view = new ForgetPasswordPanel();
    private static ForgetPasswordController instance = new ForgetPasswordController(view);

    public ForgetPasswordController() {
    }

    public ForgetPasswordController(ForgetPasswordPanel fp) {
        this.fp = fp;
        fp.getCheckButton().addActionListener(this);
    }

    public ForgetPasswordPanel getLp() {
        return fp;
    }

    public void setLp(ForgetPasswordPanel fp) {
        this.fp = fp;
    }

    public static ForgetPasswordPanel getView() {
        return view;
    }

    public static void setView(ForgetPasswordPanel view) {
        ForgetPasswordController.view = view;
    }

    public static ForgetPasswordController getInstance() {
        return instance;
    }

    public static void setInstance(ForgetPasswordController instance) {
        ForgetPasswordController.instance = instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = fp.getTaikhoanTextField().getText();
        try {
            User u = UserDAO.getUser(userName);
            if (u != null)
                JOptionPane.showMessageDialog(fp, "Mat khau: " + u.getPassword());
            else 
                JOptionPane.showMessageDialog(fp, "Tai khoan khong hop le!");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
      
        
    }

    // @Override
    // public void mouseClicked(MouseEvent e) {
    //     // TODO Auto-generated method stub

    // }

    // @Override
    // public void mousePressed(MouseEvent e) {
    //     MainFrame.refresh(LoginController.getView());

    // }

    // @Override
    // public void mouseReleased(MouseEvent e) {
    //     // TODO Auto-generated method stub

    // }

    // @Override
    // public void mouseEntered(MouseEvent e) {
    //     JLabel l = (JLabel) e.getSource();
    //     l.setForeground(Color.blue);
    //     fp.setCursor(new Cursor(Cursor.HAND_CURSOR));
    // }

    // @Override
    // public void mouseExited(MouseEvent e) {
    //     JLabel l = (JLabel) e.getSource();
    //     l.setForeground(Color.black);
    //     fp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    // }
}