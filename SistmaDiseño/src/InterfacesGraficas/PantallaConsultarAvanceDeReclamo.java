/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaConsultarAvanceDeReclamo.java
 *
 * Created on 16/09/2010, 18:24:28
 */

package InterfacesGraficas;

import DTO.DTOOrden;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import Utilidades.RenderTablaEjecutarOrdenes;
import Utilidades.RenderTablaEstadosCaso;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author diego
 */
public class PantallaConsultarAvanceDeReclamo extends javax.swing.JFrame {
    ControladorConsultarAvanceDeReclamo controlador;
    DTOOrden ordenSeleccionada;
    /** Creates new form PantallaConsultarAvanceDeReclamo */
    public PantallaConsultarAvanceDeReclamo() {
        initComponents();
    }
    public PantallaConsultarAvanceDeReclamo(ControladorConsultarAvanceDeReclamo control) {
       controlador = control;
       initComponents();
       btnDetalleOrden.setVisible(false);

       //setea el comportamiento de la tabla estados denuncia
       tblestadoCaso.setDefaultRenderer(Object.class, new RenderTablaEstadosCaso());


       ///////*Setea el comportamiento a la tabla Ordenes Reparacion:
        tblOrdenReparacion.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblOrdenReparacion.rowAtPoint(e.getPoint());
                ordenSeleccionada = (DTOOrden) ((ModeloTablaOrdenesTrabajo) tblOrdenReparacion.getModel()).getRow(fila);
                controlador.habilitarBotonDetalleOrden(ordenSeleccionada);
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

        groupTipoCaso = new javax.swing.ButtonGroup();
        cabecera = new javax.swing.JLabel();
        jpanelCaso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroCaso = new javax.swing.JTextField();
        botonConsultar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioBtnDenuncia = new javax.swing.JRadioButton();
        radioBtnReclamo = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblestadoCaso = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrdenReparacion = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFallas = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnDetalleOrden = new javax.swing.JButton();
        lblCantReclamos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/new-cabecera.png"))); // NOI18N
        getContentPane().add(cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("Número de Caso");

        txtNumeroCaso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCasoActionPerformed(evt);
            }
        });

        botonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/iconos/edit-find.png"))); // NOI18N
        botonConsultar.setText("Consultar");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Caso"));

        groupTipoCaso.add(radioBtnDenuncia);
        radioBtnDenuncia.setSelected(true);
        radioBtnDenuncia.setText("Denuncia");

        groupTipoCaso.add(radioBtnReclamo);
        radioBtnReclamo.setText("Reclamo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioBtnDenuncia)
                    .addComponent(radioBtnReclamo))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(radioBtnDenuncia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioBtnReclamo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanelCasoLayout = new javax.swing.GroupLayout(jpanelCaso);
        jpanelCaso.setLayout(jpanelCasoLayout);
        jpanelCasoLayout.setHorizontalGroup(
            jpanelCasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCasoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelCasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelCasoLayout.createSequentialGroup()
                        .addComponent(txtNumeroCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelCasoLayout.setVerticalGroup(
            jpanelCasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCasoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelCasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonConsultar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpanelCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, -1, -1));

        jLabel2.setText("Estado");

        tblestadoCaso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblestadoCaso);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 298, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrdenReparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblOrdenReparacion);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 44, 677, 110));

        jLabel3.setText("Orden Reparación");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        jLabel4.setText("Fallas Denuncia");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, -1, -1));

        tblFallas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblFallas);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 186, 677, 109));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/iconos/system-shutdown-panel.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 170, -1));

        btnDetalleOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/iconos/document-properties.png"))); // NOI18N
        btnDetalleOrden.setText("Ver Detalle Orden");
        btnDetalleOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleOrdenActionPerformed(evt);
            }
        });
        jPanel4.add(btnDetalleOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 172, -1));

        lblCantReclamos.setForeground(new java.awt.Color(24, 122, 185));
        lblCantReclamos.setText("Cantidad de Reclamos Caso:");
        jPanel4.add(lblCantReclamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 86, 700, 440));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 86, 14, 438));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        pressBotonConsultar();
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        controlador.cerrar();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDetalleOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleOrdenActionPerformed
        controlador.mostrarDetalleOrden(ordenSeleccionada.getInformeReparacion());
    }//GEN-LAST:event_btnDetalleOrdenActionPerformed

    private void txtNumeroCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCasoActionPerformed
        pressBotonConsultar();
    }//GEN-LAST:event_txtNumeroCasoActionPerformed

    private void pressBotonConsultar(){
        int seleccion=1;
        if (getRadioBtnDenuncia().isSelected()) {
            seleccion=1;
        }else{
            seleccion=2;
        }
        controlador.ConsultarEstadoCaso(getTxtNumeroCaso().getText(),seleccion);
    }
    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaConsultarAvanceDeReclamo().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton btnDetalleOrden;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel cabecera;
    private javax.swing.ButtonGroup groupTipoCaso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanelCaso;
    private javax.swing.JLabel lblCantReclamos;
    private javax.swing.JRadioButton radioBtnDenuncia;
    private javax.swing.JRadioButton radioBtnReclamo;
    private javax.swing.JTable tblFallas;
    private javax.swing.JTable tblOrdenReparacion;
    private javax.swing.JTable tblestadoCaso;
    private javax.swing.JTextField txtNumeroCaso;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tablaConsultarAvanceReclamo
     */
    public javax.swing.JTable getTablaConsultarAvanceReclamo() {
        return tblestadoCaso;
    }

    /**
     * @param tablaConsultarAvanceReclamo the tablaConsultarAvanceReclamo to set
     */
    public void setTablaConsultarAvanceReclamo(javax.swing.JTable tablaConsultarAvanceReclamo) {
        this.tblestadoCaso = tablaConsultarAvanceReclamo;
    }

    /**
     * @return the tblOrdenReparacion
     */
    public javax.swing.JTable getTblOrdenReparacion() {
        return tblOrdenReparacion;
    }


    /**
     * @return the tblFallas
     */
    public javax.swing.JTable getTblFallas() {
        return tblFallas;
    }

    /**
     * @return the btnDetalleOrden
     */
    public javax.swing.JButton getBtnDetalleOrden() {
        return btnDetalleOrden;
    }

    /**
     * @return the txtNumeroCaso
     */
    public javax.swing.JTextField getTxtNumeroCaso() {
        return txtNumeroCaso;
    }

    /**
     * @return the lblCantReclamos
     */
    public javax.swing.JLabel getLblCantReclamos() {
        return lblCantReclamos;
    }

    /**
     * @return the radioBtnDenuncia
     */
    public javax.swing.JRadioButton getRadioBtnDenuncia() {
        return radioBtnDenuncia;
    }

    /**
     * @param radioBtnDenuncia the radioBtnDenuncia to set
     */
    public void setRadioBtnDenuncia(javax.swing.JRadioButton radioBtnDenuncia) {
        this.radioBtnDenuncia = radioBtnDenuncia;
    }

    /**
     * @return the radioBtnReclamo
     */
    public javax.swing.JRadioButton getRadioBtnReclamo() {
        return radioBtnReclamo;
    }

    /**
     * @param radioBtnReclamo the radioBtnReclamo to set
     */
    public void setRadioBtnReclamo(javax.swing.JRadioButton radioBtnReclamo) {
        this.radioBtnReclamo = radioBtnReclamo;
    }

    /**
     * @return the botonConsultar
     */
    public javax.swing.JButton getBotonConsultar() {
        return botonConsultar;
    }

    /**
     * @param botonConsultar the botonConsultar to set
     */
    public void setBotonConsultar(javax.swing.JButton botonConsultar) {
        this.botonConsultar = botonConsultar;
    }
}
