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
import mundo.Espacio;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class EspacioDAO {

    private Espacio miEspacio;
    private ServiceLocator conexion = new ServiceLocator();

    public EspacioDAO() {

    }

    public void asignarEspacios(Espacio espacio) throws CaException {
        miEspacio = espacio;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO espacio VALUES(?,?,?,?,?)";
        try {
            Class.forName(conexion.getDriver());
            con = DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setString(1, miEspacio.getIdEspacio());
            prepStmt.setString(2, miEspacio.getTipo());
            prepStmt.setInt(3, miEspacio.getCodigoParqueadero());
            prepStmt.setString(4, miEspacio.getAreaID());
            prepStmt.setString(5, miEspacio.getEstado());
            
            if (prepStmt.executeUpdate() > 0) {
                con.close();
            } else {
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Espacio getMiEspacio() {
        return miEspacio;
    }

    public void setMiEspacio(Espacio miEspacio) {
        this.miEspacio = miEspacio;
    }

    public ServiceLocator getConexion() {
        return conexion;
    }

    public void setConexion(ServiceLocator conexion) {
        this.conexion = conexion;
    }
    
    public String obtenerEspacio(String idArea,String tipo,int codigo){
        String resultado=null;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT k_idespacio FROM espacio WHERE k_codigoparqueadero = "+codigo+" \n" +
                        "AND n_tipo = '"+tipo+"' AND k_idarea = '"+idArea+"' \n" +
                        "AND q_disponibilidad = 'D' limit 1";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                  resultado=rs.getString(1);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en espacio DAO");
            
        }     
        return resultado;
    }

}
