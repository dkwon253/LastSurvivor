package com.lastsurvivor.person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

// TODO: rename GamePanel
public class GameFrame extends JPanel implements ActionListener {

    Timer time;
    Player player;

    public GameFrame () {
        setFocusable(true);
        player = new Player();
    }

//    public void backgroundImage() {
//        ImageIcon img = new ImageIcon("Resources/Background.png");
//        Image background = img.getImage();
//    }
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }
}