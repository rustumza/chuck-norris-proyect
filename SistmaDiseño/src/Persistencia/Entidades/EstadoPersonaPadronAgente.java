/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class EstadoPersonaPadronAgente implements EstadoPersonaPadron{

    private EstadoPersonaPadronImplementacion implementacion;

    public int getcodigoestadopersonapadron() {
        return implementacion.getcodigoestadopersonapadron();
    }

    public String getnombreestado() {
        return implementacion.getnombreestado();
    }

    public void setcodigoestadopersonapadron(int newVal) {
        implementacion.setcodigoestadopersonapadron(newVal);
    }

    public void setnombreestado(String newVal) {
        implementacion.setnombreestado(newVal);
    }

    /**
     * @return the implementacion
     */
    public EstadoPersonaPadronImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(EstadoPersonaPadronImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
