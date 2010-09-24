package Persistencia.Entidades;

import java.sql.Time;
import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class ReparacionTareaRealizadaImplementacion implements ReparacionTareaRealizada {

    private String comentario;
    private Date fechafinrealizaciontarea;
    private Date fechainiciorealizaciontarea;
    private Time horafintarea;
    private Time horainiciotarea;
    private ElementoTrabajoReparacion elementoTrabajoReparacion;
    private Tarea tarea;

    public ReparacionTareaRealizadaImplementacion() {
    }

    public String getcomentario() {
        return comentario;
    }

    public Date getfechafinrealizaciontarea() {
        return fechafinrealizaciontarea;
    }

    public Date getfechainiciorealizaciontarea() {
        return fechainiciorealizaciontarea;
    }

    public Time gethorafintarea() {
        return horafintarea;
    }

    public Time gethorainiciotarea() {
        return horainiciotarea;
    }

    /**
     *
     * @param newVal
     */
    public void setcomentario(String newVal) {
        comentario = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfechafinrealizaciontarea(Date newVal) {
        fechafinrealizaciontarea = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfechainiciorealizaciontarea(Date newVal) {
        fechainiciorealizaciontarea = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void sethorafintarea(Time newVal) {
        horafintarea = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void sethorainiciotarea(Time newVal) {
        horainiciotarea = newVal;
    }

    /**
     * @return the elementoTrabajoReparacion
     */
    public ElementoTrabajoReparacion getElementoTrabajoReparacion() {
        return elementoTrabajoReparacion;
    }

    /**
     * @param elementoTrabajoReparacion the elementoTrabajoReparacion to set
     */
    public void setElementoTrabajoReparacion(ElementoTrabajoReparacion elementoTrabajoReparacion) {
        this.elementoTrabajoReparacion = elementoTrabajoReparacion;
    }

    /**
     * @return the tarea
     */
    public Tarea getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}
