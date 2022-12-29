package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.model.entitities.Mob;

import java.util.List;

public class MobListener implements CollisionListener{
    List<Mob> dataEntity;
    public MobListener(List<Mob> dataEntity) {
        this.dataEntity = dataEntity;
    }

    @Override
    public void update(GameController gameController) {
        gameController.setActive(false);
    }

    @Override
    public void update() { }

}
