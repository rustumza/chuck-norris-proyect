/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.ModelosTablas;

import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Utilidades.FormateadorFechas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class ModeloTablaOrdenesTrabajo extends AbstractTableModel {

    private List<OrdenTrabajo> ordenesTrabajo;
    public static String[] columnName = {"Código", "Tipo", "Fecha Inicio", "Fecha Fin", "Duración", "Equipo"};
    private boolean editable = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public void setCellEditable(boolean edit) {
        editable = edit;
    }

    public void setListaOrdenes(List<OrdenTrabajo> nuevaLista) {
        if (ordenesTrabajo == null) {
            ordenesTrabajo = new ArrayList<OrdenTrabajo>();
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

        OrdenTrabajo ordenTrabajo = ordenesTrabajo.get(rowIndex);

        switch (columnIndex) {
            case 0:
                if (ordenTrabajo.getClass().getSimpleName().equals("OrdenDeMantenimientoImplementacion")) {
                    return String.valueOf(((OrdenDeMantenimiento) ordenTrabajo).getcodigoordenmantenimiento());
                } else if (ordenTrabajo.getClass().getSimpleName().equals("OrdenDeReparacionImplementacion")) {
                    return String.valueOf(((OrdenDeReparacion) ordenTrabajo).getcodigoordenreparacion());
                }
            case 1:
                return ordenTrabajo.gettipoordentrabajo();
            case 2:
                return FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(ordenTrabajo.getfechainiciotrabajo());
            case 3:
                return FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(ordenTrabajo.getfechafintrabajo());
            case 4:
                return String.valueOf(ordenTrabajo.getduracionprevistatrabajo());
            case 5:
                return ordenTrabajo.getEquipoDeTrabajo().getnombreEquipo();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(OrdenTrabajo nuevaOrden) {
        if(ordenesTrabajo==null)
            ordenesTrabajo = new ArrayList<OrdenTrabajo>();
        ordenesTrabajo.add(nuevaOrden);
        fireTableDataChanged();
    }

    public void addAllRow(List<OrdenTrabajo> nuevaLista) {
        if (ordenesTrabajo == null) {
            ordenesTrabajo = new ArrayList<OrdenTrabajo>();
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
