/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.OrdenTrabajoAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OrdenDeReparacionAgente;
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
public class IntermediarioPersistenciaOrdenReparacion extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {

        String insert;

        OrdenDeReparacionAgente ordenRep = (OrdenDeReparacionAgente) obj;

        insert = "INSERT INTO ordenreparacion (OIDOrdenDeTrabajo, CodigoOrdenReparacion, OIDDenuncia) "
                + "VALUES ('" + obj.getOid() + "', "+String.valueOf(ordenRep.getcodigoordenreparacion())+" , '" + ordenRep.getOidDenuncia() + "')";


        return insert;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {

        String select;
        String join = "";
        String condicion = "";
        boolean addjoin = false;

        select = "SELECT * "
                + "FROM ordenreparacion";

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
                    join = join + " JOIN ordendetrabajo ON ordenreparacion.OIDOrdenDeTrabajo = ordendetrabajo.OIDOrdenDeTrabajo";
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

                condicion = condicion + "ordenreparacion." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
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
                + "FROM ordenreparacion "
                + "WHERE OIDOrdenTrabajo = '" + oid + "'";

        return selectOid;
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        OrdenDeReparacionAgente ordenRep = (OrdenDeReparacionAgente) obj;

        update = "UPDATE ordenreparacion "
                + "SET OIDOrdenDeTrabajo = '" + ordenRep.getOid() + "', "
                + "CodigoOrdenReparacion = "+String.valueOf(ordenRep.getcodigoordenreparacion())+", "
                + "OIDDenuncia = '" + ordenRep.getOidDenuncia() + "'";

        String condicion = " WHERE OIDOrdenDeTrabajo = '" + ordenRep.getOid() + "'";

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

                OrdenDeReparacionAgente nuevaOrdenRep = (OrdenDeReparacionAgente) FabricaEntidades.getInstancia().crearEntidad("OrdenDeReparacion");

                nuevaOrdenRep.setIsNuevo(false);
                nuevaOrdenRep.setOid(rs.getString("OIDOrdenDeTrabajo"));
                nuevaOrdenRep.setOidDenuncia(rs.getString("OIDDenuncia"));
                nuevaOrdenRep.setcodigoordenreparacion(rs.getInt("CodigoOrdenReparacion"));
                nuevaOrdenRep.setDenunciaBuscado(false);
                nuevaOrdenRep.setInformeReparacionBuscado(false);

                nuevosObjetos.add(nuevaOrdenRep);

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
