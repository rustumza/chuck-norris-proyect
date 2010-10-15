/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author informatica
 */
public class UsuarioAgente extends ObjetoPersistente implements Usuario {

        private UsuarioImplementacion implementacion;
	private String oidPerfil;
        //variable para objetos relacionados
        private boolean perfilBuscado;


	public String getClave(){
		return implementacion.getClave();
	}

	public String getNombreUsuario(){
		return implementacion.getNombreUsuario();
	}

	public int getNroUsuario(){
		return implementacion.getNroUsuario();
	}

        public UsuarioImplementacion getImplementacion(){
            return implementacion;
        }

        public String getOidPerfil(){
            return oidPerfil;
        }

        public Perfil getPerfil(){
            if (isPerfilBuscado() == false) {
                implementacion.setPerfil((Perfil) FachadaInterna.getInstancia().buscar("Perfil", oidPerfil));
                perfilBuscado = true;
            }
            return implementacion.getPerfil();
        }

        public boolean isPerfilBuscado(){
            return perfilBuscado;
        }

	/**
	 *
	 * @param newVal
	 */
	public void setClave(String newVal){
		implementacion.setClave(newVal);
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNombreUsuario(String newVal){
		implementacion.setNombreUsuario(newVal);
	}

	/**
	 *
	 * @param newVal
	 */
	public void setNroUsuario(int newVal){
		implementacion.setNroUsuario(newVal);
	}

        public void setImplementacion(UsuarioImplementacion impl){
            this.implementacion = impl;
        }

        public void setPerfilBuscado(boolean perfBuscado){
            this.perfilBuscado = perfBuscado;
        }

        public void setPerfil(Perfil perf){
            implementacion.setPerfil(perf);
        }

        public void setOidPerfil(String oidPerf){
            this.oidPerfil = oidPerf;
        }


}
