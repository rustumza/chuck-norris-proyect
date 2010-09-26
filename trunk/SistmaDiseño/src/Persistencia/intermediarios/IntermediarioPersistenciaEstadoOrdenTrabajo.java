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
public class IntermediarioPersistenciaEstadoOrdenTrabajo extends IntermediarioRelacional{


    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into estadoordentrabajo (OIDEstadoOrdenTrabajo, CodigoEstadoOrdenTrabajo, NombreTrabajo) values (OIDEstadoOrdenTrabajo, CodigoEstadoOrdenTrabajo, NombreTrabajo)";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        return select = "select * from estadoordentrabajo where " ;//criterios

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        return selectOid = "select * from estadoordentrabajo where OIDEstadoOrdenTrabajo = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "update estadoordentrabajo set OIDEstadoOrdenTrabajo =" + ",CodigoEstadoOrdenTrabajo = " + "NombreTrabajo = " ;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {


        return null;
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void buscarObjRelacionados(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
