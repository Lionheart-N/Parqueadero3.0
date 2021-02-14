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
import mundo.Parqueadero;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class ParqueaderoDAO {
    
    private Parqueadero parqueadero;

    public ParqueaderoDAO() {
        parqueadero = new Parqueadero();
    }
    
    public void incluirParqueadero( ) throws CaException {
     
        /*try{
          // FALTA POR ARREGLAR 
            String strSQL = "INSERT INTO parqueadero VALUES(?,?,?)" ;
            
         
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, 3);
            prepStmt.setString(2, "Bosa");
            prepStmt.setString(3, "65652");
            
            if(prepStmt.executeUpdate()>0){
                conexion.close();
            }
            
        }catch(SQLException e){
            throw new CaException("ParqueaderoDAO", "No pudo incluir el parqueadero "+ e.getMessage());
        }*/
    }
    
    public void modificarParqueadero(){
      
    }
    
    public void eliminarParqueadero(){
      
    }
    
    public void buscarParqueadero(String idParqueadero) throws CaException{
      try{
          // FALTA POR ARREGLAR 
         String strSQL = "SELECT k_identificacion, o_clave FROM empleado WHERE "
                 + "k_identificacion =" + idParqueadero ;
         
          Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
              //parqueadero.setContraseña(String.valueOf(rs.getInt(1)));
              //parqueadero.setUsuario(rs.getString(2));
                  
          }
      }catch(SQLException e){
        throw new CaException("ParqueaderoDAO", "No pudo recuperar el Parqueadero "+ e.getMessage());
      }
      
    }
    

    public void actualizarParqueadero() throws CaException {

    }

    public Parqueadero getMiParqueadero() {
        return parqueadero;
    }

    public void setMiEmpleado(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }
    
    
    
}
