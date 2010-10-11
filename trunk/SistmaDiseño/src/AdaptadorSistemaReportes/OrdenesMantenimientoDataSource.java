/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadorSistemaReportes;

import DTO.DTOOrden;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author diego
 */
public class OrdenesMantenimientoDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DTOOrden> listaOrdenes;
    private FallasTecnicasDataSource fallasDataSource;
    private EquipamientoDataSource equipamientoDataSource;
    private RepuestoDataSource repuestoDataSource;

    public OrdenesMantenimientoDataSource() {
    }

    public OrdenesMantenimientoDataSource(List<DTOOrden> nuevaListaDtoOrdenes) {
        listaOrdenes = new ArrayList<DTOOrden>();
        listaOrdenes.addAll(listaOrdenes);
        fallasDataSource = new FallasTecnicasDataSource();
    }

    public void addOrden(DTOOrden nuevaoden) {
        if (listaOrdenes == null) {
            listaOrdenes = new ArrayList<DTOOrden>();
        }
        listaOrdenes.add(nuevaoden);
    }

    public void addAllOrden(List<DTOOrden> nuevaLista) {
        if (listaOrdenes == null) {
            listaOrdenes = new ArrayList<DTOOrden>();
        }
        listaOrdenes.addAll(nuevaLista);
    }

    public boolean next() throws JRException {
        ++indicadorOrdenActual;
        if (indicadorOrdenActual < listaOrdenes.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("nroOrden")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getNroOrden();
        } else if (jrf.getName().equals("fecha")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getFechaInicioPlanificada().toString();
        } else if (jrf.getName().equals("equipo")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getNombreEquipo();
        } else if (jrf.getName().equals("calle1")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getUbicacion().getCalle1();
        } else if (jrf.getName().equals("calle2")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getUbicacion().getCalle2();
        } else if (jrf.getName().equals("nroSerieSemaforo")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getListaSemaforos().get(0).getNumeroSerie();
        } else if (jrf.getName().equals("modeloSemaforo")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getListaSemaforos().get(0).getModelo();
        } else if (jrf.getName().equals("equipamientos")) {
            equipamientoDataSource = new EquipamientoDataSource(listaOrdenes.get(indicadorOrdenActual).getListaReservas().get(0).getListaEquipamiento());
            valor = equipamientoDataSource;
        } else if (jrf.getName().equals("repuestos")) {
            repuestoDataSource = new RepuestoDataSource(listaOrdenes.get(indicadorOrdenActual).getListaReservas().get(0).getListaRepuesto());
            valor = repuestoDataSource;
        }

        return valor;
    }

    /**
     * @return the fallasDataSource
     */
    public FallasTecnicasDataSource getFallasDataSource() {
        return fallasDataSource;
    }

    /**
     * @param fallasDataSource the fallasDataSource to set
     */
    public void setFallasDataSource(FallasTecnicasDataSource fallasDataSource) {
        this.fallasDataSource = fallasDataSource;
    }

    public boolean isVacio() {
        return (listaOrdenes == null) ? true : false;
    }
}
