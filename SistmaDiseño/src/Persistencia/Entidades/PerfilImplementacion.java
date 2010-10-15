/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author informatica
 */
public class PerfilImplementacion implements Perfil{

    	private String NombrePerfil;
	private int NroPerfil;


	public PerfilImplementacion(){

	}


	public String getNombrePerfil(){
		return NombrePerfil;
	}

	public int getNroPerfil(){
		return NroPerfil;
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNombrePerfil(String newVal){
		NombrePerfil = newVal;
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNroPerfil(int newVal){
		NroPerfil = newVal;
	}


}
