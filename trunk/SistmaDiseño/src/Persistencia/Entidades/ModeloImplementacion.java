package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class ModeloImplementacion implements Modelo{

	private int codigomodelo;
	private String nombremodelo;
	private Marca marca;

	public ModeloImplementacion(){

	}

	
   public int getcodigomodelo() {
        return codigomodelo;
    }

    public String getnombremodelo() {
        return nombremodelo;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigomodelo(int newVal) {
        codigomodelo = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setnombremodelo(String newVal) {
        nombremodelo = newVal;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
