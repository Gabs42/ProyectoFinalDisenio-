/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Character.Character.CharacterBuilder;
import Characters.MainCharacter;
import Facilities.Food;
import Facilities.Storage;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class EatStrategy implements IActionStrategy{
    
    @Override
    public boolean action(MainCharacter character) {
        ArrayList<Food> currentFood = Storage.getInstance().getFoods();
        if(currentFood.size()!=0){
            character.setCurrentImage("gokuEat.png");
            character.setFood(character.getFood()+20);
            character.setLiquid(character.getLiquid()+20);
            if(character.getEnergy()<100){
                character.setEnergy(character.getEnergy()+currentFood.get(Storage.getInstance().getSelectedFood()).getEnergy());
            }
            else{
                character.setGordura(character.getGordura()+ currentFood.get(Storage.getInstance().getSelectedFood()).getEnergy());
            }
            if(character.getMentalHealth()<100){
                character.setMentalHealth(character.getMentalHealth()+ currentFood.get(Storage.getInstance().getSelectedFood()).getEnergy());
            }
            Storage.getInstance().getFoods().remove(0);
        }
        return false; 
        
    }
}
