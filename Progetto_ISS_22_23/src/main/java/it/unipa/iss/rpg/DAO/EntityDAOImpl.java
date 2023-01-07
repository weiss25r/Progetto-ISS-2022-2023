package it.unipa.iss.rpg.DAO;

import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.entitities.*;

import java.sql.*;
import java.util.ArrayList;

/**Class EntityDAOImpl is a Singleton and implements DAO interface*/
public class EntityDAOImpl  implements EntityDAO{
    private static EntityDAOImpl dbInstance = null;
    private Connection dbConnection;

    /**Constructor private without parameters because is a Singleton class*/
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

    /**Method to get a single class instance
     * @return an instance of class*/
    public static EntityDAOImpl getDbInstance(){
        if(dbInstance == null){
            dbInstance = new EntityDAOImpl();
        }
        return dbInstance;
    }

    /**Method returns necessary infos for a Player
     * @return a Player*/
    @Override
    public Player getHeroById(String id) {
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


    /**Method returns necessary infos for a Mob
     * @return a Mob*/
    @Override
    public Mob getEnemyById(String id) {
        Mob mob = null;
        Statistics stats;
        MobSprite ms;
        ArrayList<String> path = new ArrayList<>();

        try {
            String query = "select enemy_hp, enemy_defense, enemy_atk, enemy_stamina, sprite1, position_x, position_y\n" +
                            "from enemy join entitysprite on enemy.enemy_idSprite = entitysprite.sprite_id join spriteposition on entitysprite.sprite_id = spriteposition.sprite_id\n"+
                            "where enemy.enemy_id = " + id;

            Statement stmt = this.dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int enemy_hp = rs.getInt("enemy_hp");
                int enemy_defense = rs.getInt("enemy_defense");
                int enemy_atk = rs.getInt("enemy_atk");
                int enemy_stamina = rs.getInt("enemy_stamina");
                String sprite1 = rs.getString("sprite1");
                path.add(sprite1);
                int position_x = rs.getInt("position_x");
                int position_y = rs.getInt("position_y");

                stats = new Statistics(enemy_hp, enemy_defense, enemy_stamina, enemy_atk);
                ms = new MobSprite(position_x, position_y);
                ms.setSpritesPath(path);
                mob = new Mob(stats, ms);
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return mob;
    }

    /**Method returns necessary infos for a npc
     * @return a Npc*/
    @Override
    public Npc getNpcById(String id) {
        Npc npc = null;
        NPCSprite ns;
        ArrayList<String> path = new ArrayList<>();

        try{
            String query = "select sprite1, option1, option2, dialogue, dialogue_iconPath, position_x, position_y\n" +
                    "from npc join plot on npc.npc_idDialogue = plot.id_dialogue join entitysprite on entitysprite.sprite_id = npc.sprite_id join spriteposition on entitysprite.sprite_id = spriteposition.sprite_id\n" +
                    "where npc.npc_id = " + id;

            Statement stmt = this.dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                String sprite1 = rs.getString("sprite1");
                path.add(sprite1);
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String dialogue = rs.getString("dialogue");
                String dialogue_iconPath = rs.getString("dialogue_iconPath");
                int position_x = rs.getInt("position_x");
                int position_y = rs.getInt("position_y");

                ns = new NPCSprite(position_x, position_y, dialogue_iconPath);
                ns.setSpritesPath(path);
                npc = new Npc(ns, dialogue, option1, option2);
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return npc;
    }
}
