package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:14 p.m.
 */
public class EstadoOrdenTrabajoImplementacion implements EstadoOrdenTrabajo {

    private int codigoestadoordentrabajo;
    private String nombreestado;
    private OrdenTrabajoEstado ordenTrabajoEstado;

    public EstadoOrdenTrabajoImplementacion() {
    }

    public int getcodigoestadoordentrabajo() {
        return codigoestadoordentrabajo;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoestadoordentrabajo(int newVal) {
        codigoestadoordentrabajo = newVal;
    }

    /**
     * @return the ordenTrabajoEstado
     */
    public OrdenTrabajoEstado getOrdenTrabajoEstado() {
        return ordenTrabajoEstado;
    }

    /**
     * @param ordenTrabajoEstado the ordenTrabajoEstado to set
     */
    public void setOrdenTrabajoEstado(OrdenTrabajoEstado ordenTrabajoEstado) {
        this.ordenTrabajoEstado = ordenTrabajoEstado;
    }

    /**
     * @return the nombreestado
     */
    public String getNombreestado() {
        return nombreestado;
    }

    /**
     * @param nombreestado the nombreestado to set
     */
    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }
}
