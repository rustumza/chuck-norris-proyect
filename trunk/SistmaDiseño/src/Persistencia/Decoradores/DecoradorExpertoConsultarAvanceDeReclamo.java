/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Decoradores;

import DTO.DTOCaso;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Persistencia.Entidades.Operador;
import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author LEIVA
 */
public class DecoradorExpertoConsultarAvanceDeReclamo extends ExpertoConsultarAvanceDeReclamo {

    @Override
    public DTOCaso ConsultarEstadoCaso(String numcaso, int seleccion, Operador operador) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado{

        IniciarTx();
        DTOCaso aux = super.ConsultarEstadoCaso(numcaso,seleccion, operador);
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
