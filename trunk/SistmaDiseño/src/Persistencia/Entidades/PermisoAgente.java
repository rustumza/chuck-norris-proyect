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
public class PermisoAgente extends ObjetoPersistente implements Permiso{

    private PermisoImplementacion implementacion;
    private String oidPerfil;
    //variable para saber si se ha buscado el objeto relacionado
    private boolean perfilBuscado;


    public int getNroPermiso(){
        return implementacion.getNroPermiso();
    }

    public String getNombrePermiso(){
        return implementacion.getNombrePermiso();
    }

    public PermisoImplementacion getImplementacion(){
        return implementacion;
    }

    public String getOidPerfil(){
        return oidPerfil;
    }

    public boolean isPerfilBuscado(){
        return perfilBuscado;
    }

    public Perfil getPerfil(){
        if (isPerfilBuscado() == false) {
            implementacion.setPerfil((Perfil)FachadaInterna.getInstancia().buscar("Perfil", oidPerfil));
            perfilBuscado = true;
        }
        return implementacion.getPerfil();
    }

    public void setNroPermiso(Integer nroPerm){
        implementacion.setNroPermiso(nroPerm);
    }

    public void setNombrePermiso(String nomPermiso){
        implementacion.setNombrePermiso(nomPermiso);
    }

    public void setImplementacion(PermisoImplementacion impl){
        this.implementacion = impl;
    }

    public void setOidPerfil(String oidPerf){
        this.oidPerfil = oidPerf;
    }

    public void setPerfil(Perfil per){
        implementacion.setPerfil(per);
    }

    public void setPerfilBuscado(boolean PerfBuscado){
        this.perfilBuscado = PerfBuscado;
    }

    
}
