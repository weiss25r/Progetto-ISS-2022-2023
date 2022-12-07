package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.controller.WorldMapController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementHandler implements KeyListener {
    private WorldMapController worldMapController;
    private boolean upPressed, downPressed, rightPressed, leftPressed;

    public void attach(WorldMapController controller) {

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
            case KeyEvent.VK_KP_UP -> {
                this.notifyController(EventType.MOVED_UP);
            }
            case KeyEvent.VK_KP_DOWN -> {
                this.notifyController(EventType.MOVED_DOWN);
            }
            case KeyEvent.VK_KP_LEFT ->{
                this.notifyController(EventType.MOVED_LEFT);
            }
            case KeyEvent.VK_KP_RIGHT ->{
                this.notifyController(EventType.MOVED_RIGHT);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
