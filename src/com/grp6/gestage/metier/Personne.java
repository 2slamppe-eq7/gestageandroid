/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistré* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class Personne {
	// Inners Classifiers

	private int idpersonne;
	private String nom;
	private String prenom;
	private String loginUtilisateur;
	
	public Personne(int idpersonne, String nom, String prenom,
			String loginUtilisateur) {
		super();
		this.idpersonne = idpersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.loginUtilisateur = loginUtilisateur;
	}
	@Override
	public String toString() {
		return "Personne [idpersonne=" + idpersonne + ", nom=" + nom
				+ ", prenom=" + prenom + ", loginUtilisateur="
				+ loginUtilisateur + "]";
	}
	public int getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLoginUtilisateur() {
		return loginUtilisateur;
	}
	public void setLoginUtilisateur(String loginUtilisateur) {
		this.loginUtilisateur = loginUtilisateur;
	}



}

