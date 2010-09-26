
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.DenuncianteAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaDenunciante extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        DenuncianteAgente denunciante = (DenuncianteAgente) obj;
        String insert;

        insert = "INSERT INTO denunciante (OIDDenunciante, Domicilio, Celular, Email, TelefonoFijo, OIDPersonaPadron, EstadoDeBaja) "
                + "VALUES ('" + denunciante.getOid() + "', '" + denunciante.getdomicilio() + "', '" + denunciante.getcelular() + "', '" + denunciante.getemail() + "', '" + denunciante.gettelefonofijo() + "', '" + denunciante.getOidPersonaPadron() + "', " + Boolean.toString(denunciante.isEstadoBaja()) + ")";

        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM denunciante ";

        if (!criterios.isEmpty()) {
            select = select + " WHERE ";

        if(criterios.get(0).getAtributo().equals("PersonaPadron")){
                select = select+"OIDPersonaPadron"+ criterios.get(0).getOperador()+"'"+criterios.get(0).getValor()+"'";
            }
        else{
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }
        }
        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM denunciante WHERE OIDDenunciante = '" + oid + "'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        DenuncianteAgente denunciante = (DenuncianteAgente) obj;

        String update;

        update = "UPDATE denunciante "
                + "SET OIDDenunciante = '"+denunciante.getOid()+ "', "
                + "Domicilio = '"+denunciante.getdomicilio()+"', "
                + "Celular = '"+denunciante.getcelular() + "', "
                + "Email = '"+denunciante.getemail()+"', "
                + "TelefonoFijo = '"+denunciante.gettelefonofijo()+"', "
                + "OIDPersonaPadron = '"+ denunciante.getOidPersonaPadron()+"'"
                + "WHERE OIDDenunciante ='"+denunciante.getOid()+ "'";
                

        return update;

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                DenuncianteAgente nuevoDenunciante = (DenuncianteAgente)FabricaEntidades.getInstancia().crearEntidad("Denunciante");

                nuevoDenunciante.setOid(rs.getString("OIDDenunciante"));
                nuevoDenunciante.setIsNuevo(false);
                nuevoDenunciante.setdomicilio(rs.getString("Domicilio"));
                nuevoDenunciante.setcelular(rs.getString("Celular"));
                nuevoDenunciante.setemail(rs.getString("Email"));
                nuevoDenunciante.settelefonofijo(rs.getString("TelefonoFijo"));
                nuevoDenunciante.setOidPersonaPadron(rs.getString("OIDPersonaPadron"));
                nuevoDenunciante.setPersonaPadronBuscado(false);
                nuevoDenunciante.setEstadoBaja(Boolean.parseBoolean(rs.getString("EstadoDeBaja")));

                nuevosObjetos.add(nuevoDenunciante);

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
