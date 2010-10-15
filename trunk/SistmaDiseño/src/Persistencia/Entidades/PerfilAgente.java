/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author informatica
 */
public class PerfilAgente extends ObjetoPersistente implements Perfil{

        private PerfilImplementacion implementacion;


	public String getNombrePerfil(){
		return implementacion.getNombrePerfil();
	}

	public int getNroPerfil(){
		return implementacion.getNroPerfil();
	}

        public PerfilImplementacion getImplementacion(){
                return implementacion;
        }

	/**
	 *
	 * @param newVal
	 */
	public void setNombrePerfil(String newVal){
		implementacion.setNombrePerfil(newVal);
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNroPerfil(int newVal){
		implementacion.setNroPerfil(newVal);
	}

        public void setImplementacion(PerfilImplementacion impl){
            this.implementacion = impl;
        }



}
