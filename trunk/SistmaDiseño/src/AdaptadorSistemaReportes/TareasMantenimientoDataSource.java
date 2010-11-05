/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadorSistemaReportes;

import DTO.DTOTareaFichaMantenimiento;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author diego
 */
public class TareasMantenimientoDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DTOTareaFichaMantenimiento> listaTareas;

    public TareasMantenimientoDataSource() {
    }

    public TareasMantenimientoDataSource(List<DTOTareaFichaMantenimiento> nuevaListaTareas) {
        if (listaTareas == null) {
            listaTareas = new ArrayList<DTOTareaFichaMantenimiento>();
        }
        listaTareas.addAll(nuevaListaTareas);
    }

    public void addTarea(DTOTareaFichaMantenimiento nuevaTarea) {
        if (listaTareas == null) {
            listaTareas = new ArrayList<DTOTareaFichaMantenimiento>();
        }
        listaTareas.add(nuevaTarea);
    }

    public void addAllTareas(List<DTOTareaFichaMantenimiento> nuevaLista) {
        if (listaTareas == null) {
            listaTareas = new ArrayList<DTOTareaFichaMantenimiento>();
        }
        listaTareas.addAll(nuevaLista);
    }

    public boolean next() throws JRException {
        ++indicadorOrdenActual;
        if (indicadorOrdenActual < listaTareas.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("codigo")) {
            valor = listaTareas.get(indicadorOrdenActual).getCodigoTarea();
        } else if (jrf.getName().equals("descripcionTarea")) {
            valor = listaTareas.get(indicadorOrdenActual).getDescripcion();
        }
        return valor;
    }
}
