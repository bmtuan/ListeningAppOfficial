package src.Controller;
import src.View.*;
public class MainController {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame.getInstance().setVisible(true);
                MainFrame.getInstance().add(MenuController.getInstance().getView());
            }
        });
    }
}