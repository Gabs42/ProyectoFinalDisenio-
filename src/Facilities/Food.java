/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

import Builder.IBuilder;

/**
 *
 * @author Gabriel
 */
public class Food {
    private String name;
    private int energy;
    private String image;

    public Food(String name, int energy, String image) {
        this.name = name;
        this.energy = energy;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    public static class FoodBuilder implements IBuilder<Food>{
        private String name = "";
        private int energy = 0;
        private String image= "";
        
        public FoodBuilder setName(String name){
            this.name = name;
            return this;
        }
        
        public FoodBuilder setEnergy(int energy){
            this.energy = energy;
            return this;
        }
        
        public FoodBuilder setImage(String image){
            this.image = image;
            return this;
        }
        @Override
        public Food build() {
            return new Food(this.name,this.energy,this.image);
        }
        
    }
}
