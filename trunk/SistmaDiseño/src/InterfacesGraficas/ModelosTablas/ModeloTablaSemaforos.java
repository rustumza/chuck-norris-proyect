
package InterfacesGraficas.ModelosTablas;


import Persistencia.Entidades.Semaforo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaSemaforos extends AbstractTableModel {

    private List<Semaforo> listaDeSemaforos;
    public static String[] columnName = {"Código Semaforo", "Esquina", "Orientación", "Tipo", "Modelo"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaOrdenes(List<Semaforo> nuevaLista) {
        if (listaDeSemaforos == null) {
            listaDeSemaforos = new ArrayList<Semaforo>();
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

        Semaforo semaforo = listaDeSemaforos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return semaforo.getnumeroSerie();
            case 1:
                return semaforo.getEsquina().getdescripcion();
            case 2:
                return semaforo.getOrientacion().getdescripcion();
            case 3:
                return semaforo.getTipoSemaforo().getdescripciontiposemaforo();
            case 4:
                return semaforo.getModelo().getnombremodelo();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(Semaforo nuevoSemaforo) {
        if(listaDeSemaforos==null)
            listaDeSemaforos = new ArrayList<Semaforo>();
        listaDeSemaforos.add(nuevoSemaforo);
        fireTableDataChanged();
    }

    public void addAllRow(List<Semaforo> nuevaLista) {
        if (listaDeSemaforos == null) {
            listaDeSemaforos = new ArrayList<Semaforo>();
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
