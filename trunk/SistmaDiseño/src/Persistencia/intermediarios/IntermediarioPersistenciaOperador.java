/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OperadorAgente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaOperador extends IntermediarioRelacional{

 private String oid;

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into operador (OIDOperador, Legajo, NombreOperador) values (OIDOperador, Legajo, NombreOperador)";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM operador";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }
                if(criterios.get(i).getAtributo().equalsIgnoreCase("Usuario"))
                    criterios.get(i).setAtributo("OIDUsuario");

                select = select + "operador." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM operador WHERE OIDOperador = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;

        return update = "update operador set OIDOperador =" + ",Legajo = " + "NombreOperador = " ;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                OperadorAgente nuevoOperador = (OperadorAgente) FabricaEntidades.getInstancia().crearEntidad("Operador");
                nuevoOperador.setIsNuevo(false);
                nuevoOperador.setOid(rs.getString("OIDOperador"));
                nuevoOperador.setlegajo(rs.getString("OIDOperador"));
                nuevoOperador.setnombreOperador(rs.getString("NombreOperador"));

                nuevosObjetos.add(nuevoOperador);

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

