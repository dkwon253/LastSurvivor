package com.lastsurvivor.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Finish is the class that paints the exit door.
 */
public class ExitDoor {

    private final int DEFAULT_X = 915;
    private final int DEFAULT_Y = 915;
    private final int DEFAULT_WIDTH = 80;
    private final int DEFAULT_HEIGHT = 109;
    private final int DOOR_PAINT_X = 920;
    private final int DOOR_PAINT_Y = 900;
    private Image image;

    public ExitDoor() {
        this.image = new ImageIcon("Resources/Exit.png").getImage();

    }

    public void paint(Graphics2D g2) {
        g2.drawImage(image, DOOR_PAINT_X, DOOR_PAINT_Y, null);
    }

    /**
     * getBounds is being used for collision detection.
     */
    public Rectangle getBounds() {
        return new Rectangle(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}