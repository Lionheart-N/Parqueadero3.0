/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mundo.Controlador;
import mundo.Empleado;
import util.CaException;
/**
 *
 * @author Gabriel Dubuc
 */
public class IncluirEmpleado extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();
    private Empleado miEmpleado = new Empleado();
    /**
     * Creates new form IncluirEmpleado
     */
    public IncluirEmpleado() {
        initComponents();
        setTitle("Registrar empleado");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codParqueadero = new javax.swing.JTextField();
        txt_Usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JTextField();
        box_cargo = new javax.swing.JComboBox<>();
        btn_registrar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel3.setText("Cargo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel4.setText("Codigo parqueadero");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        txt_codParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codParqueaderoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_codParqueadero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 230, -1));

        txt_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 230, -1));

        txt_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 230, -1));

        box_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Administrador" }));
        getContentPane().add(box_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 230, -1));

        btn_registrar.setText("Registrar");
        btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registrarMouseClicked(evt);
            }
        });
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-P.png"))); // NOI18N
        btn_salir.setContentAreaFilled(false);
        btn_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-G.png"))); // NOI18N
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salirMouseClicked(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 70, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsuarioActionPerformed

    private void txt_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contraseñaActionPerformed

    private void txt_codParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codParqueaderoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codParqueaderoActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void btn_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseClicked
        // TODO add your handling code here:
        if(txt_Usuario.getText().equals("") || txt_codParqueadero.getText().equals("") || txt_contraseña.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
        }else{
            
            miEmpleado.setCodParqueadero(txt_codParqueadero.getText());
            miEmpleado.setUsuario(txt_Usuario.getText());
            miEmpleado.setContraseña(txt_contraseña.getText());
            if(box_cargo.getSelectedItem().equals("Empleado")){
                miEmpleado.setCargo("E");
            }else{
                miEmpleado.setCargo("A");
            }
            try {
                controlador.incluirEmpleado(miEmpleado);
                JOptionPane.showMessageDialog(null, "El empleado se registro correctamente");
            } catch (CaException ex) {
                Logger.getLogger(IncluirEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            Administrador admi = new Administrador();
            admi.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_registrarMouseClicked

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        // TODO add your handling code here:
        Administrador admi = new Administrador();
        admi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_salirMouseClicked

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
            java.util.logging.Logger.getLogger(IncluirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncluirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncluirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncluirEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncluirEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_cargo;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_Usuario;
    private javax.swing.JTextField txt_codParqueadero;
    private javax.swing.JTextField txt_contraseña;
    // End of variables declaration//GEN-END:variables
}
