package com.example.matchtracker.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Adapter.AllUnitsListAdapter;
import com.example.matchtracker.Adapter.MatchListAdapter;
import com.example.matchtracker.Adapter.RecruitedUnitsListAdapter;
import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.Entity.Unit;
import com.example.matchtracker.R;

import java.util.ArrayList;

public class CalculatorFragment extends Fragment {

    private Context context;
    private ListView alliesListView, enemiesListView, allUnitsListView;
    private RecruitedUnitsListAdapter alliesListAdapter, enemiesListAdapter;
    private AllUnitsListAdapter allUnitsListAdapter;
    private Button resultButton, addAlliesButton, addEnemiesButton, clearButton;
    private boolean isRecruitAllie;
    private ArrayList<Unit> allies = new ArrayList<>(), enemies = new ArrayList<>(), allUnits;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        ((MainActivity) getActivity()).updatePageTitle("Calculator");

        context = getContext();

        allUnits = ((MainActivity)getActivity()).getUnits();

        alliesListView = view.findViewById(R.id.alliesUnits);
        alliesListAdapter = new RecruitedUnitsListAdapter(context, allies);
        alliesListView.setAdapter(alliesListAdapter);

        enemiesListView = view.findViewById(R.id.enemiesUnits);
        enemiesListAdapter = new RecruitedUnitsListAdapter(context, enemies);
        enemiesListView.setAdapter(enemiesListAdapter);

        allUnitsListView = view.findViewById(R.id.allUnitsList);
        allUnitsListAdapter = new AllUnitsListAdapter(context,allUnits);
        allUnitsListView.setAdapter(allUnitsListAdapter);
        allUnitsListView.setOnItemClickListener((parent, v, position, l) -> {
            Unit recruitedUnit = new Unit(allUnits.get(position));
            if(isRecruitAllie){
                allies.add(recruitedUnit);
                alliesListAdapter.notifyDataSetChanged();
            }
            else{
                enemies.add(recruitedUnit);
                enemiesListAdapter.notifyDataSetChanged();
            }
            allUnitsListView.setVisibility(View.GONE);
        });
        addAlliesButton = (Button) view.findViewById(R.id.addAllieButton);
        addAlliesButton.setOnClickListener(v -> {
            allUnitsListView.setVisibility(View.VISIBLE);
            isRecruitAllie = true;
        });
        addEnemiesButton = (Button) view.findViewById(R.id.addEnemyButton);
        addEnemiesButton.setOnClickListener(v -> {
            allUnitsListView.setVisibility(View.VISIBLE);
            isRecruitAllie = false;
        });
        clearButton = (Button) view.findViewById(R.id.clearRecruitListButton);
        clearButton.setOnClickListener(v -> {
            allies.clear();
            enemies.clear();
            alliesListAdapter.notifyDataSetChanged();
            enemiesListAdapter.notifyDataSetChanged();
            ((TextView) view.findViewById(R.id.result)).setText("Press to reveal who wins.");
            allUnitsListView.setVisibility(View.GONE);
        });
        clearButton.setOnLongClickListener(v -> {
            allUnitsListView.setVisibility(View.GONE);
            return false;
        });
        resultButton = (Button) view.findViewById(R.id.checkResultButton);
        resultButton.setOnClickListener(v -> {
            TextView result = (TextView) view.findViewById(R.id.result);
            if(!allies.isEmpty() && !enemies.isEmpty()) {
                int diff = getOverallHealth(allies) + getOverallDefence(allies) - getOverallDamage(enemies);
                if (diff <= 0) {
                    result.setText("You will definatly be defeated.");
                } else if (diff > 5) {
                    result.setText("You will destroy opponents army.");
                } else {
                    result.setText("Even our best sorceres can't find an answer.");
                }
            }
            else{
                result.setText("At first you gotta fill both teams");
            }
        });
        return view;
    }

    public int getOverallHealth(ArrayList<Unit> units){
        int totalHealth = 0;
        for (Unit unit : units){
            totalHealth += unit.getHealthPoints();
        }
        return totalHealth;
    }

    public int getOverallDefence(ArrayList<Unit> units) {
        int totalDefence = 0;
        for (Unit unit : units) {
            totalDefence += unit.getDefence();
        }
        return totalDefence;
    }

    public int getOverallDamage(ArrayList<Unit> units){
        int totalDamage = 0;
        for (Unit unit : units){
            totalDamage += unit.getDamage();
        }
        return totalDamage;
    }
}
