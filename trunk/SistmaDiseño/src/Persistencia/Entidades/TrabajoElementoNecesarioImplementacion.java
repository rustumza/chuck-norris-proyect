package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:18 p.m.
 */
public class TrabajoElementoNecesarioImplementacion implements TrabajoElementoNecesario {

    private int cantidadNecesaria;
    private ElementoTrabajo elementoTrabajo;

    public TrabajoElementoNecesarioImplementacion() {
    }

    public int getcantidadNecesaria() {
        return cantidadNecesaria;
    }

    /**
     *
     * @param newVal
     */
    public void setcantidadNecesaria(int newVal) {
        cantidadNecesaria = newVal;
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
