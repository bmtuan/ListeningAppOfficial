package src.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.io.IOException;

public class MenuPanel extends View {
    private JLabel title;
    private JButton exitButton;
    private JButton helpButton;
    private JButton historyButton;
    private JButton startButton;

    public MenuPanel() {
            title = new JLabel();
            startButton = new JButton();
            helpButton = new JButton();
            exitButton = new JButton();
            historyButton = new JButton();
            // title.setIcon(new javax.swing.ImageIcon("Image\\Ok.png"));
            // title.setFont(new java.awt.Font("Arial", 0, 36));
            // title.setHorizontalAlignment(SwingConstants.CENTER);
            // title.setText("Choose Level");
            startButton.setIcon(new javax.swing.ImageIcon("Image\\start.png"));
            helpButton.setIcon(new javax.swing.ImageIcon("Image\\hint.png"));
            historyButton.setIcon(new javax.swing.ImageIcon("Image\\history.png"));
            exitButton.setIcon(new javax.swing.ImageIcon("Image\\exit.png"));
            startButton.setActionCommand("0");
            startButton.requestFocus(true);
            helpButton.setActionCommand("2");
            historyButton.setActionCommand("1");
            exitButton.setActionCommand("3");
            startButton.setText("Start");
    
            startButton.setFont(new java.awt.Font("Arial", 0, 14));
    
            historyButton.setText("History");
    
            historyButton.setFont(new java.awt.Font("Arial", 0, 14));
            
            helpButton.setText("Help");
    
            helpButton.setFont(new java.awt.Font("Arial", 0, 14));
    
            exitButton.setText("Exit");
            exitButton.setFont(new java.awt.Font("Arial", 0, 14));
        // startButton = new JButton();
        // startButton.setIcon(new ImageIcon(img));
        // helpButton = new JButton();
        // exitButton = new JButton();
        // historyButton = new JButton();
        // startButton.setActionCommand("0");
        // startButton.requestFocus(true);
        // helpButton.setActionCommand("2");
        // historyButton.setActionCommand("1");
        // exitButton.setActionCommand("3");
        // startButton.setText("Start");

        // startButton.setFont(new java.awt.Font("Arial", 0, 14));

        // historyButton.setText("History");

        // historyButton.setFont(new java.awt.Font("Arial", 0, 14));
        
        // helpButton.setText("Help");

        // helpButton.setFont(new java.awt.Font("Arial", 0, 14));

        // exitButton.setText("Exit");
        // exitButton.setFont(new java.awt.Font("Arial", 0, 14));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        // .addComponent(title, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(helpButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historyButton, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                // .addComponent(title, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                // .addGap(20, 20, 20)
                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }

    public JButton getExitButton() {
        return exitButton;
    }
    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JButton getHelpButton() {
        return helpButton;
    }
    public void setHelpButton(JButton helpButton) {
        this.helpButton = helpButton;
    }

    public JButton getHistoryButton() {
        return historyButton;
    }
    public void setHistoryButton(JButton historyButton) {
        this.historyButton = historyButton;
    }

    public JButton getStartButton() {
        return startButton;
    }
    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }
}