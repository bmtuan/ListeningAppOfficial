package src.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;


abstract public class View extends JPanel{
    protected BufferedImage background;
    public View(){
        try {
            background = ImageIO.read(new File("Image/night_star.jpg").getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }   
}