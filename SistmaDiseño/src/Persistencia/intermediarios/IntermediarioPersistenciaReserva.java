
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaAgente;
import Persistencia.Entidades.ReservaElementoTrabajo;
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
public class IntermediarioPersistenciaReserva extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        ReservaAgente reserva = (ReservaAgente) obj;
        String insert;

        insert = "INSERT INTO reserva (OIDReserva, OIDOrdenDeTrabajo, FechaReserva, CodigoReserva) "
                + "VALUES ('" + reserva.getOid() + "', '" + reserva.getOidOrdenTrabajo() + "', '" + reserva.getfecha().toString() + "', " + Integer.valueOf(reserva.getcodigoreserva()) + ")";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {
        String select;

        select = "SELECT * FROM reserva";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "reserva." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }


        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM reserva WHERE OIDReserva = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        ReservaAgente reserva = (ReservaAgente) obj;

        String update;

        update = "UPDATE reserva "
                + "SET OIDReserva = '" + reserva.getOid() + "' ,"
                + "OIDOrdenDeTrabajo = '" + reserva.getOidOrdenTrabajo()+ "', "
                + "FechaReserva = '" + reserva.getfecha().toString() + "' ,"
                + "CodigoReserva = " + String.valueOf(reserva.getcodigoreserva());

        String condicion = " WHERE OIDReserva = '"+ reserva.getOid() + "'";

        update = update + condicion;

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                ReservaAgente nuevaReserva = (ReservaAgente) FabricaEntidades.getInstancia().crearEntidad("Reserva");
                nuevaReserva.setIsNuevo(false);
                nuevaReserva.setOid(rs.getString("OIDReserva"));
                nuevaReserva.setOidOrdenTrabajo(rs.getString("OIDOrdenDeTrabajo"));
                nuevaReserva.setcodigoreserva(Integer.valueOf(rs.getString("CodigoReserva")));
                nuevaReserva.setfecha(rs.getDate("FechaReserva"));

                nuevaReserva.setReservaElementoTrabajoBuscado(false);

                nuevosObjetos.add(nuevaReserva);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return nuevosObjetos;
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {

        for (ReservaElementoTrabajo reservaElementoTrabajo : ((Reserva) obj).getReservaElementoTrabajo()) {
            FachadaInterna.getInstancia().guardar("ReservaElementoTrabajo", (ObjetoPersistente) reservaElementoTrabajo);
        }

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
