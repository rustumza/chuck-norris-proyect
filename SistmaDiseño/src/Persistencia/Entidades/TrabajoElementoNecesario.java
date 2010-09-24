/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface TrabajoElementoNecesario extends SuperDruperInterfaz {

    public int getcantidadNecesaria();

    public void setcantidadNecesaria(int newVal);

    public ElementoTrabajo getElementoTrabajo();

    public void setElementoTrabajo(ElementoTrabajo elementoTrabajo);
}
