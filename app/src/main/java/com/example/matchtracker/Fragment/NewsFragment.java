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
import com.example.matchtracker.Adapter.NewsListAdapter;
import com.example.matchtracker.R;

public class NewsFragment extends Fragment {

    private Context context;
    private ListView listView;
    private Button addButton;
    private NewsListAdapter newsListAdapter;
    private CreateNewsFragment createNewsWindow;
    private FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ((MainActivity) getActivity()).updatePageTitle("News");

        context = getContext();

        listView = view.findViewById(R.id.newsList);
        newsListAdapter = new NewsListAdapter(context, ((MainActivity) getActivity()).getNews());
        listView.setAdapter(newsListAdapter);

        addButton = (Button) view.findViewById(R.id.addNewsBtn);
        addButton.setOnClickListener(v -> {
            createNewsWindow = new CreateNewsFragment();
            fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainActivityContent, createNewsWindow);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }
}
