/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Persistencia.Entidades.ObjetoPersistente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 * DTO para contener datos de la denuncia, sus estados, fallas y orden de reparacion
 * su uso es para construir tablas
 */
public class DTOCaso extends ObjetoPersistente {

    private List<DTOEstadoDenuncia> listaEstados = new ArrayList<DTOEstadoDenuncia>();
    private List<DTOOrden> ordenesReparacion;
    private List<DTOFallaTecnica> listaFallas = new ArrayList<DTOFallaTecnica>();
    private List<DTOSemaforo> semaforosDenunciados;
    private DTOUbicacion ubicacion;
    private String nombreOperador;
    private String fechaCaso;
    private String nroCaso;
    private int cantidadReclamos = 0;
    private List<String> problemasDenunciados;

    /**
     * @return the listaFallas
     */
    public List<DTOFallaTecnica> getListaFallas() {
        return listaFallas;
    }

    /**
     * @param nuevalistaFallas the listaFallas to set
     */
    public void setListaFallas(List<DTOFallaTecnica> nuevalistaFallas) {
        if (listaFallas == null) {
            listaFallas = new ArrayList<DTOFallaTecnica>();
        }
        listaFallas.addAll(nuevalistaFallas);
    }

    public void addFalla(DTOFallaTecnica nuevaFalla) {
        listaFallas.add(nuevaFalla);
    }

    /**
     * @return the listaEstados
     */
    public List<DTOEstadoDenuncia> getListaEstados() {
        return listaEstados;
    }

    /**
     * @param listaEstados the listaEstados to set
     */
    public void setListaEstados(List<DTOEstadoDenuncia> nuevalistaEstados) {
        if (listaEstados == null) {
            listaEstados = new ArrayList<DTOEstadoDenuncia>();
        }
        listaEstados.addAll(nuevalistaEstados);
    }

    /**
     * @return the ordenRep
     */
    public List<DTOOrden> getOrdenesRep() {
        return ordenesReparacion;
    }

    /**
     * @param ordenRep the ordenRep to set
     */
    public void setOrdenRep(List<DTOOrden> ordenRep) {
        this.ordenesReparacion = ordenRep;
    }

    public void addOrden(DTOOrden nuevaOrden) {
        if (ordenesReparacion == null) {
            ordenesReparacion = new ArrayList<DTOOrden>();
        }
        ordenesReparacion.add(nuevaOrden);
    }

    /**
     * @return the nombreOperador
     */
    public String getNombreOperador() {
        return nombreOperador;
    }

    /**
     * @param nombreOperador the nombreOperador to set
     */
    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    /**
     * @return the fechaCaso
     */
    public String getFechaCaso() {
        return fechaCaso;
    }

    /**
     * @param fechaCaso the fechaCaso to set
     */
    public void setFechaCaso(String fechaCaso) {
        this.fechaCaso = fechaCaso;
    }

    /**
     * @return the nroCaso
     */
    public String getNroCaso() {
        return nroCaso;
    }

    /**
     * @param nroCaso the nroCaso to set
     */
    public void setNroCaso(String nroCaso) {
        this.nroCaso = nroCaso;
    }

    public void addEstado(DTOEstadoDenuncia nuevoEstado) {
        listaEstados.add(nuevoEstado);
    }

    /**
     * @return the cantidadReclamos
     */
    public int getCantidadReclamos() {
        return cantidadReclamos;
    }

    /**
     * @param cantidadReclamos the cantidadReclamos to set
     */
    public void setCantidadReclamos(int cantidadReclamos) {
        this.cantidadReclamos = cantidadReclamos;
    }

    public boolean seEncuentraFalla(String codigoFalla) {
        boolean resultado = false;
        for (DTOFallaTecnica dtoFalla : listaFallas) {
            if (dtoFalla.getCodigoFalla().equals(codigoFalla)) {
                resultado = true;
            }
        }

        return resultado;
    }

    public DTOUbicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(DTOUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<DTOSemaforo> getSemaforosDenunciados() {
        return semaforosDenunciados;
    }

    public void addSemaforo(DTOSemaforo nuevoSemaforo) {
        if (semaforosDenunciados == null) {
            semaforosDenunciados = new ArrayList<DTOSemaforo>();
        }
        semaforosDenunciados.add(nuevoSemaforo);
    }

    public boolean estaSemaforo(String numeroSerie) {
        boolean resultado = false;
        if (semaforosDenunciados != null) {
            for (DTOSemaforo dTOSemaforo : semaforosDenunciados) {
                if (dTOSemaforo.getNumeroSerie().equals(numeroSerie)) {
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;
    }

    public List<String> getProblemasDenunciados() {
        return problemasDenunciados;
    }

    public void addProblema(String nuevoProblema) {
        if (problemasDenunciados == null) {
            problemasDenunciados = new ArrayList<String>();
        }
        problemasDenunciados.add(nuevoProblema);
    }

    public boolean estaProblema(String problema) {
        boolean resultado = false;
        if (problemasDenunciados != null) {
            for (String prob : problemasDenunciados) {
                if (prob.equals(problema)) {
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;
    }
}
