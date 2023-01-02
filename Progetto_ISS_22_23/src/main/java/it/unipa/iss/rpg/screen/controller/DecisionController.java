package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.decision.Decision;
import it.unipa.iss.rpg.decision.DecisionLeaf;
import it.unipa.iss.rpg.decision.DecisionTree;

import java.util.LinkedList;
import java.util.List;

public class DecisionController {
    private DecisionTree decisionTree;
    private Decision lastDecision;

    public DecisionController( ) {
        this.decisionTree = new DecisionTree();

        this.decisionTree.add(new DecisionTree());
        this.decisionTree.add(new DecisionTree());

        this.decisionTree.get(0).add(new DecisionLeaf(1));
        this.decisionTree.get(0).add(new DecisionLeaf(2));

        this.decisionTree.get(1).add(new DecisionLeaf(3));
        this.decisionTree.get(1).add(new DecisionLeaf(4));

        lastDecision = decisionTree;
    }

    public void updateDecisionTree(boolean value) {
        lastDecision.makeDecision(value);

        if(lastDecision instanceof DecisionTree) {
            lastDecision = value ? ((DecisionTree) lastDecision).get(0) : ((DecisionTree) lastDecision).get(1);
        }
    }

    public DecisionTree getDecisionTree() {
        return this.decisionTree;
    }
}
