/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


/**
 *
 * @author USUARIO
 */
public class Empleado extends javax.swing.JFrame {
    
    private int codigoParqueadero;
    /**
     * Creates new form Empleado
     */
    public Empleado(java.lang.Integer codigoParqueadero) {
        initComponents();
        this.codigoParqueadero = codigoParqueadero;
        setTitle("Empleado");
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

        jLabel1 = new javax.swing.JLabel();
        btn_RegistrarSalida = new javax.swing.JButton();
        btn_RegistrarEntrada = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sistema22.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 50));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 100));

        btn_RegistrarSalida.setText("Registrar salida");
        btn_RegistrarSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RegistrarSalidaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_RegistrarSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 120, 40));

        btn_RegistrarEntrada.setText("Registrar entrada");
        btn_RegistrarEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RegistrarEntradaMouseClicked(evt);
            }
        });
        btn_RegistrarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 120, 40));

        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-P.png"))); // NOI18N
        btn_Salir.setContentAreaFilled(false);
        btn_Salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-G.png"))); // NOI18N
        btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalirMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 50, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarEntradaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_RegistrarEntradaActionPerformed

    private void btn_RegistrarSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RegistrarSalidaMouseClicked
        RegistrarSalida registrarSalida = new RegistrarSalida();
        registrarSalida.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_RegistrarSalidaMouseClicked

    private void btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalirMouseClicked
        Ingreso myIngreso = new Ingreso();
        myIngreso.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SalirMouseClicked

    private void btn_RegistrarEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RegistrarEntradaMouseClicked
        // TODO add your handling code here:
        TipoDeRegistro pago = new TipoDeRegistro(codigoParqueadero);
        pago.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_RegistrarEntradaMouseClicked

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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleado(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RegistrarEntrada;
    private javax.swing.JButton btn_RegistrarSalida;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
