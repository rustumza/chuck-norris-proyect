/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaConsultarOrdenesPendientes.java
 *
 * Created on 26/09/2010, 15:02:33
 */
package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import InterfacesGraficas.ModelosTablas.ModeloTablaReserva;
import InterfacesGraficas.ModelosTablas.ModeloTablaReservaEquipamiento;
import InterfacesGraficas.ModelosTablas.ModeloTablaResevaRepuesto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author diego
 */
public class PantallaConsultarOrdenesPendientes extends javax.swing.JFrame {

    public static final int ordenTrabajo = 1;
    public static final int ordenMantenimiento = 2;
    public static final int ordenReparacion = 3;
    ControladorConsultarOrdenesPendientes controlador;

    DTOOrden ordenSeleccionada;
    DTOReserva reservaSeleccionada;

    /** Creates new form PantallaConsultarOrdenesPendientes */
    public PantallaConsultarOrdenesPendientes() {
        initComponents();
    }

    public PantallaConsultarOrdenesPendientes(ControladorConsultarOrdenesPendientes nuevoControlador) {
        initComponents();
        controlador = nuevoControlador;

        ///////*Setea el comportamiento a la tabla Ordenes Pendientes:
        tblOrdenesTrabajo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblOrdenesTrabajo.rowAtPoint(e.getPoint());
                ordenSeleccionada = (DTOOrden) ((ModeloTablaOrdenesTrabajo)tblOrdenesTrabajo.getModel()).getRow(fila);
                controlador.mostrarReservas(ordenSeleccionada.getListaReservas());
            }
        });

         ///////*Setea el comportamiento a la tabla Reserva:
        tblReservas.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblOrdenesTrabajo.rowAtPoint(e.getPoint());
                reservaSeleccionada = (DTOReserva) ((ModeloTablaReserva)tblReservas.getModel()).getRow(fila);
                controlador.mostrarDetalleReserva(reservaSeleccionada);
            }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTipoOrden = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioBtnOrdenRep = new javax.swing.JRadioButton();
        lblFecha = new javax.swing.JLabel();
        radioBtnOrdenMant = new javax.swing.JRadioButton();
        radioBtnOrdenTodas = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        dataChsFecha = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenesTrabajo = new javax.swing.JTable();
        panelReserva = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEquipamientoReservado = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRepuestosReservado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Órdenes de Trabajo"));

        grupoTipoOrden.add(radioBtnOrdenRep);
        radioBtnOrdenRep.setText("Orden de Reparación");
        radioBtnOrdenRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnOrdenRepActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha");

        grupoTipoOrden.add(radioBtnOrdenMant);
        radioBtnOrdenMant.setText("Orden de Mantenimiento");

        grupoTipoOrden.add(radioBtnOrdenTodas);
        radioBtnOrdenTodas.setSelected(true);
        radioBtnOrdenTodas.setLabel("Todas");
        radioBtnOrdenTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnOrdenTodasActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataChsFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                    .addComponent(radioBtnOrdenRep)
                    .addComponent(radioBtnOrdenMant)
                    .addComponent(radioBtnOrdenTodas)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataChsFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha))
                .addGap(18, 18, 18)
                .addComponent(radioBtnOrdenRep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioBtnOrdenMant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioBtnOrdenTodas)
                .addGap(9, 9, 9)
                .addComponent(btnBuscar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Trabajo"));

        tblOrdenesTrabajo.setModel(new ModeloTablaOrdenesTrabajo());
        jScrollPane1.setViewportView(tblOrdenesTrabajo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelReserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Reserva"));

        tblEquipamientoReservado.setModel(new ModeloTablaReservaEquipamiento());
        jScrollPane2.setViewportView(tblEquipamientoReservado);

        tblRepuestosReservado.setModel(new ModeloTablaResevaRepuesto());
        jScrollPane3.setViewportView(tblRepuestosReservado);

        jLabel1.setText("Equipamiento");

        jLabel2.setText("Repuestos");

        javax.swing.GroupLayout panelReservaLayout = new javax.swing.GroupLayout(panelReserva);
        panelReserva.setLayout(panelReservaLayout);
        panelReservaLayout.setHorizontalGroup(
            panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelReservaLayout.setVerticalGroup(
            panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblReservas.setModel(new ModeloTablaReserva());
        jScrollPane4.setViewportView(tblReservas);

        jLabel3.setText("Reservas");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(panelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioBtnOrdenRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnOrdenRepActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_radioBtnOrdenRepActionPerformed

    private void radioBtnOrdenTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnOrdenTodasActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_radioBtnOrdenTodasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        int seleccion;
        if (radioBtnOrdenMant.isSelected()) {
            seleccion = ordenMantenimiento;
        } else if (radioBtnOrdenRep.isSelected()) {
            seleccion = ordenReparacion;
        } else {
            seleccion = ordenTrabajo;
        }
        controlador.buscarOrdenes(dataChsFecha.getDate(), seleccion);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PantallaConsultarOrdenesPendientes().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private com.toedter.calendar.JDateChooser dataChsFecha;
    private javax.swing.ButtonGroup grupoTipoOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JPanel panelReserva;
    private javax.swing.JRadioButton radioBtnOrdenMant;
    private javax.swing.JRadioButton radioBtnOrdenRep;
    private javax.swing.JRadioButton radioBtnOrdenTodas;
    private javax.swing.JTable tblEquipamientoReservado;
    private javax.swing.JTable tblOrdenesTrabajo;
    private javax.swing.JTable tblRepuestosReservado;
    private javax.swing.JTable tblReservas;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tblOrdenesTrabajo
     */
    public javax.swing.JTable getTblOrdenesTrabajo() {
        return tblOrdenesTrabajo;
    }

    /**
     * @return the tblEquipamientoReservado
     */
    public javax.swing.JTable getTblEquipamientoReservado() {
        return tblEquipamientoReservado;
    }

    /**
     * @return the tblReservas
     */
    public javax.swing.JTable getTblReservas() {
        return tblReservas;
    }

    /**
     * @return the tblRepuestosReservado
     */
    public javax.swing.JTable getTblRepuestosReservado() {
        return tblRepuestosReservado;
    }
}
