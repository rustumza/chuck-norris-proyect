package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class EstadoDenunciaImplementacion implements EstadoDenuncia{

	private int codigoestadodenuncia;
	private String nombreestado;

	public EstadoDenunciaImplementacion(){

	}

	
	public int getcodigoestadodenuncia(){
		return codigoestadodenuncia;
	}

	public String getnombreestado(){
		return nombreestado;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoestadodenuncia(int newVal){
		codigoestadodenuncia = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreestado(String newVal){
		nombreestado = newVal;
	}

}
