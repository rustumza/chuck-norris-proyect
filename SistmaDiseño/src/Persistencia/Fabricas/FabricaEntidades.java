package Persistencia.Fabricas;

import Persistencia.Entidades.CalleAgente;
import Persistencia.Entidades.CalleImplementacion;
import Persistencia.Entidades.CasoAgente;
import Persistencia.Entidades.CasoImplementacion;
import Persistencia.Entidades.CronogramaDeMantenimientoAgente;
import Persistencia.Entidades.CronogramaDeMantenimientoImplementacion;
import Persistencia.Entidades.DenunciaAgente;
import Persistencia.Entidades.DenunciaEstadoAgente;
import Persistencia.Entidades.DenunciaEstadoImplementacion;
import Persistencia.Entidades.DenunciaImplementacion;
import Persistencia.Entidades.DenuncianteAgente;
import Persistencia.Entidades.DenuncianteImplementacion;
import Persistencia.Entidades.DetalleInformeMantenimientoAgente;
import Persistencia.Entidades.DetalleInformeMantenimientoImplementacion;
import Persistencia.Entidades.DetalleInformeReparacionAgente;
import Persistencia.Entidades.DetalleInformeReparacionImplementacion;
import Persistencia.Entidades.ElementoTrabajoAgente;
import Persistencia.Entidades.ElementoTrabajoImplementacion;
import Persistencia.Entidades.ElementoTrabajoMantenimientoAgente;
import Persistencia.Entidades.ElementoTrabajoMantenimientoImplementacion;
import Persistencia.Entidades.ElementoTrabajoReparacionAgente;
import Persistencia.Entidades.ElementoTrabajoReparacionImplementacion;
import Persistencia.Entidades.EquipamientoAgente;
import Persistencia.Entidades.EquipamientoImplementacion;
import Persistencia.Entidades.EquipoDeTrabajoAgente;
import Persistencia.Entidades.EquipoDeTrabajoImplementacion;
import Persistencia.Entidades.EsquinaAgente;
import Persistencia.Entidades.EsquinaImplementacion;
import Persistencia.Entidades.EstadoDenunciaAgente;
import Persistencia.Entidades.EstadoDenunciaImplementacion;
import Persistencia.Entidades.EstadoElementoTrabajoAgente;
import Persistencia.Entidades.EstadoElementoTrabajoImplementacion;
import Persistencia.Entidades.EstadoFallaTecnicaAgente;
import Persistencia.Entidades.EstadoFallaTecnicaImplementacion;
import Persistencia.Entidades.EstadoOrdenTrabajoAgente;
import Persistencia.Entidades.EstadoOrdenTrabajoImplementacion;
import Persistencia.Entidades.EstadoPersonaPadronAgente;
import Persistencia.Entidades.EstadoPersonaPadronImplementacion;
import Persistencia.Entidades.FallaTecnicaAgente;
import Persistencia.Entidades.FallaTecnicaImplementacion;
import Persistencia.Entidades.FichaMantenimientoAgente;
import Persistencia.Entidades.FichaMantenimientoImplementacion;
import Persistencia.Entidades.InformeMantenimientoAgente;
import Persistencia.Entidades.InformeMantenimientoImplementacion;
import Persistencia.Entidades.InformeReparacionAgente;
import Persistencia.Entidades.InformeReparacionImplementacion;
import Persistencia.Entidades.InterseccionAgente;
import Persistencia.Entidades.InterseccionImplementacion;
import Persistencia.Entidades.MarcaAgente;
import Persistencia.Entidades.MarcaImplementacion;
import Persistencia.Entidades.ModeloAgente;
import Persistencia.Entidades.ModeloImplementacion;
import Persistencia.Entidades.NumeradorAgente;
import Persistencia.Entidades.NumeradorImplementacion;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.OperadorAgente;
import Persistencia.Entidades.OperadorImplementacion;
import Persistencia.Entidades.OrdenDeMantenimientoAgente;
import Persistencia.Entidades.OrdenDeMantenimientoImplementacion;
import Persistencia.Entidades.OrdenDeReparacionAgente;
import Persistencia.Entidades.OrdenDeReparacionImplementacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.OrdenTrabajoAgente;
import Persistencia.Entidades.OrdenTrabajoEstadoAgente;
import Persistencia.Entidades.OrdenTrabajoEstadoImplementacion;
import Persistencia.Entidades.OrdenTrabajoImplementacion;
import Persistencia.Entidades.OrdenTrabajoRepuestoNecesarioAgente;
import Persistencia.Entidades.OrdenTrabajoRepuestoNecesarioImplementacion;
import Persistencia.Entidades.OrientacionAgente;
import Persistencia.Entidades.OrientacionImplementacion;
import Persistencia.Entidades.PeriodicidadAgente;
import Persistencia.Entidades.PeriodicidadImplementacion;
import Persistencia.Entidades.PersonaPadronAgente;
import Persistencia.Entidades.PersonaPadronEstadoAgente;
import Persistencia.Entidades.PersonaPadronEstadoImplementacion;
import Persistencia.Entidades.PersonaPadronImplementacion;
import Persistencia.Entidades.PesoDeReclamoAgente;
import Persistencia.Entidades.PesoDeReclamoImplementacion;
import Persistencia.Entidades.ProblemaAgente;
import Persistencia.Entidades.ProblemaImplementacion;
import Persistencia.Entidades.RangoAniosAgente;
import Persistencia.Entidades.RangoAniosImplementacion;
import Persistencia.Entidades.ReclamoAgente;
import Persistencia.Entidades.ReclamoImplementacion;
import Persistencia.Entidades.ReparacionTareaRealizadaAgente;
import Persistencia.Entidades.ReparacionTareaRealizadaImplementacion;
import Persistencia.Entidades.RepuestoAgente;
import Persistencia.Entidades.RepuestoImplementacion;
import Persistencia.Entidades.ReservaAgente;
import Persistencia.Entidades.ReservaElementoTrabajoAgente;
import Persistencia.Entidades.ReservaElementoTrabajoImplementacion;
import Persistencia.Entidades.ReservaImplementacion;
import Persistencia.Entidades.RolAgente;
import Persistencia.Entidades.RolImplementacion;
import Persistencia.Entidades.SemaforoAgente;
import Persistencia.Entidades.SemaforoImplementacion;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.Entidades.TareaAgente;
import Persistencia.Entidades.TareaImplementacion;
import Persistencia.Entidades.TipoSemaforoAgente;
import Persistencia.Entidades.TipoSemaforoImplementacion;
import Persistencia.Entidades.TrabajadorAgente;
import Persistencia.Entidades.TrabajadorImplementacion;
import Persistencia.Entidades.TrabajadorRolAgente;
import Persistencia.Entidades.TrabajadorRolImplementacion;
import Persistencia.Entidades.TrabajoAgente;
import Persistencia.Entidades.TrabajoElementoNecesarioAgente;
import Persistencia.Entidades.TrabajoElementoNecesarioImplementacion;
import Persistencia.Entidades.TrabajoImplementacion;
import Persistencia.Entidades.UbicacionAgente;
import Persistencia.Entidades.UbicacionImplementacion;
import Persistencia.Entidades.UbicacionSimpleAgente;
import Persistencia.Entidades.UbicacionSimpleImplementacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bicentenario
 */
public class FabricaEntidades {

    private static FabricaEntidades instancia = null;

    public static FabricaEntidades getInstancia(){
        if(instancia == null)
            instancia = new FabricaEntidades();
        return instancia;
    }

    public SuperDruperInterfaz crearEntidad(String entidad) {

        if (entidad.equals("OrdenTrabajo")) {
            OrdenTrabajoImplementacion ordenTrabImpl = new OrdenTrabajoImplementacion();
            OrdenTrabajoAgente ordenTrabAgente = new OrdenTrabajoAgente();
            ordenTrabAgente.setImplementacion(ordenTrabImpl);

            return ordenTrabAgente;
        } else if (entidad.equals("Calle")) {
            CalleImplementacion calleImpl = new CalleImplementacion();
            CalleAgente calleAgente = new CalleAgente();
            calleAgente.setImplementacion(calleImpl);

            return calleAgente;
        } else if (entidad.equals("Caso")) {
            CasoImplementacion casoImpl = new CasoImplementacion();
            CasoAgente casoAgente = new CasoAgente();
            casoAgente.setImplementacion(casoImpl);

            return casoAgente;
        } else if (entidad.equals("CronogramaDeMantenimiento")) {
            CronogramaDeMantenimientoImplementacion cronogramaDeMantenimientoImpl = new CronogramaDeMantenimientoImplementacion();
            CronogramaDeMantenimientoAgente cronogramaDeMantenAgente = new CronogramaDeMantenimientoAgente();
            cronogramaDeMantenAgente.setImplementacion(cronogramaDeMantenimientoImpl);

            return cronogramaDeMantenAgente;
        } else if (entidad.equals("Denuncia")) {
            DenunciaImplementacion denunciaImpl = new DenunciaImplementacion();
            DenunciaAgente denunciaAgente = new DenunciaAgente();
            denunciaAgente.setImplementacion(denunciaImpl);
            denunciaAgente.setIsNuevo(true);

            return denunciaAgente;
        } else if (entidad.equals("DenunciaEstado")) {
            DenunciaEstadoImplementacion denunciaEstadoImpl = new DenunciaEstadoImplementacion();
            DenunciaEstadoAgente denunciaEstadoAgente = new DenunciaEstadoAgente();
            denunciaEstadoAgente.setImplementacion(denunciaEstadoImpl);

            return denunciaEstadoAgente;
        } else if (entidad.equals("Denunciante")) {
            DenuncianteImplementacion denuncianteImpl = new DenuncianteImplementacion();
            DenuncianteAgente denuncianteAgente = new DenuncianteAgente();
            denuncianteAgente.setImplementacion(denuncianteImpl);

            return denuncianteAgente;
        } else if (entidad.equals("DetalleInformeMantenimiento")) {
            DetalleInformeMantenimientoImplementacion detalleInformeMantenimientoImpl = new DetalleInformeMantenimientoImplementacion();
            DetalleInformeMantenimientoAgente detalleInformeMantenAgente = new DetalleInformeMantenimientoAgente();
            detalleInformeMantenAgente.setImplementacion(detalleInformeMantenimientoImpl);

            return detalleInformeMantenAgente;
        } else if (entidad.equals("DetalleInformeReparacion")) {
            DetalleInformeReparacionImplementacion detalleInformeReparacionImpl = new DetalleInformeReparacionImplementacion();
            DetalleInformeReparacionAgente detalleInformeReparacionAgente = new DetalleInformeReparacionAgente();
            detalleInformeReparacionAgente.setImplementacion(detalleInformeReparacionImpl);

            return detalleInformeReparacionAgente;
        } else if (entidad.equals("ElementoTrabajo")) {
            ElementoTrabajoImplementacion elementoTrabajoImpl = new ElementoTrabajoImplementacion();
            ElementoTrabajoAgente elementoTrabajoAgente = new ElementoTrabajoAgente();
            elementoTrabajoAgente.setImplementacion(elementoTrabajoImpl);

            return elementoTrabajoAgente;
        } else if (entidad.equals("ElementoTrabajoMantenimiento")) {
            ElementoTrabajoMantenimientoImplementacion elementoTrabajoMantenImpl = new ElementoTrabajoMantenimientoImplementacion();
            ElementoTrabajoMantenimientoAgente elementoTrabajoMantenAgente = new ElementoTrabajoMantenimientoAgente();
            elementoTrabajoMantenAgente.setImplementacion(elementoTrabajoMantenImpl);

            return elementoTrabajoMantenAgente;
        } else if (entidad.equals("ElementoTrabajoReparacion")) {
            ElementoTrabajoReparacionImplementacion elementoTrabajoReparacionImpl = new ElementoTrabajoReparacionImplementacion();
            ElementoTrabajoReparacionAgente elementoTrabajoReparacionAgente = new ElementoTrabajoReparacionAgente();
            elementoTrabajoReparacionAgente.setImplementacion(elementoTrabajoReparacionImpl);

            return elementoTrabajoReparacionAgente;
        } else if (entidad.equals("Equipamiento")) {
            EquipamientoImplementacion equipamientoImpl = new EquipamientoImplementacion();
            EquipamientoAgente equipamientoAgente = new EquipamientoAgente();
            equipamientoAgente.setImplementacion(equipamientoImpl);

            return equipamientoAgente;
        } else if (entidad.equals("EquipoDeTrabajo")) {
            EquipoDeTrabajoImplementacion equipoDeTrabajoImpl = new EquipoDeTrabajoImplementacion();
            EquipoDeTrabajoAgente equipoDeTrabajoAgente = new EquipoDeTrabajoAgente();
            equipoDeTrabajoAgente.setImplementacion(equipoDeTrabajoImpl);

            return equipoDeTrabajoAgente;
        } else if (entidad.equals("Esquina")) {
            EsquinaImplementacion esquinaImpl = new EsquinaImplementacion();
            EsquinaAgente esquinaAgente = new EsquinaAgente();
            esquinaAgente.setImplementacion(esquinaImpl);

            return esquinaAgente;
        } else if (entidad.equals("EstadoDenuncia")) {
            EstadoDenunciaImplementacion estadoDenunciaImpl = new EstadoDenunciaImplementacion();
            EstadoDenunciaAgente estadoDenunciaAgente = new EstadoDenunciaAgente();
            estadoDenunciaAgente.setImplementacion(estadoDenunciaImpl);

            return estadoDenunciaAgente;
        } else if (entidad.equals("EstadoElementoTrabajo")) {
            EstadoElementoTrabajoImplementacion estadoElementoTrabajoImpl = new EstadoElementoTrabajoImplementacion();
            EstadoElementoTrabajoAgente estadoElementoTrabajoAgente = new EstadoElementoTrabajoAgente();
            estadoElementoTrabajoAgente.setImplementacion(estadoElementoTrabajoImpl);

            return estadoElementoTrabajoAgente;
        } else if (entidad.equals("EstadoFallaTecnica")) {
            EstadoFallaTecnicaImplementacion estadoFallaTecnicaImpl = new EstadoFallaTecnicaImplementacion();
            EstadoFallaTecnicaAgente estadoFallaTecnicaAgente = new EstadoFallaTecnicaAgente();
            estadoFallaTecnicaAgente.setImplementacion(estadoFallaTecnicaImpl);

            return estadoFallaTecnicaAgente;
        } else if (entidad.equals("EstadoOrdenTrabajo")) {
            EstadoOrdenTrabajoImplementacion estadoOrdenTrabajoImpl = new EstadoOrdenTrabajoImplementacion();
            EstadoOrdenTrabajoAgente estadoOrdenTrabajoAgente = new EstadoOrdenTrabajoAgente();
            estadoOrdenTrabajoAgente.setImplementacion(estadoOrdenTrabajoImpl);

            return estadoOrdenTrabajoAgente;
        } else if (entidad.equals("EstadoPersonaPadron")) {
            EstadoPersonaPadronImplementacion estadoPersonaPadronImpl = new EstadoPersonaPadronImplementacion();
            EstadoPersonaPadronAgente estadoPersonaPadronAgente = new EstadoPersonaPadronAgente();
            estadoPersonaPadronAgente.setImplementacion(estadoPersonaPadronImpl);

            return estadoPersonaPadronAgente;
        } else if (entidad.equals("FallaTecnica")) {
            FallaTecnicaImplementacion fallaTecnicaImpl = new FallaTecnicaImplementacion();
            FallaTecnicaAgente fallaTecnicaAgente = new FallaTecnicaAgente();
            fallaTecnicaAgente.setImplementacion(fallaTecnicaImpl);

            return fallaTecnicaAgente;
        } else if (entidad.equals("FichaMantenimiento")) {
            FichaMantenimientoImplementacion fichaMantenimientoImpl = new FichaMantenimientoImplementacion();
            FichaMantenimientoAgente fichaMantenimientoAgente = new FichaMantenimientoAgente();
            fichaMantenimientoAgente.setImplementacion(fichaMantenimientoImpl);

            return fichaMantenimientoAgente;
        } else if (entidad.equals("InformeMantenimiento")) {
            InformeMantenimientoImplementacion informeMantenimientoImpl = new InformeMantenimientoImplementacion();
            InformeMantenimientoAgente informeMantenimientoAgente = new InformeMantenimientoAgente();
            informeMantenimientoAgente.setImplementacion(informeMantenimientoImpl);

            return informeMantenimientoAgente;
        } else if (entidad.equals("InformeReparacion")) {
            InformeReparacionImplementacion informeReparacionImpl = new InformeReparacionImplementacion();
            InformeReparacionAgente informeReparacionAgente = new InformeReparacionAgente();
            informeReparacionAgente.setImplementacion(informeReparacionImpl);

            return informeReparacionAgente;
        } else if (entidad.equals("Interseccion")) {
            InterseccionImplementacion interseccionImpl = new InterseccionImplementacion();
            InterseccionAgente interseccionAgente = new InterseccionAgente();
            interseccionAgente.setImplementacion(interseccionImpl);

            return interseccionAgente;
        } else if (entidad.equals("Marca")) {
            MarcaImplementacion marcaImpl = new MarcaImplementacion();
            MarcaAgente marcaAgente = new MarcaAgente();
            marcaAgente.setImplementacion(marcaImpl);

            return marcaAgente;
        } else if (entidad.equals("Modelo")) {
            ModeloImplementacion modeloImpl = new ModeloImplementacion();
            ModeloAgente modeloAgente = new ModeloAgente();
            modeloAgente.setImplementacion(modeloImpl);

            return modeloAgente;
        } else if (entidad.equals("Numerador")) {
            NumeradorImplementacion numeradorImpl = new NumeradorImplementacion();
            NumeradorAgente numeradorAgente = new NumeradorAgente();
            numeradorAgente.setImplementacion(numeradorImpl);

            return numeradorAgente;
        } else if (entidad.equals("Operador")) {
            OperadorImplementacion operadorImpl = new OperadorImplementacion();
            OperadorAgente operadorAgente = new OperadorAgente();
            operadorAgente.setImplementacion(operadorImpl);

            return operadorAgente;
        } else if (entidad.equals("OrdenDeMantenimiento")) {
            OrdenDeMantenimientoImplementacion ordenDeMantenimientoImpl = new OrdenDeMantenimientoImplementacion();
            OrdenDeMantenimientoAgente ordenDeMantenimientoAgente = new OrdenDeMantenimientoAgente();
            ordenDeMantenimientoAgente.setImplementacion(ordenDeMantenimientoImpl);

            return ordenDeMantenimientoAgente;
        } else if (entidad.equals("OrdenDeReparacion")) {
            OrdenDeReparacionImplementacion ordenDeReparacionImpl = new OrdenDeReparacionImplementacion();
            OrdenDeReparacionAgente ordenDeReparacionAgente = new OrdenDeReparacionAgente();
            ordenDeReparacionAgente.setImplementacion(ordenDeReparacionImpl);

            return ordenDeReparacionAgente;
        } else if (entidad.equals("OrdenTrabajo")) {
            OrdenTrabajoImplementacion ordenTrabajoImpl = new OrdenTrabajoImplementacion();
            OrdenTrabajoAgente ordenTrabajoAgente = new OrdenTrabajoAgente();
            ordenTrabajoAgente.setImplementacion(ordenTrabajoImpl);

            return ordenTrabajoAgente;
        } else if (entidad.equals("OrdenTrabajoEstado")) {
            OrdenTrabajoEstadoImplementacion ordenTrabajoEstadoImpl = new OrdenTrabajoEstadoImplementacion();
            OrdenTrabajoEstadoAgente ordenTrabajoEstadoAgente = new OrdenTrabajoEstadoAgente();
            ordenTrabajoEstadoAgente.setImplementacion(ordenTrabajoEstadoImpl);
            ordenTrabajoEstadoAgente.setIsNuevo(true);

            return ordenTrabajoEstadoAgente;
        } else if (entidad.equals("OrdenTrabajoRepuestoNecesario")) {
            OrdenTrabajoRepuestoNecesarioImplementacion ordenTrabajoRepuestoNecesarioImpl = new OrdenTrabajoRepuestoNecesarioImplementacion();
            OrdenTrabajoRepuestoNecesarioAgente ordenTrabajoRepuestoNecesarioAgente = new OrdenTrabajoRepuestoNecesarioAgente();
            ordenTrabajoRepuestoNecesarioAgente.setImplementacion(ordenTrabajoRepuestoNecesarioImpl);

            return ordenTrabajoRepuestoNecesarioAgente;
        } else if (entidad.equals("Orientacion")) {
            OrientacionImplementacion orientacionImpl = new OrientacionImplementacion();
            OrientacionAgente orientacionAgente = new OrientacionAgente();
            orientacionAgente.setImplementacion(orientacionImpl);

            return orientacionAgente;
        } else if (entidad.equals("Periodicidad")) {
            PeriodicidadImplementacion periodicidadImpl = new PeriodicidadImplementacion();
            PeriodicidadAgente periodicidadAgente = new PeriodicidadAgente();
            periodicidadAgente.setImplementacion(periodicidadImpl);

            return periodicidadAgente;
        } else if (entidad.equals("PersonaPadron")) {
            PersonaPadronImplementacion personaPadronImpl = new PersonaPadronImplementacion();
            PersonaPadronAgente personaPadronAgente = new PersonaPadronAgente();
            personaPadronAgente.setImplementacion(personaPadronImpl);

            return personaPadronAgente;
        } else if (entidad.equals("PersonaPadronEstado")) {
            PersonaPadronEstadoImplementacion personaPadronEstadoImpl = new PersonaPadronEstadoImplementacion();
            PersonaPadronEstadoAgente personaPadronEstadoAgente = new PersonaPadronEstadoAgente();
            personaPadronEstadoAgente.setImplementacion(personaPadronEstadoImpl);

            return personaPadronEstadoAgente;
        } else if (entidad.equals("PesoDeReclamo")) {
            PesoDeReclamoImplementacion pesoDeReclamoImpl = new PesoDeReclamoImplementacion();
            PesoDeReclamoAgente pesoDeReclamoAgente = new PesoDeReclamoAgente();
            pesoDeReclamoAgente.setImplementacion(pesoDeReclamoImpl);

            return pesoDeReclamoAgente;
        } else if (entidad.equals("Problema")) {
            ProblemaImplementacion problemaImpl = new ProblemaImplementacion();
            ProblemaAgente problemaAgente = new ProblemaAgente();
            problemaAgente.setImplementacion(problemaImpl);

            return problemaAgente;
        } else if (entidad.equals("RangoAnios")) {
            RangoAniosImplementacion rangoAniosImpl = new RangoAniosImplementacion();
            RangoAniosAgente rangoAniosAgente = new RangoAniosAgente();
            rangoAniosAgente.setImplementacion(rangoAniosImpl);

            return rangoAniosAgente;
        } else if (entidad.equals("Reclamo")) {
            ReclamoImplementacion reclamoImpl = new ReclamoImplementacion();
            ReclamoAgente reclamoAgente = new ReclamoAgente();
            reclamoAgente.setImplementacion(reclamoImpl);

            return reclamoAgente;
        } else if (entidad.equals("ReparacionTareaRealizada")) {
            ReparacionTareaRealizadaImplementacion reparacionTareaRealizadaImpl = new ReparacionTareaRealizadaImplementacion();
            ReparacionTareaRealizadaAgente reparacionTareaRealizadaAgente = new ReparacionTareaRealizadaAgente();
            reparacionTareaRealizadaAgente.setImplementacion(reparacionTareaRealizadaImpl);

            return reparacionTareaRealizadaAgente;
        } else if (entidad.equals("Repuesto")) {
            RepuestoImplementacion repuestoImpl = new RepuestoImplementacion();
            RepuestoAgente repuestoAgente = new RepuestoAgente();
            repuestoAgente.setImplementacion(repuestoImpl);

            return repuestoAgente;
        } else if (entidad.equals("Reserva")) {
            ReservaImplementacion reservaImpl = new ReservaImplementacion();
            ReservaAgente reservaAgente = new ReservaAgente();
            reservaAgente.setImplementacion(reservaImpl);

            return reservaAgente;
        } else if (entidad.equals("ReservaElementoTrabajo")) {
            ReservaElementoTrabajoImplementacion reservaElementoTrabajoImpl = new ReservaElementoTrabajoImplementacion();
            ReservaElementoTrabajoAgente reservaElementoTrabajoAgente = new ReservaElementoTrabajoAgente();
            reservaElementoTrabajoAgente.setImplementacion(reservaElementoTrabajoImpl);

            return reservaElementoTrabajoAgente;
        } else if (entidad.equals("Rol")) {
            RolImplementacion rolImpl = new RolImplementacion();
            RolAgente rolAgente = new RolAgente();
            rolAgente.setImplementacion(rolImpl);

            return rolAgente;
        } else if (entidad.equals("Semaforo")) {
            SemaforoImplementacion semaforoImpl = new SemaforoImplementacion();
            SemaforoAgente semaforoAgente = new SemaforoAgente();
            semaforoAgente.setImplementacion(semaforoImpl);

            return semaforoAgente;
        } else if (entidad.equals("Tarea")) {
            TareaImplementacion tareaImpl = new TareaImplementacion();
            TareaAgente tareaAgente = new TareaAgente();
            tareaAgente.setImplementacion(tareaImpl);

            return tareaAgente;
        } else if (entidad.equals("TipoSemaforo")) {
            TipoSemaforoImplementacion tipoSemaforoImpl = new TipoSemaforoImplementacion();
            TipoSemaforoAgente tipoSemaforoAgente = new TipoSemaforoAgente();
            tipoSemaforoAgente.setImplementacion(tipoSemaforoImpl);

            return tipoSemaforoAgente;
        } else if (entidad.equals("Trabajador")) {
            TrabajadorImplementacion trabajadorImpl = new TrabajadorImplementacion();
            TrabajadorAgente trabajadorAgente = new TrabajadorAgente();
            trabajadorAgente.setImplementacion(trabajadorImpl);

            return trabajadorAgente;
        } else if (entidad.equals("TrabajadorRol")) {
            TrabajadorRolImplementacion trabajadorRolImpl = new TrabajadorRolImplementacion();
            TrabajadorRolAgente trabajadorRolAgente = new TrabajadorRolAgente();
            trabajadorRolAgente.setImplementacion(trabajadorRolImpl);

            return trabajadorRolAgente;
        } else if (entidad.equals("Trabajo")) {
            TrabajoImplementacion trabajoImpl = new TrabajoImplementacion();
            TrabajoAgente trabajoAgente = new TrabajoAgente();
            trabajoAgente.setImplementacion(trabajoImpl);

            return trabajoAgente;
        } else if (entidad.equals("TrabajoElementoNecesario")) {
            TrabajoElementoNecesarioImplementacion trabajoElementoNecesarioImpl = new TrabajoElementoNecesarioImplementacion();
            TrabajoElementoNecesarioAgente trabajoElementoNecesarioAgente = new TrabajoElementoNecesarioAgente();
            trabajoElementoNecesarioAgente.setImplementacion(trabajoElementoNecesarioImpl);

            return trabajoElementoNecesarioAgente;
        } else if (entidad.equals("Ubicacion")) {
            UbicacionImplementacion ubicacionImpl = new UbicacionImplementacion();
            UbicacionAgente ubicacionAgente = new UbicacionAgente();
            ubicacionAgente.setImplementacion(ubicacionImpl);

            return ubicacionAgente;
        } else if (entidad.equals("UbicacionSimple")) {
            UbicacionSimpleImplementacion ubicacionSimpleImpl = new UbicacionSimpleImplementacion();
            UbicacionSimpleAgente ubicacionSimpleAgente = new UbicacionSimpleAgente();
            ubicacionSimpleAgente.setImplementacion(ubicacionSimpleImpl);

            return ubicacionSimpleAgente;
        }

        return null;
    }
}
