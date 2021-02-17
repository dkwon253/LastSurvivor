package com.anthony;

import javax.swing.*;

public class mover extends JPanel{
    JFrame f;

    public mover(){
        f = new JFrame();
        //f.add(s2);
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Moving ball");
    }

}
