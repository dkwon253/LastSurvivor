package com.lastsurvivor.person;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameFrame game = new GameFrame();
        JFrame frame = new JFrame("Test");
        frame.add(game);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}