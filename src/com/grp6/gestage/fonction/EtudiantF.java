package com.grp6.gestage.fonction;

import com.grp6.gestage.library.JSONParser;
import com.grp6.gestage.metier.Classe;
import com.grp6.gestage.metier.Etudiant;

import org.json.JSONException;
import org.json.JSONObject;

public class EtudiantF extends Config {

    private JSONParser jsonParser;


    // constructor
    public EtudiantF() {
        jsonParser = new JSONParser();
    }


    public static Etudiant chargerUnEnregistrement(JSONObject json) {
        Etudiant unEtudiant = new Etudiant(0, null, null, null, null, null, null, null, null, null);
        try {

            unEtudiant.setIdpersonne(json.getInt("id"));
            unEtudiant.setCivilite(json.getString("civilite"));
            unEtudiant.setLoginUtilisateur(json.getString("login"));
            unEtudiant.setMdp(json.getString("mdp"));
            unEtudiant.setNom(json.getString("nom"));
            unEtudiant.setNumTel(json.getString("tel"));
            unEtudiant.setNumMobile(json.getString("telMobile"));
            unEtudiant.setPrenom(json.getString("prenom"));
            JSONObject json_classe = json.getJSONObject("classe");
            Classe uneClasse = ClasseF.chargerUnEnregistrement(json_classe);
            unEtudiant.setClasse(uneClasse);

            //	uneClasse.setSpecialite(idSpecialite)

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return unEtudiant;
    }

}
