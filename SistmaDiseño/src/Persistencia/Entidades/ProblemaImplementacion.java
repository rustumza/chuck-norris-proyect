package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class ProblemaImplementacion implements Problema{

	private int codigoProblema;
	private String descripcionProblema;
	private Caso caso;

    @Override
    public String toString(){
        return getdescripcionProblema();
    }

    public ProblemaImplementacion(){

    }

	
    public int getcodigoProblema() {
        return codigoProblema;
    }

    public String getdescripcionProblema() {
        return descripcionProblema;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoProblema(int newVal) {
        codigoProblema = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setdescripcionProblema(String newVal) {
        descripcionProblema = newVal;
    }

    /**
     * @return the caso
     */
    public Caso getCaso() {
        return caso;
    }

    /**
     * @param caso the caso to set
     */
    public void setCaso(Caso caso) {
        this.caso = caso;
    }

}
