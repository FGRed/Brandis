/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;

/**
 *
 * @author Niko
 */
    //Esittelee muuttujat
public class Peli {
	private String Nimi;//Yrityksen nimi
	private String Slogan;//Yrityksen slogan
	private double Omaisuus;//Yrityksen omaisuus
	private String aika;
	private String lpvm;

    //Konstruktori Peli classille
    public Peli(String aNimi, String aSlogan, double aOmaisuus, String aika, String lpvm){
	this.Nimi = aNimi;
	this.Slogan = aSlogan;
	this.Omaisuus = aOmaisuus;
	this.aika = aika;
	this.lpvm = lpvm;
    }

/**
 * Palauttaa nimen arvon
 */
    public String getNimi() {
	return Nimi;
    }
    
/**
* Asettaa nimelle arvon
 */
    public void setNimi(String Nimi) {
	this.Nimi = Nimi;
    }

/**
* Palauttaa sloganin arvon
 */
    public String getSlogan() {
	return Slogan;
    }

/**
* Asettaa sloganin arvon
 */
    public void setSlogan(String Slogan) {
	this.Slogan = Slogan;
    }

/**
* Palauttaa omaisuuden arvon
 */
    public double getOmaisuus() {
	return Omaisuus;
    }

/**
* Asettaa omaisuuden arvon
 */
    public void setOmaisuus(double Omaisuus) {
	this.Omaisuus = Omaisuus;
    }

					/**
					 * @return the aika
					 */
					public String getAika() {
										return aika;
					}

					/**
					 * @param aika the aika to set
					 */
					public void setAika(String aika) {
										this.aika = aika;
					}

					/**
					 * @return the lpvm
					 */
					public String getLpvm() {
										return lpvm;
					}

					/**
					 * @param lpvm the lpvm to set
					 */
					public void setLpvm(String lpvm) {
										this.lpvm = lpvm;
					}
}
