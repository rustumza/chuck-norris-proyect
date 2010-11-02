/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.ModelosTablas;

import DTO.DTOEquipamientoReservado;
import DTO.DTOReserva;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaReservaEquipamiento extends AbstractTableModel {

    private List<DTOEquipamientoReservado> listaEquipamiento;
    public static String[] columnName = {"Nombre Equipamiento", "Cantidad Reservada"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaEquipamiento(List<DTOEquipamientoReservado> nuevaLista) {
        if (listaEquipamiento == null) {
            listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        }
        listaEquipamiento = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (listaEquipamiento != null) {
            return listaEquipamiento.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaEquipamiento == null) {
            return null;
        }

        DTOEquipamientoReservado equipamiento = listaEquipamiento.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return equipamiento.getNombreEquipamiento();
            case 1:
                return equipamiento.getCantidad();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTOEquipamientoReservado nuevoEquipamiento) {
        if (listaEquipamiento == null) {
            listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        }
        listaEquipamiento.add(nuevoEquipamiento);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOEquipamientoReservado> nuevaLista) {
        if (listaEquipamiento == null) {
            listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        }
        this.listaEquipamiento.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaEquipamiento.get(rowIndex);
    }

    public void clear() {
        if (listaEquipamiento != null) {
            listaEquipamiento.clear();
            fireTableDataChanged();
        }

    }

    public void removeRow(int rowIndex) {
        listaEquipamiento.remove(rowIndex);
        fireTableDataChanged();
    }
}
