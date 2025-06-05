/*******************************************************************************
 *
 *
 *******************************************************************************/
package GameEngine;

import javax.swing.*;
import java.awt.*;

public class Viewport {

    // --- Display properties ---
    private JFrame display;
    private static Viewport instance = null;

    // --- Tile Sizing ---
    private final int tileSize;
    private final int scale;
    private final int scaledTileSize;

    // --- Screen Dimensions ---
    private final int screenWidthInTiles;
    private final int screenHeightInTiles;
    private final int screenWidth;
    private final int screenHeight;

    // --- Resize Minimum Screen Components ---
    private int MinTileCols = 16;
    private int MinTileRows = 16;
    private int minSize;

    private Viewport() {
        // --- initializing Display Size ---
        this.tileSize = 16;                       // 16px x 16px tiles
        this.scale = 3;
        this.scaledTileSize = tileSize * scale;   // 48px x 48px tiles
        this.screenWidth = screenWidth();
        this.screenHeight = screenHeight();

        this.screenWidthInTiles = screenWidth / scaledTileSize;
        this.screenHeightInTiles = screenHeight / scaledTileSize;
    }

    /**
     * Ensuring that only one instance of an object exists by checking
     * if the object is null creates a new single viewport object.
     *
     * @return
     */
    public static Viewport getInstance() {
        if (instance == null) {
            instance = new Viewport();
            instance.init();   // creates the display window
        }
        return instance;
    }

    /**
     *
     */
    public void init() {
        // if object already running returns that object
        if (display != null) {
            return;
        }
            // --- Creating the Display Window --
            display = new JFrame("Farming Game");
            display.setResizable(true);
            display.setSize(screenWidthInTiles, screenHeightInTiles);
            display.setMinimumSize(new Dimension(840, 688));
            display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            display.setLocationRelativeTo(null);
            display.setVisible(true);

            // --- Dock Icon ---

            }

    // --- Setter Methods ---

    /**
     * Setting the screenWidth to the width of the users display
     *
     * @param screenWidth
     * @return
     ***************************************************************************/
    public int setScreenWidth(int screenWidth) {
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        return screenWidth;
    }

    /**
     * Setting the screenHeight to the width of the users display
     *
     * @param screenHeight
     * @return
     ***************************************************************************/
    public int setScreenHeight(int screenHeight) {
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        return screenHeight;
    }

    // Getter methods
    public int tileSize() {
        return tileSize;
    }

    public int scale() {
        return scale;
    }

    public int scaledTileSize() {
        return scaledTileSize;
    }

    public int screenWidthInTiles() {
        return screenWidthInTiles;
    }

    public int screenHeightInTiles() {
        return screenHeightInTiles;
    }

    public int screenWidth() {
        return screenWidth;
    }

    public int screenHeight() {
        return screenHeight;
    }

}

