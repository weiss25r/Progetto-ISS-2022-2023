package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.Tile;

import java.awt.image.BufferedImage;
import java.util.List;

public class PlayerSprite extends EntitySprite{
    private BufferedImage directionImage;

    public PlayerSprite() {
        super(100, 120);
    }

    public PlayerSprite(int x, int y){
        super(x, y);
    }
    @Override
    public void addSprite(Tile tile) {
        super.getSprites().add(tile);
    }

    @Override
    public void setSprites(List<Tile> sprites) {
        super.setSprites(sprites);
    }

    public BufferedImage getDirectionImage() {
        return this.directionImage;
    }

    public void setDirectionImage(EventType eventType) {
        switch (eventType) {
            case MOVED_DOWN -> this.directionImage = getSprites().get(0).getTileImage();
            case MOVED_UP -> this.directionImage = getSprites().get(1).getTileImage();
            case MOVED_LEFT -> this.directionImage = getSprites().get(2).getTileImage();
            case MOVED_RIGHT -> this.directionImage = getSprites().get(3).getTileImage();
        }
    }
}
