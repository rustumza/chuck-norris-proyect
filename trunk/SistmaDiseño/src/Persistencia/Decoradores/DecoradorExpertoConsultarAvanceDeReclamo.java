/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Decoradores;

import DTO.DTODenuncia;
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
    public DTODenuncia ConsultarEstadoCaso(String numcaso, int seleccion, Operador operador) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado{

        IniciarTx();
        DTODenuncia aux = super.ConsultarEstadoCaso(numcaso,seleccion, operador);
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
