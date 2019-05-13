/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.ui.formularios;

import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import proyectofinal.objetos.Jugador;
import proyectofinal.objetos.Vehiculo;

/**
 *
 * @author James
 */
public class DialogSeleccionarVehiculo extends javax.swing.JDialog {
    private Jugador jugador;
    private ObservableList<Vehiculo> observableListVehiculo;
    private Vehiculo vehiculoSeleccionado;
    private FrameBatalla frameBatalla;
    /**
     * Creates new form DialogSeleccionarVehiculo
     */
    public DialogSeleccionarVehiculo(java.awt.Frame parent, boolean modal, Jugador jugador, FrameBatalla frameBatalla) {
        super(parent, modal);
        this.frameBatalla = frameBatalla;
        this.jugador = jugador;
        this.observableListVehiculo = ObservableCollections.observableList(this.jugador.getVehiculosEnBatallas());
        initComponents();
        txtJugador.setText(jugador.getNombreJugador());
        botonSeleccionar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lblVehiculos = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        txtJugador = new javax.swing.JTextField();
        lblVehiculoSeleccionado = new javax.swing.JLabel();
        txtVehiculoSeleccionado = new javax.swing.JTextField();
        botonSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonActualizarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblVehiculos.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblVehiculos.setText("Vehiculos:");

        lblJugador.setText("Jugador:");

        txtJugador.setEditable(false);

        lblVehiculoSeleccionado.setText("Seleccionado:");

        txtVehiculoSeleccionado.setEditable(false);

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${observableListVehiculo}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreVehiculo}"));
        columnBinding.setColumnName("Nombre Vehiculo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hp}"));
        columnBinding.setColumnName("Hp");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nivel}"));
        columnBinding.setColumnName("Nivel");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pp}"));
        columnBinding.setColumnName("Pp");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${punteria}"));
        columnBinding.setColumnName("Punteria");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${vehiculoSeleccionado}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        botonActualizarTabla.setText("Actualizar Tabla");
        botonActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVehiculoSeleccionado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVehiculoSeleccionado)))
                        .addGap(18, 18, 18)
                        .addComponent(botonSeleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonActualizarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVehiculos)
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador)
                    .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVehiculoSeleccionado)
                    .addComponent(txtVehiculoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSeleccionar)
                    .addComponent(botonActualizarTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        // TODO add your handling code here:
        if (vehiculoSeleccionado.getHp() > 0) {
            frameBatalla.setVehiculo(vehiculoSeleccionado);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Lo siento no puedes seleccionar este vehiculo...");
        }
        
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void botonActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarTablaActionPerformed
        // TODO add your handling code here:
        actualizarTabla(jugador.getVehiculosEnBatallas());
    }//GEN-LAST:event_botonActualizarTablaActionPerformed

    private void actualizarTabla(List<Vehiculo> listadoVehiculos) {
        observableListVehiculo.clear();
        observableListVehiculo.addAll(listadoVehiculos);
    }
    
    public ObservableList<Vehiculo> getObservableListVehiculo() {
        return observableListVehiculo;
    }

    public void setObservableListVehiculo(ObservableList<Vehiculo> observableListVehiculo) {
        this.observableListVehiculo = observableListVehiculo;
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        Vehiculo previous = this.vehiculoSeleccionado;
        if(vehiculoSeleccionado != null){
            this.vehiculoSeleccionado = vehiculoSeleccionado;
            txtVehiculoSeleccionado.setText(this.vehiculoSeleccionado.getNombreVehiculo());
            botonSeleccionar.setEnabled(true);
        }
        firePropertyChange("Vehiculo Seleccionado", previous, this.vehiculoSeleccionado);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarTabla;
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblVehiculoSeleccionado;
    private javax.swing.JLabel lblVehiculos;
    private javax.swing.JTextField txtJugador;
    private javax.swing.JTextField txtVehiculoSeleccionado;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
