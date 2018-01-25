package model.Character;

import java.io.Serializable;

public class Wizard extends Character implements Serializable {
    public Wizard() {
        super("Wizard","",6,4,9,4,0,0,0,0,0);
    }

    public void resetStats(){

        this.setInitiative(6);
        this.setHp(4);
        this.setAttack(9);
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
    public Wizard(String classType, String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType, name, initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
    }

    //The Wizard character special attack.
    public void starLight(){
        //Make monsters blind and have a 80% chance to run away
    }


    // UI representation of the class with logo and attributes

    public String previewLogo(){
        return  "NAME: " + this.getName() +"\n"+
                "\t\t\t\t         ,/   *\n" +
                "WIZARD:\t\t\t\t      _,'/_   |\n" +
                "\t\t\t\t      `(\")' ,'/\n" +
                "\t\t\t\t   _ _,-H-./ /\n" +
                "Initiative= " + this.getInitiative() + "\t\t\t   \\_\\_\\.   /\n" +
                "HP= " + this.getHp() + "\t\t\t\t     )\" |  (\n" +
                "Attack= " + this.getAttack() + "\t\t\t  __/   H   \\__\n" +
                "Agility= " + this.getAgility() + "\t\t\t  \\    /|\\    /\n" +
                "\t\t\t\t   `--'|||`--'\n" +
                "\t\t\t\t      ==^==\n\n" +
                "Special attack:\n" +
                "Make monsters blind and have a 80% chance to run away.\n\n\n" +
                "TreasureBox: " + getTreasureBox() + "\n" +
                "Coin: " + getCoin() + "\tCoinBag: " + getCoinBag() + "\n" +
                "GoldJewelry: " + getGoldJewelry() + "\tGemstone: " + getGemstone() + "\n\n" +
                "Giant Spiders Slain: " + getGiantSpidersSlain() + "\n" +
                "Skeletons Slain: " + getSkeletonsSlain() + "\n" +
                "Orcs Slain: " + getOrcSlain() + "\n" +
                "Trolls Slain: " + getTrollSlain();
    }
}
