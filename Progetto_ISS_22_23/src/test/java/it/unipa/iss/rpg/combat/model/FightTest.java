package it.unipa.iss.rpg.combat.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    private Fight fight;

    @BeforeEach
    void setUp() throws CloneNotSupportedException {
        fight = new Fight();
        assertNotNull(fight);
    }

    @AfterEach
    void tearDown() {
        fight = null;
        assertNull(fight);
    }

    @Disabled
    void cmdAttack() {
        assertEquals(91, fight.c1.getHp() - fight.cmdAttack(),
                "Considering boolean default value of myTurn variable");
    }

    @Disabled
    void gameOver() {
    }

    @Disabled
    void getNextPlayer() {
    }

    @Disabled
    void checkHp() {
    }

    @Disabled
    void inputAction() {
    }
}