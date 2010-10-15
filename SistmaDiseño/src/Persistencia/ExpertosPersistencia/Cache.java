package Persistencia.ExpertosPersistencia;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Persistencia.Entidades.ObjetoPersistente;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class Cache {

    private static Cache instancia = null;
    private static HashMap<String, ObjetoPersistente> listaObjetos = null;

    public static Cache getInstancia() {
        if (instancia == null) {
            instancia = new Cache();
            listaObjetos = new HashMap<String, ObjetoPersistente>();
        }
        return instancia;
    }

    public void almacenar(String oid, ObjetoPersistente objeto) {
        if (listaObjetos == null) {
            listaObjetos = new HashMap<String, ObjetoPersistente>();
        }
        listaObjetos.put(oid, objeto);
    }

    public ObjetoPersistente traerObjeto(String oid) {

        if (listaObjetos == null) {
            return null;
        } else {
            return listaObjetos.get(oid);
        }

    }

    public void eliminarObjeto(String oid) {

        listaObjetos.remove(oid);
    }

    public boolean seEncuentra(String oid) {

        return listaObjetos.containsKey(oid);
    }
}
