/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Characters.MainCharacter;
import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class ActionProvider {
    private IActionStrategy actionStrategy;
    private HashMap<String,IActionStrategy> strategies = new HashMap();
    
    
    public ActionProvider(){
        PeeStrategy pee = new PeeStrategy();
        PooStrategy poo = new PooStrategy();
        SleepStrategy sleep = new SleepStrategy();
        strategies.put("Pee", pee);
        strategies.put("Poo", poo);
        strategies.put("Sleep",sleep);
    }
    
    public void setAccion(String accion){
        this.actionStrategy = strategies.get(accion);
    }
    
    public boolean action(MainCharacter character){
        return this.actionStrategy.action(character);
    }
}
