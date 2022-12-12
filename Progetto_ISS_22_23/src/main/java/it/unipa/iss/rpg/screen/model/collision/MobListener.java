package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;

import java.util.List;

public class MobListener implements CollisionListener{
    List<?> dataEntity;
    //TODO: it must be create the Class: Mob

    public MobListener(List<?> dataEntity) {
        this.dataEntity = dataEntity;
    }

    @Override
    public void update(GameController gameController) {
        gameController.setActive(false);
    }
}
