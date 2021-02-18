package com.lastsurvivor.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * The Board class extends JPanel and implements ActionListener and KeyListener
 * This class is responsible for controlling the movements of the InfectedPlayer and
 * Player objects.
 */
public class Board extends JPanel implements ActionListener, KeyListener {


    private final Counter COUNT_LEVEL = new Counter();
    private final int DEFAULT_SCREEN_SIZE = 1000;
    private final int ENEMY_BOUNDS = 800;
    private final ExitDoor EXIT_DOOR;
    private final Game GAME;
    private final Player PLAYER;
    private final Random RAND = new Random();

    private int enemyCount = 1;
    private List<InfectedPlayer> enemies = new ArrayList<>();

    /**
     * Board needs to take in Game in order to use the Game classes nextMethod
     *
     */
    public Board(Game GAME) {
        this.GAME = GAME;
        EXIT_DOOR = new ExitDoor();
        PLAYER = new Player();
        generateInfectedPlayers();
        Timer t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
    }

    public void generateInfectedPlayers() {
        for (int i = 0; i < enemyCount; i++) {
            enemies.add(new InfectedPlayer(RAND.nextInt(800), RAND.nextInt(500)));
        }
    }

    public void resetPlayerLocation() {
        PLAYER.setX(0);
        PLAYER.setY(0);
        PLAYER.setVelocityX(0);
        PLAYER.setVelocityY(0);
    }

    /**
     * Graphics object is used to uniformly paint the Board class
     * The background image x & y coordinates are set to 0 due to its expansion
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ImageIcon img = new ImageIcon("Resources/Background.png");
        Image background = img.getImage();
        g2.drawImage(background, 0, 0, null);
        setAndUpdateStage(g2);
        levelUp();
        deployEnemies(g2);
        checkEnemyCollision();
    }

    public void deployEnemies(Graphics2D g2) {
        enemies.forEach(e -> e.paint(g2));
    }

    public void setAndUpdateStage(Graphics2D g2) {
        EXIT_DOOR.paint(g2);
        PLAYER.paint(g2);
        COUNT_LEVEL.draw(g2);
    }

    /**
     * LevelUp is called when there is a collision between Player and ExitDoor
     * Resets the Player to the home position and adds an InfectedPlayer
     */
    public void levelUp() {
        if (PLAYER.getBounds().intersects(EXIT_DOOR.getBounds())) {
            enemies.add(new InfectedPlayer(RAND.nextInt(ENEMY_BOUNDS), RAND.nextInt(ENEMY_BOUNDS)));
            COUNT_LEVEL.add();
            resetPlayerLocation();
        }
    }

    public void resetAll() {
        this.enemyCount = 1;
        COUNT_LEVEL.reset();
        resetPlayerLocation();
        enemies = new ArrayList<>();
        generateInfectedPlayers();
    }

    public void checkEnemyCollision() {
        for (var e : enemies) {
            if (PLAYER.getBounds().intersects(e.getBounds())) {
                resetPlayerLocation();
                GAME.next();
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_SCREEN_SIZE, DEFAULT_SCREEN_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        for (InfectedPlayer a : enemies) {
            a.updateInfectedPosition();
        }
        PLAYER.updatePlayerPosition();
        PLAYER.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            PLAYER.setVelocityY(-2);
        }
        if (code == KeyEvent.VK_DOWN) {
            PLAYER.setVelocityY(2);
        }
        if (code == KeyEvent.VK_LEFT) {
            PLAYER.setVelocityX(-2);
        }
        if (code == KeyEvent.VK_RIGHT) {
            PLAYER.setVelocityX(2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PLAYER.setVelocityY(0);
        PLAYER.setVelocityX(0);
    }
}