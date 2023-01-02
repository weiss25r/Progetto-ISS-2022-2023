package it.unipa.iss.rpg.decision;

import java.util.Map.Entry;

public abstract class Decision {
    private boolean decisionMade;
    public abstract void add(Decision decision);
    public abstract void remove(Decision decision);
    public abstract DecisionEntry traverse();
    public boolean getDecisionValue(){
        return this.decisionMade;
    }
    public void makeDecision(boolean value) {
        this.decisionMade = value;
    }


}
