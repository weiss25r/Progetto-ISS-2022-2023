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

    /*@Test
    void testMove() {
        p.move(EventType.MOVED_DOWN);
        Assertions.assertEquals(4, p.getWorldY());
        p.move(EventType.MOVED_UP);
        Assertions.assertEquals(0, p.getWorldY());
        p.move(EventType.MOVED_RIGHT);
        Assertions.assertEquals(4, p.getWorldX());
        p.move(EventType.MOVED_LEFT);
        Assertions.assertEquals(0, p.getWorldX());
    }*/
}