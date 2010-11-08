/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import DTO.DTODenuncia;
import DTO.DTODetalleInformeReparacion;
import DTO.DTOEstadoDenuncia;
import DTO.DTOFallaTecnica;
import DTO.DTOInformeReparacion;
import DTO.DTOOrden;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Criterio;
import Utilidades.ConvertidorBooleanos;
import Utilidades.FormateadorFechas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor.STRING;

/**
 *
 * @author diego
 */
public class IntermediarioDTOEstadoCaso extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        return null;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {

        String select = "SELECT * from ("
                + "select caso.OIDCaso as oidDenunciaEncontrada, caso.FechaCaso,"
                + "denuncia.CodigoDenuncia, "
                + "denunciaestado.FechaCambioEstado as fechaCambioEstadoDenuncia, denunciaestado.IndicadoresEstadoActual as indicadorEstadoDenuncia, "
                + "estadodenuncia.NombreEstado as nombreEstadoDenuncia, "
                + "trabajo.NombreTrabajo as nombreFallaDenuncia, "
                + "fallatecnica.DescripcionFalla as descripcionFallaDenuncia, fallatecnica.CodigoFallaTecnica as codigoFallaDenuncia, "
                + "reclamo.CodigoReclamo, "
                + "caso.OIDOperador as operador "
                + "from caso "
                + "join denuncia on caso.OIDCaso = denuncia.OIDCaso "
                + "join denunciaestado on denuncia.OIDCaso = denunciaestado.OIDDenuncia "
                + "join estadodenuncia on denunciaestado.OIDEstadoDenuncia = estadodenuncia.OIDEstadoDenuncia "
                + "left join fallatecnicadenuncia on denuncia.OIDCaso = fallatecnicadenuncia.OIDDenuncia "
                + "join fallatecnica on fallatecnicadenuncia.OIDFallaTecnica = fallatecnica.OIDTrabajo "
                + "join trabajo on fallatecnica.OIDTrabajo = trabajo.OIDTrabajo "
                + "left join reclamo on denuncia.OIDCaso = reclamo.OIDDenuncia"
                + ") as denunciaCompleta "
                + "join ("
                + "Select ordendetrabajo.FechaInicioTrabajo, ordendetrabajo.FechaFinTrabajo, ordendetrabajo.FechaInicioPlanificada, ordendetrabajo.DuracionPrevistaTrabajo, "
                + "equipodetrabajo.NombreEquipo, "
                + "estadoordentrabajo.NombreEstado as nombreEstadoOrden, "
                + "ordenreparacion.OIDDenuncia, ordenreparacion.CodigoOrdenReparacion,"
                + "informereparacion.FechaInforme, informereparacion.HoraInforme, informereparacion.DuracionReparacion, "
                + "detalleinformereparacion.Comentario, "
                + "fallatecnica.DescripcionFalla as descripcionFallaInforme, "
                + "estadofallatecnica.NombreEstado as nombreEstadoFallaInforme "
                + "from ordendetrabajo "
                + "join equipodetrabajo on ordendetrabajo.OIDEquipoDeTrabajo = equipodetrabajo.OIDEquipoDeTrabajo "
                + "join ordentrabajoestado on ordendetrabajo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                + "join estadoordentrabajo on ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo "
                + "join ordenreparacion on ordendetrabajo.OIDOrdenDeTrabajo = ordenreparacion.OIDOrdenDeTrabajo "
                + "left join informereparacion on ordenreparacion.OIDOrdenDeTrabajo = informereparacion.OIDOrdenDeTrabajo "
                + "join detalleinformereparacion on informereparacion.OIDInformeReparacion = detalleinformereparacion.OIDInformeReparacion "
                + "join estadofallatecnica on detalleinformereparacion.OIDEstadoFallaTecnica = estadofallatecnica.OIDEstadoFallaTecnica "
                + "join fallatecnica on detalleinformereparacion.OIDFallaTecnica = fallatecnica.OIDTrabajo "
                + "where ordentrabajoestado.IndicadoresEstadoActual = TRUE "
                + ")as ordenReparacionCompleta on denunciaCompleta.oidDenunciaEncontrada = ordenReparacionCompleta.OIDDenuncia";

        String condicion = " WHERE ";

        for(int i = 0 ; i < criterios.size(); i++){
            if(i>0){
                condicion += " AND ";
            }
            if(criterios.get(i).getAtributo().equalsIgnoreCase("Operador")){
                condicion += " denunciaCompleta.operador " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            }
            else{
                condicion += " denunciaCompleta." + criterios.get(i).getAtributo()+ " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "' ";
            }
        }

         
        condicion += " ORDER BY denunciaCompleta.CodigoDenuncia, denunciaCompleta.nombreEstadoDenuncia, denunciaCompleta.nombreFallaDenuncia,ordenReparacionCompleta.CodigoOrdenReparacion";
        select = select + condicion;

        return select;
    }

    @Override
    public String armarSelectOid(String oid) {
        return null;
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {
        return null;
    }

    @Override
    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
    }

    @Override
    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {

        DTODenuncia dtoDenuncia = null;

        boolean pedirDatosPrincipales = true;
        boolean crearNuevoEstadoDenuncia = false;
        boolean crearNuevaOrdenReparacion = false;
        boolean crearNuevoInformeReparacion = false;
        boolean crearNuevoDetalleInforme = false;
        boolean crearNuevaFallaDenuncia = false;
        boolean sumarReclamo = true;

        List<String> auxiliaresReclamo = new ArrayList<String>();

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {

            while (rs.next()) {


                if (pedirDatosPrincipales) {
                    dtoDenuncia = new DTODenuncia();
                    dtoDenuncia.setFechaCaso(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(rs.getDate("FechaCaso")));
                    dtoDenuncia.setNroCaso(rs.getString("CodigoDenuncia"));
                    pedirDatosPrincipales = false;
                }

                //If para saber si crear nuevo Estado de denuncia
                if (dtoDenuncia.getListaEstados().isEmpty() && rs.getString("nombreEstadoDenuncia") != null) {
                    crearNuevoEstadoDenuncia = true;
                } else if (!dtoDenuncia.getListaEstados().get(dtoDenuncia.getListaEstados().size() - 1).getNombreestado().equals(rs.getString("nombreEstadoDenuncia")) && rs.getString("nombreEstadoDenuncia") != null) {
                    crearNuevoEstadoDenuncia = true;
                } else {
                    crearNuevoEstadoDenuncia = false;
                }

                if (crearNuevoEstadoDenuncia) {
                    DTOEstadoDenuncia nuevoEstado = new DTOEstadoDenuncia();
                    nuevoEstado.setFecha(rs.getString("fechaCambioEstadoDenuncia"));
                    nuevoEstado.setIndicadorEstadoActual(ConvertidorBooleanos.getInstancia().convertirBooleanToActivoInactivo(rs.getBoolean("indicadorEstadoDenuncia")));
                    nuevoEstado.setNombreEstadoDenuncia(rs.getString("nombreEstadoDenuncia"));
                    dtoDenuncia.addEstado(nuevoEstado);

                }

                //If para saber si crear dto Falla denuncia
                if (dtoDenuncia.getListaFallas().isEmpty() && rs.getString("nombreFallaDenuncia") != null) {
                    crearNuevaFallaDenuncia = true;
                } else if (!dtoDenuncia.seEncuentraFalla(rs.getString("codigoFallaDenuncia")) && rs.getString("codigoFallaDenuncia") != null) {
                    crearNuevaFallaDenuncia = true;
                } else {
                    crearNuevaFallaDenuncia = false;
                }

                if (crearNuevaFallaDenuncia) {
                    DTOFallaTecnica nuevaFallaDenuncia = new DTOFallaTecnica();
                    nuevaFallaDenuncia.setCodigoFalla(rs.getString("codigoFallaDenuncia"));
                    nuevaFallaDenuncia.setDescripcion(rs.getString("descripcionFallaDenuncia"));
                    nuevaFallaDenuncia.setNombreFalla(rs.getString("nombreFallaDenuncia"));
                    dtoDenuncia.addFalla(nuevaFallaDenuncia);
                }


                //If para saber si crear nueva Orden de Reparacion
                if (dtoDenuncia.getOrdenesRep().isEmpty() && rs.getString("CodigoOrdenReparacion") != null) {
                    crearNuevaOrdenReparacion = true;
                } else if (!dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion")) && rs.getString("CodigoOrdenReparacion") != null) {
                    crearNuevaOrdenReparacion = true;
                } else {
                    crearNuevaOrdenReparacion = false;
                }

                if (crearNuevaOrdenReparacion) {
                    DTOOrden nuevaOrden = new DTOOrden();
                    nuevaOrden.setNroOrden(rs.getString("CodigoOrdenReparacion"));
                    nuevaOrden.setDuracionPrevista(rs.getInt("DuracionPrevistaTrabajo"));
                    nuevaOrden.setEstado(rs.getString("nombreEstadoOrden"));
                    nuevaOrden.setFechaFinTrabajo(rs.getDate("FechaFinTrabajo"));
                    nuevaOrden.setFechaInicioPlanificada(rs.getDate("FechaInicioPlanificada"));
                    nuevaOrden.setFechaInicioTrabajo(rs.getDate("FechaInicioTrabajo"));
                    nuevaOrden.setNombreEquipo(rs.getString("NombreEquipo"));
                    dtoDenuncia.addOrden(nuevaOrden);
                }

                //If para saber si crear nuevo informe de Reparacion
                if (!dtoDenuncia.getOrdenesRep().isEmpty() && rs.getString("DuracionReparacion") != null && dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion"))) {
                    if (dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getInformeReparacion() == null) {
                        crearNuevoInformeReparacion = true;
                    } else {
                        crearNuevoInformeReparacion = false;
                    }
                } else {
                    crearNuevoInformeReparacion = false;
                }

                if (crearNuevoInformeReparacion) {
                    DTOInformeReparacion nuevoInformeReparacion = new DTOInformeReparacion();
                    nuevoInformeReparacion.setDuracion(rs.getString("DuracionReparacion"));
                    nuevoInformeReparacion.setFechaInforme(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(rs.getDate("FechaInforme")));
                    nuevoInformeReparacion.setHoraInforme(rs.getString("HoraInforme"));
                    dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).setInformeReparacion(nuevoInformeReparacion);
                }

                //If para saber si crear nuevo detalleDeInforme
                if (!dtoDenuncia.getOrdenesRep().isEmpty() && rs.getString("nombreEstadoFallaInforme") != null && !dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getInformeReparacion().seEncuentraDetalle(rs.getString("descripcionFallaInforme"))) {
                    crearNuevoDetalleInforme = true;
                } else {
                    crearNuevoDetalleInforme = false;
                }


                if (crearNuevoDetalleInforme) {
                    DTODetalleInformeReparacion nuevoDetalleInforme = new DTODetalleInformeReparacion();
                    nuevoDetalleInforme.setEstadoFalla(rs.getString("nombreEstadoFallaInforme"));
                    nuevoDetalleInforme.setFalla(rs.getString("descripcionFallaInforme"));
                    nuevoDetalleInforme.setComentario(rs.getString("Comentario"));
                    dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getInformeReparacion().addDetalle(nuevoDetalleInforme);
                }

                if (auxiliaresReclamo.isEmpty() && rs.getString("CodigoReclamo") != null) {
                } else {
                    int cantMaxRecl = auxiliaresReclamo.size();
                    for (int i = 0; i < cantMaxRecl; i++) {
                        if (auxiliaresReclamo.get(i).equals(rs.getString("CodigoReclamo"))) {
                            sumarReclamo = false;
                        }
                    }
                }
                if(sumarReclamo){
                    auxiliaresReclamo.add(rs.getString("CodigoReclamo"));
                }

                dtoDenuncia.setCantidadReclamos(auxiliaresReclamo.size());

            }
            if (dtoDenuncia != null) {
                nuevosObjetos.add(dtoDenuncia);
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
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listacCriterios) {
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
    }
}
