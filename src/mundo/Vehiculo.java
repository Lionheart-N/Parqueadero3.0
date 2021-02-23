/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Gabriel Dubuc
 */
public class Vehiculo {
    
    private String idVehiculo;
    
    private String color;
    
    private String marca;
    
    private String tipoVehiculo;

    public Vehiculo(String idVehiculo, String color, String marca, String tipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.color = color;
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
    }

    

    public Vehiculo() {
    }
    

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    
    
    
}
