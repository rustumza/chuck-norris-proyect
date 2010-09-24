/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class RolAgente implements Rol{

    private RolImplementacion implementacion;

    public int getcodigoRol() {
        return implementacion.getcodigoRol();
    }

    public String getnombreRol() {
        return implementacion.getnombreRol();
    }

    public void setcodigoRol(int newVal) {
        implementacion.setcodigoRol(newVal);
    }

    public void setnombreRol(String newVal) {
        implementacion.setnombreRol(newVal);
    }

    /**
     * @return the implementacion
     */
    public RolImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(RolImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
