package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.collision.MobListener;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WorldController extends GameController implements IPlayerListener {

    private MovementHandler movementHandler;
    private MobListener mobListener;
    private List<Mob> collisions;

    private BufferedImage[][] worldTiles;

    public WorldController(Player player, WorldPanel gamePanel) {
        super(player, gamePanel);
        movementHandler = new MovementHandler();
        movementHandler.attach(this);
        this.getGamePanel().addKeyListener(movementHandler);
        //TODO: REFACTOR
        gamePanel.addController(this);
        collisions = new LinkedList<>();
        this.mobListener = new MobListener(null);

        this.worldTiles = new BufferedImage[getGamePanel().getMaxRow()][getGamePanel().getMaxCol()];
        loadWorldTiles();

    }

    private void loadWorldTiles() {
        File map = new File("src/res/world/level_start/map.txt");
        try {
            Scanner s = new Scanner(map);

            for (int i = 0; i < getGamePanel().getMaxRow(); i++) {
                for (int j = 0; j < getGamePanel().getMaxCol(); j++) {
                    this.worldTiles[i][j] = ImageIO.read(new File("src/res/world/level_start/" + s.nextInt() + ".png"));
                }
            }

            s.close();
        }catch (IOException ex){
            ex.printStackTrace();
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
        try {
            //sistema di coordinate di swing: basso +y, destra +x
            int k = 0;

            for (int i = 0; i < getGamePanel().getMaxCol(); i++) {
                for (int j = 0; j < getGamePanel().getMaxRow(); j++) {
                    g.drawImage(this.worldTiles[j][i], i * getGamePanel().scaleTile(), j * getGamePanel().scaleTile(), getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
                }
            }

            BufferedImage testEnemy = ImageIO.read(new File("src/res/mob/baboon.png"));
            g.drawImage(testEnemy, 288, 384, getGamePanel().scaleTile(), getGamePanel().scaleTile(), null);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(EventType e) {
        Player player = this.getPlayer();
        player.move(e);

        int x = player.getPlayerSprite().getWorldX();
        int y = player.getPlayerSprite().getWorldY();

        //System.out.printf("(%d, %d)\n", x, y);

        if(x >= 288- (getGamePanel().scaleTile()/2) && x <= 288 + (getGamePanel().scaleTile()/2) &&
           y >= 384 -(getGamePanel().scaleTile()/2) && y <= 384 + (getGamePanel().scaleTile()/2)) {
            this.collisions.add(new Mob( new Statistics(10, 10, 10 ,10)));
            this.mobListener.update(this);
        }

        //System.out.printf("New Coordinates: %d %d\n", player.getWorldX(), player.getWorldY());
        this.getGamePanel().repaint();
    }

    @Override
    public void runController() {
        //TODO: ATTACH/DETACH QUA
        int fps = 60;
        double drawInterval = (double)1000000000/fps;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(isActive()) {
            //TODO: It must be initialize the Subscribers Entity
            //      of Observer-Pattern
            //TODO: When the player collide into a Entity gamePanel
            //      must send as parameter to the Observer-Pattern
            //      notifyController(gamePanel)
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

    public List<Mob> getCollisions() {
        return collisions;
    }

    public void setCollisions(List<Mob> collisions) {
        this.collisions = collisions;
    }
}
