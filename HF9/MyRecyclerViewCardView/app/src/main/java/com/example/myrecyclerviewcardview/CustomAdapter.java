package com.example.myrecyclerviewcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private String[] nameArray;
    private String[] infoArray;
    private Integer[] imageArray;


    public CustomAdapter(Context context, String[] nameArray, String[] infoArray, Integer[] imageArray) {
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.imageArray = imageArray;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,info;
        ImageView image;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View  view = inflater.inflate(R.layout.listview_row,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(nameArray[position]);
        holder.info.setText(infoArray[position]);
        holder.image.setImageResource(imageArray[position]);
    }


    @Override
    public int getItemCount() {
        return nameArray.length;
    }
}
