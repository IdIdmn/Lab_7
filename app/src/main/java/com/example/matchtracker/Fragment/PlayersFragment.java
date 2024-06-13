package com.example.matchtracker.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Adapter.PlayersListAdapter;
import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.Entity.Player;
import com.example.matchtracker.R;

import java.util.ArrayList;
import java.util.Collections;

public class PlayersFragment extends Fragment {

    private Context context;
    private ListView listView;
    private PlayersListAdapter playersListAdapter;
    private RadioButton sortByName, sortByWinRate, sortByPlayedGames;
    private ProfileFragment profile;
    private FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players_list, container, false);

        ((MainActivity) getActivity()).updatePageTitle("Players");

        context = getContext();

        if (getArguments() != null){
            ((MainActivity) getActivity()).addNewMatch((Match)getArguments().getSerializable("newMatch"));
        }

        ArrayList<Player> players = new ArrayList<>();
        players.addAll(((MainActivity) getActivity()).getPlayers());

        listView = view.findViewById(R.id.playersList);
        playersListAdapter = new PlayersListAdapter(context, players);
        listView.setAdapter(playersListAdapter);
        listView.setOnItemClickListener((parent, v, position, l) -> {
            ((MainActivity) getActivity()).updatePageTitle("Profile");
            Bundle bundle = new Bundle();
            bundle.putSerializable("chosenPlayer", players.get(position));
            profile = new ProfileFragment();
            profile.setArguments(bundle);
            fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainActivityContent, profile);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        sortByName = (RadioButton) view.findViewById(R.id.sortByName);
        sortByName.setOnClickListener(v -> {
            Collections.sort(players, (o1, o2) -> {
                String firstName = o1.getPlayerName();
                String secondName = o2.getPlayerName();
                return firstName.compareTo(secondName);
            });
            playersListAdapter.notifyDataSetChanged();
        });
        sortByWinRate = (RadioButton) view.findViewById(R.id.sortByWinRate);
        sortByWinRate.setOnClickListener(v -> {
            Collections.sort(players, (o1, o2) -> {
                double firstPlayerWinRate = o1.getWinRate();
                double secondPlayerWinRate = o2.getWinRate();
                if(firstPlayerWinRate > secondPlayerWinRate)
                    return -1;
                else if (secondPlayerWinRate > firstPlayerWinRate)
                    return 1;
                else
                    return 0;
            });
            playersListAdapter.notifyDataSetChanged();
        });
        sortByPlayedGames = (RadioButton) view.findViewById(R.id.sortByPlayedGames);
        sortByPlayedGames.setOnClickListener(v -> {
            Collections.sort(players, (o1, o2) -> {
                double firstPlayerAmount = o1.getPlayedGames();
                double secondPlayerAmount = o2.getPlayedGames();
                if(firstPlayerAmount > secondPlayerAmount)
                    return -1;
                else if (secondPlayerAmount > firstPlayerAmount)
                    return 1;
                else
                    return 0;
            });
            playersListAdapter.notifyDataSetChanged();
        });

        return view;
    }

}
