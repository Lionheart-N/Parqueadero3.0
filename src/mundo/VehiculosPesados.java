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
public class VehiculosPesados extends Vehiculo{
    
    private String tipoVehiculo;

    public VehiculosPesados(String tipoVehiculo, String idVehiculo, String color, String marca) {
        super(idVehiculo, color, marca);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    
}
