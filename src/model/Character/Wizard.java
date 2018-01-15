package model.Character;

public class Wizard extends Character {
    public Wizard() {
        super();
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
    //This constructor is used when we load in a character from save file.
    public Wizard(String classType, String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        super(classType, name, initiative, hp, attack, agility, coin, coinBag, goldJewelry, gemstone, treasureBox);
    }

    //The Wizard character special attack.
    public void starLight(){
        //Make monsters blind and have a 80% chance to run away
    }

    // UI representation of the class with logo and attributes
    public String previewLogoWizard(){
        return "\n" +
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
                "Make monsters blind and have a 80% chance to run away.";
    }
}
