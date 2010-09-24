/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class EquipamientoAgente extends ElementoTrabajoAgente implements Equipamiento{

    

    public int getcodigoEquipamiento() {
        return ((EquipamientoImplementacion)super.getImplementacion()).getcodigoEquipamiento();
    }

    public String getnombreEquipamiento() {
        return ((EquipamientoImplementacion)super.getImplementacion()).getnombreEquipamiento();
    }

    public void setcodigoEquipamiento(int newVal) {
        ((EquipamientoImplementacion)super.getImplementacion()).setcodigoEquipamiento(newVal);
    }

    public void setnombreEquipamiento(String newVal) {
        ((EquipamientoImplementacion)super.getImplementacion()).setnombreEquipamiento(newVal);
    }

   

}
