package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.collision.MobListener;
import it.unipa.iss.rpg.screen.model.collision.NPCListener;
import it.unipa.iss.rpg.screen.model.entitities.*;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelController extends GameController implements IPlayerListener {
    private final MovementHandler movementHandler;
    private final MobListener mobListener;
    private Level level;
    private final DecisionController decisionController;
    private Mob lastCollisionMob;

    public LevelController(Player player, WorldPanel gamePanel) {
        super(player, gamePanel);
        movementHandler = new MovementHandler();
        this.getGamePanel().addKeyListener(movementHandler);
        this.decisionController = new DecisionController();

        //TODO: REFACTOR
        gamePanel.addController(this);
        this.mobListener = new MobListener(null);


        loadMap();

    }
    public boolean loadMap() {
        MapBuilder builder = new MapBuilder();
        builder.buildWorldTiles(getGamePanel().getMaxRow(), getGamePanel().getMaxCol());
        builder.buildMapNpc(getGamePanel().getMaxRow(), getGamePanel().getMaxCol());
        builder.buildMapEnemies(getGamePanel().getMaxRow(), getGamePanel().getMaxCol());

        File map = new File("src/res/world/level_start/map.txt");
        File enemies = new File("src/res/world/level_start/enemies/enemies.txt");

        try {
            FileInputStream stream = new FileInputStream(enemies);
            Scanner s = new Scanner(map);

            for (int i = 0; i < getGamePanel().getMaxRow(); i++) {
                for (int j = 0; j < getGamePanel().getMaxCol(); j++) {
                    builder.addWorldTile(ImageIO.read(new File("src/res/world/level_start/world/" + s.nextInt() + ".png")), i, j);
                    char t = (char)stream.read();

                    if(Character.isDigit(t)) {
                        MobSprite mobSprite = new MobSprite(i*getGamePanel().scaleTile(), j*getGamePanel().scaleTile());
                        mobSprite.addSprite(new Tile(ImageIO.read(new File("src/res/world/level_start/enemies/" + t + ".png"))));

                        //TODO: CARICAMENTO MOB DA DATABASE
                        Mob mob = new Mob(new Statistics(80, 80, 80, 80), mobSprite);

                        builder.addMob(mob, i, j);
                    }
                }
            }

            //TODO: refactoring

            NPCSprite npcSprite = new NPCSprite(2* getGamePanel().scaleTile(), 2* getGamePanel().scaleTile(),"src/res/npc/bob.png");
            npcSprite.addSprite(new Tile(ImageIO.read(new File("src/res/npc/bob_down.png"))));

            Npc npc = new Npc(npcSprite, "Lorem ipsum ....", "Yes", "No");
            builder.addNpc(npc, 2, 2);

            ArrayList<Map> maps = new ArrayList<>();
            maps.add(builder.build());

            //TODO: caricare seconda mappa
            this.level = new Level(maps);

            s.close();
            stream.close();
            return true;
        }catch (IOException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public void drawPlayer(Graphics2D g) {
        g.drawImage(getPlayer().getDirectionImage(),
                getPlayer().getPlayerSprite().getWorldX(),
                getPlayer().getPlayerSprite().getWorldY(),
                getGamePanel().scaleTile(),
                getGamePanel().scaleTile(),
                null
        );
    }

    public void drawWorld(Graphics2D g){
        Map map = level.getCurrentMap();

        //sistema di coordinate di swing: basso +y, destra +x
        int k = 0;

        for (int i = 0; i < getGamePanel().getMaxCol(); i++) {
            for (int j = 0; j < getGamePanel().getMaxRow(); j++) {
                BufferedImage image = map.getTile(j, i);

                g.drawImage(image, i * getGamePanel().scaleTile(), j * getGamePanel().scaleTile(), getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
            }
        }
    }

    public void drawEnemies(Graphics2D g) {
        int k = 0;
        Map map = level.getCurrentMap();


        for (int i = 0; i < getGamePanel().getMaxCol(); i++) {
            for (int j = 0; j < getGamePanel().getMaxRow(); j++) {
                Mob mob = map.getEnemy(j, i);


                if(mob != null)
                    g.drawImage(mob.getMobSprite().getDefaultSprite(), i * getGamePanel().scaleTile(), j * getGamePanel().scaleTile(), getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
            }
        }
    }

    //TODO: assente nei class diagram
    public void drawCharacters(Graphics2D g) {
        int k = 0;
        Map map = level.getCurrentMap();


        for (int i = 0; i < getGamePanel().getMaxCol(); i++) {
            for (int j = 0; j < getGamePanel().getMaxRow(); j++) {
                Npc npc = map.getNpc(j, i);

                if(npc != null)
                    g.drawImage(npc.getNpcSprite().getDefaultSprite(), i * getGamePanel().scaleTile(), j * getGamePanel().scaleTile(), getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
            }
        }
    }

    @Override
    public void update(EventType e) {
        Player player = this.getPlayer();
        Map map = level.getCurrentMap();

        player.move(e);

        int x = player.getPlayerSprite().getWorldX();
        int y = player.getPlayerSprite().getWorldY();

        int col = x/96;
        int row = y/96 ;

        if(map.getEnemy(row, col) != null) {
            this.mobListener.update(this);
            this.lastCollisionMob = map.getEnemy(row, col);

            map.removeMob(row, col);
        } else if (map.getNpc(row, col) != null) {

            //TODO: deletable
            NPCListener npcListener = new NPCListener(map.getNpc(x, y));
            npcListener.update(this);
            map.removeNpc(row, col);
        }

        this.getGamePanel().repaint();
    }

    @Override
    public void runController() {
        //this.lastCollisionMob = null;
        setActive(true);
        movementHandler.attach(this);
        //TODO: ATTACH/DETACH QUA
        int fps = 60;
        double drawInterval = (double)1000000000/fps;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(isActive()) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                this.getGamePanel().repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
        this.movementHandler.detach();
    }

    public void notifyController(){
        //TODO: notify the Collision Entity
    }

    public Mob getCollisionMob(){
        return this.lastCollisionMob;
    }

    public void updateDecisionTree(boolean b) {
        this.decisionController.updateDecisionTree(b);
    }
}
