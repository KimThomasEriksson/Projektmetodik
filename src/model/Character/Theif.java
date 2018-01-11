package model.Character;

public class Theif extends Character{
    public Theif(String classType,int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType,initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
        classType ="Theif";
        initiative = 7;
        hp = 5;
        attack = 5;
        agility = 7;
        coin = 0;
        coinBag = 0;
        goldJewelry = 0;
        gemstone = 0;
        treasureBox = 0;
    }
    //The Thiefs character special attack.
    public int criticalHit(){
        int attack = getAttack();
        return attack*2;
        //25% chance to make double damage every attack
    }
}
