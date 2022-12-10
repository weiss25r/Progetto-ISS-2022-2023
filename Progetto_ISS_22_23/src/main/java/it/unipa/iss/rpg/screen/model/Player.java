package it.unipa.iss.rpg.screen.model;

import jdk.jfr.Event;

import javax.imageio.ImageIO;
import javax.xml.transform.dom.DOMResult;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

public class Player {
    private static Player player = null;
    private int worldX;
    private int worldY;
    private List<Tile> playerSprites;
    private int movementSpeed;

    private BufferedImage directionImage;

    private Player() {
        this.worldX = 0;
        this.worldY = 0;
        this.movementSpeed = 50;
        this.playerSprites = new ArrayList<>();

        loadSprites();
    }

    public static Player getInstance() {
       if(player == null)
           player = new Player();
       return player;
    }

    private void loadSprites() {
        try {
            this.playerSprites.add(new Tile(ImageIO.read(new File("src/res/player/player_down_1.png"))));
            this.playerSprites.add(new Tile(ImageIO.read(new File("src/res/player/player_up_1.png"))));
            this.playerSprites.add(new Tile(ImageIO.read(new File("src/res/player/player_left_1.png"))));
            this.playerSprites.add(new Tile(ImageIO.read(new File("src/res/player/player_right_1.png"))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.directionImage = playerSprites.get(0).getTileImage();
    }

    public void move(EventType e) {
        switch (e) {
            case MOVED_DOWN -> {
                this.worldY += movementSpeed;
                this.directionImage = playerSprites.get(0).getTileImage();
            }
            case MOVED_UP -> {
                this.worldY -= movementSpeed;
                this.directionImage = playerSprites.get(1).getTileImage();
            }
            case MOVED_LEFT -> {
                this.worldX -= movementSpeed;
                this.directionImage = playerSprites.get(2).getTileImage();
            }
            case MOVED_RIGHT -> {
                this.worldX += movementSpeed;
                this.directionImage = playerSprites.get(3).getTileImage();
            }
        }
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public BufferedImage getDirectionImage() {
        return this.directionImage;
    }
}
