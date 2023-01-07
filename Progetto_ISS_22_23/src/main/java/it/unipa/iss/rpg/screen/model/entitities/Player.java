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

    public Player() {
        this.movementSpeed = 10;
        this.playerSprite = new PlayerSprite();
        this.stats = new Statistics(100, 50, 100, 70);
    }

    public Player(Statistics stats, PlayerSprite playerSprite) {
        this.movementSpeed = 10;
        this.playerSprite = playerSprite;
        this.stats = stats;
    }

    public void move(EventType e) {
        switch (e) {
            case MOVED_DOWN -> {
                this.playerSprite.setWorldY(playerSprite.getWorldY() + this.movementSpeed);
            }
            case MOVED_UP -> {
                this.playerSprite.setWorldY(playerSprite.getWorldY() - this.movementSpeed);
            }
            case MOVED_LEFT -> {
                this.playerSprite.setWorldX(playerSprite.getWorldX() - this.movementSpeed);
            }
            case MOVED_RIGHT -> {
                this.playerSprite.setWorldX(playerSprite.getWorldX() + this.movementSpeed);
            }
        }

        playerSprite.setDirectionImage(e);
    }

    public PlayerSprite getPlayerSprite() {
        return playerSprite;
    }


    public Statistics getStats() {
        //defensive copying
        return this.stats;
        //return new Statistics(stats.getHp(), stats.getDef(), stats.getStamina(), stats.getAtk());
    }
}
