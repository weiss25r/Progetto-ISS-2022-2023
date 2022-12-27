package it.unipa.iss.rpg.decision;

public abstract class Decision {
    public abstract void makeDecision(boolean value);
    public abstract void add(Decision decision);
    public abstract void remove(Decision decision);
    public abstract void traverse();
}
