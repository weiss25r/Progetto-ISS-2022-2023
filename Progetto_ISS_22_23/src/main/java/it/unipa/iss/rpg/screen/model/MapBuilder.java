package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.NPC;

import java.awt.image.BufferedImage;

public class MapBuilder implements IMapBuilder{

    private Mob[][] mapEnemies;
    private NPC[][] mapNPC;
    private BufferedImage[][] worldTiles;
    private  BufferedImage[][] endMap;

    @Override
    public void reset() {
        this.mapEnemies = null;
        this.endMap = null;
        this.worldTiles =  null;
        this.mapNPC = null;
    }

    @Override
    public void buildNpc(NPC[][] npc) {
        this.mapNPC = npc;
    }

    @Override
    public void buildMob(Mob[][] mobs) {
        this.mapEnemies = mobs;
    }

    @Override
    public void buildWorldTiles(BufferedImage[][] worldTiles) {
        this.worldTiles = worldTiles;
    }

    @Override
    public void buildEndMap(BufferedImage[][] endMap) {
        this.endMap = endMap;
    }
    public Map build(){
        return new Map(this.mapEnemies,this.mapNPC,this.worldTiles,this.endMap);
    }
}
