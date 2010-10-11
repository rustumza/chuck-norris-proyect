/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.UbicacionAgente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaUbicacion extends IntermediarioRelacional{


    public String armarInsert(ObjetoPersistente obj) {

        UbicacionAgente ubicacion = (UbicacionAgente) obj;

        String insert;

        insert = "INSERT INTO ubicacion (OIDUbicacion, CodigoUbicacion, Prioridad, TipoUbicacion) "
                + "VALUES ('"+ubicacion.getOid()+"', "+String.valueOf(ubicacion.getcodigoubicacion())+", "+String.valueOf(ubicacion.getPrioridad())+", '"+ubicacion.gettipoubicacion()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM ubicacion";

        boolean addjoin = false;//se activa cuando es necesario hacer join para la busqueda N a N

        String join = "";

        String condicion = "";

        if (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    condicion = condicion + " AND ";
                }

                if (criterios.get(i).getAtributo().equalsIgnoreCase("Interseccion")) {
                    addjoin = true;
                    join = " JOIN interseccioncalle ON ubicacion.OIDUbicacion = interseccioncalle.OIDUbicacion";
                    condicion = condicion + "OIDInterseccion" + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }else if(criterios.get(i).getAtributo().equalsIgnoreCase("Semaforo")){
                    addjoin = true;
                    join = " JOIN semaforo ON semaforo.OIDUbicacion = ubicacion.OIDUbicacion ";
                    condicion = condicion + "OIDSemaforo " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";

                } else {
                    condicion = condicion + "ubicacion." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }

            }
        }

        if (addjoin) {
            select = select + join + condicion;
        }else{
            select = select + condicion;
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM ubicacion WHERE OIDUbicacion = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        UbicacionAgente ubicacion = (UbicacionAgente) obj;
        String update;

        update = "UPDATE ubicacion SET OIDUbicacion = '"+ubicacion.getOid()+"', "
                + "CodigoUbicacion = "+String.valueOf(ubicacion.getcodigoubicacion())+ ", "
                + "Prioridad = "+String.valueOf(ubicacion.getPrioridad())+", "
                + "TipoUbicacion = '"+ubicacion.gettipoubicacion()+"'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                UbicacionAgente nuevaUbicacion = (UbicacionAgente) FabricaEntidades.getInstancia().crearEntidad("Ubicacion");
                nuevaUbicacion.setOid(rs.getString("OIDUbicacion"));
                nuevaUbicacion.setIsNuevo(false);
                nuevaUbicacion.setcodigoubicacion(Integer.valueOf(rs.getString("CodigoUbicacion")));
                nuevaUbicacion.setPrioridad(Integer.valueOf(rs.getString("Prioridad")));
                nuevaUbicacion.settipoubicacion(rs.getString("TipoUbicacion"));
                
                nuevosObjetos.add(nuevaUbicacion);

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

