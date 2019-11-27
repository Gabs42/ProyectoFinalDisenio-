/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

import Characters.MainCharacter;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Sickness implements ISickness {
    private String name;
    private int condition;
    private String attribute;
    private ArrayList<Cure> cures;
    private int duration; 

    public Sickness(String name, int condition, String attribute, ArrayList<Cure> cures, int duration) {
        this.name = name;
        this.condition = condition;
        this.attribute = attribute;
        this.cures = cures;
        this.duration = duration;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ArrayList<Cure> getCures() {
        return cures;
    }

    public void setCures(ArrayList<Cure> cures) {
        this.cures = cures;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
    @Override
    public boolean action(MainCharacter character) {
        if("Diarrea".equals(this.getName())){
            character.setFood(character.getFood()-5);
            if(character.getFood()<0){
                character.setFood(0);
            }
            character.setEnergy(character.getEnergy()-10);
            if(character.getEnergy()<0){
                character.setEnergy(0);
            }
        }
        else if("Vomito".equals(this.getName())){
            character.setFood(character.getFood()-2);
            if(character.getFood()<0){
                character.setFood(0);
            }
            character.setEnergy(character.getEnergy()-5);
            if(character.getEnergy()<0){
                character.setEnergy(0);
            }
        }
        else if("Depresion".equals(this.getName())){
            character.setMentalHealth(character.getMentalHealth()-2);
            if(character.getMentalHealth()<0){
                character.setGordura(0);
            }
            character.setEnergy(character.getEnergy()-5);
            if(character.getEnergy()<0){
                character.setEnergy(0);
            }
            
        }
        return false;
    }
    
}
