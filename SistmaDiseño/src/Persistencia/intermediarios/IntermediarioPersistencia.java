package Persistencia.intermediarios;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Cache;
import Persistencia.ExpertosPersistencia.Criterio;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author diego
 */
public abstract class IntermediarioPersistencia {

    public void guardar(ObjetoPersistente obj){
        

        desmaterializar(obj);

        Cache.getInstancia().eliminarObjeto(obj.getOid());


        
    };

    public List<ObjetoPersistente> buscar(List<Criterio> criterios){
        List<ObjetoPersistente> objetosEncontrados = new ArrayList<ObjetoPersistente>();

        objetosEncontrados = materializar(criterios);

        for (ObjetoPersistente objetoPersist : objetosEncontrados) {
            Cache.getInstancia().almacenar(objetoPersist.getOid(),objetoPersist);
        }
        //List<SuperDruperInterfaz> oe = objetosEncontrados;
        return objetosEncontrados;
    }

    public ObjetoPersistente buscar(String oid){
         ObjetoPersistente objetoEncontrado = null;

         objetoEncontrado = Cache.getInstancia().traerObjeto(oid);

         if(objetoEncontrado == null){
            objetoEncontrado = materializar(oid);
            Cache.getInstancia().almacenar(objetoEncontrado.getOid(),objetoEncontrado);
         }
         
         return objetoEncontrado;
    }

    

    protected abstract void desmaterializar(ObjetoPersistente obj);
    protected abstract List<ObjetoPersistente> materializar(List<Criterio> criterios);
    protected abstract ObjetoPersistente materializar(String oid);

}
