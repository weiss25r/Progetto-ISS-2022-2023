package it.unipa.iss.rpg.combact;

public  class Statistics implements IAttack,Cloneable{
    private int maxHp;
    private int def;
    private int stamina;
    private int atk;

    public void Statistics(){
        this.maxHp = 0;
        this.def = 0;
        this.stamina = 0;
        this.atk = 0;
    }

    public  int getMaxHp(){
        return 0;
    }
    public int getDef(){
        return 0;
    }
    public int getStamina(){
        return 0;
    }
    public int getAtk(){
        return 0;
    }
    public Statistics clone(){
        return this; //non deve essere vuoto
    }
    public void attack(){
        //change
    }
}
