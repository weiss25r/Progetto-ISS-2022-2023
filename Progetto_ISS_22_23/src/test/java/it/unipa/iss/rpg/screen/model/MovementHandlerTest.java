package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.view.GamePanel;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.*;
import it.unipa.iss.rpg.screen.controller.*;

import java.awt.event.KeyEvent;
import java.security.Key;

class MovementHandlerTest {
    MovementHandler movementHandler;
    @BeforeEach
    void setUp() {
        this.movementHandler = new MovementHandler();
    }

    @AfterEach
    void tearDown() {
        testAttach();
    }

    @Test
    void testAttach() {

    }

    @Test
    void testDetach() {

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