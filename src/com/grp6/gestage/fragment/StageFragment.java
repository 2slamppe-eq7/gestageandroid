package com.grp6.gestage.fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.grp6.gestage.MainActivity;
import com.grp6.gestage.R;
import com.grp6.gestage.fonction.AnneeScolF;
import com.grp6.gestage.fonction.ClasseF;
import com.grp6.gestage.fonction.FiliereF;
import com.grp6.gestage.metier.AnneeScol;
import com.grp6.gestage.metier.Classe;
import com.grp6.gestage.metier.Filiere;


public class StageFragment extends Fragment {
	private ProgressDialog pDialog;
	private boolean error;
	private ArrayList<AnneeScol> lesAnnees = new ArrayList<AnneeScol>();
	private ArrayList<Filiere> lesFilieres = new ArrayList<Filiere>();
	private ArrayList<Classe> lesClasses = new ArrayList<Classe>();
	private Spinner spAnnee;
	private Spinner spFiliere;
	private Spinner spClasse;
	private String anneeSelect=null;
	private int filiereSelect=0;
	public StageFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_stage, container,
				false);
		 spAnnee = (Spinner) rootView
				.findViewById(R.id.spAnnee);
		 spFiliere = (Spinner) rootView
					.findViewById(R.id.spFiliere);
		 spClasse = (Spinner) rootView
					.findViewById(R.id.spClasse);
		 spAnnee.setOnItemSelectedListener(new OnItemSelectedListener() {
			
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					anneeSelect = lesAnnees.get(arg2).getAnneeScol();
				if(filiereSelect!=0){
					new getClasses().execute();
				}
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					anneeSelect = null;
				}

			});
		 spFiliere.setOnItemSelectedListener(new OnItemSelectedListener() {
				
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					filiereSelect = lesFilieres.get(arg2).getNumFiliere();
					if(anneeSelect!=null){
						new getClasses().execute();
					}
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					filiereSelect = 0;
				}

			});

		new getAnnees().execute();
		return rootView;
	}
	private void chargerListAnnees(){

		List<String> lablesAnnees = new ArrayList<String>();

		for (int i = 0; i < lesAnnees.size(); i++) {
			lablesAnnees.add(lesAnnees.get(i).getAnneeScol());
		}

		// Creating adapter for spinner
		ArrayAdapter<String> spinnerAdapterAnnee = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item,
				lablesAnnees);

		spinnerAdapterAnnee
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner

		spAnnee.setAdapter(spinnerAdapterAnnee);

	}
	private void chargerListFilieres(){

		List<String> lablesFilieres = new ArrayList<String>();

		for (int i = 0; i < lesFilieres.size(); i++) {
			lablesFilieres.add(lesFilieres.get(i).getLibelleFiliere());
		}

		// Creating adapter for spinner
		ArrayAdapter<String> spinnerAdapterFiliere = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item,
				lablesFilieres);

		spinnerAdapterFiliere
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner

		spFiliere.setAdapter(spinnerAdapterFiliere);

	}
	private void chargerListClasses(){

		List<String> lablesClasses = new ArrayList<String>();

		for (int i = 0; i < lesClasses.size(); i++) {
			lablesClasses.add(lesClasses.get(i).getNomClasse());
		}

		// Creating adapter for spinner
		ArrayAdapter<String> spinnerAdapterClasse = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item,
				lablesClasses);

		spinnerAdapterClasse
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner

		spClasse.setAdapter(spinnerAdapterClasse);

	}
	private class getAnnees extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Chargement...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// lesChantiers = new ArrayList<Chantier>();

			AnneeScolF anneeF = new AnneeScolF();
			FiliereF filiereF = new FiliereF();
			try {
				lesAnnees = (ArrayList<AnneeScol>) anneeF
						.getAll();
				lesFilieres = (ArrayList<Filiere>) filiereF.getAll();
				error = false;

			} catch (ConnectTimeoutException e) {
				// TODO Auto-generated catch block
				Log.e("CONNEXION", "pas de connexion au serveur");
				error = true;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			}
			return null;

		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
			if (error == true) {
				new AlertDialog.Builder(getActivity())
						.setTitle("ERREUR")
						.setMessage("Pas de connexion au serveur")
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.dismiss();
										((MainActivity) getActivity()).goTo(
												null, 0, 0, 0);
									}
								}).show();

			} else {
				chargerListAnnees();
				chargerListFilieres();
		
				}
			

		}

	}
	private class getClasses extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Chargement...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// lesChantiers = new ArrayList<Chantier>();

		ClasseF classeF = new ClasseF();
			try {
				lesClasses = (ArrayList<Classe>) classeF.getSelected(anneeSelect, filiereSelect);
			
				error = false;

			} catch (ConnectTimeoutException e) {
				// TODO Auto-generated catch block
				Log.e("CONNEXION", "pas de connexion au serveur");
				error = true;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = true;
			}
			return null;

		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
			if (error == true) {
				new AlertDialog.Builder(getActivity())
						.setTitle("ERREUR")
						.setMessage("Pas de connexion au serveur")
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.dismiss();
										((MainActivity) getActivity()).goTo(
												null, 0, 0, 0);
									}
								}).show();

			} else {
				chargerListClasses();
		
		
				}
			

		}

	}

}
