/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.PersonaPadron;
import Persistencia.Entidades.PersonaPadronAgente;
import Persistencia.Entidades.PersonaPadronEstado;
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
public class IntermediarioPersistenciaPersonaPadron extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {

        PersonaPadronAgente personaPadron = (PersonaPadronAgente) obj;
        String insert;

        insert = "INSERT INTO personapadron (OIDPersonaPadron, Apellido, Nombre, Domicilio, NroDocumento, TipoDocumento) "
                + "VALUES ('" + personaPadron.getOid() + "', '" + personaPadron.getapellido() + "', '" + personaPadron.getnombre() + "', '" + personaPadron.getdomicilio() + "', '" + personaPadron.getNroDocumento() + "', '" + personaPadron.gettipoDocumento() + "')";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM personapadron";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "personapadron." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM personapadron WHERE OIDPersonaPadron = '" + oid + "'";

        return selectOid;

    }

    public String armarUpdate(ObjetoPersistente obj) {


        PersonaPadronAgente personaPadron = (PersonaPadronAgente) obj;
        String update;

        return update = "UPDATE personapadron SET OIDPersonaPadron ='" + personaPadron.getOid() + "', "
                + "Apellido = '" + personaPadron.getapellido() + "', "
                + "Nombre = '" + personaPadron.getnombre() + "',"
                + "Domicilio = '" + personaPadron.getdomicilio() + "', "
                + "NroDocumento = '" + personaPadron.getNroDocumento() + "', "
                + "TipoDocumento ='" + personaPadron.gettipoDocumento() + "'";

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
        for (PersonaPadronEstado personaPadronEstado : ((PersonaPadron)obj).getPersonaPadronEstado()) {
            FachadaInterna.getInstancia().guardar("PersonaPadronEstado", (ObjetoPersistente) personaPadronEstado);
        }
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                PersonaPadronAgente nuevaPersonaPadron = (PersonaPadronAgente) FabricaEntidades.getInstancia().crearEntidad("PersonaPadron");

                nuevaPersonaPadron.setOid(rs.getString("OIDPersonaPadron"));
                nuevaPersonaPadron.setIsNuevo(false);
                nuevaPersonaPadron.setapellido(rs.getString("Apellido"));
                nuevaPersonaPadron.setnombre(rs.getString("Nombre"));
                nuevaPersonaPadron.setdomicilio(rs.getString("Domicilio"));
                nuevaPersonaPadron.setNroDocumento(rs.getString("NroDocumento"));
                nuevaPersonaPadron.settipoDocumento(rs.getString("TipoDocumento"));
                nuevaPersonaPadron.setPersonaPadronEstadoBuscado(false);

                nuevosObjetos.add(nuevaPersonaPadron);

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
}
