package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.DAO.EntityDAOImpl;
import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.entitities.*;

import javax.imageio.ImageIO;
import java.awt.*;
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
    
    public Level loadLevel(int levelNumber) {
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

            for (int i = 0; i < maxRows; i++) {
                for (int j = 0; j < maxCols; j++) {
                    firstMapBuilder.addWorldTile(ImageIO.read(new File("src/res/world/level_start/world/" + s.nextInt() + ".png")), i, j);
                    secondMapBuilder.addWorldTile(ImageIO.read(new File("src/res/world/level_1/world/" +w.nextInt() + ".png")), i, j);

                    char t = (char)firstStream.read();
                    char k = (char)secondStream.read();

                    if(Character.isDigit(t)) {
                        MobSprite firstMobSprite = new MobSprite(i*scale, j*scale);
                        firstMobSprite.addSprite(new Tile(ImageIO.read(new File("src/res/world/level_start/enemies/" + t + ".png"))));

                        //TODO: CARICAMENTO MOB DA DATABASE
                        Mob mob = new Mob(new Statistics(80, 80, 80, 80), firstMobSprite);
                        firstMapBuilder.addMob(mob, i, j);
                    }

                    if(Character.isDigit(k)) {
                        MobSprite secondMobSprite = new MobSprite(i*scale, j*scale);
                        secondMobSprite.addSprite(new Tile(ImageIO.read(new File("src/res/world/level_1/enemies/" + k + ".png"))));

                        Mob mob2 = new Mob(new Statistics(100, 40, 50, 60), secondMobSprite);
                        secondMapBuilder.addMob(mob2, i, j);
                    }
                }
            }

            //TODO: refactoring
            NPCSprite npcSprite = new NPCSprite(2* scale, 2* scale,"src/res/npc/bob.png");
            npcSprite.addSprite(new Tile(ImageIO.read(new File("src/res/npc/bob_down.png"))));

            Npc npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");
            firstMapBuilder.addNpc(npc, 2, 2);

            npcSprite = new NPCSprite(2* scale, 2* scale,"src/res/npc/agar.png");
            npcSprite.addSprite(new Tile(ImageIO.read(new File("src/res/npc/agar_down.png"))));
            npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");

            secondMapBuilder.addNpc(npc, 1, 3);

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
            Mob mob = EntityDAOImpl.getDbInstance().getEnemyById("001");


            //TODO: refactoring
            NPCSprite npcSprite = new NPCSprite(2* scale, 2* scale,"src/res/npc/bob.png");
            npcSprite.addSprite(new Tile(ImageIO.read(new File("src/res/npc/bob_down.png"))));

            Npc npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");
            firstMapBuilder.addNpc(npc, 2, 2);

            npcSprite = new NPCSprite(2* scale, 2* scale,"src/res/npc/agar.png");
            npcSprite.addSprite(new Tile(ImageIO.read(new File("src/res/npc/agar_down.png"))));
            npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");

            secondMapBuilder.addNpc(npc, 1, 3);

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
