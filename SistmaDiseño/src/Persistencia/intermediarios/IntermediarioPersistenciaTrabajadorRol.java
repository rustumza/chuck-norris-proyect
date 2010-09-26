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
public class IntermediarioPersistenciaTrabajadorRol extends IntermediarioRelacional{

    private String oid;

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into trabajadorrol (OIDTrabajadorRol, OIDRol, OIDTrabajador, OIDEquipoDeTrabajo, FechaFinRol, FechaInicioRol) values (OIDTrabajadorRol, OIDRol, OIDTrabajador, OIDEquipoDeTrabajo, FechaFinRol, FechaInicioRol)";
    }

    public String armarSelect(List<Criterio> criterios) {

        List<Criterio> listaCriterios;
        String select;
        listaCriterios = criterios;

        return select = "select * from trabajadorrol where " ;//criterios

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        this.oid =oid;

        return selectOid = "select * from trabajadorrol where OIDTrabajodorRol = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "update trabajadorrol set OIDTrabajodorRol =" + ",OIDRol = " + "OIDTrabajador = " + "OIDEquipoDeTrabajo =" + "FechaFinRol =" + "FechaInicioRol =";

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
