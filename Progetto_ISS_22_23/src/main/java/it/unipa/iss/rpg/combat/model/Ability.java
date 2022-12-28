package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;

public class Ability {
    AbilityBox skill;
    Statistics hero;
    Statistics enemy;

    public Ability(AbilityBox skill, Player hero, Mob enemy) throws CloneNotSupportedException {
        this.skill = skill;
        this.hero = (Statistics) hero.getStats().clone();
        this.enemy = (Statistics) enemy.getStats().clone();
    }

    public Ability(){}

    public void conditions(){
        Fight fight = new Fight();

        switch(skill){
            case HEALING:
                if(hero.getHp() <= 50){
                    this.hero.setHp(hero.getHp() + 30);
                    System.out.println("You recovered 30 HP");
                }
                break;

            case INCREASE_ATK:
                if(fight.getTurn() >= 2){
                    this.hero.setAtk(hero.getAtk() + 30);
                    System.out.println("Your atk value increased by 30 points");
                }
                break;

            case INCREASE_DEF:
                if(fight.getTurn() >= 3){
                    this.hero.setDef(hero.getDef() + 25);
                    System.out.println("Your defense value increased by 25 points");
                }
                break;

            case DECREASE_ATK:
                if(hero.getStamina() <= 50){
                    this.hero.setStamina(hero.getStamina() - 20);
                    System.out.println("Your atk value decreased by 20 points");
                }
                break;

            case DECREASE_DEF:
                if(hero.getStamina() <= 50 && enemy.getHp() >= 50){
                    this.hero.setDef(hero.getDef() - 30);
                    System.out.println("Your defense value decreased by 30 points");
                }
                break;

            case SPECIAL_ATTACK:
                if(hero.getStamina() >= 60){
                    this.hero.setAtk(hero.getAtk()*2);
                    System.out.println("You can use a special attack");
                }
                break;
        }
    }

    public String showAbilities(){
        return "AVAILABLES ABILITY\n\nHealing\nIncrease attack\nIncrease defense";
    }
}
