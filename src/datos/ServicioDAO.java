/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import mundo.Empleado;
import mundo.Servicio;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class ServicioDAO {
    
    //SELECT CONCAT('Del ',f_fechaentrada, ' al ', f_fechaentrada) AS "Periodo", v_valor
     //FROM servicio
    //WHERE f_fechaentrada BETWEEN '1996-07-01' AND '1996-07-31' ;
    
    private Servicio servicio;
    private ServiceLocator conexion = new ServiceLocator();

    public ServicioDAO() {
        
        servicio = new Servicio();
    }
    
    public void incluirServicio() throws CaException {
     
      
    }
    
    public void modificarServicio(){
      
    }
    
    public void eliminarServicio(){
      
    }
    
    public void buscarServicio(Servicio servicio) throws CaException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String date = sdf.format();
        //String dateFinal = sdf.format();
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = ""  ;
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                //miEmpleado.setContraseña(String.valueOf(rs.getInt(1)));
                //miEmpleado.setUsuario(rs.getString(2));
                  
            }
        }catch(Exception e){
            
        }
        /*try{
            String strSQL = "SELECT k_identificacion, o_clave FROM empleado WHERE "
                 + "k_identificacion =" + identificaion ;
         
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                miEmpleado.setContraseña(String.valueOf(rs.getInt(1)));
                miEmpleado.setUsuario(rs.getString(2));
                  
            }
            conexion.close();
        }catch(SQLException e){
            throw new CaException("EmpleadoDAO", "No pudo recuperar el Empleado "+ e.getMessage());
        }*/
      
    }
    

    public void actualizarServicio() throws CaException {

    }
    
}
