package it.unipa.iss.rpg.decision;

import java.util.HashMap;
import java.util.Map;

public class DecisionLeaf extends Decision{

    private final int leafNumber;

    public DecisionLeaf(int leafNumber) {
        this.leafNumber = leafNumber;
    }

    @Override
    public void add(Decision decision) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Decision decision) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public DecisionEntry traverse() {
        return new DecisionEntry(this.leafNumber, this.getDecisionValue());
    }

    public int getLeafNumber() {
        return this.leafNumber;
    }
}
