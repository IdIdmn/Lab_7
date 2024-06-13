package com.example.matchtracker.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Adapter.MatchListAdapter;
import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.R;

public class MatchesFragment extends Fragment {

    private Context context;
    private ListView listView;
    private MatchListAdapter matchListAdapter;
    private Button addButton;
    private CreateMatchFragment addNewMatchWindow;
    private MatchInfoFragment matchInfoWindow;
    private FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_list, container, false);

        ((MainActivity) getActivity()).updatePageTitle("Match List");

        context = getContext();

        if (getArguments() != null){
            ((MainActivity) getActivity()).addNewMatch((Match)getArguments().getSerializable("newMatch"));
        }

        listView = view.findViewById(R.id.matchList);
        matchListAdapter = new MatchListAdapter(context, ((MainActivity) getActivity()).getMatches());
        listView.setAdapter(matchListAdapter);
        listView.setOnItemClickListener((parent, v, position, l) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("chosenMatch", ((MainActivity) getActivity()).getMatches().get(position));
            bundle.putString("matchNumber", String.format("Match №%d", position + 1));

            matchInfoWindow = new MatchInfoFragment();
            matchInfoWindow.setArguments(bundle);
            fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainActivityContent, matchInfoWindow);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        });

        addButton = (Button) view.findViewById(R.id.addMatchInfoBtn);
        addButton.setOnClickListener(v -> {

            addNewMatchWindow = new CreateMatchFragment();
            fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainActivityContent, addNewMatchWindow);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }

}
