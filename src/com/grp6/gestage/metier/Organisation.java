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
	private int cpOrganisation;
	private int telOrganisation;
	private int faxOrganisation;
	private String formeJuridique;
	private String activite;
	
	
	
	public Organisation(int idOrganisation, String nomOrganisation,
			String villeOrganisation, int cpOrganisation, int telOrganisation,
			int faxOrganisation, String formeJuridique, String activite) {
		super();
		this.idOrganisation = idOrganisation;
		this.nomOrganisation = nomOrganisation;
		this.villeOrganisation = villeOrganisation;
		this.cpOrganisation = cpOrganisation;
		this.telOrganisation = telOrganisation;
		this.faxOrganisation = faxOrganisation;
		this.formeJuridique = formeJuridique;
		this.activite = activite;
	}



	public int getIdOrganisation() {
		return idOrganisation;
	}



	public void setIdOrganisation(int idOrganisation) {
		this.idOrganisation = idOrganisation;
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



	public int getCpOrganisation() {
		return cpOrganisation;
	}



	public void setCpOrganisation(int cpOrganisation) {
		this.cpOrganisation = cpOrganisation;
	}



	public int getTelOrganisation() {
		return telOrganisation;
	}



	public void setTelOrganisation(int telOrganisation) {
		this.telOrganisation = telOrganisation;
	}



	public int getFaxOrganisation() {
		return faxOrganisation;
	}



	public void setFaxOrganisation(int faxOrganisation) {
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

