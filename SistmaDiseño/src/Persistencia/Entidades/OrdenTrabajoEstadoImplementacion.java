package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:16 p.m.
 */
public class OrdenTrabajoEstadoImplementacion implements OrdenTrabajoEstado{

	private Date fechacambioestado;
	private boolean indicadorestadoactual;
	private EstadoOrdenTrabajo estadoOrdenTrabajo;

	public OrdenTrabajoEstadoImplementacion(){

	}

	
	   public Date getfechacambioestado() {
        return fechacambioestado;
    }

    public boolean isindicadorestadoactual() {
        return indicadorestadoactual;
    }

    /**
     *
     * @param newVal
     */
    public void setfechacambioestado(Date newVal) {
        fechacambioestado = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setindicadorestadoactual(boolean newVal) {
        indicadorestadoactual = newVal;
    }

    /**
     * @return the estadoOrdenTrabajo
     */
    public EstadoOrdenTrabajo getEstadoOrdenTrabajo() {
        return estadoOrdenTrabajo;
    }

    /**
     * @param estadoOrdenTrabajo the estadoOrdenTrabajo to set
     */
    public void setEstadoOrdenTrabajo(EstadoOrdenTrabajo estadoOrdenTrabajo) {
        this.estadoOrdenTrabajo = estadoOrdenTrabajo;
    }

}
