/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import DTO.DTODenuncia;
import DTO.DTODetalleInformeReparacion;
import DTO.DTOEstadoDenuncia;
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

        String select = "SELECT caso.FechaCaso,"
                + " denuncia.CodigoDenuncia, "
                + "denunciaestado.FechaCambioEstado AS FechaCambioEstadoDenuncia, denunciaestado.IndicadoresEstadoActual AS indicadorEstadoDenuncia,"
                + "estadodenuncia.NombreEstado AS nombreEstadoDenuncia, "
                + "ordenrep.CodigoOrdenReparacion, "
                + "orden.Tipo, orden.DuracionPrevistaTrabajo, orden.FechaInicioPlanificada, orden.FechaFinTrabajo, orden.FechaInicioTrabajo, "
                + "estadoordentrabajo.NombreEstado AS nombreEstadoOrden, "
                + "equipodetrabajo.NombreEquipo,"
                + "informe.DuracionReparacion, informe.FechaInforme, informe.HoraInforme, "
                + "detalleinforme.NombreEstado AS nombreEstadoFallaInforme, detalleinforme.DescripcionFalla AS descripcionFallaInforme, "
                + "reclamo.CodigoReclamo, "
                + "fallaDen.DescripcionFalla AS fallaDenuncia "
                + "FROM caso "
                + "JOIN denuncia ON caso.OIDCaso = denuncia.OIDCaso "
                + "JOIN denunciaestado ON denuncia.OIDCaso = denunciaestado.OIDDenuncia "
                + "JOIN estadodenuncia ON denunciaestado.OIDEstadoDenuncia = estadodenuncia.OIDEstadoDenuncia "
                + "left JOIN fallatecnicadenuncia AS fallasDenuncia ON denuncia.OIDCaso = fallasDenuncia.OIDDenuncia "
                + "left JOIN fallatecnica AS fallaDen ON fallasDenuncia.OIDFallaTecnica = fallaDen.OIDTrabajo "
                + "left JOIN reclamo ON denuncia.OIDCaso = reclamo.OIDDenuncia "
                + "left JOIN ordenreparacion AS ordenrep ON denuncia.OIDCaso = ordenrep.OIDDenuncia "
                + "left JOIN ordendetrabajo AS orden ON ordenrep.OIDOrdenDeTrabajo = orden.OIDOrdenDeTrabajo "
                + "left JOIN ordentrabajoestado ON orden.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                + "left JOIN estadoordentrabajo ON ordentrabajoestado.OIDOrdenDeTrabajo = orden.OIDOrdenDeTrabajo "
                + "left JOIN equipodetrabajo ON orden.OIDEquipoDeTrabajo = equipodetrabajo.OIDEquipoDeTrabajo "
                + "left JOIN informereparacion AS informe ON ordenrep.OIDOrdenDeTrabajo = informe.OIDOrdenDeTrabajo "
                + "left JOIN ("
                + "select detalle.OIDInformeReparacion, detalle.Comentario, estado.NombreEstado, falla.DescripcionFalla "
                + "FROM detalleinformereparacion AS detalle "
                + "JOIN estadofallatecnica AS estado ON detalle.OIDEstadoFallaTecnica = estado.OIDEstadoFallaTecnica "
                + "JOIN fallatecnica AS falla ON detalle.OIDFallaTecnica = falla.OIDTrabajo"
                + ") AS detalleinforme ON informe.OIDInformeReparacion = detalleinforme.OIDInformeReparacion ";

        String condicion = " WHERE denuncia." + criterios.get(0).getAtributo() + " = '" + criterios.get(0).getValor() + "' AND ordentrabajoestado.IndicadoresEstadoActual = TRUE";
        condicion = condicion + " ORDER BY denuncia.CodigoDenuncia, estadodenuncia.NombreEstado, ordenrep.CodigoOrdenReparacion";
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

        DTODenuncia dtoDenuncia = new DTODenuncia();
        boolean pedirDatosPrincipales = true;
        String auxUltimoReclamo = "";
        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {
            while (rs.next()) {

                if (pedirDatosPrincipales) {
                    dtoDenuncia.setFechaCaso(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(rs.getDate("FechaCaso")));
                    dtoDenuncia.setNroCaso(rs.getString("CodigoDenuncia"));
                    pedirDatosPrincipales = false;
                }


                if (dtoDenuncia.getOrdenesRep().isEmpty() || !dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size()-1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion"))) {
                    DTOOrden nuevaOrden = new DTOOrden();
                    nuevaOrden.setNroOrden(rs.getString("CodigoOrdenReparacion"));
                    nuevaOrden.setDuracionPrevista(rs.getInt("DuracionPrevistaTrabajo"));
                    nuevaOrden.setEstado(rs.getString("nombreEstadoOrden"));
                    nuevaOrden.setFechaFinTrabajo(rs.getDate("FechaFinTrabajo"));
                    nuevaOrden.setFechaInicioPlanificada(rs.getDate("FechaInicioPlanificada"));
                    nuevaOrden.setFechaInicioTrabajo(rs.getDate("FechaInicioTrabajo"));
                    nuevaOrden.setNombreEquipo(rs.getString("NombreEquipo"));
                }

                if(!dtoDenuncia.getOrdenesRep().isEmpty()|| !dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size()-1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion"))){
                    DTOInformeReparacion nuevoInformeReparacion = new DTOInformeReparacion();
                    nuevoInformeReparacion.setDuracion(rs.getString("DuracionReparacion"));
                    nuevoInformeReparacion.setFechaInforme(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(rs.getDate("FechaInforme")));
                    nuevoInformeReparacion.setHoraInforme(rs.getString("HoraInforme"));
                }

                if(!dtoDenuncia.getOrdenesRep().isEmpty()|| !dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size()-1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion"))){
                    DTODetalleInformeReparacion nuevoDetalleInforme = new DTODetalleInformeReparacion();
                    nuevoDetalleInforme.setEstadoFalla(rs.getString("nombreEstadoFallaInforme"));
                    nuevoDetalleInforme.setFalla(rs.getString("descripcionFallaInforme"));
                    dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size()-1).getInformeReparacion().addDetalle(nuevoDetalleInforme);
                }

               if(rs.getString("CodigoReclamo")!=null && !rs.getString("CodigoReclamo").equals(auxUltimoReclamo)){
                   dtoDenuncia.setCantidadReclamos(dtoDenuncia.getCantidadReclamos()+1);
                   auxUltimoReclamo = rs.getString("CodigoReclamo");
               }

            }
            nuevosObjetos.add(dtoDenuncia);
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
