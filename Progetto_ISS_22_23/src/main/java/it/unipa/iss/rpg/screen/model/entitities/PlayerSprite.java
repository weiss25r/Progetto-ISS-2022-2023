package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.Tile;

import java.awt.image.BufferedImage;
import java.util.List;

public class PlayerSprite extends EntitySprite{
    private BufferedImage direction;

    public PlayerSprite() {
        this.setWorldX(240);
        this.setWorldY(360);
    }

    @Override
    public void loadSprites(List<Tile> list) {
        this.setSprites(list);
        this.direction = this.getSprites().get(0).getTileImage();
    }


    public BufferedImage getDirection() {
        return direction;
    }
}
