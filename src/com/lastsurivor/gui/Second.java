package com.lastsurivor.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Second extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer(5, this);
    double x = 0;
    double y = 0;
    double velX = 0;
    double velY = 0;
    double r = 4;
    double s = 3;

    public Second() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ImageIcon img = new ImageIcon("Resources/Background.png");
        img.paintIcon(this, g, 0, 0);
        Ellipse2D circle = new Hero.Double(x, y, 40, 40);
        g2.fill(circle);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x > 960) {
            velX = -velX;
        }
        if (y < 0 || y > 840) {
            velY = -velY;
        }
        x += velX;
        y += velY;
        repaint();
    }

    public void up() {
        velY = -1.5;
        velX = 0;
    }

    public void down() {
        velY = 1.5;
        velX = 0;
    }

    public void left() {
        velX = -1.5;
        velY = 0;
    }

    public void right() {
        velX = 1.5;
        velY = 0;
    }

    public void upStop() {
        velY = 0;
        velX = 0;
    }

    public void downStop() {
        velY = 0;
        velX = 0;
    }

    public void leftStop() {
        velX = 0;
        velY = 0;
    }

    public void rightStop() {
        velX = 0;
        velX = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            up();
        }
        if (code == KeyEvent.VK_DOWN) {
            down();
        }
        if (code == KeyEvent.VK_LEFT) {
            left();
        }
        if (code == KeyEvent.VK_RIGHT) {
            right();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upStop();
        }
        if (code == KeyEvent.VK_DOWN) {
            downStop();
        }
        if (code == KeyEvent.VK_LEFT) {
            leftStop();
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightStop();
        }


    }
}
