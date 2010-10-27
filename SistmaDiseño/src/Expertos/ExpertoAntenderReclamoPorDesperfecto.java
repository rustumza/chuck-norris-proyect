 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import DTO.DTOProblemasDelSemaforo;
import DTO.DTOinfoParaCrearDenuncia;
import Excepciones.ExcepcionDenunciaExistente;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Fabricas.FabricaDeEstrategiaCalcularPrioridad;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.Calle;
import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.DenunciaEstado;
import Persistencia.Entidades.Denunciante;
import Persistencia.Entidades.EstadoDenuncia;
import Persistencia.Entidades.Interseccion;
import Persistencia.Entidades.Numerador;
import Persistencia.Entidades.PersonaPadron;
import Persistencia.Entidades.Problema;
import Persistencia.Entidades.Reclamo;
import Persistencia.Entidades.Semaforo;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.Ubicacion;
import Persistencia.Entidades.UbicacionSimple;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LEIVA
 */
public class ExpertoAntenderReclamoPorDesperfecto implements Experto{

    public Denunciante buscarDenunciante(String dni) throws ExcepcionObjetoNoEncontrado{
        Criterio criterio = FachadaExterna.getInstancia().crearCriterio("NroDocumento", "=", dni);
        List<Criterio> listaDeCriterios = new ArrayList<Criterio>();
        listaDeCriterios.add(criterio);
        List<SuperDruperInterfaz> listaDeInterfaces = FachadaExterna.getInstancia().buscar("PersonaPadron", listaDeCriterios);
        if(listaDeInterfaces.isEmpty()){
             ExcepcionObjetoNoEncontrado e = new ExcepcionObjetoNoEncontrado();
             e.setMensaje("Denunciante no encontrado");
             throw e;
        }
        else{
            PersonaPadron perspad = (PersonaPadron) listaDeInterfaces.get(0);
            criterio = FachadaExterna.getInstancia().crearCriterio("PersonaPadron", "=", perspad);
            List<Criterio> listaDeCriterios2 = new ArrayList<Criterio>();
            listaDeCriterios2.add(criterio);
            listaDeInterfaces = FachadaExterna.getInstancia().buscar("Denunciante", listaDeCriterios2);
            if(!listaDeInterfaces.isEmpty()){
                return (Denunciante)listaDeInterfaces.get(0);
            }

            else{
                Denunciante denun = (Denunciante)FachadaExterna.getInstancia().crearEntidad("Denunciante");
                denun.setPersonaPadron(perspad);
                return denun;
            }
        }
      
    }


    public void guardarDenunciante(Denunciante denunciante){

        FachadaExterna.getInstancia().guardar("Denunciante", denunciante);

    }



    public List<Calle> buscarCalle(String calle){

        Criterio criterio = FachadaExterna.getInstancia().crearCriterio("NombreCalle", "LIKE", calle);
        List<Criterio> listaDeCriterios = new ArrayList<Criterio>();
        listaDeCriterios.add(criterio);
        List<SuperDruperInterfaz> listaSuperDruperInterfaz = FachadaExterna.getInstancia().buscar("Calle", listaDeCriterios);
        List<Calle> listaCalles = new ArrayList<Calle>();
        for(SuperDruperInterfaz aux : listaSuperDruperInterfaz){
            listaCalles.add((Calle) aux);
        }
        return listaCalles;
    }

    public List<Integer> buscarAltura(Calle calle){

        Criterio criterio = FachadaExterna.getInstancia().crearCriterio("calle", "=", calle);
        List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
        listaDeCriterio.add(criterio);
        List<SuperDruperInterfaz> listaDeInterfaces = FachadaExterna.getInstancia().buscar("UbicacionSimple", listaDeCriterio);
        List<Integer> listaDeAlturas = new ArrayList<Integer>();
        for(int i = 0; i < listaDeInterfaces.size(); i++){
            listaDeAlturas.add(((UbicacionSimple)listaDeInterfaces.get(i)).getaltura());
        }


        return listaDeAlturas;
    }

    public List<Semaforo> buscarSemaforo(Calle calle1, Calle calle2){


        //Busco todas las intersecciones de la calle 1
        List<Criterio> criterioBuscarInterseccion = new ArrayList<Criterio>();
        criterioBuscarInterseccion.add(FachadaExterna.getInstancia().crearCriterio("Calle", "=", calle1));
        List<SuperDruperInterfaz> listaSuperDruperInterfaz = FachadaExterna.getInstancia().buscar("Interseccion", criterioBuscarInterseccion);
        List<Interseccion> listaInterseccionCalle1 = new ArrayList<Interseccion>();
        for (SuperDruperInterfaz aux : listaSuperDruperInterfaz) {
            listaInterseccionCalle1.add((Interseccion) aux);
        }
        //busco todas las intersecciones de la calle 2
        criterioBuscarInterseccion = new ArrayList<Criterio>();
        criterioBuscarInterseccion.add(FachadaExterna.getInstancia().crearCriterio("Calle", "=", calle2));
        listaSuperDruperInterfaz = FachadaExterna.getInstancia().buscar("Interseccion", criterioBuscarInterseccion);
        List<Interseccion> listaInterseccionCalle2 = new ArrayList<Interseccion>();
        for (SuperDruperInterfaz aux : listaSuperDruperInterfaz) {
            listaInterseccionCalle2.add((Interseccion) aux);
        }
        Interseccion interseccionAUsar = null;
        //comparar intersecciones
        for (Interseccion interseccion1 : listaInterseccionCalle1) {
            for (Interseccion interseccion2 : listaInterseccionCalle2) {
                if(interseccion1.getcodigoubicacion() == interseccion2.getcodigoubicacion());
                    interseccionAUsar = interseccion1;
                    break;
            }
            if(interseccionAUsar!= null)
                break;
        }

        if(interseccionAUsar!=null){
            //mandar excepcion porqeu esas calles no se intersectarn
        }
        
        Criterio criterioBuscarSemaforo = FachadaExterna.getInstancia().crearCriterio("Interseccion", "=", interseccionAUsar);
        List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
        listaDeCriterio.add(criterioBuscarSemaforo);
        List<SuperDruperInterfaz> listaDeInterfaz = FachadaExterna.getInstancia().buscar("Semaforo", listaDeCriterio);
        List<Semaforo> listaSemaforos = new ArrayList<Semaforo>();
        for(SuperDruperInterfaz aux : listaDeInterfaz)
            listaSemaforos.add((Semaforo) aux);
        return listaSemaforos;
    }

    public List<Semaforo> buscarSemaforo(Calle calle1, int altura){

        //Busco todas las intersecciones de la calle 1
        List<Criterio> criterioBuscarInterseccion = new ArrayList<Criterio>();
        criterioBuscarInterseccion.add(FachadaExterna.getInstancia().crearCriterio("Calle", "=", calle1));
        criterioBuscarInterseccion.add(FachadaExterna.getInstancia().crearCriterio("altura", "=", String.valueOf(altura)));
        List<SuperDruperInterfaz> listaSuperDruperInterfaz = FachadaExterna.getInstancia().buscar("UbicacionSimple", criterioBuscarInterseccion);
        Ubicacion ubicacionSimpleAUsar = (Ubicacion) listaSuperDruperInterfaz.get(0);
        
        Criterio criterioBuscarSemaforo = FachadaExterna.getInstancia().crearCriterio("UbicacionSimple", "=", ubicacionSimpleAUsar);
        List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
        listaDeCriterio.add(criterioBuscarSemaforo);
        List<SuperDruperInterfaz> listaDeInterfaz = FachadaExterna.getInstancia().buscar("Semaforo", listaDeCriterio);
        List<Semaforo> listaSemaforos = new ArrayList<Semaforo>();
        for(SuperDruperInterfaz aux : listaDeInterfaz)
            listaSemaforos.add((Semaforo) aux);


        return listaSemaforos;
    }




    public List<Problema> buscarProblemas() {
        List<SuperDruperInterfaz> listaDeInterfaces = FachadaExterna.getInstancia().buscar("Problema", null);
        List<Problema> listaDeProblema = new ArrayList<Problema>();
        for(SuperDruperInterfaz aux : listaDeInterfaces){
            listaDeProblema.add((Problema) aux);
        }
        return listaDeProblema;
    }

    public void guardarDenuncia(DTOinfoParaCrearDenuncia dtoInfoParaCrearDenuncia) throws ExcepcionDenunciaExistente{


        Criterio crit = FachadaExterna.getInstancia().crearCriterio("Semaforo", "=", dtoInfoParaCrearDenuncia.getProblemasDelSemaforo().get(0).getSemaforo());
        List<Criterio> listaDeCriterios = new ArrayList<Criterio>();
        listaDeCriterios.add(crit);
        List<SuperDruperInterfaz> listaDeInterfaces = FachadaExterna.getInstancia().buscar("Ubicacion", listaDeCriterios);
        Ubicacion ubicacion = (Ubicacion)listaDeInterfaces.get(0);
        crit = FachadaExterna.getInstancia().crearCriterio("Ubicacion", "=", ubicacion);
        listaDeCriterios = new ArrayList<Criterio>();
        listaDeCriterios.add(crit);
        listaDeInterfaces = FachadaExterna.getInstancia().buscar("Semaforo", listaDeCriterios);
        List<Semaforo> listaDeSemaforo = new ArrayList<Semaforo>();
        for (SuperDruperInterfaz superDruperInterfaz : listaDeInterfaces) {
            listaDeSemaforo.add((Semaforo) superDruperInterfaz);
        }
        Denuncia denunciaAUsar = null;
        for (Semaforo semaforo : listaDeSemaforo) {
            listaDeCriterios = new ArrayList<Criterio>();
            crit = FachadaExterna.getInstancia().crearCriterio("Semaforo", "=", semaforo);
            listaDeCriterios.add(crit);
            listaDeInterfaces = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterios);
            List<Denuncia> listaDeDenuncia = new ArrayList<Denuncia>();
            for (SuperDruperInterfaz superDruperInterfaz : listaDeInterfaces) {
                listaDeDenuncia.add((Denuncia) superDruperInterfaz);
            }
            for (Denuncia denuncia : listaDeDenuncia) {
                for (DenunciaEstado denEst : denuncia.getDenunciaEstado()) {
                    if(denEst.isindicadorestadoactual() & denEst.getEstadoDenuncia().getnombreestado().equalsIgnoreCase("Pendiente")){
                        denunciaAUsar = denuncia;
                        break;
                    }
                    else if(denEst.isindicadorestadoactual() & !denEst.getEstadoDenuncia().getnombreestado().equalsIgnoreCase("Cerrada"))
                        throw new ExcepcionDenunciaExistente();
                }
                if(denunciaAUsar!=null)
                    break;
            }

        }

        if(denunciaAUsar!=null){
        //hacer reclamo
            Reclamo reclamo = (Reclamo)FachadaExterna.getInstancia().crearEntidad("Reclamo");
            reclamo.setDenunciante(dtoInfoParaCrearDenuncia.getDenunciante());
            reclamo.setOperador(dtoInfoParaCrearDenuncia.getOperador());

            List<Criterio> listCrit = new ArrayList<Criterio>();
            listCrit.add(FachadaExterna.getInstancia().crearCriterio("TipoDocumentacion", "=" , "Reclamo"));
            List<SuperDruperInterfaz> listDeInterf = FachadaExterna.getInstancia().buscar("Numerador", listCrit);
            Numerador numerador = (Numerador)listDeInterf.get(0);
            numerador.setultimonumeroregistrado(numerador.getultimonumeroregistrado()+1);
            FachadaExterna.getInstancia().guardar("Numerador", numerador);
            reclamo.setcodigoreclamo(numerador.getultimonumeroregistrado());
            reclamo.setfechacaso(new Date());
            reclamo.settipocaso("RECLAMO");
            reclamo.setProblema(new ArrayList<Problema>());
            for (DTOProblemasDelSemaforo dTOProblemasDelSemaforo : dtoInfoParaCrearDenuncia.getProblemasDelSemaforo()) {
                reclamo.getProblema().addAll(dTOProblemasDelSemaforo.getListaDeProblemas());
                reclamo.getSemaforo().add(dTOProblemasDelSemaforo.getSemaforo());
            }
            if(denunciaAUsar.getReclamo().isEmpty())
                denunciaAUsar.setReclamo(new ArrayList<Reclamo>());

            denunciaAUsar.getReclamo().add(reclamo);
            
            denunciaAUsar.setprioridad(FabricaDeEstrategiaCalcularPrioridad.getInstace().crearEstrategiaDeCalculoDePrioridadDenuncia().calcularPrioridad(denunciaAUsar, ubicacion));

            
        }else{
            //hacer una denuncia nueva
            denunciaAUsar = (Denuncia) FachadaExterna.getInstancia().crearEntidad("Denuncia");
            denunciaAUsar.setDenunciante(dtoInfoParaCrearDenuncia.getDenunciante());
            denunciaAUsar.setOperador(dtoInfoParaCrearDenuncia.getOperador());
            denunciaAUsar.settipocaso("DENUNCIA");
            denunciaAUsar.setfechacaso(new Date());
            List<Criterio> listCrit = new ArrayList<Criterio>();
            listCrit.add(FachadaExterna.getInstancia().crearCriterio("TipoDocumentacion", "=" , "Denuncia"));
            List<SuperDruperInterfaz> listDeInterf = FachadaExterna.getInstancia().buscar("Numerador", listCrit);
            Numerador numerador = (Numerador)listDeInterf.get(0);
            numerador.setultimonumeroregistrado(numerador.getultimonumeroregistrado()+1);
            FachadaExterna.getInstancia().guardar("Numerador", numerador);
            denunciaAUsar.setcodigoDenuncia(numerador.getultimonumeroregistrado());
            denunciaAUsar.setReclamo(new ArrayList<Reclamo>());
            denunciaAUsar.setProblema(new ArrayList<Problema>());
            denunciaAUsar.setSemaforo(new ArrayList<Semaforo>());
            for (DTOProblemasDelSemaforo dTOProblemasDelSemaforo : dtoInfoParaCrearDenuncia.getProblemasDelSemaforo()) {

                denunciaAUsar.getProblema().addAll(dTOProblemasDelSemaforo.getListaDeProblemas());
                denunciaAUsar.getSemaforo().add(dTOProblemasDelSemaforo.getSemaforo());

            }
            denunciaAUsar.setprioridad(FabricaDeEstrategiaCalcularPrioridad.getInstace().crearEstrategiaDeCalculoDePrioridadDenuncia().calcularPrioridad(denunciaAUsar, ubicacion));
            denunciaAUsar.setDenunciaEstado(new ArrayList<DenunciaEstado>());
            crit = FachadaExterna.getInstancia().crearCriterio("NombreEstado", "=", "Pendiente");
            listCrit = new ArrayList<Criterio>();
            listCrit.add(crit);
            listaDeInterfaces = FachadaExterna.getInstancia().buscar("EstadoDenuncia", listCrit);
            DenunciaEstado denEst = (DenunciaEstado)FachadaExterna.getInstancia().crearEntidad("DenunciaEstado");
            denEst.setEstadoDenuncia((EstadoDenuncia)listaDeInterfaces.get(0));
            denEst.setfechacambioestado(new Date());
            denEst.setindicadorestadoactual(true);
            denunciaAUsar.getDenunciaEstado().add(denEst);

        }
        FachadaExterna.getInstancia().guardar("Denuncia", denunciaAUsar);




        /*List<Criterio> listaDeCriterios;
        List<Denuncia> listaDeDenuncias;
        List<DTOProblemasDelSemaforo> listaDTOProblemasDelSemaforosParaHacerleDenuncia = new ArrayList<DTOProblemasDelSemaforo>();
        List<SuperDruperInterfaz> listaDeInterfaces;
        boolean seNecesitaCrearDenunciaNueva=false;
        for(DTOProblemasDelSemaforo aux : dtoInfoParaCrearDenuncia.getProblemasDelSemaforo()){
            listaDeCriterios = new ArrayList<Criterio>();
            listaDeDenuncias = new ArrayList<Denuncia>();
            listaDeCriterios.add(FachadaExterna.getInstancia().crearCriterio("Semaforo", "=", aux.getSemaforo()));
            listaDeInterfaces = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterios);
            for(SuperDruperInterfaz aux1 : listaDeInterfaces)
                listaDeDenuncias.add((Denuncia) aux1);

            Denuncia denunciaAUtilizar=null;
            int bandera=0;
            for(Denuncia denuncia : listaDeDenuncias){
                for(DenunciaEstado denunciaEstado : denuncia.getDenunciaEstado()){
                    if(denunciaEstado.getEstadoDenuncia().getnombreestado().equalsIgnoreCase("Pendiente de atención") & denunciaEstado.isindicadorestadoactual()){
                        denunciaAUtilizar=denuncia;
                        bandera=1;//avisa que se tiene que hacer un reclamo con la denuncia guradada en denuncia
                        //GENERAR UN RECLAMO
                    }
                    else if(!denunciaEstado.getEstadoDenuncia().getnombreestado().equalsIgnoreCase("Final") & denunciaEstado.isindicadorestadoactual()){
                        bandera=1;//tiene que avisar que no se puede generar un reclamo pero que la denuncia ya exite
                            //AVISAR QUE NO SE PUEDE HACER UNA DENUNCIA
                    }
                     //sino tiene que generar una denuncia
                }
                    
                if(bandera == 1)
                    break;
            }

            if(bandera==1 & denunciaAUtilizar==null ){
            //avisar que tiene que esperar, que ya existe la denuncia

            }else if(bandera==1 & denunciaAUtilizar!=null){
            //GEnerar un reclamo

            }
            else if (bandera == 0){
                //generar denuncia
                listaDTOProblemasDelSemaforosParaHacerleDenuncia.add(aux);
                seNecesitaCrearDenunciaNueva=true;

            }
        }

        if(seNecesitaCrearDenunciaNueva){
            List<Semaforo> listSem = new ArrayList<Semaforo>();
            List<Problema> listProb = new ArrayList<Problema>();
            for(DTOProblemasDelSemaforo aux : listaDTOProblemasDelSemaforosParaHacerleDenuncia){
                listSem.add(aux.getSemaforo());
                for(Problema problem : aux.getListaDeProblemas())
                    listProb.add(problem);
            }
            Denuncia den = (Denuncia)FachadaExterna.getInstancia().crearEntidad("Denuncia");
            den.setSemaforo(listSem);
            den.setProblema(listProb);
            den.setDenunciante(dtoInfoParaCrearDenuncia.getDenunciante());
            den.setOperador(dtoInfoParaCrearDenuncia.getOperador());
            den.setfechacaso(new Date());
            den.settipocaso(1);
            List<Criterio> listCrit = new ArrayList<Criterio>();
            listCrit.add(FachadaExterna.getInstancia().crearCriterio("TipoDocumentacion", "=" , "Denuncia"));
            List<SuperDruperInterfaz> listDeInterf = FachadaExterna.getInstancia().buscar("Numerador", listCrit);
            Numerador numerador = (Numerador)listDeInterf.get(0);
            numerador.setultimonumeroregistrado(numerador.getultimonumeroregistrado()+1);
            FachadaExterna.getInstancia().guardar("Numerador", numerador);
            den.settipocaso(1);
            den.setcodigoDenuncia(numerador.getultimonumeroregistrado());
            den.setReclamo(new ArrayList<Reclamo>());
            den.setprioridad(calcularPrioridad(den.getReclamo(), den.getSemaforo().get(0)));
            den.setDenunciaEstado(new ArrayList<DenunciaEstado>());
            DenunciaEstado denEstado = (DenunciaEstado) FachadaExterna.getInstancia().crearEntidad("DenunciaEstado");
            denEstado.setfechacambioestado(new Date());
            denEstado.setindicadorestadoactual(true);
            List<Criterio> listCriterioEstDen = new ArrayList<Criterio>();
            listCriterioEstDen.add(FachadaExterna.getInstancia().crearCriterio("nombreEstado", "=", "Pendiente"));
            List<SuperDruperInterfaz> listaEstDen = FachadaExterna.getInstancia().buscar("EstadoDenuncia", listCriterioEstDen);
            denEstado.setEstadoDenuncia((EstadoDenuncia)listaEstDen.get(0));
            List<DenunciaEstado> listaDenEstado = new ArrayList<DenunciaEstado>();
            listaDenEstado.add(denEstado);
            den.setDenunciaEstado(listaDenEstado);

            FachadaExterna.getInstancia().guardar("Denuncia", den);


        }
*/


    }


}
