/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

import Characters.Ability;
import Characters.MainCharacter;

/**
 *
 * @author Gabriel
 */
public class Correr implements IExcercise{

    @Override
    public boolean action(MainCharacter character) {
        character.setCurrentImage("gokuRun.png");
        character.setPhysycalHealth(character.getPhysycalHealth()-5);
        if(character.getPhysycalHealth()<0){
            character.setPhysycalHealth(0);
        }
        character.setEnergy(character.getEnergy()-5);
        if(character.getEnergy()<0){
            character.setEnergy(0);
        }
        character.setTiredness(character.getTiredness()+15);
        Ability newAbi = new Ability("gokuRun.png","RunPunch",20);
        for(Ability abi:character.getCurrentAbilities()){
            if(abi.getName().equals(newAbi.getName())){
                return false;
            }
        }
        character.addAbility(newAbi);
        return false;
    }
    
}
