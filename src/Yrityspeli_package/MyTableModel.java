/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Niko
 */public class MyTableModel extends AbstractTableModel {

     public boolean isCellEditable(int row, int col) {
        if (col== 2) { //columnIndex: the column you want to make it editable
            return true;
        } else {
            return false;
        }
    }

					@Override
					public int getRowCount() {
										throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
					}

					@Override
					public int getColumnCount() {
										throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
					}

					@Override
					public Object getValueAt(int rowIndex, int columnIndex) {
										throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
					}
}
