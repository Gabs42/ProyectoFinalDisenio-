/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Facilities.Correr;
import Facilities.IExcercise;
import Facilities.Nadar;
import Strategy.ExcerciseEnum;
import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class FactoryExcercise {
    public static HashMap<String,IExcercise> excercises = new HashMap();
    
    public static IExcercise getIntance(ExcerciseEnum ex){
        switch(ex){
            case Nadar:
                Nadar nadarAccion = new Nadar();
                return nadarAccion;
                
            case Correr:
                Correr correrAccion = new Correr();
                return correrAccion;
        }
        return null;
                
    }
}
