/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistré* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class Etudiant extends Personne{


	private Classe classe;

	public Etudiant(int idpersonne, String civilite, String nom, String prenom,
			String numTel, String adresseMail, String numMobile,
			String loginUtilisateur, String mdp, Classe classe) {
		super(idpersonne, civilite, nom, prenom, numTel, adresseMail,
				numMobile, loginUtilisateur, mdp);
		this.classe = classe;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
	
	
}

