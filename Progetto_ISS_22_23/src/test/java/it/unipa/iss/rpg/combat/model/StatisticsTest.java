package it.unipa.iss.rpg.combat.model;

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
            System.out.println("Error clone");
        }
        assertTrue(this.v instanceof Statistics);
    }

    @Test
    void attack() {
    }

    @Test
    void setHp() {
    }

    @Test
    void setDef() {
    }

    @Test
    void setStamina() {
    }

    @Test
    void setAtk() {
    }

    @Test
    void getHp() {
        assertEquals(100,stats.getHp());
    }

    @Test
    void getDef() {
        assertEquals(20,stats.getDef());
    }

    @Test
    void getStamina() {
        assertEquals(50,stats.getStamina());
    }

    @Test
    void getAtk() {
        assertEquals(20,stats.getAtk());
    }
}