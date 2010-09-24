/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface ReservaElementoTrabajo extends SuperDruperInterfaz {

    public int getcantidadreservada();

    public void setcantidadreservada(int newVal);

    public ElementoTrabajo getElementoTrabajo();

    public void setElementoTrabajo(ElementoTrabajo elementoTrabajo);
}
