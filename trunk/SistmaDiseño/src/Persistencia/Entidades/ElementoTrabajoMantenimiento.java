/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface ElementoTrabajoMantenimiento extends SuperDruperInterfaz {

    public int getcantidad();

    public void setcantidad(int newVal);

    public ElementoTrabajo getElementoTrabajo();

    public void setElementoTrabajo(ElementoTrabajo elementoTrabajo);

    public EstadoElementoTrabajo getEstadoElementoTrabajo();

    public void setEstadoElementoTrabajo(EstadoElementoTrabajo estadoElementoTrabajo);
}
