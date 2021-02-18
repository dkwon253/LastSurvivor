package com.lastsurvivor.client;

import com.lastsurvivor.gui.Game;

/**
 * The GameClient is where the game is ran.
 */
public class GameClient {
    public static void main(String[] args) {
        Game game = new Game("The Last Survivor");
        game.showGame();
    }
}