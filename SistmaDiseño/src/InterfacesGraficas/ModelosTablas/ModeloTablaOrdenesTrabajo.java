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
    public static String[] columnName = {"Número Orden", "Tipo", "Fecha Inicio", "Fecha Fin", "Fecha inicio planificada","Duración", "Equipo"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaOrdenes(List<DTOOrden> nuevaLista) {
        if (ordenesTrabajo == null) {
            ordenesTrabajo = new ArrayList<DTOOrden>();
        }
        ordenesTrabajo = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        if (ordenesTrabajo != null) {
            return ordenesTrabajo.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (ordenesTrabajo == null) {
            return null;
        }

        DTOOrden ordenTrabajo = ordenesTrabajo.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return ordenTrabajo.getNroOrden();
            case 1:
                return ordenTrabajo.getTipo();
            case 2:
                return FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(ordenTrabajo.getFechaInicioTrabajo());
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
        if(ordenesTrabajo==null)
            ordenesTrabajo = new ArrayList<DTOOrden>();
        ordenesTrabajo.add(nuevaOrden);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTOOrden> nuevaLista) {
        if (ordenesTrabajo == null) {
            ordenesTrabajo = new ArrayList<DTOOrden>();
        }
        this.ordenesTrabajo.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return ordenesTrabajo.get(rowIndex);
    }

    public void clear() {
        ordenesTrabajo.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        ordenesTrabajo.remove(rowIndex);
        fireTableDataChanged();
    }
}
