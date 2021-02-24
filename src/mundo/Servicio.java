/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author WIN10
 */
public class Servicio {
    
    private Integer idServicio;
    private Calendar horaEntrada;
    private Calendar horaSalida;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Pago miPago;


    public Servicio(Integer idServicio, Calendar horaEntrada, Calendar horaSalida, Date fechaEntrada, Date fechaSalida, Pago miPago) {
        this.idServicio = idServicio;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.miPago = miPago;
    }

    public Servicio() {
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
    public long calcularDifMinutos( String fechaInicial,String fechaFinal){
      long respuesta=0;
      Date fechaIni = null;
      Date fechafin = null;
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try{
          fechaIni = format.parse(fechaInicial);
          fechafin = format.parse(fechaFinal);
      }catch(Exception ex){
          System.out.print(ex);
      }
      respuesta = (fechafin.getTime() - fechaIni.getTime())/60000;
      
      
      return respuesta;
    }

    public Calendar getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Calendar horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Calendar getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Calendar horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

   

    public Pago getMiPago() {
        return miPago;
    }

    public void setMiPago(Pago miPago) {
        this.miPago = miPago;
    }

    
    
    

}
