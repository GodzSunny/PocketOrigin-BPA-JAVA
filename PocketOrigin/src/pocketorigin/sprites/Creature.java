/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pocketorigin.sprites;

import java.util.ArrayList;
import java.util.Random;
import pocketorigin.Moves;

/**
 * Copyright © 2022. all right reserved.
 * @author Judah Stasinos
 */
public class Creature {
    int level;
    int healthPoints, hpIV;
    int atkPoints, atkIV;
    int defPoints, defIV;
    int spdPoints, spdIV;
    int currentHealthPoints;
    
    ArrayList<Moves> moveSet;
    
    String type;
    String species;
    String status = "normal";
    Random rNumber = new Random();

    public Creature(String species, int level) {
        this.level = level;
        this.species = species;
        
        hpIV = rNumber.nextInt(6);
        atkIV = rNumber.nextInt(6);
        defIV = rNumber.nextInt(6);
        spdIV = rNumber.nextInt(6);
        
        healthPoints = 10*(level/5) + hpIV;
        
    }
    
    public Creature(String species) {
        Moves moves = new Moves();
        
        level = 5;
        this.species = species;
        
        hpIV = rNumber.nextInt(6);
        atkIV = rNumber.nextInt(6);
        defIV = rNumber.nextInt(6);
        spdIV = rNumber.nextInt(6);
        
        healthPoints = hpIV;
        atkPoints = atkIV;
        defPoints = defIV;
        spdPoints = spdIV;
    }
    
    
    /**
     * int randomChance = rnumber.nextInt(10);
     * if (randomChance <= 5) {
     *      final String species = "Zombop";
     *      Creature creature = new Creature(species, rNumber.nextInt(3) + 1);
     * }
     */
    
    
    
}
