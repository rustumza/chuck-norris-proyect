/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.CalleAgente;
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
public class IntermediarioPersistenciaCalle extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        CalleAgente calle = (CalleAgente) obj;
        String insert;

        insert = "INSERT INTO calle (OIDCalle, CodigoCalle, NombreCalle) "
                + "VALUES ('" + calle.getOid() + "', " + String.valueOf(calle.getcodigoCalle()) + ", '" + calle.getnombrecalle() + "')";
        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

       
        String select;
        String condicion = "";
        String join = "";
        boolean addjoin = false;
        select = "SELECT * FROM calle";

        if (!criterios.isEmpty()) {

            for (int i = 0; i < criterios.size(); i++) {
                if (criterios.get(i).getAtributo().equalsIgnoreCase("Interseccion")) {
                    join = " JOIN interseccioncalle ON calle.OIDCalle = interseccioncalle.OIDCalle ";
                    addjoin=true;
                    criterios.get(i).setAtributo("OIDInterseccion");
                    if(i>0){
                        condicion = condicion + " AND ";
                    }
                    condicion = condicion + "interseccioncalle." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }else{
                    if (i > 0) {
                        condicion = condicion + " AND ";
                    }
                    condicion = condicion + "calle." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
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

        return selectOid = "SELECT * FROM calle WHERE OIDCalle = 0" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        CalleAgente calle = (CalleAgente) obj;
        String update;

        update = "UPDATE calle SET OIDCalle = '" + calle.getOid() + "', "
                + "CodigoCalle = " + String.valueOf(calle.getcodigoCalle()) + ", "
                + "NombreCalle = '" + calle.getnombrecalle() + "'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                CalleAgente nuevaCalle = (CalleAgente)FabricaEntidades.getInstancia().crearEntidad("Calle");

                nuevaCalle.setOid(rs.getString("OIDCalle"));
                nuevaCalle.setIsNuevo(false);
                nuevaCalle.setcodigoCalle(Integer.valueOf(rs.getString("CodigoCalle")));
                nuevaCalle.setnombrecalle(rs.getString("NombreCalle"));

                nuevosObjetos.add(nuevaCalle);

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
}
