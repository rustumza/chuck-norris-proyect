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
public class CronogramaDeMantenimientoAgente implements CronogramaDeMantenimiento {

    private CronogramaDeMantenimientoImplementacion implementacion;
    private String oidFichaMantenimiento;

    private boolean fichaMantenimientoBuscado;

    public int getcodigoCronograma() {
        return implementacion.getcodigoCronograma();
    }

    public Date getfechaDeCreacion() {
        return implementacion.getfechaDeCreacion();
    }

    public Date getfechaFinCronograma() {
        return implementacion.getfechaFinCronograma();
    }

    public Date getfechaInicioCronograma() {
        return implementacion.getfechaInicioCronograma();
    }

    public String getobservacionesCronograma() {
        return implementacion.getobservacionesCronograma();
    }

    public void setcodigoCronograma(int newVal) {
        implementacion.setcodigoCronograma(newVal);
    }

    public void setfechaDeCreacion(Date newVal) {
        implementacion.setfechaDeCreacion(newVal);
    }

    public void setfechaFinCronograma(Date newVal) {
        implementacion.setfechaFinCronograma(newVal);
    }

    public void setfechaInicioCronograma(Date newVal) {
        implementacion.setfechaInicioCronograma(newVal);
    }

    public void setobservacionesCronograma(String newVal) {
        implementacion.setobservacionesCronograma(newVal);
    }

    public FichaMantenimiento getFichaMantenimiento() {
        if (isFichaMantenimientoBuscado() == false) {
            implementacion.setFichaMantenimiento((FichaMantenimiento) FachadaInterna.getInstancia().buscar("FichaMantenimiento", oidFichaMantenimiento));
        }
        return implementacion.getFichaMantenimiento();
    }

    public void setFichaMantenimiento(FichaMantenimiento fichaMantenimiento) {
        implementacion.setFichaMantenimiento(fichaMantenimiento);
    }

    /**
     * @return the implementacion
     */
    public CronogramaDeMantenimientoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(CronogramaDeMantenimientoImplementacion implementacion) {
        this.implementacion = implementacion;
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
     * @return the fichaMantenimientoBuscadoBuscado
     */
    public boolean isFichaMantenimientoBuscado() {
        return fichaMantenimientoBuscado;
    }

    /**
     * @param fichaMantenimientoBuscadoBuscado the fichaMantenimientoBuscadoBuscado to set
     */
    public void setFichaMantenimientoBuscado(boolean fichaMantenimientoBuscadoBuscado) {
        this.fichaMantenimientoBuscado = fichaMantenimientoBuscadoBuscado;
    }
}
