/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import Excepciones.ExcepcionCampoInvalido;
import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import InterfacesGraficas.ModelosTablas.ModeloTablaReserva;
import InterfacesGraficas.ModelosTablas.ModeloTablaReservaEquipamiento;
import InterfacesGraficas.ModelosTablas.ModeloTablaResevaRepuesto;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class ControladorEjecutarOrdenesTrabajo implements Controlador{

    ExpertoEjecutarOrdenesTrabajo experto;
    private PantallaEjecutarOrdenDeTrabajo pantalla;
    private ChuckNorrisControlador chuck;

    public ControladorEjecutarOrdenesTrabajo(){
        
        experto = (ExpertoEjecutarOrdenesTrabajo) FabricaExpertos.getInstance().getExperto("EjecutarOrdenesTrabajo");
        pantalla = new PantallaEjecutarOrdenDeTrabajo(this);

    }

    public ControladorEjecutarOrdenesTrabajo(ChuckNorrisControlador chuckCont) {
        chuck = chuckCont;
        experto = (ExpertoEjecutarOrdenesTrabajo) FabricaExpertos.getInstance().getExperto("EjecutarOrdenesTrabajo");
        pantalla = new PantallaEjecutarOrdenDeTrabajo(this);
    }

    public void iniciar() {
        getPantalla().setLocationRelativeTo(null);
        getPantalla().setVisible(true);
    }

// public void confirmarOrden(OrdenTrabajo listaOrdenTrabajo){
//        experto.guardarOrdenTrabajo((List<OrdenTrabajo>) listaOrdenTrabajo);
//     }
    public void buscarOrdenesPendientes(Date fecha, int seleccion) {

        List<DTOOrden> listaDTOOrdens;
        try {
            listaDTOOrdens = experto.consultarOrdenesPendientes(fecha, seleccion);
            ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
            nuevoModelo.addAllRow(listaDTOOrdens);
            ((ModeloTablaOrdenesTrabajo) getPantalla().getTblOrdenesTrabajo().getModel()).setListaOrdenes(listaDTOOrdens);
        } catch (ExcepcionCampoInvalido ex) {
            JOptionPane.showMessageDialog( getPantalla(), ex.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
            //Logger.getLogger(ControladorEjecutarOrdenesTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarReservas(List<DTOReserva> reservas) {
        ((ModeloTablaReserva) getPantalla().getTblReservas().getModel()).setListaReserva(reservas);
    }

    public void mostrarDetalleReserva(DTOReserva reservaSeleccionada) {
        ((ModeloTablaReservaEquipamiento) getPantalla().getTblEquipamientoReservado().getModel()).setListaEquipamiento(reservaSeleccionada.getListaEquipamiento());
        ((ModeloTablaResevaRepuesto) getPantalla().getTblRepuestosReservado().getModel()).setListaRepuestos(reservaSeleccionada.getListaRepuesto());
    }

    public void confirmarOrdenesPendientes() {
        experto.guardarOrdenTrabajo();
    }

    public void imprimirOrdenesPendientes() {
        experto.imprimirOrdenesPendientes();
    }

    public void cerrar() {
        getPantalla().setVisible(false);
        getPantalla().dispose();
        chuck.iniciar();
    }

    /**
     * @return the pantalla
     */
    public PantallaEjecutarOrdenDeTrabajo getPantalla() {
        return pantalla;
    }

    /**
     * @param chuck the chuck to set
     */
    public void setChuck(ChuckNorrisControlador chuck) {
        this.chuck = chuck;
    }
}
