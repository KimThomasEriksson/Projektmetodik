package model.Monster;

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

    }
    public Monster() {
    }

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

    @Override
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

