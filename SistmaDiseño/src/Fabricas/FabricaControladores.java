/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabricas;

import DecoradoresSeguridad.DecoradorControladorAtenderReclamoPorDesperfecto;
import DecoradoresSeguridad.DecoradorControladorChuckNorris;
import DecoradoresSeguridad.DecoradorControladorConsultarAvanceDeReclamo;
import DecoradoresSeguridad.DecoradorControladorConsultarOrdenesPendientes;
import DecoradoresSeguridad.DecoradorControladorEjecutarOrdenesTrabajo;
import InterfacesGraficas.Controlador;

/**
 *
 * @author rustu
 */
public class FabricaControladores {

private static FabricaControladores instance = null;

    private FabricaControladores() {
    }

    public static FabricaControladores getInstance() {

        if (instance == null) {
            instance = new FabricaControladores();
        }

        return instance;

    }

    public Controlador getControlador(String tipo) {
        Controlador retorno = null;

        if (tipo.equals("AtenderReclamoPorDesperfecto")) {
            retorno = (Controlador) new DecoradorControladorAtenderReclamoPorDesperfecto();
        } else if (tipo.equals("ConsultarAvanceDeReclamo")) {
            retorno =(Controlador) new DecoradorControladorConsultarAvanceDeReclamo();
        } else if (tipo.equals("ConsultarOrdenesPendientes")) {
            retorno = (Controlador) new DecoradorControladorConsultarOrdenesPendientes();
        } else if (tipo.equals("EjecutarOrdenesTrabajo")) {
            retorno = (Controlador) new DecoradorControladorEjecutarOrdenesTrabajo();
        } else if (tipo.equals("ChuckNorris"))
            retorno = (Controlador) new DecoradorControladorChuckNorris();

        return retorno;
    }




}
