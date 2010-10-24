/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DecoradoresSeguridad;

import DTO.DTOReserva;
import InterfacesGraficas.ControladorConsultarOrdenesPendientes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DecoradorControladorConsultarOrdenesPendientes extends ControladorConsultarOrdenesPendientes{

    @Override
    public void buscarOrdenes(Date fecha, int seleccion){

        super.buscarOrdenes(fecha, seleccion);

    }

    @Override
    public void mostrarReservas(List<DTOReserva> reservas) {
        super.mostrarReservas(reservas);
    }

    @Override
    public void mostrarDetalleReserva(DTOReserva reservaSeleccionada) {
        super.mostrarDetalleReserva(reservaSeleccionada);
    }

    @Override
    public void cerrar(){

        super.cerrar();

    }



}
