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
public class MeditateStrategy implements IActionStrategy{

    @Override
    public boolean action(MainCharacter character) {
        if(character.getMentalHealth()==100){
            return false;
        }
        character.setCurrentImage("gokuMeditate.png");
        character.setMentalHealth(character.getMentalHealth()+1);
        if(character.getMentalHealth()>100){
            character.setMentalHealth(100);
        }
        return true;
    }
    
}
