package com.anthony;

import javax.swing.*;
import java.awt.*;

public class Infected {
    private Image image;
    private int x;
    private int y;
    private int vX = 1;



    public Infected(){
        this.image = new ImageIcon("Resources/Player.png").getImage();
        this.x = 50;this.y = 50;
    }
    public void paint(Graphics2D g2){
        g2.drawImage(image,  x, y, null);
        move();
    }

    public void move(){
        if (x + vX > 0 && x + vX < 1000 - 40)
            x = x + vX;
    }


}
