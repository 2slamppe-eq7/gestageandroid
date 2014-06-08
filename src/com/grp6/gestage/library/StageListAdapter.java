package com.grp6.gestage.library;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grp6.gestage.R;
import com.grp6.gestage.metier.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StageListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Stage> lesStages;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public StageListAdapter(Context context, ArrayList<Stage> lesStages) {
        this.context = context;
        this.lesStages = lesStages;
    }

    @Override
    public int getCount() {
        return lesStages.size();
    }

    @Override
    public Object getItem(int position) {
        return lesStages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.stage_list_item, null);
        }

        TextView txtNumStage = (TextView) convertView.findViewById(R.id.tvNumStage);
        TextView txtEtudiantNom = (TextView) convertView.findViewById(R.id.tvEtudiantNom);
        TextView txtEtudiantPrenom = (TextView) convertView.findViewById(R.id.tvEtudiantPrenom);
        TextView txtOrganisation = (TextView) convertView.findViewById(R.id.tvOrganisation);
        TextView txtMaitreStage = (TextView) convertView.findViewById(R.id.tvMaitreStage);
        TextView txtDateDeb = (TextView) convertView.findViewById(R.id.tvDateDebut);
        TextView txtDateFin = (TextView) convertView.findViewById(R.id.tvDateFin);
        TextView txtDateVisite = (TextView) convertView.findViewById(R.id.tvDateVisite);
        TextView txtVille = (TextView) convertView.findViewById(R.id.tvVille);

        txtNumStage.setText(lesStages.get(position).getNum_stage() + " ");
        txtEtudiantNom.setText(lesStages.get(position).getEtudiant().getNom() + " ");
        txtEtudiantPrenom.setText(lesStages.get(position).getEtudiant().getPrenom() + " ");
        txtOrganisation.setText(lesStages.get(position).getOrganisation().getNomOrganisation() + " ");
        txtMaitreStage.setText(lesStages.get(position).getMaitreStage().getNom() + "  " + lesStages.get(position).getMaitreStage().getPrenom() + " ");
        txtDateDeb.setText(sdf.format(lesStages.get(position).getDateDebut()));
        txtDateFin.setText(sdf.format(lesStages.get(position).getDateFin()));
        txtDateVisite.setText(sdf.format(lesStages.get(position).getDateVisiteStage()));
        txtVille.setText(lesStages.get(position).getVille());

        return convertView;
    }

}
