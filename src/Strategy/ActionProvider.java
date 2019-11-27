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
        EatStrategy eat = new EatStrategy();
        CollectStrategy collect = new CollectStrategy();
        SicknessStrategy sick = new SicknessStrategy();
        CureStrategy cure = new CureStrategy();
        ExcerciseStrategy exc = new ExcerciseStrategy();
        MeditateStrategy meditate= new MeditateStrategy();
        strategies.put("Pee", pee);
        strategies.put("Poo", poo);
        strategies.put("Sleep",sleep);
        strategies.put("Eat",eat);
        strategies.put("Collect",collect);
        strategies.put("Sick",sick);
        strategies.put("Cure", cure);
        strategies.put("Excercise",exc);
        strategies.put("Meditate", meditate);
    }
    
    public void setAccion(String accion){
        this.actionStrategy = strategies.get(accion);
    }
    
    public boolean executeAction(String accion,MainCharacter character){
        return this.strategies.get(accion).action(character);
    }
    
    public boolean action(MainCharacter character){
        return this.actionStrategy.action(character);
    }
}
