/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class TareaAgente extends TrabajoAgente implements Tarea{

    public int getcodigoTarea() {
        return ((TareaImplementacion)super.getImplementacion()).getcodigoTarea();
    }

    public String getdescripciontarea() {
        return ((TareaImplementacion)super.getImplementacion()).getdescripciontarea();
    }

    public void setcodigoTarea(int newVal) {
        ((TareaImplementacion)super.getImplementacion()).setcodigoTarea(newVal);
    }

    public void setdescripciontarea(String newVal) {
        ((TareaImplementacion)super.getImplementacion()).setdescripciontarea(newVal);
    }

}
