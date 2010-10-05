/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Decoradores;

import DTO.DTODenuncia;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author LEIVA
 */
public class DecoradorExpertoConsultarAvanceDeReclamo extends ExpertoConsultarAvanceDeReclamo {

    @Override
    public DTODenuncia ConsultarEstadoCaso(String numcaso, int seleccion) {

        IniciarTx();
        DTODenuncia aux = super.ConsultarEstadoCaso(numcaso,seleccion);
        confirmarTx();
        return aux;
    }

    private  void IniciarTx() {

        FachadaInterna.getInstancia().iniciarTransaccion();

    }

    private  void confirmarTx() {
        FachadaInterna.getInstancia().confirmarTransaccion();
    }
}
