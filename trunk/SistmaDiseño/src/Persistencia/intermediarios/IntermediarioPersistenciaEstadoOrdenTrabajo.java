/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.EstadoOrdenTrabajo;
import Persistencia.Entidades.EstadoOrdenTrabajoAgente;
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
public class IntermediarioPersistenciaEstadoOrdenTrabajo extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        EstadoOrdenTrabajoAgente estado = (EstadoOrdenTrabajoAgente) obj;
        String insert;

        insert = "INSERT INTO estadoordentrabajo (OIDEstadoOrdenTrabajo, CodigoEstadoOrdenTrabajo, NombreEstado) "
                + "VALUES ('" + estado.getOid() + "', " + String.valueOf(estado.getcodigoestadoordentrabajo()) + ", '" + estado.getNombreestado() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM estadoordentrabajo";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "estadoordentrabajo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM estadoordentrabajo WHERE OIDEstadoOrdenTrabajo = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {
        EstadoOrdenTrabajoAgente estado = (EstadoOrdenTrabajoAgente) obj;
        String update;

        update = "UPDATE estadoordentrabajo "
                + "SET OIDEstadoOrdenTrabajo = '" + estado.getOid() + "', "
                + "CodigoEstadoOrdenTrabajo = " + String.valueOf(estado.getcodigoestadoordentrabajo()) + ", "
                + "NombreEstado = '" + estado.getNombreestado() + "'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                EstadoOrdenTrabajoAgente nuevoEstado = (EstadoOrdenTrabajoAgente) FabricaEntidades.getInstancia().crearEntidad("EstadoOrdenTrabajo");

                nuevoEstado.setOid(rs.getString("OIDEstadoOrdenTrabajo"));
                nuevoEstado.setIsNuevo(false);
                nuevoEstado.setcodigoestadoordentrabajo(rs.getInt("CodigoEstadoOrdenTrabajo"));
                nuevoEstado.setNombreestado(rs.getString("NombreEstado"));

                nuevosObjetos.add(nuevoEstado);

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
}
