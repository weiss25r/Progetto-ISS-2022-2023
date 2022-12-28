package it.unipa.iss.rpg.decision;

public class DecisionLeaf extends Decision{

    private final int leafNumber;

    public DecisionLeaf(int leafNumber) {
        this.leafNumber = leafNumber;
    }

    @Override
    public void makeDecision(boolean value) {
        this.setDecisionValue(value);
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
    public Decision traverse() {
        return this;
    }

    public int getLeafNumber() {
        return this.leafNumber;
    }
}
