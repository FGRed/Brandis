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
public class Tilastot {
					private String yrnim;
					private double paiva, kassa, tapahtunutmyynti, myyjienpalkat, lainanmaksu, markkinointikulut, tuotteidenostohinnat, vesi, sahko, kuljetus,
													huolto, omistajanpalkka, taloushallinto, lainankorko, hyvantekevaisuus, palkojensivukulut;
					private int havikki;

					public Tilastot(String yrnim, double paiva, double kassa, double tapahtunutmyynti, double myyjienpalkat, double lainanmaksu, double markkinointikulut, double tuotteidenostohinnat, double vesi, double sahko, double kuljetus,
													double huolto, double omistajanpalkka, double taloushallinto, double lainankorko, double hyvantekevaisuus, double palkojensivukulut) {
										this.yrnim = yrnim;
										this.paiva = paiva;
										this.kassa = kassa;
										this.tapahtunutmyynti = tapahtunutmyynti;
										this.myyjienpalkat = myyjienpalkat;
										this.lainanmaksu = lainanmaksu;
										this.markkinointikulut = markkinointikulut;
										this.tuotteidenostohinnat = tuotteidenostohinnat;
										this.vesi = vesi;
										this.sahko = sahko;
										this.kuljetus = kuljetus;
										this.huolto = huolto;
										this.omistajanpalkka = omistajanpalkka;
										this.taloushallinto = taloushallinto;
										this.lainankorko = lainankorko;
										this.hyvantekevaisuus = hyvantekevaisuus;
										this.palkojensivukulut = palkojensivukulut;
					
										
      }
					/**
					 * @return the yrnim
					 */
					public String getYrnim() {
										return yrnim;
					}

					/**
					 * @param yrnim the yrnim to set
					 */
					public void setYrnim(String yrnim) {
										this.yrnim = yrnim;
					}

					/**
					 * @return the paiva
					 */
					public double getPaiva() {
										return paiva;
					}

					/**
					 * @param paiva the paiva to set
					 */
					public void setPaiva(double paiva) {
										this.paiva = paiva;
					}

					/**
					 * @return the kassa
					 */
					public double getKassa() {
										return kassa;
					}

					/**
					 * @param kassa the kassa to set
					 */
					public void setKassa(double kassa) {
										this.kassa = kassa;
					}

					/**
					 * @return the tapahtunutmyynti
					 */
					public double getTapahtunutmyynti() {
										return tapahtunutmyynti;
					}

					/**
					 * @param tapahtunutmyynti the tapahtunutmyynti to set
					 */
					public void setTapahtunutmyynti(double tapahtunutmyynti) {
										this.tapahtunutmyynti = tapahtunutmyynti;
					}

					/**
					 * @return the myyjienpalkat
					 */
					public double getMyyjienpalkat() {
										return myyjienpalkat;
					}

					/**
					 * @param myyjienpalkat the myyjienpalkat to set
					 */
					public void setMyyjienpalkat(double myyjienpalkat) {
										this.myyjienpalkat = myyjienpalkat;
					}

					/**
					 * @return the lainanmaksu
					 */
					public double getLainanmaksu() {
										return lainanmaksu;
					}

					/**
					 * @param lainanmaksu the lainanmaksu to set
					 */
					public void setLainanmaksu(double lainanmaksu) {
										this.lainanmaksu = lainanmaksu;
					}

					/**
					 * @return the markkinointikulut
					 */
					public double getMarkkinointikulut() {
										return markkinointikulut;
					}

					/**
					 * @param markkinointikulut the markkinointikulut to set
					 */
					public void setMarkkinointikulut(double markkinointikulut) {
										this.markkinointikulut = markkinointikulut;
					}

					/**
					 * @return the tuotteidenostohinnat
					 */
					public double getTuotteidenostohinnat() {
										return tuotteidenostohinnat;
					}

					/**
					 * @param tuotteidenostohinnat the tuotteidenostohinnat to set
					 */
					public void setTuotteidenostohinnat(double tuotteidenostohinnat) {
										this.tuotteidenostohinnat = tuotteidenostohinnat;
					}

					/**
					 * @return the vesi
					 */
					public double getVesi() {
										return vesi;
					}

					/**
					 * @param vesi the vesi to set
					 */
					public void setVesi(double vesi) {
										this.vesi = vesi;
					}

					/**
					 * @return the sahko
					 */
					public double getSahko() {
										return sahko;
					}

					/**
					 * @param sahko the sahko to set
					 */
					public void setSahko(double sahko) {
										this.sahko = sahko;
					}

					/**
					 * @return the kuljetus
					 */
					public double getKuljetus() {
										return kuljetus;
					}

					/**
					 * @param kuljetus the kuljetus to set
					 */
					public void setKuljetus(double kuljetus) {
										this.kuljetus = kuljetus;
					}

					/**
					 * @return the huolto
					 */
					public double getHuolto() {
										return huolto;
					}

					/**
					 * @param huolto the huolto to set
					 */
					public void setHuolto(double huolto) {
										this.huolto = huolto;
					}

					/**
					 * @return the omistajanpalkka
					 */
					public double getOmistajanpalkka() {
										return omistajanpalkka;
					}

					/**
					 * @param omistajanpalkka the omistajanpalkka to set
					 */
					public void setOmistajanpalkka(double omistajanpalkka) {
										this.omistajanpalkka = omistajanpalkka;
					}

					/**
					 * @return the taloushallinto
					 */
					public double getTaloushallinto() {
										return taloushallinto;
					}

					/**
					 * @param taloushallinto the taloushallinto to set
					 */
					public void setTaloushallinto(double taloushallinto) {
										this.taloushallinto = taloushallinto;
					}

					/**
					 * @return the lainankorko
					 */
					public double getLainankorko() {
										return lainankorko;
					}

					/**
					 * @param lainankorko the lainankorko to set
					 */
					public void setLainankorko(double lainankorko) {
										this.lainankorko = lainankorko;
					}

					/**
					 * @return the hyvantekevaisuus
					 */
					public double getHyvantekevaisuus() {
										return hyvantekevaisuus;
					}

					/**
					 * @param hyvantekevaisuus the hyvantekevaisuus to set
					 */
					public void setHyvantekevaisuus(double hyvantekevaisuus) {
										this.hyvantekevaisuus = hyvantekevaisuus;
					}

					/**
					 * @return the palkojensivukulut
					 */
					public double getPalkojensivukulut() {
										return palkojensivukulut;
					}

					/**
					 * @param palkojensivukulut the palkojensivukulut to set
					 */
					public void setPalkojensivukulut(double palkojensivukulut) {
										this.palkojensivukulut = palkojensivukulut;
					}

					/**
					 * @return the havikki
					 */
					public int getHavikki() {
										return havikki;
					}

					/**
					 * @param havikki the havikki to set
					 */
					public void setHavikki(int havikki) {
										this.havikki = havikki;
					}
													
				
}
