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
        miArea = new Area();
    }

    public void incluirArea(Area area) throws CaException {

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
            if (prepStmt.executeUpdate() > 0) {
                con.close();
            } else {
                con.close();
            }
        } catch (Exception e) {

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

}
