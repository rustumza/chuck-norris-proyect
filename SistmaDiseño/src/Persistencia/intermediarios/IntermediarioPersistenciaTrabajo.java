/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.TrabajoAgente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaTrabajo extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        TrabajoAgente trabajo = (TrabajoAgente) obj;

        insert = "INSERT INTO trabajo (OIDTrabajo, NombreTrabajo, TiempoEstimadoTrabajo, TipoTrabajo) "
                + "VALUES ('" + trabajo.getOid() + "', '" + trabajo.getNombreTrabajo() + "', " + trabajo.gettiempoEstimadoTrabajo() + ", '" + trabajo.gettipotrabajo() + "')";

        return insert;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {
        String select;
        boolean addjoin = false;//se activa cuando es necesario hacer join para la busqueda N a N

        select = "SELECT * FROM trabajo";//criterios

        String join = " JOIN trabajoordendetrabajo ON trabajo.OIDTrabajo = trabajoordendetrabajo.OIDTrabajo";

        String condicion = "";

        if (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    condicion = condicion + " AND ";
                }

                if (criterios.get(i).getAtributo().equals("OrdenTrabajo")) {
                    addjoin = true;
                    condicion = condicion + "OIDOrdenDeTrabajo" + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                } else {
                    condicion = condicion + "trabajo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }

            }
        }

        if (addjoin) {
            select = select + join + condicion;
        }else{
            select = select + condicion;
        }

        return select;
    }

    @Override
    public String armarSelectOid(String oid) {
        String selectOid;

        return selectOid = "SELECT * FROM trabajo WHERE OIDTrabajo = '" +oid+"'";
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {

        TrabajoAgente trabajo = (TrabajoAgente) obj;

        String update;

        update = "UPDATE trabajo SET "
                + "OIDTrabajo = '"+ trabajo.getOid()+ ","
                + "NombreTrabajo = '"+trabajo.getNombreTrabajo() + "', "
                + "TiempoEstimadoTrabajo = "+ trabajo.gettiempoEstimadoTrabajo()+", "
                + "TipoTrabajo = '"+trabajo.gettipotrabajo() +"'";

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

                TrabajoAgente nuevoTrabajo = (TrabajoAgente) FabricaEntidades.getInstancia().crearEntidad("Trabajo");
                nuevoTrabajo.setIsNuevo(false);
                nuevoTrabajo.setOid(rs.getString("OIDTrabajo"));
                nuevoTrabajo.setNombreTrabajo(rs.getString("NombreTrabajo"));
                nuevoTrabajo.settiempoEstimadoTrabajo(Integer.valueOf(rs.getString("TiempoEstimadoTrabajo")));
                nuevoTrabajo.settipotrabajo(rs.getString("TipoTrabajo"));

                nuevosObjetos.add(nuevoTrabajo);

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
