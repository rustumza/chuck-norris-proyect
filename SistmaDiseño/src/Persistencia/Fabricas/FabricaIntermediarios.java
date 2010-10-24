package Persistencia.Fabricas;

import Persistencia.intermediarios.IntermediarioPersistencia;
import Persistencia.intermediarios.IntermediarioPersistenciaCalle;
import Persistencia.intermediarios.IntermediarioPersistenciaCaso;
import Persistencia.intermediarios.IntermediarioPersistenciaCasoSemaforo;
import Persistencia.intermediarios.IntermediarioPersistenciaCronogramaMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaDenuncia;
import Persistencia.intermediarios.IntermediarioPersistenciaDenunciaEstado;
import Persistencia.intermediarios.IntermediarioPersistenciaDenunciante;
import Persistencia.intermediarios.IntermediarioPersistenciaDetalleInformeMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaDetalleInformeReparacion;
import Persistencia.intermediarios.IntermediarioPersistenciaElementoTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaElementoTrabajoMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaElementoTrabajoReparacion;
import Persistencia.intermediarios.IntermediarioPersistenciaEquipamiento;
import Persistencia.intermediarios.IntermediarioPersistenciaEquipoDeTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaEsquina;
import Persistencia.intermediarios.IntermediarioPersistenciaEstadoDenuncia;
import Persistencia.intermediarios.IntermediarioPersistenciaEstadoElementoTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaEstadoFallaTecnica;
import Persistencia.intermediarios.IntermediarioPersistenciaEstadoOrdenTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaEstadoPadronPersona;
import Persistencia.intermediarios.IntermediarioPersistenciaFallaTecnica;
import Persistencia.intermediarios.IntermediarioPersistenciaFichaMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaInformeMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaInformeReparacion;
import Persistencia.intermediarios.IntermediarioPersistenciaInterseccion;
import Persistencia.intermediarios.IntermediarioPersistenciaInterseccionCalle;
import Persistencia.intermediarios.IntermediarioPersistenciaMarca;
import Persistencia.intermediarios.IntermediarioPersistenciaModelo;
import Persistencia.intermediarios.IntermediarioPersistenciaNumerador;
import Persistencia.intermediarios.IntermediarioPersistenciaOperador;
import Persistencia.intermediarios.IntermediarioPersistenciaOrdenDeMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaOrdenDeTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaOrdenReparacion;
import Persistencia.intermediarios.IntermediarioPersistenciaOrdenTrabajoEstado;
import Persistencia.intermediarios.IntermediarioPersistenciaOrientacion;
import Persistencia.intermediarios.IntermediarioPersistenciaPeriodicidad;
import Persistencia.intermediarios.IntermediarioPersistenciaPersonaPadron;
import Persistencia.intermediarios.IntermediarioPersistenciaPersonaPadronEstado;
import Persistencia.intermediarios.IntermediarioPersistenciaPesoDeReclamo;
import Persistencia.intermediarios.IntermediarioPersistenciaProblema;
import Persistencia.intermediarios.IntermediarioPersistenciaProblemaCaso;
import Persistencia.intermediarios.IntermediarioPersistenciaRangoAnios;
import Persistencia.intermediarios.IntermediarioPersistenciaReclamo;
import Persistencia.intermediarios.IntermediarioPersistenciaReparacionTareaRealizada;
import Persistencia.intermediarios.IntermediarioPersistenciaRepuesto;
import Persistencia.intermediarios.IntermediarioPersistenciaReserva;
import Persistencia.intermediarios.IntermediarioPersistenciaReservaElementoTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaRol;
import Persistencia.intermediarios.IntermediarioPersistenciaSemaforo;
import Persistencia.intermediarios.IntermediarioPersistenciaTarea;
import Persistencia.intermediarios.IntermediarioPersistenciaTareaFichaMantenimiento;
import Persistencia.intermediarios.IntermediarioPersistenciaTipoSemaforo;
import Persistencia.intermediarios.IntermediarioPersistenciaTrabajador;
import Persistencia.intermediarios.IntermediarioPersistenciaTrabajadorRol;
import Persistencia.intermediarios.IntermediarioPersistenciaTrabajadorTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaTrabajoElementoNecesario;
import Persistencia.intermediarios.IntermediarioPersistenciaTrabajoOrdenDeTrabajo;
import Persistencia.intermediarios.IntermediarioPersistenciaUbicacion;
import Persistencia.intermediarios.IntermediarioPersistenciaUbicacionSimple;
import Persistencia.intermediarios.IntermediarioPersistenciaUsuario;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author diego
 */
public class FabricaIntermediarios {

    static FabricaIntermediarios instancia = null;

    private FabricaIntermediarios() {
    }

    public static FabricaIntermediarios getInstancia() {
        if (instancia == null) {
            instancia = new FabricaIntermediarios();
        }
        return instancia;

    }

    public IntermediarioPersistencia crearIntermediario(String nombre) {
        IntermediarioPersistencia intermediario = null;

        if(nombre.equals("Calle")){
            
            intermediario = (IntermediarioPersistencia) (new IntermediarioPersistenciaCalle());
        }


        if (nombre.equals("Caso")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaCaso() {});
        }

        if (nombre.equals("CronogramaMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaCronogramaMantenimiento());
        }

        if (nombre.equals("Denuncia")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaDenuncia());
        }

        if (nombre.equals("DenunciaEstado")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaDenunciaEstado());
        }
        if (nombre.equalsIgnoreCase("Denunciante")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaDenunciante());
        }

        if (nombre.equals("DetalleInformeMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaDetalleInformeMantenimiento());
        }

        if (nombre.equals("DetalleInformeReparacion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaDetalleInformeReparacion());
        }
        if (nombre.equals("ElementoTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaElementoTrabajo());
        }

        if (nombre.equals("ElementoTrabajoMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaElementoTrabajoMantenimiento());
        }

        if (nombre.equals("ElementoTrabajoReparacion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaElementoTrabajoReparacion());
        }
        if (nombre.equals("Equipamiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEquipamiento());
        }

        if (nombre.equals("EquipoDeTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEquipoDeTrabajo());
        }

        if (nombre.equals("Esquina")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEsquina());
        }
        if (nombre.equals("EstadoDenuncia")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEstadoDenuncia());
        }

        if (nombre.equals("EstadoElementoTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEstadoElementoTrabajo());
        }

        if (nombre.equals("EstadoFallaTecnica")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEstadoFallaTecnica());
        }
        if (nombre.equals("EstadoOrdenTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEstadoOrdenTrabajo());
        }

        if (nombre.equals("EstadoPadronPersona")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaEstadoPadronPersona());
        }

        if (nombre.equals("FallaTecnica")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaFallaTecnica());
        }

        if (nombre.equals("FichaMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaFichaMantenimiento());
        }

        if (nombre.equals("InformeMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaInformeMantenimiento());
        }

        if (nombre.equals("InformeReparacion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaInformeReparacion());
        }
        
        if (nombre.equals("Interseccion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaInterseccion());
        }

        if (nombre.equals("InterseccionCalle")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaInterseccionCalle());
        }
        if (nombre.equals("Marca")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaMarca());
        }

        if (nombre.equals("Modelo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaModelo());
        }

        if (nombre.equals("Numerador")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaNumerador());
        }

        if (nombre.equals("Operador")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaOperador());
        }

        if (nombre.equals("OrdenDeMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaOrdenDeMantenimiento());
        }

        if (nombre.equals("OrdenTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaOrdenDeTrabajo());
        }

        if (nombre.equals("OrdenReparacion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaOrdenReparacion());
        }

        if (nombre.equals("OrdenTrabajoEstado")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaOrdenTrabajoEstado());
        }

        if (nombre.equals("Orientacion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaOrientacion());
        }
        if (nombre.equals("Periodicidad")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaPeriodicidad());
        }

        if (nombre.equals("PersonaPadron")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaPersonaPadron());
        }

        if (nombre.equals("PersonaPadronEstado")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaPersonaPadronEstado());
        }

        if (nombre.equals("PesoDeReclamo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaPesoDeReclamo());
        }

        if (nombre.equals("Problema")) {
            intermediario = (IntermediarioPersistencia) (new IntermediarioPersistenciaProblema());
        }

        if (nombre.equals("ProblemaCaso")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaProblemaCaso());
        }

        if (nombre.equals("RangoAnios")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaRangoAnios());
        }

        if (nombre.equals("Reclamo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaReclamo());
        }

        if (nombre.equals("ReparacionTareaRealizada")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaReparacionTareaRealizada());
        }

        if (nombre.equals("Repuesto")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaRepuesto());
        }

        if (nombre.equals("Reserva")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaReserva());
        }
        if (nombre.equals("ReservaElementoTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaReservaElementoTrabajo());
        }

        if (nombre.equals("Rol")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaRol());
        }

        if (nombre.equals("Semaforo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaSemaforo());
        }

        if (nombre.equals("Tarea")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTarea());
        }

        if (nombre.equals("TareaFichaMantenimiento")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTareaFichaMantenimiento());
        }

        if (nombre.equals("TipoSemaforo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTipoSemaforo());
        }

        if (nombre.equals("Trabajador")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTrabajador());
        }

        if (nombre.equals("TrabajadorRol")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTrabajadorRol());
        }

        if (nombre.equals("TrabajadorTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTrabajadorTrabajo());
        }

        if (nombre.equals("Trabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTrabajo());
        }

        if (nombre.equals("TrabajoElementoNecesario")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTrabajoElementoNecesario());
        }

        if (nombre.equals("TrabajoOrdenDeTrabajo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaTrabajoOrdenDeTrabajo());
        }
        if (nombre.equals("Ubicacion")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaUbicacion());
        }

        if (nombre.equals("UbicacionSimple")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaUbicacionSimple());
        }
        if (nombre.equals("AUXCasoSemaforo")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaCasoSemaforo());
        }
        if (nombre.equals("AUXProblemaCaso")) {
            intermediario = (IntermediarioPersistencia)(new IntermediarioPersistenciaProblemaCaso());
        }
        if (nombre.equals("Usuario")) {
            intermediario = (IntermediarioPersistencia) (new IntermediarioPersistenciaUsuario());
        }
        return intermediario;
    }
}
