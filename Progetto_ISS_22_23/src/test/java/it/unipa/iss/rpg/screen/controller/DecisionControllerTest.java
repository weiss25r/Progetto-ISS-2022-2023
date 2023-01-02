package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.decision.Decision;
import it.unipa.iss.rpg.decision.DecisionEntry;
import it.unipa.iss.rpg.decision.DecisionTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DecisionControllerTest {
    DecisionController controller;

    @BeforeEach
    void setUp() {
        controller = new DecisionController();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateDecisionTreeTest() {
        controller.updateDecisionTree(true);
        controller.updateDecisionTree(true);
        controller.updateDecisionTree(true);

        DecisionEntry entry = controller.getDecisionTree().traverse();

        assertEquals(1, entry.getLeafNumber());
        assertTrue(entry.getDecisionValue());
    }
}