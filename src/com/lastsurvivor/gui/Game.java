package com.lastsurvivor.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
/**
 * The Game Class holds the body of the application. This includes the board and routing functionalities.
 * Routing is implemented through a CardLayout. Which is used inside of the JFrame as content manager.
 */
public class Game implements ActionListener {
    private JFrame frame;
    private Board board;
    private Container container;
    private CardLayout card;
    private EndGamePanel endGame;

    /**
     * This initializes the Game's main components and routes the Game actionListener to its children.
     */
    public Game(String name) {
        card = new CardLayout();
        frame = new JFrame(name);
        endGame = new EndGamePanel(this);
        container = frame.getContentPane();
        board = new Board(this);
    }

    /**
     * ShowGame is responsible for building out the JFrame container and displaying the application.
     */
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

    /**
     * action performed will look for events that are set in the add components
     * method. "requestFocus" is needed to switch between screens without losing
     * control over a character.
     */
    public void next() {
        card.next(container);
        board.resetAll();
        endGame.requestFocus();
    }

    /**
     * ActionPerformed controls events throughout the application
     * requestFocus is needed to direct actionListener to applicable object.
     */

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
        if (e.getActionCommand().equals("Restart")) {
            card.previous(container);
            board.requestFocus();
        }
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }


    public class WelcomeScreen extends JPanel {
        public WelcomeScreen(ActionListener listener) {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            JButton start = new JButton("Start");
            JButton retreat = new JButton("Exit");
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