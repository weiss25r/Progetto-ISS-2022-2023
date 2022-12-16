package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public class Player implements Entity {

    private Statistics stats;
    private PlayerSprite playerSprite;

    private final int movementSpeed;
    private BufferedImage directionImage;

    public Player() {
        this.movementSpeed = 10;
        this.playerSprite = new PlayerSprite();
        playerSprite.loadSprites(loadTiles());
        this.stats = new Statistics(100, 50, 0, 70);
    }

    private List<Tile> loadTiles() {
        List<Tile> playerSprites = new ArrayList<>();

        try {
            playerSprites.add(new Tile(ImageIO.read(new File("src/res/character/move/down/char_down_00.png"))));
            playerSprites.add(new Tile(ImageIO.read(new File("src/res/character/move/up/char_up_00.png"))));
            playerSprites.add(new Tile(ImageIO.read(new File("src/res/character/move/left/char_left_00.png"))));
            playerSprites.add(new Tile(ImageIO.read(new File("src/res/character/move/right/char_right_00.png"))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.directionImage = playerSprites.get(0).getTileImage();

        return playerSprites;
    }

    public void move(EventType e) {
        switch (e) {
            case MOVED_DOWN -> {
                this.playerSprite.setWorldY(playerSprite.getWorldY() + this.movementSpeed);
                this.directionImage = this.playerSprite.getSprites().get(0).getTileImage();

            }
            case MOVED_UP -> {
                this.playerSprite.setWorldY(playerSprite.getWorldY() - this.movementSpeed);
                this.directionImage = this.playerSprite.getSprites().get(1).getTileImage();
            }
            case MOVED_LEFT -> {
                this.playerSprite.setWorldX(playerSprite.getWorldX() - this.movementSpeed);
                this.directionImage = this.playerSprite.getSprites().get(2).getTileImage();
            }
            case MOVED_RIGHT -> {
                this.playerSprite.setWorldX(playerSprite.getWorldX() + this.movementSpeed);
                this.directionImage = this.playerSprite.getSprites().get(3).getTileImage();
            }
        }

        System.out.printf("(%d %d)\n", playerSprite.getWorldX(), playerSprite.getWorldY());
    }

    public PlayerSprite getPlayerSprite() {
        return playerSprite;
    }

    public BufferedImage getDirectionImage() {
        return this.directionImage;
    }

    public Statistics getStats() {
        //defensive copying
        return this.stats;
        //return new Statistics(stats.getHp(), stats.getDef(), stats.getStamina(), stats.getAtk());
    }


}
