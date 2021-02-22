/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author WIN10
 */
public class Estadistica {
    
    private String nombreParqueadero;
    private int numeroCarros;
    private int numeroMotos;
    private int numeroBicis;

    

    public Estadistica() {
    }

    public String getNombreParqueadero() {
        return nombreParqueadero;
    }

    public void setNombreParqueadero(String nombreParqueadero) {
        this.nombreParqueadero = nombreParqueadero;
    }

    public int getNumeroCarros() {
        return numeroCarros;
    }

    public void setNumeroCarros(int numeroCarros) {
        this.numeroCarros = numeroCarros;
    }

    public int getNumeroMotos() {
        return numeroMotos;
    }

    public void setNumeroMotos(int numeroMotos) {
        this.numeroMotos = numeroMotos;
    }

    public int getNumeroBicis() {
        return numeroBicis;
    }

    public void setNumeroBicis(int numeroBicis) {
        this.numeroBicis = numeroBicis;
    }
    
    
    

}