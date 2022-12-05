package it.unipa.iss.rpg.combat.model;

import java.util.Objects;

/**Class Copy, creates a character's clone
 * @author Bonura Giovanni*/

public class Copy implements Cloneable{
    private int hp, defense, damage;

    /**Constructor without parameters */
    public Copy(){}

    /**Constructor with parameters, provides character stats */
    public Copy(int hp, int defense, int damage){
        this.hp = hp;
        this.defense = defense;
        this.damage = damage;
    }

    /**Method returns character's clone
     * @return character's clone
     * @throws CloneNotSupportedException*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**Method returns current hp value
     * @return hp of character*/
    public int getHp() {
        return this.hp;
    }

    /**Method returns current defense value
     * @return defense of character*/
    public int getDefense() {
        return this.defense;
    }

    /**Method returns current damage value
     * @return damage of character*/
    public int getDamage() {
        return this.damage;
    }

    /**Override equals method*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return hp == copy.hp && defense == copy.defense && damage == copy.damage;
    }

    /**Override hashcode method*/
    @Override
    public int hashCode() {
        return Objects.hash(hp, defense, damage);
    }
}
