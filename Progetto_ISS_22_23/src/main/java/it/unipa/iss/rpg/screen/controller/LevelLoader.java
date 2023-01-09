package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.DAO.EntityDAOImpl;
import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.entitities.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelLoader {

    private final int scale;
    private final int maxRows;
    private final int maxCols;

    public LevelLoader(int scale, int maxRows, int maxCols) {
        this.scale = scale;
        this.maxRows = maxRows;
        this.maxCols = maxCols;
    }
    
    public Level loadLevel() {
        MapBuilder firstMapBuilder = new MapBuilder();
        MapBuilder secondMapBuilder = new MapBuilder();

        //costruzione bordi prima mappa
        firstMapBuilder.buildWorldTiles(maxRows, maxCols);
        firstMapBuilder.buildMapNpc(maxRows, maxCols);
        firstMapBuilder.buildMapEnemies(maxRows, maxCols);
        firstMapBuilder.buildEndMap(maxRows, maxCols);

        //costruzione bordi seconda mappa
        secondMapBuilder.buildWorldTiles(maxRows, maxCols);
        secondMapBuilder.buildMapNpc(maxRows, maxCols);
        secondMapBuilder.buildMapEnemies(maxRows, maxCols);
        secondMapBuilder.buildEndMap(maxRows, maxCols);

        File firstMap = new File("src/res/world/level_start/map.txt");
        File secondMap = new File("src/res/world/level_1/map.txt");
        File firstMapEnemies = new File("src/res/world/level_start/enemies/enemies.txt");
        File secondMapEnemies = new File("src/res/world/level_1/enemies/enemies.txt");

        try {
            FileInputStream firstStream = new FileInputStream(firstMapEnemies);
            FileInputStream secondStream = new FileInputStream(secondMapEnemies);

            Scanner s = new Scanner(firstMap);
            Scanner w = new Scanner(secondMap);

            //caricamento da file della mappa
            for (int i = 0; i < maxRows; i++) {
                for (int j = 0; j < maxCols; j++) {
                    firstMapBuilder.addWorldTile(ImageIO.read(new File("src/res/world/level_start/world/" + s.nextInt() + ".png")), i, j);
                    secondMapBuilder.addWorldTile(ImageIO.read(new File("src/res/world/level_1/world/" + w.nextInt() + ".png")), i, j);
                }
            }

            //caricamento mob database
            Mob spider = EntityDAOImpl.getDbInstance().getEnemyById("001");
            Mob wolf = EntityDAOImpl.getDbInstance().getEnemyById("002");

            Mob spider2 = EntityDAOImpl.getDbInstance().getEnemyById("003");
            Mob wolf2 = EntityDAOImpl.getDbInstance().getEnemyById("004");

            spider.getMobSprite().addSprite(new Tile(ImageIO.read(new File(spider.getMobSprite().getSpritesPath().get(0)))));
            wolf.getMobSprite().addSprite(new Tile(ImageIO.read(new File(wolf.getMobSprite().getSpritesPath().get(0)))));
            spider2.getMobSprite().addSprite(new Tile(ImageIO.read(new File(spider2.getMobSprite().getSpritesPath().get(0)))));
            wolf2.getMobSprite().addSprite(new Tile(ImageIO.read(new File(wolf.getMobSprite().getSpritesPath().get(0)))));

            firstMapBuilder.addMob(spider, spider.getMobSprite().getWorldX(), spider.getMobSprite().getWorldY());
            firstMapBuilder.addMob(spider2, spider2.getMobSprite().getWorldX(), spider2.getMobSprite().getWorldY());
            firstMapBuilder.addMob(wolf, wolf.getMobSprite().getWorldX(), wolf.getMobSprite().getWorldY());
            firstMapBuilder.addMob(wolf2, wolf2.getMobSprite().getWorldX(), wolf2.getMobSprite().getWorldY());

            secondMapBuilder.addMob(spider, 0, 7);
            secondMapBuilder.addMob(spider2, 4, 7);
            secondMapBuilder.addMob(wolf, 4, 6);
            secondMapBuilder.addMob(wolf, 4, 5);

            //TODO: refactoring
            Npc bob = EntityDAOImpl.getDbInstance().getNpcById("001");
            bob.getNpcSprite().addSprite(new Tile(ImageIO.read(new File(bob.getNpcSprite().getSpritesPath().get(0)))));

            Npc agar = EntityDAOImpl.getDbInstance().getNpcById("002");
            agar.getNpcSprite().addSprite(new Tile(ImageIO.read(new File(agar.getNpcSprite().getSpritesPath().get(0)))));

            firstMapBuilder.addNpc(bob, bob.getNpcSprite().getWorldX(), bob.getNpcSprite().getWorldY());
            secondMapBuilder.addNpc(agar, agar.getNpcSprite().getWorldX(), agar.getNpcSprite().getWorldY());

            firstMapBuilder.addEndTile(0, 5);
            firstMapBuilder.addEndTile(1, 5);
            ArrayList<Map> maps = new ArrayList<>();
            maps.add(firstMapBuilder.build());
            maps.add(secondMapBuilder.build());

            //TODO: caricare seconda mappa
            Level level = new Level(maps);

            s.close();
            firstStream.close();
            secondStream.close();

            return level;
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }


    public void loadPlayer(Player p) {
        try{
            p.getPlayerSprite().addSprite(new Tile(ImageIO.read(new File(p.getPlayerSprite().getSpritesPath().get(0)))));
            p.getPlayerSprite().addSprite(new Tile(ImageIO.read(new File(p.getPlayerSprite().getSpritesPath().get(1)))));
            p.getPlayerSprite().addSprite(new Tile(ImageIO.read(new File(p.getPlayerSprite().getSpritesPath().get(2)))));
            p.getPlayerSprite().addSprite(new Tile(ImageIO.read(new File(p.getPlayerSprite().getSpritesPath().get(3)))));

            p.getPlayerSprite().setDirectionImage(EventType.MOVED_DOWN);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
