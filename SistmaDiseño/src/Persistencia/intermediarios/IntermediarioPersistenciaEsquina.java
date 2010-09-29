/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.Esquina;
import Persistencia.Entidades.EsquinaAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaEsquina extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        EsquinaAgente esquina = (EsquinaAgente) obj;

        insert = "INSERT INTO esquina (OIDEsquina, CodigoEsquina, Descripcion)"
                + " VALUES '" + esquina.getOid() + "', '" + esquina.getcodigoEsquina() + "','" + esquina.getdescripcion() + "'";
        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM esquina";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "esquina." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;


        selectOid = "SELECT * FROM esquina WHERE OIDEsquina = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        EsquinaAgente esquina = (EsquinaAgente) obj;
        String update;

        update = "UPDATE esquina "
                + "SET OIDEsquina = '" + esquina.getOid() + "', "
                + "CodigoEsquina = " + String.valueOf(esquina.getcodigoEsquina()) + ", "
                + "Descripcion = '" + esquina.getdescripcion() + "'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                EsquinaAgente nuevaEsquina = (EsquinaAgente) FabricaEntidades.getInstancia().crearEntidad("Esquina");
                nuevaEsquina.setOid(rs.getString("OIDEsquina"));
                nuevaEsquina.setIsNuevo(false);
                nuevaEsquina.setcodigoEsquina(rs.getInt("CodigoEsquina"));
                nuevaEsquina.setdescripcion(rs.getString("Descripcion"));

                nuevosObjetos.add(nuevaEsquina);

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
    }
}
