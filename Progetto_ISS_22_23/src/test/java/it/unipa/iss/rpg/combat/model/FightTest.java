package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    Statistics stats = new Statistics();
    Player hero = new Player();
    Mob enemy = new Mob(stats);
    private Fight fight;

    @BeforeEach
    void setUp() throws CloneNotSupportedException {
        fight = new Fight(hero, enemy);
        assertNotNull(fight);
    }

    @AfterEach
    void tearDown() {
        fight = null;
        assertNull(fight);
    }

    @Test
    void cmdAttack() {
        assertEquals(75, fight.getHpHeroRemaining() - fight.cmdAttack(),
                "Considering boolean default value of myTurn variable");
    }

    @Test
    void inputAction() {
        do{
            fight.inputAction(1);
        }while(!fight.gameOverCheck());

        assertTrue(fight.gameOverCheck());
    }

    @Test
    public void getHpHeroRemaining(){
        assertEquals(100, fight.getHpHeroRemaining());
    }

    @Test
    public void getHpEnemyRemaining(){
        assertEquals(80, fight.getHpEnemyRemaining());
    }

    @Test
    public void gameOverCheck(){
        assertFalse(fight.gameOverCheck(), "We are considering default value of a boolean");
    }
}