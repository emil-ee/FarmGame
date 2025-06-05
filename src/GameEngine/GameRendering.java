/*******************************************************************************
 * Handles the core rendering of the game
 *
 ******************************************************************************/
package GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameRendering extends JPanel {
    private Viewport viewport;
    //private Player player;
    //private InputHandling keyBinding;

    /**
     * Constructing game rendering; initializes the display area and player
     * @param viewport : The Viewport instance is responsible for
     *                 window management.
     * @param player : The player object
     ***************************************************************************/
    public GameRendering(Viewport viewport, Player player) {
        this.viewport = viewport;
        //this.player = player;

        // --- Assigns Keybinding to Player Object ---
        this.keyBinding = new InputHandling(this, this.player);
        setFocusable(true);
    }

    /**
     * Updates the game state
     * This method is called repeatedly by the game loop to advance
     * the game logic. Currently, it only updates the player's state.
     */
    public void update() {
        player.update();
    }

    /**
     * Overrides the Jpanel component, called automatically by the
     * Swing framework when the panel needs to be redrawn.
     * Handles the rendering of the game elements.
     * @param g the <code>Graphics</code> object to protect
     ***************************************************************************/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // drawing the player sprite
        player.draw(g2d);
    }

    // --- Getter/Setter Methods ---
    public Viewport getViewport(Viewport viewport) {
        return viewport;
    }

}


