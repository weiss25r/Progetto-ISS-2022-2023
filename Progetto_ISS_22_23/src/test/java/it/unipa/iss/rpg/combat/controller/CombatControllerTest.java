package it.unipa.iss.rpg.combat.controller;

import it.unipa.iss.rpg.combat.model.AbilityBox;
import it.unipa.iss.rpg.combat.model.Statistics;
import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.Mob;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.combat.view.CombatPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CombatControllerTest {
    private CombatController controller;
    private Statistics stats ;
    private Mob enemy ;
    private CombatPanel view ;
    private Player player ;

    @BeforeEach
    void setUp(){
        //simulating the constructor
       this.stats =  new Statistics(100,20,50,20);
       this.enemy =  new Mob(this.stats);
       this.view  = new CombatPanel();
       this.player = new Player();

       this.controller = new CombatController(this.player,this.view,this.enemy);

    }
    @Test
    void updateTest(){
        this.controller.getFight().inputAction(1);
        //this.controller.getFight().getHpHeroRemaining();
        this.controller.update(EventType.PLAYER_ATK);

        assertEquals(Integer.toString(this.controller.getFight().getHpHeroRemaining()),
                controller.getView().getLblPlayerHp().getText().substring(11,controller.getView().getLblPlayerHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getHpEnemyRemaining()),
                controller.getView().getLblEnemyHp().getText().substring(10,controller.getView().getLblEnemyHp().getText().length()));

        //Test Corruptive_Atk
        this.controller.getFight().setSkill(AbilityBox.CORRUPTIVE_ATK);
        this.controller.getFight().inputAction(2);
        this.controller.update(EventType.PLAYER_ABILITY);
        assertEquals(Integer.toString(this.controller.getFight().getHpHeroRemaining()),
                controller.getView().getLblPlayerHp().getText().substring(11,controller.getView().getLblPlayerHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getHpEnemyRemaining()),
                controller.getView().getLblEnemyHp().getText().substring(10,controller.getView().getLblEnemyHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getStaminaHeroRemaining()),
                controller.getView().getLblPlayerStamina().getText().substring(15,controller.getView().getLblPlayerStamina().getText().length()));


        //Test sinner atk
        this.controller.getFight().setSkill(AbilityBox.SINNER_ATK);
        this.controller.getFight().inputAction(2);
        this.controller.update(EventType.PLAYER_ABILITY);
        assertEquals(Integer.toString(this.controller.getFight().getHpHeroRemaining()),
                controller.getView().getLblPlayerHp().getText().substring(11,controller.getView().getLblPlayerHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getHpEnemyRemaining()),
                controller.getView().getLblEnemyHp().getText().substring(10,controller.getView().getLblEnemyHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getStaminaHeroRemaining()),
                        controller.getView().getLblPlayerStamina().getText().substring(15,controller.getView().getLblPlayerStamina().getText().length()));

        //Test StudyPower
        this.controller.getFight().setSkill(AbilityBox.STUDY_POWER);
        this.controller.getFight().inputAction(2);
        this.controller.update(EventType.PLAYER_ABILITY);
        assertEquals(Integer.toString(this.controller.getFight().getHpHeroRemaining()),
                controller.getView().getLblPlayerHp().getText().substring(11,controller.getView().getLblPlayerHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getHpEnemyRemaining()),
                controller.getView().getLblEnemyHp().getText().substring(10,controller.getView().getLblEnemyHp().getText().length()));
        assertEquals(Integer.toString(this.controller.getFight().getStaminaHeroRemaining()),
                controller.getView().getLblPlayerStamina().getText().substring(15,controller.getView().getLblPlayerStamina().getText().length()));

        //Test Healing
        this.controller.getFight().setSkill(AbilityBox.HEALING);
        this.controller.getFight().inputAction(2);
        this.controller.update(EventType.PLAYER_ABILITY);
        assertEquals(Integer.toString(this.controller.getFight().getHpHeroRemaining()),
                controller.getView().getLblPlayerHp().getText().substring(11,controller.getView().getLblPlayerHp().getText().length()));
    }

}