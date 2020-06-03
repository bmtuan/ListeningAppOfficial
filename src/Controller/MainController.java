package src.Controller;
import src.View.*;
public class MainController {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame.getInstance().setVisible(true);
<<<<<<< HEAD
                MenuController menuController = new MenuController(new MenuPanel());
                MainFrame.getInstance().add(menuController.getView());
=======
                MainFrame.getInstance().add(MenuController.getInstance().getView());
>>>>>>> e5b351c3552bab8d7c548df0fc0c68d20236e6ce
            }
        });
    }
}