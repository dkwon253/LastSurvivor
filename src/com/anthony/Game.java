package com.anthony;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private JFrame frame;
    private Second second;
    private Container container;
    private CardLayout card;

    public Game(String name){
        card = new CardLayout();
        frame = new JFrame(name);
        second = new Second();
        container = frame.getContentPane();
    }


    public void showGame(){
        instantiate();
        frame.pack();
        frame.setVisible(true);
    }

    public void instantiate(){
        container.setLayout(card);
        addComponentsToPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void addComponentsToPane(){
        second = new Second();
        JButton button = new JButton("Button");
        button.setActionCommand("Switch");
        button.addActionListener(this);
        second.add(button, BorderLayout.SOUTH);
        JButton button2 = new JButton("Welcome, Click to get started!");
        button2.setSize(50,50);
        button2.setActionCommand("Switch");
        button2.addActionListener(this);
        container.add(button2);
        container.add(second);
    }
    public void addComponentToGame(Component component){
        container.add(component);
    }

    public void setCard(CardLayout card) {
        this.card = card;
    }

    public void setGame(Game game) {

    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Switch")){
            card.next(container);
        }
        second.requestFocus();
    }


}
