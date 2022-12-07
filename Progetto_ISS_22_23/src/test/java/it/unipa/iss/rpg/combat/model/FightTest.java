package it.unipa.iss.rpg.combat.model;

import org.junit.jupiter.api.*;

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

    @Test
    void cmdAttack() {
        assertEquals(91, fight.c1.getHp() - fight.cmdAttack(),
                "Considering boolean default value of myTurn variable");
    }

    @Test
    void inputAction() {

    }
}