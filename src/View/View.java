package src.View;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.*;

abstract public class View extends JPanel{
    public View(){
        setVisible(true);
    }
    public void paintComponent(Graphics g){
        Random r = new Random();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int red = 0, green = 0, blue = 0;
        int maxValueColor = r.nextInt(3);
        switch(maxValueColor){
            case 0: 
                red = 255;
                green = r.nextInt(255);
                blue = r.nextInt(255);
                break;
            case 1: 
                red = r.nextInt(255);
                blue = 255;
                green = r.nextInt(255);
                break;
            case 2: 
                red = r.nextInt(255);
                blue = r.nextInt(255);
                green = 255;
                break;
        }

        Color startColor = new Color(red, green, blue);
        maxValueColor = r.nextInt(3);
        switch(maxValueColor){
            case 0: 
                red = 255;
                green = r.nextInt(255);
                blue = r.nextInt(255);
                break;
            case 1: 
                red = r.nextInt(255);
                blue = 255;
                green = r.nextInt(255);
                break;
            case 2: 
                red = r.nextInt(255);
                blue = r.nextInt(255);
                green = 255;
                break;
        }
        Color endColor = new Color(red, green, blue);
        GradientPaint gradient = new GradientPaint(r.nextInt(getWidth()), r.nextInt(getHeight()), startColor, r.nextInt(getWidth()), r.nextInt(getHeight()), endColor);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

}