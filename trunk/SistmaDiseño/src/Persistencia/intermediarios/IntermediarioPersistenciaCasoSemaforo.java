/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.AUXCasoSemaforo;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaCasoSemaforo extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {

        AUXCasoSemaforo auxCasoSem = (AUXCasoSemaforo) obj;
        String insert;

        insert = "INSERT INTO casosemaforo (OIDCasoSemaforo, OIDSemaforo , OIDCaso)"
                + "VALUES ('" + auxCasoSem.getOid() + "', '" + auxCasoSem.getOidSemaforo() + "', '" + auxCasoSem.getOidCaso() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM casosemaforo";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "casosemaforo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM casosemaforo WHERE OIDCasoSemaforo = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        AUXCasoSemaforo auxCasoSem = (AUXCasoSemaforo) obj;
        String update;

        update = "UPDATE casosemaforo "
                + "SET OIDCasoSemaforo = '"+auxCasoSem.getOid()+", "
                + "OIDCaso = '"+auxCasoSem.getOidCaso()+", "
                + "OIDSemaforo = '"+auxCasoSem.getOidSemaforo()+"'";

        String condicion = " WHERE OIDCasoSemaforo = '"+obj.getOid()+"'";

        update = update + condicion;

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                AUXCasoSemaforo auxCasoSem = new AUXCasoSemaforo();

                auxCasoSem.setOid(rs.getString("OIDCasoSemaforo"));
                auxCasoSem.setIsNuevo(true);
                auxCasoSem.setOidSemaforo(rs.getString("OIDSemaforo"));
                auxCasoSem.setOidCaso(rs.getString("OIDCaso"));
                
                nuevosObjetos.add(auxCasoSem);

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
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listacCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
}
