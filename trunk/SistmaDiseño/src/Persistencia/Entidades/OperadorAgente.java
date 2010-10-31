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
public class OperadorAgente extends ObjetoPersistente implements Operador{

    private OperadorImplementacion implementacion;
    private boolean tipoOperadorBuscado;


    public String getlegajo() {
        return implementacion.getlegajo();
    }

    public String getnombreOperador() {
        return implementacion.getnombreOperador();
    }

    public void setlegajo(String newVal) {
        implementacion.setlegajo(newVal);
    }

    public void setnombreOperador(String newVal) {
        implementacion.setnombreOperador(newVal);
    }

    /**
     * @return the implementacion
     */
    public OperadorImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(OperadorImplementacion implementacion) {
        this.implementacion = implementacion;
    }

     /**
     * @return the tipoOperador
     */
    public TipoOperador getTipoOperador() {
        if(!isTipoOperadorBuscado()){
            implementacion.setTipoOperador((TipoOperador)(FachadaInterna.getInstancia().buscar("TipoOperador", super.getOid())));
            setTipoOperadorBuscado(true);
        }
        return implementacion.getTipoOperador();
    }

    /**
     * @param tipoOperador the tipoOperador to set
     */
    public void setTipoOperador(TipoOperador tipoOperador) {
        implementacion.setTipoOperador(tipoOperador);
    }

    /**
     * @return the tipoOperadorBuscado
     */
    public boolean isTipoOperadorBuscado() {
        return tipoOperadorBuscado;
    }

    /**
     * @param tipoOperadorBuscado the tipoOperadorBuscado to set
     */
    public void setTipoOperadorBuscado(boolean tipoOperadorBuscado) {
        this.tipoOperadorBuscado = tipoOperadorBuscado;
    }


    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return implementacion.getUsuario();
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        implementacion.setUsuario(usuario);
    }




}
