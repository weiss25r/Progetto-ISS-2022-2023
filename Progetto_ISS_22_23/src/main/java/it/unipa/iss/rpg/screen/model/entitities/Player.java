package it.unipa.iss.rpg.screen.model.entitities;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.EventType;

public class Player {
    private Statistics stats;
    private PlayerSprite playerSprite;
    private final int movementSpeed;

    public Player() {
        this.movementSpeed = 10;
        this.playerSprite = new PlayerSprite();
        this.stats = new Statistics(100, 50, 100, 70);
    }

    public Player(Statistics stats, PlayerSprite playerSprite) {
        this.movementSpeed = 10;
        this.playerSprite = playerSprite;
        this.stats = stats;
    }

    public void move(EventType e) {
        switch (e) {
            case MOVED_DOWN -> {
                this.playerSprite.setWorldY(playerSprite.getWorldY() + this.movementSpeed);
            }
            case MOVED_UP -> {
                this.playerSprite.setWorldY(playerSprite.getWorldY() - this.movementSpeed);
            }
            case MOVED_LEFT -> {
                this.playerSprite.setWorldX(playerSprite.getWorldX() - this.movementSpeed);
            }
            case MOVED_RIGHT -> {
                this.playerSprite.setWorldX(playerSprite.getWorldX() + this.movementSpeed);
            }
        }

        playerSprite.setDirectionImage(e);
    }

    public PlayerSprite getPlayerSprite() {
        return playerSprite;
    }


    public Statistics getStats() {
        return this.stats;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Player hero = (Player) obj;

        return this.getStats().getHp() == hero.getStats().getHp() && this.getStats().getDef() == hero.getStats().getDef() &&
                this.getStats().getAtk() == hero.getStats().getAtk() && this.getStats().getStamina() == hero.getStats().getStamina() &&
                this.getPlayerSprite().getSpritesPath().equals(hero.getPlayerSprite().getSpritesPath()) &&
                this.getPlayerSprite().getWorldX() == hero.getPlayerSprite().getWorldX() && this.getPlayerSprite().getWorldY() == hero.getPlayerSprite().getWorldY();
    }
}
