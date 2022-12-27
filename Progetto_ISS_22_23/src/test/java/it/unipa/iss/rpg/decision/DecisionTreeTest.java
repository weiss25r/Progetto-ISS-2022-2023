package it.unipa.iss.rpg.decision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecisionTreeTest {
    private DecisionTree decisionTree;

    @BeforeEach
    void setUp() {
        this.decisionTree = new DecisionTree();
    }

    @Test
    void traverseTest() {
        this.decisionTree.add(new DecisionTree());
        this.decisionTree.add(new DecisionTree());

        /*
        Decision decision = this.decisionTree.traverse();
        if(decision instanceof DecisionLeaf) {
            decision = (DecisionLeaf)decision;
            System.out.printf("Leaf %d\n", decision.getLeafNumber());
        }
        
         */
    }
}
