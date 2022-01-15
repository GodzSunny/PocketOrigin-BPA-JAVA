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
    int money = 200;
    final String gender;
    final String name;
    
    int vit, str, spd, luk, def, level;
    int expToNextLvl, currentExp;
    int healthPoints, currentHealthPoints;
    
    /**
     * Creates the new Player object
     * @param gender 
     * @param name 
     */
    public Player(String gender, String name) {
        this.gender = gender;
        this.name = name;
        
        level = 1;
        vit = 10;
        str = 10;
        spd = 10;
        def = 10;
        luk = 10;
        
        healthPoints = (level * 5) + (vit * 10);
        currentHealthPoints = healthPoints;
        
    }

    public Player() {
        gender = "male";
        name = "John";
        
        level = 1;
        vit = 10;
        str = 10;
        spd = 10;
        def = 10;
        luk = 1;
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
    public void addMoney(int money) {
        this.money = this.money + money;
    }
    
    /**
    * Your player dealing damage to the creature.
    * @param the creature you are dealing damage to.
    */
    public void attack(Creature creature) {
        int damageDealt = str * level - creature.defPoints;
        int critChance;
        if (luk < 30) {
            critChance = rNumber.nextInt(30 - luk);
        } else {
            critChance = 1;
        }
        if (critChance <= 1) {
            damageDealt *= 2;
            //TODO: crit Message
            creature.currentHealthPoints -= damageDealt;
        }
    }
    
    /**
    * Makes your player battle a creature.
    * @param the creature you will battle.
    */
    public void battle(Creature creature) {
        if (spd < creature.spdPoints) {
            int damageDealt = creature.atkPoints - (def * 2);
            currentHealthPoints -= damageDealt;
            //TODO: show damage dealt?
            if (currentHealthPoints <= 0) {
                //TODO: enter Lose State
            } else {
                attack(creature);
                //TODO: show damage dealt?
                if (creature.healthPoints <= 0) {
                    creature.healthPoints = 0;
                    //TODO: enter Win State
                } else {
                    battle(creature);
                }
            }
        } else {
            attack(creature);
            if (creature.healthPoints <= 0) {
                creature.healthPoints = 0;
                //TODO: show damage dealt?
                //TODO: enter Win State
            } else {
                int damageDealt = creature.atkPoints - (def * 2);
                currentHealthPoints -= damageDealt;
                //TODO: show damage dealt?
                if (currentHealthPoints <= 0) {
                    //TODO: enter Lose State
                } else {
                    battle(creature);
                }
            }
        }
    }
}
