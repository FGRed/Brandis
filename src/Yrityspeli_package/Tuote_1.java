/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;//Tämä tuote on ostettavissa oleva tuote, eli tuote
                           //jolla ei ole vielä määrää eikä myyntihintaa.

/**
 *
 * @author Timo
 */
//Esittelee muuttujat
public class Tuote_1 {
private String nimi;//Tuotteen nimi
private Double hinta;//Tuotteen ostohinta
    
//Konstruktori Tuote_1 classille
public Tuote_1(String ANimi,Double AHinta){
    this.nimi = ANimi;
    this.hinta = AHinta;
}

    /**
     * Palauttaa nimen arvon
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Asettaa nimen arvon
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

   
    /**
     * Palauttaa hinnan arvon
     */
    public Double getHinta() {
        return hinta;
    }

    /**
     * Asettaa hinnan arvon
     */
    public void setHinta(Double hinta) {
        this.hinta = hinta;
    }
    
}
