package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.Tile;

import java.awt.*;
import java.util.List;

public class MobSprite extends EntitySprite{

    public MobSprite(int worldX, int worldY) {
        super(worldX, worldY);
    }

    @Override
    public void addSprite(Tile tile) {
        super.getSprites().add(tile);
    }

    public Image getDefaultSprite() {
        return this.getSprites().get(0).getTileImage();
    }
}
