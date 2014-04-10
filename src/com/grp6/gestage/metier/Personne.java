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
	private String civilite;
	private String nom;
	private String prenom;
	private int numTel;
	private String adresseMail; 
	private int numMobile; 
	private String loginUtilisateur;
	private String mdp;
	
	
	public Personne(int idpersonne, String civilite, String nom, String prenom,
			int numTel, String adresseMail, int numMobile,
			String loginUtilisateur, String mdp) {
		super();
		this.idpersonne = idpersonne;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.adresseMail = adresseMail;
		this.numMobile = numMobile;
		this.loginUtilisateur = loginUtilisateur;
		this.mdp = mdp;
	}
	
	
	public int getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
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
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public int getNumMobile() {
		return numMobile;
	}
	public void setNumMobile(int numMobile) {
		this.numMobile = numMobile;
	}
	public String getLoginUtilisateur() {
		return loginUtilisateur;
	}
	public void setLoginUtilisateur(String loginUtilisateur) {
		this.loginUtilisateur = loginUtilisateur;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	} 
	
	
	
	
	



}

