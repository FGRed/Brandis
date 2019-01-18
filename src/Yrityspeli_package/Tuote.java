/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;//Tämä tuote on pelaajan ostama tuote, eli tuote 
                           //jolle on annettu määrä ja myyntihinta.

/**
 *
 * @author Timo
 */
//Esittelee muuttujat
public class Tuote {
private String nimi;//Tuotteen nimi
private Double mhinta;//Tuotteen myyntihinta
private Double hinta;//Tuotteen ostohinta
private int maara;//Miten paljon tuotetta ostetaan
    
//Konstruktori Tuote classille
public Tuote(String ANimi,Double AMHinta,Double AHinta,int AMaara){
    this.nimi = ANimi;
    this.mhinta = AMHinta;
    this.hinta = AHinta;
    this.maara = AMaara;
}

    /**
     * Palauttaa nimen arvon
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Asettaa nimelle arvon
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Palauttaa Mhinnan arvon
     */
    public Double getMhinta() {
        return mhinta;
    }

    /**
     * Asettaa Mhinnan arvon
     */
    public void setMhinta(Double mhinta) {
        this.mhinta = mhinta;
    }

    /**
     * Palauttaa hinnan arvon
     */
    public Double getHinta() {
        return hinta;
    }

    /**
     * Asettaa hinnalle arvon
     */
    public void setHinta(Double hinta) {
        this.hinta = hinta;
    }

    /**
     * Palauttaa maaran arvon
     */
    public int getMaara() {
        return maara;
    }

    /**
     * Asettaa maaran arvon
     */
    public void setMaara(int maara) {
        this.maara = maara;
    }


    
    
}
