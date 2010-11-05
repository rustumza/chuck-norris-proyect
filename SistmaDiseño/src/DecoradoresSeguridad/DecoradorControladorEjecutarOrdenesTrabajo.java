/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DecoradoresSeguridad;

import DTO.DTOReserva;
import InterfacesGraficas.ControladorEjecutarOrdenesTrabajo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DecoradorControladorEjecutarOrdenesTrabajo extends ControladorEjecutarOrdenesTrabajo {

    @Override
    public void iniciar() {
        super.iniciar();
    }


    @Override
    public void buscarOrdenesPendientes(Date fecha, int seleccion) {

        super.buscarOrdenesPendientes(fecha, seleccion);

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
    public void confirmarOrdenesPendientes(Date fecha) {
        super.confirmarOrdenesPendientes(fecha);
    }

    @Override
    public void imprimirOrdenesPendientes() {
        super.imprimirOrdenesPendientes();
    }

    @Override
    public void cerrar() {

        super.cerrar();

    }


}
