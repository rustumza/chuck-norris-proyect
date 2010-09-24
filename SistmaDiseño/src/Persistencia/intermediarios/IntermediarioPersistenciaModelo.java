/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ModeloAgente;
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
public class IntermediarioPersistenciaModelo extends IntermediarioRelacional{

 

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        ModeloAgente modelo = (ModeloAgente)obj;

        return insert = "INSERT INTO modelo (OIDModelo, OIDMarca, CodigoModelo, NombreModelo)"
                + "VALUES '" + modelo.getOid() + "','" + modelo.getOidMarca() + "', '" + modelo.getcodigomodelo() + "', '" + modelo.getnombremodelo()+"'";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        select = "SELECT * FROM modelo" ;
        String condicion = "";

        while (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";

            for(int i = 0; i< criterios.size(); i++){
                if(i>0){
                    condicion = condicion + " AND ";
                    }
                condicion = condicion + "modelo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }

        select = select + condicion;
        }

    return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;


        return selectOid = "SELECT * FROM modelo WHERE OIDModelo = '" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        ModeloAgente modelo = (ModeloAgente)obj;

         update = "UPDATE modelo SET"
                 + "OIDModelo ='" + modelo.getOid() + "', "
                 + "OIDMarca = '" + modelo.getOidMarca() + "', "
                 + "CodigoModelo = " + modelo.getcodigomodelo() + ", "
                 + "NombreModelo ='" + modelo.getnombremodelo() + "'";


         return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

    List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                ModeloAgente nuevoModelo = (ModeloAgente) FabricaEntidades.getInstancia().crearEntidad("Modelo");
                nuevoModelo.setIsNuevo(false);
                nuevoModelo.setOid(rs.getString("OIDModelo"));
                nuevoModelo.setOidMarca(rs.getString("OIDMarca"));
                nuevoModelo.setMarcaBuscado(false);
                nuevoModelo.setcodigomodelo(Integer.valueOf(rs.getString("CodigoModelo")));
                nuevoModelo.setnombremodelo(rs.getString("NombreModelo"));
            
                nuevosObjetos.add(nuevoModelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return nuevosObjetos;
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

