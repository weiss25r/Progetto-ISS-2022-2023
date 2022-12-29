package it.unipa.iss.rpg.decision;

import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.List;

public class DecisionTree extends Decision{
    private List<Decision> decisions;
    private boolean direction;

    public DecisionTree() {
        this.decisions = new LinkedList<>();
    }

    @Override
    public void makeDecision(boolean value) {
        this.direction = value;
    }

    @Override
    public void add(Decision decision) {
        this.decisions.add(decision);
    }

    @Override
    public void remove(Decision decision) {
        this.decisions.remove(decision);

    }

    @Override
    public DecisionEntry traverse() {
        Decision d = direction ? decisions.get(0) : decisions.get(1);

        if(d instanceof DecisionLeaf)
            return d.traverse();
        else return d.traverse();
    }
}