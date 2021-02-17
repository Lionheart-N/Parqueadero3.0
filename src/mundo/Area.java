/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 *HOLAHOLA
 * @author WIN10
 */
public class Area {
    
    private String identificacion;
    private ArrayList<Espacio> numCupos;
    private int cuposDisponibles;
    private String tipoArea;

    public Area() {
    }

    
    public Area(String identificacion, ArrayList<Espacio> numCupos, int cuposDisponibles, String tipoArea) {
        this.identificacion = identificacion;
        this.numCupos = numCupos;
        this.cuposDisponibles = cuposDisponibles;
        this.tipoArea = tipoArea;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public ArrayList<Espacio> getNumCupos() {
        return numCupos;
    }

    public void setNumCupos(ArrayList<Espacio> numCupos) {
        this.numCupos = numCupos;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public String getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(String tipoArea) {
        this.tipoArea = tipoArea;
    }
    
    
    
}
