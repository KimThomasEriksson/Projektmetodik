package view;

import model.Monster.Monster;
import model.Character.Character;
import model.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    private boolean flee = false;
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;
    private Monster monster4;

    private boolean monster1Alive = false;
    private boolean monster2Alive = false;
    private boolean monster3Alive = false;
    private boolean monster4Alive = false;

    private int counter = 0;
    private int monsterAlive = 0;

    public void combatStart(ArrayList<Monster> monster, Character character, Room rooms) throws IOException, InterruptedException {
        boolean cont = false;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        int playerInitiativeRoll = 0;
        int monsterInitiativeRoll1 = 0;
        int monsterInitiativeRoll2 = 0;
        int monsterInitiativeRoll3 = 0;
        int monsterInitiativeRoll4 = 0;
        clearWindow();
        rooms.printRoom();

        try {
            monster1 = monster.get(0);
            monsterAlive++;
            monster1Alive = true;
            monster2 = monster.get(1);
            monsterAlive++;
            monster2Alive = true;
            monster3 = monster.get(2);
            monsterAlive++;
            monster3Alive = true;
            monster4 = monster.get(3);
            monster4Alive = true;
            monsterAlive++;

        } catch (IndexOutOfBoundsException e) {

        }

        while (loop) {
            String encounterString = "";
            boolean printOnce = true;
            for (int i = 0; i < monster.size();i++){
                if (i+1 == monster.size() && monster.size() != 1){
                    encounterString += "and a " + monster.get(i).getClassType() + " has appeared!";
                    break;
                }
                if(monster.size()==2 && printOnce){
                    encounterString += "a " + monster.get(i).getClassType() + " ";
                    printOnce = false;
                }
                if(monster.size()==1){
                    encounterString += "a " + monster.get(i).getClassType() + " has appeared";
                    break;
                } else if (monster.size() != 2){
                    encounterString += monster.get(i).getClassType() + ", ";
                }
            }

            System.out.println(encounterString);
            Thread.sleep(500);
            System.out.println("Do you want to (A)ttack or try to (F)lee ?  ");
            System.out.println(character.getHp() + " hp left");
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("A")) {
                cont = true;
                loop = false;
            } else if (choice.equals("F")) {
                boolean tryToFlee;
                tryToFlee = character.flee();
                if (tryToFlee) {
                    System.out.println("You've fled! ");
                    rooms.flee();
                    flee = true;
                    cont = false;
                    loop = false;
                } else {
                    System.out.println("You've failed your escape ");
                    cont = true;
                    loop = false;
                }
            } else {
                System.out.println("You need to choose between (A)ttack or (F)lee ");
            }
        }
        if (cont) {
            character.setFirstHit(true);

            //rollar initiative för att se om monstret eller spelaren ska börja

            try {
                for (int i = 1; i <= monster.get(0).getInitiative(); i++) {
                    monsterInitiativeRoll1 = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll1;
                }

                for (int i = 1; i <= monster.get(1).getInitiative(); i++) {
                    monsterInitiativeRoll2 = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll2;
                }

                for (int i = 1; i <= monster.get(2).getInitiative(); i++) {
                    monsterInitiativeRoll3 = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll3;
                }

                for (int i = 1; i <= monster.get(3).getInitiative(); i++) {
                    monsterInitiativeRoll4 = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll4;
                }

            } catch (IndexOutOfBoundsException e1) {

            }


            for (int i = 1; i <= character.getInitiative(); i++) {
                playerInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + playerInitiativeRoll;

            }
            System.out.println("------------------------------");
            System.out.println("You rolled... " + playerInitiativeRoll);
            try {
                System.out.println(monster.get(0).getClassType() + " rolled... " + monsterInitiativeRoll1);
                System.out.println(monster.get(1).getClassType() + " rolled... " + monsterInitiativeRoll2);
                System.out.println(monster.get(2).getClassType() + " rolled... " + monsterInitiativeRoll3);
                System.out.println(monster.get(3).getClassType() + " rolled... " + monsterInitiativeRoll4);
            } catch (IndexOutOfBoundsException e2) {

            }
            System.out.println("------------------------------");
            System.out.println("");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ArrayList<Integer> listOfRolls = new ArrayList<Integer>();
            listOfRolls.add(playerInitiativeRoll);

            if (monsterAlive >= 1) {
                listOfRolls.add(monsterInitiativeRoll1);
            }
            if (monsterAlive >= 2) {
                listOfRolls.add(monsterInitiativeRoll2);
            }
            if (monsterAlive >= 3) {
                listOfRolls.add(monsterInitiativeRoll3);
            }
            if (monsterAlive == 4) {
                listOfRolls.add(monsterInitiativeRoll4);
            }


            Collections.sort(listOfRolls);
            Collections.reverse(listOfRolls);

            //Combat startas
            while (true) {

                if (counter == 2) {
                    try {
                        Thread.sleep(2000);
                        counter = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //kollar om spelaren dog den förra rundan
                if (character.getHp() <= 0) {
                    System.out.println("You died!");
                    //sätt in våran death animation/funktion
                    break;
                }

                //kollar om monstret dog förra rundan

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String whoAttacked = "";

                if (monsterAlive == 0) {
                    if(monster.size()>1) {
                        System.out.println("Every monster died ");
                    }
                    break;

                }
                for (int i = 0; i < listOfRolls.size(); i++) {

                    try {
                        if (monsterAlive == 0) {
                            break;

                        }
                        if (monster1.getHp() <= 0 && monster1Alive) {
                            System.out.println(monster.get(0).getClassType() + " died!");
                            monster1Alive = false;
                            monsterAlive--;
                            if(monster2==null){
                                break;
                            }
                        }
                        if (monster2.getHp() <= 0 && monster2Alive) {
                            System.out.println(monster.get(1).getClassType() + " died!");
                            monster2Alive = false;
                            monsterAlive--;
                        }
                        if (monster3.getHp() <= 0&& monster3Alive) {
                            System.out.println(monster.get(2).getClassType() + " died!");
                            monster3Alive = false;
                            monsterAlive--;
                        }
                        if (monster4.getHp() <= 0&&monster4Alive) {
                            System.out.println(monster.get(3).getClassType() + " died!");
                            monster4Alive = false;
                            monsterAlive--;
                        }
                    } catch (NullPointerException e) {

                    }

                    if (playerInitiativeRoll == listOfRolls.get(i) && !"player".equals(whoAttacked)) {
                        //frågar spelaren vad hen vill göra och spar det till en variabel
                        System.out.println("What do you want to do? ");
                        System.out.println("(A)ttack, (F)lee");
                        String playerChoice = scan.nextLine().toUpperCase();
                        int commandToAttack = 1;

                        if (playerChoice.equals("A")) {
                            if(monster2 == null){
                                character.attackMonster(monster1, false);
                            }
                            else{
                            System.out.println("Who do you want to attack? ");
                            for (int n = 0; n < monster.size(); n++) {
                                if(monster.get(n).getHp()<=0){
                                    System.out.println(commandToAttack + ". " + monster.get(n).getClassType() + " (dead)");
                                    commandToAttack++;
                                }   else {
                                    System.out.println(commandToAttack + ". " + monster.get(n).getClassType());
                                    commandToAttack++;
                                }
                            }

                            while (true) {
                                String target = scan.nextLine();

                                if (target.equals("1")) {
                                    if (monster1Alive) {
                                        character.attackMonster(monster1, false);
                                        break;
                                    } else {
                                        System.out.println("You cant attack a dead monster");
                                        Thread.sleep(1000);
                                    }
                                } else if (target.equals("2")) {
                                    if (monster2Alive) {
                                        character.attackMonster(monster2, false);
                                        break;
                                    } else {
                                        System.out.println("You cant attack a dead monster");
                                        Thread.sleep(1000);
                                    }

                                } else if (target.equals("3")) {
                                    if (monster3Alive) {
                                        character.attackMonster(monster3, false);
                                        break;
                                    } else {
                                        System.out.println("You cant attack a dead monster");
                                        Thread.sleep(1000);
                                    }
                                } else if (target.equals("4")) {
                                    if (monster4Alive) {
                                        character.attackMonster(monster4, false);
                                        break;
                                    } else {
                                        System.out.println("You cant attack a dead monster");
                                        Thread.sleep(1000);
                                    }
                                }
                            }
                            }

                        } else if (playerChoice.equals("F")) {

                            boolean flee = character.flee();

                            if (flee) {
                                System.out.println("You fled! ");
                                rooms.flee();

                            } else {
                                System.out.println("You've failed your escape. ");

                            }


                        } else {
                            System.out.println("You need to (A)ttack or try to (F)lee");
                        }
                        whoAttacked = "player";

                    } else if (monster1Alive && monsterInitiativeRoll1 == listOfRolls.get(i) && !"monster1".equals(whoAttacked)) {
                        character.defendAttack(monster1, false);
                        whoAttacked = "monster1";

                    } else if (monster2Alive && monsterInitiativeRoll2 == listOfRolls.get(i)&& !"monster2".equals(whoAttacked)) {
                        character.defendAttack(monster2, false);
                        whoAttacked = "monster2";

                    } else if (monster3Alive && monsterInitiativeRoll3 == listOfRolls.get(i)&& !"monster3".equals(whoAttacked)) {
                        character.defendAttack(monster3, false);
                        whoAttacked = "monster3";

                    } else if (monster4Alive && monsterInitiativeRoll4 == listOfRolls.get(i)&& !"monster4".equals(whoAttacked)) {
                        character.defendAttack(monster4, false);
                        whoAttacked = "monster4";
                    }
                    this.counter++;
                }

            }
        }

        }


    public void clearWindow() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combat)) return false;
        Combat combat = (Combat) o;
        return true;
    }

    @Override
    public int hashCode() {

       // return Objects.hash(getCurrentTurn());
        return 1;
    }

    public boolean getFlee() {
        return flee;
    }

    public void setFlee(boolean flee) {
        this.flee = flee;
    }
}

