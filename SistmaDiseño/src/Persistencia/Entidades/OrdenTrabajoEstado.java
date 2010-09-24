/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;

/**
 *
 * @author diego
 */
public interface OrdenTrabajoEstado extends SuperDruperInterfaz {

    public Date getfechacambioestado();

    public boolean isindicadorestadoactual();

    public void setfechacambioestado(Date newVal);

    public void setindicadorestadoactual(boolean newVal);

    public EstadoOrdenTrabajo getEstadoOrdenTrabajo();

    public void setEstadoOrdenTrabajo(EstadoOrdenTrabajo estadoOrdenTrabajo);
}
