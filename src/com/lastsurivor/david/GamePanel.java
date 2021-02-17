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

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        ImageIcon img = new ImageIcon("Resources/Background2.png");
        Image background = img.getImage();
        g2.drawImage(background, 0, 0, null);
        player.draw(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.getX() < 0 || player.getX() > 940) {
            player.setVelocityX(-player.getVelocityX());
        }
        if (player.getY() < 0 || player.getY() > 890) {
            player.setVelocityY(-player.getVelocityY());
        }
        player.updatePosition();
        repaint();
    }
}