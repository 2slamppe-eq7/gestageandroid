/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistré* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class Classe {

	private int numClasse;
	private int idSpecialite;
	private String nomClasse;
	
	public Classe(int numClasse, int idSpecialite, String nomClasse) {
		super();
		this.numClasse = numClasse;
		this.idSpecialite = idSpecialite;
		this.nomClasse = nomClasse;
	}

	public int getNumClasse() {
		return numClasse;
	}

	public void setNumClasse(int numClasse) {
		this.numClasse = numClasse;
	}

	public int getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	
	
}

