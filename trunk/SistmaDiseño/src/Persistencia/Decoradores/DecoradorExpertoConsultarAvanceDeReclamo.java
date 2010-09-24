/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Decoradores;

import DTO.DTOEstadoDenuncia;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.util.List;

/**
 *
 * @author LEIVA
 */
public class DecoradorExpertoConsultarAvanceDeReclamo extends ExpertoConsultarAvanceDeReclamo {

    @Override
    public List<DTOEstadoDenuncia> ConsultarEstadoCaso(String numcaso) {

        IniciarTx();
        List<DTOEstadoDenuncia> aux = super.ConsultarEstadoCaso(numcaso);
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
