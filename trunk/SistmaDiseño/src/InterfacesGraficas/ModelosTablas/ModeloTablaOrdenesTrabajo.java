/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.ModelosTablas;

import DTO.DTOOrden;
import Utilidades.FormateadorFechas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaOrdenesTrabajo extends AbstractTableModel {

    private List<DTOOrden> ordenesTrabajo;
    public static String[] columnName = {"Número Orden", "Tipo", "Fecha Inicio", "Fecha Fin", "Fecha inicio planificada", "Duración", "Equipo"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaOrdenes(List<DTOOrden> nuevaLista) {
        if (getOrdenesTrabajo() == null) {
            ordenesTrabajo = new ArrayList<DTOOrden>();
        }
        ordenesTrabajo = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (getOrdenesTrabajo() != null) {
            return getOrdenesTrabajo().size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (getOrdenesTrabajo() == null) {
            return null;
        }

        DTOOrden ordenTrabajo = getOrdenesTrabajo().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return ordenTrabajo.getNroOrden();
            case 1:
                return ordenTrabajo.getTipo();
            case 2:
                if (ordenTrabajo.getFechaInicioTrabajo() == null) {
                    return "";
                } else {
                    return FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(ordenTrabajo.getFechaInicioTrabajo());
                }
            case 3:
                return FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(ordenTrabajo.getFechaFinTrabajo());
            case 4:
                return FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(ordenTrabajo.getFechaInicioPlanificada());
            case 5:
                return ordenTrabajo.getDuracionPrevista();
            case 6:
                return ordenTrabajo.getNombreEquipo();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTOOrden nuevaOrden) {
        if (getOrdenesTrabajo() == null) {
            ordenesTrabajo = new ArrayList<DTOOrden>();
        }
        getOrdenesTrabajo().add(nuevaOrden);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOOrden> nuevaLista) {
        if (getOrdenesTrabajo() == null) {
            ordenesTrabajo = new ArrayList<DTOOrden>();
        }
        this.getOrdenesTrabajo().addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return getOrdenesTrabajo().get(rowIndex);
    }

    public void clear() {
        getOrdenesTrabajo().clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        getOrdenesTrabajo().remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * @return the ordenesTrabajo
     */
    public List<DTOOrden> getOrdenesTrabajo() {
        return ordenesTrabajo;
    }
}
