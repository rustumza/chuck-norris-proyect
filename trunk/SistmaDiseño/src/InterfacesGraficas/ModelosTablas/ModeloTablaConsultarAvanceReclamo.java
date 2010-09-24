/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.ModelosTablas;

import DTO.DTOEstadoDenuncia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LEIVA
 */
public class ModeloTablaConsultarAvanceReclamo extends AbstractTableModel{
    private List<DTOEstadoDenuncia> listaEstadosDenuncia;
    public static String[] columnName = {"Estado", "Fecha"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaEstadosDenuncia(List<DTOEstadoDenuncia> nuevaLista) {
        if (listaEstadosDenuncia == null) {
            listaEstadosDenuncia = new ArrayList<DTOEstadoDenuncia>();
        }
        listaEstadosDenuncia = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (listaEstadosDenuncia != null) {
            return listaEstadosDenuncia.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaEstadosDenuncia == null) {
            return null;
        }

        DTOEstadoDenuncia estado = listaEstadosDenuncia.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return estado.getNombreestado();
            case 1:
                return estado.getFecha();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTOEstadoDenuncia nuevoDTOEstado) {
        if(listaEstadosDenuncia==null)
            listaEstadosDenuncia = new ArrayList<DTOEstadoDenuncia>();
        listaEstadosDenuncia.add(nuevoDTOEstado);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOEstadoDenuncia> nuevaLista) {
        if (listaEstadosDenuncia == null) {
            listaEstadosDenuncia = new ArrayList<DTOEstadoDenuncia>();
        }
        this.listaEstadosDenuncia.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaEstadosDenuncia.get(rowIndex);
    }

    public void clear() {
        listaEstadosDenuncia.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        listaEstadosDenuncia.remove(rowIndex);
        fireTableDataChanged();
    }
}
