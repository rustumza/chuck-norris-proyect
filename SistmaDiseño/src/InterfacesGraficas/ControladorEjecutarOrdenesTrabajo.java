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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class ControladorEjecutarOrdenesTrabajo implements Controlador{

    ExpertoEjecutarOrdenesTrabajo experto;
    PantallaEjecutarOrdenDeTrabajo pantalla;
    ChuckNorrisControlador chuck;

    public ControladorEjecutarOrdenesTrabajo(){
        
    }

    public ControladorEjecutarOrdenesTrabajo(ChuckNorrisControlador chuckCont) {
        chuck = chuckCont;
        experto = (ExpertoEjecutarOrdenesTrabajo) FabricaExpertos.getInstance().getExperto("EjecutarOrdenesTrabajo");
        pantalla = new PantallaEjecutarOrdenDeTrabajo(this);
    }

    public void iniciar() {
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

// public void confirmarOrden(OrdenTrabajo listaOrdenTrabajo){
//        experto.guardarOrdenTrabajo((List<OrdenTrabajo>) listaOrdenTrabajo);
//     }
    void buscarOrdenesPendientes(Date fecha, int seleccion) {

        List<DTOOrden> listaDTOOrdens;
        try {
            listaDTOOrdens = experto.consultarOrdenesPendientes(fecha, seleccion);
            ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
            nuevoModelo.addAllRow(listaDTOOrdens);
            ((ModeloTablaOrdenesTrabajo) pantalla.getTblOrdenesTrabajo().getModel()).setListaOrdenes(listaDTOOrdens);
        } catch (ExcepcionCampoInvalido ex) {
            JOptionPane.showMessageDialog(pantalla, ex.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
            //Logger.getLogger(ControladorEjecutarOrdenesTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void mostrarReservas(List<DTOReserva> reservas) {
        ((ModeloTablaReserva) pantalla.getTblReservas().getModel()).setListaReserva(reservas);
    }

    void mostrarDetalleReserva(DTOReserva reservaSeleccionada) {
        ((ModeloTablaReservaEquipamiento) pantalla.getTblEquipamientoReservado().getModel()).setListaEquipamiento(reservaSeleccionada.getListaEquipamiento());
        ((ModeloTablaResevaRepuesto) pantalla.getTblRepuestosReservado().getModel()).setListaRepuestos(reservaSeleccionada.getListaRepuesto());
    }

    void confirmarOrdenesPendientes() {
        experto.guardarOrdenTrabajo();
    }

    void imprimirOrdenesPendientes() {
        experto.imprimirOrdenesPendientes();
    }

    public void cerrar() {
        pantalla.setVisible(false);
        pantalla.dispose();
        chuck.iniciar();
    }
}
