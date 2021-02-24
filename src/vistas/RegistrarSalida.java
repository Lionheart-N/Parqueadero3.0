/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mundo.Controlador;
import util.CaException;

/**
 *
 * @author WIN10
 */
public class RegistrarSalida extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();
    private int codigoParqueadero = 0;
    /**
     * Creates new form VentanaUno
     */
    public RegistrarSalida(java.lang.Integer codigoParqueadero) {
        initComponents();
        this.codigoParqueadero = codigoParqueadero;
        setResizable(false);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;		
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon (getClass().getResource("../img/icon.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPlacaVehiculo = new javax.swing.JTextField();
        btnSalida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPlacaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPlacaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 110, -1));

        btnSalida.setText("Registrar salida");
        btnSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalidaMouseClicked(evt);
            }
        });
        getContentPane().add(btnSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 110, -1));

        jLabel1.setText("  Placa del Vehiculo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 99, -1));

        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-P.png"))); // NOI18N
        btn_Salir.setContentAreaFilled(false);
        btn_Salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-G.png"))); // NOI18N
        btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalirMouseClicked(evt);
            }
        });
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 60, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaVehiculoActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalirMouseClicked
       Empleado miEmpleado = new Empleado (codigoParqueadero);
       miEmpleado.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_SalirMouseClicked

    private void btnSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseClicked
        // TODO add your handling code here:
        if(txtPlacaVehiculo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor ingresa un valor válido");
        }else{
            try { 
                if(controlador.buscarContrato(txtPlacaVehiculo.getText(), codigoParqueadero)=='I'){
                    
                    if(controlador.buscarServicioActivo(txtPlacaVehiculo.getText(),codigoParqueadero)=='Y')
                    {
                        controlador.actualizarServicio(txtPlacaVehiculo.getText());
                        int minuto = (int) controlador.calcularMinutos(txtPlacaVehiculo.getText());
                        int pago  = controlador.valorPago(txtPlacaVehiculo.getText(), codigoParqueadero,minuto );
                        controlador.insertarMinutosPago(minuto, txtPlacaVehiculo.getText(), pago);
                        JOptionPane.showMessageDialog(null, "Se registro la salidad satisfactoriamente"); 
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "El automovil ya salio del parqueadero");
                    }
                }
                else if(controlador.buscarContrato(txtPlacaVehiculo.getText(), codigoParqueadero)=='A'){
                
                    
                
                }else{
                    JOptionPane.showMessageDialog(null, "El vehiculo cuenta con un contrato inactivo");
                }
            } catch (CaException ex) {
                //Logger.getLogger(RegistrarSalida.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                //Logger.getLogger(RegistrarSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btnSalidaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarSalida(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtPlacaVehiculo;
    // End of variables declaration//GEN-END:variables
}
