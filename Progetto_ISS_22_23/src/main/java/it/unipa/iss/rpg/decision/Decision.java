package it.unipa.iss.rpg.decision;

public abstract class Decision {
    private boolean decisionMade;
    public abstract void makeDecision(boolean value);
    public abstract void add(Decision decision);
    public abstract void remove(Decision decision);
    public abstract Decision traverse();

    public boolean getDecisionValue(){
        return this.decisionMade;
    }

    public void setDecisionValue(boolean value) {
        this.decisionMade = value;
    }
}
