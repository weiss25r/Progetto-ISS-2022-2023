package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;

/**Class Fight, manages fighting event
 * @author Bonura Giovanni*/

public class Fight implements CombatHandler{
    Player hero;
    Mob enemy;

    private int turn = 1;
    boolean myTurn = true;
    boolean gameOver;

    /**Constructor with two parameters*/
    public Fight(Statistics hero, Statistics enemy) throws CloneNotSupportedException {
        this.hero = (Player) hero.clone();
        this.enemy = (Mob) enemy.clone();
    }

    /**Method returns damage's attack
     * @return value of a single attack*/
    public int cmdAttack() {
        if(myTurn) return ((hero.getStats().getAtk() * enemy.getStats().getDef())/ enemy.getStats().getMaxHp())*turn;
        else return ((enemy.getStats().getAtk() * hero.getStats().getDef())/ hero.getStats().getMaxHp())*(turn-1);
    }

    /**Method returns number of turns played by the hero
     * @return rounds played by the player*/
    public int getTurn(){
        return turn;
    }

    /**Override CombatHandler interface's method*/
    @Override
    public void inputAction(int choice){
        int hpHeroRemaining = 0; int hpEnemyRemaining = 0;

        switch (choice){
            case 1:
                System.out.println("Turn " + getTurn());
                int hpEnemyCurr = enemy.getStats().getMaxHp() - cmdAttack();
                hpEnemyRemaining = hpEnemyCurr;
                turn++;
                myTurn = false;
                System.out.println(getHpEnemyRemaining(hpEnemyRemaining));
                if(hpEnemyRemaining < 0){
                    gameOver = true;
                }
                break;
        }
        int hpHeroCurr = hero.getStats().getMaxHp() - cmdAttack();
        hpHeroRemaining = hpHeroCurr;
        myTurn = true;
        System.out.println(getHpHeroRemaining(hpHeroRemaining));
        if(hpHeroRemaining < 0){
            gameOver = true;
        }

        if (hpEnemyRemaining < 0) System.out.println("\nHero wins!");
        else if(hpHeroRemaining < 0) System.out.println("\nEnemy wins!");
    }

    /**Method returns health points hero's remaining
     * @return hp hero'r remaining*/
    public int getHpHeroRemaining(int hpHeroRemaining){
        return hpHeroRemaining;
    }

    /**Method returns health points enemy's remaining
     * @return hp enemy's remaining*/
    public int getHpEnemyRemaining(int hpEnemyRemaining){
        return hpEnemyRemaining;
    }

    /**Method checks game over conditions
     * @return boolean game over value*/
    public boolean gameOverCheck(boolean gameOver){
        return gameOver;
    }

    /*public static void main(String[] args) throws CloneNotSupportedException {
        Fight fight = new Fight(new Statistics(), new Statistics());
        int choice = 1;
        fight.inputAction(1);
    }*/
}