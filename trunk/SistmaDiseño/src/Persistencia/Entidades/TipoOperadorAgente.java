/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author rustu
 */
public class TipoOperadorAgente extends ObjetoPersistente implements TipoOperador{

    private TipoOperadorImplementacion implementacion;


    /**
     * @return the implementacio
     */
    public TipoOperadorImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacio the implementacio to set
     */
    public void setImplementacion(TipoOperadorImplementacion implementacio) {
        this.implementacion = implementacio;
    }


    public String getNombre() {
        return implementacion.getNombre();
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        implementacion.setNombre(nombre);
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return implementacion.getNombre();
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        implementacion.setCodigo(codigo);
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return implementacion.getDescripcion();
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        implementacion.setDescripcion(descripcion);
    }





}
