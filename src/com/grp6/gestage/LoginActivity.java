
package com.grp6.gestage;

import java.io.IOException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.grp6.gestage.fonction.PersonneF;
import com.grp6.gestage.library.DatabaseHandler;

/**
 * Class LoginActivity - Ouvre activité Login si user non loggé
 * 
 * @author windows
 *
 */
public class LoginActivity extends Activity {
	
	/**
	 * Variable
	 */
	private Button btnLogin;
	private Button btnLinkToRegister;
	private EditText inputLogin;
	private EditText inputPassword;
	private TextView loginErrorMsg;
	private ProgressDialog pDialog;
	private boolean error;
	
	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_ID = "idPersonne";
	private static String KEY_NOM = "nom";
	private static String KEY_PRENOM = "prenom";
	private static String KEY_EMAIL = "login";
	private static String KEY_CREATED_AT = "created_at";

	
	JSONObject json;
	PersonneF personneF;
	
	/**
	 * Method onCreate - Hérité de Activity
	 * Se lance à l'appel de la classe
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vue_connexion);

		inputLogin = (EditText) findViewById(R.id.etLogin);
		inputPassword = (EditText) findViewById(R.id.etPassword);
		btnLogin = (Button) findViewById(R.id.btnConnection);
		loginErrorMsg = (TextView) findViewById(R.id.twError);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				new Login().execute();
			}
		});

	}
	
	/**
	 * Class Login - Contient taches asynchrones pour se connecter
	 * 
	 * @author windows
	 *
	 */
	private class Login extends AsyncTask<Void, Void, Void> {
		
		/**
		 * Method onPreExecute - Charge l'icone de chargement
		 */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(LoginActivity.this);
			pDialog.setMessage("Chargement...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		/**
		 * Method doInBackground - Requete de test Login/Mdp
		 */
		@Override
		protected Void doInBackground(Void... arg0) {
			String email = inputLogin.getText().toString();
			String password = inputPassword.getText().toString();
			personneF = new PersonneF();
			Log.d("Button", "Login");
			try {
				json = personneF.connexionEmploye(email, password);
				error = false;
			
			} catch (ConnectTimeoutException e) {
				// TODO Auto-generated catch block
				error = true;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				error = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				error = true;
			}
			return null;	
		}

		/**
		 * Method onPostExecute - Etablit une authentification sur l'application
		 */
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
		
			if (error == true) {
				loginErrorMsg.setText("Pas de connexion au serveur");
				
			} else {
						try {
							if (json.getString(KEY_SUCCESS) != null) {
								loginErrorMsg.setText("");
								String res = json.getString(KEY_SUCCESS); 
								if(Integer.parseInt(res) == 1){
									// user successfully logged in
									// Store user details in SQLite Database
									DatabaseHandler db = new DatabaseHandler(getApplicationContext());
									JSONObject json_user = json.getJSONObject("personne");
									
									// Clear all previous data in database
									personneF.logoutUser(getApplicationContext());
									db.addUser(json_user.getInt(KEY_ID),json_user.getString(KEY_NOM), json_user.getString(KEY_PRENOM), json_user.getString(KEY_EMAIL));						
									
									// Launch Dashboard Screen
									Intent dashboard = new Intent(getApplicationContext(), MainActivity.class);
									dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
									startActivity(dashboard);
									finish();
								}else{
									// Error in login
									if (pDialog.isShowing())
										pDialog.dismiss();
									loginErrorMsg.setText("Incorrect username/password");
								}
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
			}
		}

	}
	
}
