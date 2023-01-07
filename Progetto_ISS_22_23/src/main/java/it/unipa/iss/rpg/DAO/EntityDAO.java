package it.unipa.iss.rpg.DAO;

import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Npc;
import it.unipa.iss.rpg.screen.model.entitities.Player;

public interface EntityDAO {
    public Player getHeroById(String id);
    public Mob getEnemyById(String id);
    public Npc getNpcById(String id);
}
