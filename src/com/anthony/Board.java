package com.anthony;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel implements ActionListener, KeyListener {
    private final Player player;
    private final InfectedPlayer enemy;
    private final Finish exitDoor;
    private ArrayList<InfectedPlayer> enemies = new ArrayList<>();
    private Random rand = new Random();
    private int enemyCount = 1;

    public Board() {
        exitDoor = new Finish();
        enemy = new InfectedPlayer(200, 200);
        player = new Player("Resources/PlayerYellow.png");

        spawnRandomEnemy();
        Timer t = new Timer(5, this);
        t.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

    }

    public void spawnRandomEnemy() {
        for (int i = 0; i < enemyCount; i++) {
            enemies.add(new InfectedPlayer(rand.nextInt(800), rand.nextInt(800)));
        }
    }

    public void resetPlayerLocation() {
        player.setX(0);
        player.setY(0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        ImageIcon img = new ImageIcon("Resources/Background2.png");
        Image background = img.getImage();
        g2.drawImage(background, 0, 0, null);

        for (InfectedPlayer spawnEnemy : enemies) {
            spawnEnemy.paint(g2);
        }

        exitDoor.paint(g2);
        levelUp();
        player.paint(g2);

        if (Collision()) {
            //System.exit(0);
            resetPlayerLocation();
        }
    }

    public void levelUp() {
        if (player.getBounds().intersects(exitDoor.getBounds())) {
            enemies.add(new InfectedPlayer(rand.nextInt(800), rand.nextInt(800)));
            resetPlayerLocation();
        }
    }

    public boolean Collision() {
        boolean collide = false;
        for (var e : enemies) {
            if (player.getBounds().intersects(e.getBounds())) {
                collide = true;
            }
        }
        return collide;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        for (InfectedPlayer a : enemies) {
            a.updateInfectedPosition();
        }
        player.updatePlayerPosition();
        player.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            player.setVelocityY(-2);
        }
        if (code == KeyEvent.VK_DOWN) {
            player.setVelocityY(2);
        }
        if (code == KeyEvent.VK_LEFT) {
            player.setVelocityX(-2);
        }
        if (code == KeyEvent.VK_RIGHT) {
            player.setVelocityX(2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.setVelocityY(0);
        player.setVelocityX(0);
    }
}