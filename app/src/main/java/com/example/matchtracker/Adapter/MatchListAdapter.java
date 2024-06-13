package com.example.matchtracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.R;

import java.util.ArrayList;

public class MatchListAdapter extends ArrayAdapter<Match> {

    private Context context;

    private ArrayList<Match> matches;

    public MatchListAdapter(Context context, ArrayList<Match> matches){
        super(context, R.layout.item_match, matches);
        this.context = context;
        this.matches = matches;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_match, parent, false);

        ((TextView)view.findViewById(R.id.firstPlayer)).setText(matches.get(position).getFirstPlayerName());
        ((TextView)view.findViewById(R.id.secondPlayer)).setText(matches.get(position).getSecondPlayerName());
        ((TextView)view.findViewById(R.id.startDatetime)).setText(matches.get(position).getStartDatetime());
        ((TextView)view.findViewById(R.id.endDatetime)).setText(matches.get(position).getEndDateTime());
        ((TextView)view.findViewById(R.id.curMatchNumber)).setText(String.format("Match №%d", position + 1));

        if(matches.get(position).getWinnerName().equals(matches.get(position).getFirstPlayerName())){
            ((TextView)view.findViewById(R.id.firstPlayer)).setBackgroundColor(context.getColor(R.color.winner));
            ((TextView)view.findViewById(R.id.secondPlayer)).setBackgroundColor(context.getColor(R.color.loser));
        }
        else{
            ((TextView)view.findViewById(R.id.firstPlayer)).setBackgroundColor(context.getColor(R.color.loser));
            ((TextView)view.findViewById(R.id.secondPlayer)).setBackgroundColor(context.getColor(R.color.winner));
        }
        return view;
    }

}
