package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:19 p.m.
 */
public class UbicacionImplementacion implements Ubicacion{

    private int codigoubicacion;
    private int prioridad;
    private String tipoubicacion;
    private Operador operador;

    public UbicacionImplementacion() {
    }

    public int getcodigoubicacion(){
        return codigoubicacion;

    }
    public int getPrioridad() {
        return prioridad;
    }

    public String gettipoubicacion() {
        return tipoubicacion;
    }

    /**
     *
     * @param newVal
     */

    public void setcodigoubicacion(int newVal){
        codigoubicacion = newVal;
    }
    public void setPrioridad(int newVal) {
        prioridad = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void settipoubicacion(String newVal) {
        tipoubicacion = newVal;
    }

    /**
     * @return the operador
     */
    public Operador getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(Operador operador) {
        this.operador = operador;
    }
}
