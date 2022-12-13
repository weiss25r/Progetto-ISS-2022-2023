package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldControllerTest {

    WorldController worldController;
    Player p;

    @BeforeEach
    void setUp() {
        p = new Player();
        worldController = new WorldController(p, (WorldPanel) Screen.getIstance().getGamePanel());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void drawPlayer() {

    }

    @Test
    void testDrawPlayer() {

    }

    @Test
    void testUpdate() {
        this.worldController.update(EventType.MOVED_RIGHT);
        assertEquals(p.getWorldX(), 4);

        this.worldController.update(EventType.MOVED_LEFT);
        assertEquals(p.getWorldX(), 0);

        this.worldController.update(EventType.MOVED_DOWN);
        assertEquals(p.getWorldY(), 4);

        this.worldController.update(EventType.MOVED_UP);
        assertEquals(p.getWorldY(), 0);
    }
}