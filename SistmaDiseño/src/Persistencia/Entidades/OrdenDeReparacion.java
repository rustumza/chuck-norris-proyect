/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface OrdenDeReparacion extends OrdenTrabajo {

    public int getcodigoordenreparacion();

    public void setcodigoordenreparacion(int newVal);

    public Denuncia getDenuncia();

    public void setDenuncia(Denuncia denuncia);

    public InformeReparacion getInformeReparacion();

    public void setInformeReparacion(InformeReparacion informeReparacion);
}
