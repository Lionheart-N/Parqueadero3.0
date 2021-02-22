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
import mundo.Contrato;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class ContratoDAO {
    
    private static ServiceLocator conexion;
    private Contrato contrato;
    
    public void buscarContrato(String placa) throws CaException{
      Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT q_estado FROM contrato WHERE k_placa = '"+placa+"'";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                
            }
        }catch(Exception e){
            
        }
      
    }
    
}
