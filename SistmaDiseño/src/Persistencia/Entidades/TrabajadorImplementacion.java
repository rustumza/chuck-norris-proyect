package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:18 p.m.
 */
public class TrabajadorImplementacion implements Trabajador {

    private String apellido;
    private String Documento;
    private String legajo;
    private String nombre;
    private String tipoDocumento;
    private Trabajo trabajo;

    public TrabajadorImplementacion() {
    }

    public String getapellido() {
        return apellido;
    }

    public String getDocumento() {
        return Documento;
    }

    public String getlegajo() {
        return legajo;
    }

    public String getnombre() {
        return nombre;
    }

    public String gettipoDocumento() {
        return tipoDocumento;
    }

    /**
     *
     * @param newVal
     */
    public void setapellido(String newVal) {
        apellido = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setDocumento(String newVal) {
        Documento = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setlegajo(String newVal) {
        legajo = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setnombre(String newVal) {
        nombre = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void settipoDocumento(String newVal) {
        tipoDocumento = newVal;
    }

    /**
     * @return the trabajo
     */
    public Trabajo getTrabajo() {
        return trabajo;
    }

    /**
     * @param trabajo the trabajo to set
     */
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }
}
