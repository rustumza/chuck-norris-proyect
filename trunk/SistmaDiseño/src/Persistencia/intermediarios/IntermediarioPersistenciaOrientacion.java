/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OrientacionAgente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaOrientacion extends IntermediarioRelacional{


    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        OrientacionAgente orientacion = (OrientacionAgente) obj;

        insert = "INSERT INTO orientacion (OIDOrientacion, CodigoOrientacion, Descripcion) "
                + " VALUES '" + orientacion.getOid() + "', '" + orientacion.getcodigoOrientacion() + "','" + orientacion.getdescripcion()+ "'";

     return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        select = "SELECT * FROM orientacion";
        String condicion = "";

            while (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";
            for (int i = 0; i < criterios.size();i++){
            if(i>0){
            condicion = condicion + " AND ";
           }
           condicion = condicion + "orientacion." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + "'" + criterios.get(i).getValor()+ "'";
          }
            select = select + condicion;
        }
        return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;
       
        return selectOid = "SELECT * FROM orientacion WHERE OIDOrientacion = '" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        OrientacionAgente orientacion = (OrientacionAgente) obj;
         update = "UPDATE orientacion SET "
                 + "OIDOrientacion = '" + orientacion.getOid() + "',"
                 + "CodigoOrientacion = '" + orientacion.getcodigoOrientacion() + "',"
                 + "Descripcion = '" + orientacion.getdescripcion() + "'" ;
      return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
    List<ObjetoPersistente> nuevoObjeto = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                OrientacionAgente nuevaorientacion = (OrientacionAgente) FabricaEntidades.getInstancia().crearEntidad("Orientacion");
                nuevaorientacion.setIsNuevo(false);
                nuevaorientacion.setOid(rs.getString("OIDOrientacion"));
                nuevaorientacion.setcodigoOrientacion(Integer.valueOf(rs.getString("CodigoOrientacion")));
                nuevaorientacion.setdescripcion(rs.getString("Descripcion"));
                nuevoObjeto.add(nuevaorientacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaOrientacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nuevoObjeto;
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

