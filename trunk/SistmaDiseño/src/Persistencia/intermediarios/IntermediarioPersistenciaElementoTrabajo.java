/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ElementoTrabajoAgente;
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
public class IntermediarioPersistenciaElementoTrabajo extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {

        ElementoTrabajoAgente elemento = (ElementoTrabajoAgente) obj;

        String insert;

        insert = "INSERT INTO elementotrabajo (OIDElementoTrabajo, CodigoSistemaExterno, TipoElemento) "
                + "VALUES ('" + elemento.getOid() + "', " + Integer.valueOf(elemento.getcodigosistemaexterno()) + ", '" +elemento.gettipoelemento()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM elementotrabajo";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "elementotrabajo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;


        selectOid = "SELECT * FROM elementotrabajo WHERE OIDElementoTrabajo = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        ElementoTrabajoAgente elemento = (ElementoTrabajoAgente) obj;
        String update;

        update = "UPDATE elementotrabajo "
                + "SET OIDElementoTrabajo = '" + elemento.getOid() + "', "
                + "CodigoSistemaExterno = " + Integer.valueOf(elemento.getcodigosistemaexterno()) + ", "
                + "TipoElemento = '" + elemento.gettipoelemento()+"'";

        String condicion = " WHERE OIDElementoTrabajo = '" + elemento.getOid() + "'";

        update = update + condicion;

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        try {
            while (rs.next()) {

                ElementoTrabajoAgente nuevoElemento = (ElementoTrabajoAgente) FabricaEntidades.getInstancia().crearEntidad("ElementoTrabajo");

                nuevoElemento.setOid(rs.getString("OIDElementoTrabajo"));
                nuevoElemento.setIsNuevo(false);
                nuevoElemento.setcodigosistemaexterno((rs.getShort("CodigoSistemaExterno")));
                nuevoElemento.settipoelemento(rs.getString("TipoElemento"));

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
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
}
