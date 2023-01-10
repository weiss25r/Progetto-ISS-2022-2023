package it.unipa.iss.rpg.screen.model.entitities;

import java.awt.image.BufferedImage;
import java.util.List;

public class MobSprite extends EntitySprite{

    public MobSprite(int worldX, int worldY) {
        super(worldX, worldY);
    }
    public MobSprite(int worldX, int worldY, List<BufferedImage> sprites) {
        super(worldX, worldY, sprites);
    }

    @Override
    public void addSprite(BufferedImage tile) {
        super.getSprites().add(tile);
    }

    public BufferedImage getDefaultSprite() {
        return this.getSprites().get(0);
    }
}
