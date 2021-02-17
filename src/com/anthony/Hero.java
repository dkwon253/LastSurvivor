package com.anthony;

import javax.swing.*;
import java.awt.*;

public class Hero extends JPanel  {
    private Image image;
    private int x;
    private int y;
    private int vX = 0;
    private int vY = 0;


    public Hero(String filename){
        this.image = new ImageIcon(filename).getImage();

    }

    public void paint(Graphics2D g2){
        g2.drawImage(image,  x, y, null);
    }

    @Override public int getX() {
        return x;
    }

    @Override public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getvX() {
        return vX;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public int getvY() {
        return vY;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }
}
