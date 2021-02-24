/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author WIN10
 */
public class Cliente {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private ArrayList<String> telefono;

    public Cliente() {    
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList<String> telefono) {
        this.telefono = telefono;
    }
    
    
    
}
