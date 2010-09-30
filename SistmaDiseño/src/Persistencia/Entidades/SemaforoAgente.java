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
public class SemaforoAgente extends ObjetoPersistente implements Semaforo {

    private SemaforoImplementacion implementacion;
    private String oidOrientacion;
    private String oidModelo;
    private String oidEsquina;
    private String oidTipoSemaforo;
    private String oidUbicacion;
    //variable para saber si el elemento relacionado ya ha sido buscado en la BD
    private boolean orientacionBuscado;
    private boolean modeloBuscado;
    private boolean esquinaBuscado;
    private boolean tipoSemaforoBuscado;
    private boolean ubicacionBuscado;

    public Date getfechaInstalacion() {
        return implementacion.getfechaInstalacion();
    }

    public String getnumeroSerie() {
        return implementacion.getnumeroSerie();
    }

    public void setfechaInstalacion(Date newVal) {
        implementacion.setfechaInstalacion(newVal);
    }

    public void setnumeroSerie(String newVal) {
        implementacion.setnumeroSerie(newVal);
    }

    public Orientacion getOrientacion() {
        if (isOrientacionBuscado() == false) {
            implementacion.setOrientacion((Orientacion) FachadaInterna.getInstancia().buscar("Orientacion", oidOrientacion));
            orientacionBuscado = true;
        }
        return implementacion.getOrientacion();
    }

    public void setOrientacion(Orientacion orientacion) {
        implementacion.setOrientacion(orientacion);
    }

    public Modelo getModelo() {
        if (isModeloBuscado() == false) {
            implementacion.setModelo((Modelo) FachadaInterna.getInstancia().buscar("Modelo", oidModelo));
            modeloBuscado = true;
        }
        return implementacion.getModelo();
    }

    public void setModelo(Modelo modelo) {
        implementacion.setModelo(modelo);
    }

    public Esquina getEsquina() {
        if (isEsquinaBuscado() == false) {
            implementacion.setEsquina((Esquina) FachadaInterna.getInstancia().buscar("Esquina", oidEsquina));
            esquinaBuscado = true;
        }
        return implementacion.getEsquina();
    }

    public void setEsquina(Esquina esquina) {
        implementacion.setEsquina(esquina);
    }

    public TipoSemaforo getTipoSemaforo() {
        if (isTipoSemaforoBuscado() == false) {
            implementacion.setTipoSemaforo((TipoSemaforo) FachadaInterna.getInstancia().buscar("TipoSemaforo", oidTipoSemaforo));
            tipoSemaforoBuscado = true;
        }
        return implementacion.getTipoSemaforo();
    }

    public void setTipoSemaforo(TipoSemaforo tipoSemaforo) {
        implementacion.setTipoSemaforo(tipoSemaforo);
    }

    public Ubicacion getUbicacion() {
        if (isUbicacionBuscado() == false) {
            implementacion.setUbicacion((Ubicacion) FachadaInterna.getInstancia().buscar("Ubicacion", oidUbicacion));
        }
        return implementacion.getUbicacion();
    }

    public void setUbicacion(Ubicacion ubicacion) {
        implementacion.setUbicacion(ubicacion);
    }

    /**
     * @return the implementacion
     */
    public SemaforoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(SemaforoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidOrientacion
     */
    public String getOidOrientacion() {
        return oidOrientacion;
    }

    /**
     * @param oidOrientacion the oidOrientacion to set
     */
    public void setOidOrientacion(String oidOrientacion) {
        this.oidOrientacion = oidOrientacion;
    }

    /**
     * @return the orientacionBuscado
     */
    public boolean isOrientacionBuscado() {
        return orientacionBuscado;
    }

    /**
     * @param orientacionBuscado the orientacionBuscado to set
     */
    public void setOrientacionBuscado(boolean orientacionBuscado) {
        this.orientacionBuscado = orientacionBuscado;
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
     * @return the oidEsquina
     */
    public String getOidEsquina() {
        return oidEsquina;
    }

    /**
     * @param oidEsquina the oidEsquina to set
     */
    public void setOidEsquina(String oidEsquina) {
        this.oidEsquina = oidEsquina;
    }

    /**
     * @return the esquinaBuscado
     */
    public boolean isEsquinaBuscado() {
        return esquinaBuscado;
    }

    /**
     * @param esquinaBuscado the esquinaBuscado to set
     */
    public void setEsquinaBuscado(boolean esquinaBuscado) {
        this.esquinaBuscado = esquinaBuscado;
    }

    /**
     * @return the oidTipoSemaforo
     */
    public String getOidTipoSemaforo() {
        return oidTipoSemaforo;
    }

    /**
     * @param oidTipoSemaforo the oidTipoSemaforo to set
     */
    public void setOidTipoSemaforo(String oidTipoSemaforo) {
        this.oidTipoSemaforo = oidTipoSemaforo;
    }

    /**
     * @return the tipoSemaforoBuscado
     */
    public boolean isTipoSemaforoBuscado() {
        return tipoSemaforoBuscado;
    }

    /**
     * @param tipoSemaforoBuscado the tipoSemaforoBuscado to set
     */
    public void setTipoSemaforoBuscado(boolean tipoSemaforoBuscado) {
        this.tipoSemaforoBuscado = tipoSemaforoBuscado;
    }

    /**
     * @return the oidUbicacion
     */
    public String getOidUbicacion() {
        return oidUbicacion;
    }

    /**
     * @param oidUbicacion the oidUbicacion to set
     */
    public void setOidUbicacion(String oidUbicacion) {
        this.oidUbicacion = oidUbicacion;
    }

    /**
     * @return the ubicacionBuscado
     */
    public boolean isUbicacionBuscado() {
        return ubicacionBuscado;
    }

    /**
     * @param ubicacionBuscado the ubicacionBuscado to set
     */
    public void setUbicacionBuscado(boolean ubicacionBuscado) {
        this.ubicacionBuscado = ubicacionBuscado;
    }
}
