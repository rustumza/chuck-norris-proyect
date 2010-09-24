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
public class DetalleInformeReparacionAgente implements DetalleInformeReparacion {

    private DetalleInformeReparacionImplementacion implementacion;
    public String oidReparacionTareaRealizada;
    private String oidFallaTecnica;
    private String oidEstadoFallaTecnica;


    private boolean reparacionTareaRealizadaBuscado;
    private boolean fallaTecnicaBuscado;
    private boolean estadoFallaTecnicaBuscado;

    public String getcomentario() {
        return implementacion.getcomentario();
    }

    public void setcomentario(String newVal) {
        implementacion.setcomentario(newVal);
    }

    public ReparacionTareaRealizada getReparacionTareaRealizada() {
        if (isReparacionTareaRealizadaBuscado() == false) {
            implementacion.setReparacionTareaRealizada((ReparacionTareaRealizada) FachadaInterna.getInstancia().buscar("ReparacionTareaRealizada", oidReparacionTareaRealizada));
        }
        return implementacion.getReparacionTareaRealizada();
    }

    public void setReparacionTareaRealizada(ReparacionTareaRealizada reparacionTareaRealizada) {
        implementacion.setReparacionTareaRealizada(reparacionTareaRealizada);
    }

    public FallaTecnica getFallaTecnica() {
        if (isFallaTecnicaBuscado() == false) {
            implementacion.setFallaTecnica((FallaTecnica) FachadaInterna.getInstancia().buscar("FallaTecnica", oidFallaTecnica));
        }
        return implementacion.getFallaTecnica();
    }

    public void setFallaTecnica(FallaTecnica fallaTecnica) {
        implementacion.setFallaTecnica(fallaTecnica);
    }

    public EstadoFallaTecnica getEstadoFallaTecnica() {
        if (isEstadoFallaTecnicaBuscado() == false) {
            implementacion.setEstadoFallaTecnica((EstadoFallaTecnica) FachadaInterna.getInstancia().buscar("EstadoFallaTecnica", oidEstadoFallaTecnica));
        }
        return implementacion.getEstadoFallaTecnica();
    }

    public void setEstadoFallaTecnica(EstadoFallaTecnica estadoFallaTecnica) {
        implementacion.setEstadoFallaTecnica(estadoFallaTecnica);
    }

    /**
     * @return the implementacion
     */
    public DetalleInformeReparacionImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(DetalleInformeReparacionImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidFallaTecnica
     */
    public String getOidFallaTecnica() {
        return oidFallaTecnica;
    }

    /**
     * @param oidFallaTecnica the oidFallaTecnica to set
     */
    public void setOidFallaTecnica(String oidFallaTecnica) {
        this.oidFallaTecnica = oidFallaTecnica;
    }

    /**
     * @return the oidEstadoFallaTecnica
     */
    public String getOidEstadoFallaTecnica() {
        return oidEstadoFallaTecnica;
    }

    /**
     * @param oidEstadoFallaTecnica the oidEstadoFallaTecnica to set
     */
    public void setOidEstadoFallaTecnica(String oidEstadoFallaTecnica) {
        this.oidEstadoFallaTecnica = oidEstadoFallaTecnica;
    }

    /**
     * @return the reparacionTareaRealizadaBuscado
     */
    public boolean isReparacionTareaRealizadaBuscado() {
        return reparacionTareaRealizadaBuscado;
    }

    /**
     * @param reparacionTareaRealizadaBuscado the reparacionTareaRealizadaBuscado to set
     */
    public void setReparacionTareaRealizadaBuscado(boolean reparacionTareaRealizadaBuscado) {
        this.reparacionTareaRealizadaBuscado = reparacionTareaRealizadaBuscado;
    }

    /**
     * @return the fallaTecnicaBuscado
     */
    public boolean isFallaTecnicaBuscado() {
        return fallaTecnicaBuscado;
    }

    /**
     * @param fallaTecnicaBuscado the fallaTecnicaBuscado to set
     */
    public void setFallaTecnicaBuscado(boolean fallaTecnicaBuscado) {
        this.fallaTecnicaBuscado = fallaTecnicaBuscado;
    }

    /**
     * @return the estadoFallaTecnicaBuscado
     */
    public boolean isEstadoFallaTecnicaBuscado() {
        return estadoFallaTecnicaBuscado;
    }

    /**
     * @param estadoFallaTecnicaBuscado the estadoFallaTecnicaBuscado to set
     */
    public void setEstadoFallaTecnicaBuscado(boolean estadoFallaTecnicaBuscado) {
        this.estadoFallaTecnicaBuscado = estadoFallaTecnicaBuscado;
    }
}
