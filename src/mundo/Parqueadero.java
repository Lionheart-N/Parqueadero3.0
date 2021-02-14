/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author WIN10
 */
public class Parqueadero {
    
    private String nombre;
    private String localidad;
    private String caracteristicas;
    private String direccion;
    private ArrayList<Area> area;
    private String telefono;
    private String nit;
    private String regimen;
    private String poliza;

    public Parqueadero(String nombre, String localidad, String caracteristicas, String direccion, ArrayList<Area> area, String telefono, String nit, String regimen, String poliza) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.caracteristicas = caracteristicas;
        this.direccion = direccion;
        this.area = area;
        this.telefono = telefono;
        this.nit = nit;
        this.regimen = regimen;
        this.poliza = poliza;
    }

    public Parqueadero() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Area> getArea() {
        return area;
    }

    public void setArea(ArrayList<Area> area) {
        this.area = area;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }   

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }
    
}
