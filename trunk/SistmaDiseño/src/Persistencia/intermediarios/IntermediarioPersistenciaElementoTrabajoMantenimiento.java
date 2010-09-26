/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ElementoTrabajoMantenimientoAgente;
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
public class IntermediarioPersistenciaElementoTrabajoMantenimiento extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {

        ElementoTrabajoMantenimientoAgente elementoMant = (ElementoTrabajoMantenimientoAgente) obj;

        String insert;

        insert = "INSERT INTO elementotrabajomantenimiento (OIDElementoTrabajoMantenimiento, CantidadUtilizada, OIDElementoTrabajo, OIDDetalleInformeMantenimiento, OIDEstadoElementoTrabajo) "
                + "VALUES ('"+elementoMant.getOid()+"', "+elementoMant.getcantidad()+", '"+elementoMant.getOidElementoTrabajo()+"', '"+elementoMant.getOidDetalleInformeMantenimiento()+"', '"+elementoMant.getOidEstadoElementoTrabajo()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {
        String select;

        select = "SELECT * FROM elementotrabajomantenimiento";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "elementotrabajomantenimiento." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM elementotrabajomantenimiento WHERE OIDElementoTrabajoMantenimiento = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        ElementoTrabajoMantenimientoAgente elementoMant = (ElementoTrabajoMantenimientoAgente) obj;
        String update;

        update = "UPDATE elementotrabajomantenimiento "
                + "SET OIDElementoTrabajoMantenimiento = '"+elementoMant.getOid()+"', "
                + "CantidadUtilizada = "+elementoMant.getcantidad()+", "
                + "OIDElementoTrabajo = '"+elementoMant.getOidElementoTrabajo()+"', "
                + "OIDDetalleInformeMantenimiento = '"+elementoMant.getOidDetalleInformeMantenimiento()+"', "
                + "OIDEstadoElementoTrabajo = '"+elementoMant.getEstadoElementoTrabajo()+"'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {


        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        try {
            while (rs.next()) {

                ElementoTrabajoMantenimientoAgente nuevoElementoTrabajoMantenimiento = (ElementoTrabajoMantenimientoAgente) FabricaEntidades.getInstancia().crearEntidad("ElementoTrabajoMantenimiento");

                nuevoElementoTrabajoMantenimiento.setOid(rs.getString("OIDElementoTrabajoMantenimiento"));
                nuevoElementoTrabajoMantenimiento.setIsNuevo(false);
                nuevoElementoTrabajoMantenimiento.setcantidad(Integer.valueOf(rs.getString("CantidadUtilizada")));
                nuevoElementoTrabajoMantenimiento.setOidElementoTrabajo(rs.getString("OIDElementoTrabajo"));
                nuevoElementoTrabajoMantenimiento.setElementoTrabajoBuscado(false);
                nuevoElementoTrabajoMantenimiento.setOidDetalleInformeMantenimiento(rs.getString("OIDDetalleInformeMantenimiento"));
                nuevoElementoTrabajoMantenimiento.setOidEstadoElementoTrabajo(rs.getString("OIDEstadoElementoTrabajo"));
                nuevoElementoTrabajoMantenimiento.setEstadoElementoTrabajoBuscado(false);


                nuevosObjetos.add(nuevoElementoTrabajoMantenimiento);

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
