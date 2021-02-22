/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mundo.Controlador;
import mundo.Estadistica;

/**
 *
 * @author WIN10
 */
public class Estadisticas extends javax.swing.JFrame {

    private Estadistica estadistica;
    private Controlador controlador;
    public static String fecha;
    public static String fechaFinal;
    public Estadisticas() {
        initComponents();
        setTitle("Estadisticas");
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

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jLabel1 = new javax.swing.JLabel();
        boxPeriodo = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        boxTipoVehiculo = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_generar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione un parqueadero");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 30));

        boxPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPeriodoActionPerformed(evt);
            }
        });
        getContentPane().add(boxPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, -1));

        jLabel2.setText("Tipo de vehiculo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        boxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(boxTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, -1));

        jLabel3.setText("  Fecha inicial");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 72, -1));

        jLabel4.setText("   Fecha final");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 72, -1));

        btn_generar.setText("Generar");
        btn_generar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_generarMouseClicked(evt);
            }
        });
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-P.png"))); // NOI18N
        btn_Salir.setContentAreaFilled(false);
        btn_Salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-G.png"))); // NOI18N
        btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalirMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 331, 60, 50));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 140, -1));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxPeriodoActionPerformed

    private void boxTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxTipoVehiculoActionPerformed

    private void btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalirMouseClicked
        Administrador miAdministrador = new Administrador();
        miAdministrador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SalirMouseClicked

    private void btn_generarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarMouseClicked
        // TODO add your handling code here:
        
        
        controlador = new Controlador();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        fecha = sdf.format(jDateChooser1.getDate()) ;
        fechaFinal = sdf.format(jDateChooser2.getDate());
        if(jDateChooser1.getDate() == null || jDateChooser1.getDate()== null)
        {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
        }else{ 
            Resultados resultados = new Resultados();
            resultados.setVisible(true);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btn_generarMouseClicked

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_generarActionPerformed

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
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estadisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxPeriodo;
    private javax.swing.JComboBox<String> boxTipoVehiculo;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_generar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
