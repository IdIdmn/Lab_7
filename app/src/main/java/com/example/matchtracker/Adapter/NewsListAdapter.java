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

import com.example.matchtracker.Entity.News;
import com.example.matchtracker.R;

import java.util.ArrayList;

public class NewsListAdapter extends ArrayAdapter<News> {

    private Context context;

    private ArrayList<News> news;

    public NewsListAdapter(Context context, ArrayList<News> news){
        super(context, R.layout.item_news, news);
        this.context = context;
        this.news = news;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_news, parent, false);

        if(news.get(position).isContainsImage()) {
            ((ImageView) view.findViewById(R.id.newsImage)).setVisibility(View.VISIBLE);
            if(news.get(position).isExternallyLoaded()) {
                ((ImageView) view.findViewById(R.id.newsImage)).setImageURI(news.get(position).getImageURI());
            }
            else{
                ((ImageView) view.findViewById(R.id.newsImage)).setImageResource(news.get(position).getImageResId());
            }
        }
        ((TextView)view.findViewById(R.id.newsTitle)).setText(news.get(position).getNewsTitle());
        ((TextView)view.findViewById(R.id.newsText)).setText(news.get(position).getNewsText());
        ((TextView)view.findViewById(R.id.newsDate)).setText(news.get(position).getNewsDate());

        return view;
    }
}
