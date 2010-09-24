/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Equipamiento extends ElementoTrabajo {

    public int getcodigoEquipamiento();

    public String getnombreEquipamiento();

    public void setcodigoEquipamiento(int newVal);

    public void setnombreEquipamiento(String newVal);
}
