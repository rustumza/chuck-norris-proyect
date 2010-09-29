/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Problema;
import Persistencia.Entidades.ProblemaAgente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaProblema extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        ProblemaAgente problema = (ProblemaAgente) obj;
        String insert;

        insert = "INSERT INTO problema (OIDProblema, CodigoProblema, DescripcionProblema) "
                + "VALUES ('" + problema.getOid() + "', " + String.valueOf(problema.getcodigoProblema()) + ", '" + problema.getdescripcionProblema() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        List<Criterio> listaCriterios;
        String select;
        listaCriterios = criterios;

        select = "SELECT * FROM problema";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "problema." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM problema WHERE OIDProblema = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {
        ProblemaAgente problema = (ProblemaAgente) obj;
        String update;

        update = "UPDATE problema "
                + "SET OIDProblema ='" + problema.getOid() + "', "
                + "CodigoProblema = " + String.valueOf(problema.getcodigoProblema()) + ", "
                + "DescripcionProblema = '" + problema.getdescripcionProblema() + "'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                ProblemaAgente nuevoProblema = (ProblemaAgente) FabricaEntidades.getInstancia().crearEntidad("Problema");

                nuevoProblema.setOid(rs.getString("OIDProblema"));
                nuevoProblema.setIsNuevo(false);
                nuevoProblema.setcodigoProblema(rs.getInt("CodigoProblema"));
                nuevoProblema.setdescripcionProblema(rs.getString("DescripcionProblema"));

                nuevosObjetos.add(nuevoProblema);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return nuevosObjetos;
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
