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
public class IntermediarioPersistenciaInformeReparacion extends IntermediarioRelacional{

private String oid;

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into informereparacion (OIDInformeReparacion, OIDOrdenDeTrabajo, DuracionReparacion, FechaInforme, HoraInforme) values (OIDInformeMantenimiento, OIDOrdenDeTrabajo, Duracionmantenimiento, FechaInforme, HoraInforme)";
    }

    public String armarSelect(List<Criterio> criterios) {

        List<Criterio> listaCriterios;
        String select;
        listaCriterios = criterios;

        return select = "select * from informereparacion where " ;//criterios

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        this.oid =oid;

        return selectOid = "select * from informereparacion where OIDInformeReparacion = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "update informereparacion set OIDInformeReparacion =" + ",OIDOrdenDeTrabajo = " + "DuracionReparacion = " + "FechaInforme =" + "HoraInforme =";

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
}

