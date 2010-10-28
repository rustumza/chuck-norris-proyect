/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Decoradores;

import DTO.DTOinfoDeDenunciaGuardada;
import DTO.DTOinfoParaCrearDenuncia;
import Excepciones.ExcepcionDenunciaExistente;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoAntenderReclamoPorDesperfecto;
import Persistencia.Entidades.Denunciante;
import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author LEIVA
 */
public class DecoradorExpertoAntenderReclamoPorDesperfecto extends ExpertoAntenderReclamoPorDesperfecto{

    @Override
    public Denunciante buscarDenunciante(String dni) throws ExcepcionObjetoNoEncontrado{
        inicarTX();
        Denunciante aux = super.buscarDenunciante(dni);
        return aux;
    }

    @Override
    public DTOinfoDeDenunciaGuardada guardarDenuncia(DTOinfoParaCrearDenuncia dtoInfoParaCrearDenuncia) throws ExcepcionDenunciaExistente{
        DTOinfoDeDenunciaGuardada aux = super.guardarDenuncia(dtoInfoParaCrearDenuncia);
        confirmarTx();
        return aux;
    }

    private void inicarTX(){

        FachadaInterna.getInstancia().iniciarTransaccion();

    }
    private void confirmarTx(){
    FachadaInterna.getInstancia().confirmarTransaccion();
    }
}
