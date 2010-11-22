/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package DecoradoresSeguridad;


import InterfacesGraficas.ControladorConsultarAvanceDeReclamo;
import Utilidades.validar;

/**
*
* @author rustu
*/
public class DecoradorControladorConsultarAvanceDeReclamo extends ControladorConsultarAvanceDeReclamo{





    @Override
    public void iniciar() {
        super.iniciar();
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 4))
            getPantalla().getRadioBtnDenuncia().setVisible(false);
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 5))
            getPantalla().getRadioBtnReclamo().setVisible(false);
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 6))
            getPantalla().getBtnDetalleOrden().setVisible(false);
        if(!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 7))
            getPantalla().getBotonConsultar().setEnabled(false);
    }

    @Override
    public void ConsultarEstadoCaso(String numcaso, int seleccion) {
        super.ConsultarEstadoCaso(numcaso, seleccion);
    }

    @Override
    public void mostrarMensaje(int seleccion, String mensaje) {
        super.mostrarMensaje(seleccion, mensaje);
    }

    @Override
    public void cerrar(int opcionRetorno){
        super.cerrar(opcionRetorno);
    }

    }
