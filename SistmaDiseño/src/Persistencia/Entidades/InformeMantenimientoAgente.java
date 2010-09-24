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
public class InformeMantenimientoAgente implements InformeMantenimiento {

    private InformeMantenimientoImplementacion implementacion;
    private String oidDetalleInformeMantenimiento;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean detalleInformeMantenimientoBuscado;

    public int getcodigoInformeMantenimiento() {
        return implementacion.getcodigoInformeMantenimiento();
    }

    public int getduracionMantenimiento() {
        return implementacion.getduracionMantenimiento();
    }

    public Date getfechaInforme() {
        return implementacion.getfechaInforme();
    }

    public Date gethorainforme() {
        return implementacion.gethorainforme();
    }

    public void setcodigoInformeMantenimiento(int newVal) {
        implementacion.setcodigoInformeMantenimiento(newVal);
    }

    public void setduracionMantenimiento(int newVal) {
        implementacion.setduracionMantenimiento(newVal);
    }

    public void setfechaInforme(Date newVal) {
        implementacion.setfechaInforme(newVal);
    }

    public void sethorainforme(Date newVal) {
        implementacion.sethorainforme(newVal);
    }

    public DetalleInformeMantenimiento getDetalleInformeMantenimiento() {
        if (isDetalleInformeMantenimientoBuscado() == false) {
            implementacion.setDetalleInformeMantenimiento((DetalleInformeMantenimiento) FachadaInterna.getInstancia().buscar("DetalleInformeMantenimiento", oidDetalleInformeMantenimiento));
        }
        return implementacion.getDetalleInformeMantenimiento();
    }

    public void setDetalleInformeMantenimiento(DetalleInformeMantenimiento detalleInformeMantenimiento) {
        implementacion.setDetalleInformeMantenimiento(detalleInformeMantenimiento);
    }

    /**
     * @return the implementacion
     */
    public InformeMantenimientoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(InformeMantenimientoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidDetalleInformeMantenimiento
     */
    public String getOidDetalleInformeMantenimiento() {
        return oidDetalleInformeMantenimiento;
    }

    /**
     * @param oidDetalleInformeMantenimiento the oidDetalleInformeMantenimiento to set
     */
    public void setOidDetalleInformeMantenimiento(String oidDetalleInformeMantenimiento) {
        this.oidDetalleInformeMantenimiento = oidDetalleInformeMantenimiento;
    }

    /**
     * @return the detalleInformeMantenimientoBuscado
     */
    public boolean isDetalleInformeMantenimientoBuscado() {
        return detalleInformeMantenimientoBuscado;
    }

    /**
     * @param detalleInformeMantenimientoBuscado the detalleInformeMantenimientoBuscado to set
     */
    public void setDetalleInformeMantenimientoBuscado(boolean detalleInformeMantenimientoBuscado) {
        this.detalleInformeMantenimientoBuscado = detalleInformeMantenimientoBuscado;
    }
}
