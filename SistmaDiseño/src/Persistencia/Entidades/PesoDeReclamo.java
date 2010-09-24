
package Persistencia.Entidades;

import java.util.Date;

/**
 *
 * @author diego
 */
public interface PesoDeReclamo extends SuperDruperInterfaz {

    public int getcantidadReclamosDesde();

    public int getcantidadReclamosHasta();

    public Date getfechaDesde();

    public Date getfechaHasta();

    public int getpeso();

    public void setcantidadReclamosDesde(int newVal);

    public void setcantidadReclamosHasta(int newVal);

    public void setfechaDesde(Date newVal);

    public void setfechaHasta(Date newVal);

    public void setpeso(int newVal);
}
