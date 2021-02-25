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
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import mundo.Empleado;
import mundo.Servicio;
import mundo.Vehiculo;
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
    
    private Servicio servicioN;
    private ServiceLocator conexion = new ServiceLocator();
    private Object[] informacion = new Object[2];

    public ServicioDAO() {
        
        servicioN = new Servicio();
    }
    
    public long calcularMinutos(String placa){
        long minutos = 0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT CONCAT(f_fechaentrada ||' '|| o_horaentrada), CONCAT(f_fechasalida ||' '|| o_horasalida) \n" +
                        "FROM servicio WHERE k_placa = '"
                +placa+"' ORDER BY f_fechaentrada DESC  limit 1";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                
                minutos = servicioN.calcularDifMinutos(rs.getString(1), rs.getString(2));
                             
            }
            
        }catch(Exception e){
            System.out.print(e);
        }
        return minutos;
    }
    
    
    public void actualizarServicio(String placa) throws CaException {
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "UPDATE servicio SET f_fechasalida =?, o_horasalida=? WHERE k_placa = '"+placa+"' and f_fechasalida is null ";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            prepStmt.setTime(2, java.sql.Time.valueOf(LocalTime.now()));
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public void incluirServicio(Vehiculo vehiculo, int codigoParqueadero,String idEspacio,String idArea) throws CaException {
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO servicio VALUES((select count(*) from servicio)+1,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            prepStmt.setDate(2, null);
            prepStmt.setTime(3, java.sql.Time.valueOf(LocalTime.now()));
            prepStmt.setTime(4, null);
            prepStmt.setNull(5, Types.NULL);
            prepStmt.setNull(6, Types.NULL);
            prepStmt.setString(7, idEspacio);
            prepStmt.setString(8, vehiculo.getIdVehiculo());
            prepStmt.setString(9, idArea);
            prepStmt.setInt(10, codigoParqueadero);
            
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
        
      
    }
    public void insertarMinutosPago(int minutos, String placa, int pago){
        Connection con;
        PreparedStatement prepStmt;
        
        String strSQL = "UPDATE servicio SET q_minutos = ?, v_valor = ? WHERE k_placa = '"+placa+"' AND q_minutos IS null  "
                + "AND v_valor IS null";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setInt(1, minutos);           
            prepStmt.setInt(2, pago); 
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public void modificarServicio(){
      
    }
    
    public void eliminarServicio(){
      
    }
    
    public char buscarServicioActivo(String placa, int parqueadero){
        char ingreso='N';
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select k_numeroservicio, count(*) from servicio where k_placa='"+placa+"' and k_codigoParqueadero="+parqueadero+"and f_fechasalida is null group by k_numeroservicio;";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                int a =rs.getInt(1);
                if(a!=0){
                ingreso='Y';
            }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return ingreso;
    }

    
    public void buscarServicio(String inicial, String ultimo) throws CaException{
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT CONCAT('Del ',f_fechaentrada, ' al ', f_fechaentrada) AS \"Periodo\", SUM(v_valor)" +
        "FROM servicio WHERE f_fechaentrada BETWEEN '"+inicial+"' AND '"+ultimo+"'"
                + "GROUP BY \"Periodo\" ";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                
                  informacion[0] = rs.getObject(1);
                  informacion[1] = rs.getObject(2);
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
    public String buscarServicioSalida(String placa){
        Connection con;
        String fechaSalida = "";
        PreparedStatement prepStmt;
        String strSQL = "SELECT MAX(f_fechaentrada), f_fechasalida "
                + "FROM servicio WHERE k_placa = '"+placa+"' GROUP BY f_fechasalida";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                
                fechaSalida =  rs.getString("f_fechasalida");
            }
            
        }catch(Exception e){
            
        }
        return fechaSalida;
    }
    
    public Object getInformacion(){
        return informacion;
    }
    public int id_incremento (int codigoParqueadero){
        int id = 0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT MAX(k_numeroservicio) FROM servicio WHERE k_codigoparqueadero ="+codigoParqueadero;
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                id =rs.getInt(1)+1;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return id;
    }

} 
    

