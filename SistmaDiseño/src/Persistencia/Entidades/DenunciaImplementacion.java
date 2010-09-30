package Persistencia.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:12 p.m.
 */
public class DenunciaImplementacion extends CasoImplementacion implements Denuncia{

    private int codigoDenuncia;
    private float prioridad;
    private List<Reclamo> reclamo;
    private List<DenunciaEstado> listaDenunciaEstado;
    private List<FallaTecnica> fallasTecnica;


    

    public DenunciaImplementacion() {
    }

    public int getcodigoDenuncia() {
        return codigoDenuncia;
    }

    public float getprioridad() {
        return prioridad;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoDenuncia(int newVal) {
        codigoDenuncia = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setprioridad(float newVal) {
        prioridad = newVal;
    }

    /**
     * @return the reclamo
     */
    public List<Reclamo> getReclamo() {
        return reclamo;
    }

    /**
     * @param reclamo the reclamo to set
     */
    public void setReclamo(List<Reclamo> reclamo) {
        this.reclamo = reclamo;
    }

    /**
     * @return the denunciaEstado
     */
    public List<DenunciaEstado> getDenunciaEstado() {
        return listaDenunciaEstado;
    }

    public void addDenunciaEstado(DenunciaEstado nuevoEstado){
        if(listaDenunciaEstado == null){
            listaDenunciaEstado = new ArrayList<DenunciaEstado>();
        }
        listaDenunciaEstado.add(nuevoEstado);
    }

    /**
     * @param denunciaEstado the denunciaEstado to set
     */
    public void setDenunciaEstado(List<DenunciaEstado> denunciaEstado) {
        this.listaDenunciaEstado = denunciaEstado;
    }

    /**
     * @return the fallaTecnica
     */
    public List<FallaTecnica> getFallasTecnica() {
        return fallasTecnica;
    }

    /**
     * @param fallaTecnica the fallaTecnica to set
     */
    public void setFallasTecnica(List<FallaTecnica> fallaTecnica) {
        this.fallasTecnica = fallaTecnica;
    }

    public void addFallaTecnica(FallaTecnica nuevaFalla){
        fallasTecnica.add(nuevaFalla);
    }

    public void agregarDenunciaEstado(DenunciaEstado denEstado) {
        listaDenunciaEstado.add(denEstado);
    }
}
