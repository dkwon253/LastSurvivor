package com.lastsurvivor.gui;

import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {
    private Image image;
    private int x;
    private int y;
    private int velocityX = 0;
    private int velocityY = 0;

    public Player(String filename) {
        this.image = new ImageIcon(filename).getImage();
    }

    public void updatePlayerPosition() {
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
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 55);
    }
}