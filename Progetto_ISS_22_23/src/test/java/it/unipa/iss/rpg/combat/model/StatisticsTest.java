package it.unipa.iss.rpg.combat.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StatisticsTest {

    @BeforeEach
    void setUp() {
    }


    @AfterEach
    void tearDown() {
    }
    @Test
    void shouldICreate(){
        Statistics stat = new Statistics();
        assertEquals(-1,stat.getAtk());
        assertEquals(-1,stat.getHp());
        assertEquals(-1,stat.getStamina());
        assertEquals(-1,stat.getDef());


    }




    @Test
    void testClone() {
    }

    @Test
    void attack() {
    }

}