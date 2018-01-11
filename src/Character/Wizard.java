package Character;

public class Wizard extends Character {
    public Wizard(int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
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

    public void starLight(){
        //Make monsters blind and have a 80% chance to run away
    }
}
