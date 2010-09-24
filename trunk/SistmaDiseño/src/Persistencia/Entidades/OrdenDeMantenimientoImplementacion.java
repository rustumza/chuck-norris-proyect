package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class OrdenDeMantenimientoImplementacion extends OrdenTrabajoImplementacion implements OrdenDeMantenimiento {

    private int codigoordenmantenimiento;
    private Semaforo semaforo;
    private InformeMantenimiento informeMantenimiento;
    private FichaMantenimiento fichaMantenimiento;

    public OrdenDeMantenimientoImplementacion() {
    }

    public int getcodigoordenmantenimiento() {
        return codigoordenmantenimiento;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoordenmantenimiento(int newVal) {
        codigoordenmantenimiento = newVal;
    }

    /**
     * @return the semaforo
     */
    public Semaforo getSemaforo() {
        return semaforo;
    }

    /**
     * @param semaforo the semaforo to set
     */
    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * @return the informeMantenimiento
     */
    public InformeMantenimiento getInformeMantenimiento() {
        return informeMantenimiento;
    }

    /**
     * @param informeMantenimiento the informeMantenimiento to set
     */
    public void setInformeMantenimiento(InformeMantenimiento informeMantenimiento) {
        this.informeMantenimiento = informeMantenimiento;
    }

    /**
     * @return the fichaMantenimiento
     */
    public FichaMantenimiento getFichaMantenimiento() {
        return fichaMantenimiento;
    }

    /**
     * @param fichaMantenimiento the fichaMantenimiento to set
     */
    public void setFichaMantenimiento(FichaMantenimiento fichaMantenimiento) {
        this.fichaMantenimiento = fichaMantenimiento;
    }
}
