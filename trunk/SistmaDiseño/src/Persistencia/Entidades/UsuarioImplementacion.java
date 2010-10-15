/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author informatica
 */
public class UsuarioImplementacion implements Usuario{

    
        private String Clave;
	private String NombreUsuario;
	private int NroUsuario;
	public Perfil perfil;

	public UsuarioImplementacion(){

	}


	public String getClave(){
		return Clave;
	}

	public String getNombreUsuario(){
		return NombreUsuario;
	}

	public int getNroUsuario(){
		return NroUsuario;
	}

        public Perfil getPerfil(){
            return perfil;
        }

	/**
	 *
	 * @param newVal
	 */
	public void setClave(String newVal){
		Clave = newVal;
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNombreUsuario(String newVal){
		NombreUsuario = newVal;
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNroUsuario(int newVal){
		NroUsuario = newVal;
	}

        public void setPerfil(Perfil perf){
                this.perfil = perf;
        }


}
