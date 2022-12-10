package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.Player;
import it.unipa.iss.rpg.screen.view.GamePanel;


public class CombatController extends GameController {

    public Fight combat;
    public GamePanel view;

    public CombatController(Player player, GamePanel view){
        super(player, view);
        this.view = view;
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
