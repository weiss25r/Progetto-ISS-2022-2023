package it.unipa.iss.rpg.screen.controller;

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
    void loadMapTest() {
        assertTrue(controller.loadMap());
    }
}