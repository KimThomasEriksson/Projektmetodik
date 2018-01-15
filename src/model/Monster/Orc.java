package model.Monster;

// inheritance of main MonsterCharacter Attributes For Orc.

public class Orc extends Monster {
    public Orc (){
        super();
        this.setClassType("Orc");
        this.setInitiative(6);
        this.setHp(3);
        this.setAttack(4);
        this.setAgility(4);
        this.setCommonality(10);

    }



}
