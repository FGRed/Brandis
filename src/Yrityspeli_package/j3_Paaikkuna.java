/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;
import static Yrityspeli_package.j2a_Uusi_peli.jd;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Component;
import static java.awt.Event.DELETE;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.TableColumn;


/**
 * @author Niko L. & Timo K.
 * Ota yhteyttä jos tarvitset lisätietoja
 * brandis.palaute@gmail.com
 * Copyright ©Brandis, All rights reserved
 */

public final class j3_Paaikkuna extends javax.swing.JFrame {
  public String YRNIMI; //Yrityksen nimi
  public static String Slogan; //Yrityksen slogan
  Opastus op = new Opastus(this); // Opastus framen alustus
  private double sum;// kkloopissa käytettävä arvo voiton laskuun
  public int kuk = 0;// Tämän hetkinen kuukausi
  public int vuk = 0;// Tämän hetkinen vuosi
  private int opastusnm = 0;// Käytetään opastuksen päälle/pois laittamiseen
  public double tapahtunutmyynti = 0.0; // Käytetään kkloopissa myynnin laskemiseen
  static Point compCoords; // Dynaamista otsikkopalkkia varten oleva kordinaatti
  private j3_Paaikkuna ji; // Dynaamista otsikkopalkkia varten oleva olio
  public double brandi = 10; //Brandin laskua varten oleva muuttaja
  boolean bol = true; // Käytetään tuotteiden osto/poisto eventhandlerissä nullpointer exeptionin estämiseen
  public JPopupMenu menu = new JPopupMenu(); // MENU buttonista tuleva valikko
  private double THinnatYht;  //Käytetään kkloopissa tuotteiden hinnan yhteen laskemiseen
  private Double PalkatYht = 0.0; //Käytetään kkloopissa palkkojen yhteen laskemiseen
  public double kKassa = 0; // Käytetään päivitä methodissa kassan arvon tallentamiseen sekä kkloopissa sql tallentamista varten
  private int myyntimaara;// Käytetään kkloopissa lopullisen myyntimäärän laskemiseen
  boolean Myyntihintavaroitus = false; //Käytetään etenemisen estämisessä jos pelaajalla ei ole tuotteita	
  int krt;//Käytetään päivitä methodissa käyntien määrän tulostamiseen
  j4a_Tilastot T = new j4a_Tilastot();//Tilastot framen alustus
  boolean tilastotavattu = false; //Käytetään tilastojen sijainnin muuttamiseen jos se on avattu
  int kas;// Käytetään toiminnon määrittelyyn Siirrä-ikkunaa avatessa
  boolean ops; // Käytetään opastuksessa
  private double kOmaisuus; //Käytetään kkloopissa omaisuuden asettamiseen
  public static JTextField t = new JTextField(); //Jtablen kentän tyhjentämistä varten
  public static boolean taulupaivittyy = false;// Estää ohjelman kuormittumista
  public boolean PmyyjaEstot = false;// Estää ohjelman kuormittumista
  public boolean taaksep = false; //Kertoo mennäänkö ohjelma takaisin päävalikkoon vai sammutetaanko
  public boolean npv = false; //Käytetään näkkileipien määrän tarkistuksessa kuukauden lopussa
  public Object valittutuote = "Tehdasleipä"; //Määrittää OTUOTE comboboxista valitun tuotteen
  public int NOstomaara = 0; //Käytetään näkkileipien ostomäärän tallentamisessa
  public boolean Painettu = false;//Käytetään LOGI ja TAPAHTUMAT textareoiden tyhjentämisessä jos etenekk nappia on painettu
  public MyCellEditor ej = new MyCellEditor(); // Jtablen solujen editointia varten
  

    /**
     * Creates new form j3_Paaikkuna
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
public j3_Paaikkuna() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, UnsupportedLookAndFeelException {

    
        //Pääikkunan teeman ja ulkonäön muokkaus 
	for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Metal".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
			break;
             }
	}
	UIManager.put("ComboBox.background", new ColorUIResource(UIManager.getColor("TextField.background")));
        UIManager.put("ComboBox.foreground", new ColorUIResource(UIManager.getColor("TextField.foreground")));
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(new Color(76, 181, 245)));
        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.buttonBackground", (new Color(76, 181, 245)));
        UIManager.getDefaults().put("ComboBox.buttonDarkShadow", Color.WHITE);
	UIDefaults ui = UIManager.getLookAndFeelDefaults();
        UIManager.put("TabbedPane.focus", UIManager.getColor("TabbedPane.selected"));
                           
        Font TBFont = new java.awt.Font("Segoe UI", 1, 12);
        UIManager.put("TabbedPane.font", TBFont);
        UIManager.put("TabbedPane.light", new Color(76, 181, 245));  
                           
        ui.put("PopupMenu.background", WHITE);
        ui.put("Menu.background", WHITE);
        ui.put("Button.background", new Color(76, 181, 245));
        ui.put("Button.foreground", Color.WHITE);
        ui.put("Menu.opaque", true);
        ui.put("MenuItem.background", WHITE);
        ui.put("MenuItem.opaque", true);	
        ui.put("PopupMenu.contentMargins", null);
        ui.put("MenuItem.selectionBackground", new Color(76, 181, 245));
        ui.put("MenuItem.selectionForeground", Color.WHITE);
        ui.put("JTable.selectionBackground", Color.RED);
        ui.put("ProgressBar.background", Color.WHITE);
        /* ui.put("ProgressBar.foreground", Color.WHITE);
         ui.put("ProgressBar.selectionBackground", Color.BLACK);
         ui.put("ProgressBar.selectionForeground", Color.BLACK);*/
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();

        initComponents();
 }
   
//Konstruktori j3_Paaikkuna.java jFramelle
				
    j3_Paaikkuna(String YrityksenNimi,String Slogan, double sum, boolean aOps) throws SQLException, ClassNotFoundException, LineUnavailableException, UnsupportedAudioFileException, IOException {
									
								
	this.ops = aOps; //asetetaan opastuksen arvo									                                                                
        System.out.println("-->Avataan j3_Pääikkuna.java");                                                                           
        
        initComponents();
    
        POstot.setCellEditor(ej);// asettaa POstot tableen celleditorin
    
    
        //UI asetuksia tabbedpanelle
        JT1.setUI(new BasicTabbedPaneUI() {
            private final Insets borderInsets = new Insets(0, 0, 0, 0);
            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            }
        @Override
        protected Insets getContentBorderInsets(int tabPlacement) {
            return borderInsets;
        }
        });
    
    
        HaeComboboxData();
        
        //Hakee jtableen comboboxin tiedot
        TableColumn comboCol1 = PMyyjat.getColumnModel().getColumn(1);
        ArrayList<String>Palkat = new ArrayList();
        Collections.addAll(Palkat, "0.00€", "500.00€", "1000.00€", "1500.00€");
        comboCol1.setCellEditor(new CustomComboBoxEditor(Palkat));
        haeMyyjat();
        PMyyjatTableListeneri();
        ComboBoxMuutos();
        
        
        JT1.setEnabledAt(1, false);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(12, 143, 222)));			
        BRANDIPALKKI.setToolTipText("Yrityksen maine");
        Jatka.setToolTipText("Etene");
        KASSA.setToolTipText("Siirrä varoja kassata varoihisi");
        VARAT.setToolTipText("Siirrä varoja varoistasi kassaan");
        OhjeBorder1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder1.setBackground(Color.white);
        OhjeBorder2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder2.setBackground(Color.white);
    
        OhjeBorder4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder4.setBackground(Color.white);
        OhjeBorder5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder5.setBackground(Color.white);
        OhjeBorder6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder6.setBackground(Color.white);
        OhjeBorder7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder7.setBackground(Color.white);
        OhjeBorder8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
        OhjeBorder8.setBackground(Color.white);
		
        Opastus(false,false,false,false,false);
    
        this.getContentPane().setBackground(new Color(76, 181, 254));
        this.ji = this;
        Palkki();
    
        PMyyjat.setOpaque(true); 
        JT1.setOpaque(false);
        PMyyjat.setSelectionBackground(Color.blue);
        JT1.setBackgroundAt(0, new Color(76, 181, 245));
    
    
     

      try (Connection con = jd.getConnection() //Hakee yhteyden SQL-kantaan
      ) {
          System.out.println("Con 1");
          Statement stm = con.createStatement();
          this.YRNIMI = YrityksenNimi;
          YRNIM.setText(YrityksenNimi);//Asettaa otsikkoon yrityksen nimen
          j3_Paaikkuna.Slogan = Slogan;
          this.sum = sum; 
          paivitaaika();
          paivita();
          paivitaMyyja();
          SLOGAN.setText(Slogan);
          jLabel6.setBackground(Color.WHITE);
          ChangeTableColors();
          DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();//Vaihtaa jtablejen otsikon värin
          headerRenderer.setBackground(new Color(76, 181, 245));
          logi.setText("Osta tuote ja paina jatka aloittaaksesi!");
          for (int j = 0; j < PMyyjat.getModel().getColumnCount(); j++) {
              PMyyjat.getColumnModel().getColumn(j).setHeaderRenderer(headerRenderer);
          }         for (int j = 0; j < POstot.getModel().getColumnCount(); j++) {
              POstot.getColumnModel().getColumn(j).setHeaderRenderer(headerRenderer);
          }         for (int j = 0; j < PMarkkinointi.getModel().getColumnCount(); j++) {
              PMarkkinointi.getColumnModel().getColumn(j).setHeaderRenderer(headerRenderer);
          }         this.getContentPane().setBackground(Color.WHITE);
          jScrollPane3.getViewport().setBackground(Color.WHITE);
          jScrollPane2.getViewport().setBackground(Color.WHITE);
          jScrollPane1.getViewport().setBackground(Color.WHITE);
          OTSIKKO.setBackground(new Color(76, 181, 245));
          jPanel1.setBackground(Color.WHITE);
          KASSA.setBackground(Color.WHITE);
      }
      //BRANDIPALKKI.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      POstot.setCellEditor(ej);
        
   }
    
     //Väli methodi Aloita napille
    public void jatka() throws ClassNotFoundException, SQLException, InterruptedException{
        boolean virhe = false;
	boolean etene = false;	
        DefaultTableModel model = (DefaultTableModel) POstot.getModel();
      try (Connection con = jd.getConnection() //Hakee yhteyden SQL-kantaan
      ) {
          System.out.println("Con 2");
          Statement stm = con.createStatement();
          ResultSet rs = stm.executeQuery("Select * from PTuote");
          check:
          while(rs.next()){//Tarkistaa tuotteiden myyntihinnan
              if(rs.getDouble("myyntihinta") == 0){
                  Myyntihintavaroitus = true;
                  break check;
              }else{
                  Myyntihintavaroitus = false;
              }
          }   
      }
            
        if(Myyntihintavaroitus == true){//Jos pelaajalla on tuotteita myynnissä ilmaiseksi ohjelma varoittaa
                String[] options = new String[] {"Kyllä", "Peruuta"};
                int response = JOptionPane.showOptionDialog(null, "Haluatko varmasti antaa tuotteet/tuotteita ilmaiseksi?", "Varoitus",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
															
	if(response == 0){
		etene = true;	
		Myyntihintavaroitus = false;
	}
	}
	else{
	etene = true;
	}
	if(etene){
        try{//Tarkistaa onko ostot ja myyjät tableissa jotain
        Object row = model.getValueAt(0,0);
        }catch(Exception ex){//Jos tableissa ei ole mitään asetetaan virhe arvolle true.
            virhe = true;
        }
        if (virhe) {//Jos virhe on true, ohjelma antaa käyttäjälle virheen.
          JOptionPane.showMessageDialog(null, "Osta ensin tuotteita myytäväksi.");
          
      } else {//Muuten ohjelma jatkaa seuraavaan methodiin.
          ETENEKKBTN.setEnabled(true);
          Roll();
          
      }
    }}										
				

   public void paivitalainat() throws ClassNotFoundException, SQLException{ //Methodi jossa asetetaan oikeat tiedot LAINAT textareaan
       Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
       System.out.println("Con 4");
       Statement stm = con.createStatement();
       ResultSet rs = stm.executeQuery("select *from pelaajat where nimi ='"+YRNIMI+"'");
       while(rs.next()){
           LAINAT.setText(String.valueOf(roundaaS(rs.getDouble("lainat"))));
       }
       System.out.println("Lainat päivitetty");
       con.close();
   }
   
   
   public void haenakki() throws ClassNotFoundException, SQLException{//Tarkistaa onko näkkileipää ostettu,ja jos on niin asettaa näkkileivän myös PTuotteeseen ja TMTilastoihin
       Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
       System.out.println("Con 30");
       Statement stm = con.createStatement();
       boolean nak = false;
       double nmh = 0.0;
       int nm = 0;
       ResultSet rs = stm.executeQuery("SELECT * FROM TMTilastot where yrnim ='"+YRNIMI+"'");
       while(rs.next()){
          if(rs.getString("nimi").equals("Näkkileipä")){
               nak = true;
               nmh = rs.getDouble("myyntihinta");
               nm = rs.getInt("maara");
          }
       }
       if(nak){
           jd.putData("insert into PTuote(ID,nimi,hinta,myyntihinta,maara) values(0,'Näkkileipä',1.0,"+nmh+","+nm+")");
           jd.putData("delete from TMTIlastot where paiva = 0.0 and nimi='Näkkileipä'");
       }
   }
   
   
    public void paivita() throws SQLException, ClassNotFoundException{
       //Päämethodi kaikkien tablejen ja omaisuuden päivittämiseen
        taulupaivittyy = true;                                                                
        krt++;
        System.out.println("--Paivita "+krt+"--");
        System.out.println("---------------------------------------------");
        System.out.println("Aloitetaan päivitys");
        ArrayList<Tuote> tuotelista = new ArrayList();//Lista minkä avulla ohjelma lisää tuotteen tableen
       
        ArrayList<Markkinointi> markkinointilista = new ArrayList();//Lista minkä avulla ohjelma lisää markkinoinnin tableen
        JDBC jd = new JDBC();
        Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 5");
        Statement stm = con.createStatement();
        DefaultTableModel model = (DefaultTableModel) POstot.getModel();
        
        
        DefaultTableModel model23 = (DefaultTableModel) PMarkkinointi.getModel();
        Object[] row = new Object[5];
        Object[] row1 = new Object[2];
        
        
        double MiinustettavaPelaajanOmaisuus = 0.0;
        ResultSet rs = stm.executeQuery("SELECT * FROM pelaajat");
        while(rs.next()){//Omaisuuden päivittäminen
            if(rs.getString("nimi").equals(YRNIMI)){//Käy kaikki pelaajat läpi, ja valitsee pelaajan jolla on sama nimi kuin nykyisellä pelaajalla.
                System.out.println("kassa päivittyy, uusi kassa on " + rs.getInt("kassa"));
                VARAT.setText(String.valueOf(roundaaS(rs.getDouble("omaisuus"))));	
		kKassa = rs.getDouble("kassa");
		kOmaisuus = rs.getDouble("omaisuus");
		KASSA.setText(String.valueOf(roundaaS(rs.getDouble("kassa"))));				
            }
        }
        
        int rowCount = model.getRowCount();
       
        for (int i = rowCount - 1; i >= 0; i--) {//Poistaa rivejä ostot tablesta
            System.out.println("Myyjät JTablesta on poistettu rivi");
        model.removeRow(i);
        }

        
        int rowCount3 = model23.getRowCount();
        
        for (int i = rowCount3 - 1; i >= 0; i--) {//Poistaa rivejä markkinoinnit tablesta
            System.out.println("Markkinointi JTablesta on poistettu rivi");
        model23.removeRow(i);
        }
        
      
        model.fireTableDataChanged();
        model23.fireTableDataChanged();
        
        model = (DefaultTableModel) POstot.getModel();
       
        model23 = (DefaultTableModel) PMarkkinointi.getModel();
        
        rs = stm.executeQuery("SELECT * FROM PTuote");
        while(rs.next()){//Hakee kaikki pelaajan ostamat tuotteet SQL-kannasta, ja lisää ne arraylistiin.
            Tuote t = new Tuote(rs.getString("nimi"), rs.getDouble("myyntihinta"), rs.getDouble("hinta"), rs.getInt("maara"));
	    System.out.println("Lisätään tuote tauluun");					
	    tuotelista.add(t);
		if(rs.getDouble("myyntihinta") == 0){
                    Myyntihintavaroitus = true;
		}
		else{
			Myyntihintavaroitus = false;		
		}
        }
	
	for(int i = 0; i < tuotelista.size(); i++) {//Lisää pelaajan tuotteet tableen.
            System.out.println("lisätään tuote tableen");
            row[0]=tuotelista.get(i).getNimi();
            row[1]=roundaaS(tuotelista.get(i).getHinta())+"€";
            row[2]=tuotelista.get(i).getMaara();
            row[3]=roundaaS(tuotelista.get(i).getMhinta())+"€";
            model.addRow(row);
        }
        
         System.out.println("--Markkinointi--");
         rs = stm.executeQuery("SELECT * FROM markkinointi");
         while(rs.next()){//Hakee kaikki pelaajan markkinoinnit SQL-kannasta, ja lisää ne arraylistiin.
            Markkinointi mm = new Markkinointi(rs.getString("markkinointityyppi"), rs.getDouble("hinta"));
            markkinointilista.add(mm);
        }
         
        for(int i = 0; i < markkinointilista.size(); i++) {//Lisää pelaajan markkinoinnit tableen.
           System.out.println("lisätään markkinointi tableen");
           row1[0]=markkinointilista.get(i).getMtyyppi();
           row1[1]=roundaaS(markkinointilista.get(i).getKkmaara())+"€";
           model23.addRow(row1);
        }
        
        if(!markkinointilista.isEmpty()){
            logi.setText("Lisätään markkinointi " + markkinointilista.get(markkinointilista.size()-1).getMtyyppi()+" vahvuudella "+ markkinointilista.get(markkinointilista.size()-1).getKkmaara());
            EmptyLog();
        }
      
        model.fireTableDataChanged();
        model23.fireTableDataChanged();
        
        boolean virhe = false;
        model = (DefaultTableModel) POstot.getModel();
        
        try{//Tarkistaa onko ostot ja myyjät tableissa jotain
        Object row3 = model.getValueAt(0,0);
       
        }catch(Exception ex){//Jos tableissa ei ole mitään asetetaan virhe arvolle true.
            virhe = true;
           ETENEKKBTN.setEnabled(false);					
        }
      if(virhe == false){//Jos tablessa on jotain, pelaaja voi edetä
          ETENEKKBTN.setEnabled(true);
          rs = stm.executeQuery("select * from PTuote where nimi = 'Näkkileipä'");
            while(rs.next()){
              if(npv){
             ETENEKKBTN.setEnabled(true);
             
             
              }else{
                ETENEKKBTN.setEnabled(false);  
              }
          }	
          ETENEKKBTN.setEnabled(true);
      }
      
        con.close();
        System.out.println("Päivitetään lainat");
        paivitalainat();
        System.out.println("Done and done");
        
        taulupaivittyy = false;
    }/////////////////////////////////////////////////////////////PAIVITA LOPPU
    
    
public void paivitaMyyja() throws SQLException, ClassNotFoundException{// Asettaa myyjät jtableen
	ArrayList<Myyja> myyjalista = new ArrayList();//Lista minkä avulla ohjelma lisää myyjän tableen		
        Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 6");
        Statement stm = con.createStatement();
	DefaultTableModel model2 = (DefaultTableModel) PMyyjat.getModel();
	Object[] row1 = new Object[2];
	int rowCount = model2.getRowCount();
        
        for (int i = rowCount - 1; i >= 0; i--) {//Poistaa rivejä myyjät tablesta
        model2.removeRow(i);
            System.out.println("Myyjat JTablesta on poistettu rivi");
        }
							
	boolean onjoku = false;	
	 ResultSet rs1 = stm.executeQuery("SELECT * FROM pmyyja");
        while(rs1.next()){//Hakee kaikki pelaajan palkkaamat myyjät SQL-kannasta, ja lisää ne arraylistiin.
            Myyja m = new Myyja(rs1.getString("nimi"), rs1.getDouble("palkka"));
            myyjalista.add(m);
            onjoku = true;
        }
        
	for(int i = 0; i < myyjalista.size(); i++) {//Lisää pelaajan myyjät tableen.
            System.out.println("lisätään myyjä tableen");
            row1[0]=myyjalista.get(i).getNimi();
            row1[1]=roundaaS(myyjalista.get(i).getPalkka())+"€";
            model2.addRow(row1);
        }	
                                        
        if(onjoku){// jos pelaajalla on myyjä niin ohjelma tulostaa logiin tiedot
            logi.setText("Myyja "+myyjalista.get(myyjalista.size()-1).getNimi()+" palkattu palkalla " + myyjalista.get(myyjalista.size()-1).getPalkka() + "€");
            if(!(myyjalista.get(myyjalista.size()-1).getNimi().equals("Omistaja"))){
                LOGI.append("\n>Myyjä " +myyjalista.get(myyjalista.size()-1).getNimi()+" palkattu palkalla " + myyjalista.get(myyjalista.size()-1).getPalkka() +"€");
            }}
	EmptyLog();
					
					
}//////////////////////////////////////////////////////////////////PAIVITAMYYJA LOPPU
				
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        OhjeBorder6 = new javax.swing.JPanel();
        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        REUNUS = new javax.swing.JPanel();
        OTSIKKO = new javax.swing.JPanel();
        LAINAT = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        KASSA = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        VARAT = new javax.swing.JLabel();
        Varoitus = new javax.swing.JLabel();
        sulje = new javax.swing.JLabel();
        pienenna = new javax.swing.JLabel();
        VEDA = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        MENU = new javax.swing.JToggleButton();
        SLOGAN = new javax.swing.JLabel();
        YRNIM = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JT1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OTUOTE = new javax.swing.JComboBox<>();
        MARKKINOINTICB1 = new javax.swing.JComboBox<>();
        MARKKINOINTICB2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        THINTA = new javax.swing.JLabel();
        OSTATUOTEBTN = new javax.swing.JButton();
        OSTAMARKKINOINTIBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        AIKA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        BRANDIPALKKI = new javax.swing.JProgressBar();
        TUOTEMAARA = new javax.swing.JTextField();
        OhjeBorder1 = new javax.swing.JPanel();
        PALKATTAVATMYYJAT = new javax.swing.JComboBox<>();
        PALKKA1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        PALKKAAMYYJABTN = new javax.swing.JButton();
        OhjeBorder2 = new javax.swing.JPanel();
        POISTAMYYJABTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        PMyyjat = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        OhjeBorder7 = new javax.swing.JPanel();
        POISTAMARKKINOINTIBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PMarkkinointi = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        OhjeBorder4 = new javax.swing.JPanel();
        OhjeBorder5 = new javax.swing.JPanel();
        OhjeBorder8 = new javax.swing.JPanel();
        Jatka1 = new javax.swing.JLabel();
        Jatka = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        POISTATUOTEBTN = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        POstot = new javax.swing.JTable();
        logi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TAPAHTUMATOUTPUT = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        LOGI = new javax.swing.JTextArea();
        TAKAISINBTN = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ETENEKKBTN = new javax.swing.JButton();
        INPUTPVALB = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jTextField1.setText("jTextField1");

        OhjeBorder6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder6.setEnabled(false);
        OhjeBorder6.setOpaque(false);

        org.jdesktop.layout.GroupLayout OhjeBorder6Layout = new org.jdesktop.layout.GroupLayout(OhjeBorder6);
        OhjeBorder6.setLayout(OhjeBorder6Layout);
        OhjeBorder6Layout.setHorizontalGroup(
            OhjeBorder6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 216, Short.MAX_VALUE)
        );
        OhjeBorder6Layout.setVerticalGroup(
            OhjeBorder6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 96, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Valinnat");
        setBackground(new java.awt.Color(76, 181, 255));
        setForeground(new java.awt.Color(76, 181, 245));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1270, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        REUNUS.setBackground(new java.awt.Color(76, 181, 245));
        REUNUS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        REUNUS.setForeground(new java.awt.Color(12, 143, 27));
        REUNUS.setPreferredSize(new java.awt.Dimension(1085, 529));
        REUNUS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                REUNUSMousePressed(evt);
            }
        });
        REUNUS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OTSIKKO.setBackground(new java.awt.Color(76, 181, 245));
        OTSIKKO.setPreferredSize(new java.awt.Dimension(1025, 123));
        OTSIKKO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OTSIKKOMousePressed(evt);
            }
        });
        OTSIKKO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LAINAT.setForeground(new java.awt.Color(255, 255, 255));
        LAINAT.setText("0.00");
        LAINAT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LAINAT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LAINAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LAINATMousePressed(evt);
            }
        });
        OTSIKKO.add(LAINAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 190, 22));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lainat");
        OTSIKKO.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 22));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Kassa");
        OTSIKKO.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 22));

        KASSA.setForeground(new java.awt.Color(255, 255, 255));
        KASSA.setText("0.0");
        KASSA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(20, 24, 27)));
        KASSA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KASSA.setPreferredSize(new java.awt.Dimension(18, 22));
        KASSA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KASSAMousePressed(evt);
            }
        });
        OTSIKKO.add(KASSA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 190, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(199, 235, 255));
        jLabel11.setText("Paaikkuna - Brandis© Yrityspelisimulaattori v1.0");
        jLabel11.setPreferredSize(new java.awt.Dimension(206, 21));
        OTSIKKO.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 22));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Varasi");
        jLabel29.setPreferredSize(new java.awt.Dimension(35, 22));
        OTSIKKO.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, -1));

        VARAT.setForeground(new java.awt.Color(255, 255, 255));
        VARAT.setText("0.0");
        VARAT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        VARAT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VARAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                VARATMousePressed(evt);
            }
        });
        OTSIKKO.add(VARAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 190, 22));

        Varoitus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Varoitus.setForeground(new java.awt.Color(255, 0, 0));
        OTSIKKO.add(Varoitus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 10, 20));

        sulje.setBackground(new java.awt.Color(76, 181, 255));
        sulje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sulje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buttons/nappi_default.png"))); // NOI18N
        sulje.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        sulje.setOpaque(true);
        sulje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suljeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suljeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suljeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                suljeMouseReleased(evt);
            }
        });
        OTSIKKO.add(sulje, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 45, 21));

        pienenna.setBackground(new java.awt.Color(76, 181, 255));
        pienenna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pienenna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buttons/pienennä.png"))); // NOI18N
        pienenna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pienenna.setOpaque(true);
        pienenna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pienennaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pienennaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pienennaMousePressed(evt);
            }
        });
        OTSIKKO.add(pienenna, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 0, 45, 21));

        VEDA.setBackground(new java.awt.Color(76, 181, 245));
        VEDA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        VEDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                VEDAMousePressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout VEDALayout = new org.jdesktop.layout.GroupLayout(VEDA);
        VEDA.setLayout(VEDALayout);
        VEDALayout.setHorizontalGroup(
            VEDALayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 980, Short.MAX_VALUE)
        );
        VEDALayout.setVerticalGroup(
            VEDALayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 30, Short.MAX_VALUE)
        );

        OTSIKKO.add(VEDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 980, 30));

        jPanel5.setBackground(new java.awt.Color(76, 181, 245));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });
        jPanel5.setLayout(new java.awt.CardLayout());
        OTSIKKO.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, -1));

        MENU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"))); // NOI18N
        MENU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MENU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MENUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                MENUFocusLost(evt);
            }
        });
        MENU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MENUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MENUMouseExited(evt);
            }
        });
        MENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENUActionPerformed(evt);
            }
        });
        OTSIKKO.add(MENU, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 52, 52));

        SLOGAN.setForeground(new java.awt.Color(255, 255, 255));
        SLOGAN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLOGAN.setText("Slogan");
        SLOGAN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SLOGAN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SLOGAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SLOGANKeyPressed(evt);
            }
        });
        OTSIKKO.add(SLOGAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 550, -1));

        YRNIM.setFont(new java.awt.Font("Book Antiqua", 1, 36)); // NOI18N
        YRNIM.setForeground(new java.awt.Color(255, 255, 255));
        YRNIM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YRNIM.setText("Yrityksen Nimi Oy");
        YRNIM.setToolTipText("");
        YRNIM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        YRNIM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        YRNIM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                YRNIMMousePressed(evt);
            }
        });
        OTSIKKO.add(YRNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 550, 50));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("€");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        OTSIKKO.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 10, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("€");
        OTSIKKO.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("€");
        OTSIKKO.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, 20));

        REUNUS.add(OTSIKKO, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 1, 970, 120));

        JT1.setBackground(new java.awt.Color(76, 181, 245));
        JT1.setForeground(new java.awt.Color(255, 255, 255));
        JT1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        JT1.setComponentPopupMenu(jPopupMenu1);
        JT1.setOpaque(true);
        JT1.setPreferredSize(new java.awt.Dimension(1093, 501));

        jPanel1.setForeground(new java.awt.Color(76, 181, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1075, 460));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel1.setLabelFor(PMyyjat);
        jLabel1.setText("Palkattavat myyjät:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 10, 130, 20));

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel2.setText("Ostettavat tuotteet:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 156, -1));

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel3.setText("Markkinointivaihtoehdot:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 10, 211, -1));

        OTUOTE.setEditable(true);
        OTUOTE.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        OTUOTE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Devtuote" }));
        OTUOTE.setFocusable(false);
        jPanel1.add(OTUOTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 120, 25));

        MARKKINOINTICB1.setEditable(true);
        MARKKINOINTICB1.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        MARKKINOINTICB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TV", "Internet" }));
        MARKKINOINTICB1.setFocusable(false);
        MARKKINOINTICB1.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel1.add(MARKKINOINTICB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 50, 130, -1));

        MARKKINOINTICB2.setEditable(true);
        MARKKINOINTICB2.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        MARKKINOINTICB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500.00", "1000.00", "1500.00" }));
        MARKKINOINTICB2.setFocusable(false);
        MARKKINOINTICB2.setPreferredSize(new java.awt.Dimension(49, 25));
        jPanel1.add(MARKKINOINTICB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 50, 80, -1));

        jLabel10.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel10.setText("Myyjä");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel12.setText("Kuukausipalkka");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel16.setText("Tuote");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jLabel17.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel17.setText("Hinta");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel18.setText("Määrä");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 30, -1, -1));

        jLabel20.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel20.setText("Tyyppi");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 28, -1, -1));

        jLabel21.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jLabel21.setText("Hinta");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 28, -1, -1));
        jPanel1.add(THINTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 50, 25));

        OSTATUOTEBTN.setBackground(new java.awt.Color(76, 181, 245));
        OSTATUOTEBTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        OSTATUOTEBTN.setForeground(new java.awt.Color(255, 255, 255));
        OSTATUOTEBTN.setText("Osta");
        OSTATUOTEBTN.setToolTipText("Osta tuote yläpuolella olevilla arvoilla");
        OSTATUOTEBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OSTATUOTEBTNActionPerformed(evt);
            }
        });
        jPanel1.add(OSTATUOTEBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 75, 60, -1));

        OSTAMARKKINOINTIBTN.setBackground(new java.awt.Color(76, 181, 255));
        OSTAMARKKINOINTIBTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        OSTAMARKKINOINTIBTN.setForeground(new java.awt.Color(255, 255, 255));
        OSTAMARKKINOINTIBTN.setText("Ota käyttöön");
        OSTAMARKKINOINTIBTN.setToolTipText("Ostaa markkinoinnin yläpuolella olevilla arvoilla");
        OSTAMARKKINOINTIBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OSTAMARKKINOINTIBTNActionPerformed(evt);
            }
        });
        jPanel1.add(OSTAMARKKINOINTIBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 75, 120, -1));

        jLabel4.setText("€");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, -1, 25));

        jLabel25.setText("€");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 50, -1, 25));

        AIKA.setEditable(false);
        AIKA.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        AIKA.setText("01.01.2018");
        AIKA.setToolTipText("Tämänhetkinen kuukausi");
        AIKA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIKAActionPerformed(evt);
            }
        });
        jPanel1.add(AIKA, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 300, 100, 55));

        jButton1.setBackground(new java.awt.Color(76, 181, 255));
        jButton1.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<<Takaisin alkuun");
        jButton1.setToolTipText("Palaa aloitus näytölle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 320, 150, -1));

        jLabel26.setForeground(new java.awt.Color(51, 102, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icons/question-mark-icon-32516.png"))); // NOI18N
        jLabel26.setText("Ohjeet");
        jLabel26.setToolTipText("Ohjeita yleiseen käyttöön");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.setPreferredSize(new java.awt.Dimension(57, 25));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 320, 70, -1));

        BRANDIPALKKI.setBackground(new java.awt.Color(255, 255, 255));
        BRANDIPALKKI.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BRANDIPALKKI.setForeground(new java.awt.Color(112, 220, 255));
        BRANDIPALKKI.setValue(10);
        BRANDIPALKKI.setRequestFocusEnabled(false);
        BRANDIPALKKI.setStringPainted(true);
        BRANDIPALKKI.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(BRANDIPALKKI, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 300, 704, 10));
        BRANDIPALKKI.getAccessibleContext().setAccessibleDescription("\"Brandi\"");

        TUOTEMAARA.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        TUOTEMAARA.setText("1");
        TUOTEMAARA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TUOTEMAARAFocusLost(evt);
            }
        });
        TUOTEMAARA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TUOTEMAARAKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TUOTEMAARAKeyTyped(evt);
            }
        });
        jPanel1.add(TUOTEMAARA, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 50, 116, 25));

        OhjeBorder1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder1.setEnabled(false);
        OhjeBorder1.setOpaque(false);
        OhjeBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PALKATTAVATMYYJAT.setEditable(true);
        PALKATTAVATMYYJAT.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        PALKATTAVATMYYJAT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PALKATTAVATMYYJAT.setFocusable(false);
        PALKATTAVATMYYJAT.setPreferredSize(new java.awt.Dimension(60, 25));
        OhjeBorder1.add(PALKATTAVATMYYJAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 42, 223, -1));

        PALKKA1.setEditable(true);
        PALKKA1.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        PALKKA1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500.00", "1000.00", "1500.00" }));
        PALKKA1.setFocusable(false);
        OhjeBorder1.add(PALKKA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 42, 90, 25));

        jLabel19.setText("€");
        OhjeBorder1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 42, -1, 25));

        PALKKAAMYYJABTN.setBackground(new java.awt.Color(76, 181, 245));
        PALKKAAMYYJABTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        PALKKAAMYYJABTN.setForeground(new java.awt.Color(255, 255, 255));
        PALKKAAMYYJABTN.setText("Palkkaa");
        PALKKAAMYYJABTN.setToolTipText("Palkkaa myyjän yläpuolella olevilla arvoilla");
        PALKKAAMYYJABTN.setPreferredSize(new java.awt.Dimension(41, 25));
        PALKKAAMYYJABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PALKKAAMYYJABTNActionPerformed(evt);
            }
        });
        OhjeBorder1.add(PALKKAAMYYJABTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 67, 90, -1));

        jPanel1.add(OhjeBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        OhjeBorder2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder2.setEnabled(false);
        OhjeBorder2.setOpaque(false);

        POISTAMYYJABTN.setBackground(new java.awt.Color(76, 181, 255));
        POISTAMYYJABTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        POISTAMYYJABTN.setForeground(new java.awt.Color(255, 255, 255));
        POISTAMYYJABTN.setText("Erota");
        POISTAMYYJABTN.setToolTipText("Erota valittu myyjä");
        POISTAMYYJABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POISTAMYYJABTNActionPerformed(evt);
            }
        });

        PMyyjat.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        PMyyjat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nimi", "Kuukausipalkka"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PMyyjat.setOpaque(false);
        PMyyjat.setRowHeight(18);
        PMyyjat.setSelectionBackground(new java.awt.Color(76, 181, 245));
        PMyyjat.setSelectionForeground(new java.awt.Color(0, 0, 0));
        PMyyjat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PMyyjat.getTableHeader().setReorderingAllowed(false);
        PMyyjat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PMyyjatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PMyyjatFocusLost(evt);
            }
        });
        PMyyjat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PMyyjatKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(PMyyjat);
        if (PMyyjat.getColumnModel().getColumnCount() > 0) {
            PMyyjat.getColumnModel().getColumn(0).setResizable(false);
            PMyyjat.getColumnModel().getColumn(0).setPreferredWidth(150);
            PMyyjat.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel22.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel22.setText("Palkatut myyjät:");

        org.jdesktop.layout.GroupLayout OhjeBorder2Layout = new org.jdesktop.layout.GroupLayout(OhjeBorder2);
        OhjeBorder2.setLayout(OhjeBorder2Layout);
        OhjeBorder2Layout.setHorizontalGroup(
            OhjeBorder2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(OhjeBorder2Layout.createSequentialGroup()
                .add(OhjeBorder2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(POISTAMYYJABTN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 191, Short.MAX_VALUE))
        );
        OhjeBorder2Layout.setVerticalGroup(
            OhjeBorder2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
            .add(OhjeBorder2Layout.createSequentialGroup()
                .add(jLabel22)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(POISTAMYYJABTN)
                .add(16, 16, 16))
        );

        jPanel1.add(OhjeBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 113, -1, 150));

        OhjeBorder7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder7.setEnabled(false);
        OhjeBorder7.setOpaque(false);

        POISTAMARKKINOINTIBTN.setBackground(new java.awt.Color(76, 181, 255));
        POISTAMARKKINOINTIBTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        POISTAMARKKINOINTIBTN.setForeground(new java.awt.Color(255, 255, 255));
        POISTAMARKKINOINTIBTN.setText("Peruuta");
        POISTAMARKKINOINTIBTN.setToolTipText("Peruuta valittu markkinointi");
        POISTAMARKKINOINTIBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POISTAMARKKINOINTIBTNActionPerformed(evt);
            }
        });

        PMarkkinointi.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        PMarkkinointi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tyyppi", "kk menot"
            }
        ));
        PMarkkinointi.setMaximumSize(new java.awt.Dimension(2147483647, 57));
        PMarkkinointi.setMinimumSize(new java.awt.Dimension(30, 57));
        PMarkkinointi.setOpaque(false);
        PMarkkinointi.setRowHeight(18);
        PMarkkinointi.setSelectionForeground(new java.awt.Color(0, 0, 0));
        PMarkkinointi.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(PMarkkinointi);

        jLabel24.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel24.setText("Voimassa olevat markkinoinnit:");

        org.jdesktop.layout.GroupLayout OhjeBorder7Layout = new org.jdesktop.layout.GroupLayout(OhjeBorder7);
        OhjeBorder7.setLayout(OhjeBorder7Layout);
        OhjeBorder7Layout.setHorizontalGroup(
            OhjeBorder7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(OhjeBorder7Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(OhjeBorder7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(OhjeBorder7Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(POISTAMARKKINOINTIBTN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 220, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        OhjeBorder7Layout.setVerticalGroup(
            OhjeBorder7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(OhjeBorder7Layout.createSequentialGroup()
                .add(jLabel24)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE)
                .add(POISTAMARKKINOINTIBTN)
                .addContainerGap())
        );

        jPanel1.add(OhjeBorder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 115, 213, 150));

        OhjeBorder4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder4.setEnabled(false);
        OhjeBorder4.setOpaque(false);
        OhjeBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(OhjeBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 10, -1, -1));

        OhjeBorder5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder5.setEnabled(false);
        OhjeBorder5.setOpaque(false);
        OhjeBorder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(OhjeBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 117, -1, -1));

        OhjeBorder8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        OhjeBorder8.setEnabled(false);
        OhjeBorder8.setOpaque(false);

        org.jdesktop.layout.GroupLayout OhjeBorder8Layout = new org.jdesktop.layout.GroupLayout(OhjeBorder8);
        OhjeBorder8.setLayout(OhjeBorder8Layout);
        OhjeBorder8Layout.setHorizontalGroup(
            OhjeBorder8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 76, Short.MAX_VALUE)
        );
        OhjeBorder8Layout.setVerticalGroup(
            OhjeBorder8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 57, Short.MAX_VALUE)
        );

        jPanel1.add(OhjeBorder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, -1, -1));

        Jatka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_default.png"))); // NOI18N
        Jatka1.setToolTipText("Jatka tapahtumat osioon.");
        Jatka1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jatka1.setEnabled(false);
        Jatka1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Jatka1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Jatka1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Jatka1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Jatka1MouseReleased(evt);
            }
        });
        jPanel1.add(Jatka1, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 300, 60, -1));

        Jatka.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_default.png"))); // NOI18N
        Jatka.setToolTipText("Jatka tapahtumat osioon.");
        Jatka.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jatka.setEnabled(false);
        Jatka.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JatkaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JatkaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JatkaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JatkaMouseReleased(evt);
            }
        });
        jPanel1.add(Jatka, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 300, 50, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        POISTATUOTEBTN.setBackground(new java.awt.Color(76, 181, 255));
        POISTATUOTEBTN.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        POISTATUOTEBTN.setForeground(new java.awt.Color(255, 255, 255));
        POISTATUOTEBTN.setText("Poista myynnistä");
        POISTATUOTEBTN.setToolTipText("Heitä valittu tuote roskiin");
        POISTATUOTEBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POISTATUOTEBTNActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel23.setText("Myymättömät tuotteet:");

        POstot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nimi", "Ostohinta", "Maara", "Myyntihinta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        POstot.getTableHeader().setReorderingAllowed(false);
        POstot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                POstotMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(POstot);
        if (POstot.getColumnModel().getColumnCount() > 0) {
            POstot.getColumnModel().getColumn(0).setResizable(false);
            POstot.getColumnModel().getColumn(0).setPreferredWidth(100);
            POstot.getColumnModel().getColumn(1).setResizable(false);
            POstot.getColumnModel().getColumn(2).setResizable(false);
            POstot.getColumnModel().getColumn(3).setResizable(false);
        }

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel23)
                            .add(POISTATUOTEBTN))
                        .add(0, 143, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel23)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(POISTATUOTEBTN)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 115, -1, 150));

        logi.setEditable(false);
        jPanel1.add(logi, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 265, 870, 25));

        JT1.addTab("Valinnat", null, jPanel1, "");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setNextFocusableComponent(jPanel1);
        jPanel4.setPreferredSize(new java.awt.Dimension(1088, 376));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TAPAHTUMATOUTPUT.setEditable(false);
        TAPAHTUMATOUTPUT.setColumns(20);
        TAPAHTUMATOUTPUT.setRows(5);
        jScrollPane4.setViewportView(TAPAHTUMATOUTPUT);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 480, 262));

        LOGI.setEditable(false);
        LOGI.setColumns(20);
        LOGI.setRows(5);
        jScrollPane5.setViewportView(LOGI);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 440, 262));

        TAKAISINBTN.setText("<<Palaa valintoihin");
        TAKAISINBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAKAISINBTNActionPerformed(evt);
            }
        });
        jPanel4.add(TAKAISINBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 27));

        jLabel27.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel27.setText("Tekemäsi valinnat");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, 423, 26));

        jLabel28.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel28.setText("Tapahtumat");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 458, 26));

        ETENEKKBTN.setText("Etene kuukausi");
        ETENEKKBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETENEKKBTNActionPerformed(evt);
            }
        });
        jPanel4.add(ETENEKKBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 130, -1));

        INPUTPVALB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        INPUTPVALB.setText("1.1.2018");
        jPanel4.add(INPUTPVALB, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 60, 20));

        JT1.addTab("Tapahtumat", jPanel4);

        REUNUS.add(JT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 959, 400));

        getContentPane().add(REUNUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     private void TAKAISINBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAKAISINBTNActionPerformed
      try {
          ETENEKKBTN.setEnabled(false);
          Connection con = jd.getConnection();
          System.out.println("Con 7");
          Statement stm = con.createStatement();
          if(Double.parseDouble(KASSA.getText()) < 0){//Jos pelaajan kassa on alle 0 ilmoitetaan pelaajalle varoitus
              double laina = Double.parseDouble(KASSA.getText());
              laina = laina - laina -laina;
              String[] options = new String[] {"Lainaa", "Lopeta peli"};
              int response = JOptionPane.showOptionDialog(null, "Olet velkaantunut, ota lainaa "+laina+"€ tai lopeta peli", "Varoitus",
                      JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
              if(response == 0){//jos pelaaja valitsee kyllä, ohjelma ottaa lainaa
                  double vanhalaina = 0.0;
                  ResultSet rs =stm.executeQuery("Select *from pelaajat where nimi='"+YRNIMI+"'");
                  while(rs.next()){
                      vanhalaina = rs.getDouble("lainat");
                  }
                  con.close();
                  jd.putData("UPDATE pelaajat set kassa ="+0+" where nimi ='"+YRNIMI+"'");
                  paivita();
                  laina = laina + vanhalaina;
                  laina = roundaaD(laina);
                  LAINAT.setText(String.valueOf(roundaaS(laina)));
                  jd.putData("UPDATE pelaajat set lainat = "+laina+" where nimi = '"+YRNIMI+"'");
              }else{//Jos pelaaja valitsee lopeta peli, ohjelma poistaa kaikki pelaajan tiedot sql kannoista 
                  con.close();
                  jd.putData("delete from tilastot where yrnim='"+YRNIMI+"'");
                  jd.putData("delete from tallennus where pnimi='"+YRNIMI+"'");
                  jd.putData("delete from PMyyja");
                  jd.putData("delete from PTuote");
                  jd.putData("delete from pelaajat where nimi='"+YRNIMI+"'");
                  jd.putData("delete from TMtilastot where yrnim='"+YRNIMI+"'");
                  this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                  
              }
          }
          con.close();
          if(Painettu){//Jos pelaaja on edennyt kuukauden, resetoidaan logi ja tapahtumaoutput
          TAPAHTUMATOUTPUT.setText("");
          LOGI.setText("");
          Painettu = false;
          }
          JT1.setSelectedIndex(0);
          JT1.setEnabledAt(0, true);
          JT1.setEnabledAt(1, false);
          T.dispose();
          setFrame();
          PmyyjaEstot = false;
      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
      }

     }//GEN-LAST:event_TAKAISINBTNActionPerformed

     private void ETENEKKBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ETENEKKBTNActionPerformed
          try {//avaa tilastot ikkunan ja kutsuu methodia
              PmyyjaEstot = true;
              
               
               if(!T.isShowing()){
               T = new j4a_Tilastot(YRNIMI, this);    
               
               T.setVisible(true);
               
               this.setLocation(this.getX()-231, this.getY());
               T.setLocation(this.getX() +this.getWidth(), this.getY());
               
               }
              
               tapahtunutmyynti = 0.0;
               KKloop();//Methodi jossa tehdään kuukauden eteneminen
               Opastus(false,false,false,false,true);

          } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_ETENEKKBTNActionPerformed

     private void JatkaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JatkaMouseReleased
          ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_default.png"));
          Jatka.setIcon(PlusIcon);
     }//GEN-LAST:event_JatkaMouseReleased

     private void JatkaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JatkaMousePressed
          try {

               jatka();
               Opastus(false,false,false,true,false);
          } catch (ClassNotFoundException | SQLException | InterruptedException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_JatkaMousePressed

     private void JatkaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JatkaMouseExited
          ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_default.png"));
          Jatka.setIcon(PlusIcon);
          Jatka1.setIcon(PlusIcon);
     }//GEN-LAST:event_JatkaMouseExited

     private void JatkaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JatkaMouseEntered
          ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_hover.png"));
          Jatka.setIcon(PlusIcon);
          Jatka1.setIcon(PlusIcon);
     }//GEN-LAST:event_JatkaMouseEntered

     private void Jatka1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jatka1MouseReleased
         
     }//GEN-LAST:event_Jatka1MouseReleased

     private void Jatka1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jatka1MousePressed
          try {
               jatka();
               Opastus(false,false,false,true,false);
          } catch (ClassNotFoundException | SQLException | InterruptedException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_Jatka1MousePressed

     private void Jatka1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jatka1MouseExited
          ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_default.png"));
          Jatka.setIcon(PlusIcon);
          Jatka1.setIcon(PlusIcon);
     }//GEN-LAST:event_Jatka1MouseExited

     private void Jatka1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jatka1MouseEntered
          ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/right_arrow_hover.png"));
          Jatka.setIcon(PlusIcon);
          Jatka1.setIcon(PlusIcon);
     }//GEN-LAST:event_Jatka1MouseEntered

     private void TUOTEMAARAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TUOTEMAARAFocusLost
          //Tarkistaa onko TUOTEMAARAssa olevat tiedot oikeassa muodossa
         int test;

          try{
               test = 	Integer.parseInt(TUOTEMAARA.getText());
          }
          catch(NumberFormatException e){
               TUOTEMAARA.setText("0");
          }

          if(TUOTEMAARA.getText().equals("")){
               TUOTEMAARA.setText("0");
          }
     }//GEN-LAST:event_TUOTEMAARAFocusLost

     private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
          jLabel26.setForeground(new Color(51, 102, 255));
     }//GEN-LAST:event_jLabel26MouseExited

     private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
          jLabel26.setForeground(new Color(93, 160, 255));
     }//GEN-LAST:event_jLabel26MouseEntered

     private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
          Ohje o = new Ohje();
          o.setLocationRelativeTo(null);
          o.setVisible(true);
     }//GEN-LAST:event_jLabel26MouseClicked

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
          taaksep = true;
          SuljePeli();
      } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
          Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
      }
     }//GEN-LAST:event_jButton1ActionPerformed

     private void AIKAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIKAActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_AIKAActionPerformed

     private void POISTATUOTEBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POISTATUOTEBTNActionPerformed
        try {//Poistaa tuotteen jtablesta ja sqlästä                                           
            System.out.println("delete is pressed");
            Connection con = jd.getConnection();
            System.out.println("Con 9");
            Statement stm = con.createStatement();
                                  
            int row = POstot.getSelectedRow();//Hankkii valitun rivin myyjä tablesta
                                  
            if(row == -1){//jos riviä ei ole valittu, ohjelma valittaa
               JOptionPane.showMessageDialog(null, "Valitse ensin rivi, jonka haluat poistaa!");
               con.close();
            }
            else{
                Object myyntihinta = POstot.getValueAt(row, 1);
                Object nimi = POstot.getValueAt(row, 0);
                DefaultTableModel m = (DefaultTableModel)POstot.getModel();
                System.out.println(nimi);
                                          
                ResultSet rs = stm.executeQuery("select * from pelaajat where nimi = '"+YRNIMI+"'");
               
                m.removeRow(row);//Poistaa valitun rivin tablesta
                LOGI.append("\n<Tuote " +nimi.toString()+ " on peruutettu.");
                rs = stm.executeQuery("select * from PTuote");
                int tuotem =  0;
                while(rs.next()){//selvittää miten monta tuotetta pelaajalla on
                      tuotem++;
                      System.out.println(rs.getString("nimi"));
                }
                jd.putData("DELETE FROM PTuote WHERE nimi='"+nimi+"'");
                if(tuotem == 0){
                      System.out.println("Pelaajalla ei ole yhtään nimikkeitä!");
                }

                con.close();
            }
            paivita();
            System.out.println("Row countti "+POstot.getRowCount());
            if(POstot.getRowCount() != 0){//Tarkistaa onko pelaajalla tuotteita, jos on niin asetetaan Jatka nappi päälle
                Jatka.setEnabled(true);
                Jatka1.setEnabled(true);
            }
            else{//jos ei niin sammutetaan Jatka nappi
                Jatka.setEnabled(false);
                Jatka1.setEnabled(false);
            }
        
        
        bol = true;
     }catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
     }
     }//GEN-LAST:event_POISTATUOTEBTNActionPerformed

     private void POISTAMARKKINOINTIBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POISTAMARKKINOINTIBTNActionPerformed
          try {//Poistaa markkinoinnin Jtablesta sekä sqlästä
              
               Connection con = jd.getConnection();
               System.out.println("Con 10");
               Statement stm = con.createStatement();

               int row = PMarkkinointi.getSelectedRow();//Hankkii valitun rivin myyjä tablesta
               if(row == -1){//Jos riviä ei ole valittu, ohjelma valittaa
                    JOptionPane.showMessageDialog(null, "Valitse ensin rivi, jonka haluat poistaa!");
                    con.close();
               }
               else{
                    Object maara = PMarkkinointi.getValueAt(row, 1);
                    Object tyyppi = PMarkkinointi.getValueAt(row, 0);

                    DefaultTableModel m = (DefaultTableModel)PMarkkinointi.getModel();

                    PreparedStatement ps = con.prepareStatement("DELETE FROM markkinointi WHERE markkinointityyppi='"+tyyppi+"' AND hinta='"+maara+"'");
                    LOGI.append("\n<Markkinointi +" +tyyppi+ " on peruutettu.");
                    m.removeRow(row);//Poistaa rivin myyjä tablesta
                    ps.executeUpdate();//Poistaa myyjän SQL-kannasta
                    con.close();
               }
          con.close();
          } catch (SQLException | ClassNotFoundException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_POISTAMARKKINOINTIBTNActionPerformed

     private void OSTAMARKKINOINTIBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OSTAMARKKINOINTIBTNActionPerformed
          try {//Lisää makkinoinnin Jtableen ja sqlään
              
               Opastus(false,false,true,false,false);
               
               double summa = Double.parseDouble(String.valueOf(MARKKINOINTICB2.getSelectedItem()));
               Connection con = jd.getConnection();
               System.out.println("Con 11");
               Statement stm = con.createStatement();
               String valittu = MARKKINOINTICB1.getSelectedItem().toString();
               ResultSet rs = stm.executeQuery("select * from pelaajat where nimi='"+YRNIMI+"'");
               boolean poistam = false;
               if(rs.next()){// jos pelaajalla on markkinointia, poistetaan se
                   if(rs.getDouble("markkinointi")>0){
                   poistam = true;
                   }
               }
               con.close();
               if(poistam){
                   jd.putData("delete from markkinointi");
               }
               
               jd.putData("UPDATE pelaajat SET markkinointi = "+summa+" WHERE nimi='"+YRNIMI+"'");//Päivittää markkinoinnin sqlään
               LOGI.append("\n>Markkinointi " +valittu+ " ostettu hinnalla " +summa + "€");
               jd.putData("insert into markkinointi(markkinointityyppi,hinta)values ('"+valittu+"', "+summa+")");
               
               paivita();
          } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_OSTAMARKKINOINTIBTNActionPerformed

     private void OSTATUOTEBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OSTATUOTEBTNActionPerformed
          //Lisätään tuote jtableen ja sqlään
         try {
            System.out.println("Poistetaan välit "+poistav(KASSA.getText()));
            if(Double.parseDouble(poistav(KASSA.getText())) < 0 || Double.valueOf(TUOTEMAARA.getText()) *  Double.valueOf(THINTA.getText()) > Double.parseDouble(poistav(KASSA.getText()))){
                JOptionPane.showMessageDialog(null, "Sinulla ei ole varaa!");
            }
            else{
                valittutuote = OTUOTE.getSelectedItem();
                OstaTuote();
                logi.setText("Ka-ching! Nimike "+POstot.getValueAt(POstot.getRowCount()-1,0)+" lisätty määrällä " + POstot.getValueAt(POstot.getRowCount()-1,2));
                LOGI.append("\n>Nimike "+POstot.getValueAt(POstot.getRowCount()-1,0)+" lisätty määrällä " + POstot.getValueAt(POstot.getRowCount()-1,2));
                addTableListener();
                EmptyLog();
                tarkistaKassa();
                Opastus(false,true,false,false,false);}
          } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_OSTATUOTEBTNActionPerformed

     private void PALKKAAMYYJABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PALKKAAMYYJABTNActionPerformed
          try {
              PmyyjaEstot = true;
               PalkkaaiMyyja();
              PmyyjaEstot = false; 
               
               Opastus(true,false,false,false,false);
          } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_PALKKAAMYYJABTNActionPerformed
     
     public void MenuIsShown(JPopupMenu menu){
         if(menu.isShowing()){//Jos MENU napia on painettu
             ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/menu_button_pressed.png"));
             MENU.setIcon(PlusIcon);
          }
     }
     
     private void LAINATMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LAINATMousePressed
        this.setEnabled(false);
         try {//Jos lainaa on painettu, aKas eli toiminto on 2
               kas = 2;
               KASSA.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
               LAINAT.setBorder(BorderFactory.createLineBorder(Color.GREEN));

               j4_Siirrä frame = new j4_Siirrä(this, Double.valueOf(KASSA.getText()), Double.valueOf(LAINAT.getText()), YRNIMI, kas);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
          } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
          }
     }//GEN-LAST:event_LAINATMousePressed

     private void TUOTEMAARAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TUOTEMAARAKeyPressed
        if(evt.getKeyCode() == (KeyEvent.VK_ENTER)){//Kuuntelee jos enteriä tai 0 on painettu
            System.out.println("Enter painettu");
            OSTATUOTEBTN.doClick();
	}
        if(evt.getKeyCode() == (KeyEvent.VK_0)){
            System.out.println("Nolla painettu");
            String pituus = TUOTEMAARA.getText();
        }								
     }//GEN-LAST:event_TUOTEMAARAKeyPressed

    private void suljeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suljeMouseEntered
        //Vaihtaa iconin väriä jos hiiri on sen päällä
        ImageIcon icon = new ImageIcon(getClass().getResource("/Img/Buttons/nappi.png"));
        sulje.setIcon(icon);
        sulje.setBackground(new Color(232,17,35));

    }//GEN-LAST:event_suljeMouseEntered

    private void suljeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suljeMouseExited
        //Vaihtaa iconin väriä jos hiiri lähtee sen päältä
        ImageIcon icon = new ImageIcon(getClass().getResource("/Img/Buttons/nappi_default.png"));
        sulje.setIcon(icon);

        sulje.setBackground(new Color(76,181,245));

    }//GEN-LAST:event_suljeMouseExited

    private void pienennaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pienennaMouseEntered
        ImageIcon icon = new ImageIcon(getClass().getResource("/Img/Buttons/pienennä_hover.png"));
        pienenna.setIcon(icon);
        pienenna.setBackground(new Color(168,225,255));
    }//GEN-LAST:event_pienennaMouseEntered

    private void pienennaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pienennaMouseExited
        ImageIcon icon = new ImageIcon(getClass().getResource("/Img/Buttons/pienennä.png"));
        pienenna.setIcon(icon);
        pienenna.setBackground(new Color(76,181,245));
    }//GEN-LAST:event_pienennaMouseExited

    private void suljeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suljeMouseReleased
      try {//Sulkee ohjelman
          taaksep  = false;
          SuljePeli();
          ImageIcon icon = new ImageIcon(getClass().getResource("/Img/Buttons/nappi_default.png"));
          sulje.setIcon(icon);
          sulje.setBackground(new Color(76,181,245));
      } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
          Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }//GEN-LAST:event_suljeMouseReleased

    private void pienennaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pienennaMousePressed
        this.setState(j3_Paaikkuna.ICONIFIED);
    }//GEN-LAST:event_pienennaMousePressed

    private void POstotMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POstotMousePressed
        //Jos POstot tablea klikkaa
        DefaultTableModel model = (DefaultTableModel)POstot.getModel();
        int col = POstot.getSelectedColumn();
        int row = POstot.getSelectedRow();
     
    
        POstot =(JTable) evt.getSource();
        
        if (evt.getClickCount() == 2 && POstot.getSelectedRow() != -1) {//Jos tablea on klikattu 2 kertaa ja rivi on valittu
            if(col == 3){//Jos valittu rivi on 3
                System.out.println("POstot riviä painettu");
            try{//Yrittää tyhjentää solun
                JTextField tx = (JTextField)POstot.getEditorComponent();
                tx.setText("");
            }catch(Exception ex){
                System.out.println("Ei komponenttia");
            }
            }
           
        }

    }//GEN-LAST:event_POstotMousePressed

    private void REUNUSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REUNUSMousePressed
       MENU.setSelected(false);
        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
         MENU.setIcon(Icon);
    }//GEN-LAST:event_REUNUSMousePressed

    private void VEDAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VEDAMousePressed
        ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
         MENU.setIcon(PlusIcon);
    }//GEN-LAST:event_VEDAMousePressed

    private void TUOTEMAARAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TUOTEMAARAKeyTyped
     //Virheen esto väärille kirjaimille
      char c = evt.getKeyChar();
                
      if (!Character.isLetterOrDigit(c)){//Jos syötetty arvo ei ole kirjain
            evt.consume();//se poistetaan
      }
      try{//Yrittää muuttaa syötettyä arvoa numeroksi
          Integer.parseInt(String.valueOf(c));
      }catch(NumberFormatException ex){//Jos ei onnistu
          evt.consume();//se poistetaan
      }
      if(TUOTEMAARA.getText().length() == 0){//Estää käyttäjää ostamasta nolla tuotetta
        if(String.valueOf(c).equals("0")){
           evt.consume();
           TUOTEMAARA.setText("");
        }
      } 
    }//GEN-LAST:event_TUOTEMAARAKeyTyped

    private void suljeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suljeMousePressed
       for (Component cp : this.getContentPane().getComponents() ){
           this.setEnabled(true);
        cp.setEnabled(false);
        }
        ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/nappi_default.png"));
        sulje.setIcon(PlusIcon);
        sulje.setBackground(new Color(76,181,245));
        
    }//GEN-LAST:event_suljeMousePressed

    private void MENUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENUMouseEntered
        if(!MENU.isSelected()){
            ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/menu_button_hover.png"));
            MENU.setIcon(PlusIcon);
        }
        else{
            
        }
    }//GEN-LAST:event_MENUMouseEntered

    private void MENUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENUMouseExited
        if(!menu.isShowing()){
            ImageIcon PlusIcon = new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
            MENU.setIcon(PlusIcon);
        }
    }//GEN-LAST:event_MENUMouseExited

    private void MENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENUActionPerformed
        //Methodi jossa lisätään menun sisältö ja näytetään se
        if(MENU.isSelected()){//Jos MENUa klikataan
            ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button_pressed.png"));
            MENU.setIcon(Icon);
            if(!menu.isShowing()){//Jos menu ei ole näkyvillä
                menu = new JPopupMenu() {
                @Override
                public void paintComponent(final Graphics g) {
                    g.setColor(Color.WHITE);
                    g.fillRect(0,0,getWidth(), getHeight());
                }
                };
         
                System.out.println("Menua painettu");	
      
                JMenuItem m1,m2,m3, m4, m5, m6, m7, m8; //Alustaa menu itemit

                m3=new JMenuItem(new AbstractAction("Hyväntekeväisyys"){// Lisää itemille tapahtuman
                    
                @Override
                public void actionPerformed(ActionEvent e) {//Avaa Hyvantekevaisyys framen jos klikattu
                    j4c_Hyvantekevaisyys HT = new j4c_Hyvantekevaisyys(YRNIMI);
                    HT.setBackground(new Color(76, 181, 245));
                    HT.setLocationRelativeTo(null);
                    HT.pack();
                    HT.setVisible(true);
                    MENU.setSelected(false);
                    ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
                    MENU.setIcon(Icon);
                }
                });
                
                m2=new JMenuItem(new AbstractAction("Kuukauden kertymä"){// Lisää itemille tapahtuman

                @Override
                public void actionPerformed(ActionEvent e) {//Avaa Tilastot framen jos klikattu
                    try {
                      if(!T.isShowing()){//Jos tilastot eivät ole näkyvillä
                        
                         T = new j4a_Tilastot(YRNIMI, ji);    
                         T.setLocationRelativeTo(null);
                         T.setVisible(true);
                         T.toFront();
                      }
                      tilastotavattu = true;
                      MENU.setSelected(false);
                      ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
                      MENU.setIcon(Icon);
                    } catch (ClassNotFoundException | SQLException ex) {
                         Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                });
          
                menu.addFocusListener(new java.awt.event.FocusAdapter() {
   
                @Override
                public void focusLost(java.awt.event.FocusEvent evt) {
         
                }
                
                @Override
                public void focusGained(java.awt.event.FocusEvent evt) {
                System.out.println("Menu on focusittu");
                }
                });
          
                m4=new JMenuItem(new AbstractAction("Tekijät"){// Lisää itemille tapahtuman

                @Override
                public void actionPerformed(ActionEvent e) {try {
                    //Avaa CREDITS framen jos klikattu
                    Tekijat TIT = new Tekijat();
                    TIT.setAlwaysOnTop(true);
                    TIT.setLocationRelativeTo(null);																		
                    TIT.setVisible(true);
                    MENU.setSelected(false);
                    ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
                    MENU.setIcon(Icon);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                    }
																				
                }
                });
		
		
		m6=new JMenuItem(new AbstractAction("Tietoa"){// Lisää itemille tapahtuman

                @Override
                public void actionPerformed(ActionEvent e) {
                    MENU.setSelected(false);
                    ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
                    MENU.setIcon(Icon);
		}
                });
                
                m7=new JMenuItem(new AbstractAction("Vuoden kertymä"){// Lisää itemille tapahtuman

                @Override
                public void actionPerformed(ActionEvent e) {//Avaa Kertyma framen jos klikattu
                    try {																	
                        j4b_Kertyma k = new j4b_Kertyma(YRNIMI, ji);
                        k.setVisible(true);
                        k.setLocationRelativeTo(null);
                        MENU.setSelected(false);
                        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
                        MENU.setIcon(Icon);
                   } catch (ClassNotFoundException | SQLException ex) {
                       Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                   }
																				
                }
                });     
           
                m8=new JMenuItem(new AbstractAction("Pankki"){// Lisää itemille tapahtuman

                @Override
                public void actionPerformed(ActionEvent e) {//Avaa Pankki framen jos klikattu
                    j4p_Pankki p = new j4p_Pankki(YRNIMI, ji);
                    p.setVisible(true);
                    p.setLocationRelativeTo(null);
                    MENU.setSelected(false);
                    ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
                    MENU.setIcon(Icon);																	
                }
                }); 
          
                menu.add(m2);//Lisää kaikki itemit menuun
                menu.add(m7);
                menu.add(m8);
                menu.add(m3);
                //menu.add(m6);
                menu.add(m4);

                Component b=(Component)evt.getSource();
						
                Point p=b.getLocationOnScreen();
          
                menu.show(this,0,0);

                menu.setLocation(p.x-83,p.y+1+b.getHeight());
            
            
            
        }}
        else{
            if(menu.isShowing()){  //Piilottaa menun
                ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button_pressed.png"));
                MENU.setIcon(Icon);
                menu.hide();
            }
        }
        
        
    }//GEN-LAST:event_MENUActionPerformed

    private void OTSIKKOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OTSIKKOMousePressed
        //Jos MENUsta klikkaa pois, ohjelma vaihtaa MENUn normaaliksi
        MENU.setSelected(false);
        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
         MENU.setIcon(Icon);
   
    }//GEN-LAST:event_OTSIKKOMousePressed

    private void MENUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MENUFocusGained
     
    }//GEN-LAST:event_MENUFocusGained

    private void MENUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MENUFocusLost
         
    }//GEN-LAST:event_MENUFocusLost

    private void KASSAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KASSAMousePressed
        //Jos kassaa on painettu, aKas eli toiminto on 1
        this.setEnabled(false);
        try {
          KASSA.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
          VARAT.setBorder(BorderFactory.createLineBorder(Color.GREEN));
          kas = 1;
          j4_Siirrä frame = new j4_Siirrä(this, Double.valueOf(VARAT.getText()), Double.valueOf(KASSA.getText()), YRNIMI, kas);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_KASSAMousePressed

    private void VARATMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VARATMousePressed
        //Jos varoja on painettu, aKas eli toiminto on 0
        this.setEnabled(false);
        try {
          VARAT.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
          KASSA.setBorder(BorderFactory.createLineBorder(Color.GREEN));
          kas = 0;
          j4_Siirrä frame = new j4_Siirrä(this, Double.valueOf(VARAT.getText()), Double.valueOf(KASSA.getText()), YRNIMI, kas);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
      }

         
    }//GEN-LAST:event_VARATMousePressed

    private void YRNIMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YRNIMMousePressed
        //Jos MENUsta klikkaa pois, ohjelma vaihtaa MENUn normaaliksi
        MENU.setSelected(false);
        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
        MENU.setIcon(Icon);
    }//GEN-LAST:event_YRNIMMousePressed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        //Jos MENUsta klikkaa pois, ohjelma vaihtaa MENUn normaaliksi
        MENU.setSelected(false);
        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
         MENU.setIcon(Icon);
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        //Jos MENUsta klikkaa pois, ohjelma vaihtaa MENUn normaaliksi
        MENU.setSelected(false);
        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
         MENU.setIcon(Icon);
         if(POstot.isEditing()){
         POstot.getCellEditor().stopCellEditing();
         }
         
    }//GEN-LAST:event_jPanel1MousePressed

    private void PMyyjatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PMyyjatKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_DELETE){
        }
    }//GEN-LAST:event_PMyyjatKeyTyped

    private void PMyyjatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PMyyjatFocusLost

    }//GEN-LAST:event_PMyyjatFocusLost

    private void PMyyjatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PMyyjatFocusGained
        //Jos PMyyjat tablea klikkaa
        try {//Ohjelma päivittää myyjät sql kantaan
            System.out.println("PMyyjat päivittyy PMyyjat jTableen muutetulla arvolla");
            System.out.println("Focus gained");
            int rivi = PMyyjat.getSelectedRow();
            jd.putData("update PMyyja set palkka = "+removeLastChar(PMyyjat.getValueAt(rivi, 1).toString())+" where nimi='"+PMyyjat.getValueAt(rivi, 0).toString()+"'");
            if(PMyyjat.getValueAt(rivi, 0).toString().equals("Omistaja")){
                jd.putData("update pelaajat set palkka="+removeLastChar(PMyyjat.getValueAt(rivi, 1).toString())+" where nimi ='"+YRNIMI+"'");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PMyyjatFocusGained

    private void POISTAMYYJABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POISTAMYYJABTNActionPerformed
        //Poistaa myyjän Jtablesta ja sql kannasta
        try {
            int row = PMyyjat.getSelectedRow();//Hankkii valitun rivin myyjä tablesta
            if(row == -1){//Jos riviä ei ole valittu,ohjelma valittaa
                JOptionPane.showMessageDialog(null, "Valitse ensin rivi, jonka haluat poistaa!");
            }
            else{
            PmyyjaEstot = true;
            if(!PMyyjat.getValueAt(PMyyjat.getSelectedRow(),0).equals("Omistaja")){//Jos valittu myyjä ei ole omistaja
                PALKATTAVATMYYJAT.setEnabled(true);//Asetetaan comboboxit ja nappi päälle
                PALKKAAMYYJABTN.setEnabled(true);
                PALKKA1.setEnabled(true);
                PALKATTAVATMYYJAT.removeItem("Ei myyjiä!");
            }
            
            Connection con = jd.getConnection();
            System.out.println("Con 8");
            Statement stm = con.createStatement();

            Object palkka = PMyyjat.getValueAt(row, 1);
            Object nimi = PMyyjat.getValueAt(row, 0);

            DefaultTableModel m = (DefaultTableModel)PMyyjat.getModel();
            if(!nimi.equals("Omistaja")){//Jos valittu myyjä ei ole omistaja
                PreparedStatement ps = con.prepareStatement("DELETE FROM pmyyja WHERE nimi='"+nimi+"'");
                ps.executeUpdate();//Poistaa myyjän SQL-kannasta
                LOGI.append("\n<Myyjä " +nimi+ " on erotettu.");
                jd.putData("insert into myyja(nimi,palkka)values ('"+nimi.toString()+"', '"+palkka+"')");
                m.removeRow(row);//Poistaa rivin myyjä tablesta
                PALKATTAVATMYYJAT.addItem(nimi.toString());//Palauttaa myyjan jComboBoxiin
             }
             else{//Ohjelma valittaa
                JOptionPane.showMessageDialog(null, "ET VOI POISTAA ITSEÄSI!");
             }
             con.close();
             paivita();
             PmyyjaEstot = false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_POISTAMYYJABTNActionPerformed

    private void SLOGANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SLOGANKeyPressed
        //Jos MENUsta klikkaa pois, ohjelma vaihtaa MENUn normaaliksi
        MENU.setSelected(false);
        ImageIcon Icon= new ImageIcon(getClass().getResource("/Img/Buttons/menu_button.png"));
        MENU.setIcon(Icon);
    }//GEN-LAST:event_SLOGANKeyPressed



				
				
 static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        //Tarkistaa onko Arraylistissä kopioita
        ArrayList<String> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

       
        list.stream().filter((item) -> (!set.contains(item))).map((item) -> {
            result.add(item);
          return item;
      }).forEachOrdered((item) -> {
          set.add(item);
      });
        return result;
    }
 
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
                if ("Windowsl".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(j4a_Tilastot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
									
    
        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            try {
                new j3_Paaikkuna().setVisible(true);
            } catch (SQLException | ClassNotFoundException |                InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AIKA;
    public static javax.swing.JProgressBar BRANDIPALKKI;
    private javax.swing.JButton ETENEKKBTN;
    private javax.swing.JLabel INPUTPVALB;
    public static javax.swing.JTabbedPane JT1;
    private javax.swing.JLabel Jatka;
    private javax.swing.JLabel Jatka1;
    public javax.swing.JLabel KASSA;
    public javax.swing.JLabel LAINAT;
    public static javax.swing.JTextArea LOGI;
    private javax.swing.JComboBox<String> MARKKINOINTICB1;
    private javax.swing.JComboBox<String> MARKKINOINTICB2;
    private javax.swing.JToggleButton MENU;
    private javax.swing.JButton OSTAMARKKINOINTIBTN;
    private javax.swing.JButton OSTATUOTEBTN;
    private javax.swing.JPanel OTSIKKO;
    private javax.swing.JComboBox<String> OTUOTE;
    private javax.swing.JPanel OhjeBorder1;
    private javax.swing.JPanel OhjeBorder2;
    private javax.swing.JPanel OhjeBorder4;
    private javax.swing.JPanel OhjeBorder5;
    private javax.swing.JPanel OhjeBorder6;
    private javax.swing.JPanel OhjeBorder7;
    private javax.swing.JPanel OhjeBorder8;
    private javax.swing.JComboBox<String> PALKATTAVATMYYJAT;
    private javax.swing.JComboBox<String> PALKKA1;
    private javax.swing.JButton PALKKAAMYYJABTN;
    private javax.swing.JTable PMarkkinointi;
    private javax.swing.JTable PMyyjat;
    private javax.swing.JButton POISTAMARKKINOINTIBTN;
    private javax.swing.JButton POISTAMYYJABTN;
    private javax.swing.JButton POISTATUOTEBTN;
    public static javax.swing.JTable POstot;
    private javax.swing.JPanel REUNUS;
    public static javax.swing.JLabel SLOGAN;
    private javax.swing.JButton TAKAISINBTN;
    private javax.swing.JTextArea TAPAHTUMATOUTPUT;
    private javax.swing.JLabel THINTA;
    public static javax.swing.JTextField TUOTEMAARA;
    public javax.swing.JLabel VARAT;
    private javax.swing.JPanel VEDA;
    private javax.swing.JLabel Varoitus;
    public static javax.swing.JLabel YRNIM;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField logi;
    private javax.swing.JLabel pienenna;
    private javax.swing.JLabel sulje;
    // End of variables declaration//GEN-END:variables



private void Roll() throws ClassNotFoundException, SQLException, InterruptedException {
	//Tulostaa tietoja TAPAHTUMAOUTPUT areaan
        Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 12");
	Statement stm = con.createStatement();
	TAPAHTUMATOUTPUT.setText("----------Valintasi-----------------\n");
	ResultSet rs = stm.executeQuery("SELECT * FROM PTuote");
	while(rs.next()){//Hakee kaikki pelaajan ostamat tuotteet SQL-kannasta
            if(!rs.getString("nimi").equals("Näkkileipä")){//Jos tuotteen nimi ei ole näkkileipä
                TAPAHTUMATOUTPUT.append("\nOstit tuotetta " +rs.getString("nimi") + ", tuotteen ostohinta oli " +rs.getDouble("hinta") + "€, ostit tuotetta  " +rs.getInt("maara") + " kpl,\njota myyt hintaan " + rs.getDouble("myyntihinta")+"€.\n");
            }else{
                if(NOstomaara == 0){//Jos näkkileipiä ei ole ostettu nykyisessä kuukaudessa, mutta niitä on jääny yli viime kuusta
                    TAPAHTUMATOUTPUT.append("\nSinulla on tuotetta Näkkileipä, tuotteen ostohinta oli " +rs.getDouble("hinta") + "€, sinulla on tuotetta  " +rs.getInt("maara") + " kpl,\njota myyt hintaan " + rs.getDouble("myyntihinta")+"€.\n");
                }else{
                    TAPAHTUMATOUTPUT.append("\nOstit tuotetta " +rs.getString("nimi") + ", tuotteen ostohinta oli " +rs.getDouble("hinta") + "€, ostit tuotetta  " +NOstomaara + " kpl,\nsinulla on "+rs.getInt("maara")+" näkkileipää yhteensä, jota myyt hintaan " + rs.getDouble("myyntihinta")+"€.\n");
                }
            }
        }
	rs = stm.executeQuery("SELECT * FROM PMyyja");
	while(rs.next()){//Tulostaa kaikki pelaajan myyjät
            if(!(rs.getString("nimi").equals("Omistaja"))){
                TAPAHTUMATOUTPUT.append("\nPalkkasit myyjän " + rs.getString("nimi") +", jonka palkka on " +rs.getInt("palkka") + "€.\n");
            }
	}
	rs = stm.executeQuery("SELECT * FROM pelaajat where nimi = '"+YRNIMI+"'");
	while(rs.next()){
            TAPAHTUMATOUTPUT.append("\nSinulla on markkinointia  " + rs.getString("markkinointi") +"€ edestä.");
	}
        con.close();
	JT1.setSelectedIndex(1);
	JT1.setEnabledAt(0, false);	
	JT1.setEnabledAt(1, true);
}

    private void ChangeTableColors() {
        //Vaihtaa kaikkien tablejen värit
        PMyyjat.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ?  Color.WHITE: new Color(157, 223, 255));
                if(isSelected) {setBackground(new Color(168, 226, 255));}
                if(!isSelected) {setBackground(Color.WHITE);}
                return c;
        
            }
    
        });
        
     POstot.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
     {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(row % 2 == 0 ?  Color.WHITE: new Color(157, 223, 255));
            if(isSelected) {setBackground(new Color(168, 226, 255));}
            if(!isSelected) {setBackground(Color.WHITE);}
            return c;
        }
    });
     
     PMarkkinointi.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
     {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(row % 2 == 0 ?  Color.WHITE: new Color(157, 223, 255));
            if(isSelected) {setBackground(new Color(168, 226, 255));}
            if(!isSelected) {setBackground(Color.WHITE);}
            return c;
        }
    });  
        
    }

    public void paivitaaika() throws SQLException, ClassNotFoundException {
        //Methodi jolla päivitetään AIKA label
        Connection con = jd.getConnection();
        System.out.println("Con 13");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM pelaajat");
        
        while (rs.next()){//Hakee kuukauden ja vuoden sqlästä
            if(rs.getString("nimi").equals(YRNIMI)){
                kuk = rs.getInt("kk");
                vuk = rs.getInt("v");
            }
    
            String oip;
            if(kuk>9){//Jos kuukausi on isompi kuin 9
                oip = "";
            }
            else{
                oip = "0";//Lisätään kuukauden eteen 0
            }
        AIKA.setText("01."+oip+kuk+"."+vuk);
        }
    }

    private void Palkki() {
        //Custom otiskkobarin syntaksi. Lisätietoja toteuteksesta: https://www.youtube.com/watch?v=fT8gl6R2xmc
        VEDA.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                compCoords = null;
                ji.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(12, 143, 222)));
                VEDA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                compCoords = e.getPoint();
                ji.getRootPane().setBorder(BorderFactory.createLineBorder(Color.ORANGE));
                 VEDA.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
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
       VEDA.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
               
                ji.setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
                if(tilastotavattu)	{						
			T.setLocation(ji.getX() +ji.getWidth(), ji.getY());		
		}						
                
            }
        });
    }
   
public String tuoYrnim(){
    //Palauttaa yrityksen nimen
    return YRNIMI;
}

    private void PalkkaaiMyyja() throws ClassNotFoundException, SQLException {
        try{
            //Lisää myyjän sqlään
            Connection con = jd.getConnection();
            System.out.println("Con 14");
            
            String Myyja = PALKATTAVATMYYJAT.getSelectedItem().toString();//Hakee tarvittavat tiedot comboboxeista
            String sPalkka = PALKKA1.getSelectedItem().toString();
            Double Palkka = 0.0;
            Palkka = Double.valueOf(sPalkka); 
        
        
            jd.putData("insert into PMyyja(nimi,palkka)values ('"+Myyja+"', "+Palkka+")");
            PALKATTAVATMYYJAT.removeItem(Myyja);//Poistaa palkatun myyjän comboboxista
        
            paivitaMyyja();
            con.close();
        
            if(PALKATTAVATMYYJAT.getItemCount() == 0){//Jos comboboxissa ei ole myyjiä
                PALKATTAVATMYYJAT.setEnabled(false);//sammutetaan combobox ja nappi
                PALKKAAMYYJABTN.setEnabled(false);
                PALKKA1.setEnabled(false);
                PALKATTAVATMYYJAT.addItem("Ei myyjiä!");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Sinulla ei ole palkattavia myyjiä!");
        }
    }

    private void OstaTuote() throws ClassNotFoundException, SQLException {
        //Lisää tuotteen jtableen ja sqlään
        bol = false;//Tärkäe, älä koske!
        
        Connection con = jd.getConnection();
        System.out.println("Con 15");
        Statement stm = con.createStatement();
        
        double Thinta = Double.valueOf(THINTA.getText());
        double Uusikassa = 0;//Käytetään kassan laskussa
        int Tmaara = Integer.valueOf(TUOTEMAARA.getText()); 
        ResultSet rs = stm.executeQuery("select * from pelaajat");
        while(rs.next()){//Käy nykyisen kassan sqlästä
            Uusikassa = rs.getDouble("kassa");
        }
        Uusikassa = Uusikassa - Thinta*Tmaara;//Laskee uuden kassan
        KASSA.setText(String.valueOf(roundaaS(Uusikassa)));
        jd.putData("UPDATE pelaajat set kassa ="+Uusikassa+" where nimi= '"+YRNIMI+"'");
        
        String Tuote = OTUOTE.getSelectedItem().toString();
        double Myyntihinta = 0.0;
        double Ostohinta = Double.parseDouble(THINTA.getText());
        int maara = Integer.parseInt(TUOTEMAARA.getText());
        int Maara;
        System.out.println("Ostohinta on " + Ostohinta);
        
            boolean lisattu = false;
            ResultSet tuote = stm.executeQuery("SELECT * FROM PTuote");
            while(tuote.next()){//Käy läpi pelaajan tuotteet
                if(Tuote.equals(tuote.getString("nimi"))){
                    Maara = tuote.getInt("maara");
                    if(tuote.getString("nimi").equals("Näkkileipä")){//Lisää näkkileipien ostomäärän NOstomäärään
                        NOstomaara = NOstomaara +maara;
                    }
                    maara = Maara + maara;
                    lisattu = true;
                }
            }
            
         con.close();
         if(lisattu == true){//Jos tuote on jo olemassa sql kannassa
            jd.putData("UPDATE PTuote set maara ="+maara+" where nimi= '"+Tuote+"'");
         }
         if(lisattu == false){//jos tuotetta ei ole sql kannassa
            NOstomaara = NOstomaara +maara;
            jd.putData("insert into PTuote(nimi,myyntihinta,hinta,maara)values ( '"+Tuote+"', "+Myyntihinta+","+Ostohinta+","+maara+")");    
         }
         HaeComboboxData();
         System.out.println("Row countti "+POstot.getRowCount());
         paivita();
         if(POstot.getRowCount() != 0){//Jos pelaajalla on tuotteita
            Jatka.setEnabled(true);
            Jatka1.setEnabled(true);
         }
         else{
            Jatka.setEnabled(false);
             Jatka1.setEnabled(false);
         }
         bol = true;
        
    }

    private void HaeComboboxData() throws ClassNotFoundException, SQLException {
        //Hakee tiedot comboboxiin 
        Connection con = jd.getConnection();
        System.out.println("Con 16");
        Statement stm = con.createStatement();
        OTUOTE.removeAllItems();
        
        ResultSet tuote = stm.executeQuery("SELECT * FROM Tuote");
            while(tuote.next()){
                
                OTUOTE.addItem(tuote.getString("nimi"));
                System.out.println("Comboboxin valittu itemi on " + valittutuote.toString());
                OTUOTE.setSelectedItem(valittutuote);
                if(tuote.getString("nimi").equals(OTUOTE.getSelectedItem().toString())){
                    String hinta = String.format("%.2f",tuote.getDouble("hinta"));//Formatoi stringin kahden desimaalin tarkkuteen
                    hinta = hinta.replaceAll(",",".");
                    THINTA.setText(hinta);
                }
                
            
            }
        con.close(); 
    }

public void haeMyyjat() throws ClassNotFoundException, SQLException{
    //Hakee myyjät comboboxiin
    Connection con = jd.getConnection();
    System.out.println("Con 17");
    Statement stm = con.createStatement();
    ResultSet myyja = stm.executeQuery("SELECT * FROM Myyja");
    while(myyja.next()){
       PALKATTAVATMYYJAT.addItem(myyja.getString("nimi"));
    }					
    con.close();
}

    private void ComboBoxMuutos() throws ClassNotFoundException, SQLException {
       //Jos comboxissa tapahtuu muutos, asetetaan THINTAan oikeassa muodossa oleva arvo
        OTUOTE.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(bol == true){
                try {
                    JDBC jd = new JDBC();
                    Connection con = jd.getConnection();
                    System.out.println("Con 18");
                    Statement stm = con.createStatement();
                    
                    ResultSet rs = stm.executeQuery("SELECT * FROM Tuote");
                    Double tuotehinta = 0.0;
                    while (rs.next()){
                        if(OTUOTE.getSelectedItem().toString().equals(rs.getString("nimi"))){
                            tuotehinta = rs.getDouble("hinta");
                        }
                        
                        String pilkuton = String.format("%.2f", tuotehinta);//Formatoi Stringin kahden desimaalin tarkkuudelle
                        pilkuton = pilkuton.replaceAll(",", ".");
                        THINTA.setText(pilkuton);
                        logi.setText("Item lisätty");
                        
                        
                    }
                   con.close(); 
                
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }}
    });
    }

public void tarkistaKassa() {
    //Jos kassa on alle 100€ ilmestyy kassan viereen ! merkki
	if(Double.valueOf(KASSA.getText())<100){
            KASSA.setBorder(BorderFactory.createLineBorder(Color.RED));
            Varoitus.setText("!");					
        }
	else{
            KASSA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            Varoitus.setText("");
	}
}

public void Muutkulut(double pva,double myyntimaara,double palkat,double voitot,double markkinointi,int miinustettu,double omistajanpalkka,double hyvantekevaisyys) throws ClassNotFoundException, SQLException{
        //Methodi missä lisätään muutkulut sql kantaan
        System.out.println("-------Muut kulut-----------");
        System.out.println("Päivä on " +pva);
        Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 22");
        Statement stm = con.createStatement();
        Random rando = new Random();
        double satunnaisluku = 0.98 + (1.02 - 0.98) * rando.nextDouble();
        satunnaisluku = satunnaisluku;
        double satunnaisluku2 = 0.0 + (400.0 - 0.0) * rando.nextDouble();
        satunnaisluku2 = Math.round(satunnaisluku2);
        double sahko = 80.0 + (120.0 - 80.0) * rando.nextDouble();
        sahko = Math.round(sahko);
        double vesi = 30.0 + (50.0 - 30.0) * rando.nextDouble();
        vesi = Math.round(vesi);
        double kuljetus =  0.05 * myyntimaara * satunnaisluku;
        System.out.println("myyntimaara on " + myyntimaara);
        kuljetus = Math.round(kuljetus);
        double huolto;
        if(satunnaisluku2 > 150){
            huolto = satunnaisluku2 - 150;
        }else{
            huolto = 0.0;
        }
        double taloushallinto = 40.0 + (60.0 - 40.0) * rando.nextDouble();
        taloushallinto = Math.round(taloushallinto);
        double lainankorko = 10.0;
        double palkkojensivukulut = 0.5 * (palkat+omistajanpalkka);
        ResultSet rs = stm.executeQuery("select * from tilastot where yrnim = '"+YRNIMI+"'");
        while(rs.next()){
            System.out.println("kaikki päivät tilastot SQL-kannassa "+rs.getDouble("paiva"));
        }
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        jd.putData("UPDATE tilastot SET sahko = "+ sahko +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET vesi = "+ vesi +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET tietoliikenne = "+ 50 +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET vuokra = "+ 800 +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET kuljetus = "+ kuljetus +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET huolto = "+ huolto +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET omistajanpalkka = "+ omistajanpalkka +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET taloushallinto = "+ taloushallinto +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET lainankorko = "+ lainankorko +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET palkkojensivukulut = "+ palkkojensivukulut +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
	System.out.println("Tapahtunut myynti on " + tapahtunutmyynti);
	jd.putData("UPDATE tilastot SET tapahtunutmyynti = "+ tapahtunutmyynti +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET havikki = "+ miinustettu +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
	jd.putData("UPDATE tilastot SET lainanpaaoma = "+ Double.valueOf(LAINAT.getText()) +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        double laina = Double.valueOf(LAINAT.getText());
	laina = laina * 0.1 /12;
	jd.putData("UPDATE tilastot SET lainanmaksut = "+ laina +" WHERE paiva ="+pva+" AND yrnim ='"+YRNIMI+"'");
        double kassa = Double.parseDouble(KASSA.getText());
        DefaultTableModel model2 = (DefaultTableModel) PMyyjat.getModel();
        String opv;
        try{//Poistaa € merkin myyjän palkasta
            opv = removeLastChar(model2.getValueAt(0,1).toString());
        }catch(Exception ex){
            opv = model2.getValueAt(0,1).toString();
        }
        Double op = Double.parseDouble(opv);
        voitot = voitot - sahko - vesi - 50 - 800 - kuljetus - huolto - omistajanpalkka - taloushallinto - hyvantekevaisyys - palkkojensivukulut - laina - op;
        voitot = voitot - PalkatYht;
        voitot = voitot - markkinointi;
        kassa = kassa + voitot;//Laskee uuden omaisuuden voittojen kanssa
        double vara = 0.0;
        vara = Double.valueOf(VARAT.getText());
        ResultSet ro = stm.executeQuery("select *from pelaajat where nimi ='"+YRNIMI+"'");
        while(ro.next()){
            vara = vara + ro.getDouble("palkka");
        }
        VARAT.setText(String.valueOf(roundaaS(vara)));
					
        System.out.println("kassa on " + kassa);
        jd.putData("UPDATE pelaajat SET kassa = "+kassa+" WHERE nimi = '"+YRNIMI+"'");
        jd.putData("UPDATE pelaajat SET omaisuus = "+vara+" WHERE nimi = '"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET kassa = "+kassa+" WHERE paiva = '"+pva+" 'AND yrnim ='"+YRNIMI+"'");
        jd.putData("UPDATE tilastot SET tapahtunutmyynti = "+tapahtunutmyynti+" WHERE paiva = '"+pva+"' AND yrnim ='"+YRNIMI+"'");
    
        KASSA.setText(String.valueOf(roundaaS(kassa)));//Pistää omaisuuden labeliin
        con.close();
        
    }
    
    
    
    private Double myynninkerroin(double lmyyntihinta,double lostohinta){//Tällä hetkellä turhana oleva methodi,vertailee ostohintaa ja myyntihintaa ja antaa kertoimen niitten arvoista
        double myyntikerroin = 0.0;
        Random r = new Random();
        double a = 0.1 + (1.0 - 0.1) * r.nextDouble();
        double b = a + (2.5 - a) * r.nextDouble();
        double c = b + (3.5 - b) * r.nextDouble();
        double d = c + (4.0 - c) * r.nextDouble();
        double prosentti = lmyyntihinta / lostohinta;
        System.out.println("Tuotetta myydään  " + prosentti + " kertaisella hinnalla ostohintaan verrattuna");
        if(0.1 >= prosentti){
            myyntikerroin = 10.0;
        }else if(prosentti > 0.1 && prosentti < a){
            myyntikerroin = 7.0 + (10.0 - 7.0) * r.nextDouble();
        }else if(prosentti >= a && prosentti < b){
            myyntikerroin = 5.0 + (7.0 - 5.0) * r.nextDouble();
        }else if (prosentti >= b && prosentti < c){
            myyntikerroin = 2.0 +  (5.0 - 2.0) * r.nextDouble();
        }else if (prosentti >= c && prosentti < d){
            myyntikerroin = 0.7 + (2.0 - 0.7) * r.nextDouble();
        }else if (prosentti >= d && prosentti < 3.0){
            myyntikerroin = 0.3 + (0.7 - 0.3) * r.nextDouble();
        }else{
            System.out.println("Tuotteen myynti asetetaan 0");
            myyntikerroin = 0.0;
        }
        
        return myyntikerroin;
    }
    
    
    
    
    
    private void KKloop() throws SQLException, ClassNotFoundException { 
        //Methodi jossa edetään kuukausi
        String Tnimi = "";
        System.out.println("--Kuukausi looppi metodi--");
        LOGI.setText("");
        TAPAHTUMATOUTPUT.setText("");
	boolean loppu = false;
        Painettu = true;
        Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 23");
        Statement stm = con.createStatement();
        StringBuilder sp = new StringBuilder();
        ResultSet rs = stm.executeQuery("SELECT * FROM pelaajat where nimi='"+YRNIMI+"'");
        int TJaanne = 0;
        int myyntimaaraYht = 0;
        int kk = 0;
        int v = 0;
        if(rs.next()){//Hakee tämän hetkisen kuukauden ja vuoden
        kk = rs.getInt("kk");
        v = rs.getInt("v");
        }
        sp.append(kk);//yhdistää kuukauden ja vuoden
        sp.append(".");
        sp.append(v);
        Double markkinointi = 0.0;
        
        TAPAHTUMATOUTPUT.append("\n-"+sp+"-------------------------------------------------------------------------------------\n");						
								
        ArrayList<PTuote>PelaajanTuotteet = new ArrayList();//Arraylist johon lisätään kaikki pelaajan ostamat tuotteet
        ArrayList<Myyja>PelaajanMyyjat = new ArrayList();//Arraylist johon lisätään kaikki pelaajan palkkaamat myyjät
        Myyja m = new Myyja("?", 0.0);
        double aSum = 0;
        double voitto = 0;
        PTuote t = new PTuote(0,"?", 0.0, 0, 0.0);
        int maara = 0;
        
        rs = stm.executeQuery("SELECT * FROM pelaajat where nimi='"+YRNIMI+"'");
        if(rs.next()){//Päivittää kassan
            aSum = rs.getDouble("kassa");
            KASSA.setText(String.valueOf(roundaaS(aSum)));
        }
        
        rs = stm.executeQuery("select * from PTuote");
        while(rs.next()){//Hakee tuotteen tiedot ja lisää ne listalle
            Tnimi = rs.getString("nimi");
            double hinta = rs.getDouble("hinta");
            maara = rs.getInt("maara");
            double myyntim = rs.getDouble("myyntihinta");
            int DID = rs.getInt("ID");
               
            t = new PTuote(DID,Tnimi, hinta, maara, myyntim);
            PelaajanTuotteet.add(t);//Lisää kaikki vanhat tuotteet arraylistiin
        }
        
        rs = stm.executeQuery("select * from PMyyja");
        ArrayList<Double>voitot = new ArrayList();
        while(rs.next()){//Lisää myyjät pelaajan myyjät listaan
            String nimi = rs.getString("nimi");
            double palkka = rs.getInt("palkka");
            m = new Myyja(nimi, palkka);
            PelaajanMyyjat.add(m);
        }
        
        //RANDOM TAPAHTUMAT
        for (int i = 0; i < PelaajanMyyjat.size(); i++) {//Myyjän sairastelu/myöhästely
            double muutettupalkka = Tapahtuma(PelaajanMyyjat.get(i).getPalkka(), PelaajanMyyjat.get(i).getNimi());
            m = new Myyja(PelaajanMyyjat.get(i).getNimi(), muutettupalkka);
            PelaajanMyyjat.set(i, m);
        }
        ///////////////////////////////////////
        
        
        String nimi = "";
        System.out.println("----------------------------------");//Lisää yhden tuotteen tiedot muuttujiin.
        System.out.println("loopin alku " +PelaajanTuotteet);
                
        for (int i = 0; i < PelaajanTuotteet.size(); i++) {//Lisää kaikki tiedot TMTilastoihin
            jd.putData("insert into TMtilastot(yrnim,paiva,nimi,ostohinta,myyntihinta,ostomaara,maara,myyntimaara,palkka) values('"+YRNIMI+"',"+haepaiva()+",'"+PelaajanTuotteet.get(i).getNimi()+"',"+0+", "+0+","+0+", "+0+", "+0+", "+0+")");
        }
        for (int i = 0; i < PelaajanMyyjat.size(); i++) {
            jd.putData("insert into TMtilastot(yrnim,paiva,nimi,ostohinta,myyntihinta,ostomaara,maara,myyntimaara,palkka) values('"+YRNIMI+"',"+haepaiva()+",'"+PelaajanMyyjat.get(i).getNimi()+"',"+0+", "+0+","+0+", "+0+", "+0+", "+0+")");
        }
        for (int i = 0; i < PelaajanTuotteet.size(); i++) {
            jd.putData("UPDATE TMtilastot set maara ="+POstot.getValueAt(i,2)+" where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+PelaajanTuotteet.get(i).getNimi()+"'");
            if(PelaajanTuotteet.get(i).getNimi().equals("Näkkileipä")){
                jd.putData("UPDATE TMtilastot set ostomaara ="+NOstomaara+" where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+PelaajanTuotteet.get(i).getNimi()+"'");
            }
            jd.putData("UPDATE TMtilastot set ostohinta ="+Double.parseDouble(removeLastChar(POstot.getValueAt(i,1).toString()))+" where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+PelaajanTuotteet.get(i).getNimi()+"'");
            jd.putData("UPDATE TMtilastot set myyntihinta ="+Double.parseDouble(removeLastChar(POstot.getValueAt(i,3).toString()))+" where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+PelaajanTuotteet.get(i).getNimi()+"'");
        }
        for (int i = 0; i < PelaajanMyyjat.size(); i++) {
            jd.putData("UPDATE TMtilastot set palkka ='"+PelaajanMyyjat.get(i).getPalkka()+"' where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+PelaajanMyyjat.get(i).getNimi()+"'");
        }
                
        brandi = 0;
        //Brändin lasku
        Double HT = 0.0;
        markkinointi = 0.0;
        ResultSet RSbrandi = stm.executeQuery("SELECT * FROM pelaajat where nimi='"+YRNIMI+"'");
        while(RSbrandi.next()){//Käy nykyiset tiedot
            brandi = RSbrandi.getDouble("brandi");
            HT = RSbrandi.getDouble("hyvantekevaisyys");
            markkinointi = RSbrandi.getDouble("markkinointi");
            System.out.println("Markkinointi on " +markkinointi);
        }
                
        for (int i = 0; i < PelaajanMyyjat.size(); i++) {
            Double Palkka = PelaajanMyyjat.get(i).getPalkka();
            System.out.println("Branditekijän arvot ovat " + markkinointi + " " +Palkka);
            Double branditekija = (markkinointi/500*60+Palkka/500*40)/100;
            System.out.println("Branditekijän arvo on " + branditekija);
            PalkatYht = PalkatYht + Palkka;
            if(branditekija < 0.4){
                brandi = brandi*0.9*(1+HT/50000);
                System.out.println("Brandin arvo on " +brandi);
            }else{
                    brandi = brandi*((1+branditekija/100/(brandi/50))*(1+branditekija/100/(brandi/50)))*(1+HT/50000);
                    brandi = (double)Math.round(brandi * 100000d) / 100000d;									
                    System.out.println("Bradin arvo on " + brandi);
            }
            jd.putData("update pelaajat set brandi = "+brandi+" where nimi = '"+YRNIMI+"'");
        }
        BRANDIPALKKI.setValue(Integer.valueOf(String.valueOf(Math.round(brandi))));
        ///////////////////////////////
        
	tapahtunutmyynti = 0;
	THinnatYht = 0;
        
	for (int k = 0; k < PelaajanTuotteet.size();k++) {//Laskee tuotteiden hinnat yhteen
		double ostohinta = PelaajanTuotteet.get(k).getHinta();
                if(PelaajanTuotteet.get(k).getNimi().equals("Näkkileipä")){
                    maara = maara + NOstomaara;
                }else{
                    maara = maara +PelaajanTuotteet.get(k).getMaara();
                }
                THinnatYht = THinnatYht + ostohinta*maara;			
	}
        
	System.out.println("Tuotteiden hinnat yhteensä " + THinnatYht);
        /////////////MYYNTIMÄÄRÄN LASKU JA TUOTTEIDEN VÄHENNYS
	for (int j = 0; j < PelaajanMyyjat.size(); j++) {//Käy loopin jokaista pelaajan myyjää kohden
            int yhdentuotteenmyyntimaara = 0;
            for (int i = 0; i < PelaajanTuotteet.size(); i++) {//Käy loopin jokaista pelaajan tuotetta kohden
													
		double Palkka = PelaajanMyyjat.get(j).getPalkka();
		double ostohinta = PelaajanTuotteet.get(i).getHinta();
		maara = PelaajanTuotteet.get(i).getMaara();								
                nimi = PelaajanTuotteet.get(i).getNimi();
		double myyntihinta = PelaajanTuotteet.get(i).getMyyntiHinta();
                int DIDI = PelaajanTuotteet.get(i).getID();
                PTuote T = new PTuote(DIDI,nimi, ostohinta, maara, myyntihinta);//Uusi tuote jolla korvataan vanha laskujen jälkeen.
                Random r = new Random();
                myyntimaara = 0;
                
                ////RANDOMISAATTORI
                Double valimaara = new Double(0.00); 
                double min = 0.98;
                double max = 1.02;
                double valiluku = min + (max - min) * r.nextDouble();
                System.out.println("Satunnaistekijä on "+valiluku);
                double satunnaistekija = roundaaD(valiluku);
                ///////////////////////
                
                double myyntikerroin = myynninkerroin(myyntihinta,ostohinta);
                //MYYNTIMÄÄRÄN LASKU
                System.out.println("Ostohinta on " + ostohinta + ", myyntihinta on "+myyntihinta+", brandi on "+brandi+", satunnaistekijä on " +satunnaistekija+", palkka on " +Palkka);
                System.out.println("Eli myynmäärän kaava näyttää tältä: (-1500 / "+ ostohinta+" *("+myyntihinta+" * "+myyntihinta+")+ 12000 * "+ostohinta+ ")* "+brandi+" / 50 * "+satunnaistekija+" *(1 + "+Palkka+" / 5000)");
		switch (nimi){//Valitsee oikean kaavan tuotteen nimen perusteella
			case "Tehdasleipä":
				//valimaara =(-1500 / ostohinta *(myyntihinta* myyntihinta)+12000*ostohinta)*roundaaD(brandi)/50*satunnaistekija*(1+Palkka/5000); Kaava 1
                                System.out.println("KAAVA ON" + "((1500 * (3.18 * 3.18) + 15000*("+brandi+"/100-1))/(3.18*3.18))*("+myyntihinta+"*"+myyntihinta+")+(15000*"+brandi+"/100)*"+satunnaistekija+"*(1+"+Palkka+"/10000))");
                                valimaara = -((1500 * (3.18 * 3.18) + 15000*(brandi/100-1))/(3.18*3.18))*(myyntihinta*myyntihinta)+(15000*brandi/100)*satunnaistekija*(1+Palkka/10000);
			break;
			case "Leipomon leipä":
				//valimaara =(-1000 / ostohinta *(myyntihinta* myyntihinta)+12000*ostohinta)*brandi/50*satunnaistekija*(1+Palkka/5000); Kaava 1
                                valimaara = -((1000 * (3.87 * 3.87) + 15000*(brandi/100-1))/(3.87*3.87))*(myyntihinta*myyntihinta)+(15000*brandi/100)*satunnaistekija*(1+Palkka/10000);
			break;
			case "Luomuleipä":
				//valimaara =(-500 / ostohinta *(myyntihinta* myyntihinta)+12000*ostohinta)*brandi/50*satunnaistekija*(1+Palkka/5000); Kaava 1
                                valimaara = -((500 * (5.48 * 5.48) + 15000*(brandi/100-1))/(5.48*5.48))*(myyntihinta*myyntihinta)+(15000*brandi/100)*satunnaistekija*(1+Palkka/10000);
			break;
                        case "Näkkileipä":
                                //valimaara =(-1500 / ostohinta *(myyntihinta* myyntihinta)+12000*ostohinta)*brandi/50*satunnaistekija*(1+Palkka/5000); Kaava 1
                                valimaara = -((1500 * (2.58 * 2.58) + 10000*(brandi/100-1))/(2.58*2.58))*(myyntihinta*myyntihinta)+(10000*brandi/100)*satunnaistekija*(1+Palkka/10000);
                        break;
                        default:
				System.out.println("Tuotteen haussa on ongelma");
			break;
		}
                 
                System.out.println("Tuotetta on yritetty ostaa " + valimaara + " kertaa");
                if(valimaara < 0){//Jos myyntikaava antaa negatiivisen arvon
                    valimaara = 0.0;//Asetetaan myyntimäärä 0
                }
                myyntimaara = valimaara.intValue();
                rs = stm.executeQuery("SELECT * FROM TMtilastot where yrnim='"+YRNIMI+"' and paiva ="+haepaiva()+" and nimi ='"+nimi+"'");
                int kysynta = 0;
                while(rs.next()){//Laskee kokonais kysyntää myöhempää tulostusta varten
                        kysynta = rs.getInt("kysynta");
                }
                kysynta = kysynta + myyntimaara;
		jd.putData("UPDATE TMtilastot set kysynta = "+kysynta+" where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+nimi+"'");
                
		System.out.println("IF lauseen arvot " +myyntimaara + " " +maara);
                
                if(myyntimaara > maara){//Tarkistaa onko varastossa tarpeeksi tuotteita mitä myydä.
                    myyntimaara = maara;//Korvaa luvun varastossa olevien tuotteitten määrällä.
                }
                
		tapahtunutmyynti =tapahtunutmyynti + myyntimaara * myyntihinta;	
                System.out.println("Lopullinen myyntimaara on " + myyntimaara);
                
                markkinointi = 0.0;
                rs = stm.executeQuery("SELECT * FROM TMtilastot where yrnim='"+YRNIMI+"' and paiva ="+haepaiva()+" and nimi ='"+nimi+"'");
                while(rs.next()){
                        yhdentuotteenmyyntimaara = rs.getInt("myyntimaara") + myyntimaara;
                }
                jd.putData("UPDATE TMtilastot set myyntimaara = "+yhdentuotteenmyyntimaara+" where yrnim= '"+YRNIMI+"' and paiva = "+haepaiva()+" and nimi='"+nimi+"'");
                
                //////VOITON LISÄYS
                voitto = myyntimaara*myyntihinta;
                System.out.println("voitot " + voitto);
                voitot.add(voitto);//Lisää voitot listaan
                myyntimaaraYht = myyntimaaraYht + myyntimaara;
                TJaanne = maara-myyntimaara;//Laskee tuotemäärän myynnin jälkeen
                PreparedStatement ps = con.prepareStatement("UPDATE PTuote SET maara = "+ TJaanne +" WHERE nimi = '"+nimi+"'");
                ps.executeUpdate();//Päivittää SQL-kantaan uuden tuotemäärän
                System.out.println("Miinustettava määrä: " +TJaanne);
                T.setMaara(TJaanne);//Korvaa vanhan määrän oliosta uudella
                PelaajanTuotteet.set(i,T);//Korvaa vanhan olion uudella
                /////////////////////////////////
                System.out.println("Loopin loppu " + PelaajanTuotteet);
		}}
        ////////////////////MYYNTIMÄÄRÄN LASKU LOOPIN LOPPU
	//TUOTTEIDEN TULOSTUS JA PÄIVITYS SQL KANTAAN
        rs = stm.executeQuery("SELECT * FROM TMtilastot where yrnim='"+YRNIMI+"' and paiva ="+haepaiva()+"");
        while(rs.next()){//Tulostaa pilaantuneet leivät
            System.out.println("Tulostetaan tietoja tapahtumatoutputtiin");
            if(rs.getDouble("palkka") == 0.0 && !(rs.getString("nimi").equals("Omistaja"))){
                System.out.println("Löytyi tuotteita");
                TJaanne = rs.getInt("maara") - rs.getInt("myyntimaara");
                TAPAHTUMATOUTPUT.append("\nTuotetta " +rs.getString("nimi")+ " myytiin " +rs.getInt("myyntimaara") + " kpl.\n");
                if(TJaanne > 0){
                    System.out.println("Tulostetaan pilaantuivat teksti");
                    if(!rs.getString("nimi").equals("Näkkileipä")){
                        TAPAHTUMATOUTPUT.append("Loput "+TJaanne+" leipää pilaantuivat kuukauden aikana\n");
                    }
                }else{
                    System.out.println("Info tulostetaan");
                    info(rs.getInt("kysynta"),rs.getInt("myyntimaara"));   
                }
            }
        }
        
        TAPAHTUMATOUTPUT.append("\nTuotteita myytiin yhteensä " +myyntimaaraYht + " kpl");
	 
	
        PelaajanTuotteet.clear();//Tyhjentää arraylistit
        PelaajanMyyjat.clear();
        System.out.println("-------------------Loopin päivän ja voiton lasku----------------------");
        double sum = 0;
        for (int i = 0; i < voitot.size(); i++) {//Laskee voitot yhteen.
            aSum = aSum + voitot.get(i);
            sum = sum + voitot.get(i);
        }
        voitot.clear();
        double pv = 0.0;
        ResultSet pvhaku = stm.executeQuery("select * from pelaajat");
        while(pvhaku.next()){
        if(pvhaku.getString("nimi").equals(YRNIMI)){//Hakee nykyisen kuukauden
            int kuukausi = 0;
            int vuosi = 0;
            kuukausi = pvhaku.getInt("kk");
            vuosi = pvhaku.getInt("v");
            StringBuilder sb = new StringBuilder();
            sb.append(kuukausi);
            sb.append(".");
            sb.append(vuosi);
            pv = Double.valueOf(sb.toString());
        }}
        
        boolean virhe = false;
        if(pv == 1.2018){//Jos on aloitus kuukausi
                virhe = true;
                System.out.println("Virhe on nyt asetettu arvoon true");
        }
        System.out.println("Virhe on " + virhe);
        
  
        System.out.println("Lisätään uusi päivä tilastoihin");
	boolean SisaltaaDuplikaatin = false;
        int DuplicateCount = 0;
        ResultSet til = stm.executeQuery("select * from tilastot");
        while(til.next()){//Tarkistaa onko pelaajan nimellä tallennus jo olemassa
            System.out.println("**Whilessä**");
            if(til.getString("yrnim").equals(YRNIMI) && til.getDouble("paiva") == (muutaVuosiksi()))	{
                SisaltaaDuplikaatin = true;
                System.out.println("**Sisälsi duplikaatin**");
            }
            else{
                SisaltaaDuplikaatin = false;
                System.out.println("**Ei ollut duplikaatteja**");

            }
        }
        
	if(SisaltaaDuplikaatin){
            muutaVuosiksi();											
            jd.putData("delete from tilastot where yrnim = '"+YRNIMI+"' AND paiva = "+muutaVuosiksi()+"");
            System.out.println("**Poistetaan duplikaatti**");
	}	
	else{
            System.out.println("**Ei poisteta duplikaattia**");
	}
	
        //Lisää tilastoihin uuden päivän
	jd.putData("insert into tilastot(yrnim, paiva, kassa, tapahtunutmyynti, myyjienpalkat, lainanmaksut, markkinointikulut, tuotteidenostohinta, vesi, sahko, tietoliikenne, vuokra, kuljetus, huolto, omistajanpalkka, taloushallinto, lainankorko, hyvantekevaisuus, palkkojensivukulut, havikki, lainanpaaoma) values('"+YRNIMI+"',"+pv+","+0+","+0+","+PalkatYht+","+0+","+markkinointi+","+THinnatYht+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+")");
        System.out.println("Hyväntekeväisyys on " + HT);
        jd.putData("update tilastot set hyvantekevaisuus = "+HT+" where yrnim = '"+YRNIMI+"' and paiva = "+haepaiva()+"");
            
        double omistpalk = 0.0;
        ResultSet rsa = stm.executeQuery("select *from pelaajat where nimi='"+YRNIMI+"'");
        while(rsa.next()){//Hakee omistajan palkan
        omistpalk =rsa.getDouble("palkka");
        }
        Muutkulut(pv,myyntimaaraYht,PalkatYht,sum,markkinointi,TJaanne,omistpalk,HT);
        
        kuk++;
        if(kuk == 13){//jos kuukausia on 13
            vuk++;//Lisätään yksi vuosi
            kuk = 1;//Asetetaan kuukaudet arvoon 1
        }
        jd.putData("UPDATE pelaajat SET kk = "+kuk+" WHERE nimi = '"+YRNIMI+"'");//Asettaa kuukauden SQL-kantaan
        jd.putData("UPDATE pelaajat SET v = "+vuk+" WHERE nimi = '"+YRNIMI+"'");//Asettaa vuoden SQL-kantaan
        INPUTPVALB.setText("1."+kuk+"."+vuk);//Laittaa uuden kuukauden ja vuoden labeliin
        
        sp = new StringBuilder();
        sp.append(kuk);//Yhdistää kuukauden ja vuoden
        sp.append(".");  
        sp.append(vuk); 
        pv = Double.parseDouble(sp.toString());
        System.out.println("PVÄ " + pv);
	
        
          boolean nko = false;
          Jatka.setEnabled(false);
          Jatka1.setEnabled(false);
          npv = false;
          rs = stm.executeQuery("select * from PTuote where nimi = 'Näkkileipä'");
          while(rs.next()){//Tarkistaa onko pelaajalla näkkileipiä
            npv = true;
            if(rs.getInt("maara") == 0){
                nko = true;
            }
            else{
                nko = false;
                Jatka.setEnabled(true);
                Jatka1.setEnabled(true);
            }
             System.out.println("Näkkileipiä on "+rs.getInt("maara"));
        }
        
	jd.putData("delete from PMyyja");
        
        if(nko == false){//Jos näkkileivät ovat loppu/ei ole    
	jd.putData("delete from PTuote where nimi not like 'Näkki%'");//Poistetaan näkkileipä tuotteista
        }
        else{
          jd.putData("delete from PTuote");  
        }
        
        NOstomaara = 0;//Deletoi markkinoinnin ja myyjien tiedot jtableista ja sql
	jd.putData("delete from markkinointi");
	jd.putData("update pelaajat set markkinointi = 0.0 where nimi = '"+YRNIMI+"'");
        jd.putData("update pelaajat set hyvantekevaisyys = 0.0 where nimi = '"+YRNIMI+"'");
	PALKATTAVATMYYJAT.removeAllItems();
        jd.putData("delete from myyja");
        jd.putData("insert into myyja(nimi,palkka)values ('Tauno Jallinen', 1200.0)");
	jd.putData("insert into myyja(nimi,palkka)values ('Teimo', 1500.0)");
        jd.putData("insert into myyja(nimi,palkka)values ('Erkki Toivanen', 1700.0)");
	jd.putData("insert into pmyyja(nimi,palkka)values ('Omistaja', 0.0)");
        jd.putData("UPDATE pelaajat SET palkka = 0.0 WHERE nimi = '"+YRNIMI+"'");
          //Resetoi Myyjatjcomboboxin
          PALKATTAVATMYYJAT.setEnabled(true);
          PALKKAAMYYJABTN.setEnabled(true);
          PALKKA1.setEnabled(true);
          PALKATTAVATMYYJAT.removeItem("Ei myyjiä!");
          //
        con.close();
        paivita();
	haeMyyjat();			
        PalkatYht = 0.0;
        THinnatYht = 0.0;
        paivitaaika();
        tarkistaKassa();
        System.out.println("Tilastot on päivitetty");
        T.paivita();
        paivitaMyyja();			
        TAPAHTUMATOUTPUT.append("\n---Kuukauden loppu--------------------------------------------------------------------");
        T.TAKAISINBTN.doClick();
    }  
    
public void BordelUpdate(){
	VARAT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	LAINAT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	if(Double.valueOf(KASSA.getText()) < 100){
		KASSA.setBorder(BorderFactory.createLineBorder(Color.RED));			
	}
	else{
            KASSA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
				
}

public void PaivitaStatsit() throws ClassNotFoundException, SQLException{
	//Päivittää uudet arvot VARAT,KASSA ja LAINAT labeleihin
	Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 24");
        Statement stm = con.createStatement();
	ResultSet pelaaja = stm.executeQuery("SELECT * FROM pelaajat");
        while(pelaaja.next()){//Omaisuuden päivittäminen
            if(pelaaja.getString("nimi").equals(YRNIMI)){//Käy kaikki pelaajat läpi, ja valitsee pelaajan jolla on sama nimi kuin nykyisellä pelaajalla.
                VARAT.setText(String.valueOf(roundaaS(pelaaja.getDouble("omaisuus"))));				
                KASSA.setText(String.valueOf(roundaaS(pelaaja.getDouble("kassa"))));
                LAINAT.setText(String.valueOf(roundaaS(pelaaja.getDouble("lainat"))));			
            }
	}
        con.close();
}
		

    public void setFrame() {
        JT1.setSelectedIndex(0);
	JT1.setEnabledAt(1, false);			
	JT1.setEnabledAt(0, true);	
        this.setLocationRelativeTo(null);
    }

    public void Opastusframe(int nappiapainettu){
        //Opastus methodi (RIKKI)
	if(nappiapainettu == 1){
            OhjeBorder2.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
	}else if(nappiapainettu == 2){
            OhjeBorder4.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
            op.setLocation(op.getX()+360, op.getY());
	}else if(nappiapainettu == 3){
            OhjeBorder5.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder6.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
            op.setLocation(op.getX()-360, op.getY());
	}else if(nappiapainettu == 4){
            OhjeBorder7.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder8.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
	}else if(nappiapainettu == 10){
            OhjeBorder1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder1.setBackground(Color.white);
            OhjeBorder2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder2.setBackground(Color.white);
            OhjeBorder4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder4.setBackground(Color.white);
            OhjeBorder5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder5.setBackground(Color.white);
            OhjeBorder6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder6.setBackground(Color.white);
            OhjeBorder7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder7.setBackground(Color.white);
            OhjeBorder8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
            OhjeBorder8.setBackground(Color.white);
            ops=false;
	}
    }

    private void Opastus(boolean myyjabtn, boolean ostotbtn,boolean markkinointibtn,boolean tapahtumatbtn,boolean kkbtn) {
        //Opastus methodi (RIKKI)
        if(ops){
            op.setVisible(true);
            op.setLocationRelativeTo(null);
            op.setAlwaysOnTop(true);
           if(!(myyjabtn && ostotbtn && markkinointibtn) && opastusnm == 0){
               
            OhjeBorder1.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
            opastusnm = 1;
            op.setLocation(OhjeBorder1.getX()+550, OhjeBorder1.getY()+253);
										
           }
           if(!(ostotbtn && markkinointibtn) && myyjabtn && opastusnm == 1){
               OhjeBorder1.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
               OhjeBorder2.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
               opastusnm = 2;						
               op.ensimmainen(opastusnm);
               op.setLocation(OhjeBorder1.getX()+550, OhjeBorder1.getY()+360);						
           }
           if(!(myyjabtn && markkinointibtn) && ostotbtn && opastusnm == 2){
                OhjeBorder4.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
                OhjeBorder5.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
                opastusnm = 3;
                op.ensimmainen(opastusnm);
                op.setLocation(OhjeBorder4.getX()+550, OhjeBorder1.getY()+360);
								
           }
           if(!(ostotbtn && myyjabtn) && markkinointibtn && opastusnm == 3){
                OhjeBorder6.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
                OhjeBorder7.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
                opastusnm = 4;
                op.ensimmainen(opastusnm);
            }
            if(tapahtumatbtn && opastusnm == 4){
                OhjeBorder8.setBorder(BorderFactory.createEmptyBorder(1, 1 ,1 ,1));
                opastusnm = 5;
		op.ensimmainen(opastusnm);
            }
            if(kkbtn && opastusnm == 5){
                opastusnm = 6;
		op.ensimmainen(opastusnm);
		ops = false;
            }
       }
    }

private void info(int tuotteidenmaksimi, int tuotteenvarasto) {
    //Tulostaa TAPAHTUMAOUTPUTtiin arvon kysynnän ja tuotteiden varoston mukaan
        double prosentti = Double.valueOf(tuotteidenmaksimi) / Double.valueOf(tuotteenvarasto);
        System.out.println("Tuotetta olisi ostettu " + prosentti + " kertaisella määrällä");
	if(prosentti >= 1.0 && prosentti <= 1.2){//Tuotteilla oli saman verran myyntiä kuin kysyntää
		TAPAHTUMATOUTPUT.append("Kysyntää oli suunnilleen yhtä paljon kuin myyntiä");
	}else if(prosentti >= 1.2 && prosentti <= 2.0){//Tuotteilla oli enemmän kysyntää
                TAPAHTUMATOUTPUT.append("Kysyntää oli enemmän kuin myyntiä");
	}else if(prosentti >= 2.0){//Tuotteilla oli paljon enemmän kysyntää
		TAPAHTUMATOUTPUT.append("Kysyntää oli paljon enemmän kuin myyntiä");
	}
}
					

void setBorderOnwards(int opastusnm) {
	if(opastusnm == 2){
		op.setLocation(OhjeBorder1.getX()+550, OhjeBorder1.getY()+471);
	}
	else if(opastusnm == 3){
		op.setLocation(OhjeBorder4.getX()+500, OhjeBorder1.getY()+250);
	}
}

public double getLainat() {
    //Methodi joka palauttaa lainan arvon
	double Laina;
	Laina = Double.valueOf(LAINAT.getText());
return Laina;}

					
public double muutaVuosiksi() throws ClassNotFoundException, SQLException{
    //Hakee nykyisen kuukauden ja vuoden sql kannasta
	Connection con = jd.getConnection();
        System.out.println("Con 25");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM pelaajat");
        while (rs.next()){
            if(rs.getString("nimi").equals(YRNIMI)){
                kuk = rs.getInt("kk");
                vuk = rs.getInt("v");
        }}
        con.close();
        StringBuilder sp = new StringBuilder();
        sp.append(kuk);
        sp.append(".");
        sp.append(vuk);
	double dVuosi = Double.valueOf(String.valueOf(sp));									

return dVuosi;}



private void EmptyLog() {
    //Asettaa ajastimen logi kentän tyhjentämiseen
	Timer t = new Timer(2500, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
               logi.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
}
					
public double haepaiva() throws SQLException, ClassNotFoundException{
    //Toinen methodi nykyisen päivän hakemiseen
        Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
        System.out.println("Con 26");
        Statement stm = con.createStatement();
        StringBuilder sp = new StringBuilder();
        ResultSet rs = stm.executeQuery("SELECT * FROM pelaajat where nimi='"+YRNIMI+"'");
        int kk = 0;
        int v = 0;
        if(rs.next()){
            kk = rs.getInt("kk");
            v = rs.getInt("v");
        }
        con.close();
        sp.append(kk);
        sp.append(".");
        sp.append(v);
        double paiva;
        paiva = Double.valueOf(String.valueOf(sp));
        
        return paiva;
}

    private void SuljePeli() throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //Methodi pelin sulkemiseen
        try {
               op.hide();
               Connection con = jd.getConnection();//Hakee yhteyden SQL-kantaan
               System.out.println("Con 27");
               Statement stm = con.createStatement();
               int ID = 0;
               
               String[] options = new String[] {"Kyllä", "Peruuta", "Sulje tallentamatta"};
               int response = JOptionPane.showOptionDialog(null, "Suljetaanko sovellus tallentaen?", "Varoitus",//Kysyy pelaajalta sammutetaanko peli tallentamalla vai ilman
               JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm");
               LocalDateTime now = LocalDateTime.now();
               System.out.println(dtf.format(now));
               String Nykyhetki = String.valueOf(dtf.format(now));//Hakee järjestelmän kellon ajan

               switch (response) {
                    case 0://Jos vastaus on kyllä
                        ResultSet pelaaja = stm.executeQuery("SELECT * FROM tallennus");
                        boolean setter = false;
                        int j = 0;
                        int samanimi = 0;
                        while(pelaaja.next()){//Tarkistaa onko pelaajan nimellä jo tallennus olemassa
                            j++;
                            if(pelaaja.getString("pnimi").equals(YRNIMI)){//Käy kaikki pelaajat läpi, ja valitsee pelaajan jolla on sama nimi kuin nykyisellä pelaajalla.
                                samanimi++;
                                System.out.println("Vastaavuuksia " + samanimi);
                                setter = true;
                            }
                            else{
                                System.out.println("Erinimi");
                                setter = false;
                            }
                            System.out.println("Taulussa on: "+j+ ". "+ pelaaja.getString("pnimi"));
                        }

                        if(setter){//Jos löytyi tallennus
                            //Poistaa aluksi vanhan tallennuksen
                            System.out.println("Positetaan mahdollinen duplikaatti");
                            jd.putData("delete from tallennus where pnimi='"+YRNIMI+"'");
                            jd.putData("delete from pelaajat where nimi='"+YRNIMI+"'");
                            System.out.println("Päivitetään edellinen");
                            //Lisää uuden tallennuksen sql kantaan
                            jd.putData("insert into tallennus( pnimi,pslogan,pkassa, pomaisuus, v, kk, brandi, plaina,lpvm)values ( '"+YRNIMI+"', '"+Slogan+"', "+KASSA.getText()+", "+VARAT.getText()+", '"+vuk+"',"+kuk+","+BRANDIPALKKI.getValue()+","+Double.valueOf(LAINAT.getText())+", '"+Nykyhetki+"')");
                            jd.putData("insert into pelaajat(nimi, slogan, kassa, omaisuus, v, kk, brandi, lainat)values( '"+YRNIMI+"', '"+Slogan+"', "+KASSA.getText()+", "+VARAT.getText()+", '"+vuk+"',"+kuk+","+BRANDIPALKKI.getValue()+","+Double.valueOf(LAINAT.getText())+")");
                            System.out.println(kuk + "," + vuk);
                            System.out.println("Tallennustaulu muutosten jälkeen: ");
                            
                            pelaaja = stm.executeQuery("SELECT * FROM PTuote");
                            boolean nak =false;
                            double nmh = 0.0;
                            int nm = 0;
                            double palautus = 0;
                            while(pelaaja.next()){//Tarkistaa onko pelaajalla näkkileipiä
                                if(pelaaja.getString("nimi").equals("Näkkileipä")){
                                    nak = true;
                                    nmh = pelaaja.getDouble("myyntihinta");
                                    nm = pelaaja.getInt("maara");
                                }else{//Jos tuote on joku muu kuin näkkileipä,ohjelma palauttaa rahat pelaajalle
                                    palautus = palautus + Double.valueOf(pelaaja.getInt("maara")) * pelaaja.getDouble("hinta");
                                }
                            }
                            palautus = Double.valueOf(KASSA.getText()) + palautus;
                            jd.putData("update pelaajat set kassa ="+palautus+" where nimi = '"+YRNIMI+"'");//Päivittää uuden kassan pelaajalle
                            jd.putData("update tallennus set pkassa ="+palautus+" where pnimi = '"+YRNIMI+"'");
                            if(nak){//Tallentaa näkkileipien määrän ja hinnan
                                jd.putData("insert into TMTilastot(yrnim,paiva,nimi,ostohinta,myyntihinta,maara,palkka) values('"+YRNIMI+"',0.0,'Näkkileipä',1,"+nmh+","+nm+",0)");
                            }
                            pelaaja = stm.executeQuery("SELECT * FROM tallennus");
                            con.close();
                        }
                    
                        else{//Jos tallennusta ei löytynyt
                            //Lisää uuden tallennuksen sql kantaan
                            jd.putData("delete from tallennus where pnimi='"+YRNIMI+"'");
                            jd.putData("delete from pelaajat where nimi='"+YRNIMI+"'");
                            jd.putData("insert into tallennus( pnimi,pslogan,pkassa, pomaisuus, v, kk, brandi, plaina,lpvm)values ( '"+YRNIMI+"', '"+Slogan+"', "+kKassa+", "+kOmaisuus+", '"+vuk+"',"+kuk+","+brandi+","+Double.valueOf(LAINAT.getText())+", '"+Nykyhetki+"')");
                            jd.putData("insert into pelaajat(nimi, slogan, kassa, omaisuus, v, kk, brandi, lainat)values( '"+YRNIMI+"', '"+Slogan+"', "+kKassa+", "+kOmaisuus+", '"+vuk+"',"+kuk+","+brandi+","+Double.valueOf(LAINAT.getText())+")");
                            
                            pelaaja = stm.executeQuery("SELECT * FROM PTuote");
                            boolean nak =false;
                            double nmh = 0.0;
                            int nm = 0;
                            double palautus = 0.0;
                            while(pelaaja.next()){//Tarkistaa onko pelaajalla näkkileipiä
                                if(pelaaja.getString("nimi").equals("Näkkileipä")){
                                    nak = true;
                                    nmh = pelaaja.getDouble("myyntihinta");
                                    nm = pelaaja.getInt("maara");
                                }else{//Jos tuote on joku muu kuin näkkileipä,ohjelma palauttaa rahat pelaajalle
                                    palautus = palautus + Double.valueOf(pelaaja.getInt("maara")) * pelaaja.getDouble("hinta");
                                }
                            }
                            palautus = Double.valueOf(KASSA.getText()) + palautus;
                            jd.putData("update tallennus set pkassa ="+palautus+" where pnimi = '"+YRNIMI+"'");//Päivittää uuden kassan pelaajalle
                            jd.putData("update pelaajat set kassa ="+palautus+" where nimi = '"+YRNIMI+"'");
                            if(nak){//Tallentaa näkkileipien määrän ja hinnan
                                jd.putData("insert into TMTilastot(yrnim,paiva,nimi,ostohinta,myyntihinta,maara,palkka) values('"+YRNIMI+"',0.0,'Näkkileipä',1,"+nmh+","+nm+",0)");
                            }
                            con.close();

                        }
                
                        con.close();
                        if(taaksep == false){//Jos peli on sammutettu x näppäimestä
                            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                        }
                        else{//Jos peli on sammutettu taaksepäin näppäimestä
                            j1_Aloitus a = new j1_Aloitus();
                            a.setVisible(true);
                            this.dispose();
                        }
                        break;
                        
                    case 1:
                        if(ops){
                            op.show();
                        }
                    break;
                    
                    case 2://Jos vastaus on poistu tallentamatta
			String[] valinnat = new String[] {"Kyllä", "Ei"};
                        int vastaus = JOptionPane.showOptionDialog(null, "Oletko varma? Tallennus poistetaan!", "Varoitus",//Ohjelma kysyy haluaako pelaaja varmasti lopetta tallentamatta
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, valinnat, valinnat[0]);										
			if(vastaus == 0){//Jos vastaus on kyllä, niin poistetaan kaikki tiedot
                            jd.putData("delete from tilastot where yrnim='"+YRNIMI+"'");
                            jd.putData("delete from tallennus where pnimi='"+YRNIMI+"'");
                            jd.putData("delete from PMyyja");
                            jd.putData("delete from PTuote");
                            jd.putData("delete from pelaajat where nimi='"+YRNIMI+"'");
                            jd.putData("delete from TMtilastot where yrnim='"+YRNIMI+"'");
                        if(taaksep == false){///Jos peli on sammutettu x näppäimestä
                            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                        }
                        else{//Jos peli on sammutettu taaksepäin näppäimestä
                           j1_Aloitus a = new j1_Aloitus();
                            a.setVisible(true);
                            this.dispose(); 
                        }
                        }
                    break;
                    
                    default:
                    break;
                    
               }} catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void addTableListener() {
        //Listeneri joka kuuntelee muutoksia POstot tableen ja päivittää ne SQL-tietokantaan
        DefaultTableModel model = (DefaultTableModel)POstot.getModel();
        model.addTableModelListener((TableModelEvent e) -> {
            String MV = "";
            //Esto sille, ettei tule overflow virhettä
            if(taulupaivittyy == false){
                int rivi = POstot.getSelectedRow();
                 if(rivi !=-1){
               
                
                  try{ MV = model.getValueAt(rivi, 3).toString();
                if(model.getValueAt(rivi, 3).toString().contains(",")){
                        MV = MV.replace(",",".");
                    }
                    System.out.println(MV);
                  }catch(Exception EX){
                      System.out.println("MV arvo on null");
                  }
            }
            try{
    
                boolean notDecimal = false;
    
                try{
                 
                    Double.parseDouble(MV);
                    
                    jd.putData("update PTuote set myyntihinta = "+MV+" where nimi='"+model.getValueAt(rivi, 0)+"'");
                    LOGI.append("\nTuotteelle " +model.getValueAt(rivi, 0)+ " on asetettu myyntihinnaksi " +MV+ "€");
                    System.out.println("PÄÄSEEE");
                }
                catch(Exception ex){   
                    System.out.println("Virhe");
                }
                paivita();
            }
            catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(j3_Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
            }}
            else{
                System.out.println("Kuuntelija kuuntelee");
            }
        });
        
        POstot.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

    }

    private void PMyyjatTableListeneri() {
  //Listeneri joka kuuntelee muutoksia Pmyyjat tableen ja päivittää ne SQL-tietokantaan
          DefaultTableModel model2 = (DefaultTableModel)PMyyjat.getModel();
          model2.addTableModelListener((TableModelEvent e) -> {
              //Esto sille, ettei tule overflow virhettä
                if(PmyyjaEstot == false){
                    
                boolean notDecimal = false;
                int rivi = PMyyjat.getSelectedRow();
                System.out.println("rivi on " + rivi);
                if(rivi == -1){
                    
                }
                else{
                    System.out.println("Sisällä");
                    logi.setText("Myyjä " + PMyyjat.getValueAt(rivi, 0) + " palkka on muutettu " + PMyyjat.getValueAt(rivi, 1));
                    if(PMyyjat.getValueAt(rivi, 0).equals("Omistaja")){
                        
                     LOGI.append("\nOmistajan palkka on muutettu " + PMyyjat.getValueAt(rivi, 1)+ "€");
                    }else{
                        if(PMyyjat.getValueAt(rivi, 1).equals("0.0€")){
                            JOptionPane.showMessageDialog(null, "Et voi antaa myyjälle 0€ palkkaa");
                            PMyyjat.setValueAt("500.0€",rivi, 1);
                        }else{
                           LOGI.append("\nMyyjä " + PMyyjat.getValueAt(rivi, 0) + " palkka on muutettu " + PMyyjat.getValueAt(rivi, 1)+ "€"); 
                        }
                    }
                    EmptyLog();
                }
                
                }   
            
        });
        
        POstot.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
  
    }
   //Poistaa viimeisen kirjaimen 
   private static String removeLastChar(String str) {
    return str.substring(0, str.length() - 1);
}
   //Roundaa desimaaliarvon kahteen desimaaliin ja palauttaa sen doublena
    public Double roundaaD(double roundattava) {
       roundattava  = (double)Math.round(roundattava * 100000d) / 100000d;
       String vali = String.format("%.2f",roundattava);
       if(vali.contains(",")){
           vali = vali.replaceAll(",",".");
           System.out.println(vali);
       }
       roundattava = Double.valueOf(vali);
    return roundattava;}
    //Roundaa desimaaliarvon kahteen desimaaliin ja palauttaa sen merkkijonona
    public String roundaaS(double roundattava) {
       roundattava  = (double)Math.round(roundattava * 100000d) / 100000d;
       String vali = String.format("%.2f",roundattava);
       if(vali.contains(",")){
           vali = vali.replaceAll(",",".");
           System.out.println(vali);
       }
       //Sen varalta jos tarvitsee pilkkuja desimaalipaikolle
       //DecimalFormat formatter = new DecimalFormat("#,###");
       //vali = formatter.format(Double.valueOf(vali));
    return vali;}
    //Random tapahtumat jotka sattuu tai ei satu kuukauden aikana
    public Double Tapahtuma(Double palkka, String nimi) {
        Random rando = new Random();
        int valitsin = rando.nextInt(30 - 1 + 1) + 1;
        System.out.println("val on " + valitsin);
        if(valitsin>15){
            
        TAPAHTUMATOUTPUT.append("Myyjä "+nimi+" myöhästeli tai sairasteli.\n");
        double satunnaisluku = palkka*0.6 + (palkka*0.8 - palkka*0.6) * rando.nextDouble();
        palkka = palkka - satunnaisluku;
        }
        
        
        
    return palkka;}
    //Metodi joka poistaa kaikki välit
    public String poistav(String luku){
       // luku = luku.replaceAll("\\s", ""); 
    return luku;}
    
}//j3_Paaikkuna.java lopetus
///////////////////////////////////////////
		


					
					 






    
    
    

   
    

   



