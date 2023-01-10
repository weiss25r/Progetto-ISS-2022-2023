package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.controller.LevelController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementHandler implements KeyListener {
    private LevelController gameController;

    public MovementHandler() {

    }

    public void attach(LevelController controller) {
        this.gameController = controller;
    }

    public void detach() {
        this.gameController = null;
    }

    private void notifyController(EventType e){
        this.gameController.update(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(this.gameController == null) {
            return;
        }

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
    public void keyReleased(KeyEvent e) {}
}
