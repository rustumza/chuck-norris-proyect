/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AdaptadorSistemaReportes;

import DTO.DTORepuestoReservado;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author diego
 */
public class RepuestoDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DTORepuestoReservado> listaRepuestos;

    public RepuestoDataSource() {
    }

    public RepuestoDataSource(List<DTORepuestoReservado> nuevaListaRepuestos) {
        listaRepuestos = new ArrayList<DTORepuestoReservado>();
        listaRepuestos.addAll(nuevaListaRepuestos);
    }

    public void addRepuesto(DTORepuestoReservado nuevoRepuesto) {
        if (listaRepuestos == null) {
            listaRepuestos = new ArrayList<DTORepuestoReservado>();
        }
        listaRepuestos.add(nuevoRepuesto);
    }

    public void addAllRepuestos(List<DTORepuestoReservado> nuevaLista) {
        if (listaRepuestos == null) {
            listaRepuestos = new ArrayList<DTORepuestoReservado>();
        }
        listaRepuestos.addAll(nuevaLista);
    }

    public boolean next() throws JRException {
        ++indicadorOrdenActual;
        if (indicadorOrdenActual < listaRepuestos.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("cantidad")) {
            valor = String.valueOf(listaRepuestos.get(indicadorOrdenActual).getCantidad());
        } else if (jrf.getName().equals("nombreRepuesto")) {
            valor = listaRepuestos.get(indicadorOrdenActual).getNombre();
        }
        return valor;
    }
}


