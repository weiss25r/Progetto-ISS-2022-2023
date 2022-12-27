package it.unipa.iss.rpg.decision;

public class DecisionLeaf extends Decision{
    @Override
    public void makeDecision(boolean value) {

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
    public void traverse() {
    }
}
