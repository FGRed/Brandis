/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

import static Yrityspeli_package.j3_Paaikkuna.compCoords;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * @author Niko L. & Timo K. Dat16A
 * Ota yhteyttä jos tarvitset lisätietoja
 * brandis.palaute@gmail.com
 * Copyright ©Brandis, All rights reserved
 */

public class j2a_Uusi_peli extends javax.swing.JFrame {
public String KYN; // KYN = Kirjoita Yrityksen Nimi 
public String KS; // KS = Kirjoita Yrityksen Slogan
public boolean clicked =  false; // Apu boolean klikkausen tarkastukseen
public static JDBC jd = new JDBC(); // JDBC luokan import
private j2a_Uusi_peli UP; // Uusi_Peli import
private j3_Paaikkuna PI; // Paaikkunan import
final int counter; 
char[] chars = "".toCharArray();
public boolean viall = false;
public boolean alotusohje = false;
	/**
	* Creates new form j2a_Uusi_peli
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
	 */
//Konstruktori j2a_Uusi_peli.java jFramelle jossa ei ole parametrejä
public j2a_Uusi_peli() throws ClassNotFoundException, SQLException {
    
    this.counter = 0;
    
    KS = "Kirjoita slogan";//
    KYN = "Kirjoita yrityksen nimi";
    initComponents();
    //Täytetään kentät KS:llä ja KYN:llä
    Initialize();
    //Disabloidaan napit
    DisableButtons();
    //SelectionListener();
    YRNIMIINPUT.setHighlighter(null); 
    SLOGANINPUT.setHighlighter(null);	
    //ALOITABTN.setEnabled(false);
    dev.setBackground(Color.WHITE);
  
  
    //Alustetaan kaikki SQL taulut
    DeleteAllRecords();	
    
}
    //Konstruktori jossa Uuden pelin konstruktori
    j2a_Uusi_peli(j1_Aloitus aThis) throws ClassNotFoundException, SQLException {
    this.counter = 0;
    System.out.println("->Avataan j2a_Uusi_peli.java");    
       
    KS = "Kirjoita slogan";
    KYN = "Kirjoita yrityksen nimi"; 
   
    this.UP = this;
    initComponents();;
    //Custom yläpalkin luonti
    Palkki();
    //Täytetään kentät 
    Initialize();
    DisableButtons();
    //SelectionListener();
    //ALOITABTN.setEnabled(false);
 

    //Tyhjennetään SQL-taulut
    DeleteAllRecords();	
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        ALOITABTN = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Opastus = new javax.swing.JCheckBox();
        YRNIMIINPUT = new javax.swing.JTextField();
        SLOGANINPUT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        YlaPalkki = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aloita peli");
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ALOITABTN.setBackground(new java.awt.Color(76, 181, 245));
        ALOITABTN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ALOITABTN.setForeground(new java.awt.Color(255, 255, 255));
        ALOITABTN.setText("Aloita");
        ALOITABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALOITABTNActionPerformed(evt);
            }
        });
        ALOITABTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ALOITABTNKeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(76, 181, 245));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Peruuta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel2.setText("Yrityksen nimi");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel3.setText("Yrityksen slogan");

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel4.setText("Vaikeustaso");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("Helppo");
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyPressed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Normaali");
        jRadioButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton2KeyPressed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton3.setText("Vaikea");
        jRadioButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton3KeyPressed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton4.setText("Kaaos");
        jRadioButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton4KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Helppo - Starttiraha 10k");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Vaikea - Starttiraha 2.5k");
        jLabel7.setPreferredSize(new java.awt.Dimension(142, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Kaaos - Starttiraha 100");
        jLabel8.setPreferredSize(new java.awt.Dimension(132, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Normaali - Starttiraha 5k");
        jLabel6.setPreferredSize(new java.awt.Dimension(156, 25));

        Opastus.setText("Opastus");
        Opastus.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(Opastus))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Opastus))
        );

        YRNIMIINPUT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        YRNIMIINPUT.setMinimumSize(new java.awt.Dimension(6, 24));
        YRNIMIINPUT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                YRNIMIINPUTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                YRNIMIINPUTFocusLost(evt);
            }
        });
        YRNIMIINPUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YRNIMIINPUTMouseClicked(evt);
            }
        });
        YRNIMIINPUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                YRNIMIINPUTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                YRNIMIINPUTKeyTyped(evt);
            }
        });

        SLOGANINPUT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SLOGANINPUT.setMinimumSize(new java.awt.Dimension(6, 24));
        SLOGANINPUT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SLOGANINPUTFocusGained(evt);
            }
        });
        SLOGANINPUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SLOGANINPUTMouseClicked(evt);
            }
        });
        SLOGANINPUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SLOGANINPUTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SLOGANINPUTKeyTyped(evt);
            }
        });

        jLabel9.setText("v1.0");

        YlaPalkki.setBackground(new java.awt.Color(76, 181, 245));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Uusi Peli - Brandis v1.0");

        javax.swing.GroupLayout YlaPalkkiLayout = new javax.swing.GroupLayout(YlaPalkki);
        YlaPalkki.setLayout(YlaPalkkiLayout);
        YlaPalkkiLayout.setHorizontalGroup(
            YlaPalkkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YlaPalkkiLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YlaPalkkiLayout.setVerticalGroup(
            YlaPalkkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, YlaPalkkiLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dev.setBackground(new java.awt.Color(255, 102, 0));
        dev.setForeground(new java.awt.Color(255, 255, 255));
        dev.setText("dev");
        dev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devActionPerformed(evt);
            }
        });
        dev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                devKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ALOITABTN, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(YRNIMIINPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                    .addComponent(SLOGANINPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(YlaPalkki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(YlaPalkki, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(YRNIMIINPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SLOGANINPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dev, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ALOITABTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void ALOITABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALOITABTNActionPerformed
         //Jos viall boolean on totta, estä painaminen
         if(viall == true){    
                         }
        else{
        
         try {      
            //Tuodaan connection JDBC:stä 
            Connection con = jd.getConnection();
            //Luodaan Statement 
            Statement stm = con.createStatement();
            try {
            //Tuleva yrityksen nimi    
            String YrityksenNimi;
            //YrityksenNimi = YRNIMIINPUT kentän sisältö
            YrityksenNimi = YRNIMIINPUT.getText();
            //Slogan = SLOGANINPUT kentän sisältö
            String Slogan = SLOGANINPUT.getText();
            //Alustetaan kassa
            double sum = 0;
		//Valitaan kassan arvo radiobuttoneiden perusteella												
                if(jRadioButton1.isSelected()){
                    sum = 10000.0;
		}
		else if(jRadioButton2.isSelected()){
		sum = 5000.0;
		}
		else if(jRadioButton3.isSelected()){
		sum = 2500.0;
		}
		else if(jRadioButton4.isSelected()){
		sum = 100.0;
                
                }else{
                    /*Jos käyttäjä onnistuu jotenkin pääsemään tästä ilman radiobuttonin valintaa,
                    heitä virhe*/
                    throw new NullPointerException("Mikään radiobuttoneista ei ole valittu!");
                    
                }
	    //Käydään läpi kaikki tilastot YRNIMIINPUT:in perusteella																							
            ResultSet tilastot = stm.executeQuery("select * from tilastot where yrnim = '"+YRNIMIINPUT.getText()+"'");
            boolean duplikaatti = false;
            while(tilastot.next()){
                 System.out.println("Etsitään duplikaattia");
		 duplikaatti = true;
                 System.out.println(tilastot.getString("yrnim"));
					
            }
            //Jos tauluista löytyy duplikaattii, poista tilastot saman nimen perusteella
            if(duplikaatti){
                 System.out.println("Poistetaan vanhan pelaajan tiedot");
		 jd.putData("delete from tilastot where yrnim='"+YRNIMIINPUT.getText()+"'");
                 jd.putData("delete from tallennus where pnimi='"+YRNIMIINPUT.getText()+"'");
                 jd.putData("delete from PMyyja");
                 jd.putData("delete from PTuote");
                 jd.putData("delete from pelaajat where nimi='"+YRNIMIINPUT.getText()+"'");
                 jd.putData("delete from TMtilastot where yrnim='"+YRNIMIINPUT.getText()+"'");
                                        					
}
//Luodaan record pelaajiin pelaajan antamien arvojen peruteella
jd.putData("insert into pelaajat(nimi, slogan, kassa,ht, kk, v,markkinointi,brandi) values('"+YrityksenNimi+"', '"+Slogan+"', "+sum+","+0.0+", "+1+", "+2018+","+0.0+","+10.0+")");
//Luodaan myyja "Omistaja" Pelaajan palkkaamiin myyjiin
jd.putData("insert into PMyyja(nimi,palkka) values('Omistaja',0)");
//Käydään pelaajat läpi ja tulostetaan tiedot
ResultSet rs = stm.executeQuery("select * from pelaajat");
while(rs.next()){
    System.out.println("--Pelaajat--");
    System.out.println("Pelaajan yrityksen nimi on" +rs.getString("nimi")+", yrityksen slogan on "+rs.getString("slogan")+", yrityksen aloituskassa on "+rs.getInt("kassa")+" ,yrityksen brandi on " + rs.getDouble("brandi"));
    System.out.println("------------------------------------------------------------------");
}
//Suljetaan tämä frame
System.out.println("j2a_Uusi_peli.java -> dispose");
Boolean ops = false;
//Jjos opastusradiobutton on valittu, ops = true
if(Opastus.isSelected()){
    ops = true;
}
//Luodaan uusi paaikkuna-olio
j3_Paaikkuna Paaikkuna = new j3_Paaikkuna();
	try {
        //Tuodaan Paaikkunaan pelaajan antamat arvot    
	Paaikkuna = new j3_Paaikkuna(YrityksenNimi, Slogan, sum, ops);
	} catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
	Logger.getLogger(j2a_Uusi_peli.class.getName()).log(Level.SEVERE, null, ex);
	}
//Luodaan pelin tilastot taulu        
jd.putData("insert into tilastot(yrnim, paiva, kassa, tapahtunutmyynti, myyjienpalkat, lainanmaksut, markkinointikulut, "
        + "tuotteidenostohinta, vesi, sahko, tietoliikenne, vuokra, kuljetus, huolto, omistajanpalkka, taloushallinto, lainankorko,"
        + " hyvantekevaisuus, palkkojensivukulut, havikki, lainanpaaoma) "
        + "values('"+YRNIMIINPUT.getText()+"',"+1.2018+","+sum+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+")");

//Suljetaan connection con
con.close();
//Keskitetään komponentin default-sizen perusteella
Paaikkuna.pack();
//Keskitetään Paaikkuna-frame keskelle näyttöä
Paaikkuna.setLocationRelativeTo(null);
//Asetetaan paaikkuna näkyviin
Paaikkuna.setVisible(true);
//Luodaan olio ohjeille
Ohje o = new Ohje();
//Jos boolean aloitus ohje on totta, näytä ohje o
if(alotusohje){
o.setVisible(true);
o.setLocationRelativeTo(null);
o.OHJEETPANE.setSelectedIndex(1);
o.toFront();  
}
//Suljetaan tämä frame
this.dispose();
													
} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	Logger.getLogger(j2a_Uusi_peli.class.getName()).log(Level.SEVERE, null, ex);
									}
				} catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(j2a_Uusi_peli.class.getName()).log(Level.SEVERE, null, ex);
    }}
     }//GEN-LAST:event_ALOITABTNActionPerformed

    private void YRNIMIINPUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YRNIMIINPUTMouseClicked
        //Jos YRNIMIINPUT kenttää painetaan, tyhjennä sisältö ja laita fontinväri mustaksi
        YRNIMIINPUT.setText("");
        YRNIMIINPUT.setForeground(Color.BLACK);
        //Klikattu = totta
	clicked = true;
    }//GEN-LAST:event_YRNIMIINPUTMouseClicked

    private void SLOGANINPUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SLOGANINPUTMouseClicked
        //Jos SLOGANINPUT kenttää painetaan, tyhjennä sisältö ja laita fontinväri mustaksi
        SLOGANINPUT.setText("");
        SLOGANINPUT.setForeground(Color.BLACK);
    }//GEN-LAST:event_SLOGANINPUTMouseClicked

     private void YRNIMIINPUTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YRNIMIINPUTKeyTyped
	//Jos KYN on edelleen kentässä, tyhjennä kenttä kirjoittaessa
        if(YRNIMIINPUT.getText().equals(KYN)){
	YRNIMIINPUT.setText("");
	YRNIMIINPUT.setForeground(Color.BLACK);														
        }
            //Estä käyttäjää syöttämästä sopimattomia merkkejä
            char c = evt.getKeyChar();
      if (!Character.isLetterOrDigit(c) && !String.valueOf(c).equals(" ") &&!String.valueOf(c).equals("\b") ){
            evt.consume();
            
          JOptionPane.showMessageDialog(null, "Erikoismerkkiä \" "+c+" \" ei tueta!", "Virhe", JOptionPane.ERROR_MESSAGE);
      
   }
     
         
        
     }//GEN-LAST:event_YRNIMIINPUTKeyTyped

     private void SLOGANINPUTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SLOGANINPUTKeyTyped
            //Estää käyttäjää syöttämästä sopimattomia merkkejä 
            char c = evt.getKeyChar();            
         if (!Character.isLetterOrDigit(c) && !String.valueOf(c).equals(" ") &&!String.valueOf(c).equals("\b") ){
            evt.consume();
            
          JOptionPane.showMessageDialog(null, "Erikoismerkkiä \" "+c+" \" ei tueta!", "Virhe", JOptionPane.ERROR_MESSAGE);
      
   }
         //Sama kuin YRNIMI-inputille
         if(SLOGANINPUT.getText().equals(KS)){
	SLOGANINPUT.setText("");
	SLOGANINPUT.setForeground(Color.BLACK);
    }
     }//GEN-LAST:event_SLOGANINPUTKeyTyped

    private void ALOITABTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ALOITABTNKeyPressed
        //Näppäin eventit: jos pelaaja painaa ENTER, aloitanappia klikataan;
        //Jos pelaaja painaa vasemmalle, focus siirtyy vasempaan nappiin.
        System.out.println("Enter painettu kohdalla aloita");
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           ALOITABTN.doClick();
       }
         if(evt.getKeyCode() == KeyEvent.VK_LEFT){
          this.getRootPane().setDefaultButton(jButton2);
          jButton2.requestFocus();
          
       }
    }//GEN-LAST:event_ALOITABTNKeyPressed

    private void devActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devActionPerformed
        //Devaajien pikanappi
        YRNIMIINPUT.setText("Developer Test Corporation Oy");
        SLOGANINPUT.setText("Developer Test Slogan");
        ALOITABTN.doClick();
    }//GEN-LAST:event_devActionPerformed

    private void YRNIMIINPUTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YRNIMIINPUTKeyPressed
	//Näppäin eventit: jos pelaaja painaa ENTER, aloitanappia klikataan;
        //Jos pelaaja painaa vasemmalle, focus siirtyy vasempaan nappiin.	
         if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){
            System.out.println("Enter painettu");
            ALOITABTN.doClick();
		        
         }
         if(evt.getKeyCode() == (KeyEvent.VK_DOWN)){
              SLOGANINPUT.requestFocus();                   
        }			
         
    }//GEN-LAST:event_YRNIMIINPUTKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        //Peruuta nappi: palataan j1_Aloitus frameen
        j1_Aloitus p = new j1_Aloitus();
        this.dispose();
        p.setVisible(true);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | SQLException ex) {
        Logger.getLogger(j2a_Uusi_peli.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void YRNIMIINPUTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YRNIMIINPUTFocusGained
        //Täytetään kenttä aloitusarvoilla jos kenttä saa focusin
        if(SLOGANINPUT.getText().equals("")||SLOGANINPUT.getText().equals(KS)){
            SLOGANINPUT.setForeground(Color.GRAY);
            SLOGANINPUT.setText(KS);
            
        }
    }//GEN-LAST:event_YRNIMIINPUTFocusGained
    /*Eventit Enterille ja nuolinäppäimille. Siirry seuraavaan komponenttiin
    jos käyttäjä painaa suuntanäppäintä komponenttia kohti. Enter aloittaa pelin, jos kaikki 
    tarpeellinen on täytetty*/
    private void SLOGANINPUTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SLOGANINPUTKeyPressed
        	
                if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){
		System.out.println("Enter painettu");
		ALOITABTN.doClick();
		}
                if(evt.getKeyCode() == (KeyEvent.VK_UP)){
                    YRNIMIINPUT.requestFocus();
                }
                if(evt.getKeyCode() == (KeyEvent.VK_DOWN)){
                    jRadioButton1.requestFocus();
                }
                
    }//GEN-LAST:event_SLOGANINPUTKeyPressed

    private void YRNIMIINPUTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YRNIMIINPUTFocusLost
        System.out.println("Focus lost");
        if(YRNIMIINPUT.getText().equals("")||YRNIMIINPUT.getText().equals(KYN)){
            YRNIMIINPUT.setForeground(Color.GRAY);
            YRNIMIINPUT.setText(KYN);
            
            ALOITABTN.setEnabled(false);
        }
        else{
            ALOITABTN.setEnabled(true);
        }
    }//GEN-LAST:event_YRNIMIINPUTFocusLost

    private void SLOGANINPUTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SLOGANINPUTFocusGained
        System.out.println("Focus lost");
        if(SLOGANINPUT.getText().equals("")||SLOGANINPUT.getText().equals(KS)){
            SLOGANINPUT.setForeground(Color.GRAY);
            SLOGANINPUT.setText(KS);
            ALOITABTN.setEnabled(false);
        }
        else{
            ALOITABTN.setEnabled(true);
        }
    }//GEN-LAST:event_SLOGANINPUTFocusGained

    private void jRadioButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyPressed
          if(evt.getKeyCode() == (KeyEvent.VK_UP)){
                    SLOGANINPUT.requestFocus();
                }
                if(evt.getKeyCode() == (KeyEvent.VK_DOWN)){
                    jRadioButton2.requestFocus();
                }
                 if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){
                    jRadioButton1.setSelected(true);
                }
                
    }//GEN-LAST:event_jRadioButton1KeyPressed

    private void jRadioButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton2KeyPressed
         if(evt.getKeyCode() == (KeyEvent.VK_UP)){
                    jRadioButton1.requestFocus();
                }
                if(evt.getKeyCode() == (KeyEvent.VK_DOWN)){
                    jRadioButton3.requestFocus();
                }
                 if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){
                    jRadioButton2.setSelected(true);
                   
                }
    }//GEN-LAST:event_jRadioButton2KeyPressed

    private void jRadioButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton3KeyPressed
          if(evt.getKeyCode() == (KeyEvent.VK_UP)){
                    jRadioButton2.requestFocus();
                }
                if(evt.getKeyCode() == (KeyEvent.VK_DOWN)){
                    jRadioButton4.requestFocus();
                }
                 if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){
                    jRadioButton3.setSelected(true);
                }
    }//GEN-LAST:event_jRadioButton3KeyPressed

    private void jRadioButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton4KeyPressed
         if(evt.getKeyCode() == (KeyEvent.VK_UP)){
                    jRadioButton3.requestFocus();
                }
          if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){
                    jRadioButton4.setSelected(true);
                }
          if(evt.getKeyCode() == (KeyEvent.VK_DOWN)){
                    this.getRootPane().setDefaultButton(dev);
                    dev.requestFocus(true);
                }
               
    }//GEN-LAST:event_jRadioButton4KeyPressed

    private void devKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_devKeyPressed
         if(evt.getKeyCode() == (KeyEvent.VK_UP)){
                  jRadioButton4.requestFocus(true);
                }
         if(evt.getKeyCode() == (KeyEvent.VK_RIGHT)){
                  this.getRootPane().setDefaultButton(jButton2);
                    jButton2.requestFocus(true);
                }
         
    }//GEN-LAST:event_devKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
         if(evt.getKeyCode() == (KeyEvent.VK_LEFT)){
                   this.getRootPane().setDefaultButton(dev);
                    dev.requestFocus(true);
                }
         if(evt.getKeyCode() == (KeyEvent.VK_RIGHT)){
                  if(ALOITABTN.isEnabled()){
                  this.getRootPane().setDefaultButton(ALOITABTN);
                    ALOITABTN.requestFocus(true);
                  }
                }////Eventin Enterille ja nuolinäppäimille loppuu
    }//GEN-LAST:event_jButton2KeyPressed
    
public static void main(String args[]) {				
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
		new j2a_Uusi_peli().setVisible(true);
		} catch (ClassNotFoundException ex) {
		Logger.getLogger(j2a_Uusi_peli.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
		Logger.getLogger(j2a_Uusi_peli.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
    });
}
                                           
  private void Initialize() {
    //Alustus kenttiin metodi
    YRNIMIINPUT.setForeground(Color.GRAY);
    YRNIMIINPUT.setText(KYN);										
    SLOGANINPUT.setForeground(Color.GRAY);
    SLOGANINPUT.setText(KS);								
}
  

  
    private void DisableButtons() {
        //Disabloi napit listeneri. Jos pelaaja ei ole täyttänyt kaikkia kenttiä, napit disabloidaan.
										
	ALOITABTN.setEnabled(false);
        
        jRadioButton1.setSelected(true);
        
        YRNIMIINPUT.getDocument().addDocumentListener(new DocumentListener(){
        @Override
        public void changedUpdate(DocumentEvent e) {
          
            changed();
        }
        public void removeUpdate(DocumentEvent e) {
            changed();
        }
        public void insertUpdate(DocumentEvent e) {
           
            changed();
        }

        public void changed() {
            if (YRNIMIINPUT.getText().equals("")||YRNIMIINPUT.getText().matches(".*irjoita yrityksen nim*.")||SLOGANINPUT.getText().equals("")||SLOGANINPUT.getText().equals(KS)){
               
            }
            else { 
  
                
                
            }
        }
        });
        SLOGANINPUT.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e) {
               
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }
		
            public void changed() {
      
                if (YRNIMIINPUT.getText().equals("")||YRNIMIINPUT.getText().equals(KYN)||SLOGANINPUT.getText().equals("")||SLOGANINPUT.getText().equals(KS)){
       
                    ALOITABTN.setEnabled(false);
                   
                    
              
                
                }
                else {
       
                    ALOITABTN.setEnabled(true);			
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALOITABTN;
    private javax.swing.JCheckBox Opastus;
    private javax.swing.JTextField SLOGANINPUT;
    private javax.swing.JTextField YRNIMIINPUT;
    private javax.swing.JPanel YlaPalkki;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton dev;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables

private void DeleteAllRecords() throws ClassNotFoundException, SQLException {
	//Alustetaan taulut ja luodaan uudet myyjät ja tuotteet								
	Connection con = jd.getConnection();
	Statement stm = con.createStatement();
        PreparedStatement ps = con.prepareStatement("DELETE FROM pmyyja");
        ps.executeUpdate();
        ps = con.prepareStatement("DELETE FROM myyja");
        ps.executeUpdate();
	jd.putData("insert into myyja(nimi,palkka)values ('Tauno Jallinen', 1200.0)");
	jd.putData("insert into myyja(nimi,palkka)values ('Teimo', 1500.0)");
        jd.putData("insert into myyja(nimi,palkka)values ('Erkki Toivanen', 1700.0)");
        jd.putData("insert into pmyyja(nimi,palkka)values ('Omistaja', 0.0)");
        
        ps = con.prepareStatement("DELETE FROM PTuote");
        ps.executeUpdate();
        ps = con.prepareStatement("DELETE FROM tuote");
        ps.executeUpdate();
	jd.putData("insert into tuote(nimi,hinta)values ('Tehdasleipä', 1)");
	jd.putData("insert into tuote(nimi,hinta)values ('Leipomon leipä', 2)");
        jd.putData("insert into tuote(nimi,hinta)values ('Luomuleipä', 3)");
        jd.putData("insert into tuote(nimi, hinta)values ('Näkkileipä', 1)");
        
        ps = con.prepareStatement("DELETE FROM markkinointi");
        ps.executeUpdate();
        
	con.close();
        }
private void Palkki() {  
    //Metodi palkiille. Ohjeet tekoon: https://www.youtube.com/watch?v=__eZ_kQ4UKs 
    this.getContentPane().setBackground(new Color(76, 181, 245));
         YlaPalkki.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                compCoords = null;
                jPanel4.setBorder(BorderFactory.createLineBorder(new Color(12, 143, 222)));
            }

           
            @Override
            public void mousePressed(MouseEvent e) {
                compCoords = e.getPoint();
                jPanel4.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
            }

           
            @Override
            public void mouseExited(MouseEvent e) {
            }

            
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
       YlaPalkki.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                UP.setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
                
            }
        });
       
    }
  
					
}//Ohjelman lopetus
