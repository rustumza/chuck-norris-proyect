/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.FallaTecnica;
import Persistencia.Entidades.FallaTecnicaAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.TrabajoAgente;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaFallaTecnica extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {

        FallaTecnicaAgente falla = (FallaTecnicaAgente) obj;
        String insert;

        insert = "INSERT INTO fallatecnica (OIDTrabajo, CodigoFallaTecnica, DescripcionFalla) "
                + "VALUES ('" + falla.getOid() + "', " + String.valueOf(falla.getcodigoFallaTecnica()) + ", '" + falla.getdescripcionfalla() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM fallatecnica";

        if (!criterios.isEmpty()) {
            
            if (criterios.get(0).getAtributo().equals("Denuncia")) {
                String join = " JOIN fallatecnicadenuncia ON fallatecnica.OIDTrabajo = fallatecnicadenuncia.OIDFallaTecnica";
                String condicion = " WHERE fallatecnicadenuncia.OIDDenuncia = '"+criterios.get(0).getValor()+"'";
                select = select + join + condicion;

            } else {
                
                select = select + " WHERE ";
                for (int i = 0; i < criterios.size(); i++) {
                    if (i > 0) {
                        select = select + " AND ";
                    }

                    select = select + "fallatecnica." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
                }
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM fallatecnica WHERE OIDTrabajo = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        FallaTecnicaAgente falla = (FallaTecnicaAgente) obj;
        String update;

        update = "UPDATE fallatecnica SET OIDTrabajo = '" + falla.getOid() + "', "
                + "CodigoFallaTecnica = " + String.valueOf(falla.getcodigoFallaTecnica()) + ", "
                + "DescripcionFalla = '" + falla.getdescripcionfalla() + "'";

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        try {
            while (rs.next()) {
                FallaTecnicaAgente nuevaFalla = (FallaTecnicaAgente) FabricaEntidades.getInstancia().crearEntidad("FallaTecnica");

                nuevaFalla.setOid(rs.getString("OIDTrabajo"));
                nuevaFalla.setIsNuevo(false);
                nuevaFalla.setcodigoFallaTecnica(Integer.valueOf(rs.getString("CodigoFallaTecnica")));
                nuevaFalla.setdescripcionfalla(rs.getString("DescripcionFalla"));

                nuevosObjetos.add(nuevaFalla);

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

        ((TrabajoAgente) objPer).setNombreTrabajo(padre.getNombreTrabajo());
        ((TrabajoAgente) objPer).settiempoEstimadoTrabajo(padre.gettiempoEstimadoTrabajo());
        ((TrabajoAgente) objPer).settipotrabajo(padre.gettipotrabajo());

    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        FachadaInterna.getInstancia().guardar("Trabajo", obj);
    }
}
