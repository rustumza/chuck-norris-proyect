/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import DTO.DTOEquipamientoReservado;
import DTO.DTOFallaTecnica;
import DTO.DTOOrden;
import DTO.DTORepuestoReservado;
import DTO.DTOReserva;
import DTO.DTOSemaforo;
import DTO.DTOUbicacion;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Criterio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class IntermediarioDTOOrdenReparacion extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {

        String select = "SELECT ordensemaforo.OIDOrdenDeTrabajo, "
                + "ordensemaforo.FechaInicioTrabajo,ordensemaforo.FechaFinTrabajo, ordensemaforo.FechaInicioPlanificada, ordensemaforo.DuracionPrevistaTrabajo, "
                + "ordensemaforo.Tipo, "
                + "ordenreparacion.CodigoOrdenReparacion, "
                + "denuncia.CodigoDenuncia, "
                + "semaforo.NumeroSerie, "
                + "modelo.NombreModelo, "
                + "reserva.FechaReserva, reserva.CodigoReserva, reservaelementotrabajo.CantidadReservada, "
                + "equipamiento.NombreEquipamiento, "
                + "repuesto.NombreRepuesto, "
                + "equipodetrabajo.NombreEquipo, "
                + "estadoordentrabajo.NombreEstado, "
                + "fallatecnica.CodigoFallaTecnica, fallatecnica.DescripcionFalla, "
                + "trabajo.NombreTrabajo, "
                + "ubicacion.OIDUbicacion as OIDUbicacion, ubicacion.CodigoUbicacion, ubicacion.Prioridad, ubicacion.TipoUbicacion, "
                + "ubicacionsimple.Altura, "
                + "interseccion.OIDUbicacion as OIDInterseccion, interseccioncalle.OIDCalle as intercalle, "
                + "calleInterseccion.NombreCalle as calleInterseccion, "
                + "calleUbicacionSimple.NombreCalle as calleUbSimple "
                + "from ordendetrabajo as ordensemaforo "
                + "join ordentrabajoestado "
                + "on ordensemaforo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                + "join estadoordentrabajo "
                + "on ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo "
                + "join ordenreparacion "
                + "on ordensemaforo.OIDOrdenDeTrabajo = ordenreparacion.OIDOrdenDeTrabajo "
                + "join denuncia "
                + "on ordenreparacion.OIDDenuncia = denuncia.OIDCaso "
                + "left join fallatecnicadenuncia "
                + "on denuncia.OIDCaso = fallatecnicadenuncia.OIDDenuncia "
                + "left join fallatecnica "
                + "on fallatecnicadenuncia.OIDFallaTecnica = fallatecnica.OIDTrabajo "
                + "left join trabajo "
                + "on fallatecnica.OIDTrabajo = trabajo.OIDTrabajo "
                + "join caso "
                + "on denuncia.OIDCaso = caso.OIDCaso "
                + "join casosemaforo "
                + "on caso.OIDCaso = casosemaforo.OIDCaso "
                + "join semaforo "
                + "on casosemaforo.OIDSemaforo = semaforo.OIDSemaforo "
                + "join modelo "
                + "on semaforo.OIDModelo = modelo.OIDModelo "
                + "join ubicacion "
                + "on semaforo.OIDUbicacion = ubicacion.OIDUbicacion "
                + "left join ubicacionsimple "
                + "on ubicacion.OIDUbicacion = ubicacionsimple.OIDUbicacion "
                + "left join calle as calleUbicacionSimple "
                + "on ubicacionsimple.OIDCalle = calleUbicacionSimple.OIDCalle "
                + "left join interseccion "
                + "on ubicacion.OIDUbicacion = interseccion.OIDUbicacion "
                + "LEFT JOIN interseccioncalle "
                + "on interseccion.OIDUbicacion = interseccioncalle.OIDInterseccion "
                + "left join calle as calleInterseccion "
                + "on interseccioncalle.OIDCalle = calleInterseccion.OIDCalle "
                + "left join reserva "
                + "on ordensemaforo.OIDOrdenDeTrabajo  = reserva.OIDOrdenDeTrabajo "
                + "join reservaelementotrabajo "
                + "on reserva.OIDReserva = reservaelementotrabajo.OIDReserva "
                + "join elementotrabajo "
                + "on reservaelementotrabajo.OIDElementoTrabajo = elementotrabajo.OIDElementoTrabajo "
                + "left join repuesto "
                + "on elementotrabajo.OIDElementoTrabajo = repuesto.OIDElementoTrabajo "
                + "left join equipamiento "
                + "on elementotrabajo.OIDElementoTrabajo = equipamiento.OIDElementoTrabajo "
                + "join equipodetrabajo "
                + "on ordensemaforo.OIDEquipoDeTrabajo = equipodetrabajo.OIDEquipoDeTrabajo";

        String condicion = "";
        condicion = " WHERE ordensemaforo.FechaInicioPlanificada = '" + criterios.get(0).getValor() + "'";
        if (criterios.size() == 2) {
            condicion = condicion + " AND " + criterios.get(1).getAtributo() + criterios.get(1).getOperador() + "'" + criterios.get(1).getValor() + "'";
        }
        condicion = condicion + " AND IndicadoresEstadoActual = TRUE";


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

        List<DTOOrden> listaOrdenes = new ArrayList<DTOOrden>();

        List<ObjetoPersistente> nuevosObjetos = new ArrayList<ObjetoPersistente>();

        boolean crearNuevaOrden = false;
        boolean crearNuevaReserva = false;
        boolean crearDtoEquipamiento = false;
        boolean crearDtoRepuesto = false;
        boolean crearDtoSemaforo = false;
        boolean crearDtoFalla = false;
        boolean agregarCalleUbicacion = false;


        try {

            while (rs.next()) {

                if (listaOrdenes.isEmpty() && rs.getString("OIDOrdenDeTrabajo") != null) {
                    crearNuevaOrden = true;
                } else if (!listaOrdenes.get(listaOrdenes.size() - 1).getNroOrden().equals(rs.getString("CodigoOrdenReparacion")) && rs.getString("CodigoOrdenReparacion") != null) {
                    crearNuevaOrden = true;
                } else {
                    crearNuevaOrden = false;
                }

                if (crearNuevaOrden) {
                    DTOOrden nuevaOrden = new DTOOrden();
                    nuevaOrden.setDuracionPrevista(rs.getInt("DuracionPrevistaTrabajo"));
                    nuevaOrden.setEstado(rs.getString("NombreEstado"));
                    nuevaOrden.setFechaFinTrabajo(rs.getDate("FechaFinTrabajo"));
                    nuevaOrden.setFechaInicioPlanificada(rs.getDate("FechaInicioPlanificada"));
                    nuevaOrden.setFechaInicioTrabajo(rs.getDate("FechaInicioTrabajo"));
                    nuevaOrden.setNombreEquipo(rs.getString("NombreEquipo"));
                    nuevaOrden.setNroCaso(rs.getString("CodigoDenuncia"));
                    nuevaOrden.setNroOrden(rs.getString("CodigoOrdenReparacion"));
                    nuevaOrden.setTipo(rs.getString("Tipo"));
                    listaOrdenes.add(nuevaOrden);
                }

                if (listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().isEmpty() && rs.getString("CodigoReserva") != null) {
                    crearNuevaReserva = true;
                } else if (!listaOrdenes.isEmpty() && listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().get(listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().size() - 1).getNumeroReserva() != rs.getInt("CodigoReserva")) {
                    crearNuevaReserva = true;
                } else {
                    crearNuevaReserva = false;
                }

                if (crearNuevaReserva) {
                    DTOReserva nuevaReserva = new DTOReserva();
                    nuevaReserva.setFechaReserva(rs.getDate("FechaReserva"));
                    nuevaReserva.setNumeroReserva(rs.getInt("CodigoReserva"));
                    listaOrdenes.get(listaOrdenes.size() - 1).addReserva(nuevaReserva);
                }

                if (rs.getString("NombreEquipamiento") != null && !listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().get(listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().size() - 1).seEncuentraEquipamiento(rs.getString("NombreEquipamiento"))) {
                    crearDtoEquipamiento = true;
                } else {
                    crearDtoEquipamiento = false;
                }

                if (crearDtoEquipamiento) {
                    DTOEquipamientoReservado nuevoDTOEquipamiento = new DTOEquipamientoReservado();
                    nuevoDTOEquipamiento.setCantidad(rs.getInt("CantidadReservada"));
                    nuevoDTOEquipamiento.setNombreEquipamiento(rs.getString("NombreEquipamiento"));
                    listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().get(listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().size() - 1).addEquipamiento(nuevoDTOEquipamiento);
                }

                if (rs.getString("NombreRepuesto") != null && !listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().get(listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().size() - 1).seEncuentraRepuesto(rs.getString("NombreRepuesto"))) {
                    crearDtoRepuesto = true;
                } else {
                    crearDtoRepuesto = false;
                }

                if (crearDtoRepuesto) {
                    DTORepuestoReservado nuevoDTORepuesto = new DTORepuestoReservado();
                    nuevoDTORepuesto.setCantidad(rs.getInt("CantidadReservada"));
                    nuevoDTORepuesto.setNombre(rs.getString("NombreRepuesto"));
                    listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().get(listaOrdenes.get(listaOrdenes.size() - 1).getListaReservas().size() - 1).addRepuesto(nuevoDTORepuesto);
                }

                if (rs.getString("NumeroSerie") == null) {
                    crearDtoSemaforo = false;
                } else if (listaOrdenes.get(listaOrdenes.size() - 1).getListaSemaforos().isEmpty()) {
                    crearDtoSemaforo = true;
                } else if (!listaOrdenes.get(listaOrdenes.size() - 1).seEncuentraSemaforo(rs.getString("NumeroSerie"))) {
                    crearDtoSemaforo = true;
                } else {
                    crearDtoSemaforo = false;
                }

                if (crearDtoSemaforo) {
                    DTOSemaforo nuevoSemaforo = new DTOSemaforo();
                    nuevoSemaforo.setModelo(rs.getString("NombreModelo"));
                    nuevoSemaforo.setNumeroSerie(rs.getString("NumeroSerie"));
                    listaOrdenes.get(listaOrdenes.size() - 1).addSemaforo(nuevoSemaforo);
                }

                if (rs.getString("CodigoFallaTecnica") == null) {
                    crearDtoFalla = false;
                } else if (listaOrdenes.get(listaOrdenes.size() - 1).getListaFalla().isEmpty()) {
                    crearDtoFalla = true;
                } else if (!listaOrdenes.get(listaOrdenes.size() - 1).seEncuentraFalla(rs.getString("CodigoFallaTecnica"))) {
                    crearDtoFalla = true;
                } else {
                    crearDtoFalla = false;
                }

                if (crearDtoFalla) {
                    DTOFallaTecnica nuevaFalla = new DTOFallaTecnica();
                    nuevaFalla.setCodigoFalla(rs.getString("CodigoFallaTecnica"));
                    nuevaFalla.setDescripcion(rs.getString("CodigoFallaTecnica"));
                    nuevaFalla.setNombreFalla(rs.getString("NombreTrabajo"));
                    listaOrdenes.get(listaOrdenes.size() - 1).addFalla(nuevaFalla);
                }

                if (rs.getString("OIDInterseccion") != null) {
                    if (listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion() == null) {
                        DTOUbicacion nuevaUbicacion = new DTOUbicacion();
                        listaOrdenes.get(listaOrdenes.size() - 1).setUbicacion(nuevaUbicacion);
                        agregarCalleUbicacion = true;
                    } else if (!listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion().seEncuentraCalle(rs.getString("calleInterseccion"))) {
                        agregarCalleUbicacion = true;
                    } else {
                        agregarCalleUbicacion = false;
                    }

                } else if (rs.getString("calleUbSimple") != null) {
                    if (listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion() == null) {
                        DTOUbicacion nuevaUbicacion = new DTOUbicacion();
                        listaOrdenes.get(listaOrdenes.size() - 1).setUbicacion(nuevaUbicacion);
                        agregarCalleUbicacion = true;
                    } else if (!listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion().seEncuentraCalle(rs.getString("calleInterseccion"))) {
                        agregarCalleUbicacion = true;
                    } else {
                        agregarCalleUbicacion = false;
                    }
                }

                if(agregarCalleUbicacion){
                    if(rs.getString("OIDInterseccion") != null){
                        listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion().addCalle(rs.getString("calleInterseccion"));
                    }else if(rs.getString("calleUbSimple") != null){
                        listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion().setCalle1(rs.getString("calleUbSimple"));
                        listaOrdenes.get(listaOrdenes.size() - 1).getUbicacion().setAltura(rs.getString("Altura"));
                    }
                }


            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch(Exception ex){
            ex.printStackTrace();
        }

        for (DTOOrden dTOOrden : listaOrdenes) {
            nuevosObjetos.add(dTOOrden);
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
