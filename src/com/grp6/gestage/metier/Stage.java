/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistré* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;

import java.util.Date;


public class Stage {

	private int num_stage;
	private Organisation organisation; 
	private AnneeScol anneescol;
	private MaitreStage maitreStage;
	private Date dateDebut;
	private Date dateFin; 
	private Date dateVisiteStage;
	private String ville; 
	private String divers; 
	private String bilanTravaux; 
	private String ressourcesOutils;
	private String commentaires;
	private boolean participationCcf;
	
	
	public Stage(int num_stage, Organisation organisation, AnneeScol anneescol,
			MaitreStage maitreStage, Date dateDebut, Date dateFin,
			Date dateVisiteStage, String ville, String divers,
			String bilanTravaux, String ressourcesOutils, String commentaires,
			boolean participationCcf) {
		super();
		this.num_stage = num_stage;
		this.organisation = organisation;
		this.anneescol = anneescol;
		this.maitreStage = maitreStage;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateVisiteStage = dateVisiteStage;
		this.ville = ville;
		this.divers = divers;
		this.bilanTravaux = bilanTravaux;
		this.ressourcesOutils = ressourcesOutils;
		this.commentaires = commentaires;
		this.participationCcf = participationCcf;
	}


	public int getNum_stage() {
		return num_stage;
	}


	public void setNum_stage(int num_stage) {
		this.num_stage = num_stage;
	}


	public Organisation getOrganisation() {
		return organisation;
	}


	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}


	public AnneeScol getAnneescol() {
		return anneescol;
	}


	public void setAnneescol(AnneeScol anneescol) {
		this.anneescol = anneescol;
	}


	public MaitreStage getMaitreStage() {
		return maitreStage;
	}


	public void setMaitreStage(MaitreStage maitreStage) {
		this.maitreStage = maitreStage;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Date getDateVisiteStage() {
		return dateVisiteStage;
	}


	public void setDateVisiteStage(Date dateVisiteStage) {
		this.dateVisiteStage = dateVisiteStage;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getDivers() {
		return divers;
	}


	public void setDivers(String divers) {
		this.divers = divers;
	}


	public String getBilanTravaux() {
		return bilanTravaux;
	}


	public void setBilanTravaux(String bilanTravaux) {
		this.bilanTravaux = bilanTravaux;
	}


	public String getRessourcesOutils() {
		return ressourcesOutils;
	}


	public void setRessourcesOutils(String ressourcesOutils) {
		this.ressourcesOutils = ressourcesOutils;
	}


	public String getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}


	public boolean isParticipationCcf() {
		return participationCcf;
	}


	public void setParticipationCcf(boolean participationCcf) {
		this.participationCcf = participationCcf;
	}
	
	
	
	
	

}

