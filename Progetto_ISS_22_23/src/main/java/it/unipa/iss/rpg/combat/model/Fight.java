package it.unipa.iss.rpg.combat.model;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;

/**Class Fight, manages fighting event
 * @author Bonura Giovanni*/

public class Fight implements CombatHandler{
    private Statistics hero;
    private Statistics enemy;

    private int turn = 1;
    boolean myTurn = true;
    boolean gameOver;

    /**Constructor with two parameters*/
    public Fight(Player hero, Mob enemy) throws CloneNotSupportedException {
        this.hero = (Statistics) hero.getStats().clone();
        this.enemy = (Statistics) enemy.getStats().clone();
    }

    /**Method returns damage's attack
     * @return value of a single attack*/
    public int cmdAttack() {
        if(myTurn) return ((hero.getAtk() * enemy.getDef())/ enemy.getHp())*turn;
        else return ((enemy.getAtk() * hero.getDef())/ hero.getHp())*(turn-1);
    }

    /**Method returns number of turns played by the hero
     * @return rounds played by the player*/
    public int getTurn(){
        return turn;
    }

    /**Override CombatHandler interface's method*/
    @Override
    public void inputAction(int choice){

        switch (choice){
            case 1:
                System.out.println("Turn " + getTurn());
                enemy.setHp(enemy.getHp() - cmdAttack());
                turn++;
                myTurn = false;
                if(enemy.getHp() < 0){
                    gameOver = true;
                }
                break;
        }
        this.hero.setHp(hero.getHp() - cmdAttack());
        myTurn = true;
        if(this.hero.getHp() < 0){
            gameOver = true;
        }


        if (getHpEnemyRemaining() < 0) System.out.println("\nHero wins!");
        else if(getHpHeroRemaining() < 0) System.out.println("\nEnemy wins!");

    }

    /**Method returns health points hero's remaining
     * @return hp hero'r remaining*/
    public int getHpHeroRemaining(){
        return this.hero.getHp();
    }

    /**Method returns health points enemy's remaining
     * @return hp enemy's remaining*/
    public int getHpEnemyRemaining(){
        return this.hero.getHp();
    }

    /**Method checks game over conditions
     * @return boolean game over value*/
    public boolean gameOverCheck(){
        return this.gameOver;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Fight fight = new Fight(new Player(), new Mob(new Statistics()));
        int choice = 1;
        fight.inputAction(1);
    }
}