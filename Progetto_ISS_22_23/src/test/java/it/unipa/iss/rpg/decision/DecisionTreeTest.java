package it.unipa.iss.rpg.decision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionTreeTest {
    private DecisionTree decisionTree;

    @BeforeEach
    void setUp() {
        this.decisionTree = new DecisionTree();
    }

    @Test
    void traverseTest() {
        DecisionLeaf one = new DecisionLeaf(1);
        one.makeDecision(true);
        DecisionLeaf two = new DecisionLeaf(2);
        two.makeDecision(false);

        DecisionLeaf three = new DecisionLeaf(3);
        DecisionLeaf four = new DecisionLeaf(4);

        decisionTree.add(one);
        decisionTree.add(two);

        three.makeDecision(true);
        four.makeDecision(false);

        decisionTree.makeDecision(true);

        DecisionEntry decisionEntry = decisionTree.traverse();

        assertEquals(1, decisionEntry.getLeafNumber());

        // ------------------------------------------------------------

        this.decisionTree = new DecisionTree();

        DecisionTree treeO = new DecisionTree();
        DecisionTree treeT = new DecisionTree();

        treeO.add(one);
        treeO.add(two);

        treeT.add(three);
        treeT.add(four);

        treeO.makeDecision(true);

        decisionTree.add(treeO);
        decisionTree.add(treeT);
        decisionTree.makeDecision(true);

        decisionEntry = decisionTree.traverse();
        assertEquals(1, decisionEntry.getLeafNumber());
        assertTrue(decisionEntry.getDecisionValue());


        decisionTree.makeDecision(false);

        decisionEntry = decisionTree.traverse();

        assertEquals(4, decisionEntry.getLeafNumber());
    }
}
