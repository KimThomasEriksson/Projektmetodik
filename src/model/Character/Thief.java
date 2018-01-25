package model.Character;

import java.io.Serializable;

public class Thief extends Character implements Serializable {
    public Thief() {
        super("Thief","",7,5,5,7,0,0,0,0,0);
    }

    public void resetStats(){

        this.setInitiative(7);
        this.setHp(5);
        this.setAttack(5);
        this.setAgility(7);
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
    public Thief(String classType, String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType, name, initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
    }

    //The Thief's character special attack.
    public int criticalHit(){
        int attack = getAttack();
        return attack*2;
        //25% chance to make double damage every attack
    }

    // UI representation of the class with logo and attributes

    public String previewLogo(){
        return  "NAME: " + this.getName() +"\n"+
                "\t\t\t\t     ,/|\\\n" +
                "THIEF:\t\t\t\t     //&')\n" +
                "\t\t\t\t     '')(\n" +
                "\t\t\t\t      (( )\n" +
                "Initiative= " + this.getInitiative() + "\t\t\t      )( (\n" +
                "HP= " + this.getHp() + "\t\t\t\t      (=M=[)####>\n" +
                "Attack= " + this.getAttack() + "\t\t\t      (( )\n" +
                "Agility= " + this.getAgility() + "\t\t\t      (( )_\n" +
                "\t\t\t\t      ((__,)\n\n" +
                "Special attack:\n" +
                "25% chance to make double damage every attack.\n\n\n" +
                "TreasureBox: " + getTreasureBox() + "\n" +
                "Coin: " + getCoin() + "\tCoinBag: " + getCoinBag() + "\n" +
                "GoldJewelry: " + getGoldJewelry() + "\tGemstone: " + getGemstone() + "\n\n" +
                "Giant Spiders Slain: " + getGiantSpidersSlain() + "\n" +
                "Skeletons Slain: " + getSkeletonsSlain() + "\n" +
                "Orcs Slain: " + getOrcSlain() + "\n" +
                "Trolls Slain: " + getTrollSlain();

    }


}
