package it.unipa.iss.rpg;

import it.unipa.iss.rpg.screen.controller.WorldMapController;
import it.unipa.iss.rpg.screen.model.Player;
import it.unipa.iss.rpg.screen.view.Screen;

public class Game implements Runnable {
    private GameController gameController;

    private Thread gameThread;

    public Game() {
        Player p = Player.getInstance();
        this.gameController = new WorldMapController(p, Screen.getIstance().getGamePanel());
        this.gameThread = new Thread(this);
    }

    public void startGame() {
        this.gameThread.setName("Game thread");
        this.gameThread.start();
    }

    @Override
    public void run() {
        gameController.runController();
    }

    public Thread getGameThread() {
        return gameThread;
    }
}
