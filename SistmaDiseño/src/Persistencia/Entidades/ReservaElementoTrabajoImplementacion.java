package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class ReservaElementoTrabajoImplementacion implements ReservaElementoTrabajo {

    private int cantidadreservada;
    private ElementoTrabajo elementoTrabajo;

    public ReservaElementoTrabajoImplementacion() {
    }

    public int getcantidadreservada() {
        return cantidadreservada;
    }

    /**
     *
     * @param newVal
     */
    public void setcantidadreservada(int newVal) {
        cantidadreservada = newVal;
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
}
