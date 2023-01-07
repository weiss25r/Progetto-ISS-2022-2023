package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.Map;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Npc;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.model.entitities.PlayerSprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawController {

    private final int scale;
    private final int maxRows;
    private final int maxCols;

    public DrawController(int scale, int maxRows, int maxCols) {
        this.scale = scale;
        this.maxRows = maxRows;
        this.maxCols = maxCols;
    }

    public void drawPlayer(Graphics2D g, Player player) {
        PlayerSprite playerSprite = player.getPlayerSprite();

        g.drawImage(playerSprite.getDirectionImage(),
                playerSprite.getWorldX(),
                playerSprite.getWorldY(),
                scale,
                scale,
                null
        );
    }

    public void drawWorld(Graphics2D g, Map map){

        for (int i = 0; i < this.maxCols; i++) {
            for (int j = 0; j < this.maxRows; j++) {
                BufferedImage image = map.getTile(j, i);

                g.drawImage(image, i * scale, j * scale, scale, scale, null);
            }
        }
    }

    public void drawEnemies(Graphics2D g, Map map) {

        for (int i = 0; i < this.maxCols; i++) {
            for (int j = 0; j < this.maxRows; j++) {
                Mob mob = map.getEnemy(j, i);


                if(mob != null)
                    g.drawImage(mob.getMobSprite().getDefaultSprite(), i * scale, j * scale, scale, scale, null);
            }
        }
    }

    //TODO: assente nei class diagram
    public void drawCharacters(Graphics2D g, Map map) {

        for (int i = 0; i < this.maxCols; i++) {
            for (int j = 0; j < this.maxRows; j++) {
                Npc npc = map.getNpc(j, i);

                if(npc != null)
                    g.drawImage(npc.getNpcSprite().getDefaultSprite(), i * scale, j * scale, scale, scale, null);
            }
        }
    }
}
