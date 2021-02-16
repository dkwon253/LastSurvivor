package com.lastsurvivor.person;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// TODO: delete this and just use Player as the keylistener
public class KeyStrokes extends KeyAdapter {

    Player p;

    public KeyStrokes (Player player) {
        p = player;
    }

    public void keyPressed (KeyEvent e) {
        p.keyPressed(e);
    }

    public void keyReleased (KeyEvent e) {
        p.keyReleased(e);
    }
}