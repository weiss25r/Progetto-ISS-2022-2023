package it.unipa.iss.rpg;

import it.unipa.iss.rpg.DAO.EntityDAOImpl;
import it.unipa.iss.rpg.combat.controller.CombatController;
import it.unipa.iss.rpg.screen.controller.LevelController;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.combat.view.CombatPanel;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import java.util.Scanner;

public class Game{
    private static Game instance = null;
    private LevelController worldController;
    private CombatController combatController;
    private Screen screen;

    private WorldPanel worldPanel;
    private CombatPanel combatPanel;
    private Player p;

    private Game() {
        p = EntityDAOImpl.getDbInstance().getHeroById("001");

        if(p == null) {
            System.out.println("Connessione fallita");
            Scanner s = new Scanner(System.in);
            s.nextInt();
            System.exit(-1);
        }
        this.worldPanel = new WorldPanel();
        this.combatPanel = new CombatPanel();

        this.worldController = new LevelController(p, worldPanel);

        screen = new Screen();
    }

    public void startGame() {
        //game loop
        while(true) {
            screen.setGamePanel(worldPanel);
            worldController.runController();

            screen.getWindow().dispose();

            combatController = new CombatController(p,combatPanel, worldController.getCollisionMob());

            screen.setGamePanel(combatPanel);
            combatController.runController();

            screen.getWindow().dispose();

            this.combatPanel = new CombatPanel();
        }
    }

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }
}
