/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class EstadoDenunciaAgente implements EstadoDenuncia{

    private EstadoDenunciaImplementacion implementacion;

    public int getcodigoestadodenuncia() {
        return implementacion.getcodigoestadodenuncia();
    }

    public String getnombreestado() {
        return implementacion.getnombreestado();
    }

    public void setcodigoestadodenuncia(int newVal) {
        implementacion.setcodigoestadodenuncia(newVal);
    }

    public void setnombreestado(String newVal) {
        implementacion.setnombreestado(newVal);
    }

    /**
     * @return the implementacion
     */
    public EstadoDenunciaImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(EstadoDenunciaImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
