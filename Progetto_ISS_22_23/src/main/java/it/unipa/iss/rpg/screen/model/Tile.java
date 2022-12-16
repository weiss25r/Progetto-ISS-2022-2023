package it.unipa.iss.rpg.screen.model;

import java.awt.image.BufferedImage;

/**
 * @author Raffaele Terracino
 *
 * Classe che rappresenta il singolo Tile da disegnare su schermo
 */

public class Tile {
    private final BufferedImage tileImage;



    public Tile(BufferedImage tileImage) {
        this.tileImage = tileImage;
    }

    public BufferedImage getTileImage() {
        return this.tileImage;
    }
}
