/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pocketorigin.sprites;

import java.util.ArrayList;
import java.util.Random;

/**
 * Copyright © 2022. all right reserved.
 * @author Judah Stasinos
 */
public class Creature {
    
    int level;
    int healthPoints; 
    int atkPoints; 
    int defPoints; 
    int spdPoints;
    int currentHealthPoints;
    
    String species;
    Random rNumber = new Random();
    
    public Creature(String species, int level) {
        this.level = level;
        this.species = species;
        
        healthPoints = level + rNumber.nextInt(level) * 2;
        atkPoints = level + rNumber.nextInt(level);
        defPoints = level + rNumber.nextInt(level);
        spdPoints = level + rNumber.nextInt(level);
        defPoints = level + rNumber.nextInt(level);
    }

}
