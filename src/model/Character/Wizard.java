package model.Character;

public class Wizard extends Character {
    public Wizard(String classType,int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType,initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
        classType = "Wizard";
        initiative = 6;
        hp = 4;
        attack = 9;
        agility = 4;
        coin = 0;
        coinBag = 0;
        goldJewelry = 0;
        gemstone = 0;
        treasureBox = 0;
    }
    //The Wizard character special attack.
    public void starLight(){
        //Make monsters blind and have a 80% chance to run away
    }
}
