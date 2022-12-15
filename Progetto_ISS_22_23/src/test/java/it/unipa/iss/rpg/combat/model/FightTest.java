package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    Statistics s1 = new Statistics(100, 50, 0, 70);
    Statistics s2 = new Statistics(80, 70, 0, 50);
    Player hero = new Player();
    Mob enemy = new Mob(s2);
    private Fight fight;

    @BeforeEach
    void setUp() throws CloneNotSupportedException {
        Fight fight = new Fight(hero, enemy);
        assertNotNull(fight);
    }

    @AfterEach
    void tearDown() {
        fight = null;
        assertNull(fight);
    }

    /*@Test
    void cmdAttack() {
        assertEquals(91, fight.hero.getHp() - fight.cmdAttack(),
                "Considering boolean default value of myTurn variable");
    }
    */


    @Disabled
    void inputAction() {

    }
}