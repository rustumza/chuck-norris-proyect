/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ElementoTrabajoReparacionAgente;
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
public class IntermediarioPersistenciaElementoTrabajoReparacion extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {

        ElementoTrabajoReparacionAgente elementoReparacion = (ElementoTrabajoReparacionAgente) obj;

        String insert;

        insert = "INSERT INTO elementotrabajoreparacion (OIDElementoTrabajoReparacion, OIDReparacionTareaRealizada, OIDElementoTrabajo, OIDEstadoElementoTrabajo, CantidadUtilizada) "
                + "VALUES ('" + elementoReparacion.getOid() + "', '" + elementoReparacion.getOidReparacionTareaRealizada() + "', '" + elementoReparacion.getOidElementoTrabajo() + "', '" + elementoReparacion.getOidElementoTrabajo() + "', " + elementoReparacion.getcantidad() + ")";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM elementotrabajoreparacion";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "elementotrabajoreparacion." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM elementotrabajoreparacion WHERE OIDElementoTrabajoReparacion = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        ElementoTrabajoReparacionAgente elementoReparacion = (ElementoTrabajoReparacionAgente) obj;

        String update;

        update = "UPDATE elementotrabajoreparacion SET OIDElementoTrabajoReparacion = '" + elementoReparacion.getOid() + "', "
                + "OIDReparacionTareaRealizada = '" + elementoReparacion.getOidReparacionTareaRealizada() + "', "
                + "OIDElementoTrabajo = '" + elementoReparacion.getOidElementoTrabajo() + "', "
                + "OIDEstadoElementoTrabajo = '" + elementoReparacion.getOidElementoTrabajo() + "', "
                + "CantidadUtilizada = " + Integer.valueOf(elementoReparacion.getcantidad());

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        try {
            while (rs.next()) {

                ElementoTrabajoReparacionAgente nuevoElemento = (ElementoTrabajoReparacionAgente) FabricaEntidades.getInstancia().crearEntidad("ElementoTrabajoReparacion");

                nuevoElemento.setOid(rs.getString("OIDElementoTrabajoReparacion"));
                nuevoElemento.setIsNuevo(false);
                nuevoElemento.setOidReparacionTareaRealizada(rs.getString("OIDReparacionTareaRealizada"));
                nuevoElemento.setOidElementoTrabajo(rs.getString("OIDElementoTrabajo"));
                nuevoElemento.setElementoTrabajoBuscado(false);
                nuevoElemento.setOidEstadoElementoTrabajo(rs.getString("OIDEstadoElementoTrabajo"));
                nuevoElemento.setcantidad(Integer.valueOf(rs.getString("CantidadUtilizada")));

                nuevosObjetos.add(nuevoElemento);

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
    public void setearDatosPadre(ObjetoPersistente objPer) {
    }
}
