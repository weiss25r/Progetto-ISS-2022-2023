package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.collision.MobListener;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.MobSprite;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.GamePanel;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WorldController extends GameController implements IPlayerListener {
    private MovementHandler movementHandler;
    private MobListener mobListener;
    private BufferedImage[][] worldTiles;
    private Mob[][] worldEnemies;

    private Mob lastCollisionMob;

    public WorldController(Player player, WorldPanel gamePanel) {
        super(player, gamePanel);
        movementHandler = new MovementHandler();
        this.getGamePanel().addKeyListener(movementHandler);

        //TODO: REFACTOR
        gamePanel.addController(this);
        this.mobListener = new MobListener(null);
        this.worldTiles = new BufferedImage[getGamePanel().getMaxRow()][getGamePanel().getMaxCol()];


        this.worldEnemies = new Mob[getGamePanel().getMaxRow()][getGamePanel().getMaxCol()];
        loadWorldTiles();
        //collisions[]
    }

    public boolean loadWorldTiles() {
        File map = new File("src/res/world/level_start/map.txt");
        File enemies = new File("src/res/world/level_start/enemies/enemies.txt");

        try {
            FileInputStream stream = new FileInputStream(enemies);
            Scanner s = new Scanner(map);

            for (int i = 0; i < getGamePanel().getMaxRow(); i++) {
                for (int j = 0; j < getGamePanel().getMaxCol(); j++) {
                    this.worldTiles[i][j] = ImageIO.read(new File("src/res/world/level_start/world/" + s.nextInt() + ".png"));
                    char t = (char)stream.read();

                    if(Character.isDigit(t)) {
                        MobSprite mobSprite = new MobSprite(i*getGamePanel().scaleTile(), j*getGamePanel().scaleTile());
                        mobSprite.addSprite(new Tile(ImageIO.read(new File("src/res/world/level_start/enemies/" + t + ".png"))));
                        Mob mob = new Mob(new Statistics(80, 80, 80, 80), mobSprite);

                        worldEnemies[i][j] = mob;
                    }
                }
            }

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
        //sistema di coordinate di swing: basso +y, destra +x
        int k = 0;

        for (int i = 0; i < getGamePanel().getMaxCol(); i++) {
            for (int j = 0; j < getGamePanel().getMaxRow(); j++) {
                g.drawImage(this.worldTiles[j][i], i * getGamePanel().scaleTile(), j * getGamePanel().scaleTile(), getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
            }
        }
    }

    public void drawEnemies(Graphics2D g) {
        int k = 0;

        for (int i = 0; i < getGamePanel().getMaxCol(); i++) {
            for (int j = 0; j < getGamePanel().getMaxRow(); j++) {
                if(this.worldEnemies[j][i] != null)
                    g.drawImage(this.worldEnemies[j][i].getMobSprite().getDefaultSprite(), i * getGamePanel().scaleTile(), j * getGamePanel().scaleTile(), getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
            }
        }
    }

    @Override
    public void update(EventType e) {
        Player player = this.getPlayer();
        player.move(e);

        int x = player.getPlayerSprite().getWorldX();
        int y = player.getPlayerSprite().getWorldY();

        int col = x/96;
        int row = y/96 ;

        if(worldEnemies[row][col] != null) {
            this.mobListener.update(this);
            this.lastCollisionMob = worldEnemies[row][col];

            this.worldEnemies[row][col] = null;
        }
        this.getGamePanel().repaint();
    }

    @Override
    public void runController() {
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

}
