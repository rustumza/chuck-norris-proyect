
package Persistencia.ExpertosPersistencia;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Fabricas.FabricaIntermediarios;
import Persistencia.Fabricas.FabricaEntidades;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class FachadaInterna {

    private static FachadaInterna instancia = null;

    public static FachadaInterna getInstancia() {
        if (instancia == null) {
            instancia = new FachadaInterna();
        }
        return instancia;
    }

    private FachadaInterna(){

    }

    public void guardar(String nombre, ObjetoPersistente obj) {

        FabricaIntermediarios.getInstancia().crearIntermediario(nombre).guardar(obj);

    }

    
    public List<SuperDruperInterfaz> buscar(String entidad, List<Criterio> listaCriterios) {

        if(listaCriterios==null)
            listaCriterios = new ArrayList<Criterio>();
        ArrayList<ObjetoPersistente> aux = (ArrayList<ObjetoPersistente>) FabricaIntermediarios.getInstancia().crearIntermediario(entidad).buscar(listaCriterios);
        List<SuperDruperInterfaz> objetoPeristenteInter = new ArrayList<SuperDruperInterfaz>();
        for(ObjetoPersistente op : aux){
        
            objetoPeristenteInter.add((SuperDruperInterfaz)op);
        
        }
            
        return  objetoPeristenteInter;
    }

    public SuperDruperInterfaz crearEntidad(String nombre){
        return (SuperDruperInterfaz)FabricaEntidades.getInstancia().crearEntidad(nombre);
    }

    public Criterio crearCriterio(String atributo, String operador, String valor){

         return FabricaCriterios.getInstancia().crearCriterio(atributo, operador, valor);

    }

    public Criterio crearCriterio(String atributo, String operador, ObjetoPersistente valor){

        return FabricaCriterios.getInstancia().crearCriterio(atributo, operador, valor);

    }


    public SuperDruperInterfaz buscar(String nombreEntidad,String OID){

        return (SuperDruperInterfaz)FabricaIntermediarios.getInstancia().crearIntermediario(nombreEntidad).buscar(OID);

    }

    public void iniciarTransaccion(){
    
        Conexion.getInstance().iniciarTransaccion();
    }

    public void confirmarTransaccion(){
        Conexion.getInstance().confirmarTransaccion();
    }

    public void deshacerTransaccion(){
        Conexion.getInstance().deshacerTransaccion();
    }
}
