package com.grp6.gestage.fonction;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.grp6.gestage.library.DatabaseHandler;
import com.grp6.gestage.library.JSONParser;
import com.grp6.gestage.metier.AnneeScol;
import com.grp6.gestage.metier.Classe;
import com.grp6.gestage.metier.Etudiant;
import com.grp6.gestage.metier.Filiere;
import com.grp6.gestage.metier.MaitreStage;
import com.grp6.gestage.metier.Organisation;
import com.grp6.gestage.metier.Personne;
import com.grp6.gestage.metier.Stage;

public class StageF  extends Config {

	private JSONParser jsonParser;
	
	

	// constructor
	public StageF( ){
		jsonParser = new JSONParser( );
	}
	
	
	
	public List<Stage> getSelected(int numClasse) throws JSONException, IllegalStateException, IOException{
		ArrayList<Stage> lesStages = new ArrayList<Stage>();
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "stage"));
		params.add(new BasicNameValuePair("fonc", "getSelected"));
		params.add(new BasicNameValuePair("classe",Integer.toString(numClasse)));
		
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		JSONArray json_Stages = json.getJSONArray("stages");
		for (int i = 0; i < json_Stages.length(); i++) {
		
			lesStages.add(chargerUnEnregistrement((JSONObject) json_Stages.get(i)));
		
			}
	
	
		return lesStages;
	}
	public Stage getOne(int numStage) throws JSONException, IllegalStateException, IOException{
		Stage unStage = new Stage(0, null, null, null, null, null, null, null, null, null, null, null, null, false);
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "stage"));
		params.add(new BasicNameValuePair("fonc", "getOne"));
		params.add(new BasicNameValuePair("idStage",Integer.toString(numStage)));
		
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		JSONArray json_Stages = json.getJSONArray("stage");

		unStage = chargerUnEnregistrement((JSONObject) json_Stages.get(0));
		
	
		return unStage;
	}

	public boolean setOne(Stage unStage)throws JSONException, IllegalStateException, IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "stage"));
		params.add(new BasicNameValuePair("fonc", "setOne"));
		params.add(new BasicNameValuePair("num_stage",Integer.toString(unStage.getNum_stage())));
		params.add(new BasicNameValuePair("organisation", Integer.toString(unStage.getOrganisation().getIdOrganisation())));
		params.add(new BasicNameValuePair("dateDebut", sdf.format(unStage.getDateDebut())));
		params.add(new BasicNameValuePair("dateFin", sdf.format(unStage.getDateFin())));
		params.add(new BasicNameValuePair("dateVisiteStage", sdf.format(unStage.getDateVisiteStage())));
		params.add(new BasicNameValuePair("divers", unStage.getDivers()));
		params.add(new BasicNameValuePair("bilanTravaux", unStage.getBilanTravaux()));
		params.add(new BasicNameValuePair("ressourcesOutils", unStage.getRessourcesOutils()));
		params.add(new BasicNameValuePair("commentaires", unStage.getCommentaires()));
		if(unStage.isParticipationCcf()){
			params.add(new BasicNameValuePair("participationCcf", "1"));
		}else{
			params.add(new BasicNameValuePair("participationCcf", "0"));
		}
		
		
		
		
		
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		//JSONArray json_Stages = json.getJSONArray("stage");
		
		boolean ok = json.getBoolean("succes");
		return ok;
	}
	private Stage chargerUnEnregistrement(JSONObject json){
		Stage unStage = new Stage(0,null,null,null,null,null,null, null, null, null, null, null, null, false);
		try {

			unStage.setNum_stage(json.getInt("numStage"));
			try {
				unStage.setDateFin(sdf.parse(json.getString("dateFin")));
				unStage.setDateDebut(sdf.parse(json.getString("dateDebut")));
				unStage.setDateVisiteStage(sdf.parse(json.getString("dateVisite")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			unStage.setBilanTravaux(json.getString("bilanTravaux"));
			unStage.setCommentaires(json.getString("commentaires"));
			unStage.setDivers(json.getString("divers"));
			unStage.setVille(json.getString("ville"));
			//unStage.setParticipationCcf(json.getBoolean("participationCCF"));
			unStage.setRessourcesOutils(json.getString("ressourcesOutils"));
			JSONObject json_Organisation = json.getJSONObject("organisation");
			JSONObject json_Etudiant = json.getJSONObject("etudiant");
			JSONObject json_MaitreStage = json.getJSONObject("maitreStage");
			JSONObject json_anneeScol = json.getJSONObject("anneeScol");
		
			AnneeScol uneAnneeScol = AnneeScolF.chargerUnEnregistrement(json_anneeScol);
			unStage.setAnneescol(uneAnneeScol);
			Etudiant unEtudiant = EtudiantF.chargerUnEnregistrement(json_Etudiant);
			unStage.setEtudiant(unEtudiant);
			MaitreStage unMaitreStage = MaitreStageF.chargerUnEnregistrement(json_MaitreStage);
			unStage.setMaitreStage(unMaitreStage);
			Organisation uneOrganisation = OrganisationF.chargerUnEnregistrement(json_Organisation);
			unStage.setOrganisation(uneOrganisation);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unStage;
	}




	
}
