package Character;

public class Knight extends Character {

    public Knight(int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
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

    public void ShieldBlock(){
        //Always blocks the first attack per fight
    }
}
