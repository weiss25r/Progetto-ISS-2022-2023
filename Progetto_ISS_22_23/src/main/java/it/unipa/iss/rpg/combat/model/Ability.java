package it.unipa.iss.rpg.combat.model;

/**Class Ability, includes all available abilities during a fight
 * @author Bonura Giovanni*/

public class Ability {
    private AbilityBox skill;

    /**Constructor with an enum parameter*/
    public Ability(AbilityBox skill){
        this.skill = skill;
    }

    /**Method contains implementation of abilities' effect*/
    public void useAbility(Statistics hero, Statistics enemy){
        switch(skill){
            case HEALING:
                if(hero.getHp() <= 50){
                    hero.setHp(hero.getHp() + 30);
                    Fight.myTurn = false;
                }
                break;

            case STUDY_POWER:
                enemy.setHp(enemy.getHp() - ((hero.getAtk() - (enemy.getDef()/2))/2));
                hero.setDef(hero.getDef() + 5);
                Fight.myTurn = false;
                break;

            case CORRUPTIVE_ATK:
                enemy.setHp(enemy.getHp() - ((hero.getAtk() * (hero.getStamina() / 2) / 100)));
                hero.setStamina(hero.getStamina() - 15);
                Fight.myTurn = false;
                break;

            case SINNER_ATK:
                enemy.setHp(enemy.getHp() - ((hero.getAtk() * hero.getDef())/(enemy.getDef()+10)));
                hero.setStamina(hero.getStamina() - 10);
                hero.setDef(hero.getDef() - 10);
                hero.setAtk(hero.getAtk() - 5);
                Fight.myTurn = false;
                break;
        }
    }
}
