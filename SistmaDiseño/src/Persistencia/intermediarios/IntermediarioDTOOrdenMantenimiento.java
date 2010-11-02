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
 * @author LEIVA
 */
public class IntermediarioDTOOrdenMantenimiento extends IntermediarioRelacional{

    @Override
    public String armarInsert(ObjetoPersistente obj) {
        return null;
    }

    @Override
    public String armarSelect(List<Criterio> criterios) {
        String select = "Select * from ordendetrabajo "
                + "join ordentrabajoestado on ordendetrabajo.OIDOrdenDeTrabajo = ordentrabajoestado.OIDOrdenDeTrabajo "
                + "join estadoordentrabajo on ordentrabajoestado.OIDEstadoOrdenTrabajo = estadoordentrabajo.OIDEstadoOrdenTrabajo "
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
                + "left join calle as calle1 on ubicacionsimple.OIDCalle = calle1.OIDCalle "
                + "LEFT JOIN interseccioncalle on interseccion.OIDUbicacion = interseccioncalle.OIDInterseccion "
                + "left join calle as calle2 on interseccioncalle.OIDCalle = calle2.OIDCalle";

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
        return null;
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
