package it.unipa.iss.rpg.combat.model;

public class Ability {
    AbilityBox skill;

    public Ability(AbilityBox skill){
        this.skill = skill;
    }

    public void useAbility(Statistics hero, Statistics enemy){
        switch(skill){
            case HEALING:
                if(hero.getHp() <= 50){
                    hero.setHp(hero.getHp() + 30);
                }
                break;

            case STUDY_POWER:
                enemy.setHp((hero.getAtk() - (enemy.getDef()/2)/2));
                hero.setDef(hero.getDef() + 5);
                break;

            case CORRUPTIVE_ATK:
                enemy.setHp((hero.getAtk() * (hero.getStamina()/2)/100));
                hero.setStamina(hero.getStamina() - 15);
                break;

            case SINNER_ATK:
                enemy.setHp((hero.getAtk() * hero.getDef())/enemy.getDef()+10);
                hero.setStamina(hero.getStamina() - 10);
                hero.setDef(hero.getDef() - 10);
                hero.setAtk(hero.getAtk() - 5);
                break;
        }
    }
}
