package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:18 p.m.
 */
public class TipoSemaforoImplementacion implements TipoSemaforo {

	private int codigoTipoSemaforo;
	private String descripciontiposemaforo;

	public TipoSemaforoImplementacion(){

	}

	
	public int getcodigoTipoSemaforo(){
		return codigoTipoSemaforo;
	}

	public String getdescripciontiposemaforo(){
		return descripciontiposemaforo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoTipoSemaforo(int newVal){
		codigoTipoSemaforo = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripciontiposemaforo(String newVal){
		descripciontiposemaforo = newVal;
	}

}
