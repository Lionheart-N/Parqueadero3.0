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
import util.ServiceLocator;

/**
 *
 * @author Gabriel Dubuc
 */
public class JoinDAO {
    
    private static ServiceLocator conexion;
    
    public JoinDAO() {
        conexion = new ServiceLocator();
    }
    
    public int valorPago(String placa, int codigoParqueadero, int minutos){
        int valorPago = 0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select t.v_valor  from vehiculo v,tarifas t, parqueadero p "
                + "where v.k_placa='"+placa+"' and v.i_tipodevehiculo=t.n_tipodevehiculo "
                + "and p.o_caracteristicas=t.o_caracteristicas and p.k_codigoparqueadero= "
                + codigoParqueadero +" and p.n_localidad=t.n_localidad;";
        
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                    
                valorPago = rs.getInt(1);
                
            }
                 
        }catch(Exception e){
            System.out.print(e);
        }
        
        System.out.println(minutos);
        return (valorPago*minutos);
    }
    public String areaId(String Placa){
        String areaId = "";
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT a.k_idarea FROM area a, servicio s WHERE s.k_codigoparqueadero = a.k_codigoparqueadero \n" +
        "AND s.k_idarea = a.k_idarea AND k_placa = '"+Placa+"' AND o_horasalida IS null;";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                    
                areaId = rs.getString(1);
                
            }
                 
        }catch(Exception e){
            System.out.print(e);
        }
        return areaId;
    }
    public String espacioId(String Placa){
        String espacioId = "";
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT k_idespacio FROM area a, servicio s WHERE s.k_codigoparqueadero = a.k_codigoparqueadero \n" +
        "AND s.k_idarea = a.k_idarea AND k_placa = '"+Placa+"' AND o_horasalida IS null;";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                    
                espacioId = rs.getString(1);
                
            }
                 
        }catch(Exception e){
            System.out.print(e);
        }
        return espacioId;
    }
    
}
