package it.unipa.iss.rpg.combat.controller;

import com.sun.jdi.event.Event;
import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.GamePanel;


import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * @Autor Alessia Boni * **/

public class CombatController extends GameController {


    private Fight fight;
    //trowAway declaration when mob class is implemented
    private Mob[] enemies;
    //access to class fight
    private Fight combat;
    //gestore del bottone fight



    public CombatController(Player player, CombatPanel view ,Mob[] enemies){
        super(player, view);
        this.enemies = enemies;
        //completa la lambda expression
        //view.getBtnFight().addActionListener(e -> );
    }

    public CombatController(Player player, GamePanel view){
        super(player,view);
    }

    public void update(){
        //inizializzare la view
        //if(fight.)

    }

    @Override
    public void update(EventType e) {

    }

    @Override
    public void runController()  {
        /*

        System.out.println("Combat started");
        try {
            fight = new Fight(player.getStats,enemies[0].getStats);
        } catch(CloneNotSupportedException e){
            System.out.println("Error clone");
        }
        while(isActive()) {

            update();

        }

        */
    }
}

