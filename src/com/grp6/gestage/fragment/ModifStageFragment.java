package com.grp6.gestage.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grp6.gestage.R;


public class ModifStageFragment extends Fragment {
	private ProgressDialog pDialog;
	private boolean error;
	private int numStage;
	
	public ModifStageFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_modifstage, container,
				false);
		 Bundle bundle=getArguments(); 
		 numStage = bundle.getInt("numStage"); 
	        
	        
		return rootView;
	}
}
