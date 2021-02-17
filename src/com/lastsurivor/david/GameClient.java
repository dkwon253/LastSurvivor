package com.lastsurivor.david;

import javax.swing.*;

public class GameClient {
    public static void main(String[] args) {
        GamePanel game = new GamePanel();
        JFrame frame = new JFrame("The Last Survivor");
        frame.add(game);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}