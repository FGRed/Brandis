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
public class Laina {
    private String pankki;//Pankin nimi mistä laina on otettu
    private int maara;//Lainan määrä
    private int maksuaika;//Lainan maksuaika
    private Double korko;//lainan korko
    
    //Konstruktori laina classille
public Laina(String APankki,int AMaara,int AMaksuaika,Double AKorko){
    this.pankki = APankki;
    this.maara = AMaara;
    this.maksuaika = AMaksuaika;
    this.korko = AKorko;
}

    /**
     * Palauttaa pankin arvon
     */
    public String getPankki() {
        return pankki;
    }

    /**
     * Asettaa pankille arvon
     */
    public void setPankki(String pankki) {
        this.pankki = pankki;
    }

    /**
     * Palauttaa maaran arvon
     */
    public int getMaara() {
        return maara;
    }

    /**
     * Asettaa maaralle arvon
     */
    public void setMaara(int maara) {
        this.maara = maara;
    }

    /**
     * Palauttaa maksuajan arvon
     */
    public int getMaksuaika() {
        return maksuaika;
    }

    /**
     * Asettaa maksuajalle arvon
     */
    public void setMaksuaika(int maksuaika) {
        this.maksuaika = maksuaika;
    }

    /**
     * Palauttaa koron arvon
     */
    public Double getKorko() {
        return korko;
    }

    /**
     * Asettaa korolle arvon
     */
    public void setKorko(Double korko) {
        this.korko = korko;
    }
    
}
