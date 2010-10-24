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
    private PantallaConsultarAvanceDeReclamo pantalla;
    ModeloTablaConsultarAvanceReclamo modeloEstados;
    ModeloTablaOrdenesTrabajo modeloOrdenes;
    ModeloTablaFallas modeloFallas;
    private ChuckNorrisControlador chuck;

    public ControladorConsultarAvanceDeReclamo(){
        experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
        pantalla = new PantallaConsultarAvanceDeReclamo(this);
        modeloEstados = new ModeloTablaConsultarAvanceReclamo();
        modeloOrdenes = new ModeloTablaOrdenesTrabajo();
        modeloFallas = new ModeloTablaFallas();
        pantalla.getTablaConsultarAvanceReclamo().setModel(modeloEstados);
        pantalla.getTblOrdenReparacion().setModel(modeloOrdenes);
        pantalla.getTblFallas().setModel(modeloFallas);

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
        getPantalla().setTitle("Consultar Avance de Reclamo");
        getPantalla().setLocationRelativeTo(null);
        getPantalla().setVisible(true);
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
            getPantalla().getTablaConsultarAvanceReclamo().setModel(modeloEstados);
            getPantalla().getLblEstadoOrden().setText(dtoDenuncia.getOrdenRep().getEstado());
            getPantalla().getLblEstadoOrden().setVisible(true);
            getPantalla().getLblEstadoOrden().setForeground(Color.ORANGE);
            modeloFallas.addAllRow(dtoDenuncia.getListaFallas());
            getPantalla().getLbloperador().setText(getPantalla().getLbloperador().getText() + dtoDenuncia.getNombreOperador());
        } catch (ExcepcionCampoInvalido ex) {
            mostrarMensaje(COD_CASO_VACIO, ex.getMessage());
        } catch (ExcepcionObjetoNoEncontrado ex) {
            mostrarMensaje(BUSQUEDA_VACIA, ex.getMessage());
        }


    }

    public void mostrarMensaje(int seleccion, String mensaje) {

        switch (seleccion) {
            case COD_CASO_VACIO:
                JOptionPane.showMessageDialog(getPantalla(), "Debe ingresar Código Caso", "ATENCIÓN!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(mensaje);
            case BUSQUEDA_VACIA:
                JOptionPane.showMessageDialog(getPantalla(),mensaje, "ATENCIÓN!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(mensaje);
        }
    }

    public void cerrar(){
        getPantalla().setVisible(false);
        getPantalla().dispose();
        chuck.iniciar();
    }

    /**
     * @return the pantalla
     */
    public PantallaConsultarAvanceDeReclamo getPantalla() {
        return pantalla;
    }

    /**
     * @param chuck the chuck to set
     */
    public void setChuck(ChuckNorrisControlador chuck) {
        this.chuck = chuck;
    }
    

}
