package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelControllerTest {
    LevelController controller;
    @BeforeEach
    void setUp() {
        controller = new LevelController(new Player(), new WorldPanel());
    }

    @Test
    void testUpdate() {
        this.controller.update(EventType.MOVED_RIGHT);
        assertEquals(110, controller.getPlayer().getPlayerSprite().getWorldX());

        this.controller.update(EventType.MOVED_LEFT);
        assertEquals(100, controller.getPlayer().getPlayerSprite().getWorldX());

        this.controller.update(EventType.MOVED_DOWN);
        assertEquals(130, controller.getPlayer().getPlayerSprite().getWorldY());

        this.controller.update(EventType.MOVED_UP);
        assertEquals(120, controller.getPlayer().getPlayerSprite().getWorldY());
    }
}