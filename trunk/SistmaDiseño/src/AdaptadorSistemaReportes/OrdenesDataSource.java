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
 * Contiene la informacion que se pasa cuando se genera un nuevo reporte
 */
public class OrdenesDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DTOOrden> listaOrdenes;

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
        return ++indicadorOrdenActual < listaOrdenes.size();
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("nroOrden")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getNroOrden();
        } else if (jrf.getName().equals("fecha")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getFechaInicioPlanificada().toString();
        } else if (jrf.getName().equals("equipo")) {
            valor = listaOrdenes.get(indicadorOrdenActual).getNombreEquipo();
        }

        return valor;
    }
}
