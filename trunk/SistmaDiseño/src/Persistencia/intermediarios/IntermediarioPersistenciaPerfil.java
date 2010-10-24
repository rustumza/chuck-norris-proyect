/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.intermediarios;

import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.PerfilAgente;
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
public class IntermediarioPersistenciaPerfil extends IntermediarioRelacional{

     public String armarInsert(ObjetoPersistente obj) {
        String insert;
        PerfilAgente perfil = (PerfilAgente)obj;

        return insert = "INSERT INTO perfil (OIDPerfil, NroPerfil, NombrePerfil)"
                + "VALUES '" + perfil.getOid() + "','" + perfil.getNroPerfil() + "', '" + perfil.getNombrePerfil() + "'";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        select = "SELECT * FROM perfil" ;
        String condicion = "";

        if (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";

            for(int i = 0; i< criterios.size(); i++){
                if(i>0){
                    condicion = condicion + " AND ";
                    }
                condicion = condicion + "perfil." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }

        select = select + condicion;
        }

    return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;


        selectOid = "SELECT * FROM perfil WHERE OIDPerfil = '" + oid + "'";

    return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        PerfilAgente perfil = (PerfilAgente)obj;

         update = "UPDATE perfil SET"
                 + "OIDPerfil ='" + perfil.getOid() + "', "
                 + "NroPerfil = " + perfil.getNroPerfil() + ", "
                 + "NombrePerfil ='" + perfil.getNombrePerfil() + "'";


         return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

    List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                PerfilAgente nuevoPerfil = (PerfilAgente) FabricaEntidades.getInstancia().crearEntidad("Perfil");
                nuevoPerfil.setIsNuevo(false);
                nuevoPerfil.setOid(rs.getString("OIDPerfil"));
                nuevoPerfil.setNroPerfil(Integer.valueOf(rs.getString("NroPerfil")));
                nuevoPerfil.setNombrePerfil(rs.getString("NombrePerfil"));

                nuevosObjetos.add(nuevoPerfil);
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
