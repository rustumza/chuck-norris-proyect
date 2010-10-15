/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTODenuncia;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaConsultarAvanceReclamo;
import InterfacesGraficas.ModelosTablas.ModeloTablaFallas;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author LEIVA
 */
public class ControladorConsultarAvanceDeReclamo implements Controlador{

    //Mensajes de error
    public static final int COD_CASO_VACIO = 1;
    public static final int BUSQUEDA_VACIA = 2;
    //
    ExpertoConsultarAvanceDeReclamo experto;
    PantallaConsultarAvanceDeReclamo pantalla;
    ModeloTablaConsultarAvanceReclamo modeloEstados;
    ModeloTablaOrdenesTrabajo modeloOrdenes;
    ModeloTablaFallas modeloFallas;
    ChuckNorrisControlador chuck;

    public ControladorConsultarAvanceDeReclamo(){
        
    }

    public ControladorConsultarAvanceDeReclamo(ChuckNorrisControlador chuckCont) {
        chuck=chuckCont;
        experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
        pantalla = new PantallaConsultarAvanceDeReclamo(this);
        modeloEstados = new ModeloTablaConsultarAvanceReclamo();
        modeloOrdenes = new ModeloTablaOrdenesTrabajo();
        modeloFallas = new ModeloTablaFallas();
        pantalla.getTablaConsultarAvanceReclamo().setModel(modeloEstados);
        pantalla.getTblOrdenReparacion().setModel(modeloOrdenes);
        pantalla.getTblFallas().setModel(modeloFallas);
    }

    public void iniciar() {
        pantalla.setTitle("Consultar Avance de Reclamo");
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

    public void ConsultarEstadoCaso(String numcaso, int seleccion) {

        experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");

        modeloEstados.clear();
        modeloOrdenes.clear();
        modeloFallas.clear();
        try {
            DTODenuncia dtoDenuncia = experto.ConsultarEstadoCaso(numcaso, seleccion);
            modeloEstados.addAllRow(dtoDenuncia.getListaEstados());
            modeloOrdenes.addRow(dtoDenuncia.getOrdenRep());
            pantalla.getTablaConsultarAvanceReclamo().setModel(modeloEstados);
            pantalla.getLblEstadoOrden().setText(dtoDenuncia.getOrdenRep().getEstado());
            pantalla.getLblEstadoOrden().setVisible(true);
            pantalla.getLblEstadoOrden().setForeground(Color.ORANGE);
            modeloFallas.addAllRow(dtoDenuncia.getListaFallas());
            pantalla.getLbloperador().setText(pantalla.getLbloperador().getText() + dtoDenuncia.getNombreOperador());
        } catch (ExcepcionCampoInvalido ex) {
            mostrarMensaje(COD_CASO_VACIO, ex.getMessage());
        } catch (ExcepcionObjetoNoEncontrado ex) {
            mostrarMensaje(BUSQUEDA_VACIA, ex.getMessage());
        }


    }

    public void mostrarMensaje(int seleccion, String mensaje) {

        switch (seleccion) {
            case COD_CASO_VACIO:
                JOptionPane.showMessageDialog(pantalla, "Debe ingresar Código Caso", "ATENCIÓN!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(mensaje);
            case BUSQUEDA_VACIA:
                JOptionPane.showMessageDialog(pantalla, mensaje, "ATENCIÓN!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(mensaje);
        }
    }

    public void cerrar(){
        pantalla.setVisible(false);
        pantalla.dispose();
        chuck.iniciar();
    }
    

}
