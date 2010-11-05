/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DecoradoresSeguridad;

import DTO.DTOReserva;
import InterfacesGraficas.ControladorConsultarOrdenesPendientes;
import Utilidades.validar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DecoradorControladorConsultarOrdenesPendientes extends ControladorConsultarOrdenesPendientes{

    @Override
    public void iniciar(){
        super.iniciar();
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 10)){
            getPantalla().getRadioBtnOrdenMant().setEnabled(false);
            getPantalla().getRadioBtnOrdenTodas().setEnabled(false);

        }
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 11)){
            getPantalla().getRadioBtnOrdenRep().setEnabled(false);
            getPantalla().getRadioBtnOrdenTodas().setEnabled(false);
        }
    }

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
