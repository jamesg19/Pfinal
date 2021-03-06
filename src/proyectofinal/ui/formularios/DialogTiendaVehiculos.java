/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.ui.formularios;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import proyectofinal.CrearArchivos;
import proyectofinal.objetos.Jugador;
import proyectofinal.objetos.Vehiculo;

/**
 *
 * @author James
 */
public class DialogTiendaVehiculos extends javax.swing.JDialog {
    private Jugador jugador;
    private Vehiculo vehiculoSeleccionado;
    private CrearArchivos<Vehiculo> archivoVehiculos;
    private ObservableList<Vehiculo> observableListaVehiculosArchivos;

    /**
     * Creates new form DialogTiendaVehiculos
     */
    public DialogTiendaVehiculos(java.awt.Frame parent, boolean modal, Jugador jugador, CrearArchivos<Vehiculo> archivoVehiculos) {
        super(parent, modal);
        this.jugador = jugador;
        this.archivoVehiculos = archivoVehiculos;
        this.observableListaVehiculosArchivos = ObservableCollections.observableList(archivoVehiculos.leerListaDeArchivos(".ve"));
        this.setLocationRelativeTo(null);
        initComponents();
        this.botonGenerarCompra.setEnabled(false);
        actualizarOroDisponible();
    }
    
    private void actualizarOroDisponible() {
        txtJugador.setText(jugador.getNombreJugador());
        txtOro.setText(Integer.toString(jugador.getOro()));
    }
    
    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        Vehiculo previous = this.vehiculoSeleccionado;
        if(vehiculoSeleccionado != null){
            try {
                this.vehiculoSeleccionado = (Vehiculo) vehiculoSeleccionado.clone();
                txtVehiculoSeleccionado.setText(this.vehiculoSeleccionado.getNombreVehiculo());
                txtTotal.setText("150");
                botonGenerarCompra.setEnabled(true);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(DialogCargarJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        firePropertyChange("Vehiculo Seleccionado", previous, this.vehiculoSeleccionado);
    }

    public ObservableList<Vehiculo> getObservableListaVehiculosArchivos() {
        return observableListaVehiculosArchivos;
    }

    public void setObservableListaVehiculosArchivos(ObservableList<Vehiculo> observableListaVehiculosArchivos) {
        this.observableListaVehiculosArchivos = observableListaVehiculosArchivos;
    }

    private void actualizarListadoVehiculosBoots(List<Vehiculo> listaVehiculos){
        this.observableListaVehiculosArchivos.clear();
        this.observableListaVehiculosArchivos.addAll(listaVehiculos);
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

        jTextField1 = new javax.swing.JTextField();
        lblVehiculosBoot = new javax.swing.JLabel();
        botonAgregarListado = new javax.swing.JButton();
        lblJugador = new javax.swing.JLabel();
        txtJugador = new javax.swing.JTextField();
        lblOro = new javax.swing.JLabel();
        txtOro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculosBoots = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        botonGenerarCompra = new javax.swing.JButton();
        lblVehiculoSeleccionado = new javax.swing.JLabel();
        txtVehiculoSeleccionado = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblVehiculosBoot.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblVehiculosBoot.setText("Vehiculos Boots:");

        botonAgregarListado.setText("Agregar Listado");
        botonAgregarListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarListadoActionPerformed(evt);
            }
        });

        lblJugador.setText("Jugador:");

        txtJugador.setEditable(false);

        lblOro.setText("Oro:");

        txtOro.setEditable(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${observableListaVehiculosArchivos}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaVehiculosBoots);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreVehiculo}"));
        columnBinding.setColumnName("Nombre Vehiculo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hp}"));
        columnBinding.setColumnName("Hp");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${armas}"));
        columnBinding.setColumnName("Armas");
        columnBinding.setColumnClass(java.util.List.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${vehiculoSeleccionado}"), tablaVehiculosBoots, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tablaVehiculosBoots);
        if (tablaVehiculosBoots.getColumnModel().getColumnCount() > 0) {
            tablaVehiculosBoots.getColumnModel().getColumn(0).setResizable(false);
            tablaVehiculosBoots.getColumnModel().getColumn(1).setResizable(false);
            tablaVehiculosBoots.getColumnModel().getColumn(2).setResizable(false);
        }

        lblTotal.setText("Total:");

        txtTotal.setEditable(false);

        botonGenerarCompra.setText("Generar Compra");
        botonGenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarCompraActionPerformed(evt);
            }
        });

        lblVehiculoSeleccionado.setText("Vehiculo:");

        txtVehiculoSeleccionado.setEditable(false);

        lblCosto.setText("Costo:            150");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblVehiculoSeleccionado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtVehiculoSeleccionado))
                                    .addComponent(lblVehiculosBoot, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAgregarListado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblJugador)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtJugador)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblOro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 37, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTotal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGenerarCompra))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVehiculosBoot)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador)
                    .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOro)
                    .addComponent(txtOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVehiculoSeleccionado)
                    .addComponent(txtVehiculoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCosto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAgregarListado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGenerarCompra)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarListadoActionPerformed
        // TODO add your handling code here:
        actualizarListadoVehiculosBoots(archivoVehiculos.leerListaDeArchivos(".ve"));
    }//GEN-LAST:event_botonAgregarListadoActionPerformed

    private void botonGenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarCompraActionPerformed
        // TODO add your handling code here:
        if (jugador.getOro() < 150) {
            JOptionPane.showMessageDialog(this, "Lo siento tu compra no se realizo, debido a que no posees oro suficiente. \nSigue Luchando.");
        } else {
            try {//aquie solo se comprarn boots para comprar al listado solo se le agrega un boton y se comprueba el estado
                vehiculoSeleccionado.setTurnos(3);
                vehiculoSeleccionado.setBoot(true);
                jugador.agregarVehiculosBoots((Vehiculo) vehiculoSeleccionado.clone());
                jugador.setOro(jugador.getOro() - 150);
                JOptionPane.showMessageDialog(this, "Felicidades se realizo tu compra.");
                actualizarOroDisponible();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(DialogTiendaVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonGenerarCompraActionPerformed

    private void actualizarLbl() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarListado;
    private javax.swing.JButton botonGenerarCompra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblOro;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVehiculoSeleccionado;
    private javax.swing.JLabel lblVehiculosBoot;
    private javax.swing.JTable tablaVehiculosBoots;
    private javax.swing.JTextField txtJugador;
    private javax.swing.JTextField txtOro;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVehiculoSeleccionado;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
