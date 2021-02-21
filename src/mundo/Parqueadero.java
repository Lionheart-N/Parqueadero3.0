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

    private int identificador;
    private String nombre;
    private String localidad;
    private String caracteristicas;
    private String direccion;
    private int telefono;
    private String nit;

    public Parqueadero(int identificador, String nombre, String localidad, String caracteristicas, String direccion, int telefono, String nit) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.localidad = localidad;
        this.caracteristicas = caracteristicas;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
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

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

}
