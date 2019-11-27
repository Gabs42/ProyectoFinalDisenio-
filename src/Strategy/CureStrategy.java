/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;
import Facilities.Sickness;
import Facilities.Storage;

/**
 *
 * @author Gabriel
 */
public class CureStrategy implements IActionStrategy {

    @Override
    public boolean action(MainCharacter character) {
        Storage st = Storage.getInstance();
        for(Sickness s:character.getCurrentSickness()){
            if("Medicina".equals(s.getCures().get(0).getType())){
                if(st.getMedicine().size()!=0){
                    character.removeSickness(s);
                    st.getMedicine().remove(0);
                    return false;
                }
            }
        }
        return false;
    }
    
}
