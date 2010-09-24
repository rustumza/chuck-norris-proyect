/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.UbicacionAgente;
import Persistencia.Entidades.UbicacionSimpleAgente;
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
public class IntermediarioPersistenciaUbicacionSimple extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        UbicacionSimpleAgente ubicacionSimple = (UbicacionSimpleAgente)obj;
        String insert;

        insert = "INSERT INTO ubicacionsimple (OIDUbicacion, Altura, OIDCalle) "
                + "VALUES ('"+ubicacionSimple.getOid()+"', "+String.valueOf(ubicacionSimple.getaltura())+", '"+ubicacionSimple.getOidCalle()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM ubicacionsimple";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "ubicacionsimple." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        selectOid = "SELECT * FROM ubicacionsimple WHERE OIDUbicacion = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        UbicacionSimpleAgente ubicacionSimple = (UbicacionSimpleAgente)obj;
        String update;

        update = "UPDATE ubicacionsimple "
                + "SET OIDUbicacion = '"+ubicacionSimple.getOid()+"', "
                + "Altura = '"+String.valueOf(ubicacionSimple.getaltura())+"',"
                + "OIDCalle = '"+ubicacionSimple.getOidCalle()+"'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                UbicacionSimpleAgente nuevaUbiSimp = (UbicacionSimpleAgente)FabricaEntidades.getInstancia().crearEntidad("UbicacionSimple");

                nuevaUbiSimp.setOid(rs.getString("OIDUbicacion"));
                nuevaUbiSimp.setIsNuevo(false);
                nuevaUbiSimp.setaltura(Integer.valueOf(rs.getString("Altura")));
                nuevaUbiSimp.setOidCalle(rs.getString("OIDCalle"));
                nuevaUbiSimp.setCalleBuscado(false);

                nuevosObjetos.add(nuevaUbiSimp);

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
    public void setearDatosPadre(ObjetoPersistente objPer) {

        UbicacionAgente padre = (UbicacionAgente) FachadaInterna.getInstancia().buscar("Ubicacion", objPer.getOid());

        ((UbicacionAgente)objPer).setcodigoubicacion(padre.getcodigoubicacion());
        ((UbicacionAgente)objPer).setPrioridad(padre.getPrioridad());
        ((UbicacionAgente)objPer).settipoubicacion(padre.gettipoubicacion());
    }
}

