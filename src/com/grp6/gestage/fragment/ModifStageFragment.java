package com.grp6.gestage.fragment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.grp6.gestage.MainActivity;
import com.grp6.gestage.R;
import com.grp6.gestage.fonction.ClasseF;
import com.grp6.gestage.fonction.OrganisationF;
import com.grp6.gestage.fonction.StageF;
import com.grp6.gestage.metier.Classe;
import com.grp6.gestage.metier.Organisation;
import com.grp6.gestage.metier.Stage;


public class ModifStageFragment extends Fragment {
	private ProgressDialog pDialog;
	private boolean error;
	private int numStage;
	private Stage unStage;
	private ArrayList<Organisation> lesOrganisations = new ArrayList<Organisation>();
	private Spinner spOrganisation;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private EditText etDateFin;
	private EditText etDateDebut;
	private EditText etDateVisite;
	private EditText etDate;
	private Calendar myCalendar = Calendar.getInstance();
	   
	public ModifStageFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_modifstage, container,
				false);
		 Bundle bundle=getArguments(); 
		 numStage = bundle.getInt("numStage"); 
		 spOrganisation = (Spinner) rootView.findViewById(R.id.spOrganisation);
		 
		 etDateFin= (EditText) rootView.findViewById(R.id.etDateFin);
			etDateDebut= (EditText) rootView.findViewById(R.id.etDateDebut);
		 etDateVisite= (EditText) rootView.findViewById(R.id.etDateVisite);
		 
	        new getStage().execute();
	     

	        final DatePickerDialog.OnDateSetListener datepicker = new DatePickerDialog.OnDateSetListener() {

				@Override
				  public void onDateSet(DatePicker view, int year, int monthOfYear,
		                    int dayOfMonth) {
		                // TODO Auto-generated method stub
		                myCalendar.set(Calendar.YEAR, year);
		                myCalendar.set(Calendar.MONTH, monthOfYear);
		                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		                miseAJourDate();
		            }

	        };
	     
	        OnClickListener onDateClickListener = new OnClickListener() {

	         

				@Override
				   public void onClick(View v) {
	                // TODO Auto-generated method stub
		
					 etDate = (EditText) v;
					try {
						myCalendar.setTime(sdf.parse(etDate.getText().toString()));
					//	Date uneDate 
					//	Calendar.getInstance(sdf.parse(edDate.getText().toString()));
					//	myCalendar= new Calensdf.parse(edDate.getText().toString());
						new DatePickerDialog(getActivity(), datepicker, myCalendar
		                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
		                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	            }
	        };
	        etDateDebut.setOnClickListener(onDateClickListener);
	        etDateFin.setOnClickListener(onDateClickListener);
	        etDateVisite.setOnClickListener(onDateClickListener);
		return rootView;
	}
	private void miseAJourDate(){
		etDate.setText(sdf.format(myCalendar.getTime()));
	}
 
	private void chargerStage(){
		for (int i = 0; i < lesOrganisations.size(); i++) {
		if(lesOrganisations.get(i).getIdOrganisation()==unStage.getOrganisation().getIdOrganisation()){
			spOrganisation.setSelection(i);
		}
		}
		etDateFin.setText(sdf.format(unStage.getDateFin()));
		etDateDebut.setText(sdf.format(unStage.getDateDebut()));
		etDateVisite.setText(sdf.format(unStage.getDateVisiteStage()));
	}
	
	private void chargeListeOrganisation(){
		List<String> lablesOrganisations = new ArrayList<String>();

		for (int i = 0; i < lesOrganisations.size(); i++) {
			lablesOrganisations.add(lesOrganisations.get(i).getNomOrganisation());
		}

		// Creating adapter for spinner
		ArrayAdapter<String> spinnerAdapterAnnee = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item,
				lablesOrganisations);

		spinnerAdapterAnnee
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner

		spOrganisation.setAdapter(spinnerAdapterAnnee);
	}


private class getStage extends AsyncTask<Void, Void, Void> {

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

	StageF stageF = new StageF();
	OrganisationF organisationF = new OrganisationF();
		try {
			unStage = (Stage) stageF.getOne(numStage);
			lesOrganisations = (ArrayList<Organisation>)  organisationF.getAll();
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
											null, 0, 0);
								}
							}).show();

		} else {
			 chargeListeOrganisation();
			chargerStage();
	
	
			}
		

	}

}
}