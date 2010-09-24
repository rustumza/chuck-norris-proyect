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
public class FichaMantenimientoAgente implements FichaMantenimiento {

    private FichaMantenimientoImplementacion implementacion;
    private String oidModelo;
    private String oidPeriodicidad;
    private String oidRangoAnios;
    private String oidTarea;
    //variables para saber si el atributo se busco en la BD
    private boolean modeloBuscado;
    private boolean periodicidadBuscado;
    private boolean rangoAniosBuscado;
    private boolean tareaBuscado;

    public int getcodigoFichaMantenimiento() {
        return implementacion.getcodigoFichaMantenimiento();
    }

    public void setcodigoFichaMantenimiento(int newVal) {
        implementacion.setcodigoFichaMantenimiento(newVal);
    }

    public Modelo getModelo() {
        if (isModeloBuscado() == false) {
            implementacion.setModelo((Modelo) FachadaInterna.getInstancia().buscar("Modelo", oidModelo));
        }
        return implementacion.getModelo();
    }

    public void setModelo(Modelo modelo) {
        implementacion.setModelo(modelo);
    }

    public Periodicidad getPeriodicidad() {
        if(isPeriodicidadBuscado()==false)
            implementacion.setPeriodicidad((Periodicidad)FachadaInterna.getInstancia().buscar("Periodicidad", oidPeriodicidad));
        return implementacion.getPeriodicidad();
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        implementacion.setPeriodicidad(periodicidad);
    }

    public RangoAnios getRangoAnios() {
        if(isRangoAniosBuscado()==false)
            implementacion.setRangoAnios((RangoAnios)FachadaInterna.getInstancia().buscar("RangoAnios", oidRangoAnios));
        return implementacion.getRangoAnios();
    }

    public void setRangoAnios(RangoAnios rangoAnios) {
        implementacion.setRangoAnios(rangoAnios);
    }

    public Tarea getTarea() {
        if(isTareaBuscado()==false)
            implementacion.setTarea((Tarea)FachadaInterna.getInstancia().buscar("Tarea", oidTarea));
        return implementacion.getTarea();
    }

    public void setTarea(Tarea tarea) {
        implementacion.setTarea(tarea);
    }

    /**
     * @return the implementacion
     */
    public FichaMantenimientoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(FichaMantenimientoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidModelo
     */
    public String getOidModelo() {
        return oidModelo;
    }

    /**
     * @param oidModelo the oidModelo to set
     */
    public void setOidModelo(String oidModelo) {
        this.oidModelo = oidModelo;
    }

    /**
     * @return the modeloBuscado
     */
    public boolean isModeloBuscado() {
        return modeloBuscado;
    }

    /**
     * @param modeloBuscado the modeloBuscado to set
     */
    public void setModeloBuscado(boolean modeloBuscado) {
        this.modeloBuscado = modeloBuscado;
    }

    /**
     * @return the oidPeriodicidad
     */
    public String getOidPeriodicidad() {
        return oidPeriodicidad;
    }

    /**
     * @param oidPeriodicidad the oidPeriodicidad to set
     */
    public void setOidPeriodicidad(String oidPeriodicidad) {
        this.oidPeriodicidad = oidPeriodicidad;
    }

    /**
     * @return the periodicidadBuscado
     */
    public boolean isPeriodicidadBuscado() {
        return periodicidadBuscado;
    }

    /**
     * @param periodicidadBuscado the periodicidadBuscado to set
     */
    public void setPeriodicidadBuscado(boolean periodicidadBuscado) {
        this.periodicidadBuscado = periodicidadBuscado;
    }

    /**
     * @return the oidRangoAnios
     */
    public String getOidRangoAnios() {
        return oidRangoAnios;
    }

    /**
     * @param oidRangoAnios the oidRangoAnios to set
     */
    public void setOidRangoAnios(String oidRangoAnios) {
        this.oidRangoAnios = oidRangoAnios;
    }

    /**
     * @return the rangoAniosBuscado
     */
    public boolean isRangoAniosBuscado() {
        return rangoAniosBuscado;
    }

    /**
     * @param rangoAniosBuscado the rangoAniosBuscado to set
     */
    public void setRangoAniosBuscado(boolean rangoAniosBuscado) {
        this.rangoAniosBuscado = rangoAniosBuscado;
    }

    /**
     * @return the oidTarea
     */
    public String getOidTarea() {
        return oidTarea;
    }

    /**
     * @param oidTarea the oidTarea to set
     */
    public void setOidTarea(String oidTarea) {
        this.oidTarea = oidTarea;
    }

    /**
     * @return the tareaBuscado
     */
    public boolean isTareaBuscado() {
        return tareaBuscado;
    }

    /**
     * @param tareaBuscado the tareaBuscado to set
     */
    public void setTareaBuscado(boolean tareaBuscado) {
        this.tareaBuscado = tareaBuscado;
    }
}
