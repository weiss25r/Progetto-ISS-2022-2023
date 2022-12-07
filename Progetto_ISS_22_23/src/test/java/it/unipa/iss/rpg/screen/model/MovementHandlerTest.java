package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.*;
import it.unipa.iss.rpg.screen.controller.*;

class MovementHandlerTest {
    WorldMapController controller;
    boolean attached = false;

    @BeforeEach
    void setUp() {
        controller = new WorldMapController(Player.getInstance(), new WorldPanel());
        testAttach();
    }

    @AfterEach
    void tearDown() {
        testAttach();
    }

    @Test
    void testAttach() {
        attached = true;
    }

    @Test
    void testDetach() {
        attached = false;
    }

    @Test
    void testKeyTyped() {

    }

    @Test
    void testKeyPressed() {

    }

    @Test
    void testKeyReleased() {

    }
}