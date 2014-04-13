package com.grp6.gestage.fonction;

import java.io.IOException;
import java.util.ArrayList;
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

public class ClasseF  extends Config {

	private JSONParser jsonParser;
	
	

	// constructor
	public ClasseF( ){
		jsonParser = new JSONParser( );
	}
	
	
	
	public List<Classe> getSelected(String annee, int numFiliere) throws JSONException, IllegalStateException, IOException{
		ArrayList<Classe> lesClasses = new ArrayList<Classe>();
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "classe"));
		params.add(new BasicNameValuePair("fonc", "getSelected"));
		params.add(new BasicNameValuePair("annee", annee));
		params.add(new BasicNameValuePair("filiere",Integer.toString(numFiliere)));
		
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		JSONArray json_Classes = json.getJSONArray("classes");
		for (int i = 0; i < json_Classes.length(); i++) {
			//	JSONObject catObj = (JSONObject) json_chantier.get(i);
			lesClasses.add(chargerUnEnregistrement((JSONObject) json_Classes.get(i)));
			//	lesChantiers.add(cat);
			}
	
		
	
		return lesClasses;
	}

	
	private Classe chargerUnEnregistrement(JSONObject json){
		Classe uneClasse = new Classe( 0, null, null);
		try {

			uneClasse.setNumClasse(json.getInt("numClasse"));
			uneClasse.setNomClasse(json.getString("nomClasse"));
			
			
		//	uneClasse.setSpecialite(idSpecialite)
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uneClasse;
	}
	
}
