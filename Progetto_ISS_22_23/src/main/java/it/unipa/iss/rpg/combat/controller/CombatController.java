package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.ComponentImage;
import it.unipa.iss.rpg.screen.view.GamePanel;

import java.awt.*;
import java.awt.event.ActionListener;

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
        this.view = view;
        this.setEnemies(enemy);

        try {
            this.fight = new Fight(this.getPlayer(),enemy);
        } catch(CloneNotSupportedException e){
            System.out.println("Error clone");
        }

        view.setEnemyImage(new ComponentImage(this.enemy.getMobSprite().getDefaultSprite(), 300,180 ));

        this.view.getBtnFight().addActionListener(event -> fight.cmdAttack());

        //completa la lambda expression
        view.getBtnFight().addActionListener(e -> {
            fight.inputAction(1);
            this.update(null);
        });

    }

    public CombatController(Player player, GamePanel view){
        super(player,view);
    }

    public void setEnemies(Mob enemy) {
        this.enemy = enemy;
    }

    @Override
    public void update(EventType e){
        view.setLblPlayerHp(Integer.toString(fight.getHpHeroRemaining()));
        view.setLblEnemyHp(Integer.toString(fight.getHpEnemyRemaining()));
        //temporaneo, la stamina diminuisce se uso un abilità
        view.setLblPlayerStamina(Integer.toString(this.getPlayer().getStats().getStamina()));
    }

    //ascoltatore per update

    public Mob getEnemy() {
        return enemy;
    }

    @Override
    public void runController()  {
        while(isActive()) {
            try {
                Thread.sleep(1000);
            }catch (Exception ex) {
                ex.printStackTrace();
            }
            if(fight.gameOverCheck()){
                view.getBtnFight().removeActionListener(view.getBtnFight().getActionListeners()[0]);
                this.setActive(false);
            }

        }
    }
}

