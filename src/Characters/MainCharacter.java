/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;
import Character.Character;
import Equipment.Equipment;
import Facilities.Sickness;
import Strategy.ActionProvider;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class MainCharacter extends Character{
    
    private int age;
    private ActionProvider action;
    private int tiredness;
    private int liquid;
    private int food;
    private int physycalHealth;
    private int mentalHealth;
    private int energy;
    private int gordura;
    private String currentAction = "";
    private ArrayList<Ability> currentAbilities = new ArrayList<>();
    private ArrayList<Sickness> currentSickness = new ArrayList<>();
    private String currentImage="";
    private int xPos = 100;
    private int yPos = 100;
    
    public MainCharacter(String name, String image, int hp, int dps, int level) {
        super(name,new ArrayList<String>(Arrays.asList(image)), null, hp, dps, level,0,0,0,null);
        this.age = 1;
        this.tiredness = 20;
        this.liquid = 20;
        this.food = 20;
        this.physycalHealth = 100;
        this.mentalHealth = 100;
        this.energy = 100;
        this.gordura = 0;
        this.currentImage = this.getImages().get(0);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ActionProvider getAction() {
        return action;
    }

    public void setAction(ActionProvider action) {
        this.action = action;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public int getLiquid() {
        return liquid;
    }

    public void setLiquid(int liquid) {
        this.liquid = liquid;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPhysycalHealth() {
        return physycalHealth;
    }

    public void setPhysycalHealth(int physycalHealth) {
        this.physycalHealth = physycalHealth;
    }

    public int getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(int mentalHealth) {
        this.mentalHealth = mentalHealth;
    }

    public String getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }

    public ArrayList<Ability> getCurrentAbilities() {
        return currentAbilities;
    }

    public void setCurrentAbilities(ArrayList<Ability> currentAbilities) {
        this.currentAbilities = currentAbilities;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getGordura() {
        return gordura;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    public ArrayList<Sickness> getCurrentSickness() {
        return currentSickness;
    }

    public void setCurrentSickness(ArrayList<Sickness> currentSickness) {
        this.currentSickness = currentSickness;
    }
    
    public void addSickness(Sickness s){
        this.currentSickness.add(0,s);
    }
    public void removeSickness(Sickness s){
        this.currentSickness.remove(s);
    }

    public String getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(String currentImage) {
        this.currentImage = currentImage;
    }
    public void addAbility(Ability ab){
        this.currentAbilities.add(ab);
    }
}
