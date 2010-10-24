/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Criterio;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author diego
 */
public class IntermediarioDTOEstadoCaso extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        return null;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {
        return null;
    }

    @Override
    public String armarSelectOid(String oid) {
        return null;
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {
        return null;
    }

    @Override
    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        return null;
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
    }

    @Override
    public void buscarObjRelacionados(ObjetoPersistente obj) {
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listacCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
}
