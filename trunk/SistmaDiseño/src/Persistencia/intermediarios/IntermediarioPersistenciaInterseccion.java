/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.Calle;
import Persistencia.Entidades.InterseccionAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.Ubicacion;
import Persistencia.Entidades.UbicacionAgente;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaInterseccion extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        InterseccionAgente interseccion = (InterseccionAgente) obj;
        String insert;

        insert = "INSERT INTO interseccion (OIDUbicacion) "
                + "VALUES ('" + interseccion.getOid() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        String condicion = "";
        String join = "";
        boolean addjoin = false;
        select = "SELECT * FROM interseccion";

        if (!criterios.isEmpty()) {

            for (int i = 0; i < criterios.size(); i++) {
                if (criterios.get(i).getAtributo().equalsIgnoreCase("Calle")) {
                    join = " JOIN interseccioncalle ON interseccion.OIDUbicacion = interseccioncalle.OIDInterseccion ";
                    addjoin=true;
                    criterios.get(i).setAtributo("OIDCalle");
                    if(i>0){
                        condicion = condicion + " AND ";
                    }
                    condicion = condicion + "interseccioncalle." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }else{
                    if (i > 0) {
                        condicion = condicion + " AND ";
                    }
                    condicion = condicion + "interseccion." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }
            }

            if(addjoin==true)
                select = select + join;


            select = select + " WHERE ";

            select = select + condicion;

        }

        

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM interseccion WHERE OIDUbicacion = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        InterseccionAgente interseccion = (InterseccionAgente) obj;
        String update;

        update = "UPDATE interseccion SET OIDUbicacion = '" + interseccion.getOid() + "'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                InterseccionAgente nuevaInterseccion = (InterseccionAgente) FabricaEntidades.getInstancia().crearEntidad("Interseccion");

                nuevaInterseccion.setOid(rs.getString("OIDUbicacion"));

                nuevaInterseccion.setIsNuevo(false);
                nuevaInterseccion.setOidsCalle(new ArrayList<String>());
                nuevaInterseccion.setCalles(new ArrayList<Calle>());
                nuevosObjetos.add(nuevaInterseccion);

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

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FachadaInterna.getInstancia().crearCriterio("Interseccion", "=", obj.getOid()));

        for (SuperDruperInterfaz calle : FachadaInterna.getInstancia().buscar("Calle", listaCriterios)) {
            ((InterseccionAgente) obj).addOidCalle(((ObjetoPersistente) calle).getOid());
        }

    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {

        UbicacionAgente padre = (UbicacionAgente) FachadaInterna.getInstancia().buscar("Ubicacion", objPer.getOid());

        ((UbicacionAgente) objPer).setcodigoubicacion(padre.getcodigoubicacion());
        ((UbicacionAgente) objPer).setPrioridad(padre.getPrioridad());
        ((UbicacionAgente) objPer).settipoubicacion(padre.gettipoubicacion());
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        FachadaInterna.getInstancia().guardar("Ubicacion", obj);
    }
}
