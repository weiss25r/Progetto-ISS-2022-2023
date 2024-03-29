package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Npc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

public class MapBuilder implements IMapBuilder {

    private Mob[][] mapEnemies;
    private Npc[][] mapNpc;
    private BufferedImage[][] worldTiles;
    private boolean[][] endMap;
    private int worldX, worldY;


    public MapBuilder() {

    }

    @Override
    public void reset() {
        this.mapEnemies = null;
        this.endMap = null;
        this.worldTiles = null;
        this.mapNpc = null;
    }

    public void setMapNpc(Npc[][] npc) {
        this.mapNpc = npc;
    }
    public void setMapMob(Mob[][] mobs) {
        this.mapEnemies = mobs;
    }
    public void setWorldTiles(BufferedImage[][] worldTiles) {
        this.worldTiles = worldTiles;
    }
    public void setEndMap(boolean[][] endMap) {
        this.endMap = endMap;
    }
    public Map build() {
        return new Map(this.mapEnemies, this.mapNpc, this.worldTiles, this.endMap);
    }

    @Override
    public void buildWorldTiles(int x, int y) {
        if (x > 0 && y > 0) {
            this.worldX = x;
            this.worldY = y;
            this.worldTiles = new BufferedImage[worldX][worldY];
        } else {
            System.out.print("Wrong Dimension");
        }
    }

    @Override
    public void buildEndMap(int x, int y) {
        if (x > 0 && y > 0) {
            if (x <= this.worldX && y <= this.worldY) {
                this.endMap = new boolean[worldX][worldY];
            }
        } else {
            System.out.print("Wrong Dimension");
        }
    }
    @Override
    public void buildMapEnemies(int x,int y){
        if (x > 0 && y > 0) {
            if (x <= this.worldX && y <= this.worldY) {
                this.mapEnemies = new Mob[worldX][worldY];
            }
        } else {
            System.out.print("Wrong Dimension");
        }
    }
    @Override
    public void buildMapNpc(int x,int y){
        if (x > 0 && y > 0) {
            if (x <= this.worldX && y <= this.worldY) {
                this.mapNpc = new Npc[worldX][worldY];
            }
        } else {
            System.out.print("Wrong Dimension");
        }
    }

    public void addMob(Mob enemy, int x, int y) {
        this.mapEnemies[x][y] = enemy;
    }

    public void addNpc(Npc npc, int x, int y) {
        this.mapNpc[x][y] = npc;
    }

    public void addWorldTile(BufferedImage tile,int x,int y){
        this.worldTiles[x][y] = tile;
    }

    public void addEndTile(int x, int y) {this.endMap[x][y] = true;}
}
