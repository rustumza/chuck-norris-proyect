/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.TipoSemaforoAgente;
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
    public class IntermediarioPersistenciaTipoSemaforo extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        TipoSemaforoAgente tipoSemaforo = (TipoSemaforoAgente)obj;
         insert = "INSERT INTO tiposemaforo (OIDTipoSemaforo, CodigoTipoSemaforo, DescripcionTipoSemaforo) "
                 + "VALUES '" + tipoSemaforo.getOid() + "', '" + tipoSemaforo.getcodigoTipoSemaforo() + "', '" + tipoSemaforo.getdescripciontiposemaforo() + "'";

    return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        boolean addjoin = false;//se activa cuando es necesario hacer join para la busqueda N a N

         select = "SELECT * FROM tiposemaforo" ;
         String condicion = "";

         while (!criterios.isEmpty()) {
             condicion = condicion + " WHERE ";
             for(int i = 0; i < criterios.size(); i++){
                 if(i>0){
                     condicion = condicion + " AND ";
                 }
                 condicion = condicion + "tiposemaforo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";

             }

             select = select + condicion;
        }

         return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;
        
        return selectOid = "SELECT * FROM tiposemaforo WHERE OIDTipoSemaforo = '" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        TipoSemaforoAgente tipoSemaforo = (TipoSemaforoAgente)obj;

         update = "UPDATE tiposemaforo SET"
                 + "OIDTipoSemaforo ='" + tipoSemaforo.getOid() + "',"
                 + "CodigoTipoSemaforo = '" + tipoSemaforo.getcodigoTipoSemaforo() + "' ,"
                 + "DescripcionTipoSemaforo = '" + tipoSemaforo.getdescripciontiposemaforo() + "'";

         return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                TipoSemaforoAgente nuevoTipoSemaforo = (TipoSemaforoAgente) FabricaEntidades.getInstancia().crearEntidad("TipoSemaforo");
                nuevoTipoSemaforo.setIsNuevo(false);
                try {
                    nuevoTipoSemaforo.setOid(rs.getString("OIDTipoSemaforo"));
                    nuevoTipoSemaforo.setcodigoTipoSemaforo(Integer.valueOf(rs.getString("CodigoTipoSemaforo")));
                    nuevoTipoSemaforo.setdescripciontiposemaforo(rs.getString("DescripcionTipoSemaforo"));

                    nuevosObjetos.add(nuevoTipoSemaforo);

                } catch (SQLException ex) {
                    Logger.getLogger(IntermediarioPersistenciaTipoSemaforo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaTipoSemaforo.class.getName()).log(Level.SEVERE, null, ex);
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

