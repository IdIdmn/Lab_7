package com.example.matchtracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.matchtracker.Entity.Unit;
import com.example.matchtracker.R;

import java.util.ArrayList;

public class RecruitedUnitsListAdapter extends ArrayAdapter<Unit> {

    private Context context;

    private ArrayList<Unit> units;

    public RecruitedUnitsListAdapter(Context context, ArrayList<Unit> units){
        super(context, R.layout.item_recruited_unit, units);
        this.context = context;
        this.units = units;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_recruited_unit, parent, false);

        ((TextView)view.findViewById(R.id.recruitedUnitName)).setText(units.get(position).getUnitName());
        ((TextView)view.findViewById(R.id.recruitedUnitNumber)).setText((position + 1) + ")");

        return view;
    }

}
