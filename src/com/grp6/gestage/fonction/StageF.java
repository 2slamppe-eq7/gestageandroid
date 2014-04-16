package com.grp6.gestage.fonction;

import java.io.IOException;
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
import com.grp6.gestage.metier.Filiere;
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
			//	JSONObject catObj = (JSONObject) json_chantier.get(i);

			lesStages.add(chargerUnEnregistrement((JSONObject) json_Stages.get(i)));

			}
	
	
		return lesStages;
	}

	
	private Stage chargerUnEnregistrement(JSONObject json){
		Stage unStage = new Stage(0,null,null,null,null,null, null, null, null, null, null, null, null, false);
		try {

			unStage.setNum_stage(json.getInt("numStage"));
			unStage.setDateFin((Date)json.get("dateFin"));
			unStage.setDateDebut((Date)json.get("dateDebut"));
			unStage.setDateVisiteStage((Date)json.get("dateVisiteStage"));
			unStage.setBilanTravaux(json.getString("bilanTravaux"));
			unStage.setCommentaires(json.getString("commentaires"));
			unStage.setDivers(json.getString("divers"));
			unStage.setParticipationCcf(json.getBoolean("participationCCF"));
			unStage.setRessourcesOutils(json.getString("ressourcesOutils"));
			JSONArray json_Organisation = json.getJSONArray("Organisation");
			
			
		//	uneClasse.setSpecialite(idSpecialite)
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unStage;
	}
	
}
