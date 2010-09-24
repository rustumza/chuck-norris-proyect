/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class OrdenDeMantenimientoAgente extends OrdenTrabajoAgente implements OrdenDeMantenimiento {

    private String oidSemaforo;
    private String oidFichaMantenimiento;
    //variabale para saber si el objeto relacionado ha sido buscado en la BD
    private boolean semaforoBuscado;
    private boolean informeMantenimientoBuscado;
    private boolean fichaMantenimientoBuscado;

    public int getcodigoordenmantenimiento() {
        return ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).getcodigoordenmantenimiento();
    }

    public void setcodigoordenmantenimiento(int newVal) {
        ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setcodigoordenmantenimiento(newVal);
    }

    public Semaforo getSemaforo() {
        if (isSemaforoBuscado() == false) {
            ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setSemaforo((Semaforo) FachadaInterna.getInstancia().buscar("Semaforo", oidSemaforo));
        }
        return ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).getSemaforo();

    }

    public void setSemaforo(Semaforo semaforo) {
        ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setSemaforo(semaforo);
    }

    public InformeMantenimiento getInformeMantenimiento() {
        if (informeMantenimientoBuscado == false) {
            List<Criterio> listaCriterio = new ArrayList<Criterio>();
            listaCriterio.add(FabricaCriterios.getInstancia().crearCriterio("OIDOrdenDeTrabajo", "=", getOid()));
            ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setInformeMantenimiento((InformeMantenimiento) FachadaInterna.getInstancia().buscar("InformeMantenimiento", listaCriterio).get(0));
        }

        return ((OrdenDeMantenimiento)super.getImplementacion()).getInformeMantenimiento();
    }

    public void setInformeMantenimiento(InformeMantenimiento informeMantenimiento) {
        ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setInformeMantenimiento(informeMantenimiento);
    }

    public FichaMantenimiento getFichaMantenimiento() {
        if (isFichaMantenimientoBuscado() == false) {
            ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setFichaMantenimiento((FichaMantenimiento) FachadaInterna.getInstancia().buscar("FichaMantenimiento", oidFichaMantenimiento));
        }
        return ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).getFichaMantenimiento();
    }

    public void setFichaMantenimiento(FichaMantenimiento fichaMantenimiento) {
        ((OrdenDeMantenimientoImplementacion) super.getImplementacion()).setFichaMantenimiento(fichaMantenimiento);
    }

    /**
     * @return the oidSemaforo
     */
    public String getOidSemaforo() {
        return oidSemaforo;
    }

    /**
     * @param oidSemaforo the oidSemaforo to set
     */
    public void setOidSemaforo(String oidSemaforo) {
        this.oidSemaforo = oidSemaforo;
    }

    /**
     * @return the semaforoBuscado
     */
    public boolean isSemaforoBuscado() {
        return semaforoBuscado;
    }

    /**
     * @param semaforoBuscado the semaforoBuscado to set
     */
    public void setSemaforoBuscado(boolean semaforoBuscado) {
        this.semaforoBuscado = semaforoBuscado;
    }

    /**
     * @return the informeMantenimientoBuscado
     */
    public boolean isInformeMantenimientoBuscado() {
        return informeMantenimientoBuscado;
    }

    /**
     * @param informeMantenimientoBuscado the informeMantenimientoBuscado to set
     */
    public void setInformeMantenimientoBuscado(boolean informeMantenimientoBuscado) {
        this.informeMantenimientoBuscado = informeMantenimientoBuscado;
    }

    /**
     * @return the oidFichaMantenimiento
     */
    public String getOidFichaMantenimiento() {
        return oidFichaMantenimiento;
    }

    /**
     * @param oidFichaMantenimiento the oidFichaMantenimiento to set
     */
    public void setOidFichaMantenimiento(String oidFichaMantenimiento) {
        this.oidFichaMantenimiento = oidFichaMantenimiento;
    }

    /**
     * @return the fichaMantenimientoBuscado
     */
    public boolean isFichaMantenimientoBuscado() {
        return fichaMantenimientoBuscado;
    }

    /**
     * @param fichaMantenimientoBuscado the fichaMantenimientoBuscado to set
     */
    public void setFichaMantenimientoBuscado(boolean fichaMantenimientoBuscado) {
        this.fichaMantenimientoBuscado = fichaMantenimientoBuscado;
    }

}
