/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pocketorigin.sprites;

import java.util.ArrayList;
import java.util.Random;
import pocketorigin.sprites.Creature;

/**
 * Copyright © 2022. all right reserved.
 * @author Judah Stasinos
 */
public class Player {
    
    Random rNumber = new Random();
    Creature[] team = new Creature[6];
    String[] teamNames = new String[6];
    String[] badges = new String[5];
    int money = 2000;
    final String gender;
    final String name;
    ArrayList<Item> inventory = new ArrayList<>();
    
    /**
     * Creates the new Player object
     * @param gender 
     * @param name 
     */
    public Player(String gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public Player() {
        gender = "male";
        name = "John";
    }
    
    /**
     * gets the player's team of creatures.
     * @return the team
     */
    public Creature[] getTeam() {
        return team;
    }
    
    /**
     * determines the catch rate given the creature and what type of pack you are using to catch it
     * @param creature the creature you are catching
     * @param item the pack you are using to catch it
     */
    public void catchCreature(Creature creature, Item item) {
        if ((creature.species.toLowerCase().equals("firemon") || creature.species.toLowerCase().equals("grassmon") || creature.species.toLowerCase().equals("watermon"))) {
            team[0] = creature;
            teamNames[0] = creature.species;
            return;
        } else {
            switch (item.name.toLowerCase()) {
                case "master pack":
                    for (int i = 0; i < team.length; i ++) {
                        if (teamNames[i].isEmpty()) {
                            team[i] = creature;
                            teamNames[i] = creature.species;
                            return;
                        }
                    }   break;
                case "extreme pack":
                    {
                        int catchInt = rNumber.nextInt(150);
                        String status = creature.status;
                        int statusCatchInt = 0;
                        if (!status.toLowerCase().equals("normal")) {
                            if (status.toLowerCase().equals("asleep")) {
                                statusCatchInt = 25;
                            } else if (status.toLowerCase().equals("burned")) {
                                statusCatchInt = 12;
                            }
                        }//end of status determination
                        catchInt -= statusCatchInt;
                        if (catchInt <= 0) {
                            for (int i = 0; i < team.length; i ++) {
                                if (teamNames[i].isEmpty()) {
                                    team[i] = creature;
                                    teamNames[i] = creature.species;
                                    return;
                                }
                            }// end of forLoop
                        } else {
                            int healthCatchInt = (creature.healthPoints * 255);
                            healthCatchInt /= 12;
                            healthCatchInt /= (creature.currentHealthPoints / 4);
                            if (healthCatchInt > 255) {
                                healthCatchInt = 255;
                            }
                            if (healthCatchInt < catchInt) {
                                captureFailed(creature, catchInt, healthCatchInt);
                            } else {
                                for (int i = 0; i < team.length; i ++) {
                                    if (teamNames[i].isEmpty()) {
                                        team[i] = creature;
                                        teamNames[i] = creature.species;
                                        return;
                                    }
                                }// end of forLoop
                            }//end of else
                        }       break;
                    }
                case "good pack":
                    {
                        int catchInt = rNumber.nextInt(200);
                        String status = creature.status;
                        int statusCatchInt = 0;
                        if (!status.toLowerCase().equals("normal")) {
                            if (status.toLowerCase().equals("asleep")) {
                                statusCatchInt = 25;
                            } else if (status.toLowerCase().equals("burned")) {
                                statusCatchInt = 12;
                            }
                        }//end of status determination
                        catchInt -= statusCatchInt;
                        if (catchInt <= 0) {
                            if (teamNames[teamNames.length - 1].isEmpty()) {
                                for (int i = 0; i < team.length; i ++) {
                                    if (teamNames[i].isEmpty()) {
                                        team[i] = creature;
                                        teamNames[i] = creature.species;
                                        return;
                                    }
                                }// end of forLoop
                            } else if (true) {
                                
                            }
                        } else {
                            int healthCatchInt = (creature.healthPoints * 255);
                            healthCatchInt /= 12;
                            healthCatchInt /= (creature.currentHealthPoints / 4);
                            if (healthCatchInt > 255) {
                                healthCatchInt = 255;
                            }
                            if (healthCatchInt < catchInt) {
                                captureFailed(creature, catchInt, healthCatchInt);
                            } else {
                                for (int i = 0; i < team.length; i ++) {
                                    if (teamNames[i].isEmpty()) {
                                        team[i] = creature;
                                        teamNames[i] = creature.species;
                                        return;
                                    }
                                }// end of forLoop
                            }//end of else statement
                        }//end of else Statement
                        break;
                    }
                default:
                    {
                        int catchInt = rNumber.nextInt(255);
                        String status = creature.status;
                        int statusCatchInt = 0;
                        if (!status.toLowerCase().equals("normal")) {
                            if (status.toLowerCase().equals("asleep")) {
                                statusCatchInt = 25;
                            } else if (status.toLowerCase().equals("burned")) {
                                statusCatchInt = 12;
                            }
                        }//end of status determination
                        catchInt -= statusCatchInt;
                        if (catchInt <= 0) {
                            for (int i = 0; i < team.length; i ++) {
                                if (teamNames[i].isEmpty()) {
                                    team[i] = creature;
                                    teamNames[i] = creature.species;
                                    return;
                                }
                            }// end of forLoop
                        } else {
                            int healthCatchInt = (creature.healthPoints * 255);
                            healthCatchInt /= 12;
                            healthCatchInt /= (creature.currentHealthPoints / 4);
                            if (healthCatchInt > 255) {
                                healthCatchInt = 255;
                            }
                            if (healthCatchInt < catchInt) {
                                captureFailed(creature, catchInt, healthCatchInt);
                            } else {
                                for (int i = 0; i < team.length; i ++) {
                                    if (teamNames[i].isEmpty()) {
                                        team[i] = creature;
                                        teamNames[i] = creature.species;
                                        //TODO: show Message "Successful capture of " + creature.species + ". "
                                    }
                                }// end of forLoop
                            }//end of else statement
                        }//end of else Statement
                        break;
                    } //end of catching packs
            }
        }// end of catch
    }//end of catchCreature()
    
    /**
     * Determines the message to show when failing to catch a creature.
     * @param creature
     * @param catchRate
     * @param healthCatchInt 
     */
    public void captureFailed(Creature creature, int catchRate, int healthCatchInt) {
        int messageDecider = catchRate * 100;
        messageDecider *= healthCatchInt;
        messageDecider /= 255;
        if (!creature.status.toLowerCase().equals("normal")) {
            messageDecider += 5;
        }
        
        if (messageDecider < 10) {
            //TODO: set Message to "...you missed."
        } else if (messageDecider <= 29) {
            //TODO: set Message to "Oof. The creature broke free!"
        } else if (messageDecider <= 69) {
            //TODO: set Message to "Aww, it was so close too!"
        } else {
            //TODO: set message to "Shoot! it looked like it was caught!"
        }
        
    }

    
    
    /**
     * gets the player's number of badges and their names
     * @return the String array with the names of badges.
     */
    public String[] getBadge() {
        return badges;
    }
    
    /**
     * Adds a badge to the list of badges after reaching a certain threshold.
     * @param Badge the badge you want to add to the badges list.
     */
    public void addBadge(String Badge) {
        for (int i = 0; i < badges.length; i ++) {
            if (badges[i].isEmpty()) {
                badges[i] = Badge;
                return;
            }
        }
    }

    /**
     * gets the player's money amount.
     * @return the player's money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds a quantity of money to the Player's money
     * @param money the new value of money you want to add to the Player's money
     */
    public void setMoney(int money) {
        this.money = this.money + money;
    }
    
    
    
    
}
