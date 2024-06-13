package com.example.matchtracker.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.R;
import com.google.android.material.snackbar.Snackbar;

public class CreateMatchFragment extends Fragment {

    private Context context;
    private Button cancelButton, addButton;
    private MatchesFragment matchList;
    private FragmentTransaction fragmentTransaction;
    private EditText player1, player2, startDate, startTime, endDate, endTime, map, rounds;
    private RadioButton winPlayer1, winPlayer2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_match, container, false);

        ((MainActivity) getActivity()).updatePageTitle("Create Match");

        context = getContext();

        player1 = (EditText) view.findViewById(R.id.addFirstPlayerName);
        player2 = (EditText) view.findViewById(R.id.addSecondPlayerName);
        startDate = (EditText) view.findViewById(R.id.addStartDate);
        startTime = (EditText) view.findViewById(R.id.addStartTime);
        endDate = (EditText) view.findViewById(R.id.addEndDate);
        endTime = (EditText) view.findViewById(R.id.addEndTime);
        map = (EditText) view.findViewById(R.id.addMapName);
        rounds = (EditText) view.findViewById(R.id.addRounds);

        winPlayer1 = (RadioButton) view.findViewById(R.id.addFirstPlayerWin);
        winPlayer1.setChecked(true);
        winPlayer1.setOnClickListener(v -> {
            winPlayer1.setChecked(true);
            winPlayer1.setText("Win");
            winPlayer2.setChecked(false);
            winPlayer2.setText("Defeat");
        });
        winPlayer2 = (RadioButton) view.findViewById(R.id.addSecondPlayerWin);
        winPlayer2.setOnClickListener(v -> {
            winPlayer2.setChecked(true);
            winPlayer2.setText("Win");
            winPlayer1.setChecked(false);
            winPlayer1.setText("Defeat");
        });

        cancelButton = (Button) view.findViewById(R.id.addWindowCancelButton);
        cancelButton.setOnClickListener(v -> {
            matchList = new MatchesFragment();
            fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();;
            fragmentTransaction.replace(R.id.mainActivityContent, matchList);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
        addButton = (Button) view.findViewById(R.id.addWindowAddButton);
        addButton.setOnClickListener(v -> {
            String checkResult = checkInput(String.valueOf(startDate.getText()), String.valueOf(startTime.getText()), String.valueOf(endDate.getText()),String.valueOf(endTime.getText()), String.valueOf(rounds.getText()));
            if(checkResult.isEmpty()) {
                Match newMatch = new Match();

                newMatch.setFirstPlayerName(String.valueOf(player1.getText()));
                newMatch.setSecondPlayerName(String.valueOf(player2.getText()));
                newMatch.setStartDatetime(startDate.getText() + "  " + startTime.getText());
                newMatch.setEndDateTime(endDate.getText() + "  " + endTime.getText());
                newMatch.setWinnerName((winPlayer1.isChecked()) ? newMatch.getFirstPlayerName() : newMatch.getSecondPlayerName());
                newMatch.setMapName(String.valueOf(map.getText()));
                newMatch.setAmountOfRounds(String.valueOf(rounds.getText()));

                Bundle bundle = new Bundle();
                bundle.putSerializable("newMatch", newMatch);
                matchList = new MatchesFragment();
                matchList.setArguments(bundle);

                fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainActivityContent, matchList);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            else{
                Snackbar.make(v, checkResult, Snackbar.LENGTH_LONG).show();
            }
        });
        addButton.setOnLongClickListener(v -> {
            Match newMatch = new Match();

            int startDay = (int)(1 + 31 * Math.random());
            int startMonth = (int)(1 + 12 * Math.random());
            int startYear = (int)(100 * Math.random());
            int endDay = (int)(1 + 31 * Math.random());
            int endMonth = (int)(1 + 12 * Math.random());
            int endYear = (int)(100 * Math.random());

            int startHours = (int)(24 * Math.random());
            int startMinutes = (int)(60 * Math.random());
            int endHours = (int)(24 * Math.random());
            int endMinutes = (int)(60 * Math.random());

            String startDate = ((startDay < 10) ?  "0" : "") + startDay + "." + ((startMonth < 10) ? "0" : "") + startMonth + "." + ((startYear < 10) ? "0" : "") + startYear;
            String endDate = ((endDay < 10) ?  "0" : "") + endDay + "." + ((endMonth < 10) ? "0" : "") + endMonth + "." + ((endYear < 10) ? "0" : "") + endYear;
            String startTime = ((startHours < 10) ? "0" : "") + startHours + ":" + ((startMinutes < 10) ? "0" : "") + startMinutes;
            String endTime = ((endHours < 10) ? "0" : "") + endHours + ":" + ((endMinutes < 10) ? "0" : "") + endMinutes;
            String rounds = String.valueOf((int)(1000* Math.random()));

            ((TextView)view.findViewById(R.id.addStartDate)).setText(startDate);
            ((TextView)view.findViewById(R.id.addEndDate)).setText(endDate);
            ((TextView)view.findViewById(R.id.addStartTime)).setText(startTime);
            ((TextView)view.findViewById(R.id.addEndTime)).setText(endTime);
            ((TextView)view.findViewById(R.id.addRounds)).setText(rounds);

            return false;
        });
        return view;
    }

    public boolean checkDate(String date){
        boolean checkFormat, checkValues;
        checkFormat = date.matches("\\d{2}[.]\\d{2}[.]\\d{2}");
        if(checkFormat) {
            checkValues = Integer.parseInt(date.substring(0, 2)) <= 31 && Integer.parseInt(date.substring(3, 5)) <= 12;
            return checkValues;
        }
        return false;
    }

    public boolean checkTime(String time){
        boolean checkFormat, checkValues;
        checkFormat = time.matches("\\d{2}[:]\\d{2}");
        if(checkFormat) {
            checkValues = Integer.parseInt(time.substring(0, 2)) <= 24 && Integer.parseInt(time.substring(3)) <= 59;
            return checkValues;
        }
        return false;
    }

    public String checkInput(String startDate, String startTime, String endDate, String endTime, String round){
        if (!checkDate(startDate) || !checkDate(endDate)){
            return "Одна или несколько дат введены некорректно.";
        }
        else if (!checkTime(startTime) || !checkTime(endTime)) {
            return "Неверно указано время начала или конца матча.";
        }
        else{
            return "";
        }
    }

}
