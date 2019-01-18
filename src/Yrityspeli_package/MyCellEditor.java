/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class MyCellEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = 1L;

    JTextField textField = new JTextField("");

    @Override
    public boolean isCellEditable(EventObject e) {
        if (super.isCellEditable(e)) {
            if (e instanceof MouseEvent) {
                MouseEvent me = (MouseEvent) e;
                return me.getClickCount() >= 1;
            }
            if (e instanceof KeyEvent) {
                KeyEvent ke = (KeyEvent) e;
                return ke.getKeyCode() == KeyEvent.VK_F2;
            }
        }
        return false;
    }

    @Override
    public Object getCellEditorValue() {
        return this.textField.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.textField.setFont(table.getFont());
        this.textField.setText(value.toString());
        return this.textField;
    }
   
}