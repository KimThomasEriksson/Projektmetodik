package model.Character;

public class Thief extends Character{
    public Thief() {
        super();
        this.setClassType("Thief");
        this.setInitiative(7);
        this.setHp(5);
        this.setAttack(5);
        this.setAgility(7);
        this.setCoin(0);
        this.setCoinBag(0);
        this.setGoldJewelry(0);
        this.setGemstone(0);
        this.setTreasureBox(0);
    }
    //This constructor is used when we load in a character from save file.
    public Thief(String classType, String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType, name, initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
    }

    //The Thiefs character special attack.
    public int criticalHit(){
        int attack = getAttack();
        return attack*2;
        //25% chance to make double damage every attack
    }
}
