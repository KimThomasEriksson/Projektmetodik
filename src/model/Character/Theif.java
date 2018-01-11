package model.Character;

public class Theif extends Character{
    public Theif() {
        super();
        this.setClassType("Thief");
        this.setInitiative(7);
        this.setHp(5);
        this.setAttack(5);
        this.setAgility(7);
        this.setCoin(0);
        this.setCoinBag(0);
        this.setGoldJewelry(0);
        this.setGemstone(0);
        this.setTreasureBox(0);
    }
    //The Thiefs character special attack.
    public int criticalHit(){
        int attack = getAttack();
        return attack*2;
        //25% chance to make double damage every attack
    }
}
