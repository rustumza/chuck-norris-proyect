/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import Expertos.ExpertoConsultarOrdenesPendientes;
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
public class ControladorConsultarOrdenesPendientes {
    ExpertoConsultarOrdenesPendientes experto;
    PantallaConsultarOrdenesPendientes pantalla;

    public ControladorConsultarOrdenesPendientes(){
        pantalla = new PantallaConsultarOrdenesPendientes(this);
        experto = (ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes");
    }

    void iniciar() {
        pantalla.setVisible(true);
    }

    void buscarOrdenes(Date fecha, int seleccion) {
        List<DTOOrden> listaDTOOrdens = experto.buscarOrdenesDTO(fecha, seleccion);
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






}
