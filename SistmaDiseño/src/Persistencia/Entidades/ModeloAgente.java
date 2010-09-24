/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author diego
 */
public class ModeloAgente extends ObjetoPersistente implements Modelo{

    private ModeloImplementacion implementacion;
    private String oidMarca;
    //variable para saber si el objeto relacionado ya ha sido buscado en la BD
    private boolean marcaBuscado;

    public int getcodigomodelo() {
        return getImplementacion().getcodigomodelo();
    }

    public String getnombremodelo() {
        return getImplementacion().getnombremodelo();
    }

    public void setcodigomodelo(int newVal) {
        getImplementacion().setcodigomodelo(newVal);
    }

    public void setnombremodelo(String newVal) {
        getImplementacion().setnombremodelo(newVal);
    }

    public Marca getMarca() {
        if(isMarcaBuscado()==false)
            implementacion.setMarca((Marca)FachadaInterna.getInstancia().buscar("Marca", oidMarca));
        return implementacion.getMarca();
    }

    public void setMarca(Marca marca) {
        implementacion.setMarca(marca);
    }

    /**
     * @return the implementacion
     */
    public ModeloImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(ModeloImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidMarca
     */
    public String getOidMarca() {
        return oidMarca;
    }

    /**
     * @param oidMarca the oidMarca to set
     */
    public void setOidMarca(String oidMarca) {
        this.oidMarca = oidMarca;
    }

    /**
     * @return the marcaBuscado
     */
    public boolean isMarcaBuscado() {
        return marcaBuscado;
    }

    /**
     * @param marcaBuscado the marcaBuscado to set
     */
    public void setMarcaBuscado(boolean marcaBuscado) {
        this.marcaBuscado = marcaBuscado;
    }

}
