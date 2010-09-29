/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.ReservaElementoTrabajoAgente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaReservaElementoTrabajo extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        ReservaElementoTrabajoAgente elementoTrabajo = (ReservaElementoTrabajoAgente) obj;
        String insert;

        insert = "INSERT INTO reservaelementotrabajo (OIDReservaElementoTrabajo, OIDElementoTrabajo, OIDReserva, CantidadReservada) "
                + "VALUES ('"+elementoTrabajo.getOid()+"', '"+elementoTrabajo.getOidElementoTrabajo()+"', '"+elementoTrabajo.getOidReserva()+"', "+Integer.valueOf(elementoTrabajo.getcantidadreservada())+")";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {
        String select;

        select = "SELECT * FROM reservaelementotrabajo";
        
        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "reservaelementotrabajo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM reservaelementotrabajo WHERE OIDReservaElementoTrabajo = '" +oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {
ReservaElementoTrabajoAgente elementoTrabajo = (ReservaElementoTrabajoAgente) obj;
        String update;

        update = "UPDATE reservaelementotrabajo "
                + "SET OIDReservaElementoTrabajo = '"+elementoTrabajo.getOid()+"', "
                + "OIDElementoTrabajo = '"+elementoTrabajo.getOidElementoTrabajo()+ "', "
                + "OIDReserva = '"+elementoTrabajo.getOidReserva()+"', "
                + "CantidadReservada = "+Integer.valueOf(elementoTrabajo.getcantidadreservada());

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        try {
            while (rs.next()) {

                ReservaElementoTrabajoAgente nuevaReservaElementoTrabajo = (ReservaElementoTrabajoAgente) FabricaEntidades.getInstancia().crearEntidad("ReservaElementoTrabajo");

                nuevaReservaElementoTrabajo.setOid(rs.getString("OIDReservaElementoTrabajo"));
                nuevaReservaElementoTrabajo.setIsNuevo(false);
                nuevaReservaElementoTrabajo.setOidElementoTrabajo(rs.getString("OIDElementoTrabajo"));
                nuevaReservaElementoTrabajo.setElementoTrabajoBuscado(false);
                nuevaReservaElementoTrabajo.setOidReserva(rs.getString("OIDReserva"));
                nuevaReservaElementoTrabajo.setcantidadreservada(rs.getInt("CantidadReservada"));

                nuevosObjetos.add(nuevaReservaElementoTrabajo);

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

