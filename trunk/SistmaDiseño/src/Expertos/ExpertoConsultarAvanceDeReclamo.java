/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import DTO.DTOCaso;
import DTO.DTOOrden;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Operador;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Utilidades.validar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RUSTU
 */
public class ExpertoConsultarAvanceDeReclamo implements Experto {

    public DTOCaso ConsultarEstadoCaso(String numcaso, int seleccion, Operador operador) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {



        if (numcaso.equals("")) {
            ExcepcionCampoInvalido ex = new ExcepcionCampoInvalido();
            ex.setMensaje("Código de Caso vacío.");
            throw ex;

        }

        if (seleccion == 1) {
            return buscarDTODenuncia(numcaso,operador);
        }else{
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("CodigoReclamo", "=", numcaso));
            List<SuperDruperInterfaz> listaEncontrada = FachadaExterna.getInstancia().buscar("Reclamo", listaCriterios);
            if (listaEncontrada.isEmpty()) {
                ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
                ex.setMensaje("No se han encontrado Casos con el numero: " + numcaso);
                throw ex;
            }
            listaCriterios.clear();
            listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("Reclamo", "=", (ObjetoPersistente) listaEncontrada.get(0)));
            List<SuperDruperInterfaz> denunciasBuscadas = FachadaExterna.getInstancia().buscar("Denuncia", listaCriterios);

            return buscarDTODenuncia(String.valueOf(((Denuncia)denunciasBuscadas.get(0)).getcodigoDenuncia()),operador);
        }



    }

    public DTOCaso buscarDTODenuncia(String numcaso,  Operador operador) throws ExcepcionObjetoNoEncontrado{
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            if(!validar.validarPermisos(operador.getUsuario().getPerfil().getPermisos(), 17))
                listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("Operador", "=", operador));
            listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("CodigoDenuncia", "=", numcaso));
            List<SuperDruperInterfaz> listaEncontrada = FachadaExterna.getInstancia().buscar("DTOEstadoCaso", listaCriterios);
            if (listaEncontrada.isEmpty()) {
                ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
                ex.setMensaje("No se han encontrado Casos con el numero: " + numcaso);
                throw ex;
            }
              DTOCaso dtoEncontrado = (DTOCaso) listaEncontrada.get(0);
             return dtoEncontrado;
    }

    public boolean habilitarBotonDetalleOrden(DTOOrden dtoOrdenRep) {
        if (dtoOrdenRep.getInformeReparacion() != null) {
            return true;
        } else {
            return false;
        }
    }
}
