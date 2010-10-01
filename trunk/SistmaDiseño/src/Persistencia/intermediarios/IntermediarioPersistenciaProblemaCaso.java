/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.AUXProblemaCaso;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaProblemaCaso extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        AUXProblemaCaso problemaCaso = (AUXProblemaCaso)obj;
        String insert;

        insert = "INSERT INTO problemacaso (OIDProblemaCaso, OIDCaso, OIDProblema) "
                + "VALUES ('" + problemaCaso.getOid() + "', '" + problemaCaso.getOidCaso() + "', '" + problemaCaso.getOidProblema() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "select * from problemacaso";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "problemacaso." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM problemacaso WHERE OIDProblemaCaso = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        AUXProblemaCaso problemaCaso = new AUXProblemaCaso();
        String update;

        update = "UPDATE problemacaso "
                + "SET OIDProblemaCaso = '" + problemaCaso.getOid() + "', "
                + "OIDCaso = '" + problemaCaso.getOidCaso() + "', "
                + "OIDProblema = '" + problemaCaso.getOidProblema() + "'";
        
        String condicion = " WHERE OIDProblemaCaso = '" + obj.getOid() + "'";

        update = update + condicion;

        return update;

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
    }
}
