package com.lastsurvivor.gui;

import javax.swing.*;
import java.awt.*;

public class InfectedPlayer {
    private Image image;
    public Game game;
    private int x;
    private int y;
    private int velocityX = 1;
    private int velocityY;

    public InfectedPlayer(int x, int y) {
        this.image = new ImageIcon("Resources/InfectedPlayer2.png").getImage();
        this.x = x;
        this.y = y;
    }

    public void updateInfectedPosition() {
        y += velocityY;
        x += velocityX;

        if (x < 0 || x > 920) {
            velocityX = -velocityX;
        }
        if (y < 0 || y > 891) {
            velocityY = -velocityY;
        }
    }

    public void paint(Graphics2D g2) {
        g2.drawImage(image, x, y, null);
        move();
    }

    public void move() {
        if (x + velocityX > 0 && x + velocityX < 1000 - 40)
            x = x + velocityX;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 80, 109);
    }
}