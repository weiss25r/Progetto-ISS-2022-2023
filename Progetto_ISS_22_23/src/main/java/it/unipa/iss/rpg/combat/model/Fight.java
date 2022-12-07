package it.unipa.iss.rpg.combat.model;

import java.util.Scanner;

/**Class Fight, manages fighting event
 * @author Bonura Giovanni*/

public class Fight extends Copy implements CombatHandler{
    Copy c1 = new Copy(100, 30, 60);
    Copy clone1 = (Copy) c1.clone();
    Copy c2 = new Copy(100, 50, 80);
    Copy clone2 = (Copy) c2.clone();

    private int turn = 1;
    boolean myTurn = true;
    boolean gameOverCheck;

    /**Constructor without parameters*/
    public Fight() throws CloneNotSupportedException {}

    /**Constructor with parameters, provides parameters of superClass Copy*/
    public Fight(int hp, int defense, int damage) throws CloneNotSupportedException {
        super(hp, defense, damage);
    }

    /**Method returns damage's attack
     * @return value of a single attack*/
    public int cmdAttack() {
        if(myTurn) return ((clone1.getDamage() * clone2.getDefense())/ clone2.getHp())*turn;
        else return ((clone2.getDamage() * clone1.getDefense())/ clone1.getHp())*(turn-1);
    }

    /**Method returns number of turns played by the hero
     * @return rounds played by the player*/
    public int getTurn(){
        return turn;
    }

    /**Override CombatHandler interface's method*/
    @Override
    public void inputAction(){
        int scelta;
        int hpHeroRemaining = 0; int hpEnemyRemaining = 0;

        do{
            Scanner sc = new Scanner(System.in);
            scelta = sc.nextInt();
            switch (scelta){
                case 1:
                    System.out.print("Turn " + getTurn() + "\nHero is attacking --> Enemy HP: ");
                    int hpEnemyCurr = clone2.getHp() - cmdAttack();
                    System.out.println(hpEnemyCurr);
                    hpEnemyRemaining = hpEnemyCurr;
                    turn++;
                    myTurn = false;
                    if(hpEnemyRemaining < 0) gameOverCheck = true;
                    break;
            }
            System.out.print("Enemy is attacking --> Hero HP: ");
            int hpHeroCurr = clone1.getHp() - cmdAttack();
            System.out.println(hpHeroCurr);
            hpHeroRemaining = hpHeroCurr;
            myTurn = true;
            if(hpHeroRemaining < 0) gameOverCheck = true;
        }while(!gameOverCheck);

        if (hpEnemyRemaining < 0) System.out.println("\nHero wins!");
        else if(hpHeroRemaining < 0) System.out.println("\nEnemy wins!");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Fight fight = new Fight();

        fight.inputAction();
    }
}