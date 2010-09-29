package Persistencia.intermediarios;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Conexion;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.generadorOid;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public abstract class IntermediarioRelacional extends IntermediarioPersistencia{

    @Override
    public void desmaterializar(ObjetoPersistente obj) {

        String consulta = null;
        if(obj.isIsNuevo()){
            obj.setOid((generadorOid.getInstance().generarOid()));
            guardarDatosPadre(obj);
            guardarObjetosRelacionados(obj);
            consulta = armarInsert(obj);

        }else{
            consulta = armarUpdate(obj);
        }

        //Imprime por pantalla la consulta
        System.out.println(consulta);
        
        Conexion.getInstance().insert(consulta);

        guardarObjetoCompuesto(obj);

        

    }

    @Override
    public List<ObjetoPersistente> materializar(List<Criterio> criterios){
        List<ObjetoPersistente> objetosEncontrados = new ArrayList<ObjetoPersistente>();

        String consulta = armarSelect(criterios);
        //muestra la consulta
        System.out.println(consulta);

        ResultSet rs = Conexion.getInstance().select(consulta);

        objetosEncontrados = convertirRegistrosAObjetos(rs);

        for (ObjetoPersistente objPer : objetosEncontrados) {
            setearDatosPadre(objPer, criterios);
        }

        for (ObjetoPersistente objPer : objetosEncontrados) {
            buscarObjRelacionados(objPer);
        }

        return objetosEncontrados;
    }

    @Override
    public ObjetoPersistente materializar(String oid){

        ObjetoPersistente objetoEncontrado;
        List<ObjetoPersistente> objetoRetornado = new ArrayList<ObjetoPersistente>();

        String consulta = armarSelectOid(oid);
        System.out.println(consulta);
        ResultSet rs = Conexion.getInstance().select(consulta);

        objetoRetornado = convertirRegistrosAObjetos(rs);

        objetoEncontrado = (ObjetoPersistente) objetoRetornado.get(0);

        setearDatosPadre(objetoEncontrado, null);
        buscarObjRelacionados(objetoEncontrado);
                
        return objetoEncontrado;
    }

    public ResultSet ejecutarSelect(String consulta){
        return Conexion.getInstance().select(consulta);
    }
    public abstract String armarInsert(ObjetoPersistente obj);
    public abstract String armarSelect(List<Criterio> criterios);
    public abstract String armarSelectOid(String oid);
    public abstract String armarUpdate(ObjetoPersistente obj);
    public abstract void guardarObjetoCompuesto(ObjetoPersistente obj);
    public abstract List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs);

    public abstract void guardarObjetosRelacionados(ObjetoPersistente obj);
    public abstract void buscarObjRelacionados(ObjetoPersistente obj);

    public abstract  void setearDatosPadre(ObjetoPersistente objPer,List<Criterio> listacCriterios);

    public abstract void guardarDatosPadre(ObjetoPersistente obj);

   

}
