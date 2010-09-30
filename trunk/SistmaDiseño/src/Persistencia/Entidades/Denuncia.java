/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.List;

/**
 *
 * @author diego
 */
public interface Denuncia extends Caso {

    

    public int getcodigoDenuncia();

    public float getprioridad();

    public void setcodigoDenuncia(int newVal);

    public void setprioridad(float newVal);

    public List<Reclamo> getReclamo();

    public void setReclamo(List<Reclamo> reclamo);

    public List<DenunciaEstado> getDenunciaEstado();

    public void setDenunciaEstado(List<DenunciaEstado> denunciaEstado);

    public List<FallaTecnica> getFallasTecnica();

    public void setFallasTecnica(List<FallaTecnica> fallaTecnica);

    public void agregarDenunciaEstado(DenunciaEstado denEstado);
}
