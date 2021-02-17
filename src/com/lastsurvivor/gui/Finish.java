package com.lastsurvivor.gui;

import java.awt.*;

public class Finish {
    private int x;
    private int y;
    private final int DEFAULT_X = 900;
    private final int DEFAULT_Y = 900;
    private final int DEFAULT_WIDTH = 80;
    private final int DEFAULT_HEIGHT = 80;

    Rectangle rectangle;

    public Finish() {
        rectangle = new Rectangle(DEFAULT_X, DEFAULT_Y, 5, 5);
    }

    public void paint(Graphics2D g2) {
        g2.drawRect(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g2.fillRect(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Rectangle getBounds() {
        return new Rectangle(DEFAULT_X, DEFAULT_Y, 5, 5);
    }
}