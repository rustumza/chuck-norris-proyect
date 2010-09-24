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
public class IntermediarioPersistenciaTrabajador extends IntermediarioRelacional{

    private String oid;

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into trabajador (OIDTrabajador, Nombre, Apellido, TipoDocumento, Documento, Legajo) values (OIDTrabajador, Nombre, Apellido, TipoDocumento, Documento, Legajo)";
    }

    public String armarSelect(List<Criterio> criterios) {

        List<Criterio> listaCriterios;
        String select;
        listaCriterios = criterios;

        return select = "select * from trabajador where " ;//criterios

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        this.oid =oid;

        return selectOid = "select * from trabajador where OIDTrabajador = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "update trabajador set OIDTrabajador =" + ",Nombre = " + "Apellido = " + "TipoDocumento =" + "Documento =" + "Legajo =";

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


