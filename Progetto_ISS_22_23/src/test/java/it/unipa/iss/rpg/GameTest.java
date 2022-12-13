package it.unipa.iss.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        this.game = new Game();
    }

    @Test
    void testGameStart() {
        this.game.startGame();
    }

    void testRun() {

    }

}