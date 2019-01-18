/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import static Yrityspeli_package.j2a_Uusi_peli.jd;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Niko L. & Timo K. Dat16A
 * Ota yhteyttä jos tarvitset lisätietoja
 * brandis.palaute@gmail.com
 * Copyright ©Brandis, All rights reserved
 */
public class j4_Siirrä extends javax.swing.JFrame {
					
	private Double Kassa;
	private Double Varat;
	public j3_Paaikkuna j;
	private String YRNIM;
	private int aKas = 0; //Siirrä ohjelman toiminto joka saadaan KASSA, VARAT tai LAINAT jTextFieldiä klikkaamalla j3_Paaikkunasta.
        //0 = varansiirto kassaan, 1 = kassan siirto varoihin, else = kassansiirto lainoihin
	public static Double Lainat;
	/**
        * Creates new form j4e_Siirrä
	*/
public j4_Siirrä() {
	initComponents();
}

					

j4_Siirrä(j3_Paaikkuna aThis, Double aVARAT, Double aKassa, String aYRNIM, int aKas) throws ClassNotFoundException, SQLException {
	this.Kassa = aKassa;
	this.Varat = aVARAT;
	this.j = aThis;
	this.YRNIM = aYRNIM;
	this.aKas = aKas;
        //Käydään arvot SQL-tauluista
	setOmaisuus();
	initComponents();
        //Haetaan valittu toiminto
	HaeTiedot();
}


@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Pienentyva = new javax.swing.JTextField();
        Lisaantyva = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Otsikko = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jSlider1.setMajorTickSpacing(1000);
        if(aKas == 0){
            jSlider1.setMaximum(Integer.parseInt(String.valueOf(Math.round(Varat))));
        }
        else if(aKas == 1){
            jSlider1.setMaximum(Integer.parseInt(String.valueOf(Math.round(Kassa))));
        }
        else{
            if(Lainat >= Kassa){
                jSlider1.setMaximum(Kassa.intValue());
            }else{
                jSlider1.setMaximum(Integer.parseInt(String.valueOf(Math.round(Lainat))));
            }
        }
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("Kassa");

        jLabel2.setText("Varasi");

        Pienentyva.setEditable(false);
        Pienentyva.setText("0");

        Lisaantyva.setEditable(false);
        Lisaantyva.setText("0.0");

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Otsikko.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Otsikko.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Pienentyva, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(162, 162, 162)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lisaantyva, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Otsikko)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Otsikko)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pienentyva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lisaantyva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
	System.out.println(aKas);
	int sliderarvo = jSlider1.getValue();
	int kassaarvo = Integer.parseInt(String.valueOf(Math.round(Kassa)));
	int varaarvo = Integer.parseInt(String.valueOf(Math.round(Varat)));
	int lainaarvo = Integer.parseInt(String.valueOf(Math.round(Lainat)));
	System.out.println(kassaarvo);
	System.out.println(varaarvo);
        int max = jSlider1.getMaximum();
        //Valitaan aKas toiminto ja pävitetään tarvittavat arvot kenttiin.
        //jSliderin max arvo riippuu siitä, mikä aKas on kyseessä. Tämän määrittäminen on 
        //tehty komponenttiin. Huom! Katso InitComponents tai jSlider1:sen custom code.
            switch (aKas) {
                case 0:
                    try {
                        
                        if(max <= 0){
                            jLabel3.setText("Sinulla ei ole varoja joita siirtää!");
                            jLabel3.setForeground(Color.BLUE);
                        }else{
                            jLabel3.setForeground(Color.BLACK);
                            
                            System.out.println(kassaarvo);
                            System.out.println("IF LAUSE");
                            Lisaantyva.setText(String.valueOf(kassaarvo+sliderarvo));
                            Pienentyva.setText(String.valueOf(varaarvo-sliderarvo));
                            jLabel3.setText(String.valueOf(sliderarvo));
                            
                            JDBC jd = new JDBC();
                            Connection con = jd.getConnection();
                            
                            
                            /*PreparedStatement Pkk = con.prepareStatement("UPDATE pelaajat SET omaisuus = "+Double.valueOf(Pienentyva.getText())+" WHERE nimi = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            Pkk = con.prepareStatement("UPDATE pelaajat SET kassa = "+Double.valueOf(Lisaantyva.getText())+" WHERE nimi = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            */
                            j.KASSA.setText(j.roundaaS(Double.valueOf(Lisaantyva.getText())));
                            j.VARAT.setText(j.roundaaS(Double.valueOf(Pienentyva.getText())));
                            
                            con.close();
                        }} catch (ClassNotFoundException | SQLException ex) {
                            System.out.println("Try virhe");
                            Logger.getLogger(j4_Siirrä.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                case 1:
                    if(max <= 0){
                        jLabel3.setText("Sinulla ei ole varoja joita siirtää!");
                        jLabel3.setForeground(Color.BLUE);
                    }else{
                        System.out.println(sliderarvo);
                        System.out.println(kassaarvo);
                        System.out.println("ELSE LAUSE");
                        Pienentyva.setText(String.valueOf(kassaarvo-sliderarvo));
                        Lisaantyva.setText(String.valueOf(varaarvo+sliderarvo));
                        jLabel3.setText(String.valueOf(sliderarvo));
                        j.KASSA.setText(j.roundaaS(Double.valueOf(Pienentyva.getText())));
                        j.VARAT.setText(j.roundaaS(Double.valueOf(Lisaantyva.getText())));
                    }
                    break;
                default:
                    if(max <= 0){
                        jLabel3.setText("Sinulla ei ole lainaa jota siirtää!");
                        jLabel3.setForeground(Color.BLUE);
                    }else{
                        System.out.println(sliderarvo);
                        System.out.println(kassaarvo);
                        System.out.println("ELSE LAUSE");
                        Lisaantyva.setText(String.valueOf(kassaarvo-sliderarvo));
                        Pienentyva.setText(String.valueOf(lainaarvo-sliderarvo));
                        jLabel3.setText(String.valueOf(sliderarvo));
                        j.KASSA.setText(j.roundaaS(Double.valueOf(Lisaantyva.getText())));
                        j.LAINAT.setText(j.roundaaS(Double.valueOf(Pienentyva.getText())));
                    }                   break;
            }
										
										
     }//GEN-LAST:event_jSlider1StateChanged

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         //Asetetaan Paaikkuna takaisin aktiiviseksi
         j.setEnabled(true);
         //Päivitetään muutokset SQL-tauluihin aKasin peruteella.
         try {   
                
                Connection con = jd.getConnection();
                
                    switch (aKas) {
                        case 0:
                            
                            PreparedStatement Pkk = con.prepareStatement("UPDATE pelaajat SET omaisuus = "+Double.valueOf(Pienentyva.getText())+" WHERE nimi = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            Pkk = con.prepareStatement("UPDATE pelaajat SET kassa = "+Double.valueOf(Lisaantyva.getText())+" WHERE nimi = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            
                            
                            break;
                        case 1:
                            Pkk = con.prepareStatement("UPDATE pelaajat SET omaisuus = "+Double.valueOf(Lisaantyva.getText())+" WHERE nimi = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            Pkk = con.prepareStatement("UPDATE pelaajat SET kassa = "+Double.valueOf(Pienentyva.getText())+" WHERE nimi = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            Pkk = con.prepareStatement("UPDATE tilastot SET kassa = "+Double.valueOf(Pienentyva.getText())+" WHERE yrnim = '"+YRNIM+"'");
                            Pkk.executeUpdate();
                            
                            break;
                       
                            
                            
                        default:
                            Pkk = con.prepareStatement("UPDATE pelaajat SET kassa = "+Double.valueOf(Lisaantyva.getText())+" WHERE nimi = '"+YRNIM+"'");
			    Pkk.executeUpdate();
			    Pkk = con.prepareStatement("UPDATE pelaajat SET lainat = "+Double.valueOf(Pienentyva.getText())+" WHERE nimi = '"+YRNIM+"'");
			    Pkk.executeUpdate();
                            break;
                    }
                    j.PaivitaStatsit();
                    j.BordelUpdate();
                    this.dispose();
               
                con.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(j4_Siirrä.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(j4_Siirrä.class.getName()).log(Level.SEVERE, null, ex);
            }

     }//GEN-LAST:event_jButton1ActionPerformed

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
															java.util.logging.Logger.getLogger(j4_Siirrä.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
										} catch (InstantiationException ex) {
															java.util.logging.Logger.getLogger(j4_Siirrä.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
										} catch (IllegalAccessException ex) {
															java.util.logging.Logger.getLogger(j4_Siirrä.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
										} catch (javax.swing.UnsupportedLookAndFeelException ex) {
															java.util.logging.Logger.getLogger(j4_Siirrä.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
										}
										//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
	public void run() {
		new j4_Siirrä().setVisible(true);
	}
});
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Lisaantyva;
    private javax.swing.JLabel Otsikko;
    private javax.swing.JTextField Pienentyva;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables

private void HaeTiedot() {
            //Määritetään tiedot jLabeleihin ja JTextFieldeihin aKas arvon perusteella.
         
            switch (aKas) {
                case 0:
                    jLabel2.setText("Varasi");
                    jLabel1.setText("Kassa");
                    Pienentyva.setText(String.valueOf(Math.round(Varat)));
                    Lisaantyva.setText(String.valueOf(Math.round(Kassa)));
                    Otsikko.setText("Siirrä varoja varoistasi kassaan");
                    break;
                case 1:
                    jLabel1.setText("Varasi");
                    jLabel2.setText("Kassa");
                    Lisaantyva.setText(String.valueOf(Math.round(Varat)));
                    Pienentyva.setText(String.valueOf(Math.round(Kassa)));
                    Otsikko.setText("Lisää varoja kassasta varoihisi");
                    break;
                case 2:
                    jLabel1.setText("Kassa");
                    jLabel2.setText("Lainat");
                    Lisaantyva.setText(String.valueOf(Math.round(Kassa)));
                    Pienentyva.setText(String.valueOf(Math.round(Lainat)));
                    Otsikko.setText("Maksa lainaa");
                    break;
                default:
                    break;
            }
}

private void setOmaisuus() throws ClassNotFoundException, SQLException {
        //Alustetaan double tyyppiä olevat muuttujat "kassa" ja "omaisuus" pelaajat tablen arvoilla, missä nimi on sama
        //kuin tämän hetkisen istunnon yritys.
	JDBC jd = new JDBC();
        Connection con = jd.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM pelaajat where nimi='"+YRNIM+"'");
        if(rs.next()){
		Varat= rs.getDouble("omaisuus");	
		Kassa = rs.getDouble("kassa");
	}
	Lainat = j.getLainat();
	con.close();
}
}
