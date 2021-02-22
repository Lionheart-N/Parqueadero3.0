/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import datos.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.CaException;

/**
 *
 * @author WIN10
 */
public class Controlador {
    
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();
    private ServicioDAO servicioDAO = new ServicioDAO();
    private AreaDAO areaDAO = new AreaDAO();
    private ContratoDAO contratoDAO = new ContratoDAO();
    
    public void incluirEmpleado() throws CaException {
      empleadoDAO.incluirEmpleado();
    }
    public Empleado getEmpleado() {
        return empleadoDAO.getMiEmpleado();
    }
    public void buscarEmpleado(String identificaion) throws CaException{
        empleadoDAO.buscarEmpleado(identificaion);
    }
    public void incluirParqueadero(Parqueadero parqueadero ) throws CaException {
        parqueaderoDAO.incluirParqueadero(parqueadero);
    }
    public void buscarParqueadero(String idParqueadero)throws CaException{
        parqueaderoDAO.buscarParqueadero(idParqueadero);
    }
    public void buscarServicio(String inicial, String ultimo) throws CaException{
        servicioDAO.buscarServicio(inicial,ultimo);
    }
    public void incluirArea(Area area) throws CaException{
        areaDAO.incluirArea(area);
    }
    public static ArrayList<String> consultar_nombres (){
        return ParqueaderoDAO.consultar_nombres();
    }
    
    public ArrayList<Registro> buscarVehiculoPorPlaca(String placa) throws CaException{
        VehiculoDAO buscar = new VehiculoDAO();
        return buscar.buscarVehiculo(placa);
    }
    public Object getInformacion(){
        return servicioDAO.getInformacion();
    }
    public int getCodigoParqueadero(String usuario){
        return empleadoDAO.getCodigoParqueadero(usuario);
    }
    public void buscarContrato(String placa) throws CaException{
        try {
            contratoDAO.buscarContrato(placa);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Contrato getContrato(){
    
        return contratoDAO.getContrato();
    }
    public void actualizarContrato() throws SQLException{
        contratoDAO.actualizarContrato();
    }
}
