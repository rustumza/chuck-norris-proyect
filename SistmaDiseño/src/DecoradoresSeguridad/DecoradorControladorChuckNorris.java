/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DecoradoresSeguridad;

import InterfacesGraficas.ChuckNorrisControlador;
import InterfacesGraficas.ControladorSubSistemaPermisos;
import InterfacesGraficas.PantallaPrincipal;
import Persistencia.Entidades.Operador;
import Persistencia.Entidades.Permiso;
import Utilidades.validarPermisos;

/**
 *
 * @author rustu
 */
public class DecoradorControladorChuckNorris extends ChuckNorrisControlador{

    @Override
    public void iniciar() {

        super.iniciar();
        /*
         if(validarPermisos.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 21))
            getPantPrinc().getatenderReclamo().setEnabled(false);
        if(validarPermisos.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 22))
            getPantPrinc().getconsultarAvanceDeReclamo().setEnabled(false);
        if(validarPermisos.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 23))
            getPantPrinc().getconsultarOrdenesPendientes().setEnabled(false);
        if(validarPermisos.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 24))
            getPantPrinc().getejecutarOrdenesDeTrabajos().setEnabled(false);
        */
    }

    @Override
    public void iniciarCUAtenderReclamoPorDesperfecto() {

        super.iniciarCUAtenderReclamoPorDesperfecto();

    }

    @Override
    public void iniciarCUConsultarAvanceDeReclamo() {

        super.iniciarCUConsultarAvanceDeReclamo();
    }

    @Override
    public void iniciarCUConsultarOrdenesPendientes() {

        super.iniciarCUConsultarOrdenesPendientes();

    }

    @Override
    public void iniciarCUEjecutarOrdenesPendientes() {

        super.iniciarCUEjecutarOrdenesPendientes();

    }

    @Override
    public PantallaPrincipal getPantPrinc() {
        return super.getPantPrinc();
    }




    @Override
    public void setPantPrinc(PantallaPrincipal pantPrinc) {
        super.setPantPrinc(pantPrinc);
    }

    @Override
    public void cerrar(){

        super.cerrar();

    }



    @Override
    public void setContSubSisPerm(ControladorSubSistemaPermisos contSubSisPerm) {
        super.setContSubSisPerm(contSubSisPerm);
    }

    @Override
    public Operador getOperadorEncontrado() {
        return super.getOperadorEncontrado();
    }


    @Override
    public void setOperadorEncontrado(Operador operadorEncontrado) {
        super.setOperadorEncontrado(operadorEncontrado);
    }


}
