package it.unipa.iss.rpg.DAO;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;

public interface EntityDAO {
    public void heroById(String id);
    public Mob getEnemyById(String id);
    public Statistics getStatsById(String id);
}
