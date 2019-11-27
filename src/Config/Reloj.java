/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Gabriel
 */
public class Reloj {
    private int hora = 00;
    private int minutos = 00;
    private String horaActual = Integer.toString(hora)+":"+Integer.toString(minutos);
    private long avance;//cantidad de minutos de la vida real que tomara para que pase un dia en el juego
    private int diasAnio;
    private int diasPasados = 1;
    private int anio = 1;

    public Reloj(long avance, int diasAnio) {
        this.avance = (long) (((avance*60.0)/96.0)*1000.0);
       
        this.diasAnio = diasAnio;
    }

    
    
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    

    public long getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getDiasAnio() {
        return diasAnio;
    }

    public void setDiasAnio(int diasAnio) {
        this.diasAnio = diasAnio;
    }

    public int getAño() {
        return anio;
    }

    public void setAño(int año) {
        this.anio = año;
    }

    public String getHoraActual() {
        return horaActual;
    }

    public int getDiasPasados() {
        return diasPasados;
    }

    public void setDiasPasados(int diasPasados) {
        this.diasPasados = diasPasados;
    }
    
    
    
    public void actualizar(){
        this.minutos += 15;
        if(minutos == 60){
            this.hora+=1;
            this.minutos = 00;
        }
        if(this.hora == 24&&this.minutos == 0){
            this.hora = 00;
            this.diasPasados += 1;
        }
        if(diasPasados>diasAnio){
            this.anio +=1;
            diasPasados = 0;
        }
        this.horaActual = Integer.toString(hora)+":"+Integer.toString(minutos);
    }
    
    
}
