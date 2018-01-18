package model.Monster;

// Declaration of main MonsterCharacter Attributes.

import java.util.Objects;

public class Monster {
    private String classType;
    private int initiative;
    private int hp;
    private int attack;
    private int agility;
    private float commonality;


    public Monster(String classType, int initiative, int hp, int attack, int agility, float commonality) {
        this.classType = classType;
        this.initiative = initiative;
        this.hp = hp;
        this.attack = attack;
        this.agility = agility;
        this.commonality = commonality;

        //Calls Main Monster class method.
    }
    public Monster() {
    }

    ////
    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setCommonality(float commonality) {
        this.commonality = commonality;
    }

    public String getClassType() {
        return classType;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getAgility() {
        return agility;
    }

    public float getCommonality() {
        return commonality;
    }

    public void takeDamage(){
        this.hp = this.hp - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        Monster monster = (Monster) o;
        return getInitiative() == monster.getInitiative() &&
                getHp() == monster.getHp() &&
                getAttack() == monster.getAttack() &&
                getAgility() == monster.getAgility() &&
                Float.compare(monster.getCommonality(), getCommonality()) == 0 &&
                Objects.equals(getClassType(), monster.getClassType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getClassType(), getInitiative(), getHp(), getAttack(), getAgility(), getCommonality());
    }

    public String toString() {
        return "Monster{" +
                "classType='" + classType + '\'' +
                ", initiative=" + initiative +
                ", hp=" + hp +
                ", attack=" + attack +
                ", agility=" + agility +
                ", commonality=" + commonality +
                '}';
    }
}