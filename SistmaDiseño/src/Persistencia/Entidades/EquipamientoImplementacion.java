package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class EquipamientoImplementacion extends ElementoTrabajoImplementacion implements Equipamiento{

	private int codigoEquipamiento;
	private String nombreEquipamiento;

	public EquipamientoImplementacion(){

	}


	public int getcodigoEquipamiento(){
		return codigoEquipamiento;
	}

	public String getnombreEquipamiento(){
		return nombreEquipamiento;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoEquipamiento(int newVal){
		codigoEquipamiento = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreEquipamiento(String newVal){
		nombreEquipamiento = newVal;
	}

}
