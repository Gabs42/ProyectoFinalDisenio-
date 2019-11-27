/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;
import Facilities.Food;
import Facilities.Huerto;
import Facilities.Storage;

/**
 *
 * @author Gabriel
 */
public class CollectStrategy implements IActionStrategy{
    
    @Override
    public boolean action(MainCharacter character) {
        character.setCurrentImage("gokuFarmer.png");
        Huerto h = Huerto.getInstance();
        Storage s = Storage.getInstance();
        for(Food food:h.getCurrentFoods()){
            s.addFood(food);
        }
        for(Food cure:h.getCurrentCure()){
            s.addCure(cure);
        }
        h.getCurrentFoods().clear();
        h.getCurrentCure().clear();
        return false;
    }
    
}
