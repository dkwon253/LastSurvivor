package com.lastsurvivor.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class EndGamePanel extends JPanel {

    EndGamePanel(ActionListener listener) {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        JButton endGame = new JButton("End Game");
        JButton restart = new JButton("Restart");

        add(new JLabel("<html><h1><strong><i>Game Over</i></strong></h1><hr></html>"), gbc);

        endGame.addActionListener(listener);
        restart.addActionListener(listener);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());

        buttons.add(endGame);
        buttons.add(restart);

        add(buttons, gbc);

    }
}