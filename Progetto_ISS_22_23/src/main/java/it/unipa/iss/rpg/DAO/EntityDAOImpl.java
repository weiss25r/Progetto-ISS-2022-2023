package it.unipa.iss.rpg.DAO;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.model.entitities.PlayerSprite;

import java.sql.*;
import java.util.ArrayList;

public class EntityDAOImpl  implements EntityDAO{
    private static EntityDAOImpl dbInstance = null;
    private Connection dbConnection;

    private EntityDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entitystats",
                    "agar", "agarproject");
        }

        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static EntityDAOImpl getDbInstance(){
        if(dbInstance == null){
            dbInstance = new EntityDAOImpl();
        }
        return dbInstance;
    }

    @Override
    public Player getHeroStatsById(String id) {
        Player player = null;
        Statistics stats;

        try {

            String query = "select hero_hp, hero_defense, hero_atk, hero_stamina from hero where hero_id = " + id;

            Statement stmt = this.dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int hero_hp = rs.getInt("hero_hp");
                int hero_defense = rs.getInt("hero_defense");
                int hero_atk = rs.getInt("hero_atk");
                int hero_stamina = rs.getInt("hero_stamina");

                stats = new Statistics(hero_hp, hero_defense, hero_stamina, hero_atk);
                player = new Player(stats, null);
            }

        }

        catch (Exception e){
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public ArrayList<String> getHeroSpritesById(String id){
        try{
            String query = " "
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Mob getEnemyById(String id) {
        return null;
    }

    @Override
    public Statistics getStatsById(String id) {
        return null;
    }
}
