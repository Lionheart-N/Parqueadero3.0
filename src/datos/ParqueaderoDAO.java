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
import java.util.ArrayList;
import mundo.Empleado;
import mundo.Parqueadero;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class ParqueaderoDAO {

    private static ServiceLocator conexion;
    private int numeroCupos;
    private int numeroAreas;
    private int contador;
    private int contadorVerdadero;
    private int contadorFalso;
    
    public ParqueaderoDAO() {
        conexion = new ServiceLocator();
    }

    public void incluirParqueadero(Parqueadero parqueadero) throws CaException {

        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO parqueadero VALUES(?,?,?,?,?,?)";

        try {
            Class.forName(conexion.getDriver());
            con = DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setInt(1, parqueadero.getIdentificador());
            prepStmt.setString(2, parqueadero.getLocalidad());
            prepStmt.setString(3, parqueadero.getDireccion());
            prepStmt.setString(4, parqueadero.getNombre());
            prepStmt.setString(5, parqueadero.getCaracteristicas());
            prepStmt.setString(6, parqueadero.getNit());
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

    public void modificarParqueadero() {

    }

    public void eliminarParqueadero() {

    }

    public void buscarParqueadero(String idParqueadero) throws CaException {
        /*try{
          // FALTA POR ARREGLAR 
         String strSQL = "SELECT k_identificacion, o_clave FROM empleado WHERE "
                 + "k_identificacion =" + idParqueadero ;
         
          Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
          while (rs.next()){
              //parqueadero.setContraseña(String.valueOf(rs.getInt(1)));
              //parqueadero.setUsuario(rs.getString(2));
                  
          }
      }catch(SQLException e){
        throw new CaException("ParqueaderoDAO", "No pudo recuperar el Parqueadero "+ e.getMessage());
      }
         */
    }

    public void actualizarParqueadero() throws CaException {

    }

    /**
     * public Parqueadero getMiParqueadero() { return parqueadero; }
     *
     * public void setMiEmpleado(Parqueadero parqueadero) { this.parqueadero =
     * parqueadero; }
     */
    public static ArrayList<String> consultar_nombres() {
        Connection con;
        PreparedStatement prepStmt;
        String script = "SELECT n_nombreparqueadero FROM parqueadero";
        ResultSet rs;
        ArrayList<String> nombres = new ArrayList<String>();

        try {
            Class.forName(conexion.getDriver());
            con = DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(script);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                nombres.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("No se pudo consultar los nombres del parqueadero, porque ocurrió este error: " + e);
        }

        return nombres;
    }

    public boolean verificarCupo(String tipoVehiculo, int codigoParqueadero) {
        Connection con;
        PreparedStatement prepStmt;
        String script = "";
        String scriptBusqueda = "";
        ResultSet rs;
        contador = 0;
        numeroCupos = 0;
        scriptBusqueda = "SELECT COUNT(*) FROM area WHERE k_codigoparqueadero=" + codigoParqueadero;
        //Consultar el numero de registros en la tabla area

        if (tipoVehiculo.equals("Motocicletas")) {  //Segun la seleccion del usuario asignamos un script
            script = " SELECT q_disponiblesmotos FROM area WHERE k_codigoparqueadero =" + codigoParqueadero;
        } else if (tipoVehiculo.equals("Automoviles")) {
            script = " SELECT q_disponiblesautomoviles FROM area WHERE k_codigoparqueadero =" + codigoParqueadero;
        } else {
            script = " SELECT q_disponiblesbicicletas FROM area WHERE k_codigoparqueadero =" + codigoParqueadero;
        }

        try {
            Class.forName(conexion.getDriver());
            con = DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());

            prepStmt = con.prepareStatement(scriptBusqueda); //Ejecutamos el script para saber el numero de areas
            rs = prepStmt.executeQuery();
            rs.next();
            numeroAreas = rs.getInt(1);   //Asignamos el numero de areas a una variable de tipo int

            while (contador < numeroAreas) {   //Ciclo while que se repite el numero de areas del parqueadero
                contador++;

                prepStmt = con.prepareStatement(script);    //Ejecutamos el script para saber el numero de cupos disponibles
                rs = prepStmt.executeQuery();
                for (int i = 0; i < contador; i++) {    //Segun el area en la que estemos gracias al contador seguimos al siguiente registro la cantidad de veces necesarias
                    rs.next();
                }
                numeroCupos = rs.getInt(1);

                if (numeroCupos > 0) {
                    contadorVerdadero++;    //Se contabilizan las veces que hay cupos disponibles;
                }
                if (numeroCupos == 0) {
                    contadorFalso++;    //Se contabilizan las veces todos los cupos estan llenos
                }
            }

            if (contadorFalso == numeroAreas) {   //Si el numero de areas llenas es igual al numero de parqueaderos se retorna falso
                return false;
            } else {
                return true;    //De lo contrario se retorna verdadero
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    /*public int obtenerArea(){
        
    }*/
}
