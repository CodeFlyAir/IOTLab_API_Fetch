package com.example.iotlab_recapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    MainActivity mainActivity;
    List<Model> data;

    public ViewAdapter(MainActivity mainActivity, List<Model> data) {
        this.mainActivity = mainActivity;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.data_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardTitle.setText(data.get(position).getTitle());
        holder.cardDesc.setText(data.get(position).getDescription());
        holder.cardPrice.setText(String.format("$%s", data.get(position).getPrice()));
        holder.cardRating.setText(String.format("Rating : %s/5.0  (%s)", Objects.requireNonNull(data.get(position).
                        getRating().get("rate")),
                data.get(position).getRating().
                        get("count").toString()));

        Picasso.get()
                .load(data.get(position).getImage())
                .fit()
                .placeholder(R.drawable.placeholder)
                .into(holder.cardImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardTitle;
        TextView cardDesc;
        TextView cardPrice;
        TextView cardRating;
        ImageView cardImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTitle = itemView.findViewById(R.id.cardTitle);
            cardDesc = itemView.findViewById(R.id.cardDesc);
            cardRating = itemView.findViewById(R.id.cardRating);
            cardPrice = itemView.findViewById(R.id.cardPrice);
            cardImage = itemView.findViewById(R.id.cardImage);
        }
    }
}
