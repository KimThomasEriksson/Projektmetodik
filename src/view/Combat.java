package view;

import model.Adventure;
import model.Monster.Monster;
import model.Character.Character;
import model.Room;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    private int currentTurn;


    public void combatStart(Monster monster, Character character, Room rooms) {
        boolean cont = false;
        Scanner scan = new Scanner(System.in);
        int playerInitiativeRoll = 0;
        int monsterInitiativeRoll = 0;
        System.out.println("a " + monster.getClassType() + " has appeared!");

        System.out.println("Do you want to (A)ttack it or try to (F)lee ?  ");
        String choice = scan.nextLine();
        if (choice.equals("A")) {
            cont = true;
        } else if (choice.equals("F")) {
            boolean tryToFlee;
            tryToFlee = character.flee();
            if (tryToFlee) {
                System.out.println("You fled from " + monster.getClassType());
                cont = false;
            } else {
                System.out.println("You've failed your escape ");
                cont = true;
            }
        }
        if (cont) {
            character.setFirstHit(true);

            //rollar initiative för att se om monstret eller spelaren ska börja
            for (int i = 1; i <= monster.getInitiative(); i++) {
                monsterInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll;
            }

            for (int i = 1; i <= character.getInitiative(); i++) {
                playerInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + playerInitiativeRoll;
            }

            System.out.println("You rolled... " + playerInitiativeRoll);
            System.out.println(monster.getClassType() + " rolled... " + monsterInitiativeRoll);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //jämför rollsen och ger current turn till den som rollade högst (currentTurn 1 spelare, 0 monster)
            if (playerInitiativeRoll > monsterInitiativeRoll) {
                System.out.println("You go first! ");
                this.currentTurn = 1;
            } else {
                System.out.println(monster.getClassType() + " goes first! ");
                this.currentTurn = 0;
            }

            //Combat startas
            while (true) {

                //kollar om spelaren dog den förra rundan
                if (character.getHp() <= 0) {
                    System.out.println("You died!");
                    //sätt in våran death animation/funktion
                    break;
                }

                //kollar om monstret dog förra rundan
                if (monster.getHp() <= 0) {
                    System.out.println(monster.getClassType() + " died!");
                    break;
                }

                if (this.currentTurn == 1) {
                    //frågar spelaren vad hen vill göra och spar det till en variabel
                    System.out.println("What do you want to do? ");
                    System.out.println("(A)ttack, (F)lee");
                    String playerChoice = scan.nextLine().toUpperCase();

                    if (playerChoice.equals("A")) {
                        character.attackMonster(monster);
                        this.currentTurn = 0;
                    } else if (playerChoice.equals("F")) {

                        boolean flee = character.flee();

                        if (flee) {
                            System.out.println("You fled! ");

                            break;
                        } else {
                            System.out.println("You've failed your escape. ");
                            this.currentTurn = 0;
                        }


                    } else {
                        System.out.println("You need to (A)ttack or try to (F)lee");
                    }
                } else if (this.currentTurn == 0) {
                    character.defendAttack(monster);
                    this.currentTurn = 1;
                }
            }

        }
    }


    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combat)) return false;
        Combat combat = (Combat) o;
        return getCurrentTurn() == combat.getCurrentTurn();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCurrentTurn());
    }
}
