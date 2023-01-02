package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.combat.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.ComponentImage;

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


        this.view.getBtnFight().addActionListener(event -> fight.cmdAttack());
        view.getBtnFight().addActionListener(e -> {
            fight.inputAction(1);
            this.update(EventType.PLAYER_ATK);
        });

        if(this.enemy.getMobSprite() != null) {
            view.setEnemyImage(new ComponentImage(this.enemy.getMobSprite().getDefaultSprite(), 300, 180));
        }
    }

    public void setEnemies(Mob enemy) {
        this.enemy = enemy;
    }

    @Override
    public void update(EventType e){
        switch(e){
            case PLAYER_ATK ->{
                view.setLblPlayerHp("HP: " + fight.getHpHeroRemaining());
                view.setLblEnemyHp("HP: " + fight.getHpEnemyRemaining());
            }
            case PLAYER_ABILITY -> {
                //Attenzione da modificare
                view.setLblPlayerStamina(Integer.toString(this.getPlayer().getStats().getStamina()));
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

