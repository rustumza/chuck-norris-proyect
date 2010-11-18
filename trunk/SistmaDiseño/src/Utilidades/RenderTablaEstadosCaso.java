/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author diego
 */
public class RenderTablaEstadosCaso implements TableCellRenderer{

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);

        if(isSelected){
            etiqueta.setBackground(new Color(78, 78, 78));
            etiqueta.setForeground(Color.WHITE);
        }else{
            etiqueta.setBackground(Color.WHITE);
            etiqueta.setForeground(Color.BLACK);
        }

        if(value instanceof String && value != null){
            etiqueta.setText((String)value);
        }

        //comportamiento si el campo es igual a pendiente
        if(value.toString().equalsIgnoreCase("Activo")){
            etiqueta.setForeground(Color.WHITE);
            etiqueta.setBackground(new Color(43,152,1));
        }


        return etiqueta;
    }

}
