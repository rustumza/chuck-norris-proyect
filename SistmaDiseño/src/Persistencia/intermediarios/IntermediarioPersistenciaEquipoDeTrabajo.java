/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.EquipoDeTrabajoAgente;
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
public class IntermediarioPersistenciaEquipoDeTrabajo extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        EquipoDeTrabajoAgente equipo = (EquipoDeTrabajoAgente) obj;

        return insert = "INSERT INTO equipodetrabajo VALUES ('"+equipo.getOid()+"', "+equipo.getcargaHorariaMaxPorDia()+", "+equipo.getcodigoEquipo()+", '"+equipo.getnombreEquipo()+"')";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "select * from equipodetrabajo";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "equipodetrabajo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        return selectOid = "select * from equipodetrabajo where OIDEquipoDeTrabajo = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "insert into equipodetrabajo values (OIDEquipoDeTrabajo, CargaHorariaMaxPorDia, CodigoEquipo, NombreEquipo)";

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                EquipoDeTrabajoAgente nuevoEquipo = (EquipoDeTrabajoAgente) FabricaEntidades.getInstancia().crearEntidad("EquipoDeTrabajo");

                nuevoEquipo.setOid(rs.getString("OIDEquipoDeTrabajo"));
                nuevoEquipo.setIsNuevo(false);
                nuevoEquipo.setTrabajadorBuscado(false);
                nuevoEquipo.setcargaHorariaMaxPorDia(Integer.valueOf(rs.getString("CargaHorariaMaxPorDia")));
                nuevoEquipo.setcodigoEquipo(Integer.valueOf(rs.getString("CodigoEquipo")));
                nuevoEquipo.setnombreEquipo(rs.getString("NombreEquipo"));

                nuevosObjetos.add(nuevoEquipo);

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
    public void setearDatosPadre(ObjetoPersistente objPer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

