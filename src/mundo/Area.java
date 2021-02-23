/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 * HOLa
 *
 * @author WIN10
 */
public class Area { //Hola

    private String identificacion;
    private int cuposAutomoviles;
    private int cuposMotos;
    private int cuposBicicletas;
    private int cuposTotales;
    private int codigoParqueadero;
    private int motosDisponibles;
    private int autosDisponibles;
    private int bicicletasDisponibles;

    public Area() {
        
    }

    public Area(String identificacion, int cuposAutomoviles, int cuposMotos, int cuposBicicletas, int cuposTotales, int codigoParqueadero, int motosDisponibles, int autosDisponibles, int bicicletasDisponibles) {
        this.identificacion = identificacion;
        this.cuposAutomoviles = cuposAutomoviles;
        this.cuposMotos = cuposMotos;
        this.cuposBicicletas = cuposBicicletas;
        this.cuposTotales = cuposTotales;
        this.codigoParqueadero = codigoParqueadero;
        this.motosDisponibles = motosDisponibles;
        this.autosDisponibles = autosDisponibles;
        this.bicicletasDisponibles = bicicletasDisponibles;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getCuposAutomoviles() {
        return cuposAutomoviles;
    }

    public void setCuposAutomoviles(int cuposAutomoviles) {
        this.cuposAutomoviles = cuposAutomoviles;
    }

    public int getCuposMotos() {
        return cuposMotos;
    }

    public void setCuposMotos(int cuposMotos) {
        this.cuposMotos = cuposMotos;
    }

    public int getCuposBicicletas() {
        return cuposBicicletas;
    }

    public void setCuposBicicletas(int cuposBicicletas) {
        this.cuposBicicletas = cuposBicicletas;
    }

    public int getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(int cuposTotales) {
        this.cuposTotales = cuposTotales;
    }

    public int getCodigoParqueadero() {
        return codigoParqueadero;
    }

    public void setCodigoParqueadero(int codigoParqueadero) {
        this.codigoParqueadero = codigoParqueadero;
    }

    public int getMotosDisponibles() {
        return motosDisponibles;
    }

    public void setMotosDisponibles(int motosDisponibles) {
        this.motosDisponibles = motosDisponibles;
    }

    public int getAutosDisponibles() {
        return autosDisponibles;
    }

    public void setAutosDisponibles(int autosDisponibles) {
        this.autosDisponibles = autosDisponibles;
    }

    public int getBicicletasDisponibles() {
        return bicicletasDisponibles;
    }

    public void setBicicletasDisponibles(int bicicletasDisponibles) {
        this.bicicletasDisponibles = bicicletasDisponibles;
    }

}
