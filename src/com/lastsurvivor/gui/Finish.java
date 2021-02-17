package com.lastsurvivor.gui;

import javax.swing.*;
import java.awt.*;

public class Finish {
    private int x;
    private int y;
    private Image image;
    private final int DEFAULT_X = 915;
    private final int DEFAULT_Y = 915;
    private final int DEFAULT_WIDTH = 80;
    private final int DEFAULT_HEIGHT = 109;

    Rectangle rectangle;

    public Finish() {
        this.image = new ImageIcon("Resources/Exit.png").getImage();
        rectangle = new Rectangle(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paint(Graphics2D g2) {

        g2.drawImage(image, 920, 900, null);
//        g2.drawRect(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        g2.fillRect(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Rectangle getBounds() {
        return new Rectangle(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    // 80 W 109H
}