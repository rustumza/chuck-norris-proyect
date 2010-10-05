/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.ModelosTablas;

import DTO.DTOFallaTecnica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaFallas extends AbstractTableModel {

    private List<DTOFallaTecnica> fallasTecnicas;
    public static String[] columnName = {"Nombre Falla", "Descripción"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaFallas(List<DTOFallaTecnica> nuevaLista) {
        if (fallasTecnicas == null) {
            fallasTecnicas = new ArrayList<DTOFallaTecnica>();
        }
        fallasTecnicas = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (fallasTecnicas != null) {
            return fallasTecnicas.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (fallasTecnicas == null) {
            return null;
        }

        DTOFallaTecnica fallaTecnica = fallasTecnicas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return fallaTecnica.getNombreFalla();
            case 1:
                return fallaTecnica.getDescripcion();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTOFallaTecnica nuevaFalla) {
        if (fallasTecnicas == null) {
            fallasTecnicas = new ArrayList<DTOFallaTecnica>();
        }
        fallasTecnicas.add(nuevaFalla);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOFallaTecnica> nuevaLista) {
        if ( fallasTecnicas == null) {
            fallasTecnicas = new ArrayList<DTOFallaTecnica>();
        }
        fallasTecnicas.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return fallasTecnicas.get(rowIndex);
    }

    public void clear() {
        fallasTecnicas.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        fallasTecnicas.remove(rowIndex);
        fireTableDataChanged();
    }

}
