package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.Tile;

import java.awt.image.BufferedImage;
import java.util.List;

public class PlayerSprite extends EntitySprite{
    private BufferedImage direction;

    public PlayerSprite() {
        super(100, 120);
    }

    @Override
    public void addSprite(Tile tile) {
        super.getSprites().add(tile);

    }

    @Override
    public void setSprites(List<Tile> sprites) {
        super.setSprites(sprites);
        this.direction = this.getSprites().get(0).getTileImage();
    }

    public BufferedImage getDirection() {
        return direction;
    }
}
