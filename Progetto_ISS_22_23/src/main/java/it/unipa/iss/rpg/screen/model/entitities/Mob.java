package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.combat.model.Statistics;

public class Mob implements Entity{
    private MobSprite mobSprite;
    private Statistics stats;

    public Mob(Statistics stats) {
        this.stats = new Statistics(80, 70, 0, 50);
    }

    public Mob(Statistics stats, MobSprite mobSprite) {
        this.stats = stats;
        this.mobSprite = mobSprite;
    }

    public Statistics getStats() {
        return new Statistics(stats.getHp(), stats.getDef(), stats.getStamina(), stats.getAtk());
    }

    public MobSprite getMobSprite() {
        return mobSprite;
    }
}
