/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.EsquinaAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaEsquina extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        EsquinaAgente esquina = (EsquinaAgente) obj;

        insert = "INSERT INTO esquina (OIDEsquina, CodigoEsquina, Descripcion)" +
                " VALUES '" + esquina.getOid()+ "', '" + esquina.getcodigoEsquina() + "','" + esquina.getdescripcion() + "'";
        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        List<Criterio> listaCriterios;
        String select;
        listaCriterios = criterios;

        return select = "select * from esquina where " ;//criterios

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        

        return selectOid = "select * from esquina where OIDEsquina = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "insert into esquina values (OIDEsquina, CodigoEsquina, Descripcion)";

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
    public void setearDatosPadre(ObjetoPersistente objPer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

