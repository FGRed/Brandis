/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Niko
 */
public class Opastus extends javax.swing.JFrame {

    /**
     * Creates new form Opastus
     */
    private int nappiapainettu = 0;
    private int opastusnm = 0;
    j3_Paaikkuna j;
		Opastus ji;		
    public Opastus() {
        initComponents();
    }

    Opastus(j3_Paaikkuna aThis) {
        initComponents();
        j=aThis;
				this.ji = this;				
				 jScrollPane1.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
					this.getContentPane().setBackground(Color.WHITE);
					this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jScrollPane1 = new javax.swing.JScrollPane();
          VAIHTUVALB = new javax.swing.JTextArea();
          SEURAAVABTN = new javax.swing.JButton();
          LOPETA = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setUndecorated(true);
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel1.setBackground(new java.awt.Color(255, 255, 255));
          jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          VAIHTUVALB.setEditable(false);
          VAIHTUVALB.setColumns(20);
          VAIHTUVALB.setRows(5);
          VAIHTUVALB.setText("Palkkaa ensimmäiseksi myyjä");
          VAIHTUVALB.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
          VAIHTUVALB.setDisabledTextColor(new java.awt.Color(255, 255, 255));
          VAIHTUVALB.setFocusable(false);
          VAIHTUVALB.setOpaque(false);
          jScrollPane1.setViewportView(VAIHTUVALB);

          jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 120));

          SEURAAVABTN.setText("Seuraava");
          SEURAAVABTN.setEnabled(false);
          SEURAAVABTN.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SEURAAVABTNActionPerformed(evt);
               }
          });
          jPanel1.add(SEURAAVABTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

          LOPETA.setText("Lopeta ohjeistus");
          LOPETA.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LOPETAActionPerformed(evt);
               }
          });
          jPanel1.add(LOPETA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 284, 160));

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void SEURAAVABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEURAAVABTNActionPerformed
        // TODO add your handling code here:
        nappiapainettu++;
        ensimmainen(opastusnm);
    }//GEN-LAST:event_SEURAAVABTNActionPerformed

     private void LOPETAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOPETAActionPerformed
          // TODO add your handling code here:
					 j.Opastusframe(10);
					 this.dispose();
     }//GEN-LAST:event_LOPETAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Opastus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opastus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opastus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opastus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opastus().setVisible(true);
            }
        });
    }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton LOPETA;
     private javax.swing.JButton SEURAAVABTN;
     private javax.swing.JTextArea VAIHTUVALB;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     // End of variables declaration//GEN-END:variables

    void ensimmainen(int aopastusnm) {
        opastusnm = aopastusnm;
        if(opastusnm == 2 && nappiapainettu == 0){
            VAIHTUVALB.setText("Tästä voit muokata tämän hetkisiä myyjiä.");
            SEURAAVABTN.setEnabled(true);
									
        }else if(opastusnm == 2 && nappiapainettu == 1){
						 j.Opastusframe(nappiapainettu);
            VAIHTUVALB.setText("Tästä voit muokata omaa palkkaasi.");
							j.setBorderOnwards(opastusnm);						
        }else if(opastusnm == 2 && nappiapainettu == 2){
						 j.Opastusframe(nappiapainettu);
            VAIHTUVALB.setText("Osta itsellesi jotain tuotteita.\nTehdasleipä myy yleensä alkuun 2700-3300 \nväliltä yhdellä myyjällä ja omistajalla\n2€ myyntihinnalla.");
            SEURAAVABTN.setEnabled(false);
								j.setBorderOnwards(3);				
        }else if(opastusnm == 3 && nappiapainettu == 2){
							VAIHTUVALB.setText("Tästä voit muokata ostettuja tuotteita.");
            SEURAAVABTN.setEnabled(true);
												j.setBorderOnwards(opastusnm);
				}else if(opastusnm == 3 && nappiapainettu == 3){
							VAIHTUVALB.setText("Osta itsellesi markkinointi.");
            SEURAAVABTN.setEnabled(false);
												j.setBorderOnwards(opastusnm);
							j.Opastusframe(nappiapainettu);
				}else if(opastusnm == 4 && nappiapainettu == 3){
							VAIHTUVALB.setText("Tästä voit muokata ostettuja markkinointeja.");
            SEURAAVABTN.setEnabled(true);
				}else if(opastusnm == 4 && nappiapainettu == 4){
							VAIHTUVALB.setText("Tästä pääset tapahtumat ikkunaan.");
							j.Opastusframe(nappiapainettu);
							SEURAAVABTN.setEnabled(false);
				}else if(opastusnm == 5 && nappiapainettu == 4){
							VAIHTUVALB.setText("Aloita seuraava kuukausi napista\nliikut ajassa kuukauden eteenpäin.");
				}else if(opastusnm == 6 && nappiapainettu == 4){
							VAIHTUVALB.setText("Opastus loppuu tähän,\npaina seuraava sammuttaaksesi ikkunan.");
							SEURAAVABTN.setEnabled(true);
				}else if(opastusnm == 6 && nappiapainettu == 5){
							this.dispose();
				}
    }
}