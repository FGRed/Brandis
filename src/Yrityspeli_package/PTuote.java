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
public class PTuote {
    private String nimi;
    private Double Hinta;
    private int Maara;
    private Double MyyntiHinta;
    private int ID;
 public PTuote(int ID,String aNimi, Double aHinta, int aMaara, Double aMyyntihinta){
     this.nimi = aNimi;
     this.Hinta = aHinta;
     this.Maara = aMaara;
     this.MyyntiHinta = aMyyntihinta;
     this.ID = ID;
     
     
 }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the Hinta
     */
    public Double getHinta() {
        return Hinta;
    }

    /**
     * @param Hinta the Hinta to set
     */
    public void setHinta(Double Hinta) {
        this.Hinta = Hinta;
    }

    /**
     * @return the Maara
     */
    public int getMaara() {
        return Maara;
    }

    /**
     * @param Maara the Maara to set
     */
    public void setMaara(int Maara) {
        this.Maara = Maara;
    }

    /**
     * @return the MyyntiHinta
     */
    public Double getMyyntiHinta() {
        return MyyntiHinta;
    }

    /**
     * @param MyyntiHinta the MyyntiHinta to set
     */
    public void setMyyntiHinta(Double MyyntiHinta) {
        this.MyyntiHinta = MyyntiHinta;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    @Override
    public String toString(){
        return ID + " " + nimi + " " + Hinta + " " + MyyntiHinta + " " + Maara;
    }
}



