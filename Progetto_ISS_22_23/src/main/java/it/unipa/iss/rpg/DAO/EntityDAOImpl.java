package it.unipa.iss.rpg.DAO;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import java.sql.*;

public class EntityDAOImpl  implements EntityDAO{
    private static EntityDAOImpl dbInstance = null;
    private Connection dbConnection;

    private EntityDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/characterstats",
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
    public void heroById(String id) {
        try {
            Player p;

            String query = "select * from hero where hero_id = " + id;

            Statement stmt = this.dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Statistics stats  = new Statistics();

            while (rs.next()){
                String idHero = rs.getString(id);
                String heroName = rs.getString("default");
                String hero_idSprite = rs.getString(id);
                String sprite_1 = rs.getString("src/res/character/move/down/char_down_00.png");
                String sprite_2 = rs.getString("src/res/character/move/up/char_up_00.png");
                String sprite_3 = rs.getString("src/res/character/move/left/char_left_00.png");
                String sprite_4 = rs.getString("src/res/character/move/right/char_right_00.png");

                System.out.print("hero_id: " + idHero);
                System.out.print(", hero_name: " + heroName);
                System.out.print(", hero_idSprite: " + hero_idSprite);
            }


        }

        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println();
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
