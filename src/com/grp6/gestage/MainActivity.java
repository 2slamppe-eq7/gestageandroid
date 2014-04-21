package com.grp6.gestage;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.grp6.gestage.fonction.PersonneF;
import com.grp6.gestage.fragment.AccueilFragment;
import com.grp6.gestage.fragment.ModifStageFragment;
import com.grp6.gestage.fragment.StageFragment;
import com.grp6.gestage.library.NavDrawerItem;
import com.grp6.gestage.library.NavDrawerListAdapter;

/**
 * Class MainActivity - Se lance au démarrage de l'application
 * 
 * @author windows
 *
 */
public class MainActivity extends Activity{

	/**
	 * Variable
	 */
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	PersonneF personneF; 

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	/**
	 * Method onCreate - Methode chargé au démarrage
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		personneF = new PersonneF();
		if(personneF.isUserLoggedIn(getApplicationContext())){
			setContentView(R.layout.vue_principal);
			mTitle = mDrawerTitle = getTitle();

			// load slide menu items
			navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

			// nav drawer icons from resources
			navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

			mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

			navDrawerItems = new ArrayList<NavDrawerItem>();

			// adding nav drawer items to array
			// Home
			navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
			// Find People
			navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
			// Recycle the typed array
			navMenuIcons.recycle();

			mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

			// setting the nav drawer list adapter
			adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
			mDrawerList.setAdapter(adapter);

			// enabling action bar app icon and behaving it as toggle button
			getActionBar().setDisplayHomeAsUpEnabled(true);
	

			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
			) {
			
				public void onDrawerClosed(View view) {
					getActionBar().setTitle(mTitle);
					// calling onPrepareOptionsMenu() to show action bar icons
					invalidateOptionsMenu();
				}
			
				public void onDrawerOpened(View drawerView) {
					getActionBar().setTitle(mDrawerTitle);
					// calling onPrepareOptionsMenu() to hide action bar icons
					invalidateOptionsMenu();
				}
			};
			
			mDrawerLayout.setDrawerListener(mDrawerToggle);

			if (savedInstanceState == null) {
				// on first time display view for first nav item
				displayView(0, 0);
			}
			
		}else{
			// user is not logged in show login screen
			Intent login = new Intent(getApplicationContext(), LoginActivity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);
			// Closing dashboard screen
			finish();
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			if (position==3){
				personneF.logoutUser(getApplicationContext());
				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(login);
	        	// Closing dashboard screen
	        	finish();
				
			}else{
			displayView(position, 0);
			}
		}
	}
	
	/**
	 * Method onActivityResult
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	 // TODO Auto-generated method stub
		getFragmentManager().findFragmentById(R.id.frame_container).onActivityResult(requestCode, resultCode, data);

	 }

	/**
	 * Method onOptionsItemSelected
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
			return super.onOptionsItemSelected(item);
	}

	/**
	 * Method goTo - 
	 * 
	 * @param v
	 * @param vue
	 * @param idChantier
	 * @param idInt
	 */
	public void goTo(View v,int vue, int arg) {
		displayView(vue, arg);
	}
	
	/**
	 * Method displayView - Displaying fragment view for selected nav drawer list item
	 * 
	 * @param position
	 * @param arg 

	 */
	private void displayView(int position, int arg) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (position) {
		case 0:
			fragment = new AccueilFragment();
			break;
		case 1:
			fragment = new StageFragment();
			break;
		case 11:
			fragment = new ModifStageFragment();
		    args.putInt("numStage", arg);
		    fragment.setArguments(args);
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack( "tag" ).commit();
			if(position<2){
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
			}else{
			//	mDrawerList.setSelection(null);
			//	setTitle(mTitle);
			}
		
		} else {
			// error in creating fragment
			Log.e("MenuActivity", "Error in creating fragment");
		}
	}

	/**
	 * Method erreur - Renvoi message si erreur connexion serveur
	 */
	public  void erreur() {
    	new AlertDialog.Builder(this).setTitle("ERREUR")
	    .setMessage("Pas de connexion au serveur")	
	    .setPositiveButton("OK", new DialogInterface.OnClickListener() {

	    	public void onClick(DialogInterface dialog, int id) {
	    		dialog.dismiss();
	    	}

	    })
	    .show();
	}
	
	/**
	 * 
	 */
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}



	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}


}
