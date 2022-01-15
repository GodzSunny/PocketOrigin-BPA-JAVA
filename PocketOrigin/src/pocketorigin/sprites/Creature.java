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
    
    Moves moves = new Moves();
    int level;
    int healthPoints; 
    final int hpIV;
    int atkPoints; 
    final int atkIV;
    int defPoints; 
    final int defIV;
    int spdPoints;
    final int spdIV;
    int currentHealthPoints;
    int experienceToLvl, currentExperience;
    
    ArrayList<String> moveSet;
    
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
        experienceToLvl = level;
        currentExperience = 0;
        
        healthPoints = level + rNumber.nextInt(level) + hpIV;
        atkPoints = level + rNumber.nextInt(level) + atkIV;
        defPoints = level + rNumber.nextInt(level) +defIV;
        spdPoints = level + rNumber.nextInt(level) + spdIV;
        defPoints = level + rNumber.nextInt(level) + defIV;
        
        
    }
    
    public Creature(String species) {
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
        
        moveSet.add(moves.namesOfMoves.get(0));
        
    }
    
    public void chooseMove() {
        
    }
    
    public void battle(Creature creature) {
        if (creature.spdPoints > spdPoints) {
            creature.chooseMove();
        }
    }
    
}
