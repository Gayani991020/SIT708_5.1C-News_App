package com.example.sit708_task_5_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adapter for a RecyclerView that displays related news items with images and text.
 */
public class RelativeNewsAdapter extends RecyclerView.Adapter<RelativeNewsAdapter.MyViewHolder> {
    // Array of image resource IDs for the news items
    private int[] array;

    /**
     * Constructor for the RelativeNewsAdapter.
     *
     * @param array An array of image resource IDs for initializing the adapter.
     */
    public RelativeNewsAdapter(int[] array) {
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout from XML and initializing the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind the image resource to the ImageView in each item of the RecyclerView
        holder.relativeImageView.setImageResource(array[position]);
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the data set held by the adapter
        return array.length;
    }

    /**
     * ViewHolder class for the RecyclerView, which contains views that display individual news items.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // ImageView for displaying the news image
        ImageView relativeImageView;
        // TextView for the title of the news item
        TextView relativeNewsTitle;
        // TextView for the description of the news item
        TextView relativeNewsDescription;

        /**
         * Constructor for initializing the views in the ViewHolder
         *
         * @param itemView The view of the individual row/item
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeImageView = itemView.findViewById(R.id.relativeNewsImage);
            relativeNewsTitle = itemView.findViewById(R.id.relativeNewsTitle);
            relativeNewsDescription = itemView.findViewById(R.id.relativeNewsDescription);
        }
    }
}
