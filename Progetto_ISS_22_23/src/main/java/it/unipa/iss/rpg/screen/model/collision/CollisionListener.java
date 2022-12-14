package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;

public interface CollisionListener {
    void update();
    void update(GameController gameController);
}
