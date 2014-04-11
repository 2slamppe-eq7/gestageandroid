package com.grp6.gestage.fonction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.grp6.gestage.library.DatabaseHandler;
import com.grp6.gestage.library.JSONParser;
import com.grp6.gestage.metier.Personne;

public class PersonneF  extends Config {

	private JSONParser jsonParser;
	
	
	private static String login_tag = "login";
	private static String register_tag = "register";
	
	// constructor
	public PersonneF(  ){
		jsonParser = new JSONParser( );
	}
	
	/**
	 * function make Login Request
	 * @param email
	 * @param password
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * */
	public JSONObject connexionEmploye(String login, String password) throws IllegalStateException, IOException{
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "personne"));
		params.add(new BasicNameValuePair("fonc", "connexion"));
		params.add(new BasicNameValuePair("login", login));
		params.add(new BasicNameValuePair("mdp", password));
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		// return json
		// Log.e("JSON", json.toString());
		return json;
	}
	

	
	/**
	 * Function get Login status
	 * */
	public boolean isUserLoggedIn(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		int count = db.getRowCount();
		if(count > 0){
			// user logged in
			return true;
		}
		return false;
	}
	
	/**
	 * Function to logout user
	 * Reset Database
	 * */
	public boolean logoutUser(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		db.resetTables();
		return true;
	}
	
	public List<Personne> getAll() throws IllegalStateException, IOException{
		ArrayList<Personne> lesPersonnes = new ArrayList<Personne>();
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		
		lesPersonnes.add(chargerUnEnregistrement(json ));
		// return json
		// Log.e("JSON", json.toString());
		return lesPersonnes;
	}

	
	private Personne chargerUnEnregistrement(JSONObject json){
		Personne unPersonne = new Personne(0, null, null, null);
		try {

			unPersonne.setIdpersonne(json.getInt("idPersonne"));
			unPersonne.setNom(json.getString("nom"));
			unPersonne.setPrenom(json.getString("prenom"));
			unPersonne.setLoginUtilisateur(json.getString("loginUtilisateur"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unPersonne;
	}
	
}
