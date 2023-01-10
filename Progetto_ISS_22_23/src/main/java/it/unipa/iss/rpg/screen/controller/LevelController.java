package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.model.*;
import it.unipa.iss.rpg.screen.model.collision.MobListener;
import it.unipa.iss.rpg.screen.model.collision.NPCListener;
import it.unipa.iss.rpg.screen.model.entitities.*;
import it.unipa.iss.rpg.screen.view.WorldPanel;

import java.awt.*;

public class LevelController extends GameController implements PlayerListener {
    private final MovementHandler movementHandler;
    private final MobListener mobListener;
    private Level level;
    private final DecisionController decisionController;
    private Mob lastCollisionMob;
    private final DrawController drawController;
    private final LevelLoader levelLoader;


    public LevelController(Player player, WorldPanel gamePanel) {
        super(player, gamePanel);

        movementHandler = new MovementHandler();
        this.getGamePanel().addKeyListener(movementHandler);
        this.decisionController = new DecisionController();

        //TODO: REFACTOR
        gamePanel.addController(this);
        this.mobListener = new MobListener(null);

        drawController = new DrawController(gamePanel.scaleTile(), gamePanel.getMaxRow(), gamePanel.getMaxCol());
        levelLoader = new LevelLoader(gamePanel.scaleTile(), gamePanel.getMaxRow(), gamePanel.getMaxCol());
        levelLoader.loadPlayer(player);
        this.level = levelLoader.loadLevel();
    }

    @Override
    public void update(EventType e) {
        Player player = this.getPlayer();
        Map map = level.getCurrentMap();

        player.move(e);

        //System.out.printf("(%d, %d)\n", player.getPlayerSprite().getWorldX(), player.getPlayerSprite().getWorldY());

        int x = player.getPlayerSprite().getWorldX();
        int y = player.getPlayerSprite().getWorldY();

        int col = (int)Math.floor((double)x/96);
        int row = (int) Math.floor((double) y/96) ;

        if(map.getEnemy(row, col) != null) {
            this.mobListener.update(this);
            this.lastCollisionMob = map.getEnemy(row, col);
            map.removeMob(row, col);
        } else if (map.getNpc(row, col) != null) {
            NPCListener npcListener = new NPCListener(map.getNpc(row, col));
            npcListener.update(this);
            map.removeNpc(row, col);
        } else if(map.getEndMap(row, col)) {
            level.switchMap();
            player.getPlayerSprite().setWorldX(490);
            player.getPlayerSprite().setWorldY(490);
        }
   }

    @Override
    public void runController() {
        setActive(true);
        movementHandler.attach(this);

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

    public Mob getCollisionMob(){
        return this.lastCollisionMob;
    }

    public void updateDecisionTree(boolean b) {
        this.decisionController.updateDecisionTree(b);
    }

    public void draw(Graphics2D g2) {
        drawController.drawWorld(g2, this.level.getCurrentMap());
        drawController.drawEnemies(g2, this.level.getCurrentMap());
        drawController.drawCharacters(g2,this.level.getCurrentMap());
        drawController.drawPlayer(g2, this.getPlayer());
    }
}
