package Persistencia.ExpertosPersistencia;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Persistencia.Entidades.DenunciaEstado;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.ObjetoPersistente;
import java.util.List;

/**
 *
 * @author diego
 */
public class FachadaExterna {

    private static FachadaExterna instancia = null;

    public static FachadaExterna getInstancia(){
        if (instancia == null)
            instancia = new FachadaExterna();
        return instancia;
    }

    private FachadaExterna(){

    }

    public void guardar(String nombreClase, SuperDruperInterfaz obj){
       FachadaInterna.getInstancia().guardar(nombreClase, (ObjetoPersistente)obj);
    }

    public SuperDruperInterfaz crearEntidad(String nombre){
        return FachadaInterna.getInstancia().crearEntidad(nombre);
    }

    public Criterio crearCriterio(String atributo, String operador, String valor){

        return FachadaInterna.getInstancia().crearCriterio(atributo, operador, valor);

    }

       public Criterio crearCriterio(String atributo, String operador, SuperDruperInterfaz valor){

        return FachadaInterna.getInstancia().crearCriterio(atributo, operador, (ObjetoPersistente)valor);

    }

       public List<DenunciaEstado> getEstados(){



           return null;
       }

    public List<SuperDruperInterfaz> buscar(String nombreEntidad, List<Criterio> listaCriterios) {
          return FachadaInterna.getInstancia().buscar(nombreEntidad, listaCriterios);
    }

}
