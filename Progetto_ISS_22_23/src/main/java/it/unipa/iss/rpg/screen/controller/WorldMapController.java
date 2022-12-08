package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.view.WorldPanel;

public class WorldMapController implements IPlayerListener {
    private Player player;
    private WorldPanel worldPanel;

    public WorldMapController(Player p, WorldPanel w) {
        this.player = p;
        this.worldPanel = w;
        MovementHandler movementHandler = new MovementHandler();
        movementHandler.attach(this);
        w.addKeyListener(movementHandler);
    }

    public void draw() {

    }

    @Override
    public void update(EventType e) {
        switch (e) {
            case MOVED_UP -> {
                player.move(Direction.UP);
            }
            case MOVED_DOWN -> player.move(Direction.DOWN);
            case MOVED_LEFT -> player.move(Direction.LEFT);
            case MOVED_RIGHT -> player.move(Direction.RIGHT);
        }

        System.out.printf("New Coordinates: %d %d\n", player.getWorldX(), player.getWorldY());

    }
}
