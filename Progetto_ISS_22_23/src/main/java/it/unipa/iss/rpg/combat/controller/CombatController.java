package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.GamePanel;

/**
 * @Autor Alessia Boni * **/

public class CombatController extends GameController {
    private Fight fight;
    //trowAway declaration when mob class is implemented
    private Mob enemy;
    private CombatPanel view;

    /*
        Ripasso alla view le statistiche aggiornate con

     */

    public CombatController(Player player, CombatPanel view ,Mob enemy){
        super(player, view);
        this.setEnemies(enemy);

        try {
            this.fight = new Fight(this.getPlayer(),enemy);
        } catch(CloneNotSupportedException e){
            System.out.println("Error clone");
        }

        this.view.getBtnFight().addActionListener(event -> fight.cmdAttack());

        //completa la lambda expression
        view.getBtnFight().addActionListener(e -> {
            fight.cmdAttack();
            this.update();
        });

    }

    public CombatController(Player player, GamePanel view){
        super(player,view);
    }

    public void setEnemies(Mob enemy) {
        this.enemy = enemy;
    }

    public void update(){
        view.setLblPlayerHp(Integer.toString(fight.getHpHeroRemaining()));
        view.setLblEnemyHp(Integer.toString(fight.getHpEnemyRemaining()));
    }

    //ascoltatore per update
    @Override
    public void update(EventType e) {
        this.update();
    }

    @Override
    public void runController()  {
        while(isActive()) {
            if(fight.gameOverCheck()){
                super.setActive(false);
            }
        }
    }
}

