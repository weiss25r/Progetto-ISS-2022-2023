package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.*;

class PlayerTest {
    private Player p;

    @BeforeEach
    void setUp() {
        p = new Player();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getInstance() {

    }

    @Test
    void testMove() {
        p.move(EventType.MOVED_DOWN);
        Assertions.assertEquals(130, p.getPlayerSprite().getWorldY());
        p.move(EventType.MOVED_UP);
        Assertions.assertEquals(120, p.getPlayerSprite().getWorldY());
        p.move(EventType.MOVED_RIGHT);
        Assertions.assertEquals(110, p.getPlayerSprite().getWorldX());
        p.move(EventType.MOVED_LEFT);
        Assertions.assertEquals(100, p.getPlayerSprite().getWorldX());
    }
}