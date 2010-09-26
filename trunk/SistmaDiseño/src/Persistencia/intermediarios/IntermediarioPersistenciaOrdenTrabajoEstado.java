/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OrdenTrabajoEstadoAgente;
import Persistencia.Fabricas.FabricaEntidades;
import Utilidades.FormateadorFechas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaOrdenTrabajoEstado extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into ordentrabajoestado (OIDOrdenTrabajoEstado, OIDOrdenDeTrabajo, OIDEstadoOrdenTrabajo, FechaCambioEstado, IndicadoresEstadoActual) values (OIDOrdenTrabajoEstado, OIDOrdenDeTrabajo, OIDEstadoOrdenTrabajo, FechaCambioEstado, IndicadoresEstadoActual)";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "select * from ordentrabajoestado";

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

        return selectOid = "select * from ordentrabajoestado where OIDOrdenTrabajoEstado = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "update ordentrabajoestado set OIDOrdenTrabajoEstado =" + ",OIDOrdenDeTrabajo = " + "OIDEstadoOrdenTrabajo = " + "FechaCambioEstado =" + "IndicadoresEstadoActual =";

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
                nuevoEstado.setOidEstadoOrdenTrabajo(rs.getString("OIDEstadoOrdenTrabajo"));
                nuevoEstado.setEstadoOrdenTrabajoBuscado(false);
                try {
                    nuevoEstado.setfechacambioestado(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().parse(rs.getString("FechaCambioEstado")));
                } catch (ParseException ex) {
                    Logger.getLogger(IntermediarioPersistenciaOrdenTrabajoEstado.class.getName()).log(Level.SEVERE, null, ex);
                }
                nuevoEstado.setindicadorestadoactual(Boolean.valueOf(rs.getString("IndicadoresEstadoActual")));

                nuevosObjetos.add(nuevoEstado);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nuevosObjetos;

    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void buscarObjRelacionados(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

