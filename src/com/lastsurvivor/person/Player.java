package com.lastsurvivor.person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

// TODO: player implements KeyListener (directly)

public class Player extends GameEntity {

    int vX = 0;
    int vY = 0;

    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        y += vY;
        x += vX;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(playerObject(), x, y, null);
    }

    public Image playerObject() {
        ImageIcon img = new ImageIcon("Resources/Player.png");
        return img.getImage();
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            vY = -2;
        } else if (code == KeyEvent.VK_DOWN) {
            vY = 2;
        } else if (code == KeyEvent.VK_LEFT) {
            vX = -2;
        } else if (code == KeyEvent.VK_RIGHT) {
            vX = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            vY = 0;
        } else if (code == KeyEvent.VK_DOWN) {
            vY = 0;
        } else if (code == KeyEvent.VK_LEFT) {
            vX = 0;
        } else if (code == KeyEvent.VK_RIGHT) {
            vX = 0;
        }
    }
}