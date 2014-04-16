package com.grp6.gestage.library;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grp6.gestage.R;
import com.grp6.gestage.metier.Stage;

public class StageListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Stage> lesStages;

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
		TextView txtEtudiant = (TextView) convertView.findViewById(R.id.tvEtudiant);


		txtNumStage.setText(lesStages.get(position).getNum_stage()+"");
	//	txtEtudiant.setText(lesStages.get(position).get)
	
	
		return convertView;
	}

}
