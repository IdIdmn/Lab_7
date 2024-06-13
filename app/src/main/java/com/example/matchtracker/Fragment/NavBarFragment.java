package com.example.matchtracker.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.R;

public class NavBarFragment extends Fragment {

    Button menuButton;
    Context context;
    MatchesFragment matchList;
    ProfileFragment profile;
    PlayersFragment playersList;
    NewsFragment newsList;
    CalculatorFragment calculator;
    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_bar, container, false);
        String title = getArguments().getString("newTitle");
        ((TextView) view.findViewById(R.id.pageTitle)).setText(title);

        context = getContext();

        menuButton = (Button) view.findViewById(R.id.navMenuButton);
        menuButton.setOnClickListener(v -> {
            PopupMenu navMenu = new PopupMenu(context, v);
            navMenu.getMenuInflater().inflate(R.menu.nav_bar_button_menu, navMenu.getMenu());

            navMenu.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.menuProfileButton){
                    ((MainActivity) getActivity()).updatePageTitle("Your profile");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("chosenPlayer", ((MainActivity) getActivity()).getOwner());
                    profile = new ProfileFragment();
                    profile.setArguments(bundle);
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainActivityContent, profile);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if (itemId == R.id.menuNewsButton){
                    newsList = new NewsFragment();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainActivityContent, newsList);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if (itemId == R.id.menuMatchesButton){
                    matchList = new MatchesFragment();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainActivityContent, matchList);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if (itemId == R.id.menuPlayersButton){
                    playersList = new PlayersFragment();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainActivityContent, playersList);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if (itemId == R.id.menuCalculatorButton){
                    calculator = new CalculatorFragment();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainActivityContent, calculator);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            });
            navMenu.show();
        });

        return view;
    }


}
