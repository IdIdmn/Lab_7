package com.example.matchtracker.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Entity.Player;
import com.example.matchtracker.R;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Player player = (Player)getArguments().getSerializable("chosenPlayer");

        ((ImageView)view.findViewById(R.id.userProfileImage)).setImageResource(player.getImageResId());
        ((TextView)view.findViewById(R.id.userProfileName)).setText(player.getPlayerName());
        ((TextView)view.findViewById(R.id.userProfileRating)).setText(player.getRating());
        ((TextView)view.findViewById(R.id.userProfileCreateDate)).setText(player.getDateOfCreate());
        ((TextView)view.findViewById(R.id.userProfileWins)).setText(player.getWinsNumber());
        ((TextView)view.findViewById(R.id.userProfileDefeats)).setText(player.getDefeatsNumber());
        ((TextView)view.findViewById(R.id.userProfileFavoriteMap)).setText(player.getFavoriteMap());
        ((TextView)view.findViewById(R.id.userProfileFavoriteUnit)).setText(player.getFavoriteUnit());

        return view;
    }
}
