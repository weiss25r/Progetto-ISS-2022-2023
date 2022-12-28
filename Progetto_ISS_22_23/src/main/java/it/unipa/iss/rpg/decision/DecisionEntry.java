package it.unipa.iss.rpg.decision;

public class DecisionEntry {
    private final int leafNumber;
    private final boolean decisionValue;

    public DecisionEntry(int leafNumber, boolean decisionValue) {
        this.leafNumber = leafNumber;
        this.decisionValue = decisionValue;
    }

    public int getLeafNumber() {
        return leafNumber;
    }

    public boolean getDecisionValue() {
        return decisionValue;
    }
}
