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
import java.time.LocalTime;
import mundo.Area;
import mundo.Empleado;
import mundo.Parqueadero;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class AreaDAO {//Holaaa

    private Area miArea;
    private ServiceLocator conexion = new ServiceLocator();

    public AreaDAO() {
        
    }

    public void incluirArea(Area area) throws CaException {
        miArea = area;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO area VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName(conexion.getDriver());
            con = DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setInt(1, miArea.getCuposAutomoviles());
            prepStmt.setInt(2, miArea.getCuposMotos());
            prepStmt.setInt(3, miArea.getCuposBicicletas());
            prepStmt.setInt(4, miArea.getCuposTotales());
            prepStmt.setInt(5, miArea.getCodigoParqueadero());
            prepStmt.setInt(6, miArea.getAutosDisponibles());
            prepStmt.setInt(7, miArea.getMotosDisponibles());
            prepStmt.setInt(8, miArea.getBicicletasDisponibles());
            prepStmt.setString(9, miArea.getIdentificacion()); //Autoincremento del identificador
            System.out.println(miArea.getIdentificacion());
            if (prepStmt.executeUpdate() > 0) {
                con.close();
            } else {
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
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

    public Area getMiArea() {
        return miArea;
    }

    public void setMiArea(Area miArea) {
        this.miArea = miArea;
    }
    public void actualizarAreaAutomovil(){
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "update area b set q_disponiblesAutomoviles=(select count(*)"
                + "from espacio e,area a where e.n_tipo='Automoviles' and e.k_codigoparqueadero=a.k_codigoparqueadero "
                + "and e.k_idarea=a.k_idarea and b.k_idarea=a.k_idarea and e.q_disponibilidad='D');";
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);

            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public void actualizarAreaMotocicletas(){
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "update area b set q_disponiblesMotos=(select count(*)"
                + "from espacio e,area a where e.n_tipo='Motocicletas' and e.k_codigoparqueadero=a.k_codigoparqueadero "
                + "and e.k_idarea=a.k_idarea and b.k_idarea=a.k_idarea and e.q_disponibilidad='D');";
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);

            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public void actualizarAreaBicicletas(){
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "update area b set q_disponiblesBicicletas=(select count(*)"
                + "from espacio e,area a where e.n_tipo='Bicicletas' and e.k_codigoparqueadero=a.k_codigoparqueadero "
                + "and e.k_idarea=a.k_idarea and b.k_idarea=a.k_idarea and e.q_disponibilidad='D');";
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);

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
