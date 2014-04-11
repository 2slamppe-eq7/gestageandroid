
package com.grp6.gestage.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class JSONParser {

	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";

	// constructor
	public JSONParser() {

	}


	public JSONObject getJSONFromUrl( String url, List<NameValuePair> params) throws IllegalStateException, IOException{

		// Making HTTP request
	
		//	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		//	StrictMode.setThreadPolicy(policy);
	

	
		
		try {
			HttpParams httpParameters = new BasicHttpParams();
			// Set the timeout in milliseconds until a connection is established.
			// The default value is zero, that means the timeout is not used. 
			int timeoutConnection = 5000;
			HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
			// Set the default socket timeout (SO_TIMEOUT) 
			// in milliseconds which is the timeout for waiting for data.
			int timeoutSocket = 15000;
			//HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

			
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
		
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(params));
		
	
			HttpResponse httpResponse = null;

				
			try {
				httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				Log.e("ERREUR", "SERVEUR INTROUVABLE");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.e("ERREUR", "SERVEUR INTROUVABLE");

			}
			
		
		} catch (UnsupportedEncodingException e) {
			Log.e("UnsupportedEncodingException", "UnsupportedEncodingException");
		}
		
		if(is!=null){
		
			
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"), 8);
			//"iso-8859-1"
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			Log.i("JSON", json);
		} catch (Exception e) {
			
		}

		// try parse the string to a JSON object
		try {
			jObj = new JSONObject(json);			
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}
		}
		// return JSON String
		return jObj;

	}
}
