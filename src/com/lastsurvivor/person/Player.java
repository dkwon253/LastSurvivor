package com.lastsurvivor.person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// TODO: player implements KeyListener (directly)

public class Player extends JPanel implements KeyListener, ActionListener {

    Timer t = new Timer(5, this);
    int vX = 0;
    int vY = 0;
    int x;
    int y;

    public Player(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

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

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (x < 0 || x > 960) {
            vX = -vX;
        }
        if (y < 0 || y > 840) {
            vY = -vY;
        }
        x += vX;
        y += vY;
        repaint();
    }
}