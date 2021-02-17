package com.lastsurivor.david;

import javax.swing.*;
import java.awt.*;

public class InfectedPlayer {

    private int x;
    private int y;
    private int velocityY = 2;
    private int velocityX = 2;

    public InfectedPlayer (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updateInfectedPosition() {
        y += velocityY;
        x += velocityX;

        if (x < 0 || x > 940) {
            velocityX = -velocityX;
        }
        if (y < 0 || y> 890) {
            velocityY = -velocityY;
        }
    }

    public void drawInfectedPlayer(Graphics2D g2) {
        g2.drawImage(infectedPlayer(), x, y, null);
    }

    public Image infectedPlayer() {
        ImageIcon img = new ImageIcon("Resources/PlayerBlack.png");
        return img.getImage();
    }
}