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
import java.util.ArrayList;
import mundo.Registro;
import mundo.Vehiculo;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class VehiculoDAO {
    private ServiceLocator conexion = new ServiceLocator();
    private Vehiculo miVehiculo = new Vehiculo();
    public void incluirVehiculoMinutos(Vehiculo miVehiculo) throws CaException {
     
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO vehiculo VALUES(?,?,?,?)" ;
        
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setString(1,miVehiculo.getIdVehiculo());
            prepStmt.setString(2,miVehiculo.getTipoVehiculo());
            prepStmt.setString(3,null);
            prepStmt.setString(4,null);
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
        //Connection conexion = ServiceLocator.getInstance().tomarConexion();
        /*try{
          // FALTA POR ARREGLAR 
            String strSQL = "INSERT INTO parqueadero VALUES(?,?,?)" ;
            
         
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, 3);
            prepStmt.setString(2, "Bosa");
            prepStmt.setString(3, "65652");
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException("ParqueaderoDAO", "No pudo incluir el parqueadero "+ e.getMessage());
        }finally {
            ServiceLocator.getInstance().liberarConexion();
        }*/
    }
    
    
    public ArrayList<Registro> buscarVehiculo(String placa) throws CaException{
        ArrayList<Registro> registros = new ArrayList<>();
        Registro registro = new Registro(placa);
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT o_horaentrada, o_horasalida, f_fechaentrada, f_fechasalida\n" +
                        "FROM servicio WHERE k_placa = '"+placa+"' ";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                String fecha="";
                fecha += rs.getDate(3);
                fecha += rs.getTime(1);
                registro.setEntrada(fecha);
                fecha = "";
                fecha += rs.getDate(4);
                fecha += rs.getTime(2);
                registro.setSalida(fecha);
                registros.add(registro);
            }
            return registros;
        }catch(Exception e){
            return buscarVehiculoContrato(placa);  
        } 
}
    
   
    
    public void actualizarDatos(String marca, String modelo,String color,String placa) throws CaException {
     
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "update vehiculo set n_modelo=?,o_color=?,n_marca=? where k_placa=?;" ;
        
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setString(1,modelo);
            prepStmt.setString(2,color);
            prepStmt.setString(3,marca);
            prepStmt.setString(4,placa);
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public Vehiculo retornarTipoVehiculo(String placa){
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT i_tipodevehiculo FROM vehiculo WHERE k_placa = '"+placa+"' ";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                
                miVehiculo.setTipoVehiculo(rs.getString(1));
            }
            
        }catch(Exception e){
            System.out.print(e);
        }
        return miVehiculo;
    }
    
 
    
    public ArrayList<Registro> buscarVehiculoContrato(String placa) throws CaException{
        ArrayList<Registro> registros = new ArrayList<>();
        Registro registro = new Registro(placa);
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT  f_fechainicio, f_fechafinalizacion\n" +
                        "FROM contrato WHERE k_placa = '"+placa+"';";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                registro.setEntrada(rs.getDate(1).toString());
                registro.setSalida(rs.getDate(2).toString());
                registros.add(registro);
            }
            return registros;
        }catch(Exception e){
            return null;  
        }    
}
    
}
