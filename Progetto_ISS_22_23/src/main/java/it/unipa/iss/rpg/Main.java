package it.unipa.iss.rpg;

import it.unipa.iss.rpg.screen.controller.WorldMapController;
import it.unipa.iss.rpg.screen.model.Player;
import it.unipa.iss.rpg.screen.view.Screen;
import it.unipa.iss.rpg.screen.view.WorldPanel;

public class Main {
    public static void main(String[] args) {
        Screen screen = Screen.getIstance();
        WorldMapController controller = new WorldMapController(Player.getInstance(), (WorldPanel) screen.getGamePanel());
    }
}