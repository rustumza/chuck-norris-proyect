/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.ModelosTablas;

import DTO.DTOReserva;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaReserva extends AbstractTableModel {

    private List<DTOReserva> listaReserva;
    public static String[] columnName = {"Número Reserva", "Fecha Reserva"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaReserva(List<DTOReserva> nuevaLista) {
        if (listaReserva == null) {
            listaReserva = new ArrayList<DTOReserva>();
        }
        listaReserva = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (listaReserva != null) {
            return listaReserva.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaReserva == null) {
            return null;
        }

        DTOReserva reserva = listaReserva.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return reserva.getNumeroReserva();
            case 1:
                return reserva.getFechaReserva();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTOReserva nuevaReserva) {
        if (listaReserva == null) {
            listaReserva = new ArrayList<DTOReserva>();
        }
        listaReserva.add(nuevaReserva);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOReserva> nuevaLista) {
        if (listaReserva == null) {
            listaReserva = new ArrayList<DTOReserva>();
        }
        this.listaReserva.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaReserva.get(rowIndex);
    }

    public void clear() {
        if (listaReserva != null) {
            listaReserva.clear();
            fireTableDataChanged();
        }
    }

    public void removeRow(int rowIndex) {
        listaReserva.remove(rowIndex);
        fireTableDataChanged();
    }
}
