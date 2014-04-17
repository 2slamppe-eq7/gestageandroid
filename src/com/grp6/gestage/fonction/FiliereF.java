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
import com.grp6.gestage.metier.Filiere;
import com.grp6.gestage.metier.Personne;

/**
 * Class FiliereF
 * 
 * @author windows
 *
 */
public class FiliereF  extends Config {

	/**
	 * Variable
	 */
	private JSONParser jsonParser;

	/**
	 * Constructor
	 */
	public FiliereF( ){
		jsonParser = new JSONParser( );
	}
	
	/**
	 * Method getAll
	 * 
	 * @return
	 * @throws JSONException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public List<Filiere> getAll() throws JSONException, IllegalStateException, IOException{
		ArrayList<Filiere> lesFilieres = new ArrayList<Filiere>();
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "filiere"));
		params.add(new BasicNameValuePair("fonc", "getAll"));
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		JSONArray json_Filieres = json.getJSONArray("filieres");
		
		for (int i = 0; i < json_Filieres.length(); i++) {
			lesFilieres.add(chargerUnEnregistrement((JSONObject) json_Filieres.get(i)));
			}

		return lesFilieres;
	}

	/**
	 * Method chargerUnEnregistrement
	 * 
	 * @param json
	 * @return
	 */
	private Filiere chargerUnEnregistrement(JSONObject json){
		Filiere uneFiliere = new Filiere(0, null);
		try {

			uneFiliere.setNumFiliere(json.getInt("numFiliere"));
			uneFiliere.setLibelleFiliere(json.getString("libelleFiliere"));		
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uneFiliere;
	}
	
}
