package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.combat.model.Statistics;

public class Mob {
    private MobSprite mobSprite;
    private Statistics stats;

    public Mob(Statistics stats, MobSprite mobSprite) {
        this.stats = stats;
        this.mobSprite = mobSprite;
    }

    public Mob(Statistics stats) {
        this.stats = new Statistics(80, 50, 100, 50);
    }

    public Statistics getStats() {
        return this.stats;
    }

    public MobSprite getMobSprite() {
        return mobSprite;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Mob enemy = (Mob) obj;

        return this.getStats().getHp() == enemy.getStats().getHp() && this.getStats().getDef() == enemy.getStats().getDef() &&
                this.getStats().getAtk() == enemy.getStats().getAtk() && this.getStats().getStamina() == enemy.getStats().getStamina() &&
                this.getMobSprite().getSpritesPath().equals(enemy.getMobSprite().getSpritesPath()) &&
                this.getMobSprite().getWorldX() == enemy.getMobSprite().getWorldX() && this.getMobSprite().getWorldY() == enemy.getMobSprite().getWorldY();
    }
}
