package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.Player;
import it.unipa.iss.rpg.screen.view.GamePanel;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldMapControllerTest {

    WorldMapController worldMapController;

    @BeforeEach
    void setUp() {
        worldMapController = new WorldMapController(Player.getInstance(), (WorldPanel) Screen.getIstance().getGamePanel());
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
        this.worldMapController.update(EventType.MOVED_RIGHT);
        assertEquals(Player.getInstance().getWorldX(), 4);

        this.worldMapController.update(EventType.MOVED_LEFT);
        assertEquals(Player.getInstance().getWorldX(), 0);

        this.worldMapController.update(EventType.MOVED_DOWN);
        assertEquals(Player.getInstance().getWorldY(), 4);

        this.worldMapController.update(EventType.MOVED_UP);
        assertEquals(Player.getInstance().getWorldY(), 0);
    }
}