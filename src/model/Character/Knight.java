package model.Character;

public class Knight extends Character {
    public Knight() {
        super();
        this.setClassType("Knight");
        this.setInitiative(5);
        this.setHp(9);
        this.setAttack(6);
        this.setAgility(4);
        this.setCoin(0);
        this.setCoinBag(0);
        this.setGoldJewelry(0);
        this.setGemstone(0);
        this.setTreasureBox(0);
    }
    //This constructor is used when we load in a character from save file.
    public Knight(String classType, String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType, name, initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
    }

    //The Knights character special attack.
    public void ShieldBlock(){
        //Always blocks the first attack per fight
    }
}
