package it.unipa.iss.rpg.combat.model;
import java.lang.Cloneable;
public  class Statistics implements IAttack,Cloneable{
    private int maxHp;
    private int def;
    private int stamina;
    private int atk;

    public  Statistics(){
        this.maxHp = 0;
        this.def = 0;
        this.stamina = 0;
        this.atk = 0;
    }
    public  Statistics(int hp,int def,int stamina , int atk){
        this.atk = atk;
        this.def = def;
        this.stamina = stamina;
        this.maxHp = hp;

    }
    public  int getMaxHp(){
        return this.maxHp;
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

    public void attack(){
        //change
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
