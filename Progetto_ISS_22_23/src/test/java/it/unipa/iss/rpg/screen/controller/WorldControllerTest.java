package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldControllerTest {

    WorldController worldController;
    Player p;

    @BeforeEach
    void setUp() {
        p = new Player();
        worldController = new WorldController(p, new WorldPanel());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testUpdate() {
        this.worldController.update(EventType.MOVED_RIGHT);
        assertEquals(110, p.getPlayerSprite().getWorldX());

        this.worldController.update(EventType.MOVED_LEFT);
        assertEquals(100, p.getPlayerSprite().getWorldX());

        this.worldController.update(EventType.MOVED_DOWN);
        assertEquals(130, p.getPlayerSprite().getWorldY());

        this.worldController.update(EventType.MOVED_UP);
        assertEquals(120, p.getPlayerSprite().getWorldY());
    }

    @Test
    void testLoadWorldTiles() {
        assertTrue(this.worldController.loadWorldTiles());
    }
}