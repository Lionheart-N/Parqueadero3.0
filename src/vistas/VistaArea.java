/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import mundo.Area;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mundo.Controlador;
import mundo.Espacio;
import mundo.Parqueadero;
import util.CaException;

/**
 *
 * @author Gabriel Dubuc
 */
public class VistaArea extends javax.swing.JFrame {

    Parqueadero parqueadero;
    Controlador control = new Controlador();
    Area area = new Area();
    Espacio espacio = new Espacio();
    Random rnd = new Random();
    static int contador;    //Numero de areas que se deben registrar
    static int contadorPropio = 0;  //Contador que nos ayuda a saber cual es el area que estamos registrando
    private int espaciosAuto;
    private int espaciosMoto;
    private int espaciosBici;
    private char letraRandom;
    private int inicioRandom;
    private String random;
    private String identificadorEspacio;

    /**
     * Creates new form Area
     */
    public VistaArea(mundo.Parqueadero parqueadero, int contador) {
        this.parqueadero = parqueadero;
        this.contador = contador;
        initComponents();
        setTitle("Area");
        setResizable(false);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../img/icon.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cuposCarros = new javax.swing.JTextField();
        cuposMotos = new javax.swing.JTextField();
        cuposBicicletas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        btn_Area = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_areaID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cuposCarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuposCarrosActionPerformed(evt);
            }
        });
        getContentPane().add(cuposCarros, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 160, -1));
        getContentPane().add(cuposMotos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 160, -1));
        getContentPane().add(cuposBicicletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 160, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresa la cantidad de cupos para bicicletas");
        jLabel2.setToolTipText("");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 220, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingresa la cantidad de cupos para carros");
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 220, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ingresa la cantidad de cupos para motos");
        jLabel4.setToolTipText("");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, 30));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-P.png"))); // NOI18N
        btn_salir.setContentAreaFilled(false);
        btn_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit-G.png"))); // NOI18N
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salirMouseClicked(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        btn_Area.setText("Registrar Area");
        btn_Area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AreaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Area, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jLabel1.setText("Ingresa un ID para esta area:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 190, -1));

        txt_areaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_areaIDActionPerformed(evt);
            }
        });
        getContentPane().add(txt_areaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuposCarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuposCarrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuposCarrosActionPerformed

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        // TODO add your handling code here:
        RegistrarParqueadero registrarParqueadero = new RegistrarParqueadero();
        registrarParqueadero.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_salirMouseClicked

    private void btn_AreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AreaMouseClicked

        area.setCuposAutomoviles(Integer.parseInt(cuposCarros.getText()));  //Se asigna al objeto los valores recibidos
        area.setCuposMotos(Integer.parseInt(cuposMotos.getText()));
        area.setCuposBicicletas(Integer.parseInt(cuposBicicletas.getText()));
        area.setAutosDisponibles(Integer.parseInt(cuposCarros.getText()));
        area.setMotosDisponibles(Integer.parseInt(cuposMotos.getText()));
        area.setBicicletasDisponibles(Integer.parseInt(cuposBicicletas.getText()));
        int cuposTotales = Integer.parseInt(cuposCarros.getText()) + Integer.parseInt(cuposMotos.getText() + Integer.parseInt(cuposBicicletas.getText()));
        area.setCuposTotales(cuposTotales);
        area.setIdentificacion(txt_areaID.getText());
        area.setCodigoParqueadero(parqueadero.getIdentificador());

        espacio.setCodigoParqueadero(area.getCodigoParqueadero());
        espacio.setEstado("D");
        espacio.setAreaID(area.getIdentificacion());

        contadorPropio++;   //Se aumenta el identificador de las ventanas

        espaciosAuto = 0;
        espaciosMoto = 0;
        espaciosBici = 0;
        inicioRandom = 0;

        if (contadorPropio <= contador) { //Condicional que se cumple cuando no es la ultima area a registrar
            try {
                espaciosAuto = 0;
                espaciosMoto = 0;
                espaciosBici = 0;

                control.incluirArea(area);

                inicioRandom = 0;   //Inicializamos el numero aleatorio 
                random = "";        //Inicializamos el string que va a recibir el numero aleatorio

                letraRandom = (char) (Math.random() * (122 - 97) + 97); //Obtenemos una letra al azar del abecedario
                //En este ciclo obtenemos un string de 4 numeros aleatorios
                for (int i = 0; i < 3; i++) {
                    if (i < 3) {
                        random += rnd.nextInt(10);
                    }
                }
                inicioRandom = Integer.parseInt(random);    //Convertimos los numero aleatorio recibidos de tipo String a tipo int

                while (espaciosAuto < area.getCuposAutomoviles()) {  //Mientras el contador sea menor al numero de espacios se siguen registrando los espacios
                    identificadorEspacio = " "; //Limpiamos el identificador
                    espaciosAuto++; //Aumentamos el contador
                    inicioRandom++; //Aumentamos en 1 el valor del numero aleatorio
                    identificadorEspacio += letraRandom; //Adjuntamos al identificador la letra aleatoria
                    identificadorEspacio += inicioRandom;   //Adjuntamos al identificador el numero aleatorio con su incremento en 1
                    espacio.setIdEspacio(identificadorEspacio);
                    espacio.setTipo("Automovil");
                    control.asignarEspacios(espacio);
                    System.out.println(identificadorEspacio);
                }

                while (espaciosMoto < area.getCuposMotos()) {  //Mientras el contador sea menor al numero de espacios se siguen registrando los espacios
                    identificadorEspacio = " "; //Limpiamos el identificador
                    espaciosMoto++; //Aumentamos el contador
                    inicioRandom++; //Aumentamos en 1 el valor del numero aleatorio
                    identificadorEspacio += letraRandom; //Adjuntamos al identificador la letra aleatoria
                    identificadorEspacio += inicioRandom;   //Adjuntamos al identificador el numero aleatorio con su incremento en 1
                    espacio.setIdEspacio(identificadorEspacio);
                    espacio.setTipo("Motocicletas");
                    control.asignarEspacios(espacio);
                    System.out.println(identificadorEspacio);
                }

                while (espaciosBici < area.getCuposBicicletas()) {  //Mientras el contador sea menor al numero de espacios se siguen registrando los espacios
                    identificadorEspacio = " "; //Limpiamos el identificador
                    espaciosBici++; //Aumentamos el contador
                    inicioRandom++; //Aumentamos en 1 el valor del numero aleatorio
                    identificadorEspacio += letraRandom; //Adjuntamos al identificador la letra aleatoria
                    identificadorEspacio += inicioRandom;   //Adjuntamos al identificador el numero aleatorio con su incremento en 1
                    espacio.setIdEspacio(identificadorEspacio);
                    espacio.setTipo("Bicicletas");
                    control.asignarEspacios(espacio);
                    System.out.println(identificadorEspacio);
                }

            } catch (CaException ex) {
                Logger.getLogger(VistaArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();

        }
        if (contadorPropio == contador + 1) {   //Condicional que se cumple cuando es la ultima area a registrar
            try {
                espaciosAuto = 0;
                espaciosMoto = 0;
                espaciosBici = 0;

                control.incluirArea(area);

                inicioRandom = 0;   //Inicializamos el numero aleatorio 
                random = "";        //Inicializamos el string que va a recibir el numero aleatorio

                letraRandom = (char) (Math.random() * (122 - 97) + 97); //Obtenemos una letra al azar del abecedario
                //En este ciclo obtenemos un string de 4 numeros aleatorios
                for (int i = 0; i < 3; i++) {
                    if (i < 3) {
                        random += rnd.nextInt(10);
                    }
                }
                inicioRandom = Integer.parseInt(random);    //Convertimos los numero aleatorio recibidos de tipo String a tipo int

                while (espaciosAuto < area.getCuposAutomoviles()) {  //Mientras el contador sea menor al numero de espacios se siguen registrando los espacios
                    identificadorEspacio = " "; //Limpiamos el identificador
                    espaciosAuto++; //Aumentamos el contador
                    inicioRandom++; //Aumentamos en 1 el valor del numero aleatorio
                    identificadorEspacio += letraRandom; //Adjuntamos al identificador la letra aleatoria
                    identificadorEspacio += inicioRandom;   //Adjuntamos al identificador el numero aleatorio con su incremento en 1
                    espacio.setIdEspacio(identificadorEspacio);
                    espacio.setTipo("Automovil");
                    control.asignarEspacios(espacio);
                    System.out.println(identificadorEspacio);
                }

                while (espaciosMoto < area.getCuposMotos()) {  //Mientras el contador sea menor al numero de espacios se siguen registrando los espacios
                    identificadorEspacio = " "; //Limpiamos el identificador
                    espaciosMoto++; //Aumentamos el contador
                    inicioRandom++; //Aumentamos en 1 el valor del numero aleatorio
                    identificadorEspacio += letraRandom; //Adjuntamos al identificador la letra aleatoria
                    identificadorEspacio += inicioRandom;   //Adjuntamos al identificador el numero aleatorio con su incremento en 1
                    espacio.setIdEspacio(identificadorEspacio);
                    espacio.setTipo("Motocicletas");
                    control.asignarEspacios(espacio);
                    System.out.println(identificadorEspacio);
                }

                while (espaciosBici < area.getCuposBicicletas()) {  //Mientras el contador sea menor al numero de espacios se siguen registrando los espacios
                    identificadorEspacio = " "; //Limpiamos el identificador
                    espaciosBici++; //Aumentamos el contador
                    inicioRandom++; //Aumentamos en 1 el valor del numero aleatorio
                    identificadorEspacio += letraRandom; //Adjuntamos al identificador la letra aleatoria
                    identificadorEspacio += inicioRandom;   //Adjuntamos al identificador el numero aleatorio con su incremento en 1
                    espacio.setIdEspacio(identificadorEspacio);
                    espacio.setTipo("Bicicletas");
                    control.asignarEspacios(espacio);
                    System.out.println(identificadorEspacio);
                }

            } catch (CaException ex) {
                Logger.getLogger(VistaArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Parqueadero y areas registradas con exito", "Parqueadero", 1);
            Administrador administrador = new Administrador();
            administrador.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_btn_AreaMouseClicked

    private void txt_areaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_areaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_areaIDActionPerformed

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
            java.util.logging.Logger.getLogger(Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaArea(null, contador).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Area;
    private javax.swing.JButton btn_salir;
    private javax.swing.JTextField cuposBicicletas;
    private javax.swing.JTextField cuposCarros;
    private javax.swing.JTextField cuposMotos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_areaID;
    // End of variables declaration//GEN-END:variables
}
