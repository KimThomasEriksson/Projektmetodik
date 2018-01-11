package model.Character;

public class Knight extends Character {
    public Knight(String classType,int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType,initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
        classType = "Knight";
        initiative = 5;
        hp = 9;
        attack = 6;
        agility = 4;
        coin = 0;
        coinBag = 0;
        goldJewelry = 0;
        gemstone = 0;
        treasureBox = 0;
    }
    //The Knights character special attack.
    public void ShieldBlock(){
        //Always blocks the first attack per fight
    }
}
