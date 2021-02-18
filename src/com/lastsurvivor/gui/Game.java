package com.lastsurvivor.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private JFrame frame;
    private Board board;
    private Container container;
    private CardLayout card;
    private EndGamePanel endGame;

    public Game(String name) {
        card = new CardLayout();
        frame = new JFrame(name);
        endGame = new EndGamePanel(this);
        container = frame.getContentPane();
        board = new Board(this);
    }

    public void showGame() {
        instantiate();
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
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
        WelcomeScreen welcomeScreen = new WelcomeScreen(this);

        container.add(welcomeScreen);
        container.add(board);
        container.add(endGame);
    }

    public void addComponentToGame(Component component) {
        container.add(component);
    }

    /**
     * action performed will look for events that are set in the add components
     * method. "requestFocus" is needed to switch between screens without losing
     * control over a character.
     */
    public void next(){
        card.next(container);
        endGame.requestFocus();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Switch")) {
            card.next(container);
            board.requestFocus();
        }
        if (e.getActionCommand().equals("Start")) {
            card.next(container);
            board.requestFocus();
        }
        if(e.getActionCommand().equals("End Game")){
            System.exit(0);
        }
        if(e.getActionCommand().equals("Restart")){
            card.previous(container);
            board.requestFocus();
        }
    }
    public class WelcomeScreen extends JPanel{
        public WelcomeScreen(ActionListener listener){
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            JButton start = new JButton("Start");
            JButton retreat = new JButton("I'm not ready.");
            add(new JLabel("<html><h1><strong><i>Welcome to the ThunderDome</i></strong></h1><hr></html>"), gbc);
            start.addActionListener(listener);
            retreat.addActionListener(listener);
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            JPanel buttons = new JPanel(new GridBagLayout());
            buttons.add(start);
            buttons.add(retreat);
            add(buttons, gbc);

        }
    }
}
