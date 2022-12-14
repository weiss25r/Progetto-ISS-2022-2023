package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.GamePanel;


public class CombatController extends GameController {
    public Fight combat;
    public Mob enemies[];

    public CombatController(Player player, CombatPanel view ,Mob[] enemies){
        super(player, view);
        this.enemies = enemies;
    }

    public CombatController(Player player, GamePanel view){
        super(player,view);
    }

    public void update(){

    }

    @Override
    public void update(EventType e) {

    }

    @Override
    public void runController() {

        System.out.println("Combat started");

    }
}
