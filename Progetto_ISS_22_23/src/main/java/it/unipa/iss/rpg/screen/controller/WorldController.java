package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import java.awt.*;

public class WorldController extends GameController implements IPlayerListener {

    private MovementHandler movementHandler;

    public WorldController(Player player, WorldPanel gamePanel) {
        super(player, gamePanel);
        movementHandler = new MovementHandler();
        movementHandler.attach(this);
        this.getGamePanel().addKeyListener(movementHandler);

        //TODO: REFACTOR
        gamePanel.addController(this);
    }

    public void drawPlayer(Graphics2D g) {
        g.drawImage(getPlayer().getDirectionImage(),
                    getPlayer().getPlayerSprite().getWorldX(),
                    getPlayer().getPlayerSprite().getWorldY(),
                    getGamePanel().scaleTile(),
                    getGamePanel().scaleTile(),
                    null
        );
    }

    @Override
    public void update(EventType e) {
        Player player = this.getPlayer();
        player.move(e);

        //System.out.printf("New Coordinates: %d %d\n", player.getWorldX(), player.getWorldY());
        this.getGamePanel().repaint();
    }

    @Override
    public void runController() {
        //TODO: ATTACH/DETACH QUA
        int fps = 60;
        double drawInterval = (double)1000000000/fps;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(isActive()) {
            //TODO: It must be initialize the Subscribers Entity
            //      of Observer-Pattern
            //TODO: When the player collide into a Entity gamePanel
            //      must send as parameter to the Observer-Pattern
            //      notifyController(gamePanel)
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                this.getGamePanel().repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void notifyController(){
        //TODO: notify the Collision Entity
    }

}
