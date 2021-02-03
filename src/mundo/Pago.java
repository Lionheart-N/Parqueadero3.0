/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author WIN10
 */
public class Pago {
    
    private String referencia;
    private String formaDePago;
    private double valorAPagar;

    public Pago(String referencia, String formaDePago, double valorAPagar) {
        this.referencia = referencia;
        this.formaDePago = formaDePago;
        this.valorAPagar = valorAPagar;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
    
    
    
}
