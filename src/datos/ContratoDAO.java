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
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import mundo.Contrato;
import util.CaException;
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
        String strSQL = "select count(*) from contrato where k_codigoparqueadero="+parqueadero+
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
        
    }
   
   
   
   public void ingresarContrato(int idPropietario,String placa ,String fechaFinal,int valor,int codigoParqueadero) throws CaException {
     
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO contrato VALUES((select count(*) from contrato)+1,?,'"+fechaFinal+"',"+
                valor+",'"+placa+"','"+idPropietario+"',"+codigoParqueadero+",'A')" ;
        
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setDate(1,java.sql.Date.valueOf(LocalDate.now()));
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    

    
}
