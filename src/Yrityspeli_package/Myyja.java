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
public class Myyja {
    private String nimi;//Myyjän nimi
    private Double palkka;//Myyjän palkka
    
    //Konstruktori Myyja classille
public Myyja(String ANimi,Double APalkka){
    this.nimi = ANimi;
    this.palkka = APalkka;
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
     * Palauttaa palkan arvon
     */
    public Double getPalkka() {
        return palkka;
    }

    /**
     * Asettaa palkan arvon
     */
    public void setPalkka(Double palkka) {
        this.palkka = palkka;
    }


}

