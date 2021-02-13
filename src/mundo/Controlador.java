/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import datos.EmpleadoDAO;
import util.CaException;

/**
 *
 * @author WIN10
 */
public class Controlador {
    
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    public void incluirEmpleado() throws CaException {
      empleadoDAO.incluirEmpleado();
    }


    public Empleado getEmpleado() {
        return empleadoDAO.getMiEmpleado();
    }
    
    public void buscarEmpleado(String identificaion)throws CaException{
        empleadoDAO.buscarEmpleado(identificaion);
    }
    
}
