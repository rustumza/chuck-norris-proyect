/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;

/**
 *
 * @author diego
 */
public interface Semaforo extends SuperDruperInterfaz {

    public Date getfechaInstalacion();

    public String getnumeroSerie();

    public void setfechaInstalacion(Date newVal);

    public void setnumeroSerie(String newVal);

    public Orientacion getOrientacion();

    public void setOrientacion(Orientacion orientacion);

    public Modelo getModelo();

    public void setModelo(Modelo modelo);

    public Esquina getEsquina();

    public void setEsquina(Esquina esquina);

    public TipoSemaforo getTipoSemaforo();

    public void setTipoSemaforo(TipoSemaforo tipoSemaforo);

    public Ubicacion getUbicacion();

    public void setUbicacion(Ubicacion ubicacion);
}
