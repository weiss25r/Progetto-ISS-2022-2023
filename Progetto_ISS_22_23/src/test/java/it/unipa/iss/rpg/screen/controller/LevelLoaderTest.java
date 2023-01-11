package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.DAO.EntityDAOImpl;
import it.unipa.iss.rpg.screen.model.Level;
import it.unipa.iss.rpg.screen.model.Map;
import it.unipa.iss.rpg.screen.model.MapBuilder;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.NPCSprite;
import it.unipa.iss.rpg.screen.model.entitities.Npc;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LevelLoaderTest {
    Player player;
    Level level;

    @BeforeEach
    void setUp() {
        MapBuilder firstMapBuilder = new MapBuilder();
        MapBuilder secondMapBuilder = new MapBuilder();

        //costruzione bordi prima mappa
        firstMapBuilder.buildWorldTiles(6, 8);
        firstMapBuilder.buildMapNpc(6, 8);
        firstMapBuilder.buildMapEnemies(6, 8);
        firstMapBuilder.buildEndMap(6, 8);

        //costruzione bordi seconda mappa
        secondMapBuilder.buildWorldTiles(6, 8);
        secondMapBuilder.buildMapNpc(6, 8);
        secondMapBuilder.buildMapEnemies(6, 8);
        secondMapBuilder.buildEndMap(6, 8);

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
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 8; j++) {
                    firstMapBuilder.addWorldTile(ImageIO.read(new File("src/res/world/level_start/world/" + s.nextInt() + ".png")), i, j);
                    secondMapBuilder.addWorldTile(ImageIO.read(new File("src/res/world/level_1/world/" + w.nextInt() + ".png")), i, j);
                }
            }

            //caricamento mob database
            Mob mob = EntityDAOImpl.getDbInstance().getEnemyById("001");

            //TODO: refactoring
            NPCSprite npcSprite = new NPCSprite(2* 96, 2* 96,"src/res/npc/bob.png");
            npcSprite.addSprite(ImageIO.read(new File("src/res/npc/bob_down.png")));

            Npc npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");
            firstMapBuilder.addNpc(npc, 2, 2);

            npcSprite = new NPCSprite(2* 96, 2* 96,"src/res/npc/agar.png");
            npcSprite.addSprite((ImageIO.read(new File("src/res/npc/agar_down.png"))));
            npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");

            secondMapBuilder.addNpc(npc, 1, 3);

            firstMapBuilder.addEndTile(0, 5);
            firstMapBuilder.addEndTile(1, 5);
            ArrayList<Map> maps = new ArrayList<>();
            maps.add(firstMapBuilder.build());
            maps.add(secondMapBuilder.build());

            //TODO: caricare seconda mappa
            level = new Level(maps);

            s.close();
            firstStream.close();
            secondStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    void loadLevelTest() {
        assertEquals(new );
    }

    @Test
    void loadPlayer() {

    }
}