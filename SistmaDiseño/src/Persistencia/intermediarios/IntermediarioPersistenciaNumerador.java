/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.Numerador;
import Persistencia.Entidades.NumeradorAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sun.management.Agent;

/**
 *
 * @author Eduardo
 */
public class IntermediarioPersistenciaNumerador extends IntermediarioRelacional {

    private String oid;

    public String armarInsert(ObjetoPersistente obj) {
        String insert;

        return insert = "insert into numerador (OIDNumeradores, TipoDocumentacion, UltimoNumeroRegistrado) values (OIDNumeradores, TipoDocumentacion, UltimoNumeroRegistrado)";
    }

    public String armarSelect(List<Criterio> criterios) {

        String select = "SELECT * FROM numerador";
        if (!criterios.isEmpty()) {
            select = select + " WHERE ";
            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    select = select + "AND";
                }
                select = select + "numerador." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";

            }
        }
        return select;




    }

    public String armarSelectOid(String oid) {

        String selectOid;
        this.oid = oid;

        return selectOid = "select * from numerador where OIDNumeradores = " + oid;
    }

    public String armarUpdate(ObjetoPersistente obj) {

        NumeradorAgente numerador = (NumeradorAgente)obj;
        String update;

        return update = "update numerador set OIDNumeradores = '" +numerador.getOid()+ "' , TipoDocumentacion = '" + numerador.gettipodocumentacion() + "' , UltimoNumeroRegistrado = " + numerador.getultimonumeroregistrado() + " WHERE OIDNumeradores = '" + numerador.getOid() +"'";

    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                NumeradorAgente nuevoNumerador = (NumeradorAgente) FabricaEntidades.getInstancia().crearEntidad("Numerador");
                nuevoNumerador.setIsNuevo(false);
                nuevoNumerador.setOid(rs.getString("OIDNumeradores"));
                nuevoNumerador.settipodocumentacion(rs.getString("TipoDocumentacion"));
                nuevoNumerador.setultimonumeroregistrado(rs.getInt("UltimoNumeroRegistrado"));

                nuevosObjetos.add(nuevoNumerador);

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
