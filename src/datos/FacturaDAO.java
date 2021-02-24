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
import mundo.Factura;
import util.ServiceLocator;

/**
 *
 * @author Gabriel Dubuc
 */
public class FacturaDAO {
    
    private ServiceLocator conexion = new ServiceLocator();
    
    private Factura factura = new Factura();
    
    public FacturaDAO() {
        conexion = new ServiceLocator();
    }
    public void rellenarFactura(String placa){
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT f_fechasalida, k_placa, v_valor, o_horasalida, telefono, n_nombreparqueadero, o_direccion\n" +
            "FROM parqueadero p, servicio s WHERE p.k_codigoparqueadero = s.k_codigoparqueadero\n" +
            "AND k_placa = 'WTY254'";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                    
               factura.setFechaSalida(rs.getDate(1).toString());
               factura.setPlaca(rs.getString(2));
               factura.setPago(rs.getInt(3));
               factura.setHoraSalida(rs.getTime(4).toString());
               factura.setTelefono(rs.getInt(5));
               factura.setNombre(rs.getString(6));
               factura.setDireccion(rs.getString(7));
            }
                 
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
}
