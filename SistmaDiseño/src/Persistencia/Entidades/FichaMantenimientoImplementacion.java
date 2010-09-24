package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:14 p.m.
 */
public class FichaMantenimientoImplementacion implements FichaMantenimiento {

    private int codigoFichaMantenimiento;
    private Modelo modelo;
    private Periodicidad periodicidad;
    private RangoAnios rangoAnios;
    private Tarea tarea;

    public FichaMantenimientoImplementacion() {
    }

    public int getcodigoFichaMantenimiento() {
        return codigoFichaMantenimiento;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoFichaMantenimiento(int newVal) {
        codigoFichaMantenimiento = newVal;
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
     * @return the periodicidad
     */
    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    /**
     * @param periodicidad the periodicidad to set
     */
    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    /**
     * @return the rangoAnios
     */
    public RangoAnios getRangoAnios() {
        return rangoAnios;
    }

    /**
     * @param rangoAnios the rangoAnios to set
     */
    public void setRangoAnios(RangoAnios rangoAnios) {
        this.rangoAnios = rangoAnios;
    }

    /**
     * @return the tarea
     */
    public Tarea getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}
