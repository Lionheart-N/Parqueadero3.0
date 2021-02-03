/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author WIN10
 */
public class Servicio {
    
    private String idServicio;
    private Calendar horaEntrada;
    private Calendar minutoEntrada;
    private Calendar segundoEntrada;
    private Calendar horaSalida;
    private Calendar minutoSalida;
    private Calendar segundoSalida;
    private Pago miPago;

    public Servicio(String idServicio, Calendar horaEntrada, Calendar minutoEntrada, Calendar segundoEntrada, Calendar horaSalida, Calendar minutoSalida, Calendar segundoSalida, Pago miPago) {
        this.idServicio = idServicio;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.segundoEntrada = segundoEntrada;
        this.horaSalida = horaSalida;
        this.minutoSalida = minutoSalida;
        this.segundoSalida = segundoSalida;
        this.miPago = miPago;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public Calendar getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Calendar horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Calendar getMinutoEntrada() {
        return minutoEntrada;
    }

    public void setMinutoEntrada(Calendar minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }

    public Calendar getSegundoEntrada() {
        return segundoEntrada;
    }

    public void setSegundoEntrada(Calendar segundoEntrada) {
        this.segundoEntrada = segundoEntrada;
    }

    public Calendar getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Calendar horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Calendar getMinutoSalida() {
        return minutoSalida;
    }

    public void setMinutoSalida(Calendar minutoSalida) {
        this.minutoSalida = minutoSalida;
    }

    public Calendar getSegundoSalida() {
        return segundoSalida;
    }

    public void setSegundoSalida(Calendar segundoSalida) {
        this.segundoSalida = segundoSalida;
    }

    public Pago getMiPago() {
        return miPago;
    }

    public void setMiPago(Pago miPago) {
        this.miPago = miPago;
    }
    
    

}
