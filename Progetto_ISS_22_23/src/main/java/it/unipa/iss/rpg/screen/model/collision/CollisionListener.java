package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;

public interface CollisionListener {
    void update(GameController gameController);
    void update(String path, String dialog, String choose_one, String choose_two);
}
