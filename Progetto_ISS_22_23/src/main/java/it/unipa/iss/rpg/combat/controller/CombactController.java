package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.combat.model.Fight;

import it.unipa.iss.rpg.screen.view.GamePanel;


public class CombactController {

    public Fight combact;
    public GamePanel view;


    public CombactController(Fight combact, GamePanel view){
        this.combact = combact;
        this.view = view;
    }


    public void update(){

    }



}
