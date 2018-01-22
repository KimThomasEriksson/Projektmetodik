package model.Character;

import model.Monster.Monster;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Character implements Serializable,CharacterInterface{
    private String classType;
    private String name;
    private int initiative;
    private int hp;
    private int attack;
    private int agility;
    private int coin;
    private int coinBag;
    private int goldJewelry;
    private int gemstone;
    private int treasureBox;
    private boolean firstHit = true;
    private int giantSpidersSlain;
    private int skeletonsSlain;
    private int orcSlain;
    private int trollSlain;
    private int totalScore;

    //Character constructor and all get and setters.



    public Character(String classType,String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        this.classType = classType;
        this.name =name;
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

    // used from view, searches and loads saved character
    public Character loadCharacterFromStorage(String name){

        Character myCharacter;

        // search storage for match and return the right object with given name

        return null;
    }

    public void attackMonster(Monster monster, boolean quickCombat){
        int attackDamage = 0;
        int monsterAgility = 0;

        //Rullar varje tärning och adderar det till attackdamage variablen
        for (int i = 1; i <= this.attack; i++){
            attackDamage = ThreadLocalRandom.current().nextInt(1, 6 + 1) + attackDamage;
        }

        //variabel för att spara monstrets agilitiy roll
        for (int i = 1; i <= monster.getAgility(); i++){
            monsterAgility = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterAgility ;
        }

        //bara development syfte för att se rollsen
        if(!quickCombat) {
            System.out.println("Your attack: " + attackDamage);
            System.out.println("Monster agility: " + monsterAgility);
            System.out.println(" ");
        }
        //kollar om spelarens attack är högre än monstrets agility, applicerar thiefs passive om spelaren är en
        if (attackDamage>monsterAgility){

            if(this.classType.equals("Thief")){
                int critChance = ThreadLocalRandom.current().nextInt(1,4 + 1);
                if(critChance == 1){
                    if(!quickCombat) {
                        System.out.println("You crit the " + monster.getClassType());
                    }
                        monster.setHp(monster.getHp() - 2);

                }
                else{
                    if(!quickCombat) {
                        System.out.println("You attack the " + monster.getClassType());
                    }
                    monster.takeDamage();
                }
            }
            else {
                if(!quickCombat) {
                    System.out.println("You attack the " + monster.getClassType());
                }
                monster.takeDamage();
            }
        }
        else if (attackDamage < monsterAgility){
            if(!quickCombat) {
                System.out.println("Your attack missed! ");
            }
        }
    }
    //Tar in ett monster objekt och använder dens attribut och funktioner
    public void defendAttack(Monster monster, boolean quickCombat){

        //Variabler för att komma ihåg spelarens smidighets roll och monstrets attack roll
        int monsterAttackDamage = 0;
        int playerAgility = 0;


        //rolls för monstrets skada och spelarens agilitiy
        for (int i = 1; i <=monster.getAttack(); i++){
            monsterAttackDamage = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterAttackDamage;
        }


        for (int i = 1; i <= this.agility; i++){
            playerAgility  = ThreadLocalRandom.current().nextInt(1, 6 + 1) + playerAgility;
        }
        System.out.println(" ");

        //Kollar om monstrets attack träffar eller inte, om den träffar kollar den om spelaren är en knight och om detta är första slaget
        if(monsterAttackDamage<playerAgility){
            if(!quickCombat) {
                System.out.println(monster.getClassType() + "s attack missed!" + "\n");
            }
        }
        else if(monsterAttackDamage>playerAgility){
            if(firstHit && this.classType.equals("Knight")){
                if(!quickCombat) {
                    System.out.println("You block " + monster.getClassType() + " attack");
                }
                firstHit = false;
            }
            else {
                if(!quickCombat) {
                    System.out.println(monster.getClassType() + "s attack hit!");
                }
                this.hp = this.hp - 1;
            }
        }
    }
    //Returnar true om spelaren kan fly och false om inte
    public boolean flee(){
        Random rand = new Random();
        //wizards passiva ger 80% till att fly
        if (this.classType.equals("Wizard")){
            if (rand.nextInt(100)<80){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            if (rand.nextInt(100) < (this.agility * 10)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return name + "\t\t<" + classType + ">\n";
    }

    @Override
    public String previewLogo() {
        return null;
    }

    @Override
    public void resetStats(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public void raiseSpidersSlain() {
        this.giantSpidersSlain+=1;
        }
    public void raiseSkeletonsSlain(){
        this.skeletonsSlain+=1;
    }
    public void orcSlain(){
        this.orcSlain+=1;
    }
    public void trollStailn(){
        this.trollSlain+=1;
    }

    public int getGiantSpidersSlain() {
        return giantSpidersSlain;
    }

    public void setGiantSpidersSlain(int giantSpidersSlain) {
        this.giantSpidersSlain = giantSpidersSlain;
    }

    public int getSkeletonsSlain() {
        return skeletonsSlain;
    }

    public void setSkeletonsSlain(int skeletonsSlain) {
        this.skeletonsSlain = skeletonsSlain;
    }

    public int getOrcSlain() {
        return orcSlain;
    }

    public void setOrcSlain(int orcSlain) {
        this.orcSlain = orcSlain;
    }

    public int getTrollSlain() {
        return trollSlain;
    }

    public void setTrollSlain(int trollSlain) {
        this.trollSlain = trollSlain;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
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

    //Reglera om det ska vara det första slaget i en strid
    public void setFirstHit(boolean trueFalse){
        this.firstHit = trueFalse;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public boolean isFirstHit() {
        return firstHit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return getInitiative() == character.getInitiative() &&
                getHp() == character.getHp() &&
                getAttack() == character.getAttack() &&
                getAgility() == character.getAgility() &&
                getCoin() == character.getCoin() &&
                getCoinBag() == character.getCoinBag() &&
                getGoldJewelry() == character.getGoldJewelry() &&
                getGemstone() == character.getGemstone() &&
                getTreasureBox() == character.getTreasureBox() &&
                isFirstHit() == character.isFirstHit() &&
                Objects.equals(getClassType(), character.getClassType()) &&
                Objects.equals(getName(), character.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getClassType(), getName(), getInitiative(), getHp(), getAttack(), getAgility(), getCoin(), getCoinBag(), getGoldJewelry(), getGemstone(), getTreasureBox(), isFirstHit());
    }
}
