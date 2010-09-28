/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.ModelosTablas;

import DTO.DTORepuestoReservado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaResevaRepuesto  extends AbstractTableModel {

    private List<DTORepuestoReservado> listaRepuesto;
    public static String[] columnName = {"Nombre Repuesto", "Cantidad Reservada"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaRepuestos(List<DTORepuestoReservado> nuevaLista) {
        if (listaRepuesto == null) {
            listaRepuesto = new ArrayList<DTORepuestoReservado>();
        }
        listaRepuesto = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (listaRepuesto != null) {
            return listaRepuesto.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaRepuesto == null) {
            return null;
        }

        DTORepuestoReservado repuesto = listaRepuesto.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return repuesto.getNombre();
            case 1:
                return repuesto.getCantidad();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTORepuestoReservado nuevoRepuesto) {
        if(listaRepuesto==null)
            listaRepuesto = new ArrayList<DTORepuestoReservado>();
        listaRepuesto.add(nuevoRepuesto);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTORepuestoReservado> nuevaLista) {
        if (listaRepuesto == null) {
            listaRepuesto = new ArrayList<DTORepuestoReservado>();
        }
        this.listaRepuesto.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaRepuesto.get(rowIndex);
    }

    public void clear() {
        listaRepuesto.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        listaRepuesto.remove(rowIndex);
        fireTableDataChanged();
    }
}

