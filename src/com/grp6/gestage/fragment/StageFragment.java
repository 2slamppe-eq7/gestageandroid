package com.grp6.gestage.fragment;

import java.util.HashMap;

import com.grp6.gestage.R;
import com.grp6.gestage.library.DatabaseHandler;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class StageFragment extends Fragment {


	public StageFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_accueil, container,
				false);



		
		return rootView;
	}

}
