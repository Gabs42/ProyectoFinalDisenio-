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
        addSeccion("Cocina",250,250);
        addSeccion("Cuarto",0,0);
        addSeccion("Banio",500,500);
        addSeccion("Comedor",600,600);
        addSeccion("Huerto",700,700);
        addSeccion("Bodega",375,375);
        addSeccion("ZonaEjercicios",800,800);
        addSeccion("ZonaPelea",400,400);
        addSeccion("Jardin",900,900);
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
