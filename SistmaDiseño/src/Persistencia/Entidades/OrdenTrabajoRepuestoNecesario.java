/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface OrdenTrabajoRepuestoNecesario extends SuperDruperInterfaz {

    public int getcantidadNecesaria();

    public void setcantidadNecesaria(int newVal);

    public Repuesto getRepuesto();

    public void setRepuesto(Repuesto repuesto);
}
