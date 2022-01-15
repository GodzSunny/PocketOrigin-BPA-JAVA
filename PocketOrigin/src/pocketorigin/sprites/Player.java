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
    
    int vit, str, spd, inte, luk, level;
    
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
        inte = 10;
        luk = 10;
        
    }

    public Player() {
        gender = "male";
        name = "John";
        
        level = 1;
        vit = 10;
        str = 10;
        spd = 10;
        inte = 10;
        luk = 10;
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
