package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.screen.model.Tile;

import java.awt.image.BufferedImage;
import java.util.List;

public class NPCSprite extends EntitySprite{

    String dialogIconPath;

    public NPCSprite(int worldX, int worldY) {
        super(worldX, worldY);
    }

    public NPCSprite(int worldX, int worldY, String dialogIconPath) {
        super(worldX, worldY);
        this.dialogIconPath = dialogIconPath;
    }

    public NPCSprite(int worldX, int worldY, List<Tile> sprites) {
        super(worldX, worldY, sprites);
    }

    @Override
    public void addSprite(Tile tile) {
        super.getSprites().add(tile);
    }

    public BufferedImage getDefaultSprite() {
        return this.getSprites().get(0).getTileImage();
    }

    public String getDialogIconPath() {
        return dialogIconPath;
    }
}
