/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Decoradores;

import DTO.DTOinfoDeDenunciaGuardada;
import DTO.DTOinfoParaCrearDenuncia;
import Excepciones.ExcepcionCampoInvalido;
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
    public DTOinfoDeDenunciaGuardada guardarDenuncia(DTOinfoParaCrearDenuncia dtoInfoParaCrearDenuncia) throws ExcepcionDenunciaExistente, ExcepcionObjetoNoEncontrado{
        DTOinfoDeDenunciaGuardada aux = super.guardarDenuncia(dtoInfoParaCrearDenuncia);
        confirmarTx();
        return aux;
    }

    @Override
    public void guardarDenunciante(Denunciante denunciante) throws ExcepcionCampoInvalido {
        super.guardarDenunciante(denunciante);
    }


    private void inicarTX(){

        FachadaInterna.getInstancia().iniciarTransaccion();

    }
    private void confirmarTx(){
    FachadaInterna.getInstancia().confirmarTransaccion();
    }
}
