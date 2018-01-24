package model.Character;

import model.Adventure;
import model.Monster.Monster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class AI {

    private Monster monster1;
    private Monster monster2;
    private Monster monster3;
    private Monster monster4;

    private int currentTurn;
    private int hitLastTurn;
    private boolean contCombat;
    private boolean quickCombat;
    private Character AI;
    private Adventure aiAdventure;


    public AI(Character AI, boolean quickCombat){

        this.AI = AI;
        this.quickCombat = quickCombat;

    }

    public void startMoving(){
        aiAdventure.gameRoundAi(aiAdventure.isKeepMoving());
    }

    public void startCombat(ArrayList<Monster> monster ){
        boolean flee;

        ArrayList<Monster> listOfMonster = new ArrayList<Monster>();

        boolean monster1Alive = false;
        boolean monster2Alive = false;
        boolean monster3Alive = false;
        boolean monster4Alive = false;

        int counter = 0;
        int monsterAlive = 0;

        boolean cont = false;
        boolean loop = true;

        int playerInitiativeRoll = 0;
        int monsterInitiativeRoll1 = 0;
        int monsterInitiativeRoll2 = 0;
        int monsterInitiativeRoll3 = 0;
        int monsterInitiativeRoll4 = 0;
        int monsterScore = 0;


        for (int i = 0; i < monster.size(); i++) {
            if (monster.get(i).getClassType().equals("GiantSpider")) {
                monsterScore += 5;
            } else if (monster.get(i).getClassType().equals("Skeleton")) {
                monsterScore += 10;
            } else if (monster.get(i).getClassType().equals("Orc")) {
                monsterScore += 20;
            } else if (monster.get(i).getClassType().equals("Troll")) {
                monsterScore += 40;
            }
        }
        try {
            monster1 = monster.get(0);
            monsterAlive++;
            listOfMonster.add(monster1);
            monster1Alive = true;
            monster2 = monster.get(1);
            monsterAlive++;
            monster2Alive = true;
            listOfMonster.add(monster2);
            monster3 = monster.get(2);
            monsterAlive++;
            monster3Alive = true;
            listOfMonster.add(monster3);
            monster4 = monster.get(3);
            monster4Alive = true;
            monsterAlive++;
            listOfMonster.add(monster4);

        } catch (IndexOutOfBoundsException e) {

        }

        while (loop) {
            String encounterString = "";
            if (!quickCombat) {
                for (int i = 0; i < monster.size(); i++) {
                    if (i + 1 == monster.size() && monster.size() != 1) {
                        encounterString += "and a " + monster.get(i).getClassType() + " has appeared!";
                        break;
                    }
                    if (monster.size() == 1) {
                        encounterString += "a " + monster.get(i).getClassType() + " has appeared";
                        break;
                    } else {
                        encounterString += monster.get(i).getClassType() + ", ";
                    }
                }


                System.out.println(encounterString);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Do you want to (A)ttack or try to (F)lee ?  ");
                System.out.println(AI.getHp() + " hp left");
            }
            boolean tryToFlee = false;
            boolean triedToFlee = false;
            if (!aiAdventure.getTestRoom().isFirstTimeExit() && monsterScore > 5 || aiAdventure.getTestRoom().isFirstTimeExit() && monsterScore > 40 && AI.getHp() <= 4|| AI.getHp() == 1
                    || AI.getHp() == 2 && monsterScore > 5 && !AI.getClassType().equals("Knight") && aiAdventure.getTestRoom().isFirstTimeExit()
                    || AI.getHp() == 2 && monsterScore > 10 && AI.getClassType().equals("Knight") && aiAdventure.getTestRoom().isFirstTimeExit()) {
                tryToFlee = AI.flee();
                triedToFlee = true;
                aiAdventure.setProgressAfterExitDiscovery(false);

            } else {
                cont = true;
                loop = false;
            }

            if (tryToFlee) {
                System.out.println("You've fled! ");
                aiAdventure.getTestRoom().flee();
                flee = true;
                cont = false;
                loop = false;
            } else if (triedToFlee && !tryToFlee) {
                System.out.println("You've failed your escape ");
                cont = true;
                loop = false;
            }
        }
        if (cont) {
            AI.setFirstHit(true);

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


            for (int i = 1; i <= AI.getInitiative(); i++) {
                playerInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + playerInitiativeRoll;

            }
            if(!quickCombat) {
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
            }
            ArrayList<Integer> listOfRolls = new ArrayList<>();
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
                        if(!quickCombat) {
                            Thread.sleep(2000);
                        }
                        counter = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //kollar om spelaren dog den förra rundan
                if (AI.getHp() <= 0) {
                    System.out.println("You died!");
                    aiAdventure.setNavigationBool(false);
                    //sätt in våran death animation/funktion
                    break;
                }

                //kollar om monstret dog förra rundan

                try {
                    if(!quickCombat) {
                        Thread.sleep(2500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String whoAttacked = "";

                if (monsterAlive == 0) {
                    if (!quickCombat) {
                        System.out.println("Every monster died ");
                    }
                    break;

                }
                for (int i = 0; i < listOfRolls.size(); i++) {

                    try {
                        if (monster1.getHp() <= 0 && monster1Alive) {
                            if(!quickCombat) {
                                System.out.println(monster.get(0).getClassType() + " died!");
                            }
                            monster1Alive = false;
                            monsterAlive--;
                        }
                        if (monster2.getHp() <= 0 && monster2Alive) {
                            if(!quickCombat) {
                                System.out.println(monster.get(1).getClassType() + " died!");
                            }
                            monster2Alive = false;
                            monsterAlive--;
                        }
                        if (monster3.getHp() <= 0 && monster3Alive) {
                            if(!quickCombat) {
                                System.out.println(monster.get(2).getClassType() + " died!");
                            }
                            monster3Alive = false;
                            monsterAlive--;
                        }
                        if (monster4.getHp() <= 0 && monster4Alive) {
                            if(!quickCombat) {
                                System.out.println(monster.get(3).getClassType() + " died!");
                            }
                            monster4Alive = false;
                            monsterAlive--;
                        }
                        if (monsterAlive == 0) {
                            if(!quickCombat) {
                                System.out.println("Every monster died ");
                            }
                            break;

                        }
                    } catch (NullPointerException e) {

                    }

                    if (playerInitiativeRoll == listOfRolls.get(i) && !"player".equals(whoAttacked) && monsterAlive != 0) {
                        //frågar spelaren vad hen vill göra och spar det till en variabel
                        if (!quickCombat) {
                            System.out.println("What do you want to do? ");
                            System.out.println("(A)ttack, (F)lee");
                        }
                        int commandToAttack = 1;
                        String AIChoice = "";

                        if (!aiAdventure.getTestRoom().isFirstTimeExit() && monsterScore > 5 || aiAdventure.getTestRoom().isFirstTimeExit() && monsterScore > 45 && AI.getHp()<=3 || AI.getHp() == 1
                                || AI.getHp() == 2 && monsterScore > 5 && !AI.getClassType().equals("Knight") && aiAdventure.getTestRoom().isFirstTimeExit()
                                || AI.getHp() == 2 && monsterScore > 10 && AI.getClassType().equals("Knight") && aiAdventure.getTestRoom().isFirstTimeExit()) {
                            AIChoice = "F";
                        } else {
                            AIChoice = "A";
                        }

                        if (AIChoice.equals("A")) {
                            if (monster.size() > 1) {
                                if (!quickCombat) {
                                    System.out.println("Who do you want to attack? ");

                                    for (int n = 0; n < monster.size(); n++) {
                                        if (monster.get(n).getHp() <= 0) {
                                            System.out.println(commandToAttack + ". " + monster.get(n).getClassType() + " (dead)");
                                            commandToAttack++;
                                        } else {
                                            System.out.println(commandToAttack + ". " + monster.get(n).getClassType());
                                            commandToAttack++;
                                        }
                                    }

                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            int lowestHp = Integer.MAX_VALUE;
                            try {
                                for (int n = 0; n < monster.size(); n++) {
                                    if (monster.get(n).getHp() < lowestHp && monster.get(n).getHp() != 0) {
                                        lowestHp = monster.get(n).getHp();
                                    }
                                }
                            } catch (IndexOutOfBoundsException e) {

                            }
                            try {
                                if (monster.get(0).getHp() == lowestHp && monster1Alive) {
                                    AI.attackMonster(monster1, quickCombat);


                                } else if (monster.get(1).getHp() == lowestHp && monster2Alive) {
                                    AI.attackMonster(monster2, quickCombat);

                                } else if (monster.get(2).getHp() == lowestHp && monster3Alive) {
                                    AI.attackMonster(monster3, quickCombat);

                                } else if (monster.get(3).getHp() == lowestHp && monster4Alive) {
                                    AI.attackMonster(monster4, quickCombat);

                                }
                            } catch (IndexOutOfBoundsException e) {

                            }

                        } else if (AIChoice.equals("F")) {

                            flee = AI.flee();

                            if (flee) {
                                System.out.println("You fled! ");
                                aiAdventure.getTestRoom().flee();
                                break;

                            } else {
                                System.out.println("You've failed your escape. ");

                            }


                        }
                        whoAttacked = "player";

                    } else if (monster1Alive && monsterInitiativeRoll1 == listOfRolls.get(i) && !"monster1".equals(whoAttacked)) {
                        AI.defendAttack(monster1, quickCombat);
                        whoAttacked = "monster1";

                    } else if (monster2Alive && monsterInitiativeRoll2 == listOfRolls.get(i) && !"monster2".equals(whoAttacked)) {
                        AI.defendAttack(monster2, quickCombat);
                        whoAttacked = "monster2";

                    } else if (monster3Alive && monsterInitiativeRoll3 == listOfRolls.get(i) && !"monster3".equals(whoAttacked)) {
                        AI.defendAttack(monster3, quickCombat);
                        whoAttacked = "monster3";

                    } else if (monster4Alive && monsterInitiativeRoll4 == listOfRolls.get(i) && !"monster4".equals(whoAttacked)) {
                        AI.defendAttack(monster4, quickCombat);
                        whoAttacked = "monster4";
                    }
                    counter++;
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

    public int getHitLastTurn() {
        return hitLastTurn;
    }

    public void setHitLastTurn(int hitLastTurn) {
        this.hitLastTurn = hitLastTurn;
    }

    public boolean isContCombat() {
        return contCombat;
    }

    public void setContCombat(boolean contCombat) {
        this.contCombat = contCombat;
    }

    public boolean isQuickCombat() {
        return quickCombat;
    }

    public void setQuickCombat(boolean quickCombat) {
        this.quickCombat = quickCombat;
    }

    public Character getAI() {
        return AI;
    }

    public void setAI(Character AI) {
        this.AI = AI;
    }

    public Adventure getAiAdventure() {
        return aiAdventure;
    }

    public void setAiAdventure(Adventure aiAdventure) {
        this.aiAdventure = aiAdventure;
    }

}
