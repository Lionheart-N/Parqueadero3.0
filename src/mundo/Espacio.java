/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author WIN10
 */
public class Espacio {

    private String idEspacio;
    private String estado;
    private String tipo;
    private int codigoParqueadero;
    private String areaID;

    
    public Espacio(){
        
    }
    
    public Espacio(String idEspacio, String estado, String tipo, int codigoParqueadero, String areaID) {
        this.idEspacio = idEspacio;
        this.estado = estado;
        this.tipo = tipo;
        this.codigoParqueadero = codigoParqueadero;
        this.areaID = areaID;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigoParqueadero() {
        return codigoParqueadero;
    }

    public void setCodigoParqueadero(int codigoParqueadero) {
        this.codigoParqueadero = codigoParqueadero;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    
    public String getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(String idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
