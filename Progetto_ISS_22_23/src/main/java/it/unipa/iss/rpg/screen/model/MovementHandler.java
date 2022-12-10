package it.unipa.iss.rpg.screen.model;

import it.unipa.iss.rpg.screen.controller.WorldController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementHandler implements KeyListener {
    private WorldController worldController;

    public MovementHandler() {
    }

    public void attach(WorldController controller) {
        this.worldController = controller;
    }

    public void detach() {
        this.worldController = null;
    }

    private void notifyController(EventType e){
        this.worldController.update(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //TODO: mettere check null
        if(this.worldController == null) {
            System.out.println("Sono null");
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
