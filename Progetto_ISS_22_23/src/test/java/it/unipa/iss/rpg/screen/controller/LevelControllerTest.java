package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.DAO.EntityDAOImpl;
import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.WorldPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelControllerTest {
    LevelController controller;
    Player player;

    @BeforeEach
    void setUp() {
        player = EntityDAOImpl.getDbInstance().getHeroById("001");
        player.getPlayerSprite().setWorldX(200);
        player.getPlayerSprite().setWorldY(290);
        controller = new LevelController(player, new WorldPanel());
    }

    @Test
    void testUpdate() {
        //per ogni npc e mob della prima mappa si posiziona il player in cui l'entità è presente e si verifica che la collissione
        //sia stata notificata e risolta (ovvero, che l'entità di riferimento sia nul

        controller.update(EventType.MOVED_RIGHT);
        assertNull(controller.getLevel().getCurrentMap().getEnemy(3, 2));

        player.getPlayerSprite().setWorldX(190);
        player.getPlayerSprite().setWorldY(200);
        controller.update(EventType.MOVED_RIGHT);
        assertNull(controller.getLevel().getCurrentMap().getNpc(2, 2));

        player.getPlayerSprite().setWorldX(0);
        player.getPlayerSprite().setWorldY(290);
        controller.update(EventType.MOVED_DOWN);
        assertNull(controller.getLevel().getCurrentMap().getEnemy(3, 0));

        player.getPlayerSprite().setWorldX(380);
        player.getPlayerSprite().setWorldY(300);
        controller.update(EventType.MOVED_RIGHT);
        assertNull(controller.getLevel().getCurrentMap().getEnemy(3, 4));

        player.getPlayerSprite().setWorldX(570);
        player.getPlayerSprite().setWorldY(300);
        controller.update(EventType.MOVED_RIGHT);
        assertNull(controller.getLevel().getCurrentMap().getEnemy(3, 6));
    }
}