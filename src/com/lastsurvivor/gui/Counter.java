package com.lastsurvivor.gui;

import java.awt.*;

public class Counter {
    private int counter = 1;
    Font text = new Font("Comics", Font.BOLD, 20);

    public void draw(Graphics g) {
        g.setFont(text);
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(counter), 970, 50);
    }
    public void addCounter() {
        counter+=1;
    }
}