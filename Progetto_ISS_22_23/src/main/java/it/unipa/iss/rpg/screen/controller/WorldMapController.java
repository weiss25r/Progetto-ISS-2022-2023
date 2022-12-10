package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.view.GamePanel;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import java.awt.*;

public class WorldMapController extends GameController implements IPlayerListener {
    public WorldMapController(Player player, GamePanel gamePanel) {
        super(player, gamePanel);
        MovementHandler movementHandler = new MovementHandler();
        movementHandler.attach(this);
        this.getGamePanel().addKeyListener(movementHandler);

        //TODO: REFACTOR
        ((WorldPanel)gamePanel).addController(this);
    }

    public void drawPlayer(Graphics2D g) {
        g.drawImage(getPlayer().getDirectionImage(),
                    getPlayer().getWorldX(),
                    getPlayer().getWorldY(),
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
        int fps = 60;
        double drawInterval = (double)1000000000/fps;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(true) {
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
}
