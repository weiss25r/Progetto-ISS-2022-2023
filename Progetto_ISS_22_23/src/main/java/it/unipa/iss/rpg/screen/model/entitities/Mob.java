package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.combat.model.Statistics;

public class Mob implements Entity{
    private MobSprite mobSprite;
    private Statistics stats;

    public Mob(Statistics stats, MobSprite mobSprite) {
        this.stats = stats;
        this.mobSprite = mobSprite;
    }

    public Statistics getStats() {
        return this.stats;
    }

    public MobSprite getMobSprite() {
        return mobSprite;
    }
}
