package it.unipa.iss.rpg.DAO;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.entitities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntityDAOImplTest {
    Player player = null;
    Mob mob = null;
    Npc npc = null;
    Statistics statsHero, statsEnemy;
    PlayerSprite ps;
    MobSprite ms;
    NPCSprite ns;

    @BeforeEach
    void setUp() {
        statsHero = new Statistics(100, 60,100, 40);
        ps = new PlayerSprite(100, 120);
        ArrayList<String> pathsHero = new ArrayList<>();
        pathsHero.add("src/res/character/move/down/char_down_00.png");
        pathsHero.add("src/res/character/move/up/char_up_00.png");
        pathsHero.add("src/res/character/move/left/char_left_00.png");
        pathsHero.add("src/res/character/move/right/char_right_00.png");
        ps.setSpritesPath(pathsHero);
        player = new Player(statsHero, ps);
        assertNotNull(player);

        statsEnemy = new Statistics(80, 50, 100, 50);
        ms = new MobSprite(3, 0);
        ArrayList<String> pathsEnemy = new ArrayList<>();
        pathsEnemy.add("src/res/world/level_start/enemies/0.png");
        ms.setSpritesPath(pathsEnemy);
        mob = new Mob(statsEnemy, ms);
        assertNotNull(mob);

        ArrayList<String> pathsNpc = new ArrayList<>();
        pathsNpc.add("src/res/npc/bob_down.png");
        ns = new NPCSprite(2, 2, "src/res/npc/bob.png");
        ns.setSpritesPath(pathsNpc);
        String dialog = "Ehi tu, per favore aiutami, non capisco dove siamo, chi sono quelli?\n" +
                "E soprattutto cosa sono!?\n" +
                "Se mi proteggi posso darti le chiavi della struttura qui alle nostre spalle.";
        String option1 = "Va bene";
        String option2 = "Devo già badare a me";
        npc = new Npc(ns, dialog, option1, option2);
        assertNotNull(npc);
    }

    @AfterEach
    void tearDown() {
        player = null; assertNull(player);
        mob = null; assertNull(mob);
        npc = null; assertNull(npc);
    }

    @Test
    void getHeroById() {
        EntityDAOImpl test = EntityDAOImpl.getDbInstance();

        assertEquals(player, test.getHeroById("001"));
    }

    @Test
    void getEnemyById() {
        EntityDAOImpl test = EntityDAOImpl.getDbInstance();

        assertEquals(mob, test.getEnemyById("001"));
    }

    @Test
    void getNpcById() {
        EntityDAOImpl test = EntityDAOImpl.getDbInstance();

        assertEquals(npc, test.getNpcById("001"));
    }
}