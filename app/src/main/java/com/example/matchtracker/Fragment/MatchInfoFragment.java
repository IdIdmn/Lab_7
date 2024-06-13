package com.example.matchtracker.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.R;

public class MatchInfoFragment extends Fragment {

    Button backButton;
    Match chosenmatch;
    MatchesFragment matchList;
    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_match_info, container, false);

        ((MainActivity) getActivity()).updatePageTitle("Match Info");

        if (getArguments() != null) {
            Match chosenmatch = (Match)getArguments().getSerializable("chosenMatch");
            ((TextView)view.findViewById(R.id.chosenMatch)).setText(getArguments().getString("matchNumber"));
            ((TextView)view.findViewById(R.id.infoFirstPlayerNameValue)).setText(chosenmatch.getFirstPlayerName());
            ((TextView)view.findViewById(R.id.infoSecondPlayerNameValue)).setText(chosenmatch.getSecondPlayerName());
            ((TextView)view.findViewById(R.id.infoStartDatetimeValue)).setText(chosenmatch.getStartDatetime());
            ((TextView)view.findViewById(R.id.infoEndDatetimeValue)).setText(chosenmatch.getEndDateTime());
            ((TextView)view.findViewById(R.id.infoWinnerNameValue)).setText(chosenmatch.getWinnerName());
            ((TextView)view.findViewById(R.id.infoMapNameValue)).setText(chosenmatch.getMapName());
            ((TextView)view.findViewById(R.id.infoAmountOfRoundsValue)).setText(chosenmatch.getAmountOfRounds());
        }

        backButton = (Button) view.findViewById(R.id.MatchInfoBackButton);
        backButton.setOnClickListener(v -> {
            matchList = new MatchesFragment();
            fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();;
            fragmentTransaction.replace(R.id.mainActivityContent, matchList);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }

}
