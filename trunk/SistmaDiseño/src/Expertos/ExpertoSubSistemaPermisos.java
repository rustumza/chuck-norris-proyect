/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import Excepciones.ExcepcionObjetoNoEncontrado;
import Persistencia.Entidades.Operador;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.Usuario;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ExpertoSubSistemaPermisos implements Experto {

    public Operador buscarOperador(String nombreUsuario, String clave) throws ExcepcionObjetoNoEncontrado {

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("NombreUsuario", "=", nombreUsuario));
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("Clave", "=", clave));



        List<SuperDruperInterfaz> listaInterfaces = FachadaExterna.getInstancia().buscar("Usuario", listaCriterios);

        if (listaInterfaces.isEmpty()) {
            ExcepcionObjetoNoEncontrado excep = new ExcepcionObjetoNoEncontrado();
            excep.setMensaje("Usuario o Clave Incorrecta.");
            throw excep;
        } else {
            Usuario usuarioEncontrado = (Usuario) listaInterfaces.get(0);

            listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("Usuario", "=", usuarioEncontrado));

            listaInterfaces = FachadaExterna.getInstancia().buscar("Operador", listaCriterios);

            return (Operador) listaInterfaces.get(0);
        }

    }
}
