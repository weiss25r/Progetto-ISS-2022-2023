package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.Tile;

import java.util.ArrayList;
import java.util.List;

public abstract class EntitySprite {
    private int worldX, worldY;
    private List<Tile> sprites;
    private List<String> spritesPath;

    public EntitySprite(int worldX, int worldY) {
        this.sprites = new ArrayList<>();
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public EntitySprite(int worldX, int worldY, List<Tile> sprites) {
        this.sprites = new ArrayList<>();
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public void addSprite(Tile tile) {
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

    public List<Tile> getSprites() {
        return sprites;
    }

    public void setSprites(List<Tile> sprites) {
        this.sprites = sprites;
    }
}
