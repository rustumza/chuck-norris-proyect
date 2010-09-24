package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:16 p.m.
 */
public class OrdenTrabajoRepuestoNecesarioImplementacion implements OrdenTrabajoRepuestoNecesario {

    private int cantidadNecesaria;
    private Repuesto repuesto;

    public OrdenTrabajoRepuestoNecesarioImplementacion() {
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
     * @return the repuesto
     */
    public Repuesto getRepuesto() {
        return repuesto;
    }

    /**
     * @param repuesto the repuesto to set
     */
    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }
}
