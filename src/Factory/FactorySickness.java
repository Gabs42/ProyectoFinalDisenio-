/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Facilities.Cure;
import Facilities.ISickness;
import Facilities.Sickness;
import Strategy.SicknessEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class FactorySickness {
    private static HashMap<String,ISickness> sicknesses = new HashMap();
    
    
    public static ISickness getInstance(String s){
        return sicknesses.get(s);
    }
    
    public static ISickness createSickness(SicknessEnum sick){
        Sickness newSickness = null;
        Cure cure;
        switch(sick){
                case Diarrea:
                    cure = new Cure("Medicina","Herb");
                    newSickness = new Sickness(sick.toString(),80,"Comida,",new ArrayList<Cure>(Arrays.asList(cure)),4);                   
                    break;
                case Vomito:
                    cure = new Cure("Medicina","Herb");
                    newSickness = new Sickness(sick.toString(),100,"Comida",new ArrayList<Cure>(Arrays.asList(cure)),5);
                    FactorySickness.addSickness(newSickness, sick.toString());
                    break;
                case Depresion:
                    cure = new Cure("Excercise","");
                    newSickness = new Sickness(sick.toString(),50,"Mental",new ArrayList<Cure>(Arrays.asList(cure)),4);
                    FactorySickness.addSickness(newSickness, sick.toString());
                    break;
            }
        return newSickness;
    }
    
    public static void addSickness(ISickness sickness,String key){
        sicknesses.put(key, sickness);
    }
}
