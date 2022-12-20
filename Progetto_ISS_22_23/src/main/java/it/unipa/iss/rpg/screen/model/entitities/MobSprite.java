package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class MobSprite extends EntitySprite{

    public MobSprite(int worldX, int worldY) {
        super(worldX, worldY);
    }
    public MobSprite(int worldX, int worldY, List<Tile> sprites) {
        super(worldX, worldY, sprites);
    }

    @Override
    public void addSprite(Tile tile) {
        super.getSprites().add(tile);
    }

    public BufferedImage getDefaultSprite() {
        return this.getSprites().get(0).getTileImage();
    }
}
