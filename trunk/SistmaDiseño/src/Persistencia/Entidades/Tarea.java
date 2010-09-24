/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Tarea extends Trabajo {

    public int getcodigoTarea();

    public String getdescripciontarea();

    public void setcodigoTarea(int newVal);

    public void setdescripciontarea(String newVal);
}
