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
import java.time.LocalDate;
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
    public char buscarContrato(String placa, int parqueadero) throws CaException, SQLException{
        char resultado='I';
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select count(*) from contrato where k_codigoparqueadero="+1+
                "and k_placa='"+placa+"' and q_estado='A';";
        ResultSet rs;
        try{   
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                if(rs.getInt(1)!=0){
                    resultado='A';
                }
            }
            
        }catch(Exception ex){
            
            System.out.print(ex);
            System.out.print("Error en contratoDao");
            
        }
        System.out.print(resultado);
            
        return resultado;
    }
    public Contrato getContrato(){
        return contrato;
    }
   public void actualizarContrato(String fecha) throws SQLException{
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "Select actualizar_contratos('"+fecha+"');";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            
        }catch(Exception e){
            System.out.print(e);
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
