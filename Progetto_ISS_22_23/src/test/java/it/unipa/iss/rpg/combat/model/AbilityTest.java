package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbilityTest {
    Statistics stats;
    Player hero;
    Mob enemy;

    @BeforeEach
    void setUp()  {
        stats = new Statistics(); assertNotNull(stats);
        hero = new Player(); assertNotNull(hero);
        enemy = new Mob(stats); assertNotNull(enemy);
    }

    @AfterEach
    void tearDown() {
        stats = null; assertNull(stats);
        hero = null; assertNull(hero);
        enemy = null; assertNull(enemy);
    }

    @Test
    void useAbility() {
        Ability skillType_1 = new Ability(AbilityBox.HEALING);
        Ability skillType_2 = new Ability(AbilityBox.STUDY_POWER);
        Ability skillType_3 = new Ability(AbilityBox.CORRUPTIVE_ATK);
        Ability skillType_4 = new Ability(AbilityBox.SINNER_ATK);

        skillType_1.useAbility(hero.getStats(), enemy.getStats());
        assertEquals(130, hero.getStats().getHp());

        skillType_2.useAbility(hero.getStats(), enemy.getStats());
        assertEquals(83, enemy.getStats().getHp());

        skillType_3.useAbility(hero.getStats(), enemy.getStats());
        assertEquals(65, enemy.getStats().getHp());

        skillType_4.useAbility(hero.getStats(), enemy.getStats());
        assertEquals(57, enemy.getStats().getHp());
    }
}