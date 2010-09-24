package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:18 p.m.
 */
public class SemaforoImplementacion implements Semaforo{

    private Date fechaInstalacion;
    private String numeroSerie;
    private Orientacion orientacion;
    private Modelo modelo;
    private Esquina esquina;
    private TipoSemaforo tipoSemaforo;
    private Ubicacion ubicacion;

    public SemaforoImplementacion() {
    }

    public Date getfechaInstalacion() {
        return fechaInstalacion;
    }

    public String getnumeroSerie() {
        return numeroSerie;
    }

    /**
     *
     * @param newVal
     */
    public void setfechaInstalacion(Date newVal) {
        fechaInstalacion = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setnumeroSerie(String newVal) {
        numeroSerie = newVal;
    }

    /**
     * @return the orientacion
     */
    public Orientacion getOrientacion() {
        return orientacion;
    }

    /**
     * @param orientacion the orientacion to set
     */
    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the esquina
     */
    public Esquina getEsquina() {
        return esquina;
    }

    /**
     * @param esquina the esquina to set
     */
    public void setEsquina(Esquina esquina) {
        this.esquina = esquina;
    }

    /**
     * @return the tipoSemaforo
     */
    public TipoSemaforo getTipoSemaforo() {
        return tipoSemaforo;
    }

    /**
     * @param tipoSemaforo the tipoSemaforo to set
     */
    public void setTipoSemaforo(TipoSemaforo tipoSemaforo) {
        this.tipoSemaforo = tipoSemaforo;
    }

    /**
     * @return the ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
