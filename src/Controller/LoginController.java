package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.DAO.*;
import src.View.*;

public class LoginController implements ActionListener {
    private LoginPanel lp;
    private static LoginPanel view = new LoginPanel();
    private static LoginController instance = new LoginController(view);

    public LoginController() {
    }

    public LoginController(LoginPanel lp) {
        lp.getLoginButton().addActionListener(this);
        this.lp = lp;
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
        lp.setVisible(false);
        MainFrame.getInstance().add(MenuController.getInstance().getView());
    }
    
}