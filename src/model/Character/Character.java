package model.Character;

public class Character {
    private String classType;
    private int initiative;
    private int hp;
    private int attack;
    private int agility;
    private int coin;
    private int coinBag;
    private int goldJewelry;
    private int gemstone;
    private int treasureBox;

    //Character constructor and all get and setters.



    public Character(String classType, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        this.classType = classType;
        this.initiative = initiative;
        this.hp = hp;
        this.attack = attack;
        this.agility = agility;
        this.coin = coin;
        this.coinBag = coinBag;
        this.goldJewelry = goldJewelry;
        this.gemstone = gemstone;
        this.treasureBox = treasureBox;
    }

    public Character() {

    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setCoinBag(int coinBag) {
        this.coinBag = coinBag;
    }

    public void setGoldJewelry(int goldJewelry) {
        this.goldJewelry = goldJewelry;
    }

    public void setGemstone(int gemstone) {
        this.gemstone = gemstone;
    }

    public void setTreasureBox(int treasureBox) {
        this.treasureBox = treasureBox;
    }

    public int getCoin() {
        return coin;
    }

    public void raiseCoin() {
        this.coin+=1;
    }

    public int getCoinBag() {
        return coinBag;
    }

    public void raiseCoinBag() {
        this.coinBag+=1;
    }

    public int getGoldJewelry() {
        return goldJewelry;
    }

    public void raiseGoldJewelry() {
        this.goldJewelry+=1;
    }

    public int getGemstone() {
        return gemstone;
    }

    public void raiseGemstone() {
        this.gemstone+=1;
    }

    public int getTreasureBox() {
        return treasureBox;
    }

    public void raiseTreasureBox() {
        this.treasureBox+=1;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
