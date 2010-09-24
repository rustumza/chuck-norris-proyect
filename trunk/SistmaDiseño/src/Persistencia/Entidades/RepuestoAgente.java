/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class RepuestoAgente extends ElementoTrabajoAgente implements Repuesto{

    public int getcodigoRepuesto() {
        return ((RepuestoImplementacion)super.getImplementacion()).getcodigoRepuesto();
    }

    public String getnombreRepuesto() {
        return ((RepuestoImplementacion)super.getImplementacion()).getnombreRepuesto();
    }

    public void setcodigoRepuesto(int newVal) {
        ((RepuestoImplementacion)super.getImplementacion()).setcodigoRepuesto(newVal);
    }

    public void setnombreRepuesto(String newVal) {
        ((RepuestoImplementacion)super.getImplementacion()).setnombreRepuesto(newVal);
    }

}
