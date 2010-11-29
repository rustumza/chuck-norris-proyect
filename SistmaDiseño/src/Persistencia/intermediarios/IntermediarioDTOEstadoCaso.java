/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import DTO.DTOCaso;
import DTO.DTODetalleInformeReparacion;
import DTO.DTOEstadoDenuncia;
import DTO.DTOFallaTecnica;
import DTO.DTOInformeReparacion;
import DTO.DTOOrden;
import DTO.DTOSemaforo;
import DTO.DTOUbicacion;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Criterio;
import Utilidades.ConvertidorBooleanos;
import Utilidades.FormateadorFechas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String select = "SELECT * FROM ( "
                + "SELECT caso.OIDCaso AS oidDenunciaEncontrada, caso.FechaCaso, "
                + "denuncia.CodigoDenuncia, "
                + "denunciaestado.FechaCambioEstado AS fechaCambioEstadoDenuncia, denunciaestado.IndicadoresEstadoActual AS indicadorEstadoDenuncia, "
                + "estadodenuncia.NombreEstado AS nombreEstadoDenuncia, "
                + "trabajo.NombreTrabajo AS nombreFallaDenuncia, "
                + "fallatecnica.DescripcionFalla AS descripcionFallaDenuncia, fallatecnica.CodigoFallaTecnica AS codigoFallaDenuncia, "
                + "reclamoDenuncia.CodigoReclamo, "
                + "caso.OIDOperador AS operador, "
                + "semaforo.NumeroSerie, "
                + "modelo.NombreModelo, "
                + "tiposemaforo.DescripcionTipoSemaforo AS tipoSem, "
                + "esquina.Descripcion AS esquinaSem, "
                + "orientacion.Descripcion AS orientacionSem, "
                + "ubicacion.TipoUbicacion, "
                + "calleSimple.NombreCalle AS calleSimple, "
                + "ubicacionsimple.Altura, "
                + "calleInterseccion.NombreCalle AS calleInterseccion, "
                + "problema.DescripcionProblema, "
                + "reclamoDenuncia.NumeroSerieSemaforoReclamo, "
                + "reclamoDenuncia.NombreModeloReclamo, "
                + "reclamoDenuncia.DescripcionTipoSemReclamo, "
                + "reclamoDenuncia.esquinaSemReclamo, "
                + "reclamoDenuncia.orientacionSemReclamo, "
                + "reclamoDenuncia.ProblemaReclamo "
                + "FROM caso "
                + "LEFT JOIN casosemaforo ON caso.OIDCaso = casosemaforo.OIDCaso "
                + "LEFT JOIN problemacaso ON caso.OIDCaso = problemacaso.OIDCaso "
                + "LEFT JOIN problema ON problemacaso.OIDProblema = problema.OIDProblema "
                + "LEFT JOIN semaforo on casosemaforo.OIDSemaforo = semaforo.OIDSemaforo "
                + "LEFT JOIN modelo ON semaforo.OIDModelo = modelo.OIDModelo "
                + "LEFT JOIN tiposemaforo ON semaforo.OIDTipoSemaforo = tiposemaforo.OIDTipoSemaforo "
                + "LEFT JOIN esquina ON semaforo.OIDEsquina = esquina.OIDEsquina "
                + "LEFT JOIN orientacion ON semaforo.OIDOrientacion = orientacion.OIDOrientacion "
                + "LEFT JOIN ubicacion ON semaforo.OIDUbicacion = ubicacion.OIDUbicacion "
                + "LEFT JOIN ubicacionsimple ON ubicacion.OIDUbicacion = ubicacionsimple.OIDUbicacion "
                + "LEFT JOIN calle AS calleSimple on ubicacionsimple.OIDCalle = calleSimple.OIDCalle "
                + "LEFT JOIN interseccion on ubicacion.OIDUbicacion = interseccion.OIDUbicacion "
                + "LEFT JOIN interseccioncalle ON interseccion.OIDUbicacion = interseccioncalle.OIDInterseccion "
                + "LEFT JOIN calle AS calleInterseccion ON interseccioncalle.OIDCalle = calleInterseccion.OIDCalle "
                + "LEFT JOIN denuncia ON caso.OIDCaso = denuncia.OIDCaso "
                + "LEFT JOIN denunciaestado ON denuncia.OIDCaso = denunciaestado.OIDDenuncia "
                + "LEFT JOIN estadodenuncia ON denunciaestado.OIDEstadoDenuncia = estadodenuncia.OIDEstadoDenuncia "
                + "LEFT JOIN fallatecnicadenuncia ON denuncia.OIDCaso = fallatecnicadenuncia.OIDDenuncia "
                + "LEFT JOIN fallatecnica ON fallatecnicadenuncia.OIDFallaTecnica = fallatecnica.OIDTrabajo "
                + "LEFT JOIN trabajo ON fallatecnica.OIDTrabajo = trabajo.OIDTrabajo "
                + "LEFT JOIN ( "
                + "select reclamo.OIDDenuncia as OIDDenReclamo, reclamo.CodigoReclamo, "
                + "semaforoReclamo.NumeroSerie as NumeroSerieSemaforoReclamo, "
                + "modeloReclamo.NombreModelo as NombreModeloReclamo, "
                + "tipoSemReclamo.DescripcionTipoSemaforo as DescripcionTipoSemReclamo, "
                + "esquinaSemReclamo.Descripcion as esquinaSemReclamo, "
                + "orientacionSemReclamo.Descripcion as orientacionSemReclamo, "
                + "problemaSemaforo.DescripcionProblema as ProblemaReclamo "
                + "from reclamo "
                + "LEFT JOIN caso as casoReclamo on reclamo.OIDCaso = casoReclamo.OIDCaso "
                + "LEFT JOIN problemacaso as problemasReclamo on casoReclamo.OIDCaso = problemasReclamo.OIDCaso "
                + "LEFT JOIN problema as problemaSemaforo on problemasReclamo.OIDProblema = problemaSemaforo.OIDProblema "
                + "LEFT JOIN casosemaforo as casoSemaforoReclamo on casoReclamo.OIDCaso = casoSemaforoReclamo.OIDCaso "
                + "LEFT JOIN semaforo as semaforoReclamo on casoSemaforoReclamo.OIDSemaforo = semaforoReclamo.OIDSemaforo "
                + "LEFT JOIN modelo as modeloReclamo ON semaforoReclamo.OIDModelo = modeloReclamo.OIDModelo "
                + "LEFT JOIN tiposemaforo as tipoSemReclamo ON semaforoReclamo.OIDTipoSemaforo = tipoSemReclamo.OIDTipoSemaforo "
                + "LEFT JOIN esquina as esquinaSemReclamo ON semaforoReclamo.OIDEsquina = esquinaSemReclamo.OIDEsquina "
                + "LEFT JOIN orientacion as orientacionSemReclamo ON semaforoReclamo.OIDOrientacion = orientacionSemReclamo.OIDOrientacion "
                + ")as reclamoDenuncia ON denuncia.OIDCaso = reclamoDenuncia.OIDDenReclamo "
                + ") AS denunciaCompleta "
                + "LEFT JOIN ( "
                + "SELECT ordendetrabajo.FechaInicioTrabajo, ordendetrabajo.FechaFinTrabajo, ordendetrabajo.FechaInicioPlanificada, ordendetrabajo.DuracionPrevistaTrabajo, "
                + "equipodetrabajo.NombreEquipo, "
                + "estadoordentrabajo.NombreEstado AS nombreEstadoOrden, "
                + "ordenreparacion.OIDDenuncia, ordenreparacion.CodigoOrdenReparacion, "
                + "informereparacion.FechaInforme, informereparacion.HoraInforme, informereparacion.DuracionReparacion, "
                + "detalleinformereparacion.Comentario, "
                + "fallatecnica.DescripcionFalla AS descripcionFallaInforme, "
                + "estadofallatecnica.NombreEstado AS nombreEstadoFallaInforme "
                + "FROM ordendetrabajo "
                + "LEFT JOIN equipodetrabajo ON ordendetrabajo.OIDEquipoDeTrabajo = equipodetrabajo.OIDEquipoDeTrabajo "
                + "LEFT JOIN ordentrabajoestado ON ordendetrabajo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                + "LEFT JOIN estadoordentrabajo ON ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo "
                + "LEFT JOIN ordenreparacion ON ordendetrabajo.OIDOrdenDeTrabajo = ordenreparacion.OIDOrdenDeTrabajo "
                + "LEFT JOIN informereparacion ON ordenreparacion.OIDOrdenDeTrabajo = informereparacion.OIDOrdenDeTrabajo "
                + "LEFT JOIN detalleinformereparacion ON informereparacion.OIDInformeReparacion = detalleinformereparacion.OIDInformeReparacion "
                + "LEFT JOIN estadofallatecnica ON detalleinformereparacion.OIDEstadoFallaTecnica = estadofallatecnica.OIDEstadoFallaTecnica "
                + "LEFT JOIN fallatecnica ON detalleinformereparacion.OIDFallaTecnica = fallatecnica.OIDTrabajo "
                + "WHERE ordentrabajoestado.IndicadoresEstadoActual = TRUE "
                + ")as ordenReparacionCompleta ON denunciaCompleta.oidDenunciaEncontrada = ordenReparacionCompleta.OIDDenuncia";

        String condicion = " WHERE ";

        for (int i = 0; i < criterios.size(); i++) {
            if (i > 0) {
                condicion += " AND ";
            }
            if (criterios.get(i).getAtributo().equalsIgnoreCase("Operador")) {
                condicion += " denunciaCompleta.operador " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "'";
            } else {
                condicion += " denunciaCompleta." + criterios.get(i).getAtributo() + " " + criterios.get(i).getOperador() + " '" + criterios.get(i).getValor() + "' ";
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

        DTOCaso dtoDenuncia = null;

        boolean pedirDatosPrincipales = true;
        boolean crearNuevoEstadoDenuncia = false;
        boolean crearNuevaOrdenReparacion = false;
        boolean crearNuevoInformeReparacion = false;
        boolean crearNuevoDetalleInforme = false;
        boolean crearNuevaFallaDenuncia = false;
        boolean sumarReclamo = false;
        boolean agregarCalleInterseccion = false;
        boolean crearNuevoSemaforo = false;

        List<String> auxiliaresReclamo = new ArrayList<String>();

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();
        try {

            while (rs.next()) {


                if (pedirDatosPrincipales) {
                    dtoDenuncia = new DTOCaso();
                    dtoDenuncia.setFechaCaso(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(rs.getDate("FechaCaso")));
                    dtoDenuncia.setNroCaso(rs.getString("CodigoDenuncia"));
                    DTOUbicacion ubicacion = new DTOUbicacion();
                    dtoDenuncia.setUbicacion(ubicacion);
                    pedirDatosPrincipales = false;
                }

                //Agregar Ubicacion

                if (rs.getString("calleSimple") != null) {
                    dtoDenuncia.getUbicacion().setCalle1(rs.getString("calleSimple"));
                    dtoDenuncia.getUbicacion().setAltura(rs.getString("Altura"));
                    dtoDenuncia.getUbicacion().setTipo(rs.getString("TipoUbicacion"));
                    agregarCalleInterseccion = false;
                } else if (rs.getString("calleInterseccion") != null) {
                    if (!dtoDenuncia.getUbicacion().seEncuentraCalle(rs.getString("calleInterseccion"))) {
                        agregarCalleInterseccion = true;
                    } else {
                        agregarCalleInterseccion = false;
                    }
                }
                if (agregarCalleInterseccion) {
                    if (dtoDenuncia.getUbicacion().getTipo().isEmpty()) {
                        dtoDenuncia.getUbicacion().setTipo(rs.getString("TipoUbicacion"));
                    }
                    dtoDenuncia.getUbicacion().addCalle(rs.getString("calleInterseccion"));
                }

                //If para saber si agregar problemas
                if(rs.getString("DescripcionProblema") != null && !dtoDenuncia.estaProblema(rs.getString("DescripcionProblema"))){
                    dtoDenuncia.addProblema(rs.getString("DescripcionProblema"));
                }

                //If para saber si agregar problemas
                if(rs.getString("ProblemaReclamo") != null && !dtoDenuncia.estaProblema(rs.getString("ProblemaReclamo"))){
                    dtoDenuncia.addProblema(rs.getString("ProblemaReclamo"));
                }

                //If para saber si agregar nuevo semaforo
                if ((rs.getString("NumeroSerie")!=null)&&!dtoDenuncia.estaSemaforo(rs.getString("NumeroSerie"))) {
                    crearNuevoSemaforo = true;
                } else {
                    crearNuevoSemaforo = false;
                }

                if (crearNuevoSemaforo) {
                    DTOSemaforo nuevoSemaforo = new DTOSemaforo();
                    nuevoSemaforo.setEsquina(rs.getString("esquinaSem"));
                    nuevoSemaforo.setModelo(rs.getString("NombreModelo"));
                    nuevoSemaforo.setNumeroSerie(rs.getString("NumeroSerie"));
                    nuevoSemaforo.setOrientacion(rs.getString("orientacionSem"));
                    nuevoSemaforo.setTipo(rs.getString("tipoSem"));
                    dtoDenuncia.addSemaforo(nuevoSemaforo);
                }

                //If para saber si agregar nuevo semaforo reclamado
                if ((rs.getString("NumeroSerieSemaforoReclamo")!=null)&&!dtoDenuncia.estaSemaforo(rs.getString("NumeroSerieSemaforoReclamo"))) {
                    crearNuevoSemaforo = true;
                } else {
                    crearNuevoSemaforo = false;
                }

                if (crearNuevoSemaforo) {
                    DTOSemaforo nuevoSemaforo = new DTOSemaforo();
                    nuevoSemaforo.setEsquina(rs.getString("esquinaSemReclamo"));
                    nuevoSemaforo.setModelo(rs.getString("NombreModeloReclamo"));
                    nuevoSemaforo.setNumeroSerie(rs.getString("NumeroSerieSemaforoReclamo"));
                    nuevoSemaforo.setOrientacion(rs.getString("orientacionSemReclamo"));
                    nuevoSemaforo.setTipo(rs.getString("DescripcionTipoSemReclamo"));
                    dtoDenuncia.addSemaforo(nuevoSemaforo);
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
                if (rs.getString("CodigoOrdenReparacion") == null) {
                    crearNuevaOrdenReparacion = false;
                } else if (dtoDenuncia.getOrdenesRep() ==  null) {
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
                if ((dtoDenuncia.getOrdenesRep() != null) && rs.getString("DuracionReparacion") != null && dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion"))) {
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
                if (dtoDenuncia.getOrdenesRep() != null && rs.getString("nombreEstadoFallaInforme") != null && !dtoDenuncia.getOrdenesRep().get(dtoDenuncia.getOrdenesRep().size() - 1).getInformeReparacion().seEncuentraDetalle(rs.getString("descripcionFallaInforme"))) {
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

                //if para contar los reclamos
                if (auxiliaresReclamo.isEmpty() && rs.getString("CodigoReclamo") != null) {
                    sumarReclamo = true;
                } else if (rs.getString("CodigoReclamo") != null) {
                    int cantMaxRecl = auxiliaresReclamo.size();
                    for (int i = 0; i < cantMaxRecl; i++) {
                        if (auxiliaresReclamo.get(i).equals(rs.getString("CodigoReclamo"))) {
                            sumarReclamo = false;
                        }
                    }
                }
                if (sumarReclamo) {
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
