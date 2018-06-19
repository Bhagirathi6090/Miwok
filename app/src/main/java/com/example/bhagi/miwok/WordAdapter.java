package com.example.bhagi.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private  int colorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words,int colorResourceId){
        super(context, 0 ,words);
        this.colorResourceId = colorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word word = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView defaultView = convertView.findViewById(R.id.default_translation);
        TextView miwokView = convertView.findViewById(R.id.miwok_translation);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        if(word.hasImage()){
            imageView.setImageResource(word.getImageResourceid());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        defaultView.setText(word.getDefaultTranslation());
        miwokView.setText(word.getmMiwokTranslation());

        View textContainer = convertView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);

        return convertView;
    }
}