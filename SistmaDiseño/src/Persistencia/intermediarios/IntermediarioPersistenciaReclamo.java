/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.Caso;
import Persistencia.Entidades.CasoAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.ReclamoAgente;
import Persistencia.ExpertosPersistencia.FachadaInterna;
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
public class IntermediarioPersistenciaReclamo extends IntermediarioRelacional{

    public String armarInsert(ObjetoPersistente obj) {
        ReclamoAgente reclamo = (ReclamoAgente)obj;
        String insert;

        return insert = "INSERT INTO reclamo (OIDCaso, CodigoReclamo, OIDDenuncia) "
                + "VALUES ('"+reclamo.getOid()+"', '"+reclamo.getcodigoreclamo()+"', '"+reclamo.getOidDenuncia()+"')";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;

        select = "SELECT * FROM reclamo";
        
        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + " AND ";
                }

                select = select + "reclamo." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
        }

        return select;

    }

    public String armarSelectOid(String oid) {

        String selectOid;

        selectOid = "SELECT * FROM reclamo WHERE OIDCaso = '"+oid+"'";

        return selectOid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        ReclamoAgente reclamo = (ReclamoAgente)obj;
        String update;

        return update = "UPDATE reclamo "
                + "SET OIDCaso = '"+reclamo.getOid()+ "', "
                + "CodigoReclamo = "+String.valueOf(reclamo.getcodigoreclamo())+", "
                + "OIDDenuncia = '"+reclamo.getOidDenuncia()+"'"
                + " WHERE OIDCaso = '" + reclamo.getOid() + "'";

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                ReclamoAgente nuevoReclamo = (ReclamoAgente) FabricaEntidades.getInstancia().crearEntidad("Reclamo");

                nuevoReclamo.setOid(rs.getString("OIDCaso"));
                nuevoReclamo.setIsNuevo(false);
                nuevoReclamo.setcodigoreclamo(Integer.valueOf(rs.getString("CodigoReclamo")));
                nuevoReclamo.setOidDenuncia(rs.getString("OIDDenuncia"));

                nuevosObjetos.add(nuevoReclamo);


            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaDenuncia.class.getName()).log(Level.SEVERE, null, ex);
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
        CasoAgente padre = (CasoAgente) FachadaInterna.getInstancia().buscar("Caso", objPer.getOid());
        
        ((CasoAgente)objPer).setOidDenunciante(padre.getOidDenunciante());
        ((CasoAgente)objPer).setDenuncianteBuscado(false);
        ((CasoAgente)objPer).setOidOperador(padre.getOidOperador());
        ((CasoAgente)objPer).setOperadorBuscado(false);
        ((CasoAgente)objPer).setfechacaso(padre.getfechacaso());
        ((CasoAgente)objPer).settipocaso(padre.gettipocaso());
        ((CasoAgente)objPer).setOidSemaforo(padre.getOidSemaforo());
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        FachadaInterna.getInstancia().guardar("Caso", obj);
    }
}

