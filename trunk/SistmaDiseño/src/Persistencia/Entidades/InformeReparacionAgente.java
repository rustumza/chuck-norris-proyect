/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author diego
 */
public class InformeReparacionAgente implements InformeReparacion {

    private InformeReparacionImplementacion implementacion;
    private String oidDetalleInformeReparacion;
    //variable para saber si el objeto relacionado ya ha sido buscado
    private boolean detalleInformeReparacionBuscado;

    public int getduracionReparacion() {
        return implementacion.getduracionReparacion();
    }

    public Date getfechainforme() {
        return implementacion.getfechainforme();
    }

    public Time gethorainforme() {
        return implementacion.gethorainforme();
    }

    public void setduracionReparacion(int newVal) {
        implementacion.setduracionReparacion(newVal);
    }

    public void setfechainforme(Date newVal) {
        implementacion.setfechainforme(newVal);
    }

    public void sethorainforme(Time newVal) {
        implementacion.sethorainforme(newVal);
    }

    public DetalleInformeReparacion getDetalleInformeReparacion() {
        if (isDetalleInformeReparacionBuscado() == false) {
            implementacion.setDetalleInformeReparacion((DetalleInformeReparacion) FachadaInterna.getInstancia().buscar("DetalleInformeReparacion", oidDetalleInformeReparacion));
        }
        return implementacion.getDetalleInformeReparacion();
    }

    public void setDetalleInformeReparacion(DetalleInformeReparacion detalleInformeReparacion) {
        implementacion.setDetalleInformeReparacion(detalleInformeReparacion);
    }

    /**
     * @return the implementacion
     */
    public InformeReparacionImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(InformeReparacionImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidDetalleInformeReparacion
     */
    public String getOidDetalleInformeReparacion() {
        return oidDetalleInformeReparacion;
    }

    /**
     * @param oidDetalleInformeReparacion the oidDetalleInformeReparacion to set
     */
    public void setOidDetalleInformeReparacion(String oidDetalleInformeReparacion) {
        this.oidDetalleInformeReparacion = oidDetalleInformeReparacion;
    }

    /**
     * @return the detalleInformeReparacionBuscado
     */
    public boolean isDetalleInformeReparacionBuscado() {
        return detalleInformeReparacionBuscado;
    }

    /**
     * @param detalleInformeReparacionBuscado the detalleInformeReparacionBuscado to set
     */
    public void setDetalleInformeReparacionBuscado(boolean detalleInformeReparacionBuscado) {
        this.detalleInformeReparacionBuscado = detalleInformeReparacionBuscado;
    }
}
