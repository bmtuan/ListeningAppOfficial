package src.View;
import javax.swing.ImageIcon;

import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{
    private static MainFrame instance = new MainFrame();
    public MainFrame(){
        setTitle("Listening English Pro v1.1");
        setSize(850, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int input = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn thoát?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,new javax.swing.ImageIcon("Image\\why.png"));
                if (input == 0)
                    System.exit(0);
            }
        });
    }
    public static Container getInstance(){
        return instance.getContentPane();
    }
    public static void refresh(JPanel view){
        instance.getContentPane().removeAll();
        instance.getContentPane().add(view);
        instance.repaint();
        instance.revalidate();
        instance.setVisible(true);
    }
}