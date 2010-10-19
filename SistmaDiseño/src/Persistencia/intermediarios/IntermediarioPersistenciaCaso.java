
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.AUXCasoSemaforo;
import Persistencia.Entidades.AUXProblemaCaso;
import Persistencia.Entidades.CasoAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Problema;
import Persistencia.Entidades.ProblemaAgente;
import Persistencia.Entidades.Semaforo;
import Persistencia.Entidades.SemaforoAgente;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import Persistencia.Fabricas.FabricaEntidades;
import Utilidades.FormateadorFechas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public abstract class IntermediarioPersistenciaCaso extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        CasoAgente caso = (CasoAgente) obj;


        insert = "INSERT INTO caso (OIDCaso, OIDDenunciante, OIDOperador, FechaCaso, TipoCaso) "
                + "VALUES ('" + caso.getOid() + "', '" + caso.getOidDenunciante() + "', '" + caso.getOidOperador() + "', '" + FormateadorFechas.getInstancia().formatearAMySql(caso.getfechacaso()) + "', '" + caso.gettipocaso() + "')";

        return insert;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {
        String select;
        boolean addjoin = false;//se activa cuando es necesario hacer join para la busqueda N a N

        select = "SELECT * FROM caso";

        String join = " JOIN casosemaforo ON caso.OIDCaso = casosemaforo.OIDCaso";

        String condicion = "";

        if (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    condicion = condicion + " AND ";
                }

                if (criterios.get(i).getAtributo().equals("Semaforo")) {
                    addjoin = true;
                    condicion = condicion + "semaforo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                } else {
                    condicion = condicion + "caso." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }

            }
        }

        if (addjoin) {
            select = select + join + condicion;
        } else {
            select = select + condicion;
        }

        return select;
    }

    @Override
    public String armarSelectOid(String oid) {
        String selectOid;

        return selectOid = "SELECT * FROM caso WHERE OIDCaso = '" + oid + "'";
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {

        CasoAgente caso = (CasoAgente) obj;

        String update;

        update = "UPDATE caso SET "
                + "OIDCaso = '" + caso.getOid() + "',"
                + "OIDDenunciante = '" + caso.getOidDenunciante() + "', "
                + "OIDOperador = '" + caso.getOidOperador() + "', "
                + "FechaCaso = '" + caso.getfechacaso() + "', "
                + "TipoCaso = '" + caso.gettipocaso() + "'"
                + " WHERE OIDCaso = '"+caso.getOid() + "'";


        return update;
    }

    @Override
    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    @Override
    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                CasoAgente nuevoCaso = (CasoAgente) FabricaEntidades.getInstancia().crearEntidad("Caso");

                nuevoCaso.setIsNuevo(false);
                nuevoCaso.setOid(rs.getString("OIDCaso"));
                nuevoCaso.setOidDenunciante(rs.getString("OIDDenunciante"));
                nuevoCaso.setDenuncianteBuscado(false);
                nuevoCaso.setOidOperador(rs.getString("OIDOperador"));
                nuevoCaso.setOperadorBuscado(false);
                nuevoCaso.setfechacaso(rs.getDate("FechaCaso"));

                nuevoCaso.settipocaso(rs.getString("TipoCaso"));

                nuevosObjetos.add(nuevoCaso);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return nuevosObjetos;
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {

        CasoAgente caso = (CasoAgente) obj;
        AUXCasoSemaforo auxcasosem;
        String aux;
        for(Semaforo auxsem :caso.getSemaforo()){
            aux = ((SemaforoAgente) auxsem).getOid();
            auxcasosem = (AUXCasoSemaforo) FachadaInterna.getInstancia().crearEntidad("AUXCasoSemaforo");
            auxcasosem.setOidCaso(obj.getOid());
            auxcasosem.setOidSemaforo(aux);
            FachadaInterna.getInstancia().guardar("AUXCasoSemaforo", auxcasosem);
        }
        
        AUXProblemaCaso auxprobcaso;
        String aux1;
        for(Problema auxProb : caso.getProblema()) {
            aux1=((ProblemaAgente)auxProb).getOid();
            auxprobcaso = (AUXProblemaCaso) FachadaInterna.getInstancia().crearEntidad("AUXProblemaCaso");
            auxprobcaso.setOidCaso(obj.getOid());
            auxprobcaso.setOidProblema(aux1);
            FachadaInterna.getInstancia().guardar("AUXProblemaCaso", auxprobcaso);
        }


    }

    @Override
    /*
     * Buscar oids de los semaforos de un caso
     */
    public void buscarObjRelacionados(ObjetoPersistente obj) {
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("Caso", "=", obj.getOid()));

        for (SuperDruperInterfaz semaforo : FachadaInterna.getInstancia().buscar("Semaforo", listaCriterios)) {
            ((CasoAgente) obj).addOidSemaforo(((ObjetoPersistente) semaforo).getOid());
        }
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
    
}