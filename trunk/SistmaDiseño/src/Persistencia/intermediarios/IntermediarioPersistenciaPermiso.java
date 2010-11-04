/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.PermisoAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class IntermediarioPersistenciaPermiso extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        PermisoAgente permiso = (PermisoAgente) obj;

        insert = "INSERT INTO permiso (OIDPermiso, NroPermiso, NombrePermiso)"
                + "VALUES '" + permiso.getOid() + "', '" + permiso.getNroPermiso() + "', '" + permiso.getNombrePermiso() + "'";

    return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        select = "SELECT * FROM permiso ";
        String condicion = "";
        //String caonsulta = "SELECT permiso.NroPermiso AS nropermiso, permiso.NombrePermiso AS nombrepermiso FROM permiso JOIN permisoperfiles ON permiso.OIDPermiso = permisoperfiles.OIDPermiso WHERE permisoperfiles.OIDPerfil = '"+ obj.getOid() +"'";
        if (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";

            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    condicion = condicion + " AND ";
                }
                if(criterios.get(i).getAtributo().equalsIgnoreCase("Perfil")){
                    criterios.get(i).setAtributo("OIDPerfil");
                    select += "JOIN permisoperfiles ON permiso.OIDPermiso = permisoperfiles.OIDPermiso ";
                    condicion += "permisoperfiles." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }else{
                    condicion += "permiso." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";

                }
            }
            select = select + condicion;
        }

        return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;


        selectOid = "SELECT * FROM permiso WHERE OIDPermiso = '" + oid + "'";

    return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        PermisoAgente permiso = (PermisoAgente) obj;

        update = "UPDATE permiso SET"
                + "OIDPermiso ='" + permiso.getOid() + "', "
                + "NroPermiso = " + permiso.getNroPermiso() + ", "
                + "NombrePermiso ='" + permiso.getNombrePermiso() + "'";

        return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                PermisoAgente nuevoPermiso = (PermisoAgente) FabricaEntidades.getInstancia().crearEntidad("Permiso");
                nuevoPermiso.setIsNuevo(false);
                nuevoPermiso.setOid(rs.getString("OIDPermiso"));
                nuevoPermiso.setNroPermiso(Integer.valueOf(rs.getString("NroPermiso")));
                nuevoPermiso.setNombrePermiso(rs.getString("NombrePermiso"));

                nuevosObjetos.add(nuevoPermiso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaModelo.class.getName()).log(Level.SEVERE, null, ex);
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
