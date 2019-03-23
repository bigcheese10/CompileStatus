/*
Author: Kaleb Ringenberg
Date: 
Purpose: create the class that is status for the character
 */
package compilestatus;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CompileStatus
{

  
    public static void main(String[] args)
    {
        // 3 statuses exist so far, if you are poisoned by an enemy/trap you will begin to take 
        // damage after 3 vollies of combat, as well as a bleed effect which 
        // has a 5% chance of occuring to the player after every successful hit landed on the player
        // by an enemy
        
        // !!!!!!!!!!!!!! I made all these variables before doing any actual coding so if they are unused
        // then they will most likely not be needed
        
        
        
        //--------status variables---------------
        int statusPoison = 1;
        int statusBleed = 2;
        
        // will be used for the almighty RNJesus
        Random rand = new Random();
        
        //--------flags for activating/deactivating status effects------------
        boolean poisonActive = true;
        boolean bleedActive = true;      
        boolean inCombat = true;     
        
        // --------player/npc health-----------------
        int playerHealth = 100;
        int enemyHealth = 0;
        
        //---------counters-------------
        int volleyCounter = 0;
        
        //damage calculators
        int playerDamage;
        int enemyDamage;
       
        //option
        char attack;
        
        // scanner for the hell of it
        Scanner input = new Scanner(System.in);
        
        // a temporary variable for seeing if you will begin to bleed after a volley of combat.
        // the bleedTemp variable will always be 5, and after every volley of combat a random number
        // between 1-20 will be generated and if it lands on 5 then the bleed effect will actiavte
        int bleedTemp = 5;
        // random number will be stored here, if bleedChance = 5 then bleed will activate
        int bleedChance;
       
        // a variable for if the enemy can poison you (toxic spit, toxic tipped weapons, poisonous fangs/claws etc.)
        // the enemy will have a 2% chance of being poisonous, if they are then they will poison you and do 10 damage
        // every 3 vollies, if you kill if before 3 vollies then no poison will damage you.
        int poisonChanceOfEnemy;
        int poisonTemp = 24;
        int poisonTest;
        
        
         enemyHealth = ThreadLocalRandom.current().nextInt(21, 51);
         poisonChanceOfEnemy = ThreadLocalRandom.current().nextInt(1,51);
        //=========while loop for status logic==============
        while(inCombat == true)
        {
            // once you enter combat, the enemy's health will be generated between 20-50 hp
            // ----------can obviously be modified-----------------
            enemyHealth = ThreadLocalRandom.current().nextInt(21, 51);
            poisonChanceOfEnemy = ThreadLocalRandom.current().nextInt(1,51);
           
           
           // just here to see it work
           System.out.println("The enemy's health is: "+ enemyHealth);
           System.out.println("Do you wish to attack? ofcourse you do! press 'y' now!");
           attack = input.next().toUpperCase().charAt(0);
           
           // when you press y to attack you are entering a volley of combat that will be counted
           // if you reach 3 vollies of combat, you will have a chance of being poisoned.
           
             if (attack == 'Y')
         {
             if (poisonChanceOfEnemy == poisonTemp)            
             {
              
               System.out.println("You are being attacked!");
               enemyDamage = ThreadLocalRandom.current().nextInt(1,16);
               playerHealth -= enemyDamage;              
              
               System.out.println("You attack back!");
               playerDamage = ThreadLocalRandom.current().nextInt(1,31);
               enemyHealth -= playerDamage;
               
               System.out.println("Your health is: " + playerHealth + "\nand the enemy's health is: " + enemyHealth);
               volleyCounter++;
              
               // if you kill the enemy, or die then you jump out of the combat loop
               if (enemyHealth <= 0)
                {
                   System.out.println("Enemy defeated.");
                   inCombat = false;
                  }
                  if (playerHealth <= 0)
                  {
                   System.out.println("You are dead, good job.");
                   inCombat = false;
                  }
                  poisonTest = (volleyCounter % 3);
                  if (poisonTest == 0)
                 {
                  playerHealth -= 10;
                  System.out.println("You have been poisoned and take damage.");
                  System.out.println("Your healh is: " + playerHealth);
                 }               
               }
              else
              {
                 System.out.println("You are being attacked!");
                 enemyDamage = ThreadLocalRandom.current().nextInt(1,16);
                 playerHealth -= enemyDamage;              
              
                 System.out.println("You attack back!");
                 playerDamage = ThreadLocalRandom.current().nextInt(1,31);
                 enemyHealth -= playerDamage;
               
                  System.out.println("Your health is: " + playerHealth + "\nand the enemy's health is: " + enemyHealth);
               
               
                 // random number b/n 1-20
                 bleedChance = ThreadLocalRandom.current().nextInt(1,21);
               
                 // sees if that random number is 5, if it is then you will take 5 damage
                if(bleedChance == bleedTemp)
                 {
                   System.out.println("You start to bleed, you should get some bandages.");
                   playerHealth -= 5;
                   System.out.println("Your health is: " + playerHealth);
                 }
               
                 // if you kill the enemy, or die then you jump out of the combat loop
                 if (enemyHealth <= 0)
                 {
                   System.out.println("Enemy defeated.");
                   inCombat = false;
                 }
                 if (playerHealth <= 0)
                 {
                   System.out.println("You are dead, good job.");
                   inCombat = false;
                 }
              }
             
       
         }
           
           
        }
    }
    
}
