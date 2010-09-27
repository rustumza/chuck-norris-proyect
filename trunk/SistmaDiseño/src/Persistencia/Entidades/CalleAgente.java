/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author Bicentenario
 */
public class CalleAgente extends ObjetoPersistente implements Calle {

    private CalleImplementacion implementacion;

    public String toString(){

        return getnombrecalle();
    }

    public int getcodigoCalle() {
        return getImplementacion().getcodigoCalle();
    }

    public String getnombrecalle() {
        return getImplementacion().getnombrecalle();
    }

    public void setcodigoCalle(int newVal) {
        getImplementacion().setcodigoCalle(newVal);
    }

    public void setnombrecalle(String newVal) {
        getImplementacion().setnombrecalle(newVal);
    }

    /**
     * @return the implementacion
     */
    public CalleImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(CalleImplementacion implementacion) {
        this.implementacion = implementacion;
    }
}
