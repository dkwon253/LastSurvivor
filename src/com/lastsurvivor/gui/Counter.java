package com.lastsurvivor.gui;

import java.awt.*;
/**
 * The Counter class represents counter for the application.
 */
public class Counter {

    private final int DISPLAY_X = 860;
    private final int DISPLAY_Y = 50;

    private int counter = 1;
    private Font text = new Font("San Serif", Font.BOLD, 25);

    public void draw(Graphics g) {
        g.setFont(text);
        g.setColor(Color.WHITE);
        g.drawString("Level: "+Integer.toString(counter), DISPLAY_X, DISPLAY_Y);
    }

    public void add() {
        counter += 1;
    }

    public void reset() {
        counter = 1;
    }
}