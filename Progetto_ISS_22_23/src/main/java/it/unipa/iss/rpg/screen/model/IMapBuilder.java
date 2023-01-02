package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Npc;

import java.awt.image.BufferedImage;

public interface IMapBuilder {
    public void reset();
    public void buildMapNpc(int x,int y);
    public void buildMapEnemies(int x,int y);
    public void buildWorldTiles(int x,int y);
    public void buildEndMap(int x, int y);
    public Map build();

}
