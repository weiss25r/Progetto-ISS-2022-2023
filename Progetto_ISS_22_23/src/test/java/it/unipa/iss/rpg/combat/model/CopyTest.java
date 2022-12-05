package it.unipa.iss.rpg.combat.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyTest {
    private Copy copy;
    private Copy copyClone;

    @BeforeEach
    void setUp() throws CloneNotSupportedException {
        copy = new Copy(70, 40, 30);
        copyClone = (Copy) copy.clone();
        assertNotNull(copy);
        assertNotNull(copyClone);
    }

    @AfterEach
    void tearDown() {
        copy = null;
        assertNull(copy);
        copyClone = null;
        assertNull(copyClone);
    }

    @Test
    void testClone() {
        Assertions.assertAll(() -> assertEquals(copy.getHp(), copyClone.getHp()),
                             () -> assertEquals(copy.getDefense(), copyClone.getDefense()),
                             () -> assertEquals(copy.getDamage(), copyClone.getDamage()),
                             () -> assertEquals(copy.hashCode(), copyClone.hashCode()));
    }
}