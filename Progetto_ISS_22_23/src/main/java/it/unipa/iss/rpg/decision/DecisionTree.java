package it.unipa.iss.rpg.decision;

import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.List;

public class DecisionTree extends Decision{
    private List<Decision> decisions;

    public DecisionTree() {
        this.decisions = new LinkedList<>();
    }

    @Override
    public void makeDecision(boolean value) {
        if(value) {
            this.decisions.get(0).setDecisionValue(true);
        }
        else {
            this.decisions.get(1).setDecisionValue(true);
        }
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
    public Decision traverse() {

        //TODO: refactoring...
        Decision d = decisions.get(0).getDecisionValue() ? decisions.get(0) : decisions.get(1);

        if(d instanceof DecisionLeaf)
            return d;
        else return d.traverse();

        /*
        for (Decision d : decisions) {
            if(d.traverse() instanceof DecisionLeaf && d.traverse().getDecisionValue()) {
                ret = d;
                break;
            }
        }

         */
    }
}
