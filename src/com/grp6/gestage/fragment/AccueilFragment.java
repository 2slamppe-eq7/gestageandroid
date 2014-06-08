package com.grp6.gestage.fragment;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grp6.gestage.R;
import com.grp6.gestage.library.DatabaseHandler;

import java.util.HashMap;


public class AccueilFragment extends Fragment {

    private TextView bienvenue;
    private TextView menu;
    private ImageView imageView2;

    public AccueilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_accueil, container,
                false);
        bienvenue = (TextView) rootView.findViewById(R.id.twBienvenue);
        menu = (TextView) rootView.findViewById(R.id.twMenu);
        DatabaseHandler db = new DatabaseHandler(getActivity());
        HashMap<String, String> user = db.getUserDetails();
        bienvenue.setText("Bienvenue " + user.get("prenom") + " "
                + user.get("nom"));
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "chalkboard.ttf");
        bienvenue.setTypeface(font);
        menu.setTypeface(font);


        return rootView;
    }

}
