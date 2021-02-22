package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mundo.Empleado;
import mundo.Estadistica;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author WIN10
 */
public class EstadisticaDAO {
    
    //SELECT CONCAT('Del ',f_fechaentrada, ' al ', f_fechaentrada) AS "Periodo", v_valor
     //FROM servicio
    //WHERE f_fechaentrada BETWEEN '1996-07-01' AND '1996-07-31' ;
    
    private Estadistica estadisticaN;
    private ServiceLocator conexion = new ServiceLocator();
    private Object[] informacion = new Object[3];

    public EstadisticaDAO() {
        
    }
    
    public void buscarEstadistica(String inicial, String ultimo,String nombre) throws CaException{
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select n_nombreparqueadero,n_tipo, count(*) from espacio e, servicio s,area a, parqueadero p where s.k_idarea=e.k_idarea and s.k_codigoparqueadero=e.k_codigoparqueadero and s.k_idarea=a.k_idarea and s.k_codigoparqueadero=a.k_codigoparqueadero and p.k_codigoparqueadero=a.k_codigoparqueadero group by n_nombreparqueadero,n_tipo";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                
                  informacion[0] = rs.getObject(1);
                  informacion[1] = rs.getObject(2);
                  informacion[3] = rs.getObject(3);
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
    
    public Object getInformacion(){
        return informacion;
    }
    
}
