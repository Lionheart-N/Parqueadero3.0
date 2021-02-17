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
public class Empleado {
    
    private String usuario;
    
    private String contraseña;
    
    private String codParqueadero;
    
    private String cargo;

    public Empleado(String usuario, String contraseña, String codParqueadero, String cargo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codParqueadero = codParqueadero;
        this.cargo = cargo;
    }

    public Empleado() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodParqueadero() {
        return codParqueadero;
    }

    public void setCodParqueadero(String codParqueadero) {
        this.codParqueadero = codParqueadero;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

   
    
    
    
}
