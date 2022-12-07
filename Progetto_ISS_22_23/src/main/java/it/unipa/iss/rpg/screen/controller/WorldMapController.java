package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.screen.model.Direction;
import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.IPlayerListener;
import it.unipa.iss.rpg.screen.model.Player;
import it.unipa.iss.rpg.screen.view.WorldPanel;

public class WorldMapController implements IPlayerListener {
    private Player player;
    private WorldPanel worldPanel;

    public WorldMapController(Player p, WorldPanel w) {

    }

    public void drawPlayer() {

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
    }
}
