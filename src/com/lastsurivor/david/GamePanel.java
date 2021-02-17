package com.lastsurivor.david;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    private Timer time = new Timer(5, this);
    private Player player = new Player(0, 0);

    public GamePanel() {
        setFocusable(true);
        addKeyListener(player);
        time.start();
    }

    //    public void backgroundImage() {
//        ImageIcon img = new ImageIcon("Resources/Background.png");
//        Image background = img.getImage();
//    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.getX() < 0 || player.getX() > 940) {
            player.setVelocityX(-player.getVelocityX());
        }
        if (player.getY() < 0 || player.getY() > 900) {
            player.setVelocityY(-player.getVelocityY());
        }
        player.updatePosition();
        repaint();
    }
}