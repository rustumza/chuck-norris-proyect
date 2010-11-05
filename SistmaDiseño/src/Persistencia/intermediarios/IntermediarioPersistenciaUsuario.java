/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Perfil;
import Persistencia.Entidades.PerfilAgente;
import Persistencia.Entidades.PerfilImplementacion;
import Persistencia.Entidades.Permiso;
import Persistencia.Entidades.PermisoAgente;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.UsuarioAgente;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import Persistencia.Fabricas.FabricaEntidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class IntermediarioPersistenciaUsuario extends IntermediarioRelacional {

    public String armarInsert(ObjetoPersistente obj) {
        String insert;
        UsuarioAgente usuario = (UsuarioAgente) obj;

        insert = "INSERT INTO usuario (OIDUsuario, OIDPerfil, NroUsuario, NombreUsuario, Clave)"
                + "VALUES '" + usuario.getOid() + "','" + usuario.getOidPerfil() + "', '" + usuario.getNroUsuario() + "', '" + usuario.getNombreUsuario() + "', '" + usuario.getClave() + "'";
        return insert;
    }

    public String armarSelect(List<Criterio> criterios) {

        String select;
        select = "SELECT * FROM usuario";
        String condicion = "";

        if (!criterios.isEmpty()) {
            condicion = condicion + " WHERE ";

            for (int i = 0; i < criterios.size(); i++) {
                if (i > 0) {
                    condicion = condicion + " AND ";
                }
                condicion = condicion + "usuario." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }

            select = select + condicion;
        }

        return select;
    }

    public String armarSelectOid(String oid) {

        String selectOid;


        return selectOid = "SELECT * FROM usuario WHERE OIDUsuario = '" + oid + "'";
    }

    public String armarUpdate(ObjetoPersistente obj) {

        String update;
        UsuarioAgente usuario = (UsuarioAgente) obj;

        update = "UPDATE usuario SET"
                + "OIDUsuario ='" + usuario.getOid() + "', "
                + "OIDPerfil = '" + usuario.getOidPerfil() + "', "
                + "NroUsuario = " + usuario.getNroUsuario() + ", "
                + "NombreUsuario ='" + usuario.getNombreUsuario() + "', "
                + "Clave = '" + usuario.getClave() + "'";


        return update;
    }

    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {
                UsuarioAgente nuevoUsuario = (UsuarioAgente) FabricaEntidades.getInstancia().crearEntidad("Usuario");

                nuevoUsuario.setIsNuevo(false);
                nuevoUsuario.setOid(rs.getString("OIDUsuario"));
                nuevoUsuario.setOidPerfil(rs.getString("OIDPerfil"));
                nuevoUsuario.setPerfilBuscado(false);
                nuevoUsuario.setNroUsuario(Integer.valueOf(rs.getString("NroUsuario")));
                nuevoUsuario.setNombreUsuario(rs.getString("NombreUsuario"));
                nuevoUsuario.setClave(rs.getString("Clave"));

                nuevosObjetos.add(nuevoUsuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntermediarioPersistenciaModelo.class.getName()).log(Level.SEVERE, null, ex);
        }


        return nuevosObjetos;
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
    }

    @Override
    public void buscarObjRelacionados(ObjetoPersistente obj) {
        UsuarioAgente usuario = (UsuarioAgente) obj;
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FachadaInterna.getInstancia().crearCriterio("OIDPerfil", "=", usuario.getOidPerfil()));
        Perfil perfil = (Perfil) FachadaInterna.getInstancia().buscar("Perfil", listaCriterios).get(0);

        /*for(SuperDruperInterfaz objetoEncontrado : FachadaInterna.getInstancia().buscar("Permiso", listaCriterios)){
           perfil.addPermiso((Permiso)objetoEncontrado);
        }*/
        usuario.setPerfil(perfil);
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listaCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
}
