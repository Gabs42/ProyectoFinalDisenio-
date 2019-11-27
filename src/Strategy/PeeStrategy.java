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
public class PeeStrategy implements IActionStrategy {

    @Override
    public boolean action(MainCharacter character) {
        if(character.getLiquid()> 0){
            character.setCurrentImage("gokuBath.png");
           character.setLiquid(character.getLiquid()-2); 
           if(character.getLiquid()<0){
               character.setLiquid(0);
           }
           return true;
        }
        return false;
        
    }
    
}
