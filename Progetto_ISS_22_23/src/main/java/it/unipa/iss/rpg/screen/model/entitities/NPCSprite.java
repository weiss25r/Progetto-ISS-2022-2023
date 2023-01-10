package it.unipa.iss.rpg.screen.model.entitities;

import java.awt.image.BufferedImage;

public class NPCSprite extends EntitySprite{

    String dialogIconPath;

    public NPCSprite(int worldX, int worldY, String dialogIconPath) {
        super(worldX, worldY);
        this.dialogIconPath = dialogIconPath;
    }

    @Override
    public void addSprite(BufferedImage tile) {
        super.getSprites().add(tile);
    }

    public BufferedImage getDefaultSprite() {
        return this.getSprites().get(0);
    }

    public String getDialogIconPath() {
        return dialogIconPath;
    }
}
