/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;
import Facilities.Correr;
import Facilities.Nadar;
import Factory.FactoryExcercise;
import static Strategy.ExcerciseEnum.Correr;

/**
 *
 * @author Gabriel
 */
public class ExcerciseStrategy implements IActionStrategy {

    @Override
    public boolean action(MainCharacter character) {
        String action = character.getCurrentAction();
        switch(action){
            case("Correr"):
                Correr accionCorrer = (Correr) FactoryExcercise.getIntance(ExcerciseEnum.Correr);
                return accionCorrer.action(character);
            case("Nadar"):
                Nadar accionNadar = (Nadar) FactoryExcercise.getIntance(ExcerciseEnum.Nadar);
                return accionNadar.action(character);
        }
        return false;
    }

    
}
