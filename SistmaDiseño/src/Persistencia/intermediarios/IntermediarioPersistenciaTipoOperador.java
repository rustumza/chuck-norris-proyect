/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.intermediarios;

import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.TipoOperador;
import Persistencia.Entidades.TipoOperadorAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rustu
 */
public class IntermediarioPersistenciaTipoOperador extends IntermediarioRelacional{

    @Override
    public String armarInsert(ObjetoPersistente obj) {

        TipoOperadorAgente tipoOperador = (TipoOperadorAgente) obj;

        String insert = "INSERT INTO tipooperador (OIDTipoOperador, CodigoTipoOperador,NombreTipoOperador, DescripcionTipoOperador)"
                + "VALUES ('"+tipoOperador.getOid()+"', '"+tipoOperador.getNombre()+"', '"+tipoOperador.getDescripcion()+"')";
        return insert;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM tipooperador";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "tipooperador." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }


        return select;
    }

    @Override
    public String armarSelectOid(String oid) {
        String selectOid;

        selectOid = "SELECT * FROM tipooperador WHERE OIDTipoOperador = '" + oid + "'";

        return selectOid;
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {
        TipoOperadorAgente tipoOperador = (TipoOperadorAgente) obj;

        String update;

        update = "UPDATE tipooperador "
                + "set OIDTipoOperador = '"+tipoOperador.getOid()+"', "
                + "CodigoTipoOperador = '"+tipoOperador.getCodigo()+"', "
                + "NombreTipoOperador = '"+tipoOperador.getNombre()+"', "
                + "DescripcionTipoOperador = '"+tipoOperador.getDescripcion()+"'";

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

                TipoOperadorAgente nuevoTipoOperadorAgente = (TipoOperadorAgente) FabricaEntidades.getInstancia().crearEntidad("nuevoTipoOperador");
                nuevoTipoOperadorAgente.setIsNuevo(false);
                nuevoTipoOperadorAgente.setOid(rs.getString("OIDTipoOperador"));
                nuevoTipoOperadorAgente.setCodigo(rs.getString("CodigoTipoOperador"));
                nuevoTipoOperadorAgente.setNombre(rs.getString("NombreTipoOperador"));
                nuevoTipoOperadorAgente.setDescripcion(rs.getString("DescripcionTipoOperador"));

                nuevosObjetos.add(nuevoTipoOperadorAgente);

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
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listacCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }


}
