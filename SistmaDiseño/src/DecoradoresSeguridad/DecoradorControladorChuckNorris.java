/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoradoresSeguridad;

import InterfacesGraficas.ChuckNorrisControlador;
import InterfacesGraficas.PantallaPrincipal;
import Persistencia.Entidades.Operador;
import Utilidades.validar;

/**
 *
 * @author rustu
 */
public class DecoradorControladorChuckNorris extends ChuckNorrisControlador {

    @Override
    public void iniciar() {

        super.iniciar();

        if (!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 12)) {
            getPantPrinc().getatenderReclamo().setVisible(false);
            getPantPrinc().getCrearusuario().setVisible(false);
        }

        if (!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 13)) {
            getPantPrinc().getconsultarAvanceDeReclamo().setVisible(false);
            getPantPrinc().getCrearusuario().setVisible(false);
        }
        if (!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 14)) {
            getPantPrinc().getconsultarOrdenesPendientes().setVisible(false);
            getPantPrinc().getCrearusuario().setVisible(false);
        }
        if (!validar.validarPermisos(getOperadorEncontrado().getUsuario().getPerfil().getPermisos(), 15)) {
            getPantPrinc().getejecutarOrdenesDeTrabajos().setVisible(false);
            getPantPrinc().getCrearusuario().setVisible(false);
        }

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
    public void cerrar() {

        super.cerrar();

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
