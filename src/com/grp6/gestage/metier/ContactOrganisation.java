/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistré* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class ContactOrganisation extends Personne{

	private String fonction;

	public ContactOrganisation(int idpersonne, String civilite, String nom,
			String prenom, String numTel, String adresseMail, String numMobile,
			String loginUtilisateur, String mdp, String fonction) {
		super(idpersonne, civilite, nom, prenom, numTel, adresseMail,
				numMobile, loginUtilisateur, mdp);
		this.fonction = fonction;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	} 
	
	
	
	
}

