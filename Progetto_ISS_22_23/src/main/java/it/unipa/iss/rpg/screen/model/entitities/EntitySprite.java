package it.unipa.iss.rpg.screen.model.entitities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class EntitySprite {
    private int worldX, worldY;
    private List<BufferedImage> sprites;
    private List<String> spritesPath;

    public EntitySprite(int worldX, int worldY) {
        this.sprites = new ArrayList<>();
        this.worldX = worldX;
        this.worldY = worldY;
        this.spritesPath = new ArrayList<>();
    }

    public EntitySprite(int worldX, int worldY, List<BufferedImage> sprites) {
        this.sprites = new ArrayList<>();
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public void addSprite(BufferedImage tile) {
        this.sprites.add(tile);
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public void setSpritesPath(List<String> strings) {
        this.spritesPath.addAll(strings);
    }

    public List<BufferedImage> getSprites() {
        return sprites;
    }

    public void setSprites(List<BufferedImage> sprites) {
        this.sprites = sprites;
    }

    public List<String> getSpritesPath() {
        return this.spritesPath;
    }
}
