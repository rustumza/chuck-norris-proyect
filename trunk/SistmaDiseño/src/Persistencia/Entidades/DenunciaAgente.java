/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class DenunciaAgente extends CasoAgente implements Denuncia {

    private DenunciaImplementacion implementacion;
    private String oidReclamo;
    private List<String> oidDenunciaEstado;
    private List<String> listaOidFallaTecnica;
    //variables para saber si se han buscado los atributos en la BD
    private boolean reclamoBuscado;
    private boolean denunciaEstadoBuscado;
    private boolean fallaTecnicaBuscado;

    public int getcodigoDenuncia() {
        return implementacion.getcodigoDenuncia();
    }

    public float getprioridad() {
        return implementacion.getprioridad();
    }

    public void setcodigoDenuncia(int newVal) {
        implementacion.setcodigoDenuncia(newVal);
    }

    public void setprioridad(float newVal) {
        implementacion.setprioridad(newVal);
    }

    public List<Reclamo> getReclamo() {
        if (isReclamoBuscado() == false) {
            List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
            listaDeCriterio.add(FachadaInterna.getInstancia().crearCriterio("oidDenuncia", "=", super.getOid()));
            List<SuperDruperInterfaz> listaDeInterfaces = FachadaInterna.getInstancia().buscar("Reclamo", listaDeCriterio);
            List<Reclamo> listaReclamo = new ArrayList<Reclamo>();
            for (SuperDruperInterfaz aux : listaDeInterfaces) {
                listaReclamo.add((Reclamo) aux);
            }

            implementacion.setReclamo(listaReclamo);
        }
        return implementacion.getReclamo();
    }

    public void setReclamo(List<Reclamo> reclamo) {
        implementacion.setReclamo(reclamo);
        reclamoBuscado = true;
    }

    public List<DenunciaEstado> getDenunciaEstado() {
        if (isDenunciaEstadoBuscado() == false) {
            List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
            listaDeCriterio.add(FachadaInterna.getInstancia().crearCriterio("oidDenuncia", "=", super.getOid()));
            List<SuperDruperInterfaz> listaDencunaEstados = FachadaInterna.getInstancia().buscar("DenunciaEstado", listaDeCriterio);
            for (SuperDruperInterfaz denunciaEstado : listaDencunaEstados) {
                implementacion.addDenunciaEstado((DenunciaEstado) denunciaEstado);
            }
        }
        return implementacion.getDenunciaEstado();
    }

    public void setDenunciaEstado(List<DenunciaEstado> denunciaEstado) {
        implementacion.setDenunciaEstado(denunciaEstado);
        denunciaEstadoBuscado=true;
        if(oidDenunciaEstado ==null)
            oidDenunciaEstado = new ArrayList<String>();
        for(DenunciaEstado aux : denunciaEstado)
            oidDenunciaEstado.add(((ObjetoPersistente)aux).getOid());
    }

    public List<FallaTecnica> getFallasTecnica() {
        if (isFallaTecnicaBuscado() == false) {
            List<Criterio> listacCriterios = new ArrayList<Criterio>();
            listacCriterios.add(FabricaCriterios.getInstancia().crearCriterio("Denuncia", "=",this));
            List<FallaTecnica> listaFallas = new ArrayList<FallaTecnica>();
            for(SuperDruperInterfaz falla :FachadaInterna.getInstancia().buscar("FallaTecnica", listacCriterios)){
                listaFallas.add((FallaTecnica)falla);
            }
            implementacion.setFallasTecnica(listaFallas);
            fallaTecnicaBuscado = true;
        }
        return implementacion.getFallasTecnica();
    }

    public void setFallasTecnica(List<FallaTecnica> fallaTecnica) {
        implementacion.setFallasTecnica(fallaTecnica);
    }

    /**
     * @return the implementacion
     */
    @Override
    public DenunciaImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(DenunciaImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidReclamo
     */
    public String getOidReclamo() {
        return oidReclamo;
    }

    /**
     * @param oidReclamo the oidReclamo to set
     */
    public void setOidReclamo(String oidReclamo) {
        this.oidReclamo = oidReclamo;
    }

    /**
     * @return the oidDenunciaEstado
     */
    public List<String> getOidDenunciaEstado() {
        return oidDenunciaEstado;
    }

    /**
     * @param oidDenunciaEstado the oidDenunciaEstado to set
     */
    public void setOidDenunciaEstado(List<String> oidDenunciaEstado) {
        this.oidDenunciaEstado = oidDenunciaEstado;
    }

    /**
     * @return the reclamoBuscado
     */
    public boolean isReclamoBuscado() {
        return reclamoBuscado;
    }

    public void addOidFallaTecnica(String oidFallaTecnica) {
        if (listaOidFallaTecnica == null) {
            listaOidFallaTecnica = new ArrayList<String>();
        }

        listaOidFallaTecnica.add(oidFallaTecnica);
    }

    /**
     * @param reclamoBuscado the reclamoBuscado to set
     */
    public void setReclamoBuscado(boolean reclamoBuscado) {
        this.reclamoBuscado = reclamoBuscado;
    }

    /**
     * @return the denunciaEstadoBuscado
     */
    public boolean isDenunciaEstadoBuscado() {
        return denunciaEstadoBuscado;
    }

    /**
     * @param denunciaEstadoBuscado the denunciaEstadoBuscado to set
     */
    public void setDenunciaEstadoBuscado(boolean denunciaEstadoBuscado) {
        this.denunciaEstadoBuscado = denunciaEstadoBuscado;
    }

    /**
     * @return the fallaTecnicaBuscado
     */
    public boolean isFallaTecnicaBuscado() {
        return fallaTecnicaBuscado;
    }

    /**
     * @param fallaTecnicaBuscado the fallaTecnicaBuscado to set
     */
    public void setFallaTecnicaBuscado(boolean fallaTecnicaBuscado) {
        this.fallaTecnicaBuscado = fallaTecnicaBuscado;
    }

    public void agregarDenunciaEstado(DenunciaEstado denEstado) {
        oidDenunciaEstado.add(((DenunciaAgente)denEstado).getOid());
        implementacion.agregarDenunciaEstado(denEstado);
    }
}
