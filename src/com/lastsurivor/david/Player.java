package com.lastsurivor.david;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {

    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updatePosition() {
        y += velocityY;
        x += velocityX;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(playerObject(), x, y, null);
    }

    public Image playerObject() {
        ImageIcon img = new ImageIcon("Resources/PlayerBlack.png");
        return img.getImage();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            setVelocityY(-2);
        } else if (code == KeyEvent.VK_DOWN) {
            setVelocityY(2);
        } else if (code == KeyEvent.VK_LEFT) {
            setVelocityX(-2);
        } else if (code == KeyEvent.VK_RIGHT) {
            setVelocityX(2);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            velocityY = 0;
        } else if (code == KeyEvent.VK_DOWN) {
            velocityY = 0;
        } else if (code == KeyEvent.VK_LEFT) {
            velocityX = 0;
        } else if (code == KeyEvent.VK_RIGHT) {
            velocityX = 0;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocityX() {
        return velocityX;
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
}