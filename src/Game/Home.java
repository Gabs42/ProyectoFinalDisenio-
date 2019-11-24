/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import com.badlogic.gdx.math.Vector2;
import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class Home {
    private HashMap<String,Vector2> secciones = new HashMap(); 
    
    public Home(){
        addSeccion("Cocina",0,0);
        addSeccion("Cuarto",15,15);
        addSeccion("Banio",500,500);
        addSeccion("Comedor",50,50);
        addSeccion("Huerto",100,100);
        addSeccion("Bodega",200,200);
        addSeccion("ZonaEjercicios",300,300);
        addSeccion("ZonaPelea",400,400);
        addSeccion("Jardin",30,30);
    }

    public HashMap<String, Vector2> getSecciones() {
        return secciones;
    }

    public void setSecciones(HashMap<String, Vector2> secciones) {
        this.secciones = secciones;
    }
    public void addSeccion(String nombre,int x,int y){
        Vector2 v = new Vector2(x,y);
        this.secciones.put(nombre, v);
    }
    
    public Vector2 getSeccion(String nombre){
        Vector2 v = this.secciones.get(nombre);
        return v;
    }
    
    
}
