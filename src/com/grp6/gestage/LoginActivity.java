
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

public class LoginActivity extends Activity {
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
	private static String KEY_ID = "PER_ID";
	private static String KEY_NOM = "PER_NOM";
	private static String KEY_PRENOM = "PER_PRENOM";
	private static String KEY_EMAIL = "EMP_EMAIL";
	private static String KEY_CREATED_AT = "created_at";

	
	JSONObject json;
	PersonneF personneF;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vue_connexion);

		// Importing all assets like buttons, text fields
		inputLogin = (EditText) findViewById(R.id.etLogin);
		inputPassword = (EditText) findViewById(R.id.etPassword);
		btnLogin = (Button) findViewById(R.id.btnConnection);
	//	btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
		loginErrorMsg = (TextView) findViewById(R.id.twError);

		// Login button Click Event
		btnLogin.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				new Login().execute();
			}
		});

	}
	/**
	 * tache asynchrone pour se connecter
	 * */
	private class Login extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(LoginActivity.this);
			pDialog.setMessage("Chargement...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			String email = inputLogin.getText().toString();
			String password = inputPassword.getText().toString();
			personneF = new PersonneF(getApplicationContext());
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

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
			// check for login response
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
									JSONObject json_user = json.getJSONObject("employe");
									
									// Clear all previous data in database
									personneF.logoutUser(getApplicationContext());
									// User utilisateur = new User(null, null, null, null, null, null);
									
									
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
