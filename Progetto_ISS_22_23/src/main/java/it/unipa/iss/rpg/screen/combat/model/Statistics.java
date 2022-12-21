package it.unipa.iss.rpg.screen.combat.model;
import java.lang.Cloneable;
public  class Statistics implements Cloneable{
    private int hp;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    private int def;
    private int stamina;
    private int atk;

    //da cancellare
    public  Statistics(){

    }
    public  Statistics(int hp,int def,int stamina , int atk){
        this.atk = atk;
        this.def = def;
        this.stamina = stamina;
        this.hp = hp;

    }
    public  int getHp(){
        return this.hp;
    }
    public int getDef(){
        return this.def;
    }
    public int getStamina(){
        return this.stamina;
    }
    public int getAtk(){
        return this.atk;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
