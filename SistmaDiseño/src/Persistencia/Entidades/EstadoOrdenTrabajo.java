/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface EstadoOrdenTrabajo extends SuperDruperInterfaz {

    public int getcodigoestadoordentrabajo();

    public void setcodigoestadoordentrabajo(int newVal);

    public OrdenTrabajoEstado getOrdenTrabajoEstado();

    public void setOrdenTrabajoEstado(OrdenTrabajoEstado ordenTrabajoEstado);

    public String getNombreestado();

    public void setNombreestado(String nombreestado);
}
