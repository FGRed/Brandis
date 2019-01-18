/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Niko
 */
public class CustomComboBoxEditor extends DefaultCellEditor {
    public ArrayList<Integer> Palkat = new ArrayList();
    // Declare a model that is used for adding the elements to the `Combo box`
  public static DefaultComboBoxModel modely = null;

  public CustomComboBoxEditor(ArrayList List) {
      super(new JComboBox());
      this.Palkat = List;
      this.modely = (DefaultComboBoxModel)((JComboBox)getComponent()).getModel();
      System.out.println(Palkat);
      
              }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
      // Add the elements which you want to the model.
      
      
      modely.removeAllElements();
      
      
      // Here I am adding elements from the orderList(say) which you can pass via constructor to this class.
      for (int i = 0; i < Palkat.size(); i++) {
          modely.addElement(Palkat.get(i));
      }
      
      
      
      

      //finally return the component.
      return super.getTableCellEditorComponent(table, value, isSelected, row, column);
  } 
}
