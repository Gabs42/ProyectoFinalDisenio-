/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

/**
 *
 * @author Gabriel
 */
public class Cure {
    private String type;
    private String name; 

    public Cure(String type, String name) {
        this.type = type;
        this.name = name;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
