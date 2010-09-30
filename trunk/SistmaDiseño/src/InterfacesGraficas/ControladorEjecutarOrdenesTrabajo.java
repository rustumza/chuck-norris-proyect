/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import InterfacesGraficas.ModelosTablas.ModeloTablaReserva;
import InterfacesGraficas.ModelosTablas.ModeloTablaReservaEquipamiento;
import InterfacesGraficas.ModelosTablas.ModeloTablaResevaRepuesto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ControladorEjecutarOrdenesTrabajo {

    ExpertoEjecutarOrdenesTrabajo experto;
    PantallaEjecutarOrdenDeTrabajo pantalla;

    public ControladorEjecutarOrdenesTrabajo() {
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
        List<DTOOrden> listaDTOOrdens = experto.consultarOrdenesPendientes(fecha, seleccion);
        ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
        nuevoModelo.addAllRow(listaDTOOrdens);
        ((ModeloTablaOrdenesTrabajo)pantalla.getTblOrdenesTrabajo().getModel()).setListaOrdenes(listaDTOOrdens);
    }

    void mostrarReservas(List<DTOReserva> reservas) {
        ((ModeloTablaReserva)pantalla.getTblReservas().getModel()).setListaReserva(reservas);
    }

    void mostrarDetalleReserva(DTOReserva reservaSeleccionada) {
        ((ModeloTablaReservaEquipamiento)pantalla.getTblEquipamientoReservado().getModel()).setListaEquipamiento(reservaSeleccionada.getListaEquipamiento());
        ((ModeloTablaResevaRepuesto)pantalla.getTblRepuestosReservado().getModel()).setListaRepuestos(reservaSeleccionada.getListaRepuesto());
    }

    void confirmarOrdenesPendientes(List<DTOOrden> ordenesTrabajo) {
        experto.confirmarOrdenesPendientes();
    }

 }
