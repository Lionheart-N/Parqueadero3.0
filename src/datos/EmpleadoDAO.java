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
    private ServiceLocator conexion = new ServiceLocator();

    public EmpleadoDAO() {
        
        miEmpleado = new Empleado();
    }
    
    public void incluirEmpleado() throws CaException {
     
      
    }
    
    public void modificarEmpleado(){
      
    }
    
    public void eliminarEmpleado(){
      
    }
    
    public void buscarEmpleado(String usuario) throws CaException{
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT k_id_empeado, o_clave,i_cargo FROM empleado WHERE "
                 + "k_id_empeado = '"+usuario+"'";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                miEmpleado.setUsuario(rs.getString(1));
                miEmpleado.setContraseña(rs.getString(2));            
                miEmpleado.setCargo(rs.getString(3));
            }
        }catch(Exception e){
            System.out.print(e);
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
    

    public void actualizarEmpleado() throws CaException {

    }

    public Empleado getMiEmpleado() {
        return miEmpleado;
    }

    public void setMiEmpleado(Empleado miEmpleado) {
        this.miEmpleado = miEmpleado;
    }
    public int getCodigoParqueadero(String usuario){
        Connection con;
        int codigo = 0;
        PreparedStatement prepStmt;
        String strSQL = "SELECT k_codigoparqueadero FROM empleado WHERE k_id_empeado = '" +usuario+"'" ;
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                codigo = rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.print(ex);
        }
        return codigo;
    }
    
    
    
   
    
    
}
