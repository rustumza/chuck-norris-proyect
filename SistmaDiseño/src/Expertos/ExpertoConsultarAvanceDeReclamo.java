/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import DTO.DTODenuncia;
import DTO.DTOOrden;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Reclamo;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RUSTU
 */
public class ExpertoConsultarAvanceDeReclamo implements Experto {

    public DTODenuncia ConsultarEstadoCaso(String numcaso, int seleccion) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {



//        Denuncia casoEncontrado;
//        DTODenuncia dTODenuncia = null;
//
        if (numcaso.equals("")) {
            ExcepcionCampoInvalido ex = new ExcepcionCampoInvalido();
            ex.setMensaje("Código de Caso vacío.");
            throw ex;

        }

        DTODenuncia dtoEncontrado;

        if (seleccion == 1) {
            return buscarDTODenuncia(numcaso);
        }else{
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("CodigoReclamo", "=", numcaso));
            List<SuperDruperInterfaz> listaEncontrada = FachadaExterna.getInstancia().buscar("Reclamo", listaCriterios);
            if (listaEncontrada.isEmpty()) {
                ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
                ex.setMensaje("No se han encontrado Casos con el numero: " + numcaso);
                throw ex;
            }
            listaCriterios.clear();
            listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("Reclamo", "=", (ObjetoPersistente) listaEncontrada.get(0)));
            List<SuperDruperInterfaz> denunciasBuscadas = FachadaExterna.getInstancia().buscar("Denuncia", listaCriterios);

            return buscarDTODenuncia(String.valueOf(((Denuncia)denunciasBuscadas.get(0)).getcodigoDenuncia()));
        }



//
//        if (seleccion == 1) {//es denuncia
//
//            Criterio criterio = FachadaExterna.getInstancia().crearCriterio("CodigoDenuncia", "=", numcaso);
//            List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
//            listaDeCriterio.add(criterio);
//            List<SuperDruperInterfaz> denunciasBuscadas = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterio);
//
//            if (denunciasBuscadas.isEmpty()) {
//                //debe lanzar excepcion
//                ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
//                ex.setMensaje("No se han encontrado Denuncias con el numero: " + numcaso);
//                throw ex;
//
//            } else {
//                casoEncontrado = (Denuncia) denunciasBuscadas.get(0);
//                dTODenuncia = armarDtoDenuncia(casoEncontrado);
//            }
//
//
//
//        } else if (seleccion == 2) {//es reclamo
//            List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
//            listaDeCriterio.add(FabricaCriterios.getInstancia().crearCriterio("CodigoReclamo", "=", numcaso));
//            List<SuperDruperInterfaz> interfaceCasoEncontrado = FachadaExterna.getInstancia().buscar("Reclamo", listaDeCriterio);
//
//            Reclamo reclamoEncontrado = (Reclamo) interfaceCasoEncontrado.get(0);
//
//            listaDeCriterio.clear();
//            listaDeCriterio.add(FabricaCriterios.getInstancia().crearCriterio("Reclamo", "=", (ObjetoPersistente) reclamoEncontrado));
//            List<SuperDruperInterfaz> denunciasBuscadas = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterio);
//
//            casoEncontrado = (Denuncia) denunciasBuscadas.get(0);
//
//            dTODenuncia = armarDtoDenuncia(casoEncontrado);
//
//        }
//
//        return dTODenuncia;
//
//    }
//
//    public List<DTOEstadoDenuncia> armarDtoEstadoDenuncia(Denuncia denuncia) {
//
//        List<DTOEstadoDenuncia> listaDtoEstado = new ArrayList<DTOEstadoDenuncia>();
//
//        for (DenunciaEstado denunciaEstado : denuncia.getDenunciaEstado()) {
//
//            DTOEstadoDenuncia dtoEstado = new DTOEstadoDenuncia();
//            FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(denunciaEstado.getfechacambioestado());
//            dtoEstado.setFecha(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(denunciaEstado.getfechacambioestado()));
//            dtoEstado.setNombreEstadoDenuncia(denunciaEstado.getEstadoDenuncia().getnombreestado());
//            dtoEstado.setIndicadorEstadoActual(ConvertidorBooleanos.getInstancia().convertirBooleanToActivoInactivo(denunciaEstado.isindicadorestadoactual()));
//            listaDtoEstado.add(dtoEstado);
//        }
//        return listaDtoEstado;
//    }
//
//    public DTODenuncia armarDtoDenuncia(Denuncia denuncia) {
//
//        DTODenuncia dtoDenuncia = new DTODenuncia();
//        //busca los estados de la denuncia
//        List<DTOEstadoDenuncia> listaDtoEstado = armarDtoEstadoDenuncia(denuncia);
//        dtoDenuncia.setListaEstados(listaDtoEstado);
//
//        boolean buscarFallas = false;
//        boolean buscarOrden = false;
//
//
//        for (DTOEstadoDenuncia estado : listaDtoEstado) {
//            if (estado.getIndicadorEstadoActual().equals("Activo")) {
//
//                if (estado.getNombreestado().equals("FALLAS ASIGNADAS")) {//la denuncia tiene fallas asignadas,
//                    buscarFallas = true;
//                } else if (estado.getNombreestado().equals("RECURSOS ASIGNADOS") || estado.getNombreestado().equals("EN REPARACION") || estado.getNombreestado().equals("CERRADA")) {
//                    buscarFallas = true;
//                    buscarOrden = true;
//                }
//            }
//        }
//
//        if (buscarFallas) {
//            List<DTOFallaTecnica> dtoFallas = armarDtoFallas(denuncia.getFallasTecnica());
//            dtoDenuncia.setListaFallas(dtoFallas);
//        } else {
//            List<DTOFallaTecnica> dtoFallas = new ArrayList<DTOFallaTecnica>();
//            dtoDenuncia.setListaFallas(dtoFallas);
//        }
//
//        if (buscarOrden) {
//            List<Criterio> listacriCriterios = new ArrayList<Criterio>();
//            listacriCriterios.add(FabricaCriterios.getInstancia().crearCriterio("Denuncia", "=", (ObjetoPersistente) denuncia));
//            OrdenTrabajo ordenTrabajo = (OrdenTrabajo) FachadaExterna.getInstancia().buscar("OrdenReparacion", listacriCriterios).get(0);
//            DTOOrden dtoOrden = armarDtoOrden(ordenTrabajo);
//            dtoDenuncia.setOrdenRep(dtoOrden);
//        } else {
//            dtoDenuncia.setOrdenRep(null);
//        }
//
//        dtoDenuncia.setFechaCaso(FormateadorFechas.getInstancia().getFormatMySQLyyyyMMdd().format(denuncia.getfechacaso()));
//
//        dtoDenuncia.setNombreOperador(denuncia.getOperador().getnombreOperador());
//
//
//        return dtoDenuncia;

    }

    public DTODenuncia buscarDTODenuncia(String numcaso) throws ExcepcionObjetoNoEncontrado{
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("CodigoDenuncia", "=", numcaso));
            List<SuperDruperInterfaz> listaEncontrada = FachadaExterna.getInstancia().buscar("DTOEstadoCaso", listaCriterios);
            if (listaEncontrada.isEmpty()) {
                ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
                ex.setMensaje("No se han encontrado Casos con el numero: " + numcaso);
                throw ex;
            }
              DTODenuncia dtoEncontrado = (DTODenuncia) listaEncontrada.get(0);
             return dtoEncontrado;
    }

    public boolean habilitarBotonDetalleOrden(DTOOrden dtoOrdenRep) {
        if (dtoOrdenRep.getInformeReparacion() != null) {
            return true;
        } else {
            return false;
        }
    }
//    private List<DTOFallaTecnica> armarDtoFallas(List<FallaTecnica> fallasTecnica) {
//        List<DTOFallaTecnica> dtoFallas = new ArrayList<DTOFallaTecnica>();
//
//        for (FallaTecnica falla : fallasTecnica) {
//            DTOFallaTecnica nuevoDtoFalla = new DTOFallaTecnica();
//            nuevoDtoFalla.setDescripcion(falla.getdescripcionfalla());
//            nuevoDtoFalla.setNombreFalla(falla.getNombreTrabajo());
//            dtoFallas.add(nuevoDtoFalla);
//        }
//
//        return dtoFallas;
//    }
//
//    private DTOOrden armarDtoOrden(OrdenTrabajo ordenTrabajo) {
//        DTOOrden dtoOrden = new DTOOrden();
//
//        dtoOrden.setDuracionPrevista(ordenTrabajo.getduracionprevistatrabajo());
//        dtoOrden.setFechaFinTrabajo(ordenTrabajo.getfechafintrabajo());
//        dtoOrden.setFechaInicioPlanificada(ordenTrabajo.getfechainicioplanificada());
//        dtoOrden.setFechaInicioTrabajo(dtoOrden.getFechaInicioTrabajo());
//        dtoOrden.setNombreEquipo(ordenTrabajo.getEquipoDeTrabajo().getnombreEquipo());
//        dtoOrden.setNroOrden(String.valueOf(((OrdenDeReparacion) ordenTrabajo).getcodigoordenreparacion()));
//        dtoOrden.setTipo(ordenTrabajo.gettipoordentrabajo());
//
//        for(OrdenTrabajoEstado estado : ordenTrabajo.getListaEstadosOrdenTrabajo()){
//            if(estado.isindicadorestadoactual()){
//                dtoOrden.setEstado(estado.getEstadoOrdenTrabajo().getNombreestado());
//            }
//        }
//
//        return dtoOrden;
//
//    }
}
