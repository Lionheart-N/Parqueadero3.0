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
public class Factura {
    
    private int minutos;
    
    private String placa;
    
    private String fechaSalida;
    
    private String horaSalida;
    
    private int telefono;
    
    private String nombre;
    
    private String direccion;
    
    private int pago;

    public Factura(int minutos, String placa, String fechaSalida, String horaSalida, int telefono, String nombre, String direccion, int pago) {
        this.minutos = minutos;
        this.placa = placa;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pago = pago;
    }

   

    public Factura() {
    }
    

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
    
    
    
}
