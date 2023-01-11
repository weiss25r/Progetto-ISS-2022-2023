package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Npc;

import java.awt.image.BufferedImage;

public class Map {
   private Mob[][] mapEnemies;
   private Npc[][] mapNpc;
   private BufferedImage[][] worldTiles;
   private boolean[][] endMap;

   /*
   public Map(Map map){
        this.mapEnemies = map.getMapEnemies();
        this.mapNpc = map.getNpc();
        this.worldTiles = map.getWorldTiles();
        this.endMap = map.getEndMap();
   }

    */

    public Map() {}
   public Map(Mob[][] mapEnemies, Npc[][] mapNpc,
              BufferedImage[][] worldTiles , boolean[][] endMap){
        this.mapEnemies = mapEnemies;
        this.mapNpc = mapNpc;
        this.worldTiles = worldTiles;
        this.endMap = endMap;
   }

    //Aggiunge un Mob

    //Rimuove un Mob
   public void removeMob(int x,int y){
        this.mapEnemies[x][y] = null;
    }
    // Aggiune un Npc
  
    //Rimuove un Npc
   public void removeNpc (int x, int y){
       this.mapNpc[x][y] = null;
    }
   public Npc getNpc(int x, int y){
        if(x >= 0 && y >= 0)
            return  this.mapNpc[x][y];
        else return null;
    }
   //Restituisce un singolo nemico
   public Mob getEnemy(int x,int y){
        if(x >= 0 && y >= 0)
            return this.mapEnemies[x][y];
        else return null;
    }

   public BufferedImage getTile(int x, int y) {
        if(x >= 0 && y >= 0)
            return this.worldTiles[x][y];
        else return null;
    }

   //Restituisce la griglia dei nemici
   public Mob[][] getMapEnemies(){
        return this.mapEnemies;
    }
   //Il player e' giunto a fine della mappa, si deve confrontare con il sistema di collisioni
   //per passare alla prossima mappa
   public boolean[][] getEndMap(){
        return this.endMap;
    }

   public BufferedImage[][] getWorldTiles(){ return  this.worldTiles;}

    public boolean getEndMap(int x, int y) {
        if(x >= 0 && y >= 0)
            return this.endMap[x][y];
        return false;
    }
}
