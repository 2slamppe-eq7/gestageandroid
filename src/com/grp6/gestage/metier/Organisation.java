/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistré* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class Organisation {
	// Inners Classifiers

	private int idOrganisation; 
	private String nomOrganisation; 
	private String villeOrganisation;
	private String cpOrganisation;
	private String telOrganisation;
	private String faxOrganisation;
	private String formeJuridique;
	private String activite;
	private String adresse;
	
	
	
	public Organisation(int idOrganisation, String nomOrganisation,
			String villeOrganisation, String cpOrganisation, String telOrganisation,
			String faxOrganisation,String adresse, String formeJuridique, String activite) {
		super();
		this.idOrganisation = idOrganisation;
		this.nomOrganisation = nomOrganisation;
		this.villeOrganisation = villeOrganisation;
		this.cpOrganisation = cpOrganisation;
		this.telOrganisation = telOrganisation;
		this.faxOrganisation = faxOrganisation;
		this.formeJuridique = formeJuridique;
		this.activite = activite;
		this.adresse = adresse;
	}



	public int getIdOrganisation() {
		return idOrganisation;
	}



	public void setIdOrganisation(int idOrganisation) {
		this.idOrganisation = idOrganisation;
	}

	public String getAdresse() {
		return this.adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNomOrganisation() {
		return nomOrganisation;
	}



	public void setNomOrganisation(String nomOrganisation) {
		this.nomOrganisation = nomOrganisation;
	}



	public String getVilleOrganisation() {
		return villeOrganisation;
	}



	public void setVilleOrganisation(String villeOrganisation) {
		this.villeOrganisation = villeOrganisation;
	}



	public String getCpOrganisation() {
		return cpOrganisation;
	}



	public void setCpOrganisation(String cpOrganisation) {
		this.cpOrganisation = cpOrganisation;
	}



	public String getTelOrganisation() {
		return telOrganisation;
	}



	public void setTelOrganisation(String telOrganisation) {
		this.telOrganisation = telOrganisation;
	}



	public String getFaxOrganisation() {
		return faxOrganisation;
	}



	public void setFaxOrganisation(String faxOrganisation) {
		this.faxOrganisation = faxOrganisation;
	}



	public String getFormeJuridique() {
		return formeJuridique;
	}



	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}



	public String getActivite() {
		return activite;
	}



	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	
	



}

