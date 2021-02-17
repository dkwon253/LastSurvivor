package com.lastsurvivor.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private JFrame frame;
    private Board board;
    private Container container;
    private CardLayout card;

    public Game(String name) {
        card = new CardLayout();
        frame = new JFrame(name);
        board = new Board();
        container = frame.getContentPane();
    }

    public void showGame() {
        instantiate();
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Set Frame to CardLayout; this will allow for switching of components
     * addComponentToPane will add all components into our application.
     */
    public void instantiate() {
        container.setLayout(card);
        addComponentsToPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponentsToPane() {
        JButton button = new JButton("Button");
        button.setActionCommand("Switch");
        button.addActionListener(this);
        JButton button2 = new JButton("Welcome, Click to get started!");
        button2.setSize(50, 50);
        button2.setActionCommand("Switch");
        button2.addActionListener(this);
        container.add(button2);
        container.add(board);
    }

    public void addComponentToGame(Component component) {
        container.add(component);
    }

    /**
     * action performed will look for events that are set in the add components
     * method. "requestFocus" is needed to switch between screens without losing
     * control over a character.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Switch")) {
            card.next(container);
            board.requestFocus();
        }
    }
}
