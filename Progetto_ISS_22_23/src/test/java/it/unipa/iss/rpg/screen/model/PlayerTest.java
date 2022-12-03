package it.unipa.iss.rpg.screen.model;

import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

class PlayerTest {
    Player p;

    @BeforeEach
    void setUp() {
        p = Player.getInstance();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getInstance() {

    }

    @Test
    void testMove() {
        p.move(Direction.DOWN);
        Assertions.assertEquals(4, p.getWorldY());
        p.move(Direction.UP);
        Assertions.assertEquals(0, p.getWorldY());
        p.move(Direction.RIGHT);
        Assertions.assertEquals(4, p.getWorldX());
        p.move(Direction.LEFT);
        Assertions.assertEquals(0, p.getWorldX());
    }
}