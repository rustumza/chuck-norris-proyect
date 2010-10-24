/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class PerfilImplementacion implements Perfil{

    	private String NombrePerfil;
	private int NroPerfil;
        private List<Permiso> permisos;


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

    /**
     * @return the permisos
     */
    public List<Permiso> getPermisos() {
        return permisos;
    }

    /**
     * @param permisos the permisos to set
     */
    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public void addPermiso(Permiso nuevoPermiso){
        if(permisos == null){
            permisos = new ArrayList<Permiso>();
        }

        permisos.add(nuevoPermiso);
    }


}
