package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class OrdenDeReparacionImplementacion extends OrdenTrabajoImplementacion implements OrdenDeReparacion {

    private int codigoordenreparacion;
    private Denuncia denuncia;
    private InformeReparacion informeReparacion;

    public OrdenDeReparacionImplementacion() {
    }

    public int getcodigoordenreparacion() {
        return codigoordenreparacion;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoordenreparacion(int newVal) {
        codigoordenreparacion = newVal;
    }

    /**
     * @return the denuncia
     */
    public Denuncia getDenuncia() {
        return denuncia;
    }

    /**
     * @param denuncia the denuncia to set
     */
    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    /**
     * @return the informeReparacion
     */
    public InformeReparacion getInformeReparacion() {
        return informeReparacion;
    }

    /**
     * @param informeReparacion the informeReparacion to set
     */
    public void setInformeReparacion(InformeReparacion informeReparacion) {
        this.informeReparacion = informeReparacion;
    }
}
