/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.intermediarios;

import DTO.DTOEquipamientoReservado;
import DTO.DTOOrden;
import DTO.DTORepuestoReservado;
import DTO.DTOReserva;
import DTO.DTOSemaforo;
import DTO.DTOTareaFichaMantenimiento;
import DTO.DTOUbicacion;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Criterio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEIVA
 */
public class IntermediarioDTOOrdenMantenimiento extends IntermediarioRelacional {

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        return null;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {
        String select = "Select ordenmantenimiento.CodigoOrdenMantenimiento as nroOrden, "
                + "ordendetrabajo.OIDOrdenDeTrabajo, ordendetrabajo.DuracionPrevistaTrabajo, ordendetrabajo.FechaInicioTrabajo, ordendetrabajo.FechaFinTrabajo, ordendetrabajo.FechaInicioPlanificada,ordendetrabajo.Tipo, "
                + "equipodetrabajo.NombreEquipo, "
                + "estadoordentrabajo.NombreEstado, "
                + "reserva.FechaReserva, reserva.CodigoReserva, "
                + "reservaelementotrabajo.CantidadReservada, "
                + "equipamiento.NombreEquipamiento, "
                + "repuesto.NombreRepuesto, "
                + "semaforo.NumeroSerie, "
                + "modelo.NombreModelo, "
                + "trabajo.NombreTrabajo, "
                + "tarea.CodigoTarea, tarea.DescripcionTarea, "
                + "ubicacion.OIDUbicacion as OIDUbicacion, ubicacion.CodigoUbicacion, ubicacion.Prioridad, ubicacion.TipoUbicacion, "
                + "ubicacionsimple.Altura, "
                + "interseccion.OIDUbicacion as OIDInterseccion, interseccioncalle.OIDCalle as intercalle, "
                + "calleInterseccion.NombreCalle as calleInterseccion, "
                + "calleUbSimple.NombreCalle as calleUbSimple "
                + "from ordendetrabajo "
                + "join ordentrabajoestado on ordendetrabajo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                + "join estadoordentrabajo on ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo "
                + "join equipodetrabajo on ordendetrabajo.OIDEquipoDeTrabajo = equipodetrabajo.OIDEquipoDeTrabajo "
                + "left join reserva on ordendetrabajo.OIDOrdenDeTrabajo  = reserva.OIDOrdenDeTrabajo "
                + "join reservaelementotrabajo on reserva.OIDReserva = reservaelementotrabajo.OIDReserva "
                + "join elementotrabajo on reservaelementotrabajo.OIDElementoTrabajo = elementotrabajo.OIDElementoTrabajo "
                + "left join repuesto on elementotrabajo.OIDElementoTrabajo = repuesto.OIDElementoTrabajo "
                + "left join equipamiento on elementotrabajo.OIDElementoTrabajo = equipamiento.OIDElementoTrabajo "
                + "join ordenmantenimiento on ordendetrabajo.OIDOrdenDeTrabajo = ordenmantenimiento.OIDOrdenDeTrabajo "
                + "join fichamantenimiento on ordenmantenimiento.OIDFichaMantenimiento = fichamantenimiento.OIDFichaMantenimiento "
                + "join tareafichamantenimiento on fichamantenimiento.OIDFichaMantenimiento = tareafichamantenimiento.OIDFichaMantenimiento "
                + "join tarea on tareafichamantenimiento.OIDTarea = tarea.OIDTrabajo "
                + "join trabajo on tarea.OIDTrabajo = trabajo.OIDTrabajo "
                + "join semaforo on ordenmantenimiento.OIDSemaforo = semaforo.OIDSemaforo "
                + "join modelo on semaforo.OIDModelo = modelo.OIDModelo "
                + "join ubicacion on semaforo.OIDUbicacion = ubicacion.OIDUbicacion "
                + "left join ubicacionsimple on ubicacion.OIDUbicacion = ubicacionsimple.OIDUbicacion "
                + "left join interseccion on ubicacion.OIDUbicacion = interseccion.OIDUbicacion "
                + "left join calle as calleUbSimple on ubicacionsimple.OIDCalle = calleUbSimple.OIDCalle "
                + "LEFT JOIN interseccioncalle on interseccion.OIDUbicacion = interseccioncalle.OIDInterseccion "
                + "left join calle as calleInterseccion on interseccioncalle.OIDCalle = calleInterseccion.OIDCalle";

        String condicion = "";
        condicion = " WHERE ordendetrabajo.FechaInicioPlanificada = '" + criterios.get(0).getValor() + "'";
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
        boolean creardtoFichaMant = false;
        boolean agregarCalleUbicacion = false;


        try {

            while (rs.next()) {

                if (listaOrdenes.isEmpty() && rs.getString("OIDOrdenDeTrabajo") != null) {
                    crearNuevaOrden = true;
                } else if (!estaOrdenTrabajo(listaOrdenes, rs.getString("nroOrden")) && rs.getString("nroOrden") != null) {
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
                    nuevaOrden.setNroOrden(rs.getString("nroOrden"));
                    nuevaOrden.setTipo(rs.getString("Tipo"));
                    listaOrdenes.add(nuevaOrden);
                }

                if (buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaReservas().isEmpty() && rs.getString("CodigoReserva") != null) {
                    crearNuevaReserva = true;
                } else if (!listaOrdenes.isEmpty() && !buscarOrden(listaOrdenes, rs.getString("nroOrden")).seEncuentraReserva(rs.getString("CodigoReserva"))) {
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

                if (rs.getString("NombreEquipamiento") != null && !buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaReservas().get(buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaReservas().size() - 1).seEncuentraEquipamiento(rs.getString("NombreEquipamiento"))) {
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

                if (rs.getString("NombreRepuesto") != null && !buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaReservas().get(buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaReservas().size() - 1).seEncuentraRepuesto(rs.getString("NombreRepuesto"))) {
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
                } else if (buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaSemaforos().isEmpty()) {
                    crearDtoSemaforo = true;
                } else if (!buscarOrden(listaOrdenes, rs.getString("nroOrden")).seEncuentraSemaforo(rs.getString("NumeroSerie"))) {
                    crearDtoSemaforo = true;
                } else {
                    crearDtoSemaforo = false;
                }

                if (crearDtoSemaforo) {
                    DTOSemaforo nuevoSemaforo = new DTOSemaforo();
                    nuevoSemaforo.setModelo(rs.getString("NombreModelo"));
                    nuevoSemaforo.setNumeroSerie(rs.getString("NumeroSerie"));
                    buscarOrden(listaOrdenes, rs.getString("nroOrden")).addSemaforo(nuevoSemaforo);
                }

                if (rs.getString("CodigoTarea") != null) {
                    if (buscarOrden(listaOrdenes, rs.getString("nroOrden")).getListaTareasMantenimiento() == null) {
                        creardtoFichaMant = true;
                    } else if (!buscarOrden(listaOrdenes, rs.getString("nroOrden")).seEncuentraTareaMant(rs.getString("CodigoTarea"))) {
                        creardtoFichaMant = true;
                    } else {
                        creardtoFichaMant = false;
                    }
                } else {
                    creardtoFichaMant = false;
                }

                if (creardtoFichaMant) {
                    DTOTareaFichaMantenimiento nuevaTarea = new DTOTareaFichaMantenimiento();
                    nuevaTarea.setCodigoTarea(rs.getString("CodigoTarea"));
                    nuevaTarea.setDescripcion(rs.getString("DescripcionTarea"));
                    nuevaTarea.setNombreTarea(rs.getString("NombreTrabajo"));
                    buscarOrden(listaOrdenes, rs.getString("nroOrden")).addTareaMantenimiento(nuevaTarea);
                }

                if (rs.getString("OIDInterseccion") != null) {
                    if (buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion() == null) {
                        DTOUbicacion nuevaUbicacion = new DTOUbicacion();
                        listaOrdenes.get(listaOrdenes.size() - 1).setUbicacion(nuevaUbicacion);
                        agregarCalleUbicacion = true;
                    } else if (!buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion().seEncuentraCalle(rs.getString("calleInterseccion"))) {
                        agregarCalleUbicacion = true;
                    } else {
                        agregarCalleUbicacion = false;
                    }

                } else if (rs.getString("calleUbSimple") != null) {
                    if (buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion() == null) {
                        DTOUbicacion nuevaUbicacion = new DTOUbicacion();
                        buscarOrden(listaOrdenes, rs.getString("nroOrden")).setUbicacion(nuevaUbicacion);
                        agregarCalleUbicacion = true;
                    } else if (!buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion().seEncuentraCalle(rs.getString("calleInterseccion"))) {
                        agregarCalleUbicacion = true;
                    } else {
                        agregarCalleUbicacion = false;
                    }
                }

                if (agregarCalleUbicacion) {
                    if (rs.getString("OIDInterseccion") != null) {
                        buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion().addCalle(rs.getString("calleInterseccion"));
                    } else if (rs.getString("calleUbSimple") != null) {
                        buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion().setCalle1(rs.getString("calleUbSimple"));
                        buscarOrden(listaOrdenes, rs.getString("nroOrden")).getUbicacion().setAltura(rs.getString("Altura"));
                    }
                }


            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

    public boolean estaOrdenTrabajo(List<DTOOrden>ordenes, String nroOrden){
        boolean seEncuentraOrden = false;

        for (DTOOrden dTOOrden : ordenes) {
            if(dTOOrden.getNroOrden().equals(nroOrden)){
                seEncuentraOrden = true;
                break;
            }
        }

        return seEncuentraOrden;
    }

    public DTOOrden buscarOrden(List<DTOOrden> ordenes, String nroOrden){
        DTOOrden ordenEncontrada = null;
        for (DTOOrden dTOOrden : ordenes) {
            if(dTOOrden.getNroOrden().equals(nroOrden)){
                ordenEncontrada = dTOOrden;
                break;
            }
        }
        return ordenEncontrada;
    }
}
