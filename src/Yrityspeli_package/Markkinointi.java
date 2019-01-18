/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

/**
 *
 * @author Timo
 */

    //Esittelee muuttujat
public class Markkinointi {
    private String mtyyppi;//Markkinointi tyyppi(tv,lehti,internet jne.).
    private Double kkmaara;//Miten monta kuukautta markkinointi on voimassa.
    
    //Konstruktori Markkinointi classille
public Markkinointi(String AMTyyppi,Double AKKMaara){
    this.mtyyppi = AMTyyppi;
    this.kkmaara = AKKMaara;
}

    /**
     * Palauttaa Mtyypin arvon
     */
    public String getMtyyppi() {
        return mtyyppi;
    }

    /**
     * Asettaa Mtyypille arvon
     */
    public void setMtyyppi(String mtyyppi) {
        this.mtyyppi = mtyyppi;
    }

    /**
     * Palauttaa Kkmaaran arvon
     */
    public Double getKkmaara() {
        return kkmaara;
    }

    /**
     * Asettaa Kkmaaran arvon
     */
    public void setKkmaara(Double kkmaara) {
        this.kkmaara = kkmaara;
    }
}
