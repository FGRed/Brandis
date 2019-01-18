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
public class Kuukaudet {
				private String Tammikuu, Helmikuu ,Maaliskuu
				,Huhtikuu
				 ,Toukokuu
				,Kesäkuu
				 ,Heinäkuu
				  ,Elokuu
				  ,Syyskuu
					,Lokakuu
					,Marraskuu
					,Joulukuu;							
										
				public Kuukaudet(String Tammikuu, String Helmikuu, String Maaliskuu, String Huhtikuu, String Toukokuu, String Kesäkuu, String Heinäkuu, String Elokuu, String Syyskuu, String Lokakuu,
												String Marraskuu, String Joulukuu){
									this.Tammikuu = Tammikuu;
									this.Helmikuu = Helmikuu;
									this.Maaliskuu = Maaliskuu;
									this.Toukokuu = Toukokuu;
									this.Kesäkuu = Kesäkuu;
									this.Heinäkuu = Heinäkuu;
									this.Elokuu = Elokuu;
									this.Syyskuu = Syyskuu;
									this.Lokakuu = Lokakuu;
									this.Marraskuu = Marraskuu;
									this.Joulukuu = Joulukuu;
									
									
				}

					/**
					 * @return the Tammikuu
					 */
					public String getTammikuuPM() {
										String PM = String.valueOf(31);
										return PM;
					}
				
				
}
