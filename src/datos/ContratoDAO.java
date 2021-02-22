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
import mundo.Contrato;
import util.CaException;
import java.util.Date;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class ContratoDAO {
    
    private static ServiceLocator conexion;
    private Contrato contrato = new Contrato();

    public ContratoDAO() {
        conexion = new ServiceLocator();
    }
    
    
    public void buscarContrato(String placa) throws CaException, SQLException{
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT q_estado, MAX(f_fechafinalizacion),k_codigoparqueadero  FROM contrato"
                + " WHERE k_placa = '"+placa+"' GROUP BY q_estado , k_codigoparqueadero";
        ResultSet rs;
        try{   
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                contrato.setEstado(rs.getString("q_estado"));
                contrato.setIdParqueadero(rs.getInt("k_codigoparqueadero"));
            }
        }catch(Exception ex){
            
            System.out.print(ex);
        }
      
    }
    public Contrato getContrato(){
        return contrato;
    }
    public void actualizarContrato() throws SQLException{
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "update contrato set q_estado=?;";
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setString(1,"I");
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print("Hola");
        }
        /*strSQL = "update contrato set q_estado='A' "
                + "where current_date>=f_fechainicio and current_date<f_fechafinalizacion;";
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
        }catch(Exception e){
            System.out.print(e);
        }*/
        
    }
    

    
}
