package Persistencia.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class EquipoDeTrabajoImplementacion implements EquipoDeTrabajo{

	private int cargaHorariaMaxPorDia;
	private int codigoEquipo;
	private String nombreEquipo;
	private List<TrabajadorRol> roles;

	public EquipoDeTrabajoImplementacion(){

	}

	
	public int getcargaHorariaMaxPorDia(){
		return cargaHorariaMaxPorDia;
	}

	public int getcodigoEquipo(){
		return codigoEquipo;
	}

	public String getnombreEquipo(){
		return nombreEquipo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcargaHorariaMaxPorDia(int newVal){
		cargaHorariaMaxPorDia = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoEquipo(int newVal){
		codigoEquipo = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreEquipo(String newVal){
		nombreEquipo = newVal;
	}

    /**
     * @return the trabajadorRol
     */
    public List<TrabajadorRol> getTrabajadorRol() {
        return roles;
    }

    /**
     * @param trabajadorRol the trabajadorRol to set
     */
    public void setTrabajadorRol(List<TrabajadorRol> trabajadorRol) {
        this.roles = trabajadorRol;
    }

    public void addRol(TrabajadorRol nuevoRol){
        if(roles == null){
            roles = new ArrayList<TrabajadorRol>();
        }
        roles.add(nuevoRol);
    }

}
