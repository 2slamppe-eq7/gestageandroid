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
import com.grp6.gestage.metier.Personne;

public class MaitreStageF  extends Config {

	private JSONParser jsonParser;
	
	

	// constructor
	public MaitreStageF( ){
		jsonParser = new JSONParser( );
	}
	
	
	
	public static MaitreStage chargerUnEnregistrement(JSONObject json){
		MaitreStage unMaitreStage = new MaitreStage(0, null, null, null, null, null, null, null, null);
		try {

			unMaitreStage.setIdpersonne(json.getInt("idPersonne"));
			unMaitreStage.setCivilite(json.getString("civilite"));
			unMaitreStage.setLoginUtilisateur(json.getString("login"));
			unMaitreStage.setMdp(json.getString("mdp"));
			unMaitreStage.setNom(json.getString("nom"));
			unMaitreStage.setNumTel(json.getString("numTel"));
			unMaitreStage.setPrenom(json.getString("prenom"));
			
		//	uneClasse.setSpecialite(idSpecialite)
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unMaitreStage;
	}
	
}