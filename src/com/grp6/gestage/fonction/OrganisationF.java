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
import com.grp6.gestage.metier.Etudiant;
import com.grp6.gestage.metier.Filiere;
import com.grp6.gestage.metier.MaitreStage;
import com.grp6.gestage.metier.Organisation;
import com.grp6.gestage.metier.Personne;

public class OrganisationF  extends Config {

	private JSONParser jsonParser;
	
	

	// constructor
	public OrganisationF( ){
		jsonParser = new JSONParser( );
	}
	
	
	public List<Organisation> getAll() throws JSONException, IllegalStateException, IOException{
		ArrayList<Organisation> lesOrganisations = new ArrayList<Organisation>();
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", "organisation"));
		params.add(new BasicNameValuePair("fonc", "getAll"));
		JSONObject json = jsonParser.getJSONFromUrl(URL, params);
		JSONArray json_organisations = json.getJSONArray("organisations");
		
		for (int i = 0; i < json_organisations.length(); i++) {
			lesOrganisations.add(chargerUnEnregistrement((JSONObject) json_organisations.get(i)));
			}
	
		return lesOrganisations;
	}
	public static Organisation chargerUnEnregistrement(JSONObject json){
		Organisation uneOrganisation = new Organisation(0,null, null, null,null,null,null, null, null);
		try {

			uneOrganisation.setActivite(json.getString("activite"));
			uneOrganisation.setCpOrganisation(json.getString("cp"));
			uneOrganisation.setFaxOrganisation(json.getString("fax"));
			uneOrganisation.setFormeJuridique(json.getString("formeJuridique"));
			uneOrganisation.setIdOrganisation(json.getInt("id"));
			uneOrganisation.setNomOrganisation(json.getString("nom"));
			uneOrganisation.setTelOrganisation(json.getString("tel"));
			uneOrganisation.setAdresse(json.getString("adresse"));
			uneOrganisation.setVilleOrganisation(json.getString("ville"));
		//	uneClasse.setSpecialite(idSpecialite)
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uneOrganisation;
	}
	
}