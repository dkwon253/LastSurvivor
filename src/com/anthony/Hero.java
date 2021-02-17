package com.anthony;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Hero extends Ellipse2D implements KeyListener, ActionListener {
    private double x;
    private double y;
    private double width;
    private double height;
    private boolean isEmpty;
    private double velX;
    private double velY;


    private Frame frame;


    public Hero(double x, double y, double width,double height){
        setFrame(x,y,width,height);
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
    this.x=x;
    this.y=y;
    this.width=w;
    this.height=h;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    static class Double extends Ellipse2D.Double{
        public Double(double x, double y, double w, double h) {
            super(x, y, w, h);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();

        /*if(x < 0 || x > 910){
            velX = -velX;
        }
        if(y < 0 || y > 850){
            velY = -velY;
        }*/
        x += velX;
        y += velY;

    }

    public void up(){
        velY= -1.5;
        velX = 0;
    }

    public void down(){
        velY = 1.5;
        velX = 0;
    }

    public void left(){
        velX = -1.5;
        velY = 0;
    }

    public void right(){
        velX = 1.5;
        velY= 0;
    }

    public void upStop(){
        velY = 0;
        velX = 0;
    }

    public void downStop(){
        velY = 0;
        velX = 0;
    }

    public void leftStop(){
        velX = 0;
        velY = 0;
    }

    public void rightStop(){
        velX = 0;
        velX = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if( code == KeyEvent.VK_UP){
            up();
        }
        if(code == KeyEvent.VK_DOWN){
            down();
        }
        if (code == KeyEvent.VK_LEFT){
            left();
        }
        if (code == KeyEvent.VK_RIGHT){
            right();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            upStop();
        }
        if (code == KeyEvent.VK_DOWN){
            downStop();
        }
        if(code == KeyEvent.VK_LEFT){
            leftStop();
        }

        if(code == KeyEvent.VK_RIGHT){
            rightStop();
        }


    }
}
