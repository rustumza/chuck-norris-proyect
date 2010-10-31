package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class OperadorImplementacion implements Operador{

	private String legajo;
	private String nombreOperador;
        private TipoOperador tipoOperador;
        private Usuario usuario;

	public OperadorImplementacion(){

	}

	
	public String getlegajo(){
		return legajo;
	}

	public String getnombreOperador(){
		return nombreOperador;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setlegajo(String newVal){
		legajo = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreOperador(String newVal){
		nombreOperador = newVal;
	}

    /**
     * @return the tipoOperador
     */
    public TipoOperador getTipoOperador() {
        return tipoOperador;
    }

    /**
     * @param tipoOperador the tipoOperador to set
     */
    public void setTipoOperador(TipoOperador tipoOperador) {
        this.tipoOperador = tipoOperador;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
