/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.MarcaAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
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
public class IntermediarioPersistenciaMarca extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        MarcaAgente Marca = (MarcaAgente) obj;
        insert = "INSERT INTO marca (OIDMarca, CodigoMarca, NombreMarca)"
                + " VALUES ('" + Marca.getOid() + "' , '" + Marca.getcodigomarca() + "' , '" + Marca.getnombremarca() + ")";
    return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        select =  "SELECT * FROM marca WHERE " ;
        if(!criterios.isEmpty()){
            select = select + "WHERE";
            for(int i = 0; i < criterios.size(); i++){
                if(i>0){
                    select = select + "AND";
                   }
                select = select + "marca." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " ' " + criterios.get(i).getValor() + "'" ;

            }
        }
        return select; 
     }

    public String armarSelectOid(String oid) {

        String selectOid;
        
        selectOid = "SELECT * FROM marca WHERE OIDMarca = '" + oid + "'";
    
        return selectOid;
    }


    public String armarUpdate(ObjetoPersistente obj) {
        MarcaAgente marca = (MarcaAgente) obj;
        String update;

        update = "UPDATE marca"
                + "SET OIDMarca = '" + marca.getOid() + "',"
                + "CodigoMarca = '" + String.valueOf(marca.getcodigomarca()) + "',"
                + "NombreMarca = " + marca.getnombremarca() + "',";

        return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
       List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                MarcaAgente nuevamarca = (MarcaAgente) FabricaEntidades.getInstancia().crearEntidad("marca");
                nuevamarca.setIsNuevo(false);
                nuevamarca.setOid(rs.getString("OIDmarca"));
                nuevamarca.setcodigomarca(Integer.valueOf(rs.getString("CodigoMarca")));
                nuevamarca.setnombremarca(rs.getString("NombreMarca"));
                nuevosObjetos.add(nuevamarca);

            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaMarca.class.getName()).log(Level.SEVERE, null, ex);
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

