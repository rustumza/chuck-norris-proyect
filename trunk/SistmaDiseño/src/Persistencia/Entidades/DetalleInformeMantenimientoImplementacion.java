package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class DetalleInformeMantenimientoImplementacion implements DetalleInformeMantenimiento {

    private String comentario;
    private Date fechafinrealizaciontarea;
    private Date fechainiciorealizaciontarea;
    private Date horafintarea;
    private Date horainiciotarea;
    private Tarea tarea;
    private ElementoTrabajoMantenimiento elementoTrabajoMantenimiento;

    

    public DetalleInformeMantenimientoImplementacion() {
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

    public Date gethorafintarea() {
        return horafintarea;
    }

    public Date gethorainiciotarea() {
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
    public void sethorafintarea(Date newVal) {
        horafintarea = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void sethorainiciotarea(Date newVal) {
        horainiciotarea = newVal;
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

    /**
     * @return the elementoTrabajoMantenimiento
     */
    public ElementoTrabajoMantenimiento getElementoTrabajoMantenimiento() {
        return elementoTrabajoMantenimiento;
    }

    /**
     * @param elementoTrabajoMantenimiento the elementoTrabajoMantenimiento to set
     */
    public void setElementoTrabajoMantenimiento(ElementoTrabajoMantenimiento elementoTrabajoMantenimiento) {
        this.elementoTrabajoMantenimiento = elementoTrabajoMantenimiento;
    }
}
