package model.Character;

public class Wizard extends Character {
    public Wizard(String classType,int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType,initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
        this.setClassType("Wizard");
        this.setInitiative(6);
        this.setHp(4);
        this.setAttack(9);
        this.setAgility(4);
        this.setCoin(0);
        this.setCoinBag(0);
        this.setGoldJewelry(0);
        this.setGemstone(0);
        this.setTreasureBox(0);

    }
    //The Wizard character special attack.
    public void starLight(){
        //Make monsters blind and have a 80% chance to run away
    }
}
