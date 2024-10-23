package com.example.myhomework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    private Activity context;
    private Integer[] imageArray;
    private String[] nameArray;
    private String[] infoArray;

    public CustomAdapter(@NonNull Activity context, String[] names, String[] infos, Integer[] images) {
        super(context, R.layout.listview_row, names);
        this.context = context;
        this.nameArray = names;
        this.infoArray = infos;
        this.imageArray = images;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.listview_row, null, true);
        TextView name = view.findViewById(R.id.name);
        TextView info = view.findViewById(R.id.info);
        TextView priceTextView = view.findViewById(R.id.priceTextView);
        ImageView image = view.findViewById(R.id.imageView);

        name.setText(nameArray[position]);
        info.setText(infoArray[position]);
        image.setImageResource(imageArray[position]);

        priceTextView.setVisibility(View.GONE);
        return view;
    }
    public void showPrices(View view,String prices) {
        TextView priceTextView =view.findViewById(R.id.priceTextView);
        priceTextView.setText(prices);
        priceTextView.setVisibility(View.VISIBLE);
    }
}


