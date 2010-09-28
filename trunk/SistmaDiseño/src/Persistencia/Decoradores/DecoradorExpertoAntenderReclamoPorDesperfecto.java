/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Decoradores;

import DTO.DTOinfoParaCrearDenuncia;
import Expertos.ExpertoAntenderReclamoPorDesperfecto;
import Persistencia.Entidades.Denunciante;
import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author LEIVA
 */
public class DecoradorExpertoAntenderReclamoPorDesperfecto extends ExpertoAntenderReclamoPorDesperfecto{

    @Override
    public Denunciante buscarDenunciante(String dni){
        inicarTX();
        Denunciante aux = super.buscarDenunciante(dni);
        return aux;
    }

    @Override
    public void guardarDenuncia(DTOinfoParaCrearDenuncia dtoInfoParaCrearDenuncia){
        super.guardarDenuncia(dtoInfoParaCrearDenuncia);
        confirmarTx();
    }

    private void inicarTX(){

        FachadaInterna.getInstancia().iniciarTransaccion();

    }
    private void confirmarTx(){
    FachadaInterna.getInstancia().confirmarTransaccion();
    }
}
