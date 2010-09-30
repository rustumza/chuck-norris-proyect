/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OrdenDeMantenimientoAgente;
import Persistencia.Entidades.OrdenTrabajoAgente;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaOrdenDeMantenimiento extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        OrdenDeMantenimientoAgente ordenMant = (OrdenDeMantenimientoAgente) obj;

        insert = "INSERT INTO ordendemantenimiento (OIDOrdenDeTrabajo, OIDSemaforo, CodigoOrdenMantenimiento, OIDFichaMantenimiento) "
                + "VALUES ('" + ordenMant.getOid() + "', '" + ordenMant.getOidSemaforo() + "', " + ordenMant.getcodigoordenmantenimiento() + ", '" + ordenMant.getOidFichaMantenimiento() + "')";

        return insert;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {
        String select;
        String join = "";
        String condicion = "";
        boolean addjoin = false;

        select = "SELECT * "
                + "FROM ordendemantenimiento";

        if (!criterios.isEmpty()) {
            for (int i = 0; i < criterios.size(); i++) {
                if (criterios.get(i).getAtributo().equals("estado")) {
                    addjoin = true;
                    join = join + " JOIN ordentrabajoestado ON ordendetrabajo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                            + "JOIN estadoordentrabajo ON ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo";
                    if (condicion.length() != 0) {
                        condicion = condicion + " AND ";
                    }
                    condicion = condicion + "estadoordentrabajo.NombreEstado = '" + criterios.get(i).getValor() + "' AND ordentrabajoestado.IndicadoresEstadoActual = 1";
                    continue;
                } else if (criterios.get(i).getAtributo().equals("FechaInicioPlanificada")) {
                    join = join + " JOIN ordendetrabajo ON ordendemantenimiento.OIDOrdenDeTrabajo = ordendetrabajo.OIDOrdenDeTrabajo";
                    if (condicion.length() != 0) {
                        condicion = condicion + " AND ";
                    }
                    condicion = condicion + "ordendetrabajo.FechaInicioPlanificada = '" + criterios.get(i).getValor() + "'";
                    addjoin = true;
                    continue;

                }
                if (i > 0) {
                    condicion = condicion + " AND ";
                }

                condicion = condicion + "ordendemantenimiento." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        if (addjoin) {
            select = select + join;
        }

        select = select + " WHERE " + condicion;
        return select;
        
    }

    @Override
    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * "
                + "FROM ordendemantenimiento "
                + "WHERE OIDOrdenDeTrabajo = '" + oid + "'";

        return selectOid;
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        OrdenDeMantenimientoAgente ordenMant = (OrdenDeMantenimientoAgente) obj;

        update = "UPDATE ordendemantenimiento "
                + "SET OIDOrdenDeTrabajo = '" + ordenMant.getOid() + "', "
                + "OIDSemaforo = '" + ordenMant.getOidSemaforo() + "', "
                + "CodigoOrdenMantenimiento = " + ordenMant.getcodigoordenmantenimiento() + ", "
                + "OIDFichaMantenimiento = '" + ordenMant.getOidFichaMantenimiento() + "'";

        String condicion = " WHERE OIDOrdenDeTrabajo = '" + ordenMant.getOid() + "'";

        update = update + condicion;

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
                OrdenDeMantenimientoAgente nuevaOrdenDeMantenimiento = (OrdenDeMantenimientoAgente) FabricaEntidades.getInstancia().crearEntidad("OrdenDeMantenimiento");

                nuevaOrdenDeMantenimiento.setIsNuevo(false);
                nuevaOrdenDeMantenimiento.setOid(rs.getString("OIDOrdenDeTrabajo"));
                nuevaOrdenDeMantenimiento.setOidSemaforo(rs.getString("OIDSemaforo"));
                nuevaOrdenDeMantenimiento.setSemaforoBuscado(false);
                nuevaOrdenDeMantenimiento.setInformeMantenimientoBuscado(false);
                nuevaOrdenDeMantenimiento.setOidFichaMantenimiento(rs.getString("OIDFichaMantenimiento"));
                nuevaOrdenDeMantenimiento.setFichaMantenimientoBuscado(false);
                nuevaOrdenDeMantenimiento.setcodigoordenmantenimiento(rs.getInt("CodigoOrdenMantenimiento"));

                nuevosObjetos.add(nuevaOrdenDeMantenimiento);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return nuevosObjetos;
    }

    @Override
    /*
     * para armar la relacion N a N
     */
    public void buscarObjRelacionados(ObjetoPersistente obj) {
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
       //busca el padre por oid
        OrdenTrabajoAgente padre = (OrdenTrabajoAgente) FachadaInterna.getInstancia().buscar("OrdenTrabajo", objPer.getOid());
        //setea los datos del padre a la entidad
        ((OrdenTrabajoAgente) objPer).setOidEquipoDeTrabajo(padre.getOidEquipoDeTrabajo());
        ((OrdenTrabajoAgente) objPer).setfechainiciotrabajo(padre.getfechainiciotrabajo());
        ((OrdenTrabajoAgente) objPer).setfechafintrabajo(padre.getfechafintrabajo());
        ((OrdenTrabajoAgente) objPer).setfechainicioplanificada(padre.getfechainicioplanificada());
        ((OrdenTrabajoAgente) objPer).setduracionprevistatrabajo(padre.getduracionprevistatrabajo());
        ((OrdenTrabajoAgente) objPer).settipoordentrabajo(padre.gettipoordentrabajo());
        ((OrdenTrabajoAgente) objPer).setEquipoDeTrabajoBuscado(false);
        ((OrdenTrabajoAgente) objPer).setOrdenTrabajoEstadosBuscado(false);
        ((OrdenTrabajoAgente) objPer).setReservaBuscado(false);
        ((OrdenTrabajoAgente) objPer).setTrabajoBuscado(false);
        if (padre.getTrabajos() != null) {
            ((OrdenTrabajoAgente) objPer).setTrabajos(padre.getTrabajos());
        }
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        FachadaInterna.getInstancia().guardar("OrdenTrabajo", obj);
    }
}
