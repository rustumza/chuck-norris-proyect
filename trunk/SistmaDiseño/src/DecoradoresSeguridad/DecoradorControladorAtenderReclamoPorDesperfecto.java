/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DecoradoresSeguridad;

import DTO.DTOinfoParaCrearDenuncia;
import Excepciones.ExcepcionObjetoNoEncontrado;
import InterfacesGraficas.ControladorAtenderReclamoPorDesperfecto;
import Persistencia.Entidades.Calle;
import Persistencia.Entidades.Denunciante;
import Persistencia.Entidades.Problema;

/**
 *
 * @author rustu
 */
public class DecoradorControladorAtenderReclamoPorDesperfecto extends ControladorAtenderReclamoPorDesperfecto {



    @Override
    public void iniciar(){

    }

    @Override
    public Denunciante buscarDenunciante(String dni) throws ExcepcionObjetoNoEncontrado{
        return super.buscarDenunciante(dni);
    }

    @Override
    public void guardarDenunciante(Denunciante denunciante){
        super.guardarDenunciante(denunciante);

    }

    @Override
    public void cerrar(){

    }

    @Override

    public Calle[] buscarCalle(String calle){
        return super.buscarCalle(calle);
    }

    @Override

    public void buscarSemaforo(Calle calle1, Calle calle2){
        super.buscarSemaforo(calle1, calle2);
    }

    @Override
    public Problema[] buscarProblema(){
        return super.buscarProblema();
    }

    @Override
    public void guardarDenuncia(DTOinfoParaCrearDenuncia infoParaCrearDenuncia){
        super.guardarDenuncia(infoParaCrearDenuncia);
    }


}
