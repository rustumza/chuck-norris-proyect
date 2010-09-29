/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Fabricas.FabricaAdaptadoresSistemaStock;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.TareaAgente;
import Persistencia.Entidades.Trabajo;
import Persistencia.Entidades.TrabajoAgente;
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
public class IntermediarioPersistenciaTarea extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        TareaAgente tarea = (TareaAgente) obj;
        String insert;

        insert = "INSERT INTO tarea (OIDTrabajo, CodigoTarea, DescripcionTarea) "
                + "VALUES ('"+tarea.getOid()+"', "+String.valueOf(tarea.getcodigoTarea())+", '"+tarea.getdescripciontarea()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM tarea";
        
        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "tarea." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }


        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;
        
        selectOid = "SELECT * FROM tarea WHERE OIDTrabajo = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        TareaAgente tarea = (TareaAgente) obj;
        String update;

        update = "UPDATE tarea "
                + "SET OIDTrabajo = '"+tarea.getOid()+"', "
                + "CodigoTarea = "+String.valueOf(tarea.getcodigoTarea())+", "
                + "DescripcionTarea = '"+tarea.getdescripciontarea()+"'" ;

        return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        try {
            while (rs.next()) {
                TareaAgente nuevaTarea = (TareaAgente) FabricaEntidades.getInstancia().crearEntidad("Tarea");

                nuevaTarea.setOid(rs.getString("OIDTrabajo"));
                nuevaTarea.setIsNuevo(false);
                nuevaTarea.setcodigoTarea(Integer.valueOf(rs.getString("CodigoTarea")));
                nuevaTarea.setdescripciontarea(rs.getString("DescripcionTarea"));

                nuevosObjetos.add(nuevaTarea);
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
        //busca el padre
        TrabajoAgente padre = (TrabajoAgente) FachadaInterna.getInstancia().buscar("Trabajo", objPer.getOid());

        ((TrabajoAgente)objPer).setNombreTrabajo(padre.getNombreTrabajo());
        ((TrabajoAgente)objPer).settiempoEstimadoTrabajo(padre.gettiempoEstimadoTrabajo());
        ((TrabajoAgente)objPer).settipotrabajo(padre.gettipotrabajo());
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        FachadaInterna.getInstancia().guardar("Trabajo", obj);
    }
}

