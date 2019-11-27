/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Storage {
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Food> medicine = new ArrayList<>();
    private static Storage instance; 
    private int selectedFood = 0;
    
    private Storage(){
        //Food f = new Food("Hi",50,"as");
        //this.foods.add(f);
    }
    
    public static Storage getInstance(){
        if(instance == null){
            instance = new Storage();
            return instance;
        }
        return instance;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
    
    public void addFood(Food food){
        this.foods.add(0,food);
    }
    
    public void addCure(Food food){
        this.medicine.add(food);
    }

    public int getSelectedFood() {
        return selectedFood;
    }

    public void setSelectedFood(int selectedFood) {
        this.selectedFood = selectedFood;
    }
    
    public ArrayList<Food> getMedicine(){
        return medicine;
    }
    
}
