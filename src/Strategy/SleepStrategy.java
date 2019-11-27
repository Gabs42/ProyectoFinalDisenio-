/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;

/**
 *
 * @author Gabriel
 */
public class SleepStrategy implements IActionStrategy{
    
    @Override
    public boolean action(MainCharacter character) {
        if(character.getTiredness() != 0){
           character.setCurrentImage("gokuSleep.png");
           character.setTiredness(character.getTiredness()-1); 
           if(character.getPhysycalHealth()!=100){
            character.setPhysycalHealth(character.getPhysycalHealth()+1);
            if(character.getPhysycalHealth()>100){
                character.setPhysycalHealth(100);
            }
            }
           return true;
        }      
        return false;
        
    }
}
