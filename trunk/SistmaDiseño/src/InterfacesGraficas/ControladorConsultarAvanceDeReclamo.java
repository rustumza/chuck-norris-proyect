/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTOCaso;
import DTO.DTOInformeReparacion;
import DTO.DTOOrden;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaConsultarAvanceReclamo;
import InterfacesGraficas.ModelosTablas.ModeloTablaFallas;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import Persistencia.Entidades.Operador;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author LEIVA
 */
public class ControladorConsultarAvanceDeReclamo implements Controlador {

    //Mensajes de error
    public static final int COD_CASO_VACIO = 1;
    public static final int BUSQUEDA_VACIA = 2;
    //
    ExpertoConsultarAvanceDeReclamo experto;
    private PantallaConsultarAvanceDeReclamo pantalla;
    private PantallaDetalleOrden pantallaDetalleOrden;
    ModeloTablaConsultarAvanceReclamo modeloEstados;
    ModeloTablaOrdenesTrabajo modeloOrdenes;
    ModeloTablaFallas modeloFallas;
    private ChuckNorrisControlador chuck;
    

    public ControladorConsultarAvanceDeReclamo() {
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
        chuck = chuckCont;
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

        limpiarPantalla();

        experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");

        modeloEstados.clear();
        modeloOrdenes.clear();
        modeloFallas.clear();
        try {
            DTOCaso dtoDenuncia = experto.ConsultarEstadoCaso(numcaso, seleccion, chuck.getOperadorEncontrado());
            modeloEstados.addAllRow(dtoDenuncia.getListaEstados());
            modeloOrdenes.addAllRow(dtoDenuncia.getOrdenesRep());
            pantalla.getTablaConsultarAvanceReclamo().setModel(modeloEstados);
            modeloFallas.addAllRow(dtoDenuncia.getListaFallas());
           pantalla.getLblCantReclamos().setText(pantalla.getLblCantReclamos().getText()+" "+dtoDenuncia.getCantidadReclamos()+".");
        } catch (ExcepcionCampoInvalido ex) {
            mostrarMensaje(COD_CASO_VACIO, ex.getMessage());
        } catch (ExcepcionObjetoNoEncontrado ex) {
            mostrarMensaje(BUSQUEDA_VACIA, ex.getMessage());
            pantalla.getTxtNumeroCaso().setText("");
        }


    }

    public void mostrarMensaje(int seleccion, String mensaje) {

        switch (seleccion) {
            case COD_CASO_VACIO:
                JOptionPane.showMessageDialog(getPantalla(), mensaje, "ATENCIÓN!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(mensaje);
                break;
            case BUSQUEDA_VACIA:
                JOptionPane.showMessageDialog(getPantalla(), mensaje, "ATENCIÓN!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(mensaje);
                break;
        }
    }

    public void mostrarDetalleOrden(DTOInformeReparacion informe) {
        pantallaDetalleOrden = new PantallaDetalleOrden(this);
        pantallaDetalleOrden.setTitle("Detalle Orden Reparación");
        pantallaDetalleOrden.setLocationRelativeTo(null);
        pantallaDetalleOrden.setVisible(true);
        pantallaDetalleOrden.setInformeReparacion(informe);
    }

    public void cerrar() {
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

    public void habilitarBotonDetalleOrden(DTOOrden dtoOrdenRep) {
        boolean habilitar = false;

        if (dtoOrdenRep != null) {
            habilitar = experto.habilitarBotonDetalleOrden(dtoOrdenRep);
        }
        if (habilitar) {
            pantalla.getBtnDetalleOrden().setVisible(true);
        } else {
            pantalla.getBtnDetalleOrden().setVisible(false);
        }
    }

    public void limpiarPantalla() {
        modeloEstados.clear();
        modeloOrdenes.clear();
        modeloFallas.clear();
        pantalla.getLblCantReclamos().setText("Cantidad de Reclamos Caso:");
        habilitarBotonDetalleOrden(null);
    }

    public void cerrarPantallaDetalle(){
        pantallaDetalleOrden = null;
    }

    /**
     * @return the operadorEncontrado
     */
    public Operador getOperadorEncontrado() {
        return chuck.getOperadorEncontrado();
    }

    
}
