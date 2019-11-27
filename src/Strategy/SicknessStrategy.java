/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;
import Facilities.Cure;
import Facilities.ISickness;
import Facilities.Sickness;
import Factory.FactorySickness;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class SicknessStrategy implements IActionStrategy{
    private ISickness sickness;
    public SicknessStrategy(){
    }
    @Override
    public boolean action(MainCharacter character) {
        for(SicknessEnum sick:SicknessEnum.values()){
            switch(sick){        
                case Diarrea:
                    if(character.getFood()>=80){
                        Sickness newSickness = (Sickness) FactorySickness.createSickness(sick);
                        for(Sickness current:character.getCurrentSickness()){
                            if(current.getName().compareTo(newSickness.getName())==0){
                                return false;
                            }
                        }
                        character.addSickness(newSickness);
                        return true;
                    }
                    break;
                case Vomito:
                    if(character.getFood()>=100){
                        Sickness newSickness = (Sickness) FactorySickness.createSickness(sick);
                        for(Sickness current:character.getCurrentSickness()){
                            if(current.getName().compareTo(newSickness.getName())==0){
                                return false;
                            }
                        }
                        character.addSickness(newSickness);
                        return true; 
                    }
                    break;
                case Depresion:
                    if(character.getMentalHealth()<=50){
                        Sickness newSickness = (Sickness) FactorySickness.createSickness(sick);
                        for(Sickness current:character.getCurrentSickness()){
                            if(current.getName().compareTo(newSickness.getName())==0){
                                return false;
                            }
                        }
                        character.addSickness(newSickness);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
    
    
}
