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

/**
 * Class ClasseF
 * 
 * @author windows
 *
 */
public class ClasseF  extends Config {

	private JSONParser jsonParser;

	/**
	 * Constructor
	 */
	public ClasseF( ){
		jsonParser = new JSONParser( );
	}
	
	
	/**
	 * Method getSelected
	 * 
	 * @param annee
	 * @param numFiliere
	 * @return
	 * @throws JSONException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
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
			lesClasses.add(chargerUnEnregistrement((JSONObject) json_Classes.get(i)));
			}

		return lesClasses;
	}

	/**
	 * Method chargerUnEnregistrement
	 * 
	 * @param json
	 * @return
	 */
	public static Classe chargerUnEnregistrement(JSONObject json){
		Classe uneClasse = new Classe( 0, null, null);
		try {

			uneClasse.setNumClasse(json.getInt("numClasse"));
			uneClasse.setNomClasse(json.getString("nomClasse"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uneClasse;
	}
	
}
