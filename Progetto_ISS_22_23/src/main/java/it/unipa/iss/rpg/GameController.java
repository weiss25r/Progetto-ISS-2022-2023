package it.unipa.iss.rpg;

import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.view.GamePanel;

public abstract class GameController {
    private Player player;
    private GamePanel gamePanel;

    public abstract void update(EventType e);
    public abstract void runController();

    public GameController(Player player, GamePanel gamePanel) {
        this.player = player;
        this.gamePanel = gamePanel;
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    public Player getPlayer() {
        return this.player;
    }
}
