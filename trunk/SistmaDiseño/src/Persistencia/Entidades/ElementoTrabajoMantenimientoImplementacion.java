package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class ElementoTrabajoMantenimientoImplementacion implements ElementoTrabajoMantenimiento{

    private int cantidad;
    private ElementoTrabajo elementoTrabajo;
    private EstadoElementoTrabajo estadoElementoTrabajo;

    

    public ElementoTrabajoMantenimientoImplementacion() {
    }

    public int getcantidad() {
        return cantidad;
    }

    /**
     *
     * @param newVal
     */
    public void setcantidad(int newVal) {
        cantidad = newVal;
    }

    /**
     * @return the elementoTrabajo
     */
    public ElementoTrabajo getElementoTrabajo() {
        return elementoTrabajo;
    }

    /**
     * @param elementoTrabajo the elementoTrabajo to set
     */
    public void setElementoTrabajo(ElementoTrabajo elementoTrabajo) {
        this.elementoTrabajo = elementoTrabajo;
    }

    /**
     * @return the estadoElementoTrabajo
     */
    public EstadoElementoTrabajo getEstadoElementoTrabajo() {
        return estadoElementoTrabajo;
    }

    /**
     * @param estadoElementoTrabajo the estadoElementoTrabajo to set
     */
    public void setEstadoElementoTrabajo(EstadoElementoTrabajo estadoElementoTrabajo) {
        this.estadoElementoTrabajo = estadoElementoTrabajo;
    }
}
