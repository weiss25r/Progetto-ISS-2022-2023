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
        PlayerSprite ps;
        ArrayList<String> paths = new ArrayList<>();

        try {

            String query = "select hero_hp, hero_defense, hero_atk, hero_stamina, sprite1, sprite2, sprite3, sprite4, position_x, position_y\n" +
                    "from hero join entitysprite on hero.hero_id = entitysprite.sprite_id join spriteposition on entitysprite.sprite_id = spriteposition.sprite_id\n" +
                    "where hero.hero_id = " + id;

            Statement stmt = this.dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int hero_hp = rs.getInt("hero_hp");
                int hero_defense = rs.getInt("hero_defense");
                int hero_atk = rs.getInt("hero_atk");
                int hero_stamina = rs.getInt("hero_stamina");
                String path1 = rs.getString("sprite1");
                paths.add(path1);
                String path2 = rs.getString("sprite2");
                paths.add(path2);
                String path3 = rs.getString("sprite3");
                paths.add(path3);
                String path4 = rs.getString("sprite4");
                paths.add(path4);
                int position_x = rs.getInt("position_x");
                int position_y = rs.getInt("position_y");


                stats = new Statistics(hero_hp, hero_defense, hero_stamina, hero_atk);
                ps = new PlayerSprite(position_x, position_y);
                ps.setSpritesPath(paths);
                player = new Player(stats, ps);


            }

        }

        catch (Exception e){
            e.printStackTrace();
        }
        return player;
    }



    @Override
    public Mob getEnemyById(String id) {
        return null;
    }

    @Override
    public Statistics getStatsById(String id) {
        return null;
    }

    public static void main(String[] args) {
        EntityDAOImpl test = EntityDAOImpl.getDbInstance();
        test.getHeroStatsById("001");

    }
}
