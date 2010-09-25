package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:12 p.m.
 */
public class DenunciaEstadoImplementacion {

	private Date fechacambioestado;
	private boolean indicadorestadoactual;
	private EstadoDenuncia estadoDenuncia;
        


        

	public DenunciaEstadoImplementacion(){

	}

	public Date getfechacambioestado(){
		return fechacambioestado;
	}

	public boolean isindicadorestadoactual(){
		return indicadorestadoactual;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechacambioestado(Date newVal){
		fechacambioestado = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setindicadorestadoactual(boolean newVal){
		indicadorestadoactual = newVal;
	}

    /**
     * @return the estadoDenuncia
     */
    public EstadoDenuncia getEstadoDenuncia() {
        return estadoDenuncia;
    }

    /**
     * @param estadoDenuncia the estadoDenuncia to set
     */
    public void setEstadoDenuncia(EstadoDenuncia estadoDenuncia) {
        this.estadoDenuncia = estadoDenuncia;
    }


    Boolean getIndicadoresEstadoActual() {
        return indicadorestadoactual;
    }

}
