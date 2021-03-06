/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.ui.formularios;

import proyectofinal.objetos.Jugador;
import proyectofinal.objetos.Vehiculo;
import proyectofinal.objetos.Escenario;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import proyectofinal.CrearArchivos;

/**
 *
 * @author James
 */
public class DialogoPedirEscenario extends javax.swing.JDialog {
    private JLabel matrizLbl[][];
    private FrameBatalla frameBatalla;
    private JDesktopPane panelDeEscritorio;
    private Jugador jugador;
    private Escenario escenario;
    private CrearArchivos<Escenario> archivoEscenario;
    private CrearArchivos<Vehiculo> archivoVehiculo;
    private int cont = 1;
    private boolean esMultijugador;
    private DialogSeleccionarVehiculo dialogSeleccionarVehiculo;
    private DialogModificarEscenario dialogModificarEscenario;
    private java.awt.Frame parent;
    
    /**
     * Creates new form DialogPedirEscenario
     */
   public DialogoPedirEscenario(java.awt.Frame parent, boolean modal, CrearArchivos<Escenario> archivoEscenario, JDesktopPane panelDeEscritorio, Jugador jugador) {
        super(parent, modal);
        this.jugador= jugador;
        this.parent = parent;
        this.panelDeEscritorio = panelDeEscritorio;
        this.archivoEscenario = archivoEscenario;
        initComponents();
        desactivarYActivarBotones(false);
    }

    public void desactivarYActivarBotones(boolean estado) {
        botonAnterior.setEnabled(estado);
        botonSiguiente.setEnabled(estado);
        botonSeleccionar.setEnabled(estado);
        botonBoot.setEnabled(estado);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonCPU = new javax.swing.JButton();
        botonVS = new javax.swing.JButton();
        lblNombreDelEsceanrio = new javax.swing.JLabel();
        lblSelecciona = new javax.swing.JLabel();
        txtEscenarioSeleccionado = new javax.swing.JTextField();
        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonSeleccionar = new javax.swing.JButton();
        botonBoot = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelEscenarios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        botonCPU.setText("Contra CPU");
        botonCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCPUActionPerformed(evt);
            }
        });

        botonVS.setText("Multijugador");
        botonVS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVSActionPerformed(evt);
            }
        });

        lblNombreDelEsceanrio.setText("Nombre:");

        lblSelecciona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelecciona.setText("Selecciona un Escenario:");

        txtEscenarioSeleccionado.setEditable(false);

        botonAnterior.setText("Anterior");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        botonBoot.setText("Agregar Boot´s");
        botonBoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBootActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEscenariosLayout = new javax.swing.GroupLayout(panelEscenarios);
        panelEscenarios.setLayout(panelEscenariosLayout);
        panelEscenariosLayout.setHorizontalGroup(
            panelEscenariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );
        panelEscenariosLayout.setVerticalGroup(
            panelEscenariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelEscenarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSeleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBoot)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelecciona)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblNombreDelEsceanrio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEscenarioSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonCPU)
                                .addGap(2, 2, 2))
                            .addComponent(botonVS))
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCPU)
                    .addComponent(lblSelecciona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVS)
                    .addComponent(lblNombreDelEsceanrio)
                    .addComponent(txtEscenarioSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAnterior)
                    .addComponent(botonSiguiente)
                    .addComponent(botonSeleccionar)
                    .addComponent(botonBoot))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCPUActionPerformed
        // TODO add your handling code here:
        limpiarPanel();
        desactivarYActivarBotones(true);
        esMultijugador = false;
        identificarEcenarios();
    }//GEN-LAST:event_botonCPUActionPerformed

    private void identificarEcenarios() {
        if (esMultijugador == false) {
            agregarEscenario("Escenario", ".es");
        } else {
            agregarEscenario("EscenarioMultijugador", ".esm");
        }
    }
    
    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        // TODO add your handling code here:
        limpiarPanel();
        if (cont >= 3) {
            cont = 1;
        } else {
            cont++;
        }
        identificarEcenarios();
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        // TODO add your handling code here:
        limpiarPanel();
        if (cont  == 1) {
            cont = 3;
        } else {
            cont--;
        }
        identificarEcenarios();
    }//GEN-LAST:event_botonAnteriorActionPerformed

    private void botonVSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVSActionPerformed
        // TODO add your handling code here:
        limpiarPanel();
        desactivarYActivarBotones(true);
        esMultijugador = true;
        identificarEcenarios();
    }//GEN-LAST:event_botonVSActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        // TODO add your handling code here:
        archivoVehiculo  = new CrearArchivos<>();
        frameBatalla  = new FrameBatalla(escenario, jugador/*, archivoVehiculo.leerArchivo("Avion", "30", ".ve")*/, parent);
        frameBatalla.setVisible(true);
        dialogSeleccionarVehiculo = new DialogSeleccionarVehiculo(parent, true, jugador, frameBatalla);
        dialogSeleccionarVehiculo.setVisible(true);
        panelDeEscritorio.add(frameBatalla);
        this.setVisible(false);
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void botonBootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBootActionPerformed
        // TODO add your handling code here:
        this.dialogModificarEscenario = new DialogModificarEscenario(parent, true, escenario);
        this.setVisible(false);
        dialogModificarEscenario.setVisible(true);
    }//GEN-LAST:event_botonBootActionPerformed

    public void agregarEscenario(String pathInicial, String pathFinal) {
        escenario = archivoEscenario.leerArchivo(pathInicial, "E_" + cont, pathFinal);
        txtEscenarioSeleccionado.setText(escenario.getNombreEscenario());
        matrizLbl  = new JLabel[escenario.getValorM()][escenario.getValorN()];
        for (int i = 0; i < escenario.getValorM(); i++) {
            for (int j = 0; j < escenario.getValorN(); j++) {
                matrizLbl[i][j] = new JLabel();
                matrizLbl[i][j].setSize(118, 57);
                matrizLbl[i][j].setLocation(40+(i*125), 35+(j*65));
                escenario.asignarColorImprimir(i, j, 1, matrizLbl, escenario.getTerrenos());
                matrizLbl[i][j].setVisible(true);
                panelEscenarios.add(matrizLbl[i][j]);
            }
        }
        this.setSize(85 + escenario.getValorM()*125,  200 + (35+(escenario.getValorN()*60)));
    }
    
    public void limpiarPanel() {
        try {
            for (int i = 0; i < escenario.getValorM(); i++) {
            for (int j = 0; j < escenario.getValorN(); j++) {
                matrizLbl[i][j].setIcon(null);
                matrizLbl[i][j] = null;
            }
        }
        } catch (Exception e) {
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonBoot;
    private javax.swing.JButton botonCPU;
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonVS;
    private javax.swing.JLabel lblNombreDelEsceanrio;
    private javax.swing.JLabel lblSelecciona;
    private javax.swing.JPanel panelEscenarios;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtEscenarioSeleccionado;
    // End of variables declaration//GEN-END:variables
}
