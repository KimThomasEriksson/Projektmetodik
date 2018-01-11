package model.Monster;

// inheritance of  main MonsterCharacter Attributes For Skeleton.

public class Skeleton extends Monster {
    public Skeleton(){
        super();
        this.setClassType("Skeleton");
        this.setInitiative(4);
        this.setHp(2);
        this.setAttack(3);
        this.setAgility(3);
        this.setCommonality(15);

    }



}
