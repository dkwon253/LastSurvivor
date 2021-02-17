package com.anthony;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeScreen extends JFrame {
    private boolean initialized = false;
    private Actions actions = new Actions();

    public WelcomeScreen(){
        initialize();
        JButton j = new JButton();
        j.setActionCommand("Open");
        this.add(j);
    }

    public void initialize() {
        initializeGui();
        initializeEvents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initializeGui() {
        if (initialized)
            return;
        initialized = true;
        this.setSize(500, 400);
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
        Container pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
        // TODO: Add UI widgets
    }

    private void initializeEvents() {

    }



    public class Actions implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println(command);
            command = command == null ? "" : command;
            System.out.println(command);



        }
    }

    public void dispose() {
        // TODO: Save settings
        //super.dispose();
        System.exit(0);
    }

    public void setVisible(boolean b) {
        initialize();
        super.setVisible(b);
    }


    public static void main(String[] args) {
        JFrame window = new WelcomeScreen();
        window.setJMenuBar(new JMenuBar());

        window.setVisible(true);
    }
}
