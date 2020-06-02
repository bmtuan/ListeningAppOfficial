package src.Controller;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.*;
import src.DAO.*;
import src.Model.User;
import src.View.*;

public class LoginController implements ActionListener, MouseListener {
    private LoginPanel lp;
    private static LoginPanel view = new LoginPanel();
    private static LoginController instance = new LoginController(view);

    public LoginController() {
    }

    public LoginController(LoginPanel lp) {
        this.lp = lp;
        lp.getLoginButton().addActionListener(this);
        lp.getGuestLabel().addMouseListener(this);
        lp.getForgetLabel().addMouseListener(this);
        lp.getSignUpButton().addActionListener(this);

    }

    public LoginPanel getLp() {
        return lp;
    }

    public void setLp(LoginPanel lp) {
        this.lp = lp;
    }

    public static LoginPanel getView() {
        return view;
    }

    public static void setView(LoginPanel view) {
        LoginController.view = view;
    }

    public static LoginController getInstance() {
        return instance;
    }

    public static void setInstance(LoginController instance) {
        LoginController.instance = instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // lp.setVisible(false);
        // MainFrame.getInstance().add(MenuController.getInstance().getView());
        if (e.getSource() == lp.getLoginButton()) {
            String userName = lp.getTaikhoanTextField().getText();
            char[] passwordChars = lp.getLoginPasswordField().getPassword();
            String password = "";
            for (char p : passwordChars)
                password += p;
            if (!userName.equals("")) {
                try {
                    User u = UserDAO.getUser(userName);
                    if (u != null && !(password.equals("")) && u.getPassword().equals(password))
                        MainFrame.refresh(MenuController.getInstance().getView());
                    else
                        JOptionPane.showMessageDialog(lp, "Tai khoan hoac mat khau khong hop le!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
            else
                JOptionPane.showMessageDialog(lp, "Tai khoan hoac mat khau khong hop le!");

        } else if (e.getSource() == lp.getSignUpButton()) {
            String name = lp.getNameTextField().getText();
            String userName = lp.getSignUpUserTextField().getText();
            String password = "";
            char[] passwordChars = lp.getSignUpPasswordField().getPassword();
            for (char p : passwordChars)
                password += p;
            char[] confirmPasswordChars = lp.getConfirmPasswordField().getPassword();
            String confirmPassword = "";
            for (char c : confirmPasswordChars)
                confirmPassword += c;
            String day = lp.getDayComboBox().getSelectedItem().toString();
            String month = lp.getMonthComboBox().getSelectedItem().toString();
            String year = lp.getYearComboBox().getSelectedItem().toString();
            String gender = "";
            if (lp.getMaleRadioButton().isSelected())
                gender = "Nam";
            else
                gender = "Nữ";
            User u = new User(name, userName, password, day + "/" + month + "/" + year, gender);
            // if (u.isValid() && confirmPassword.equals(password))
            //     JOptionPane.showMessageDialog(lp, "Dang ky thanh cong!", null, 1);
            // else if (!confirmPassword.equals(password))
            //     JOptionPane.showMessageDialog(lp, "Mat khau xac nhan khong hop le!", null, 1);
            // else 
            //     JOptionPane.showMessageDialog(lp, "Vui long dien day du thong tin", null, 1);

            try {
                if (u.isValid() && confirmPassword.equals(password) && UserDAO.getUser(u.getUserID()) == null) {
                    try {
                        UserDAO.addUser(u);
                        JOptionPane.showMessageDialog(lp, "Dang ky thanh cong!", null, 1);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                } 
                else if (u != null)
                    JOptionPane.showMessageDialog(lp, "Ten dang nhap da ton tai!", null, 1);
                else if (!u.isValid())
                    JOptionPane.showMessageDialog(lp, "Vui long dien day du thong tin dang ky!", null, 1);
                else 
                    JOptionPane.showMessageDialog(lp, "Xac nhan mat khau khong chinh xac!", null, 1);
            } catch (HeadlessException | SQLException e1) {
                e1.printStackTrace();
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel source = (JLabel) e.getSource();
        source.setForeground(Color.black);
        lp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        if (source == lp.getGuestLabel())
            MainFrame.refresh(MenuController.getInstance().getView());
        else if (source == lp.getForgetLabel()){
            JFrame frame = new JFrame();
            ForgetPasswordPanel fp = new ForgetPasswordPanel();
            ForgetPasswordController fc = new ForgetPasswordController(fp);
            frame.getContentPane().add(fp);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        source.setForeground(Color.blue);
        lp.setCursor(new Cursor(Cursor.HAND_CURSOR));


    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        source.setForeground(Color.black);
        lp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));


    }
    
}