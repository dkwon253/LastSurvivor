package com.anthony;

import com.lastsurvivor.gui.Finish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener, KeyListener {
    private final Hero hero;
    private final Infected enemy;
    private final Finish finish;

    public Board() {
        //Get Infected
        enemy = new Infected();
        //Get Hero
        hero = new Hero("Resources/Player.png");
        finish = new Finish();
        Timer t = new Timer(5, this);
        t.start();
        //Board hold the keys and tells player and infected to move.
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        finish.paint(g2);
        hero.paint(g2);
        enemy.paint(g2);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
        if(finish.getRectangle().intersects(hero.getRectangle())){
            hero.setX(300);
            hero.setY(300);
        }
        if (hero.getX() < 0 || hero.getX() > 860) {
            hero.setvX(-(hero.getvX()));
        }
        if (hero.getY() < 0 || hero.getY() > 860) {
            hero.setvY(-(hero.getvY()));
        }
        hero.setX(hero.getX() + hero.getvX());
        hero.setY(hero.getY() + hero.getvY());
        repaint();
        hero.requestFocus();
    }

    public boolean checkBoundaries(){
return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
            keyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            hero.setvY(-1);
        }
        if (code == KeyEvent.VK_DOWN) {
            hero.setvY(1);
        }
        if (code == KeyEvent.VK_LEFT) {
            hero.setvX(-1);
        }
        if (code == KeyEvent.VK_RIGHT) {
            hero.setvX(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.setvY(0);
        hero.setvX(0);
    }
}