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
        player = new Player(0, 0);
        // TODO: addKeyListener(player);
        addKeyListener(new KeyStrokes(player));
        time = new Timer(5, this);
        time.start();
    }

//    public void backgroundImage() {
//        ImageIcon img = new ImageIcon("Resources/Background.png");
//        Image background = img.getImage();
//    }
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Last Survivor Test", 500, 500);
        player.draw(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }
}