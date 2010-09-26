
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.OrdenTrabajoAgente;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.TrabajoAgente;
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
public class IntermediarioPersistenciaOrdenDeTrabajo extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        OrdenTrabajoAgente ordenTrabajo = (OrdenTrabajoAgente) obj;

        return insert = "INSERT INTO ordendetrabajo (OIDOrdenDeTrabajo, FechaInicioTrabajo, FechaFinTrabajo, FechaInicioPlanificada, DuracionPrevistaTrabajo, Tipo, OIDEquipoDeTrabajo)"
                + " VALUES ('" + ordenTrabajo.getOid() + "', '" + ordenTrabajo.getfechainiciotrabajo() + "', '" + ordenTrabajo.getfechafintrabajo() + "', '" + ordenTrabajo.getfechainicioplanificada() + "', " + ordenTrabajo.getduracionprevistatrabajo() + ", '" + ordenTrabajo.gettipoordentrabajo() + "', '" + ordenTrabajo.getOidEquipoDeTrabajo() + "'d);";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        String condicion = null;
        String join = null;

        select = "SELECT * FROM ordendetrabajo";
        boolean addjoin = false;

        if (!criterios.isEmpty()) {

            if (criterios.get(0).getAtributo().equals("estado")) {
                addjoin = true;
                join = " JOIN ordentrabajoestado ON ordendetrabajo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                        + "JOIN estadoordentrabajo ON ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo";
                condicion = " WHERE estadoordentrabajo.NombreEstado = '" + criterios.get(0).getValor() + "'";
            } else {
                condicion = " WHERE ";
            }

            for (int i = 0; i < criterios.size(); i++) {
                if (addjoin && i == 0) {
                    continue;
                }
                if (i > 0) {
                    condicion = condicion + " AND ";
                }

                condicion = condicion + "ordendetrabajo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }

        }

        if (addjoin) {
            select = select + join + condicion;
        }

        return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;

        return selectOid = "SELECT * FROM ordendetrabajo WHERE OIDOrdenDeTrabajo = '" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        OrdenTrabajoAgente ordenTrabajo = (OrdenTrabajoAgente) obj;
        String update;

        update = "UPDATE ordendetrabajo "
                + "SET OIDOrdenDeTrabajo = '" + ordenTrabajo.getOid() + ","
                + "FechaInicioTrabajo = '" + ordenTrabajo.getfechainiciotrabajo() + "', "
                + "FechaFinTrabajo = '" + ordenTrabajo.getfechafintrabajo() + "', "
                + "FechaInicioPlanificada = '" + ordenTrabajo.getfechainicioplanificada() + "', "
                + "DuracionPrevistaTrabajo = " + ordenTrabajo.getduracionprevistatrabajo() + ", "
                + "Tipo = '" + ordenTrabajo.gettipoordentrabajo() + "', "
                + "OIDEquipoDeTrabajo = '" + ordenTrabajo.getOidEquipoDeTrabajo() + "';";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                OrdenTrabajoAgente nuevaOrdenTrabajo = (OrdenTrabajoAgente) FabricaEntidades.getInstancia().crearEntidad("OrdenTrabajo");
                nuevaOrdenTrabajo.setIsNuevo(false);
                nuevaOrdenTrabajo.setOid(rs.getString("OIDOrdenDeTrabajo"));
                nuevaOrdenTrabajo.setOidEquipoDeTrabajo(rs.getString("OIDEquipoDeTrabajo"));

                nuevaOrdenTrabajo.setfechainiciotrabajo(rs.getDate("FechaInicioTrabajo"));
                nuevaOrdenTrabajo.setfechafintrabajo(rs.getDate("FechaFinTrabajo"));
                nuevaOrdenTrabajo.setfechainicioplanificada(rs.getDate("FechaInicioPlanificada"));

                nuevaOrdenTrabajo.setduracionprevistatrabajo(Integer.valueOf(rs.getString("DuracionPrevistaTrabajo")));
                nuevaOrdenTrabajo.settipoordentrabajo(rs.getString("Tipo"));
                nuevaOrdenTrabajo.setEquipoDeTrabajoBuscado(false);
                nuevaOrdenTrabajo.setOrdenTrabajoEstadosBuscado(false);
                nuevaOrdenTrabajo.setReservaBuscado(false);
                nuevaOrdenTrabajo.setTrabajoBuscado(false);

                nuevosObjetos.add(nuevaOrdenTrabajo);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return nuevosObjetos;
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
        for (Reserva reserva : ((OrdenTrabajo) obj).getRervas()) {
            FachadaInterna.getInstancia().guardar("Reserva", (ObjetoPersistente) reserva);
        }
    }

    @Override
    /*
     * Busqueda de la relacion N a N
     */
    public void buscarObjRelacionados(ObjetoPersistente obj) {

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("OrdenTrabajo", "=", obj.getOid()));

        List<SuperDruperInterfaz> listaTrabajos = FachadaInterna.getInstancia().buscar("Trabajo", listaCriterios);

        for (SuperDruperInterfaz trabajo : listaTrabajos) {

            ((OrdenTrabajoAgente) obj).addOidTrabajo(((TrabajoAgente) trabajo).getOid());

        }
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
    }
}
