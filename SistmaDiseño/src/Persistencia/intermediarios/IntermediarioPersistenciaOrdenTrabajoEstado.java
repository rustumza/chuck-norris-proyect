/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OrdenTrabajoEstadoAgente;
import Persistencia.Fabricas.FabricaEntidades;
import Utilidades.ConvertidorBooleanos;
import Utilidades.FormateadorFechas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaOrdenTrabajoEstado extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        OrdenTrabajoEstadoAgente ordenTrabajo = (OrdenTrabajoEstadoAgente) obj;
        String insert;

        insert = "INSERT INTO ordentrabajoestado (OIDOrdenTrabajoEstado, OIDOrdenDeTrabajo, OIDEstadoOrdenTrabajo, FechaCambioEstado, IndicadoresEstadoActual) "
                + "VALUES ('" +ordenTrabajo.getOid()+ "', '" +ordenTrabajo.getOidOrdenTrabajo()+"', '"+ ordenTrabajo.getOidEstadoOrdenTrabajo()+"', '"+ FormateadorFechas.getInstancia().formatearAMySql(ordenTrabajo.getfechacambioestado()) + "', "+ ConvertidorBooleanos.getInstancia().convertirBooleanToString(ordenTrabajo.isindicadorestadoactual()) +")";
        
        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM ordentrabajoestado";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "ordentrabajoestado." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        return selectOid = "SELECT * FROM ordentrabajoestado WHERE OIDOrdenTrabajoEstado = '" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        OrdenTrabajoEstadoAgente ordenTrabajo = (OrdenTrabajoEstadoAgente) obj;
        String update;

        update = "UPDATE ordentrabajoestado "
                + "SET OIDOrdenTrabajoEstado = '" + ordenTrabajo.getOid() + "', "
                + "OIDOrdenDeTrabajo = '" + ordenTrabajo.getOidOrdenTrabajo() + "', "
                + "OIDEstadoOrdenTrabajo = '" + ordenTrabajo.getOidEstadoOrdenTrabajo() + "', "
                + "FechaCambioEstado = '" + FormateadorFechas.getInstancia().formatearAMySql(ordenTrabajo.getfechacambioestado()) + "', "
                + "IndicadoresEstadoActual = '" + ConvertidorBooleanos.getInstancia().convertirBooleanToString(ordenTrabajo.isindicadorestadoactual()) + "'";

        String condicion = " WHERE OIDOrdenTrabajoEstado = '" + ordenTrabajo.getOid() + "'";
        update = update + condicion;

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                OrdenTrabajoEstadoAgente nuevoEstado = (OrdenTrabajoEstadoAgente) FabricaEntidades.getInstancia().crearEntidad("OrdenTrabajoEstado");

                nuevoEstado.setOid(rs.getString("OIDOrdenTrabajoEstado"));
                nuevoEstado.setIsNuevo(false);
                nuevoEstado.setOidOrdenTrabajo(rs.getString("OIDOrdenDeTrabajo"));
                nuevoEstado.setOidEstadoOrdenTrabajo(rs.getString("OIDEstadoOrdenTrabajo"));
                nuevoEstado.setEstadoOrdenTrabajoBuscado(false);

                nuevoEstado.setfechacambioestado(rs.getDate("FechaCambioEstado"));

                nuevoEstado.setindicadorestadoactual(rs.getBoolean("IndicadoresEstadoActual"));

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

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
}
