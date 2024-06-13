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

public class AllUnitsListAdapter extends ArrayAdapter<Unit> {

    private Context context;

    private ArrayList<Unit> units;

    public AllUnitsListAdapter(Context context, ArrayList<Unit> units){
        super(context, R.layout.item_unit, units);
        this.context = context;
        this.units = units;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_unit, parent, false);

        ((TextView)view.findViewById(R.id.addListUnitName)).setText(units.get(position).getUnitName());
        ((TextView)view.findViewById(R.id.addListUnitDamage)).setText(String.valueOf(units.get(position).getDamage()));
        ((TextView)view.findViewById(R.id.addListUnitDefence)).setText(String.valueOf(units.get(position).getDefence()));
        ((TextView)view.findViewById(R.id.addListUnitHealth)).setText(String.valueOf(units.get(position).getHealthPoints()));

        return view;
    }

}
