package model.Character;

import java.io.Serializable;

public class Knight extends Character implements Serializable {
    public Knight() {
        super("Knight", "", 5, 9, 6, 4, 0, 0, 0, 0, 0);
    }

    public void resetStats(){

        this.setInitiative(5);
        this.setHp(9);
        this.setAttack(6);
        this.setAgility(4);
        if (this.getName().startsWith("AI")){

            setTreasureBox(0);
            setCoin(0);
            setCoinBag(0);
            setGoldJewelry(0);
            setGemstone(0);
            setGiantSpidersSlain(0);
            setSkeletonsSlain(0);
            setOrcSlain(0);
            setTrollSlain(0);
        }

    }

    //This constructor is used when we load in a character from save file.
    public Knight(String classType, String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType, name, initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
    }

    //The Knights character special attack.
    public void ShieldBlock() {
        //Always blocks the first attack per fight
    }

    // UI representation of the class with logo and attributes

    public String previewLogo() {
        return "NAME: " + this.getName() + "\n" +
                "\t\t\t\t              /\n" +
                "KNIGHT:\t\t\t\t       ,~~   /\n" +
                "\t\t\t\t   _  <=)  _/_\n" +
                "\t\t\t\t  /I\\.=\"==.{>\n" +
                "Initiative= " + this.getInitiative() + "\t\t\t  \\I/-\\T/-'\n" +
                "HP= " + this.getHp() + "\t\t\t\t      /_\\\n" +
                "Attack= " + this.getAttack() + "\t\t\t     // \\\\_\n" +
                "Agility= " + this.getAgility() + "\t\t\t    _I    /\n\n" +
                "Special attack:\n" +
                "Always blocks the first attack per fight.\n\n\n" +
                "TreasureBox: " + getTreasureBox() + "\n" +
                "Coin: " + getCoin() + "\tCoinBag: " + getCoinBag() + "\n" +
                "GoldJewelry: " + getGoldJewelry() + "\tGemstone: " + getGemstone() + "\n\n" +
                "Giant Spiders Slain: " + getGiantSpidersSlain() + "\n" +
                "Skeletons Slain: " + getSkeletonsSlain() + "\n" +
                "Orcs Slain: " + getOrcSlain() + "\n" +
                "Trolls Slain: " + getTrollSlain();
    }



}
