package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mundo.Cliente;
import mundo.Empleado;
import util.CaException;
import util.ServiceLocator;


public class PropietarioDAO {
    private Cliente miPropietario;
    private ServiceLocator conexion = new ServiceLocator();

    public PropietarioDAO() {
        miPropietario = new Cliente();
    }
    
    public boolean buscarPropietario(int id){
        boolean resultado=false;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from propietario where k_identificacionpropietario="+id+";";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                int a =rs.getInt(1);
                System.out.println(a);
                if(a!=0){
                resultado=true;
            } 
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(resultado);
        return resultado;
    }
    
    public void ingresarPropietario(int idPropietario,String nombreUno ,String nombreDos,String apeUno ,String apeDos) throws CaException {
     
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "INSERT INTO propietario VALUES("+idPropietario+",'"+nombreUno+"','"+
                nombreDos+"','"+apeUno+"','"+apeDos+"')" ;
        
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
