package it.unipa.iss.rpg.combat.model;

/**Class Fight, manages fighting event
 * @author Bonura Giovanni*/

public class Fight extends Statistics implements CombatHandler{
    Statistics hero = new Statistics(100, 30, 0, 60);
    Statistics clone1 = (Statistics) hero.clone();
    Statistics enemy = new Statistics(100, 50, 0, 80);
    Statistics clone2 = (Statistics) enemy.clone();

    private int turn = 1;
    boolean myTurn = true;
    boolean gameOver;

    /**Constructor without parameters*/
    public Fight() throws CloneNotSupportedException {}

    /**Method returns damage's attack
     * @return value of a single attack*/
    public int cmdAttack() {
        if(myTurn) return ((clone1.getAtk() * clone2.getDef())/ clone2.getMaxHp())*turn;
        else return ((clone2.getAtk() * clone1.getDef())/ clone1.getMaxHp())*(turn-1);
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
                int hpEnemyCurr = clone2.getMaxHp() - cmdAttack();
                hpEnemyRemaining = hpEnemyCurr;
                turn++;
                myTurn = false;
                System.out.println(getHpEnemyRemaining(hpEnemyRemaining));
                if(hpEnemyRemaining < 0){
                    gameOver = true;
                }
                break;
        }
        int hpHeroCurr = clone1.getMaxHp() - cmdAttack();
        hpHeroRemaining = hpHeroCurr;
        myTurn = true;
        System.out.println(getHpHeroRemaining(hpHeroRemaining));
        if(hpHeroRemaining < 0){
            gameOver = true;
        }

        if (hpEnemyRemaining < 0) System.out.println("\nHero wins!");
        else if(hpHeroRemaining < 0) System.out.println("\nEnemy wins!");
    }

    public int getHpHeroRemaining(int hpHeroRemaining){
        return hpHeroRemaining;
    }

    public int getHpEnemyRemaining(int hpEnemyRemaining){
        return hpEnemyRemaining;
    }

    public boolean gameOverCheck(boolean gameOver){
        return gameOver;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Fight fight = new Fight();
        int choice = 1;
        fight.inputAction(1);
    }
}