package it.unipa.iss.rpg;

import it.unipa.iss.rpg.combat.controller.CombatController;
import it.unipa.iss.rpg.screen.controller.WorldController;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;

public class Game{
    private WorldController worldController;
    private CombatController combatController;

    public Game() {
        Player p = new Player();
        this.worldController = new WorldController(p, (WorldPanel) Screen.getIstance().getGamePanel());
        this.combatController = new CombatController(p, Screen.getIstance().getGamePanel());
    }

    public void startGame() {
        //game loop
        while(true) {
            worldController.runController();
            //break;
            //combatController.runController();
        }

    }
}
