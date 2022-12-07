package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.controller.WorldMapController;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementHandler implements KeyListener {
    private WorldMapController worldMapController;
    private boolean upPressed, downPressed, rightPressed, leftPressed;

    public MovementHandler() {
    }

    public void attach(WorldMapController controller) {
        this.worldMapController = controller;
    }

    public void detach(WorldMapController controller) {

    }

    private void notifyController(EventType e){
        this.worldMapController.update(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W -> {
                this.notifyController(EventType.MOVED_UP);
            }
            case KeyEvent.VK_S -> {
                this.notifyController(EventType.MOVED_DOWN);
            }
            case KeyEvent.VK_A ->{
                this.notifyController(EventType.MOVED_LEFT);
            }
            case KeyEvent.VK_D->{
                this.notifyController(EventType.MOVED_RIGHT);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
