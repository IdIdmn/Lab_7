package com.example.matchtracker.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Activity.MainActivity;
import com.example.matchtracker.Entity.News;
import com.example.matchtracker.R;

public class CreateNewsFragment extends Fragment {

    private Intent intent;
    private Uri newImageUri;
    private boolean isImageAdded = false;
    private ImageView addImage;
    private Button addImageButton, createButton, cancelButton;
    private NewsFragment newsList;
    private FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_news, container, false);

        ((MainActivity) getActivity()).updatePageTitle("Create News");

        addImage = (ImageView) view.findViewById(R.id.addNewsImage);
        cancelButton = (Button) view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            newsList = new NewsFragment();
            fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainActivityContent, newsList);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
        addImageButton = (Button) view.findViewById(R.id.addNewsImageButton);
        addImageButton.setOnClickListener(v -> {
            intent = new Intent(Intent.ACTION_PICK);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 1000);
        });
        createButton = (Button) view.findViewById(R.id.createNewsButton);
        createButton.setOnClickListener(v -> {
            News anotherNews = new News();
            anotherNews.setNewsTitle(String.valueOf(((EditText)view.findViewById(R.id.addNewsTitle)).getText()));
            anotherNews.setNewsText(String.valueOf(((EditText)view.findViewById(R.id.addNewsText)).getText()));
            anotherNews.setNewsDate(String.valueOf(((EditText)view.findViewById(R.id.addNewsDate)).getText()));
            anotherNews.setImageURI(newImageUri);
            anotherNews.setContainsImage(isImageAdded);
            anotherNews.setExternallyLoaded(true);

            ((MainActivity)getActivity()).addNews(anotherNews);

            newsList = new NewsFragment();
            fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainActivityContent, newsList);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == -1){
            if(requestCode == 1000){
                newImageUri = data.getData();
                isImageAdded = true;
                addImage.setImageURI(data.getData());
                addImage.setVisibility(View.VISIBLE);
            }
        }

    }

}
