package it.unipa.iss.rpg.combat.model;

/**Interface CombatHandler, provides all actions available during a fight
 * @author Bonura Giovanni*/
public interface CombatHandler {
    int cmdAttack();
    void gameOver();
}
