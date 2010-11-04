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
    


    public int getNroPermiso(){
        return implementacion.getNroPermiso();
    }

    public String getNombrePermiso(){
        return implementacion.getNombrePermiso();
    }

    public PermisoImplementacion getImplementacion(){
        return implementacion;
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
    
}
