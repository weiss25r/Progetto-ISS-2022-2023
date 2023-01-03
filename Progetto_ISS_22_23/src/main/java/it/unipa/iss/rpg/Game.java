package it.unipa.iss.rpg;

import it.unipa.iss.rpg.combat.controller.CombatController;
import it.unipa.iss.rpg.screen.controller.LevelController;
import it.unipa.iss.rpg.screen.controller.WorldController;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.combat.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;

public class Game{
    private LevelController worldController;
    private CombatController combatController;
    private Screen screen;

    private WorldPanel worldPanel;
    private CombatPanel combatPanel;
    private Player p;

    public Game() {
        p = new Player();

        this.worldPanel = new WorldPanel();
        this.combatPanel = new CombatPanel();

        screen = new Screen();
        this.worldController = new LevelController(p, worldPanel);
    }

    public void startGame() {
        //game loop
        while(true) {
            screen.setGamePanel(worldPanel);
            worldController.runController();
            screen.setGamePanel(combatPanel);
            this.combatController = new CombatController(p,combatPanel, worldController.getCollisionMob());
            combatController.runController();
            this.combatPanel = new CombatPanel();
        }
    }
}
