/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DecoradoresSeguridad;

import DTO.DTOReserva;
import InterfacesGraficas.ControladorEjecutarOrdenesTrabajo;
import Utilidades.validar;
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
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 8)){
            getPantalla().getRadioBtnOrdenMant().setEnabled(false);
            getPantalla().getRadioBtnOrdenTodas().setEnabled(false);
            
        }
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 9)){
            getPantalla().getRadioBtnOrdenRep().setEnabled(false);
            getPantalla().getRadioBtnOrdenTodas().setEnabled(false);
            
        }
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 16))
            getPantalla().getBtnConfirmar().setEnabled(false);

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
    public void confirmarOrdenesPendientes(Date fecha, int seleccion) {
        super.confirmarOrdenesPendientes(fecha, seleccion);
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
