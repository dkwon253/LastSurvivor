package com.lastsurivor.gui;

import javax.swing.*;

public class Mover {
    public static void main(String args[]) {
        Second s = new Second();
        JFrame f = new JFrame();
        f.add(s);
        f.setVisible(true);
        f.setSize(1000,900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Last Survivor");
    }
}
