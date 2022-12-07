package it.unipa.iss.rpg.combat.model;

import java.util.ArrayList;
import java.util.Scanner;

/**Class Fight, manages fighting event
 * @author Bonura Giovanni*/

public class Fight extends Copy implements CombatHandler{
    Copy c1 = new Copy(100, 30, 60);
    Copy clone1 = (Copy) c1.clone();
    Copy c2 = new Copy(0, 70, 30);
    Copy clone2 = (Copy) c2.clone();
    Copy c3 = new Copy(100, 20, 80);
    Copy clone3 = (Copy) c3;

    ArrayList<Fight> characters = new ArrayList<>(1);

    private int heroTurn = 1;
    boolean myTurn;

    /**Constructor without parameters*/
    public Fight() throws CloneNotSupportedException {}

    /**Constructor with parameters, provides parameters of superClass Copy*/
    public Fight(int hp, int defense, int damage) throws CloneNotSupportedException {
        super(hp, defense, damage);
    }

    /**Override of CombatHandler interface's method
     * @return value of a single attack*/
    @Override
    public int cmdAttack() {
        if(myTurn){
            heroTurn++;
            return (clone1.getDamage() * clone2.getDefense())/ clone2.getHp();
        }
        else return (clone2.getDamage() * clone1.getDefense())/ clone1.getHp();
    }

    /**Override of CombatHandler interface's method*/
    @Override
    public void gameOver() {

    }

    /**Method returns number of turns played by the hero
     * @return rounds played by the player*/
    public int getHeroTurn(){
        return heroTurn;
    }

    public void getNextPlayer(){

    }

    public boolean checkHp(){
        if(clone2.getHp() == 0) return true;
        else return false;
    }

    public void inputAction(){
        int scelta = 0;

        while (scelta != 2){
            Scanner sc = new Scanner(System.in);
            scelta = sc.nextInt();
            switch (scelta){
                case 1:
                    System.out.println(clone1.getHp() - cmdAttack());
                    break;

                default:
                    if(checkHp()) System.out.println("Hero wins!");
                    else System.out.println("Enemy wins!");
                    break;
            }
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Fight fight = new Fight();

        fight.inputAction();

    }
}
