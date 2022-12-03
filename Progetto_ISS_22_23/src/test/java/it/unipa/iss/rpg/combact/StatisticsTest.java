package it.unipa.iss.rpg.combact;

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
        assertEquals(-1,stat.getMaxHp());
        assertEquals(-1,stat.getStamina());
        assertEquals(-1,stat.getDef());
        assertNotNull(stat.clone());

    }



    @Test
    void getMaxHp() {
    }

    @Test
    void getDef() {
    }

    @Test
    void getStamina() {
    }

    @Test
    void getAtk() {
    }

    @Test
    void testClone() {
    }

    @Test
    void attack() {
    }

}