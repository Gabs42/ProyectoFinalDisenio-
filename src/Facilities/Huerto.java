/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

import Facilities.Food.FoodBuilder;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Gabriel
 */
public class Huerto {
    private ArrayList<Food> currentFoods = new ArrayList<>();
    private ArrayList<Food> currentCure = new ArrayList<>();
    private int dailyFood = 0;
    private int actualFood = 0;
    private static Huerto instance;
    private ArrayList<String> randomNames = new ArrayList<>();
    private ArrayList<String> randomImages = new ArrayList<>();
    
    private Huerto(){
        this.randomNames.add("Papa");
        this.randomNames.add("Manzana");
        this.randomNames.add("Sandia");
        this.randomNames.add("Banana");
        this.randomNames.add("Brocoli");
        this.randomNames.add("Repollo");
        this.randomImages.add("badlogic.jpg");
    }
    
    public static Huerto getInstance(){
        if(instance == null){
            instance = new Huerto();
            return instance;
        }
        return instance;
    }
    
    public void generateFood(){
        Random rand = new Random();
        FoodBuilder builder = new FoodBuilder();
        Food f = builder.setEnergy(ThreadLocalRandom.current().nextInt(30,51)).setName(this.randomNames.get(rand.nextInt(randomNames.size()))).setImage(this.randomImages.get(rand.nextInt(randomImages.size()))).build();
        currentFoods.add(f);
        Food c =  builder.setEnergy(0).setName("Herb").setImage(this.randomImages.get(rand.nextInt(randomImages.size()))).build();
        currentCure.add(c);
        
    }

    public ArrayList<Food> getCurrentFoods() {
        return currentFoods;
    }

    public void setCurrentFoods(ArrayList<Food> currentFoods) {
        this.currentFoods = currentFoods;
    }

    public int getDailyFood() {
        return dailyFood;
    }

    public void setDailyFood(int dailyFood) {
        this.dailyFood = dailyFood;
    }

    public int getActualFood() {
        return actualFood;
    }

    public void setActualFood(int actualFood) {
        this.actualFood = actualFood;
    }

    public ArrayList<Food> getCurrentCure() {
        return currentCure;
    }

    public void setCurrentCure(ArrayList<Food> currentCure) {
        this.currentCure = currentCure;
    }
    
    
    
}
