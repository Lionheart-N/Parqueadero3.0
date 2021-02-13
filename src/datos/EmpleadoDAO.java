/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mundo.Empleado;
import util.CaException;
import util.ServiceLocator;


/**
 *
 * @author WIN10
 */
public class EmpleadoDAO {
    
    private Empleado miEmpleado;

    public EmpleadoDAO() {
        
        miEmpleado = new Empleado();
    }
    
    public void incluirEmpleado() throws CaException {
     
      
    }
    
    public void modificarEmpleado(){
      
    }
    
    public void eliminarEmpleado(){
      
    }
    
    public void buscarEmpleado(String identificaion) throws CaException{
      try{
         String strSQL = "SELECT k_identificacion, o_clave FROM empleado WHERE "
                 + "k_identificacion =" + identificaion ;
         
          Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
              miEmpleado.setContraseña(String.valueOf(rs.getInt(1)));
              miEmpleado.setUsuario(rs.getString(2));
                  
          }
      }catch(SQLException e){
        throw new CaException("EmpleadoDAO", "No pudo recuperar el Empleado "+ e.getMessage());
      }
      
    }
    

    public void actualizarEmpleado() throws CaException {

    }

    public Empleado getMiEmpleado() {
        return miEmpleado;
    }

    public void setMiEmpleado(Empleado miEmpleado) {
        this.miEmpleado = miEmpleado;
    }
    
    
    
   
    
    
}
