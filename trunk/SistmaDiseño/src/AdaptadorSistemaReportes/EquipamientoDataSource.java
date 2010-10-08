/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AdaptadorSistemaReportes;

import DTO.DTOEquipamientoReservado;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author diego
 */
public class EquipamientoDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DTOEquipamientoReservado> listaEquipamiento;

    public EquipamientoDataSource() {
    }

    public EquipamientoDataSource(List<DTOEquipamientoReservado> nuevaListaDtoEquipamiento) {
        listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        listaEquipamiento.addAll(nuevaListaDtoEquipamiento);
    }

    public void addEquipamiento(DTOEquipamientoReservado nuevoEquipamiento) {
        if (listaEquipamiento == null) {
            listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        }
        listaEquipamiento.add(nuevoEquipamiento);
    }

    public void addAllEquipamiento(List<DTOEquipamientoReservado> nuevaLista) {
        if (listaEquipamiento == null) {
            listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        }
        listaEquipamiento.addAll(nuevaLista);
    }

    public boolean next() throws JRException {
        ++indicadorOrdenActual;
        if (indicadorOrdenActual < listaEquipamiento.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("cantidad")) {
            valor = String.valueOf(listaEquipamiento.get(indicadorOrdenActual).getCantidad());
        } else if (jrf.getName().equals("nombreEquipamiento")) {
            valor = listaEquipamiento.get(indicadorOrdenActual).getNombreEquipamiento();
        }
        return valor;
    }
}


