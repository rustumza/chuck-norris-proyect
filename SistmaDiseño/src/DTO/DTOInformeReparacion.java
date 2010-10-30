/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class DTOInformeReparacion {

    private String duracion;
    private String fechaInforme;
    private String horaInforme;
    private List<DTODetalleInformeReparacion> detalles;

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the fechaInforme
     */
    public String getFechaInforme() {
        return fechaInforme;
    }

    /**
     * @param fechaInforme the fechaInforme to set
     */
    public void setFechaInforme(String fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    /**
     * @return the horaInforme
     */
    public String getHoraInforme() {
        return horaInforme;
    }

    /**
     * @param horaInforme the horaInforme to set
     */
    public void setHoraInforme(String horaInforme) {
        this.horaInforme = horaInforme;
    }

    /**
     * @return the detalles
     */
    public List<DTODetalleInformeReparacion> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(List<DTODetalleInformeReparacion> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(DTODetalleInformeReparacion nuevoDetalle) {
        if (detalles == null) {
            detalles = new ArrayList<DTODetalleInformeReparacion>();
        }
        detalles.add(nuevoDetalle);
    }

    public boolean seEncuentraDetalle(String nombreFalla) {
        boolean resultado = false;
        if (detalles != null) {
            for (DTODetalleInformeReparacion dTODetalleInformeReparacion : detalles) {
                if (dTODetalleInformeReparacion.getFalla().equals(nombreFalla)) {
                    resultado = true;
                }
            }
        }
        return resultado;
    }
}
