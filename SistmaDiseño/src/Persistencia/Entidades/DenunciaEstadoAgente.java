/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.util.Date;

/**
 *
 * @author diego
 */
public class DenunciaEstadoAgente extends ObjetoPersistente implements DenunciaEstado {

    private DenunciaEstadoImplementacion implementacion;
    private String oidDenuncia;
    private String oidEstadoDenuncia;
    private boolean estadoDenunciaBuscadoscado;

    public Date getfechacambioestado() {
        return implementacion.getfechacambioestado();
    }



    public boolean isindicadorestadoactual() {
        return implementacion.isindicadorestadoactual();
    }

    public void setfechacambioestado(Date newVal) {
        implementacion.setfechacambioestado(newVal);
    }

    public void setindicadorestadoactual(boolean newVal) {
        implementacion.setindicadorestadoactual(newVal);
    }

    public EstadoDenuncia getEstadoDenuncia() {
        if (isEstadoDenunciaBuscadoscado() == false) {
            implementacion.setEstadoDenuncia((EstadoDenuncia) FachadaInterna.getInstancia().buscar("EstadoDenuncia", oidEstadoDenuncia));
        }
        return implementacion.getEstadoDenuncia();
    }

    public void setEstadoDenuncia(EstadoDenuncia estadoDenuncia) {
        implementacion.setEstadoDenuncia(estadoDenuncia);
    }

    /**
     * @return the implementacion
     */
    public DenunciaEstadoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(DenunciaEstadoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the estadoDenunciaBuscadoscado
     */
    public boolean isEstadoDenunciaBuscadoscado() {
        return estadoDenunciaBuscadoscado;
    }

    /**
     * @param estadoDenunciaBuscadoscado the estadoDenunciaBuscadoscado to set
     */
    public void setEstadoDenunciaBuscadoscado(boolean estadoDenunciaBuscadoscado) {
        this.estadoDenunciaBuscadoscado = estadoDenunciaBuscadoscado;
    }


    public String getOidEstadoDenuncia() {
        return oidEstadoDenuncia;
    }

    public Boolean getIndicadoresEstadoActual() {
        return implementacion.getIndicadoresEstadoActual();
    }

    public void setOidEstadoDenuncia(String nuevoOidEstadoDenuncia) {
        oidEstadoDenuncia = nuevoOidEstadoDenuncia;
    }

    /**
     * @return the oidDenuncia
     */
    public String getOidDenuncia() {
        return oidDenuncia;
    }

    /**
     * @param oidDenuncia the oidDenuncia to set
     */
    public void setOidDenuncia(String oidDenuncia) {
        this.oidDenuncia = oidDenuncia;
    }

    
}
