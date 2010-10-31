/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.intermediarios;

import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.ExpertosPersistencia.Criterio;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author diego
 */
public  class IntermediarioDTOOrdenReparacion extends IntermediarioRelacional{

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {

        String select = "SELECT ordensemaforo.OIDOrdenDeTrabajo, "
                + " ordensemaforo.FechaInicioTrabajo,ordensemaforo.FechaFinTrabajo, ordensemaforo.FechaInicioPlanificada, ordensemaforo.DuracionPrevistaTrabajo, ordensemaforo.Tipo, "
                + " ordenreparacion.CodigoOrdenReparacion, denuncia.CodigoDenuncia, caso.FechaCaso, caso.TipoCaso, "
                + " semaforo.NumeroSerie,semaforo.OIDSemaforo, "
                + " ubicacion.OIDUbicacion, ubicacion.CodigoUbicacion, ubicacion.Prioridad, ubicacion.TipoUbicacion, ubicacionsimple.Altura, "
                + " interseccion.OIDUbicacion, interseccioncalle.OIDCalle as intercalle, calle1.OIDCalle as oidcale,calle2.OIDCalle, calle1.CodigoCalle "
                + " from ordendetrabajo as ordensemaforo "
                + " join ordenreparacion "
                + " on ordensemaforo.OIDOrdenDeTrabajo = ordenreparacion.OIDOrdenDeTrabajo "
                + " join denuncia "
                + " on ordenreparacion.OIDDenuncia = denuncia.OIDCaso "
                + " join caso "
                + " on denuncia.OIDCaso = caso.OIDCaso "
                + " join casosemaforo "
                + " on caso.OIDCaso = casosemaforo.OIDCaso "
                + " join semaforo "
                + " on casosemaforo.OIDSemaforo = semaforo.OIDSemaforo "
                + " join ubicacion "
                + " on semaforo.OIDUbicacion = ubicacion.OIDUbicacion "
                + " left join ubicacionsimple "
                + " on ubicacion.OIDUbicacion = ubicacionsimple.OIDUbicacion "
                + " left join interseccion "
                + " on ubicacion.OIDUbicacion = interseccion.OIDUbicacion "
                + " left join calle as calle1 "
                + " on ubicacionsimple.OIDCalle = calle1.OIDCalle "
                + " LEFT JOIN interseccioncalle "
                + " on interseccion.OIDUbicacion = interseccioncalle.OIDInterseccion "
                + " left join calle as calle2 "
                + " on interseccioncalle.OIDCalle = calle2.OIDCalle "
                + " left join reserva "
                + " on ordensemaforo.OIDOrdenDeTrabajo  = reserva.OIDOrdenDeTrabajo "
                + " join reservaelementotrabajo "
                + " on reserva.OIDReserva = reservaelementotrabajo.OIDReserva"
                + " join elementotrabajo "
                + " on reservaelementotrabajo.OIDElementoTrabajo = elementotrabajo.OIDElementoTrabajo "
                + " left join repuesto "
                + " on elementotrabajo.OIDElementoTrabajo = repuesto.OIDElementoTrabajo "
                + " left join equipamiento "
                + " on elementotrabajo.OIDElementoTrabajo = equipamiento.OIDElementoTrabajo "
                + " join equipodetrabajo "
                + " on ordensemaforo.OIDEquipoDeTrabajo = equipodetrabajo.OIDEquipoDeTrabajo";

        return select;

        
    }

    @Override
    public String armarSelectOid(String oid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String armarUpdate(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void guardarObjetoCompuesto(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ObjetoPersistente> convertirRegistrosAObjetos(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void guardarObjetosRelacionados(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void buscarObjRelacionados(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setearDatosPadre(ObjetoPersistente objPer, List<Criterio> listacCriterios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void guardarDatosPadre(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }







}
