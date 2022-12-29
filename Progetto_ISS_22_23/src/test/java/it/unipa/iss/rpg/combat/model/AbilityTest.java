package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbilityTest {
    AbilityBox skill;
    Statistics stats = new Statistics();
    Player hero = new Player();
    Mob enemy = new Mob(stats);
    Fight fight;
    private Ability ability;

    @BeforeEach
    void setUp() throws CloneNotSupportedException {
        ability = new Ability(skill);
        fight = new Fight(hero, enemy);
        assertNotNull(ability);
        assertNotNull(fight);
    }

    @AfterEach
    void tearDown() {
        ability = null;
        assertNull(ability);
        fight = null;
        assertNull(fight);
    }

    @Test
    void useAbility() {
        
    }

    @Test
    void showAbilities() {

    }
}