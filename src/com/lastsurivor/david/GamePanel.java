package com.lastsurivor.david;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer time = new Timer(5, this);
    private Player player = new Player(0, 0);
    private InfectedPlayer infectedPlayer = new InfectedPlayer(200, 200);
    ArrayList<InfectedPlayer> infected = new ArrayList<>();
    Random randomInfected = new Random();
    private int infectedCount = 5;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        randomInfected();
        time.start();
    }

    public void addInfected(InfectedPlayer p) {
        infected.add(p);
    }

    public void randomInfected () {
        for (int i = 0; i < infectedCount; i++) {
            addInfected(new InfectedPlayer(randomInfected.nextInt(700), randomInfected.nextInt(700)));
        }
    }

    public void drawInfectedPlayer(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (InfectedPlayer player : infected) {
            player.drawInfectedPlayer(g2);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        ImageIcon img = new ImageIcon("Resources/Background2.png");
        Image background = img.getImage();
        g2.drawImage(background, 0, 0, null);

        drawInfectedPlayer(g2);
        player.drawPlayer(g2);
        infectedPlayer.drawInfectedPlayer(g2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            player.setVelocityY(-2);
        } else if (code == KeyEvent.VK_DOWN) {
            player.setVelocityY(2);
        } else if (code == KeyEvent.VK_LEFT) {
            player.setVelocityX(-2);
        } else if (code == KeyEvent.VK_RIGHT) {
            player.setVelocityX(2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            player.setVelocityY(0);
        } else if (code == KeyEvent.VK_DOWN) {
            player.setVelocityY(0);
        } else if (code == KeyEvent.VK_LEFT) {
            player.setVelocityX(0);
        } else if (code == KeyEvent.VK_RIGHT) {
            player.setVelocityX(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.updatePlayerPosition();
        infectedPlayer.updateInfectedPosition();
        repaint();
    }
}