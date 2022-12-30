package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Npc;

import java.awt.image.BufferedImage;

public interface IMapBuilder {
    public void reset();
    public void buildNpc(Npc[][] npc);
    public void buildMob(Mob[][] mobs);
    public void buildWorldTiles(BufferedImage[][] worldTiles);
    public void buildEndMap(BufferedImage[][] endMap);
    public Map build();

}
