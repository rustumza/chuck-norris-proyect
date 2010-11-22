/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.ModelosTablas;

import DTO.DTOSemaforo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaSemaforosDenunciadosDTO extends AbstractTableModel {

    private List<DTOSemaforo> listaDeSemaforos;
    public static String[] columnName = {"Código Semaforo", "Esquina", "Orientación", "Tipo", "Modelo"};
    private boolean editable = false;

    public ModeloTablaSemaforosDenunciadosDTO() {
        listaDeSemaforos = new ArrayList<DTOSemaforo>();
    }




    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaOrdenes(List<DTOSemaforo> nuevaLista) {
        if (listaDeSemaforos == null) {
            listaDeSemaforos = new ArrayList<DTOSemaforo>();
        }
        listaDeSemaforos = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (listaDeSemaforos != null) {
            return listaDeSemaforos.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaDeSemaforos == null) {
            return null;
        }

        DTOSemaforo semaforo = listaDeSemaforos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return semaforo.getNumeroSerie();
            case 1:
                return semaforo.getEsquina();
            case 2:
                return semaforo.getOrientacion();
            case 3:
                return semaforo.getTipo();
            case 4:
                return semaforo.getModelo();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTOSemaforo nuevoSemaforo) {
        if(listaDeSemaforos==null)
            listaDeSemaforos = new ArrayList<DTOSemaforo>();
        listaDeSemaforos.add(nuevoSemaforo);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOSemaforo> nuevaLista) {
        if (listaDeSemaforos == null) {
            listaDeSemaforos = new ArrayList<DTOSemaforo>();
        }
        this.listaDeSemaforos.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaDeSemaforos.get(rowIndex);
    }

    public void clear() {
        listaDeSemaforos.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        listaDeSemaforos.remove(rowIndex);
        fireTableDataChanged();
    }
}
