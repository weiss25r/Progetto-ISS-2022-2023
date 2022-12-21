package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.combat.model.Statistics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StatisticsTest {
    private Statistics stats;
    private Statistics v;


    @BeforeEach
    void setUp() {
        //setting up a Statistic object to test the metod get
        stats = new Statistics(100,20,50,20);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testClone() {
        try{
             this.v = (Statistics) stats.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        assertTrue(this.v instanceof Statistics);
        assertEquals(stats.getHp(),v.getHp());
        assertEquals(stats.getStamina(),v.getStamina());
        assertEquals(stats.getDef(),v.getDef());
        assertEquals(stats.getAtk(),v.getAtk());
    }

}