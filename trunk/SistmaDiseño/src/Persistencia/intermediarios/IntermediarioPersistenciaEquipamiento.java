/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ElementoTrabajoAgente;
import Persistencia.Entidades.EquipamientoAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
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
public class IntermediarioPersistenciaEquipamiento extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {

        EquipamientoAgente equipamiento = (EquipamientoAgente) obj;

        String insert;

        insert = "INSERT INTO equipamiento (OIDElementoTrabajo, CodigoEquipamiento, NombreEquipamiento) "
                + "VALUES ('"+equipamiento.getOid()+"', "+String.valueOf(equipamiento.getcodigoEquipamiento())+", '"+equipamiento.getnombreEquipamiento()+"')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {
        String select;

        select = "SELECT * FROM equipamiento";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "equipamiento." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM equipamiento WHERE OIDElementoTrabajo = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        EquipamientoAgente equipamiento = (EquipamientoAgente) obj;

        String update;

        update = "UPDATE INTO equipamiento "
                + "SET OIDElementoTrabajo = "+equipamiento.getOid()+", "
                + "CodigoEquipamiento = "+String.valueOf(equipamiento.getcodigoEquipamiento())+", "
                + "NombreEquipamiento = '"+equipamiento.getnombreEquipamiento()+"'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                EquipamientoAgente nuevoEquipamiento = (EquipamientoAgente) FabricaEntidades.getInstancia().crearEntidad("Equipamiento");

                nuevoEquipamiento.setOid(rs.getString("OIDElementoTrabajo"));
                nuevoEquipamiento.setIsNuevo(false);
                nuevoEquipamiento.setcodigoEquipamiento(Integer.valueOf(rs.getString("CodigoEquipamiento")));
                nuevoEquipamiento.setnombreEquipamiento("NombreEquipamiento");


                nuevosObjetos.add(nuevoEquipamiento);

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

        ((EquipamientoAgente)objPer).setcodigosistemaexterno(padre.getcodigosistemaexterno());
        ((EquipamientoAgente)objPer).settipoelemento(padre.gettipoelemento());
    }
}
