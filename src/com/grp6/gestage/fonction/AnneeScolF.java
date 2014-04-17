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
import com.grp6.gestage.metier.Personne;

/**
 * Class AnneeScolF
 * 
 * @author windows
 *
 */
public class AnneeScolF  extends Config {

	/**
	 * Variable
	 */
	private JSONParser jsonParser;
	
	/**
	 * Constructor
	 */
	public AnneeScolF( ){
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
	public List<AnneeScol> getAll() throws JSONException, IllegalStateException, IOException{
		ArrayList<AnneeScol> lesAnneeScols = new ArrayList<AnneeScol>();
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "annee"));
		params.add(new BasicNameValuePair("fonc", "getAll"));
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		JSONArray json_annees = json.getJSONArray("annees");
		
		for (int i = 0; i < json_annees.length(); i++) {
			lesAnneeScols.add(chargerUnEnregistrement((JSONObject) json_annees.get(i)));
			}
	
		return lesAnneeScols;
	}

	/**
	 * Method chargerUnEnregistrement
	 * 
	 * @param json
	 * @return
	 */
	public static AnneeScol chargerUnEnregistrement(JSONObject json){
		AnneeScol uneAnneeScol = new AnneeScol(null);
		try {

			uneAnneeScol.setAnneeScol(json.getString("annee"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uneAnneeScol;
	}
	
}
