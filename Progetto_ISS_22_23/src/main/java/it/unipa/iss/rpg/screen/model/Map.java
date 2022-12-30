package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.NPC;

import java.awt.image.BufferedImage;

public class Map {
   private Mob[][] mapEnemies;
   private NPC[][] mapNPC;
   private BufferedImage[][] worldTiles;
   private  BufferedImage[][] endMap;

   public Map(Map map){
        this.mapEnemies = map.getMapEnemies();
        this.mapNPC = map.getNpc();
        this.worldTiles = map.getWorldTiles();
        this.endMap = map.getEndMap();
   }
   public Map(Mob[][] mapEnemies, NPC[][] mapNPC,
              BufferedImage[][] worldTiles , BufferedImage[][] endMap){
        this.mapEnemies = mapEnemies;
        this.mapNPC = mapNPC;
        this.worldTiles = worldTiles;
        this.endMap = endMap;
   }
    //Aggiunge un Mob
   public void addMob(Mob enemy,int x,int y){
        this.mapEnemies[x][y] = enemy;
    }
    //Rimuove un Mob
   public void removeMob(Mob enemy,int x,int y){
        this.mapEnemies[x][y] = null;
    }
    // Aggiune un Npc
   public void addNpc (NPC npc, int x, int y){
        this.mapNPC[x][y] = npc;
    }
    //Rimuove un Npc
   public void removeNpc (NPC npc, int x, int y){
       this.mapNPC[x][y] = null;
    }
   public NPC[][] getNpc(){
        return  this.mapNPC;
    }
    //Restituisce un singolo nemico
   public Mob getEnemy(int x,int y){
        return this.mapEnemies[x][y];
    }
    //Restituisce la griglia dei nemici
   public Mob[][] getMapEnemies(){
        return this.mapEnemies;
    }
    //Il player e' giunto a fine della mappa, si deve confrontare con il sistema di collisioni
    //per passare alla prossima mappa
   public BufferedImage[][] getEndMap(){
        return this.endMap;
    }

   public BufferedImage[][] getWorldTiles(){ return  this.worldTiles;}
}
