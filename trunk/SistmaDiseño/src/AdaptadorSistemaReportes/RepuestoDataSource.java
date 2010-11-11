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
    private int cantFilas = 0;

    public RepuestoDataSource() {
    }

    public RepuestoDataSource(List<DTORepuestoReservado> nuevaListaRepuestos) {
        listaRepuestos = new ArrayList<DTORepuestoReservado>();
        listaRepuestos.addAll(nuevaListaRepuestos);
        cantFilas = nuevaListaRepuestos.size();
    }

    public void addRepuesto(DTORepuestoReservado nuevoRepuesto) {
        if (listaRepuestos == null) {
            listaRepuestos = new ArrayList<DTORepuestoReservado>();
        }
        listaRepuestos.add(nuevoRepuesto);
        cantFilas++;
    }

    public void addAllRepuestos(List<DTORepuestoReservado> nuevaLista) {
        if (listaRepuestos == null) {
            listaRepuestos = new ArrayList<DTORepuestoReservado>();
        }
        listaRepuestos.addAll(nuevaLista);
        cantFilas = cantFilas + nuevaLista.size();
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
        }else if (jrf.getName().equals("nroLinea")) {
            if(indicadorOrdenActual < cantFilas){
                valor = indicadorOrdenActual+1;
            }
        }
        return valor;
    }
}


