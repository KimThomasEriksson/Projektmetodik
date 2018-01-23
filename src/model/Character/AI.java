package model.Character;

import model.Monster.Monster;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AI {


    private int currentTurn;
    private int hitLastTurn;
    private boolean contCombat;
    private boolean quickCombat;
    private Character AI;

    public AI(Character AI, boolean quickCombat){

        this.AI = AI;
        this.quickCombat = quickCombat;

    }

    public void startMoving(){

    }

    public void startCombat(Monster monster){

        boolean cont = false;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        int playerInitiativeRoll = 0;
        int monsterInitiativeRoll = 0;
        if (!quickCombat) {
            System.out.println("a " + monster.getClassType() + " has appeared!");
        }

        for (int i = 1; i <= monster.getInitiative(); i++) {
            monsterInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll;
        }

        for (int i = 1; i <= AI.getInitiative(); i++) {
            playerInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + playerInitiativeRoll;
        }
        if(!quickCombat) {
            System.out.println("------------------------------");
            System.out.println("You rolled... " + playerInitiativeRoll);
            System.out.println(monster.getClassType() + " rolled... " + monsterInitiativeRoll);
            System.out.println("------------------------------");
            System.out.println("");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (playerInitiativeRoll > monsterInitiativeRoll) {
            if(!quickCombat) {
                System.out.println("You go first! ");
            }
            this.currentTurn = 1;
        } else {
            if (!quickCombat) {
                System.out.println(monster.getClassType() + " goes first! ");
            }
            this.currentTurn = 0;
        }


        while (loop){
            if(!quickCombat) {
                System.out.println(AI.getHp() + " hp left");
            }
            boolean flee;
            if (AI.getHp()==0){
                System.out.println("You died!");
                System.exit(0);
            }
            else if(monster.getHp()<=0){
                if (!quickCombat){
                    hitLastTurn = 0;
                    System.out.println(monster.getClassType() + " has died! ");
                    loop = false;
                    break;
                }
                else{
                    hitLastTurn = 0;
                    loop = false;
                    break;
                }
            }
            if(currentTurn == 1){
                if(AI.getClassType().equals("Thief") && monster.getHp() > 2 && AI.getHp() == 1){
                    flee = AI.flee();
                    if(flee){
                        if(!quickCombat) {
                            System.out.println("you fled");
                        }
                        break;
                    }
                    else {
                        if(!quickCombat) {
                            System.out.println("You've failed your escape");
                        }
                        currentTurn = 0;
                    }


                }
                else if(AI.getClassType().equals("Knight") && monster.getHp() >= 2 && AI.getHp()==1){
                    flee = AI.flee();
                    if(flee){
                        if(!quickCombat) {
                            System.out.println("you fled");
                        }
                        break;
                    }
                    else {
                        if (!quickCombat) {
                            System.out.println("You've failed your escape");
                        }
                        currentTurn = 0;
                    }

                }


                //hade ett 1 hp , rollade högre, max hp troll
                else if(AI.getClassType().equals("Wizard") && monster.getHp()>1 && AI.getHp()==1){
                    flee = AI.flee();
                    if(flee){
                        if(!quickCombat) {
                            System.out.println("you fled");
                        }
                        break;
                    }
                    else {
                        if(!quickCombat) {
                            System.out.println("You've failed your escape");
                        }
                        currentTurn = 0;
                    }

                }
                else if (monster.getClassType().equals("GiantSpider")){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }
                else if(AI.getClassType().equals("Knight") && monster.getHp()<=2 && AI.getHp()==1 && hitLastTurn == 0){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }

                else if(AI.getClassType().equals("Knight") && monster.getHp()==1 && AI.getHp()==1 && hitLastTurn == 1){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }
                else if(AI.getClassType().equals("Knight") && monster.getHp()>=1 && AI.getHp()>1){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }

                else if(AI.getClassType().equals("Thief") && monster.getHp() <= 2 && AI.getHp() >= 1){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }
                else if(AI.getClassType().equals("Thief") && monster.getHp()>1 && AI.getHp()>1){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }
                else if(AI.getClassType().equals("Wizard") && monster.getHp()==1 && AI.getHp() == 1){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }
                else if(AI.getClassType().equals("Wizard") && monster.getHp()>=1 && AI.getHp()>1){
                    AI.attackMonster(monster,quickCombat);
                    this.currentTurn = 0;

                }

            }
            else if(currentTurn == 0){
                AI.defendAttack(monster,quickCombat);
                hitLastTurn = 1;
                this.currentTurn = 1;
            }
        }

    }

}
