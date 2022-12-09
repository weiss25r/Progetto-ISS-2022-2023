package it.unipa.iss.rpg;

import it.unipa.iss.rpg.screen.model.Player;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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