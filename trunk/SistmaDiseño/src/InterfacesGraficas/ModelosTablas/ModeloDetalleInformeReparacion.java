/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.ModelosTablas;

import DTO.DTODetalleInformeReparacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloDetalleInformeReparacion extends AbstractTableModel {

    private List<DTODetalleInformeReparacion> listaDetalles;
    public static String[] columnName = {"Falla", "Estado Falla", "Comentario"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaDetalles(List<DTODetalleInformeReparacion> nuevaLista) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DTODetalleInformeReparacion>();
        }
        listaDetalles = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (listaDetalles != null) {
            return listaDetalles.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaDetalles == null) {
            return null;
        }

        DTODetalleInformeReparacion detalle = listaDetalles.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return detalle.getFalla();
            case 1:
                return detalle.getEstadoFalla();
            case 2:
                return detalle.getComentario();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTODetalleInformeReparacion nuevoDetalle) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DTODetalleInformeReparacion>();
        }
        listaDetalles.add(nuevoDetalle);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTODetalleInformeReparacion> nuevaLista) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DTODetalleInformeReparacion>();
        }
        listaDetalles.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaDetalles.get(rowIndex);
    }

    public void clear() {
        if (listaDetalles == null) {
            return;
        }
        listaDetalles.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        listaDetalles.remove(rowIndex);
        fireTableDataChanged();
    }
}
