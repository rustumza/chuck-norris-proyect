/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaCronogramaMantenimiento extends IntermediarioRelacional{

private String oid;

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into cronogramamantenimiento values (OIDCronogramaDeMantenimiento, CodigoCronograma, ObservacionesCronograma, FechaDeCreacion, FechaInicioCronograma, FechaFinCronograma)";
    }

    public String armarSelect(List<Criterio> criterios) {

        List<Criterio> listaCriterios;
        String select;
        listaCriterios = criterios;

        return select = "select * from cronogramamantenimiento where " ;//criterios

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        this.oid =oid;

        return selectOid = "select * from cronogramamantenimiento where OIDCronogramaDeMantenimiento = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "insert into cronogramamantenimiento values (OIDCronogramaDeMantenimiento, CodigoCronograma, ObservacionesCronograma, FechaDeCreacion, FechaInicioCronograma, FechaFinCronograma)";

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

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
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
        
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

