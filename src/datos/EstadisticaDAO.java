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
    private Object[]informacion;

    public EstadisticaDAO() {
        
    }
    
    public void buscarEstadistica(String inicial, String ultimo) throws CaException{
        int auxiliar=(this.numeroColumnas(inicial, ultimo))*3;
        informacion=new Object [auxiliar];
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select n_nombreparqueadero,n_tipo, count(*) from espacio e, servicio s,area a, parqueadero p where s.k_idarea=e.k_idarea and s.k_codigoparqueadero=e.k_codigoparqueadero and s.k_idarea=a.k_idarea and s.k_codigoparqueadero=a.k_codigoparqueadero and p.k_codigoparqueadero=a.k_codigoparqueadero and f_fechaentrada>='"+inicial+"' and f_fechasalida<='"+ultimo+"' group by n_nombreparqueadero,n_tipo;";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            int auxDos=0;
            while (rs.next()){
                for(int i=0;i<3;i++){
                    informacion[(auxDos*3)+i]=rs.getObject(i+1);
                } 
                auxDos++;  
            }
            
        }catch(Exception e){
            
        }
    }
    public int numeroColumnas(String inicial, String ultimo) throws CaException{
        int resultado= 0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select count(n_nombreparqueadero || n_tipo) from espacio e, servicio s,area a, parqueadero p where e.k_idespacio=s.k_idespacio and s.k_idarea=e.k_idarea and s.k_codigoparqueadero=e.k_codigoparqueadero and s.k_idarea=a.k_idarea and s.k_codigoparqueadero=a.k_codigoparqueadero and p.k_codigoparqueadero=a.k_codigoparqueadero and f_fechaentrada>='"+inicial+"' and f_fechasalida<=' "+ultimo+"'";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                resultado=rs.getInt(1);
            }
            
        }catch(Exception e){
            
        }
        return resultado;
        
    }
    
    
    public Object getInformacion(){
        return informacion;
    }
    
}
