package com.example.matchtracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.matchtracker.Entity.Player;
import com.example.matchtracker.R;

import java.util.ArrayList;

public class PlayersListAdapter extends ArrayAdapter<Player> {

    private Context context;

    private ArrayList<Player> players;

    public PlayersListAdapter(Context context, ArrayList<Player> players){
        super(context, R.layout.item_player, players);
        this.context = context;
        this.players = players;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_player, parent, false);

        ((ImageView)view.findViewById(R.id.playersListItemPlayerImage)).setImageResource(players.get(position).getImageResId());
        ((TextView)view.findViewById(R.id.playersListItemPlayerName)).setText(players.get(position).getPlayerName());
        ((TextView)view.findViewById(R.id.playersListItemWinRate)).setText(String.valueOf(players.get(position).getWinRate()).substring(0, 4) + " %");
        ((TextView)view.findViewById(R.id.playersListItemPlayedGames)).setText(String.valueOf(players.get(position).getPlayedGames()));

        return view;
    }

}
