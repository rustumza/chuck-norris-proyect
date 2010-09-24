package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:12 p.m.
 */
public class CronogramaDeMantenimientoImplementacion implements CronogramaDeMantenimiento{

	private int codigoCronograma;
	private Date fechaDeCreacion;
	private Date fechaFinCronograma;
	private Date fechaInicioCronograma;
	private String observacionesCronograma;
	private FichaMantenimiento fichaMantenimiento;

        

	public CronogramaDeMantenimientoImplementacion(){

	}

	
	public int getcodigoCronograma(){
		return codigoCronograma;
	}

	public Date getfechaDeCreacion(){
		return fechaDeCreacion;
	}

	public Date getfechaFinCronograma(){
		return fechaFinCronograma;
	}

	public Date getfechaInicioCronograma(){
		return fechaInicioCronograma;
	}

	public String getobservacionesCronograma(){
		return observacionesCronograma;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoCronograma(int newVal){
		codigoCronograma = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaDeCreacion(Date newVal){
		fechaDeCreacion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaFinCronograma(Date newVal){
		fechaFinCronograma = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaInicioCronograma(Date newVal){
		fechaInicioCronograma = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setobservacionesCronograma(String newVal){
		observacionesCronograma = newVal;
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
