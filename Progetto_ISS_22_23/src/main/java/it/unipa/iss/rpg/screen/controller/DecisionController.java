package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.decision.Decision;
import it.unipa.iss.rpg.decision.DecisionLeaf;
import it.unipa.iss.rpg.decision.DecisionTree;

import java.util.LinkedList;
import java.util.List;

public class DecisionController {
    private DecisionTree decisionTree;
    private int treeNumber;

    public DecisionController( ) {
        treeNumber = -1;
        this.decisionTree = new DecisionTree();

        this.decisionTree.add(new DecisionTree());
        this.decisionTree.add(new DecisionTree());

        this.decisionTree.get(0).add(new DecisionLeaf(1));
        this.decisionTree.get(0).add(new DecisionLeaf(2));

        this.decisionTree.get(1).add(new DecisionLeaf(3));
        this.decisionTree.get(1).add(new DecisionLeaf(4));
    }

    public void updateDecisionTree(boolean value) {
        this.decisionTree.get(treeNumber).makeDecision(true);
    }
}
