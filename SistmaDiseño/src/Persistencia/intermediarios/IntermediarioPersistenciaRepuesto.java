/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ElementoTrabajo;
import Persistencia.Entidades.ElementoTrabajoAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.RepuestoAgente;
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
public class IntermediarioPersistenciaRepuesto extends IntermediarioRelacional{


    public String armarInsert(ObjetoPersistente obj) {

        RepuestoAgente repuesto = (RepuestoAgente) obj;

        String insert;

        insert = "INSERT INTO repuesto (OIDElementoTrabajo, CodigoRepuesto, NombreRepuesto) "
                + "VALUES ('"+repuesto.getOid()+"', "+Integer.valueOf(repuesto.getcodigoRepuesto())+", '"+repuesto.getnombreRepuesto()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM repuesto";
        
        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "repuesto." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM repuesto WHERE OIDElementoTrabajo = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        RepuestoAgente repuesto = (RepuestoAgente) obj;

        String update;

        update = "UPDATE repuesto SET OIDElementoTrabajo = '"+repuesto.getOid()+ "', "
                + "CodigoRepuesto = "+String.valueOf(repuesto.getcodigoRepuesto())+", "
                + "NombreRepuesto = '"+repuesto.getnombreRepuesto()+"'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                RepuestoAgente nuevoRepuesto = (RepuestoAgente) FabricaEntidades.getInstancia().crearEntidad("Repuesto");

                nuevoRepuesto.setOid(rs.getString("OIDElementoTrabajo"));
                nuevoRepuesto.setIsNuevo(false);
                nuevoRepuesto.setcodigoRepuesto(rs.getInt("CodigoRepuesto"));
                nuevoRepuesto.setnombreRepuesto(rs.getString("NombreRepuesto"));

                nuevosObjetos.add(nuevoRepuesto);

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
        ElementoTrabajoAgente padre = (ElementoTrabajoAgente) FachadaInterna.getInstancia().buscar("ElementoTrabajo", objPer.getOid());

        ((RepuestoAgente)objPer).setcodigosistemaexterno(padre.getcodigosistemaexterno());
        ((RepuestoAgente)objPer).settipoelemento(padre.gettipoelemento());

    }
}

