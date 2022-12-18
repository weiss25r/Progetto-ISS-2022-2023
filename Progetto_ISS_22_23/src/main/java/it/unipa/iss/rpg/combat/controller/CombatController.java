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
            e.printStackTrace();
        }
        if(this.enemy.getMobSprite() != null) {
            view.setEnemyImage(new ComponentImage(this.enemy.getMobSprite().getDefaultSprite(), 300, 180));
        }

        this.view.getBtnFight().addActionListener(event -> fight.cmdAttack());
        view.getBtnFight().addActionListener(e -> {
            fight.inputAction(1);
            this.update(EventType.PLAYER_ATK);
        });

    }

    public void setEnemies(Mob enemy) {
        this.enemy = enemy;
    }

    @Override
    public void update(EventType e){
        switch(e){
            case PLAYER_ATK ->{
                view.setLblPlayerHp(Integer.toString(fight.getHpHeroRemaining()));
                view.setLblEnemyHp(Integer.toString(fight.getHpEnemyRemaining()));
                break;
            }
            case PLAYER_ABILITY -> {
                //Attenzione da modificare
                view.setLblPlayerStamina(Integer.toString(this.getPlayer().getStats().getStamina()));
                break;
            }

        }

    }

    //ascoltatore per update


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

    public CombatPanel getView(){
        return this.view;
    }
    public Fight getFight(){
        return this.fight;
    }
}

