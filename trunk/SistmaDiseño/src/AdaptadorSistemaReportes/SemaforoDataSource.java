/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AdaptadorSistemaReportes;

import DTO.DTOSemaforo;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author diego
 */
public class SemaforoDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DTOSemaforo> listaSemaforos;

    public SemaforoDataSource() {
    }

    public SemaforoDataSource(List<DTOSemaforo> nuevaListaDtoSemaforos) {
        listaSemaforos = new ArrayList<DTOSemaforo>();
        listaSemaforos.addAll(nuevaListaDtoSemaforos);
    }

    public void addSemaforo(DTOSemaforo nuevoSemaforo) {
        if (listaSemaforos == null) {
            listaSemaforos = new ArrayList<DTOSemaforo>();
        }
        listaSemaforos.add(nuevoSemaforo);
    }

    public void addAllSemaforos(List<DTOSemaforo> nuevaLista) {
        if (listaSemaforos == null) {
            listaSemaforos = new ArrayList<DTOSemaforo>();
        }
        listaSemaforos.addAll(nuevaLista);
    }

    public boolean next() throws JRException {
        ++indicadorOrdenActual;
        if (indicadorOrdenActual < listaSemaforos.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("numSerie")) {
            valor = listaSemaforos.get(indicadorOrdenActual).getNumeroSerie();
        } else if (jrf.getName().equals("modelo")) {
            valor = listaSemaforos.get(indicadorOrdenActual).getModelo();
        }
        return valor;
    }
}

