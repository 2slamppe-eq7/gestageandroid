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
	private Specialite specialite;
	private String nomClasse;
	public Classe(int numClasse, Specialite specialite, String nomClasse) {
		super();
		this.numClasse = numClasse;
		this.specialite = specialite;
		this.nomClasse = nomClasse;
	}
	public int getNumClasse() {
		return numClasse;
	}
	public void setNumClasse(int numClasse) {
		this.numClasse = numClasse;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public String getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	
	
	
}

