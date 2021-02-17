package com.anthony;

import java.awt.*;

public class Finish {
    private int x;
    private int y;
    Rectangle rectangle;

    Finish(){
        rectangle = new Rectangle(100, 100, 20, 20);
    }

    public void paint(Graphics2D g2){
        g2.drawRect(100, 100, 20, 20);
        g2.fillRect(100,100,20,20);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
