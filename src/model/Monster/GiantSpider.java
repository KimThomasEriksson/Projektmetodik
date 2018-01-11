package model.Monster;

// inheritance of  main MonsterCharacter Attributes For GiantSpider.

public class GiantSpider extends Monster {
    public GiantSpider(){
        super();
        this.setClassType("GiantSpider");
        this.setInitiative(7);
        this.setHp(1);
        this.setAttack(2);
        this.setAgility(3);
        this.setCommonality(20);

    }



}
