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
    private EstadisticaDAO estadisticaDAO = new EstadisticaDAO();
    private VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private EspacioDAO espacioDAO = new EspacioDAO();
    private PropietarioDAO propietarioDAO = new PropietarioDAO();
    private JoinDAO joinDAO = new JoinDAO();
    private FacturaDAO facturaDAO = new FacturaDAO();
    
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
    public void buscarEstadistica(String inicial, String ultimo) throws CaException{
        estadisticaDAO.buscarEstadistica(inicial, ultimo);
    }
    public int columnasEstadisticas(String inicial, String ultimo) throws CaException{
        return estadisticaDAO.numeroColumnas(inicial, ultimo);
    }
    public void actualizarServicio(String placa) throws CaException {
        servicioDAO.actualizarServicio(placa);
    }
    public void incluirArea(Area area) throws CaException{
        areaDAO.incluirArea(area);
    }
    public void asignarEspacios(Espacio espacio)throws CaException{
        espacioDAO.asignarEspacios(espacio);
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
    public Object getInformacionEstadistica(){
        return estadisticaDAO.getInformacion();
    }
    public int getCodigoParqueadero(String usuario){
        return empleadoDAO.getCodigoParqueadero(usuario);
    }
    public char validarContrato(String placa,int codigo) throws CaException, SQLException{
            return  contratoDAO.buscarContrato(placa,codigo);   
    }
    public char buscarServicioActivo(String placa,int codigo){
        char ingreso='N';
        ingreso= servicioDAO.buscarServicioActivo(placa,codigo);
        return ingreso;
    }

    public Contrato getContrato(){
    
        return contratoDAO.getContrato();
    }
    public void actualizarContrato(String fecha) throws SQLException{
        contratoDAO.actualizarContrato(fecha);
    }
    public boolean verificarCupo(String tipoVehiculo, int codigoParqueadero){
        parqueaderoDAO = new ParqueaderoDAO();
        return parqueaderoDAO.verificarCupo(tipoVehiculo, codigoParqueadero); 
    }
    public void incluirVehiculoMinutos(Vehiculo miVehiculo) throws CaException {
        
        vehiculoDAO.incluirVehiculoMinutos(miVehiculo);
        
    }
    public int id_incremento (int codigoParqueadero){
        return servicioDAO.id_incremento(codigoParqueadero);
    }
    public void incluirServicio(Vehiculo vehiculo, int codigoParqueadero) throws CaException {
      
        servicioDAO.incluirServicio(vehiculo, codigoParqueadero);
      
    }
    public char buscarContrato(String Placa, int parqueadero) throws CaException, SQLException{
        char estado='I';
        estado=contratoDAO.buscarContrato(Placa, parqueadero);
        return estado;
    }
    public String buscarServicioSalida(String placa){
            
        return servicioDAO.buscarServicioSalida(placa);
    }
    public long calcularMinutos(String placa){
        return servicioDAO.calcularMinutos(placa);
    }
    public int valorPago(String placa, int codigoParqueadero, int minutos){
        
        return joinDAO.valorPago(placa, codigoParqueadero, minutos);
    }
    public void insertarMinutosPago(int minutos, String placa, int pago){
        
        servicioDAO.insertarMinutosPago(minutos, placa, pago);
    }
    
    public void actualizarContratoYVehiculo(int idPropietario,String placa,String fechaFinal,int valor, int codigoParqueadero,String marca,String modelo,String color) throws CaException{
        contratoDAO.ingresarContrato(idPropietario, placa, fechaFinal, valor, codigoParqueadero);
        vehiculoDAO.actualizarDatos(marca, modelo, color, placa);
    }
    public boolean buscarPropietario(int idPropietario) throws CaException{
        return propietarioDAO.buscarPropietario(idPropietario);
    }
    
    public void ingresarPropietario(int idPropietario,String nombUno,String nombDos,String apeUno,String apeDos) throws CaException{
        propietarioDAO.ingresarPropietario(idPropietario, nombUno, nombDos, apeUno, apeDos);
    }
    public void rellenarFactura(String placa){
    
        facturaDAO.rellenarFactura(placa);
    }
    public Factura getFactura(){
        
        return facturaDAO.getFactura();
    }

}
