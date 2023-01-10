package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
    void testMove() {
        p.move(EventType.MOVED_DOWN);
        assertEquals(130, p.getPlayerSprite().getWorldY());
        p.move(EventType.MOVED_UP);
        assertEquals(120, p.getPlayerSprite().getWorldY());
        p.move(EventType.MOVED_RIGHT);
        assertEquals(110, p.getPlayerSprite().getWorldX());
        p.move(EventType.MOVED_LEFT);
        assertEquals(100, p.getPlayerSprite().getWorldX());
    }
}