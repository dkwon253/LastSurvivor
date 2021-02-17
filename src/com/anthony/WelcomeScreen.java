package com.anthony;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeScreen extends JPanel {
        WelcomeScreen(ActionListener actionListener){
            GridLayout layout = new GridLayout();
            JButton button = new JButton("Switch");
            button.addActionListener(actionListener);
            layout.addLayoutComponent("Button", button);
            setLayout(layout);
            setSize(50, 50);
            setBackground(Color.GREEN);


            add(new WelcomeMessage("Hello World"), BorderLayout.NORTH);
        }

        private class WelcomeMessage extends JLabel{

            WelcomeMessage(String message){
                setText(message);
            }
        }
}
