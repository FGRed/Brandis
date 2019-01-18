/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import static Yrityspeli_package.j2a_Uusi_peli.jd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niko
 */
public class j4p_Pankki extends javax.swing.JFrame {
    public String YRNIMI = "";
    public j3_Paaikkuna ji;
    /**
     * Creates new form j4p_Pankki
     */
    public j4p_Pankki() {
        initComponents();
    }
    j4p_Pankki(String YRNIM,j3_Paaikkuna j){
        initComponents();
        YRNIMI = YRNIM;
        ji = j;
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
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lainabox = new javax.swing.JComboBox<>();
        OTALAINAABTN = new javax.swing.JButton();
        MAKSALAINAABTN = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(553, 538));

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel9.setText("Lainat:");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel5.setText("Maara");

        Lainabox.setEditable(true);
        Lainabox.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        Lainabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1000.00", "5000.00", "10000.00", "15000.00", "20000.00", "25000.00", "30000.00", "35000.00", "40000.00", "45000.00", "50000.00" }));
        Lainabox.setFocusable(false);
        Lainabox.setOpaque(false);
        Lainabox.setPreferredSize(new java.awt.Dimension(55, 25));

        OTALAINAABTN.setBackground(new java.awt.Color(76, 181, 255));
        OTALAINAABTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        OTALAINAABTN.setForeground(new java.awt.Color(255, 255, 255));
        OTALAINAABTN.setText("Lainaa");
        OTALAINAABTN.setToolTipText("Lainaa vasemmalla olevan määrän rahaa 10% korolla");
        OTALAINAABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTALAINAABTNActionPerformed(evt);
            }
        });

        MAKSALAINAABTN.setForeground(new java.awt.Color(255, 255, 255));
        MAKSALAINAABTN.setText("Maksa lainaa");
        MAKSALAINAABTN.setPreferredSize(new java.awt.Dimension(67, 25));
        MAKSALAINAABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAKSALAINAABTNActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel7.setText("Korko");

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel8.setText("10% per vuosi");

        jLabel1.setText("€");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lainabox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(OTALAINAABTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MAKSALAINAABTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(MAKSALAINAABTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lainabox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OTALAINAABTN)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MAKSALAINAABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSALAINAABTNActionPerformed

       
        try {
            double laina = 0.0;
            double kassa = 0.0;
            double maksu = Double.parseDouble(String.valueOf(Lainabox.getSelectedItem()));
            Connection con = jd.getConnection();
            Statement stm = con.createStatement();
            System.out.println(YRNIMI);
            ResultSet rs = stm.executeQuery("Select *from pelaajat where nimi = '"+YRNIMI+"'");
            while(rs.next()){
                laina = rs.getDouble("lainat");
                kassa = rs.getDouble("kassa");
            }
            con.close();
            
            if(maksu > laina){
                maksu = laina;
            }
            laina = laina -maksu;
            kassa = kassa - maksu;
            jd.putData("update tilastot set lainanmaksut = "+maksu+" where paiva = "+ji.haepaiva()+" and yrnim = '"+YRNIMI+"'");
            jd.putData("update pelaajat set kassa = "+kassa+" where nimi = '"+YRNIMI+"'");
            jd.putData("update pelaajat set lainat = "+laina+" where nimi ='"+YRNIMI+"'");
            ji.LOGI.append("\n<Maksoit lainaa " +maksu+"€");
            ji.KASSA.setText(String.valueOf(ji.roundaaS(kassa)));
            ji.LAINAT.setText(String.valueOf(ji.roundaaS(laina)));
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(j4p_Pankki.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }//GEN-LAST:event_MAKSALAINAABTNActionPerformed

    private void OTALAINAABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OTALAINAABTNActionPerformed
        try {
            Double Ilaina = Double.valueOf(Lainabox.getSelectedItem().toString());
            double Dlaina = 0.10 *Ilaina / 12;

            double laina = Double.valueOf(ji.LAINAT.getText());
            laina = laina + Ilaina;

            jd.putData("update pelaajat set lainat = "+laina+" where nimi = '"+YRNIMI+"'");
            ji.LAINAT.setText(String.valueOf(ji.roundaaS(laina)));

            double nykom = Double.valueOf(ji.KASSA.getText());
            System.out.println("Kassa ennen lainaa " +nykom);
            double muutkassa = nykom+Ilaina;
            System.out.println("Kassa lainan jälkeen " + muutkassa);
            jd.putData("update pelaajat set kassa = "+muutkassa+" where nimi = '"+YRNIMI+"'");
            ji.LOGI.append("\n>Otit lainaa " +laina+"€");
            ji.paivita();
            ji.tarkistaKassa();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OTALAINAABTNActionPerformed

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
            java.util.logging.Logger.getLogger(j4p_Pankki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(j4p_Pankki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(j4p_Pankki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(j4p_Pankki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new j4p_Pankki().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Lainabox;
    private javax.swing.JButton MAKSALAINAABTN;
    private javax.swing.JButton OTALAINAABTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}